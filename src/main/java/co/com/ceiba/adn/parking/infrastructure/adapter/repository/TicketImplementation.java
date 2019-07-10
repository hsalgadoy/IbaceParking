package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.TicketRepositoryJPA;

@Repository
@Transactional
public class TicketImplementation {
	
	@Autowired
	private TicketRepositoryJPA ticketRepositoryJPA;
	
	

}
