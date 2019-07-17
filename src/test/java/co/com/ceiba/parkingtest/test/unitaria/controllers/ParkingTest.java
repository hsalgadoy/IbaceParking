package co.com.ceiba.parkingtest.test.unitaria.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;

public class ParkingTest {

//	private static final int VEHICLE_ID = 1;
//	private static final String VEHICLE_LICENSE = "RQR45A";
	private Vehicle vehicle;

//	private ObjectWriter objectWriter;
//
//	@Autowired	
//	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
	
		vehicle = new VehicleDataBuilder().build();
	}

	@Test
	public void test() throws JsonProcessingException {
		
		assertNotNull(vehicle);
		
	}
}
