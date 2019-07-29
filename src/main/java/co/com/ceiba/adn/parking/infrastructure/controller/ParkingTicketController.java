package co.com.ceiba.adn.parking.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/parking")
@Api(tags = "parking")
public class ParkingTicketController {

	private final TicketService ticketService;

	public ParkingTicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping("/invehicle")
	public ParkingTicket entryVehiclesParking(@RequestBody Vehicle vehicle) {
		return ticketService.registryIn(vehicle);
//		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PatchMapping("/outvehicle/{licenceplate}")
	public ResponseEntity<ParkingTicket> extracVehicleParking(@PathVariable("licenceplate") String licenceplate) {
		return new ResponseEntity<>(ticketService.registryOut(licenceplate), HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public List<ParkingTicket>	listParking(){
		return ticketService.findAllTickets();
	}

}
