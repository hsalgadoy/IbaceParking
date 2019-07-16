package co.com.ceiba.adn.parking.domain.model;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;
import co.com.ceiba.adn.parking.domain.exception.VehicleTypeException;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hsneider.salgado
 *
 */

@Getter
@Setter
@Component
public class Parking {
	private static final int TYPE_CAR = 2;
	private static final int TYPE_MOTORBYKE = 1;
	private static final String ERROR_VEHICLE_TYPE = "Tipo de Vehiculo Incompatible";
	private static final String ERROR_VEHICLE_RESTRICTION = "Acceso denegado: Los Vehiculos con placas que inicial con "
			+ "'A' Solo pueden ingresar los Domingos y Lunes";
	private static final String ERROR_MAX_CAPACITY = "Acceso denegado: El estacionamiento esta en su maxima capacidad";

	private static final String INITIAL_LETER_RESTRICTION = "A";
	private static final int MAXIMUN_CAPACITY_CARS = 20;
	private static final int MAXIMUN_CAPACITY_MOTORBYKE = 10;
	private static final int EXTRA_RATE_CYLINDER = 500;
	
	@Autowired
	VehicleTypeRepository typeRepository;

	public ParkingTicket validateEntryVehicle(ParkingTicket ticket, LocalDateTime inDate) {

		if (!(Objects.equals(ticket.getVehicle().getVehicleType(), TYPE_CAR)
				|| Objects.equals(ticket.getVehicle().getVehicleType(), TYPE_MOTORBYKE))) {
			throw new VehicleTypeException(ERROR_VEHICLE_TYPE);
		}
		if (authorizeVehicleIn(ticket) || !validateLicensePlate(ticket.getVehicle().getLicensePlate())) {
			ticket.setInTimeDate(inDate);
			ticket.setGrossTotal(0);
			return ticket;
		}
		throw new ParkingException(ERROR_VEHICLE_RESTRICTION);

	}

	public boolean validateLicensePlate(String licensePlate) {
		return licensePlate.toUpperCase().startsWith(INITIAL_LETER_RESTRICTION);
	}

	public boolean authorizeVehicleIn(ParkingTicket ticketParking) {

		return (validateLicensePlate(ticketParking.getVehicle().getLicensePlate())
				&& validateVehicleInDate(ticketParking));

	}

	public boolean validateVehicleInDate(ParkingTicket parkingTicket) {
		return (Objects.equals(localDateTimeToDate(parkingTicket.getInTimeDate()).get(Calendar.DAY_OF_WEEK),
				Calendar.SUNDAY)
				|| Objects.equals(localDateTimeToDate(parkingTicket.getInTimeDate()).get(Calendar.DAY_OF_WEEK),
						Calendar.MONDAY));

	}

	public static Calendar localDateTimeToDate(LocalDateTime localDateTime) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(localDateTime.getYear(), localDateTime.getMonthValue() - 1, localDateTime.getDayOfMonth(),
				localDateTime.getHour(), localDateTime.getMinute(), localDateTime.getSecond());
		return calendar;
	}

	public boolean validateParkinPlaces(long counterParkingPlaces, int vechileTypeId) {
		switch (vechileTypeId) {
		case TYPE_CAR:
			if (counterParkingPlaces >= MAXIMUN_CAPACITY_CARS) {
				throw new ParkingException(ERROR_MAX_CAPACITY);
			}
			break;
		case TYPE_MOTORBYKE:
			if (counterParkingPlaces >= MAXIMUN_CAPACITY_MOTORBYKE) {
				throw new ParkingException(ERROR_MAX_CAPACITY);
			}
			break;

		default:
			throw new VehicleTypeException(ERROR_VEHICLE_TYPE);
		}

		return true;
	}

	public ParkingTicket validateVehicelOut(Vehicle vehicle, ParkingTicket ticketParking) {
		ParkingTicket ticket = new ParkingTicket();
		LocalDateTime inDate;
		LocalDateTime outDate;
		outDate = LocalDateTime.now();
		inDate = ticketParking.getInTimeDate();
		ticket.setOutTimeDate(outDate);
		ticket.setGrossTotal(calculateTotalParking(inDate, outDate,
				typeRepository.findByVehicleTypeId(vehicle.getVehicleType()), vehicle));

		return ticket;
	}

	public long calculateTotalParking(LocalDateTime inDateTime, LocalDateTime outDateTime, VehicleType type,
			Vehicle vehicle) {
		long cost = 0;

		long serviceTime = TimeUnit.SECONDS.toHours(((long)outDateTime.getSecond() - (long)inDateTime.getSecond()));

		while (serviceTime >= 24) {
			cost += type.getDayValue();
			serviceTime -= 24;
			

		}
		cost += (serviceTime >= 9 ? type.getHourValue() : type.getHourValue() * serviceTime)
				+ ((type.getIdVehicleType() == TYPE_MOTORBYKE && vehicle.getDisplacement() >= EXTRA_RATE_CYLINDER)
						? type.getDisplacementCost()
						: 0);

		return cost;
	}

}
