package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
public class VehicleTypeEntity {
	@Id
	@Column(name = "ID_VEHICLE_TYPE")
	private int idVehicleType;
	
	@Column(name="TYPE_DESCRIPTION")
	private String description;
	
	@Column(name = "HOUR_VALUE")
	private double hourValue;

	@Column(name = "DAY_VALUE")
	private double dayValue;

	@Column(name = "PARKING_SPACE")
	private int parkingSpace;

	@Column(name = "SPACE_AVIABLE")
	private int spaceAviable;

	@Column(name = "EXTRA_COST")
	private double displacementCost;
	

}
