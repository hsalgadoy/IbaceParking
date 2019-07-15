package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.ParkingTicketRepositoryJPA;

@Repository
@Transactional
public class TicketImplementation {
	
	@Autowired
	private ParkingTicketRepositoryJPA ticketRepositoryJPA;
	
	public ParkingTicketEntity getTicket(int ticketNumber) {
		return ticketRepositoryJPA.findTicketNumber(ticketNumber);
	}

}
