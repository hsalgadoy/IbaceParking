package co.com.ceiba.adn.parking.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.adn.parking.domain.entity.Ticket;
import com.ceiba.adn.parking.domain.repository.TicketRepository;

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
	 * @param ticket objet ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	/**
	 * get a list of all tickets at parking
	 * @return list of tickets
	 */
	public List<Ticket> findAllTickets() {
		return ticketRepository.findAllTickets();
	}
}
