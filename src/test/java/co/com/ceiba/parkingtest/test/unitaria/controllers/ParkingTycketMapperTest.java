package co.com.ceiba.parkingtest.test.unitaria.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.ParkingTicketMapper;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.ParkingTicketDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.ParkingTicketEntityDataBuilder;

public class ParkingTycketMapperTest {
	
	ParkingTicketEntity ticketEntity;
	ParkingTicket ticket;
	
	ParkingTicketDataBuilder ticketDataBuilder;
	ParkingTicketEntityDataBuilder ticketEntitytDataBuilder;
	
	@Before
	public void setUp() throws ParseException {
		
		ticketDataBuilder = new ParkingTicketDataBuilder();
		ticketEntitytDataBuilder = new ParkingTicketEntityDataBuilder();
	}
	
	@Test
	public void domationToEntity() {
		
		ticket = ticketDataBuilder.build();
		ticketEntity= ParkingTicketMapper.toEntity(ticket);
		
		assertEquals(ticket.getGrossTotal(), ticketEntity.getGrossTotal(),0.01);
		assertEquals(ticket.getInTimeDate(), ticketEntity.getInTimeDate());
		assertEquals(ticket.getOutTimeDate(), ticketEntity.getOutTimeDate());
		assertEquals(ticket.getTicketNumber(), ticketEntity.getTicketNumber(),0.01);
		
	}
	
	@Test
	public void entityToDomain() {
		ticketEntity = ticketEntitytDataBuilder.build();
		ticket = ParkingTicketMapper.toDomain(ticketEntity);
		
		
		assertEquals(ticket.getGrossTotal(), ticketEntity.getGrossTotal(),0.01);
		assertEquals(ticket.getInTimeDate(), ticketEntity.getInTimeDate());
		assertEquals(ticket.getOutTimeDate(), ticketEntity.getOutTimeDate());
		assertEquals(ticket.getTicketNumber(), ticketEntity.getTicketNumber(),0.01);
		
	}

}
