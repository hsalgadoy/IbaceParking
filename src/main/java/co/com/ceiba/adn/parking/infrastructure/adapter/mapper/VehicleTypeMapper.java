package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

public class VehicleTypeMapper {

	private VehicleTypeMapper() {

	}

	public static VehicleType entityToDomain(VehicleTypeEntity entity) {
		VehicleType vehicleType = new VehicleType();
		vehicleType.setDayValue(entity.getDayValue());
		vehicleType.setDisplacementCost(entity.getDisplacementCost());
		vehicleType.setHourValue(entity.getHourValue());
		vehicleType.setIdVehicleType(entity.getIdVehicleType());
		vehicleType.setParkingSpace(entity.getParkingSpace());
		vehicleType.setSpaceAviable(entity.getSpaceAviable());

		return vehicleType;
	}

	public static VehicleEntity domainToEntity(Vehicle domain) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();

		vehicleEntity.setLicensePlate(domain.getLicensePlate());

		vehicleTypeEntity.setIdVehicleType(domain.getVehicleType());
		vehicleEntity.setVehicleType(vehicleTypeEntity);

		return vehicleEntity;
	}
}
