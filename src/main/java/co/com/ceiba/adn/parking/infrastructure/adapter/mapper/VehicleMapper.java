package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {

	private VehicleMapper() {

	}

	public static Vehicle toDomain(VehicleEntity entity) {
		Vehicle vehicle = new Vehicle();

		vehicle.setLicensePlate(entity.getLicensePlate());

		vehicle.setDisplacement(entity.getDisplacement());

		vehicle.setVehicleType(entity.getVehicleType());

		return vehicle;
	}

	public static VehicleEntity toEntity(Vehicle domain) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setDisplacement(domain.getDisplacement());
		
		vehicleEntity.setLicensePlate(domain.getLicensePlate());
		

		vehicleEntity.setVehicleType(domain.getVehicleType());

		return vehicleEntity;
	}
}
