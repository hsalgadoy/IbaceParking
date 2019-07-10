package com.ceiba.adn.parking.domain.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adn.parking.domain.validator.ParkingValidator;

import lombok.Data;


@Component

public class Parking {
	private static final String MAX_CAPACITY_MESSAGE = "Capacidad maxima para este tipo de vehiculo";
	private static final String RESTRICTION_MESSAGE = "El vehiculo tiene restricion de acceso el dia de hoy";

	private List<Ticket> tickets;

	
	public Parking(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket vehicleCheckIn(Vehicle vehicle, LocalDateTime entryDate) {

		ParkingValidator.capacityValidation(countVehiclesByType(vehicle.getVehicleType()),
				vehicle.getVehicleType().getMaxQuantity(), MAX_CAPACITY_MESSAGE);
		ParkingValidator.checkInByLicensePlateValidation(vehicle.getLicensePlate(), entryDate, RESTRICTION_MESSAGE);

		Ticket ticket = new Ticket();
		ticket.setEntranceDate(entryDate);
		ticket.setVehicle(vehicle);

		tickets.add(ticket);

		return ticket;

	}

	public float calculatePrice(Ticket ticket) {

		LocalDateTime tempDateTime = LocalDateTime.from(ticket.getEntranceDate());
		long days = tempDateTime.until(ticket.getDepartureDate(), ChronoUnit.DAYS);
		tempDateTime = tempDateTime.plusDays(days);
		long hours = tempDateTime.until(ticket.getDepartureDate(), ChronoUnit.HOURS);
		float price = hours * ticket.getVehicle().getVehicleType().getHourPrice()
				+ days * ticket.getVehicle().getVehicleType().getDayPrice();

		if (ticket.getVehicle().getVehicleType().equals(VehicleTypeEnum.MOTORBYKE)
				&& ticket.getVehicle().getDisplacement() > 500) {
			price += 2000F;
		}

		return price;
	}

	private long countVehiclesByType(VehicleTypeEnum vehicleType) {
		return tickets.stream().filter(t -> t.getVehicle().getVehicleType().equals(vehicleType)).count();
	}
}
