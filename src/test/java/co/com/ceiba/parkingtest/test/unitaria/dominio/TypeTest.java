package co.com.ceiba.parkingtest.test.unitaria.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.TypeTestDataBuilder;

public class TypeTest {

	public static final int TYPE_ID = 2;
	public static final double COST_BY_DAY = 8000L;
	public static final double COST_BY_HOUR = 1000L;
	public static final double EXTRA_COST=0;
	private static final int PARKING_PLACES = 20;
	private static final int AVIABLE_PLACES = 20;
	
	@Test
	public void seup() {
		//arrange
		
		TypeTestDataBuilder typeBuilder = new TypeTestDataBuilder();
		
		//act
		
		VehicleType type = typeBuilder.withIdVehicleType(TYPE_ID).withDayValue(COST_BY_DAY).withHourValue(COST_BY_HOUR)
				.withDisplacementCost(EXTRA_COST).withParkingSpace(PARKING_PLACES).withSpaceAviable(AVIABLE_PLACES).build();
		
		
		//assert
		
		assertNotNull(type);
		assertEquals(type.getIdVehicleType(), TYPE_ID);
		assertEquals(type.getDayValue(), COST_BY_DAY,0.01);
		assertEquals(type.getHourValue(), COST_BY_HOUR,0.01);
		assertEquals(type.getDisplacementCost(), EXTRA_COST,0.01);
		assertEquals(type.getParkingSpace(), PARKING_PLACES);
		assertEquals(type.getSpaceAviable(), AVIABLE_PLACES);
		
		
		
		
		
	}
	
}
