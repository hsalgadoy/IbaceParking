package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

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
public class VehicleTypeEntity {
	@Id
	@Column(name = "ID_VEHICLE_TYPE")
	private int idVehicleType;

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
	@OneToMany(mappedBy = "vehicleType")
	private List<VehicleEntity> vehicles;

}
