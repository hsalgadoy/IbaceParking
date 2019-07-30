package co.com.ceiba.adn.parking.application.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;
import co.com.ceiba.adn.parking.domain.exception.VehicleTypeException;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleRepository;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.TicketImplementation;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Service
public class TicketService {

	
	private static final String ERROR_MAX_CAPACITY = "Acceso denegado: El estacionamiento esta en su maxima capacidad";
	private static final String ERROR_VEHICLE_TYPE = "Tipo de Vehiculo Incompatible";
	private static final String INITIAL_LETER_RESTRICTION = "A";
	
	@Autowired
	private  TicketImplementation ticketImplementation;
	@Autowired
	private  VehicleRepository vehicleRepository;
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	
	public ParkingTicket registryIn(Vehicle vehicle) {
		Date inDateTime = new Date();
		if (vehicleRepository.countByLicensePlate(vehicle.getLicensePlate()) >= 1) {
			vehicle = vehicleRepository.findVehicleByLicensePlate(vehicle.getLicensePlate());
		} else {
			vehicleRepository.save(vehicle);
		}
		ParkingTicket ticket = new ParkingTicket();
		ticket.setInTimeDate(inDateTime);
		if(this.validateParkinPlaces(vehicle.getVehicleType()) && authorizeVehicleIn(ticket,vehicle)) {
			ticket.setVehicle(vehicle);
			return ticketImplementation.save(ticket);
		}else {
			throw new ParkingException("No se pudo Ingresar el vehiculo");
		}
		
	}

	public ParkingTicket registryOut(String lisencePlate) {
		Vehicle vehicle = vehicleRepository.findVehicleByLicensePlate(lisencePlate);
		
		ParkingTicket ticket = findByVehicle(vehicle);
		if (ticket != null) {
			ticket.setOutTimeDate(new Date());
			ticket.setGrossTotal(calculateTotalParking(ticket.getInTimeDate(), ticket.getOutTimeDate(),
					vehicleTypeRepository.findByVehicleTypeId(vehicle.getVehicleType())));
			return ticket;
		}
		return ticket;
	}

	public ParkingTicket findByVehicle(Vehicle vehicle) {
		List<ParkingTicket> tickets = ticketImplementation.findAll();
		for (ParkingTicket ticket : tickets) {
			if (vehicle.getLicensePlate().equalsIgnoreCase(ticket.getVehicle().getLicensePlate())) {
				return ticket;
			}
		}
		return null;

	}

	public long calculateTotalParking(Date inDateTime, Date outDateTime, VehicleType type) {
		long cost = 0;

		long serviceTime = TimeUnit.MILLISECONDS.toHours((outDateTime.getTime() - inDateTime.getTime()));

		while (serviceTime >= 24) {
			cost += type.getDayValue();
			serviceTime -= 24;

		}
		cost += (serviceTime >= 9 ? type.getHourValue() : type.getHourValue() * serviceTime)
				+ type.getDisplacementCost();
		return cost;
	}

	public boolean validateParkinPlaces(int vechileTypeId) {
		switch (vechileTypeId) {
		case 1:
		case 2:
			if (vehicleTypeRepository.findByVehicleTypeId(vechileTypeId).getSpaceAviable()<1) {
				throw new ParkingException(ERROR_MAX_CAPACITY);
			}
			break;

		default:
			throw new VehicleTypeException(ERROR_VEHICLE_TYPE);
		}

		return true;
	}
	
	/**
	 * Access to save ticket
	 * 
	 * @param ticket object ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public ParkingTicket save(ParkingTicket ticket) {
		return ticketImplementation.save(ticket);
	}

	/**
	 * get a list of all tickets at parking
	 * 
	 * @return list of tickets
	 */
	public List<ParkingTicket> findAllTickets() {
		return ticketImplementation.findAll();
		
	}
	
	
	public boolean validateLicensePlate(String licensePlate) {
		
		return licensePlate.toUpperCase().startsWith(INITIAL_LETER_RESTRICTION);
	}

	public boolean authorizeVehicleIn(ParkingTicket ticketParking, Vehicle vehicle) {

		return ((validateLicensePlate(vehicle.getLicensePlate())
				&& validateVehicleInDate(ticketParking))||!validateLicensePlate(vehicle.getLicensePlate()));

	}

	public boolean validateVehicleInDate(ParkingTicket parkingTicket) {
	
		Calendar calInt = Calendar.getInstance();
		Calendar calOut = Calendar.getInstance();
		calInt.setTime(parkingTicket.getInTimeDate());
		calOut.setTime(parkingTicket.getInTimeDate());
		return (Objects.equals((calInt.get(Calendar.DAY_OF_WEEK)),Calendar.SUNDAY)
				|| Objects.equals((calInt.get(Calendar.DAY_OF_WEEK)),Calendar.MONDAY));

	}

}
