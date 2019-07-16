package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import co.com.ceiba.adn.parking.domain.model.Vehicle;

public class VehicleDataBuilder {

	private static final int TYPE = 1;
	private static final long DISPLACEMENT_CC = 650;
	private static final String LISENCE_PLATE = "FSG83D";

	private String licensePlate;

	private double displacement;

	private int vehicleType;

	public VehicleDataBuilder() {
		this.licensePlate = LISENCE_PLATE;
		this.displacement = DISPLACEMENT_CC;
		this.vehicleType = TYPE;
	}

	public VehicleDataBuilder withLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}

	public VehicleDataBuilder withDisplacement(double displacement) {
		this.displacement = displacement;
		return this;
	}

	public VehicleDataBuilder withVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	public Vehicle build() {
		Vehicle vehicle = new Vehicle();
		vehicle.setDisplacement(this.displacement);
		vehicle.setVehicleType(this.vehicleType);
		vehicle.setLicensePlate(this.licensePlate);
		return vehicle;
	}

}
