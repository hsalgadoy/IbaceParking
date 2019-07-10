package co.com.ceiba.adn.parking.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.TicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.TicketRepositoryJPA;
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
	private TicketRepositoryJPA ticketRepository;
	/**
	 * Access to save ticket
	 * @param ticket objet ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public TicketEntity saveTicket(TicketEntity ticket) {
		return ticketRepository.save(ticket);
	}
	/**
	 * get a list of all tickets at parking
	 * @return list of tickets
	 */
	public List<TicketEntity> findAllTickets() {
		return ticketRepository.findAllTickets();
	}
}
