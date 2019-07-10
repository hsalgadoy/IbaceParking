package co.com.ceiba.adn.parking.application.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.parking.domain.entity.Parking;
import com.ceiba.adn.parking.domain.entity.Ticket;
import com.ceiba.adn.parking.domain.entity.Vehicle;
import com.ceiba.adn.parking.domain.repository.TicketRepository;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Service
public class ParkingService {

	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private Parking parking;
	
	public Ticket vehicleRegistration(Vehicle vehicle, LocalDateTime entryDate) {	
		return ticketRepository.save(parking.vehicleCheckIn(vehicle, entryDate));
	}
	/**
	 * calculate the price of the parking time of a vehicle
	 * @param ticketId the id's ticket to be calculated
	 * @return return the price of parking time
	 */
	public float calculatePrice(int ticketId) {
		Ticket ticket = ticketRepository.findTicketById(ticketId);
		ticket.setDepartureDate(LocalDateTime.now());
		return parking.calculatePrice(ticket);
	}
	/**
	 * give a get out or a check out to a vehicle
	 * @param ticketId the id of ticket to be checkout
	 */
	public void checkOutVehicle(int ticketId) {
		Ticket ticket = ticketRepository.findTicketById(ticketId);
		ticket.setPayment(true);
		ticketRepository.save(ticket);
	}
	
}
