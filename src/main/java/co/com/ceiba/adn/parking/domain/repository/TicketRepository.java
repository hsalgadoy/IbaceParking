package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
@Repository
public interface TicketRepository {

	List<ParkingTicket> findAll();
	ParkingTicket findByTicketNumber(int ticketnumber);
	ParkingTicket save(ParkingTicket parkingTicket);

	
	
}
