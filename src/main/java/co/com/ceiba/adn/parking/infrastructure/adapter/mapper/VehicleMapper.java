package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {

	public static Vehicle toDomain(VehicleEntity entity) {
		return new Vehicle(entity.getLicensePlate(), entity.getDisplacement(), entity.getVehicleType());
	}

	public static VehicleEntity toEntity(Vehicle domain) {
		VehicleEntity entity = new VehicleEntity();
		entity.setDisplacement(domain.getDisplacement());
		entity.setLicensePlate(domain.getLicensePlate());
		entity.setVehicleType(domain.getVehicleType());
		return entity;
	}
}
