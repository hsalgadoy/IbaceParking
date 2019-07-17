package co.com.ceiba.adn.parking.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;

@RestController
@RequestMapping("/api/type")
public class VehicleTypeController {

	@Autowired
	private VehicleTypeRepository vehicleTypeRapository;

	

	


}
