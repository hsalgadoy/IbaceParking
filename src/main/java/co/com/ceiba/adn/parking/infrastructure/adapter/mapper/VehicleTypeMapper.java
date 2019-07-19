package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

public class VehicleTypeMapper {

	private VehicleTypeMapper() {

	}

	public static VehicleType entityToDomain(VehicleTypeEntity entity) {
		VehicleType vehicleType = new VehicleType();
		vehicleType.setDayValue(entity.getDayValue());
		vehicleType.setDisplacementCost(entity.getDisplacementCost());
		vehicleType.setHourValue(entity.getHourValue());
		vehicleType.setDescription(entity.getDescription());
		vehicleType.setIdVehicleType(entity.getIdVehicleType());
		vehicleType.setParkingSpace(entity.getParkingSpace());
		vehicleType.setSpaceAviable(entity.getSpaceAviable());

		return vehicleType;
	}

	public static VehicleTypeEntity domainToEntity(VehicleType domain) {
		VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();
		vehicleTypeEntity.setIdVehicleType(domain.getIdVehicleType());
		vehicleTypeEntity.setDayValue(domain.getDayValue());
		vehicleTypeEntity.setDisplacementCost(domain.getDisplacementCost());
		vehicleTypeEntity.setHourValue(domain.getHourValue());
		vehicleTypeEntity.setParkingSpace(domain.getParkingSpace());
		vehicleTypeEntity.setSpaceAviable(domain.getSpaceAviable());

		return vehicleTypeEntity;
	}
}
