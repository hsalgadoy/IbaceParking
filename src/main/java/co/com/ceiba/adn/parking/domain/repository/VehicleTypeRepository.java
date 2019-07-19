package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.VehicleType;

@Repository
public interface VehicleTypeRepository {

	void putAviablePlacesByType(int idVehicleType, int places);

	int obtainAviablePlacesBytType(int idVehicleType);

	void saveVehicleType(VehicleType vehicleType);

	List<VehicleType> getVehicleTypes();

	VehicleType save(VehicleType type);

	VehicleType findByVehicleTypeId(int vehicleTypeId);
	
	

}
