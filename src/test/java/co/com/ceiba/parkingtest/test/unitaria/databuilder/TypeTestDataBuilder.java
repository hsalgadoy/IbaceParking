package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import java.util.List;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.model.VehicleType;

public class TypeTestDataBuilder {

	private static final int TYPE_ID = 1;
	private static final long COST_BY_HOUR = 500;
	private static final long COST_BY_DAY = 4000;
	private static final long EXTRA_COST = 2000;
	private static final int PARKING_PLACES = 10;
	private static final int AVIABLE_PLACES = 10;

	private int idVehicleType;

	private double hourValue;

	private double dayValue;

	private int parkingSpace;

	private int spaceAviable;

	private double DisplacementCost;

	
	public TypeTestDataBuilder() {
		
		this.dayValue = COST_BY_DAY;
		this.hourValue = COST_BY_HOUR;
		this.DisplacementCost = EXTRA_COST;
		this.idVehicleType = TYPE_ID;
		this.parkingSpace = PARKING_PLACES;
		this.spaceAviable= AVIABLE_PLACES;

	}


	

	public TypeTestDataBuilder withIdVehicleType(int idVehicleType) {
		this.idVehicleType = idVehicleType;
		return this;
	}


	public TypeTestDataBuilder withHourValue(double hourValue) {
		this.hourValue = hourValue;
		return this;
	}


	public TypeTestDataBuilder withDayValue(double dayValue) {
		this.dayValue = dayValue;
		return this;
	}


	public TypeTestDataBuilder withParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
		return this;
	}


	public TypeTestDataBuilder withSpaceAviable(int spaceAviable) {
		this.spaceAviable = spaceAviable;
		return this;
	}


	public TypeTestDataBuilder withDisplacementCost(double displacementCost) {
		DisplacementCost = displacementCost;
		return this;
	}



	public VehicleType build() {
		VehicleType type = new VehicleType();
		
		type.setDayValue(this.dayValue);
		type.setDisplacementCost(this.DisplacementCost);
		type.setHourValue(this.hourValue);
		type.setIdVehicleType(this.idVehicleType);
		type.setParkingSpace(this.parkingSpace);
		type.setSpaceAviable(this.spaceAviable);
		
		
		return type;
	}
	

	
	
	

}
