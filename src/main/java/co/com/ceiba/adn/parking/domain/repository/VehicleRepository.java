package co.com.ceiba.adn.parking.domain.repository;

import java.util.List;

import co.com.ceiba.adn.parking.domain.model.Vehicle;

public interface VehicleRepository {

	void save(Vehicle vehicle);
	
	List<Vehicle> findAll();
	
}
