package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface ParkingTicketRepositoryJPA extends JpaRepository<ParkingTicketEntity, Long> {
	public <S> S save(ParkingTicketEntity parkingTicketEntity);

	public List<ParkingTicketEntity> findAllTickets();

	public ParkingTicketEntity findTicketNumber(long ticketNumber);

}
