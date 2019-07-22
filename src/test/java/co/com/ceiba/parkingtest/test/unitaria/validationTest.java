package co.com.ceiba.parkingtest.test.unitaria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;
import co.com.ceiba.adn.parking.domain.validator.ArgumentValidator;
import co.com.ceiba.adn.parking.domain.validator.ParkingValidator;

public class validationTest {
	private  DateTimeFormatter format;
	@Before
	public void setUp() {
		 
		format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
	}
	
	@Test(expected = ParkingException.class)
	public void testRequiredValue() {
		ArgumentValidator.required(null, "error message");
	}
	
	@Test(expected = ParkingException.class)
	public void testPlusthanZero() {
	ArgumentValidator.greaterThanZeroValidation(-1, "error message");
		
	}
	
	
	@Test(expected = ParkingException.class)
	public void testCapacity() {
		ParkingValidator.capacityValidation(20, 20, "maximo");
	}
	
	
	
	@Test(expected = ParkingException.class)
	public void testLicencePlate() {
		ParkingValidator.checkInByLicensePlateValidation("AWS043", LocalDateTime.of(2019,7,22,13,13), "lunes");
	}
	

}
