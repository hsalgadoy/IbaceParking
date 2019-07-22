package co.com.ceiba.parkingtest.test.unitaria;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.adn.parking.application.service.TicketService;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.ParkingTicketDataBuilder;

class TicketUnitTest {
	private static final String IN_DATE_MONDAY = "21/07/2019 07:00:00";
	private static final String OUT_DATE_SUNDAY = "22/07/2019 20:00:00";
	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm");
	@Autowired 
	private  TicketService service;
	ParkingTicket ticket;
	ParkingTicketDataBuilder ticketBuilder;
	@Before
	public void setUp() throws ParseException{
		ticketBuilder = new ParkingTicketDataBuilder();
		ticket = ticketBuilder.build();
		assertEquals(service.validateVehicleInDate(ticket), true);
	}
	
	@Test
	void testSunday() throws ParseException {
		ticket.setInTimeDate(formato.parse(OUT_DATE_SUNDAY));
		
	}
	
	@Test
	void testMonday() throws ParseException {
		ticket.setInTimeDate(formato.parse(IN_DATE_MONDAY));
		assertEquals(service.validateVehicleInDate(ticket), true);
	}

}
