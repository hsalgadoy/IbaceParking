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
	private static final String SUNDAY_DATE = "28/07/2019 20:00:00";
	private static final String MONDAY_DATE = "21/07/2019 20:00:00";
	private static final String NORMAL_DATE = "22/07/2019 20:00:00";
	private static final Vehicle VEHICLE_T = new VehicleDataBuilder().build();
	private static final VehicleType VEHICLE_TYPE = new VehicleTypeDataBuilder().build();
	private static final VehicleType VEHICLE_TYPE_CAR = new VehicleTypeDataBuilder().withDayValue(8000)
			.withDisplacementCost(0).withIdVehicleType(1000).withIdVehicleType(2).withParkingSpace(20).withSpaceAviable(20).build();
	private static final double TOTAL_TICKET = 6000;
	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
	private ParkingTicket parkingTicket;

	@Autowired
	private TicketService service = new TicketService();

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
	public void testsundayprice() throws ParseException {

		// coregir con valor
		assertEquals(76000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(SUNDAY_DATE), VEHICLE_TYPE),
				0.01);

	}
	
	@Test
	public void testmondayprice() throws ParseException {

		// coregir con valor
		assertEquals(48000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(MONDAY_DATE), VEHICLE_TYPE),
				0.01);

	}
	
	@Test
	public void testnormaprice() throws ParseException {

		// coregir con valor
		assertEquals(52000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(NORMAL_DATE), VEHICLE_TYPE),
				0.01);

	}
	@Test
	public void testService() throws ParseException {

		// coregir con valor
		assertEquals(4000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(OUT_DATE), VEHICLE_TYPE),
				0.01);

	}
	
	@Test
	public void testsundaypricecar() throws ParseException {

		// coregir con valor
		assertEquals(152000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(SUNDAY_DATE), VEHICLE_TYPE_CAR),
				0.01);

	}
	
	@Test
	public void testmondaypricecar() throws ParseException {

		// coregir con valor
		assertEquals(96000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(MONDAY_DATE), VEHICLE_TYPE_CAR),
				0.01);

	}
	
	@Test
	public void testnormapricecar() throws ParseException {

		// coregir con valor
		assertEquals(104000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(NORMAL_DATE), VEHICLE_TYPE_CAR),
				0.01);

	}
	@Test
	public void testServicecar() throws ParseException {

		// coregir con valor
		assertEquals(4000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(OUT_DATE), VEHICLE_TYPE),
				0.01);

	}
	
	

	@Test
	public void testSundayIn() throws ParseException {

		// coregir que de valor
		parkingTicket.setInTimeDate(formato.parse(SUNDAY_DATE));
		assertEquals(service.validateVehicleInDate(parkingTicket), true);
	}

	@Test
	public void testMondayIn() throws ParseException {

		// coregir que de valor
		parkingTicket.setInTimeDate(formato.parse(MONDAY_DATE));
		assertEquals(service.validateVehicleInDate(parkingTicket), true);
	}

	public void testNormaDayIn() throws ParseException {

		// coregir que de valor
		parkingTicket.setInTimeDate(formato.parse(NORMAL_DATE));
		assertEquals(service.validateVehicleInDate(parkingTicket), false);
	}

}
