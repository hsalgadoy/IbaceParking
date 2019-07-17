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
public interface VehicleTypeRepositoryJpa extends JpaRepository<VehicleTypeEntity, Integer> {

	<S> S save(VehicleTypeEntity vehicleType);

	VehicleType save(VehicleType type);

	VehicleTypeEntity findByIdVehicleType(int vehicleTypeId);

	List<VehicleTypeEntity> findAll();

}
