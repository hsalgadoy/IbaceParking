package co.com.ceiba.parkingtest.test.unitaria.controllers;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;
import co.com.ceiba.adn.parking.domain.model.Parking;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.ParkingTicketDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;

public class ParkingTest {

	private static final String LISENSE_PLATE = " PND02E";
	private static final String RSTRICTION_PLATE = "ABC345";
	private static final int TYPE_CAR = 2;
	private static final int TYPE_MOTORBYKE = 1;
	private static final int OTHER_TYPE = 0;
	private static final String ERROR_VEHICLE_RESTRICTION = "Acceso denegado: Los Vehiculos con placas que inicial con "
			+ "'A' Solo pueden ingresar los Domingos y Lunes";
	private static final String IN_DATE = "10/06/2019 07:00:00";
	private static final String OUT_DATE = "10/06/2019 20:00:00";
	private static final String RESTRICTITION_DATE = "07/07/2019 20:00:00";
	private static final String RESTRICTITION_DATE_TWO = "08/07/2019 20:00:00";

	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm");

	Parking parkling = new Parking();
	ParkingTicket ticket;
	ParkingTicket ticketArestriction;
	Vehicle vehicle;
	Vehicle vehiclePlateRestrictiton;
	@Before
	public void setUp() throws Exception {
		// Arrange
		VehicleDataBuilder vehicleBuilder = new VehicleDataBuilder().withLicensePlate(LISENSE_PLATE)
				.withVehicleType(TYPE_MOTORBYKE).withVehicleType(TYPE_MOTORBYKE);
		vehicle = vehicleBuilder.build();
		ParkingTicketDataBuilder parkingTicketBuilder = new ParkingTicketDataBuilder().withVehicle(vehicle)
				.withOutTimeDate(formato.parse(IN_DATE));
		// act
		ticket = parkingTicketBuilder.build();

	}

	@Test
	public void testEntryVehicle() throws JsonProcessingException, ParseException {
		assertEquals(parkling.validateEntryVehicle(ticket, formato.parse(IN_DATE)), ticket);
		
	}
	
	@Before
	public void setUp2() throws Exception {
		// Arrange
		VehicleDataBuilder vehicleBuilder = new VehicleDataBuilder().withLicensePlate(LISENSE_PLATE)
				.withVehicleType(TYPE_CAR);
		vehicle = vehicleBuilder.build();
		ParkingTicketDataBuilder parkingTicketBuilder = new ParkingTicketDataBuilder().withVehicle(vehicle)
				.withOutTimeDate(formato.parse(IN_DATE));
		// act
		ticket = parkingTicketBuilder.build();

	}

	@Test
	public void testEntryVehicle2() throws JsonProcessingException, ParseException {
		assertEquals(parkling.validateEntryVehicle(ticket, formato.parse(IN_DATE)), ticket);
	}
	
	
	@Before
	public void setUp3() throws Exception {
		// Arrange
		VehicleDataBuilder vehicleBuilder = new VehicleDataBuilder().withLicensePlate(LISENSE_PLATE)
				.withVehicleType(TYPE_CAR);
		vehicle = vehicleBuilder.build();
		ParkingTicketDataBuilder parkingTicketBuilder = new ParkingTicketDataBuilder().withVehicle(vehicle)
				.withOutTimeDate(formato.parse(RESTRICTITION_DATE));
		// act
		ticket = parkingTicketBuilder.build();

	}

	@Test
	public void testEntryVehicle3() throws JsonProcessingException, ParseException {
		assertEquals(parkling.validateVehicleInDate(ticket), false);
	}
	
	
	
	@Before
	public void setUp4() throws Exception {
		// Arrange
		VehicleDataBuilder vehicleBuilder = new VehicleDataBuilder().withLicensePlate(LISENSE_PLATE)
				.withVehicleType(TYPE_CAR);
		vehicle = vehicleBuilder.build();
		ParkingTicketDataBuilder parkingTicketBuilder = new ParkingTicketDataBuilder().withVehicle(vehicle)
				.withOutTimeDate(formato.parse(RESTRICTITION_DATE_TWO));
		// act
		ticket = parkingTicketBuilder.build();

	}

	@Test
	public void testEntryVehicle4() throws JsonProcessingException, ParseException {
		assertEquals(parkling.validateVehicleInDate(ticket), false);
	}
	
}
