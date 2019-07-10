package com.ceiba.adn.parking.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.adn.parking.domain.entity.Vehicle;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String>{
	
	public Vehicle save(Vehicle vehicle);

	public List<Vehicle> findAllVehicles();
}
