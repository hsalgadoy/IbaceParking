package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.repository.VehicleRepository;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.VehicleMapper;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.VehicleRepositoryJPA;

@Repository
@Transactional
public class VehicleImplementation implements VehicleRepository{
	
	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	@Override
	public void save (Vehicle vehicle) {
		vehicleRepositoryJPA.save(VehicleMapper.toEntity(vehicle));
	}
	


	@Override
	public Vehicle findVehicleByLicensePlate(String licensePlate) {
		return VehicleMapper.toDomain(vehicleRepositoryJPA.findVehicleByLicensePlate(licensePlate));
		
	}



	@Override
	public List<Vehicle> findAll() {
		
		return null;
	}



	@Override
	public int countByLicensePlate(String licensePlate) {
		return vehicleRepositoryJPA.countByLicensePlate(licensePlate);
	}

}
