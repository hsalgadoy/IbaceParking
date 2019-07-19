package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

public class VehicleTypeEntityDataBuilder {
	private static final int TYPE_ID = 1;
	private static final double HOUR_VALUE = 500;
	private static final String DESCRIPTION = "moto";
	private static final double DAY_VALUE = 4000;
	private static final int PARKING_SPACE = 10;
	private static final int SPACES_AVIABLES = 10;
	private static final double DISPLACEMENT_COST = 200;

	private int idVehicleType;
	private String description;
	private double hourValue;
	private double dayValue;
	private int parkingSpace;
	private int spaceAviable;
	private double displacementCost;
	
	public VehicleTypeEntityDataBuilder() {
		this.idVehicleType=TYPE_ID;
		this.description=DESCRIPTION;
		this.hourValue=HOUR_VALUE;
		this.dayValue=DAY_VALUE;
		this.parkingSpace=PARKING_SPACE;
		this.spaceAviable=SPACES_AVIABLES;
		this.displacementCost=DISPLACEMENT_COST;
		}

	public VehicleTypeEntityDataBuilder withIdVehicleType(int idVehicleType) {
		this.idVehicleType = idVehicleType;
		return this;
	}

	public VehicleTypeEntityDataBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	public VehicleTypeEntityDataBuilder withHourValue(double hourValue) {
		this.hourValue = hourValue;
		return this;
	}

	public VehicleTypeEntityDataBuilder withDayValue(double dayValue) {
		this.dayValue = dayValue;
		return this;
	}

	public VehicleTypeEntityDataBuilder withParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
		return this;
	}

	public VehicleTypeEntityDataBuilder withSpaceAviable(int spaceAviable) {
		this.spaceAviable = spaceAviable;
		return this;
	}

	public VehicleTypeEntityDataBuilder withDisplacementCost(double displacementCost) {
		this.displacementCost = displacementCost;
		return this;
	}
	
	public VehicleTypeEntity build() {
		VehicleTypeEntity entity = new VehicleTypeEntity();
		entity.setDayValue(this.dayValue);
		entity.setDescription(this.description);
		entity.setDisplacementCost(this.displacementCost);
		entity.setHourValue(this.hourValue);
		entity.setIdVehicleType(this.idVehicleType);
		entity.setParkingSpace(this.parkingSpace);
		entity.setSpaceAviable(this.spaceAviable);		
		return entity;
	}
	

}
