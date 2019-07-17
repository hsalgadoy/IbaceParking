package co.com.ceiba.adn.parking.application.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.repository.TicketRepository;
import co.com.ceiba.adn.parking.domain.repository.VehicleRepository;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;
import lombok.Data;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Data
@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleTypeRepository typeRepository;
	
	
	public void registryIn(Vehicle vehicle) {
		Date inDateTime = new Date();
		ParkingTicket ticket = new ParkingTicket();
		ticket.setInTimeDate(inDateTime);
		ticket.setVehicle(vehicle);
		this.save(ticket);
	}
	
	
	/**
	 * Access to save ticket
	 * @param ticket object ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public ParkingTicket save(ParkingTicket ticket) {
		return ticketRepository.save(ticket);
	}
	/**
	 * get a list of all tickets at parking
	 * @return list of tickets
	 */
	public List<ParkingTicket> findAllTickets() {
		return ticketRepository.findAll();
	}
	
	public  ParkingTicket findByVehicle(Vehicle vehicle) {
		return ticketRepository.findByVehicle(vehicle);
	}
	public TicketService(TicketRepository ticketRepository, VehicleRepository vehicleRepository,
			VehicleTypeRepository typeRepository) {
		super();
		this.ticketRepository = ticketRepository;
		this.vehicleRepository = vehicleRepository;
		this.typeRepository = typeRepository;
	}
}
