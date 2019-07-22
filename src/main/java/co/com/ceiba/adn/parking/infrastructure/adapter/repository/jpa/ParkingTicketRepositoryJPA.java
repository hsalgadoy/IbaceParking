package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface ParkingTicketRepositoryJPA extends JpaRepository<ParkingTicketEntity, Integer> {

	public List<ParkingTicketEntity> findAll();

	ParkingTicketEntity save(ParkingTicketEntity parkingTicket);

	public ParkingTicketEntity findByTicketNumber(int ticketNumber);

}
