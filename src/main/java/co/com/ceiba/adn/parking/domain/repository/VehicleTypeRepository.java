package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import co.com.ceiba.adn.parking.domain.model.VehicleType;

public interface VehicleTypeRepository {

	void putAviablePlacesByType(int idVehicleType);

	int obtainAviablePlacesBytType(int idVehicleType);

	VehicleType saveVehicleType(VehicleType vehicleType);

	List<VehicleType> getVehicleTypes();

	VehicleType save(VehicleType type);
	
	List<VehicleType> findAll();
	
	VehicleType findByVehicleTypeId(int vehicleTypeId);

}
