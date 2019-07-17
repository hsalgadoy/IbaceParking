package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;

public interface TicketRepository {

	List<ParkingTicket> findAll();
	ParkingTicket findByTicketNumber(int ticketnumber);
	void save(ParkingTicket parkingTicket);

	
	
}
