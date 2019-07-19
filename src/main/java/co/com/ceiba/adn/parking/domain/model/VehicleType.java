package co.com.ceiba.adn.parking.domain.model;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author hsneider.salgado
 *
 */

@Getter
@Setter
public class VehicleType {
	private int idVehicleType;
	
	private double hourValue;
	
	private double dayValue;
	
	private String description;
	
	private int parkingSpace;
	
	private int spaceAviable;
	
	private double DisplacementCost;
	
	
}
