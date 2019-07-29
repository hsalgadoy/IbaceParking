package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.VehicleService;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import io.swagger.annotations.Api;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/vehicle")
@Api(tags = "vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	
	@PostMapping("/entry")
	public Vehicle toRegisterVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);

	}

	@GetMapping("/get/{licenceplate}")
	public Vehicle get(@PathVariable("licenceplate") String vehicleLisencePlate) {
		return vehicleService.ObtainVehicleByLicensePlate(vehicleLisencePlate);
	}
}
