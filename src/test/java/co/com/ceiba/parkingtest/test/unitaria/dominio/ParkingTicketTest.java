package co.com.ceiba.parkingtest.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.adn.parking.application.service.TicketService;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.ParkingTicketDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleTypeDataBuilder;

public class ParkingTicketTest {

	private static final int TICKET_NUM = 1;
	private static final String IN_DATE = "10/06/2019 07:00:00";
	private static final String OUT_DATE = "10/06/2019 20:00:00";
	private static final Vehicle VEHICLE_T = new VehicleDataBuilder().build();
	private static final VehicleType VEHICLE_TYPE = new VehicleTypeDataBuilder().build();
	private static final double TOTAL_TICKET = 6000;

	private ParkingTicket parkingTicket;
	
	@Autowired
	private TicketService service = new  TicketService();
	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");

	@Before
	public void setUp() throws ParseException {
		// Arrange   
		
		ParkingTicketDataBuilder parkingTicketDataBuilder = new ParkingTicketDataBuilder().withTicketNumber(TICKET_NUM)
				.withInTimeDate(formato.parse(IN_DATE)).withOutTimeDate(formato.parse(OUT_DATE)).withVehicle(VEHICLE_T)
				.withGrossTotal(TOTAL_TICKET);
		// Act
		parkingTicket = parkingTicketDataBuilder.build();

	}

	@Test
	public void test() throws ParseException {
		// Assert
		assertNotNull(parkingTicket);
		assertEquals(parkingTicket.getTicketNumber(), TICKET_NUM);
		assertEquals(parkingTicket.getInTimeDate(), formato.parse(IN_DATE));
		assertEquals(parkingTicket.getOutTimeDate(), formato.parse(OUT_DATE));
		assertEquals(parkingTicket.getVehicle(), VEHICLE_T);
		assertEquals(parkingTicket.getGrossTotal(), TOTAL_TICKET, 0.01);

	}
	
	@Test
	public void testService() throws ParseException {
		service.calculateTotalParking(formato.parse(IN_DATE),formato.parse(OUT_DATE),VEHICLE_TYPE);
		
	}

}
