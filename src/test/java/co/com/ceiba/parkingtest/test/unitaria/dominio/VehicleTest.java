package co.com.ceiba.parkingtest.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;

public class VehicleTest {

	
	private static final String V_LISENCEPLATE = "AGS12A";
	private static final long V_DISPLASEMENT = 200;
	private static final int V_TYPE  = 1;
	
	private Vehicle vehicle;
	
	@Before
	public void setUp() {
		//Arrange
		VehicleDataBuilder vehicleDataBuilder = new VehicleDataBuilder().withDisplacement(V_DISPLASEMENT).withVehicleType(V_TYPE)
				.withLicensePlate(V_LISENCEPLATE);
		
		// act
		vehicle=vehicleDataBuilder.build();
	}
	
	@Test
	public void test() throws ParseException {
		//Assert
		
		assertNotNull(vehicle);
		assertEquals(vehicle.getLicensePlate(), V_LISENCEPLATE);
		assertEquals(vehicle.getDisplacement(), V_DISPLASEMENT,0.01);
		assertEquals(vehicle.getVehicleType(), V_TYPE);
		
	}

}
