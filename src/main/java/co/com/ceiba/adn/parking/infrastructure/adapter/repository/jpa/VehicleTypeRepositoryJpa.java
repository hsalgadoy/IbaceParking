package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleTypeRepositoryJpa extends JpaRepository<VehicleTypeEntity, Integer>{

	void putAviablePlacesByType(int idVehicleType, int places);

	int obtainAviablePlacesBytType(int idVehicleType);

	void saveVehicleType(VehicleType vehicleType);

	List<VehicleType> getVehicleTypes();

	VehicleType save(VehicleType type);
		
	VehicleType findByVehicleTypeId(int vehicleTypeId);
	
	List<VehicleTypeEntity> findAll();
	
}
