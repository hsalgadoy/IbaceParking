package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.repository.TicketRepository;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.ParkingTicketMapper;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.ParkingTicketRepositoryJPA;

@Repository
@Transactional
public class TicketImplementation implements TicketRepository{
	
	@Autowired
	private ParkingTicketRepositoryJPA ticketRepositoryJPA;
	
	public ParkingTicketEntity getTicket(int ticketNumber) {
		return ticketRepositoryJPA.findByTicketNumber(ticketNumber);
	}

	@Override
	public List<ParkingTicket> findAll() {
		ticketRepositoryJPA.findAll();
		return null;
	}

	@Override
	public ParkingTicket findByTicketNumber(int ticketnumber) {
		ticketRepositoryJPA.findById(ticketnumber);
		return null;
	}

	@Override
	public void save(ParkingTicket parkingTicket) {
		ticketRepositoryJPA.save(ParkingTicketMapper.toEntity(parkingTicket));
	}

	

}
