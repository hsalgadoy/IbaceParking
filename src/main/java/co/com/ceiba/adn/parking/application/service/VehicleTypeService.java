package co.com.ceiba.adn.parking.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Service
public class VehicleTypeService {


	@Autowired
	private VehicleTypeRepository ticketRepository;
	
	public VehicleType searchVehicle(int vehicleTypeId) {
		return ticketRepository.findByVehicleTypeId(vehicleTypeId);
	}
		
	
}
