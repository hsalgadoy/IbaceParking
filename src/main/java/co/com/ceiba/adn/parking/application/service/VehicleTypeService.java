package co.com.ceiba.adn.parking.application.service;

import java.util.List;

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
	private VehicleTypeRepository vehicleTypeRepository;
	
	/**
	 * Access to save ticket
	 * @param ticket object ticket to be saved
	 * @return return ticked to save as a saved ticked
	 */
	public void save(VehicleType type) {
		 vehicleTypeRepository.saveVehicleType(type);
	}
	/**
	 * get a list of all tickets at parking
	 * @return list of tickets
	 */
	public List<VehicleType> findAllTypes() {
		return vehicleTypeRepository.getVehicleTypes();
	}
	
	public VehicleType findByIdType(int type) {
		return vehicleTypeRepository.findByVehicleTypeId(type);
	}

	
		
	
}
