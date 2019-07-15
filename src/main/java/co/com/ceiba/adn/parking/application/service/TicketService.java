package co.com.ceiba.adn.parking.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.repository.TicketRepository;
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
	/**
	 * Access to save ticket
	 * @param ticket object ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public ParkingTicket saveTicket(ParkingTicket ticket) {
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
}