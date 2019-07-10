package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.TicketEntity;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface TicketRepositoryJPA extends JpaRepository<TicketEntity, Integer>{
	public TicketEntity save(TicketEntity ticket);

	public List<TicketEntity> findAllTickets();

	public TicketEntity findTicketById(int ticketId);
}
