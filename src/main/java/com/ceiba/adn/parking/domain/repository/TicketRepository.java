package com.ceiba.adn.parking.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.parking.domain.entity.Ticket;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{
	public Ticket save(Ticket ticket);

	public List<Ticket> findAllTickets();

	public Ticket findTicketById(int ticketId);
}
