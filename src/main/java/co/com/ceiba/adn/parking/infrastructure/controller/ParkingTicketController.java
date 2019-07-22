package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.TicketService;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/parking")
@Api(tags = "parking")
public class ParkingTicketController {

	private final TicketService ticketService;

	public ParkingTicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping("/invehicle")
	public ResponseEntity<ParkingTicket> ingresarVehiculoEstacionamiento(@RequestBody Vehicle vehicle) {
		ticketService.registryIn(vehicle);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/outvehicle/{licenceplate}")
	public ResponseEntity<ParkingTicket> extraerVehiculoEstacionamiento(@PathVariable("licenceplate") String licenceplate) {
		return new ResponseEntity<>(ticketService.registryOut(licenceplate), HttpStatus.CREATED);
	}
	
	

}
