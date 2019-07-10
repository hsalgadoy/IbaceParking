package co.com.ceiba.adn.parking.application.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.Parking;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.TicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.TicketRepositoryJPA;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Service
public class ParkingService {

	@Autowired
	private TicketRepositoryJPA ticketRepository;
	
	@Autowired
	private Parking parking;
	
	public TicketEntity vehicleRegistration(Vehicle vehicle, LocalDateTime entryDate) {	
		return ticketRepository.save(parking.vehicleCheckIn(vehicle, entryDate));
	}
	/**
	 * calculate the price of the parking time of a vehicle
	 * @param ticketId the id's ticket to be calculated
	 * @return return the price of parking time
	 */
	public float calculatePrice(int ticketId) {
		TicketEntity ticket = ticketRepository.findTicketById(ticketId);
		ticket.setDepartureDate(LocalDateTime.now());
		return parking.calculatePrice(ticket);
	}
	/**
	 * give a get out or a check out to a vehicle
	 * @param ticketId the id of ticket to be checkout
	 */
	public void checkOutVehicle(int ticketId) {
		TicketEntity ticket = ticketRepository.findTicketById(ticketId);
		ticket.setPayment(true);
		ticketRepository.save(ticket);
	}
	
}
