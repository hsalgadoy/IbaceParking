package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
@Repository
public interface VehicleRepository  {

	void save(Vehicle vehicle);
	
	Vehicle findVehicleByLicensePlate(String licensePlate);
	
	List<Vehicle> findAll();
	
}
