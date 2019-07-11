package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

public class VehicleTypeMapper {
	public static Vehicle entityToDomain(VehicleEntity vehicleEntity) {
		Vehicle vehicleDomain = new Vehicle();
		
		vehicleDomain.setLicensePlate(vehicleEntity.getLicensePlate());
		vehicleDomain.setDisplacement(vehicleEntity.getDisplacement());
		vehicleDomain.setVehicleType(vehicleDomain.getVehicleType());
		
		return vehicleDomain;
	}

	public static VehicleEntity domainToEntity(Vehicle domain) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		VehicleTypeEntity vehicleTypeEntity= new VehicleTypeEntity();
		
		vehicleEntity.setLicensePlate(domain.getLicensePlate());
		
		vehicleTypeEntity.setIdVehicleType(domain.getVehicleType());
		vehicleEntity.setVehicleType(vehicleTypeEntity);
		
		
		
		return vehicleEntity;
	}
}
