package co.com.ceiba.parkingtest.test.unitaria.controllers;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
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
		
	}
	
	@Test
	public void entityToDomain() {
		ticketEntity = ticketEntitytDataBuilder.build();
		
		
	}

}
