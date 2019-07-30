package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleTypeRepositoryJpa extends CrudRepository<VehicleTypeEntity, Integer> {

	@SuppressWarnings("unchecked")
	VehicleTypeEntity save(VehicleTypeEntity vehicleType);

	VehicleTypeEntity findByIdVehicleType(int vehicleTypeId);

	List<VehicleTypeEntity> findAll();

}
