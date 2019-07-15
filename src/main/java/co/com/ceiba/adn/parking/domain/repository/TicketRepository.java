package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;

public interface TicketRepository {

	List<ParkingTicket> findAll();
	ParkingTicket findByTicketNumber();
	ParkingTicket save(ParkingTicket parkingTicket);
	ParkingTicket findByVehicle(Vehicle vehicle);
	
	
}
