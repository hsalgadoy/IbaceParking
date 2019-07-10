package com.ceiba.adn.parking.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


@Data
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime entranceDate;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime departureDate;
	private Vehicle vehicle;
	private boolean payment = false;
	
	public Ticket() {
		
	}

	public Ticket(int id, LocalDateTime entranceDate, LocalDateTime departureDate, Vehicle vehicle, boolean payment) {
		this.id = id;
		this.entranceDate = entranceDate;
		this.departureDate = departureDate;
		this.vehicle = vehicle;
		this.payment = payment;
	}

	

}
