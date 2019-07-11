package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

@Component
public final class VehicleMapper {

	public static Vehicle toDomain(VehicleEntity entity) {
		return new Vehicle();
	}

	public static VehicleEntity toEntity(Vehicle domain) {
		VehicleEntity entity = new VehicleEntity();
		
		return entity;
	}
}
