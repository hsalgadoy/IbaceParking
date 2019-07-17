package co.com.ceiba.adn.parking.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.repository.TicketRepository;
import co.com.ceiba.adn.parking.domain.repository.VehicleRepository;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Service
public class TicketService {

	private final TicketRepository ticketRepository;
	private final VehicleRepository vehicleRepository;
	private final VehicleTypeRepository vehicleTypeRepository;

	public TicketService(final TicketRepository ticketRepository, final VehicleRepository vehicleRepository,
			final VehicleTypeRepository vehicleTypeRepository) {
		this.ticketRepository = ticketRepository;
		this.vehicleTypeRepository = vehicleTypeRepository;
		this.vehicleRepository = vehicleRepository;
	}

	public void registryIn(Vehicle vehicle) {
		Date inDateTime = new Date();
		ParkingTicket ticket = new ParkingTicket();
		ticket.setInTimeDate(inDateTime);
		ticket.setVehicle(vehicle);
		this.save(ticket);
	}

	/**
	 * Access to save ticket
	 * 
	 * @param ticket object ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public void save(ParkingTicket ticket) {
		ticketRepository.save(ticket);
	}

	/**
	 * get a list of all tickets at parking
	 * 
	 * @return list of tickets
	 */
	public List<ParkingTicket> findAllTickets() {
		return ticketRepository.findAll();
	}

}
