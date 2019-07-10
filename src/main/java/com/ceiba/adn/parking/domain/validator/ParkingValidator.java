package com.ceiba.adn.parking.domain.validator;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;

public class ParkingValidator {
	
	private static final String RESTRICTED_PLATE_FILTER = "A";

	private ParkingValidator() {
	}
	/**
	 * validate if the quantity of places is enough 
	 * @param actualQuantity quantity real at time to register  
	 * @param ocupedParkingPlaces	quantity restricted by the type of vehicle
	 * @param message exception message to be displayed 
	 */
	public static void capacityValidation(long ocupedParkingPlaces, int maxQuantity, String message) {
		if (ocupedParkingPlaces >= maxQuantity) {
			throw new ParkingException(message);
		}
	}
	/**
	 * validate if the car plate have a day parking restriction
	 * @param licensePlate plate of car 
	 * @param entryDate	current date of income
	 * @param message  exception message to be displayed
	 */
	public static void checkInByLicensePlateValidation(String licensePlate, LocalDateTime entryDate, String message) {
		if (licensePlate.startsWith(RESTRICTED_PLATE_FILTER) && !(entryDate.getDayOfWeek().equals(DayOfWeek.SUNDAY)
				|| entryDate.getDayOfWeek().equals(DayOfWeek.MONDAY))) {
			throw new ParkingException(message);
		}
	}
}
