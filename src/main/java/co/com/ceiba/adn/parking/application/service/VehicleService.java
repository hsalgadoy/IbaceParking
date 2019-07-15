package co.com.ceiba.adn.parking.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.domain.repository.VehicleRepository;
import lombok.Data;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Data
@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository ;
	
	/**
	 * return the list of all vehicles into parking
	 * @return
	 */
	public List<Vehicle> findAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	/**
	 * return the vehicle sent to save as a saved
	 * @param vehicle
	 */
	public void saveVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}
	
	/**
	 * Obtain the vehicle searching by the licensePlate
	 * @param licensePlate the license plate as a string
	 * @return vehicle 
	 */
	public Vehicle ObtainVehicleByLicensePlate(String licensePlate) {
		return vehicleRepository.findVehicleByLicensePlate(licensePlate);
	}

}
