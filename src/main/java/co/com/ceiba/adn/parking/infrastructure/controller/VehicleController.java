package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.VehicleService;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/vehicle")
@Api(tags = "vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping
	public ResponseEntity<Vehicle> toRegisterVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.saveVehicle(vehicle);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{licenceplate}")
	public ResponseEntity<Vehicle> get(@PathVariable("licenceplate") String vehicleLisencePlate) {
		return new ResponseEntity<> (vehicleService.ObtainVehicleByLicensePlate(vehicleLisencePlate),HttpStatus.OK);
	}
}
