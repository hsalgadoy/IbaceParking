package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.VehicleService;
import co.com.ceiba.adn.parking.domain.model.Vehicle;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<Vehicle> toRegisterVehicle(@RequestBody Vehicle vehicle){
		vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<Vehicle>(HttpStatus.CREATED);
	}
	
}
