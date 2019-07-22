package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;

@RestController
@RequestMapping("/api/type")
public class VehicleTypeController {

	@Autowired
	private VehicleTypeRepository vehicleTypeRapository;

	
	@PostMapping
	public ResponseEntity<VehicleType> toRegisterVehicle(@RequestBody VehicleType type){
		vehicleTypeRapository.save(type);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	


}
