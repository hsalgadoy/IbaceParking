package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

public class VehicleEntityDataBuilder {
	private static final String LISENCE_PLATE = "FSG83D";
	private static final double DISPLACEMENT = 650;
	private static final VehicleTypeEntity VEHILCE_TYPE_ENTITY = new VehicleTypeEntity();

	private String licensePlate;
	private double displacement;
	private VehicleTypeEntity vehicleType;

	public VehicleEntityDataBuilder() {
		this.licensePlate = LISENCE_PLATE;
		this.displacement = DISPLACEMENT;
		this.vehicleType = VEHILCE_TYPE_ENTITY;
	}

	public VehicleEntityDataBuilder withVehicleType(VehicleTypeEntity type) {
		this.vehicleType = type;
		return this;
	}

	public VehicleEntityDataBuilder withDisplacement(long displacemente) {
		this.displacement = displacemente;
		return this;
	}

	public VehicleEntityDataBuilder withLisencePlate(String lisencePlate) {
		this.licensePlate = lisencePlate;
		return this;
	}

	public VehicleEntity build() {
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setDisplacement(this.displacement);
		vehicleEntity.setLicensePlate(this.licensePlate);
		vehicleEntity.setVehicleType(this.vehicleType.getIdVehicleType());
		return vehicleEntity;
	}

}
