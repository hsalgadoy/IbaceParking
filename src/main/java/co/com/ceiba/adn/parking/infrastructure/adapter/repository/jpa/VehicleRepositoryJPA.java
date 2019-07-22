package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleRepositoryJPA extends CrudRepository<VehicleEntity, String> {

	void save(Vehicle vehicle);

	VehicleEntity findVehicleByLicensePlate(String licensePlate);
	
	int countByLicensePlate(String licensePlate);

}
