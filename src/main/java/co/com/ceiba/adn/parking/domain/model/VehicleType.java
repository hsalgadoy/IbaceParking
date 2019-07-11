package co.com.ceiba.adn.parking.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class VehicleType {
	private int idVehicleType;
	
	private double hourValue;
	
	private double dayValue;
	
	private int parkingSpace;
	
	private int spaceAviable;
	
	private List<Vehicle> vehicles;
	
}
