package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import java.util.ArrayList;
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
	
	public ParkingTicket getTicket(int ticketNumber) {
		return ParkingTicketMapper.toDomain(ticketRepositoryJPA.findByTicketNumber(ticketNumber));
	}

	@Override
	public List<ParkingTicket> findAll() {
		List<ParkingTicket> tickets = new ArrayList<ParkingTicket>();
		for(ParkingTicketEntity ticketEntoty:ticketRepositoryJPA.findAll()) {
			tickets.add(ParkingTicketMapper.toDomain(ticketEntoty));
		}
		return tickets;
		
	}

	@Override
	public ParkingTicket findByTicketNumber(int ticketnumber) {
		return ParkingTicketMapper.toDomain(ticketRepositoryJPA.findByTicketNumber(ticketnumber));
		
	}

	@Override
	public ParkingTicket save(ParkingTicket parkingTicket) {
		return ParkingTicketMapper.toDomain(ticketRepositoryJPA.save(ParkingTicketMapper.toEntity(parkingTicket)));
	}

	

}
