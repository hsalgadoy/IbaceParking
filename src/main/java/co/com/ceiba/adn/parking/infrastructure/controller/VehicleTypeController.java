package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.VehicleTypeService;
import co.com.ceiba.adn.parking.domain.model.VehicleType;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/type")
@Api(tags="type")
public class VehicleTypeController {

	@Autowired
	private VehicleTypeService service;
	
	@PostMapping
	public ResponseEntity<VehicleType> guardarTipo(@RequestBody VehicleType type) {
		service.save(type);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
