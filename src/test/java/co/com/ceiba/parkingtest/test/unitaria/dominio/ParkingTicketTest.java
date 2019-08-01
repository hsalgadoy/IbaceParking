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

	private static final Vehicle VEHICLE_T = new VehicleDataBuilder().build();
	private static final double TOTAL_TICKET = 6000;
	public final SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
	private ParkingTicket parkingTicket;

	@Autowired
	private TicketService service = new TicketService();

	@Before
	public void setUp() throws ParseException {

	}

	// test for data builder ParkingTicket
	@Test
	public void testbuildtciket() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String OUT_DATE = "10-06-2019 20:00:00";
		
		// Arrange

		ParkingTicketDataBuilder parkingTicketDataBuilder = new ParkingTicketDataBuilder().withTicketNumber(TICKET_NUM)
				.withInTimeDate(formato.parse(IN_DATE)).withOutTimeDate(formato.parse(OUT_DATE)).withVehicle(VEHICLE_T)
				.withGrossTotal(TOTAL_TICKET);
		// Act
		parkingTicket = parkingTicketDataBuilder.build();
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
		String IN_DATE = "10-06-2019 07:00:00";
		String SUNDAY_DATE = "28-07-2019 20:00:00";
		
		VehicleType type_moto = new VehicleTypeDataBuilder().build();

		assertEquals(76000,
				service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(SUNDAY_DATE), type_moto), 0.01);

	}

	@Test
	public void testmondayprice() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String MONDAY_DATE = "21-07-2019 20:00:00";
		
		VehicleType type_moto = new VehicleTypeDataBuilder().build();

		assertEquals(48000,
				service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(MONDAY_DATE), type_moto), 0.01);

	}

	@Test
	public void testnormaprice() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String NORMAL_DATE = "22-07-2019 20:00:00";
		
		VehicleType type_moto = new VehicleTypeDataBuilder().build();

		assertEquals(52000,
				service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(NORMAL_DATE), type_moto), 0.01);

	}

	@Test
	public void testService() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String OUT_DATE = "10-06-2019 20:00:00";
		
		VehicleType type_moto = new VehicleTypeDataBuilder().build();

		assertEquals(4000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(OUT_DATE), type_moto),0.01);

	}

	@Test
	public void testsundaypricecar() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String SUNDAY_DATE = "28-07-2019 20:00:00";
		
		VehicleType type_car = new VehicleTypeDataBuilder().withDayValue(8000).withDisplacementCost(0)
				.withIdVehicleType(1000).withIdVehicleType(2).withParkingSpace(20).withSpaceAviable(20).build();
		
		assertEquals(152000,
				service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(SUNDAY_DATE), type_car), 0.01);

	}

	@Test
	public void testmondaypricecar() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String MONDAY_DATE = "21-07-2019 20:00:00";
		
		VehicleType type_car = new VehicleTypeDataBuilder().withDayValue(8000).withDisplacementCost(0)
				.withIdVehicleType(1000).withIdVehicleType(2).withParkingSpace(20).withSpaceAviable(20).build();
		
		assertEquals(96000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(MONDAY_DATE), type_car),
				0.01);

	}

	@Test
	public void testnormapricecar() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String NORMAL_DATE = "22-07-2019 20:00:00";
		
		VehicleType type_car = new VehicleTypeDataBuilder().withDayValue(8000).withDisplacementCost(0)
				.withIdVehicleType(1000).withIdVehicleType(2).withParkingSpace(20).withSpaceAviable(20).build();
		
		assertEquals(104000,
				service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(NORMAL_DATE), type_car), 0.01);

	}

	@Test
	public void testServicecar() throws ParseException {
		String IN_DATE = "10-06-2019 07:00:00";
		String OUT_DATE = "10-06-2019 20:00:00";
		
		VehicleType type_moto = new VehicleTypeDataBuilder().build();
		
		assertEquals(4000, service.calculateTotalParking(formato.parse(IN_DATE), formato.parse(OUT_DATE), type_moto),
				0.01);

	}

	// testForEntryRestrictionMondyaSunday
	@Test
	public void testSundayIn() throws ParseException {
		String OUT_DATE = "10-06-2019 20:00:00";
		String SUNDAY_DATE = "28-07-2019 20:00:00";
		

		ParkingTicketDataBuilder parkingTicketDataBuilder = new ParkingTicketDataBuilder().withTicketNumber(TICKET_NUM)
				.withInTimeDate(formato.parse(SUNDAY_DATE)).withOutTimeDate(formato.parse(OUT_DATE))
				.withVehicle(VEHICLE_T).withGrossTotal(TOTAL_TICKET);

		parkingTicket = parkingTicketDataBuilder.build();

		assertEquals(service.validateVehicleInDate(parkingTicket), true);
	}

	@Test
	public void testMondayIn() throws ParseException {
		String OUT_DATE = "10-06-2019 20:00:00";
		String MONDAY_DATE = "21-07-2019 20:00:00";
		

		ParkingTicketDataBuilder parkingTicketDataBuilder = new ParkingTicketDataBuilder().withTicketNumber(TICKET_NUM)
				.withInTimeDate(formato.parse(MONDAY_DATE)).withOutTimeDate(formato.parse(OUT_DATE))
				.withVehicle(VEHICLE_T).withGrossTotal(TOTAL_TICKET);

		parkingTicket = parkingTicketDataBuilder.build();

		assertEquals(service.validateVehicleInDate(parkingTicket), true);
	}

	public void testNormaDayIn() throws ParseException {
		String OUT_DATE = "10-06-2019 20:00:00";
		String NORMAL_DATE = "22-07-2019 20:00:00";
		
		ParkingTicketDataBuilder parkingTicketDataBuilder = new ParkingTicketDataBuilder().withTicketNumber(TICKET_NUM)
				.withInTimeDate(formato.parse(NORMAL_DATE)).withOutTimeDate(formato.parse(OUT_DATE))
				.withVehicle(VEHICLE_T).withGrossTotal(TOTAL_TICKET);

		parkingTicket = parkingTicketDataBuilder.build();

		assertEquals(service.validateVehicleInDate(parkingTicket), false);
	}

}
