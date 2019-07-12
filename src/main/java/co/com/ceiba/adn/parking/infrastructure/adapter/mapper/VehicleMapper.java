package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

@Component
public final class VehicleMapper {

	public static Vehicle toDomain(VehicleEntity entity) {
		Vehicle vehicle = new Vehicle();
		
		vehicle.setLicensePlate(entity.getLicensePlate());
		
		vehicle.setDisplacement(entity.getDisplacement());
		
		vehicle.setVehicleType(entity.getVehicleType().getIdVehicleType());

		return vehicle;
	}

	public static VehicleEntity toEntity(Vehicle domain) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		VehicleTypeEntity vehicleTypeEntity = new VehicleTypeEntity();

		vehicleEntity.setDisplacement(domain.getDisplacement());

		vehicleEntity.setLicensePlate(domain.getLicensePlate());

		vehicleTypeEntity.setIdVehicleType(domain.getVehicleType());
		vehicleEntity.setVehicleType(vehicleTypeEntity);

		return vehicleEntity;
	}
}
