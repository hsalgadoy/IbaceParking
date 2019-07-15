package co.com.ceiba.adn.parking.domain.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Entity
@Getter
@Setter
public class Vehicle {


	private String licensePlate;
	
	private  double displacement;
	
	private int vehicleType;
	
	
	
	
}
 