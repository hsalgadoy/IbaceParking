package co.com.ceiba.adn.parking.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.adn.parking.application.service.TicketService;
import co.com.ceiba.adn.parking.domain.model.ParkingTicket;

@RestController
@RequestMapping("/api/ticket")
public class ParkingTicketController {
	
	private final TicketService ticketService;
	
	public ParkingTicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	@PostMapping
	public ResponseEntity<ParkingTicket> toRegisterVehicle(@RequestBody ParkingTicket ticket){
		ticketService.save(ticket);
		return new ResponseEntity<ParkingTicket>(HttpStatus.CREATED);
	}
}
