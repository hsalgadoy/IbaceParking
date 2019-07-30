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
public class VehicleEntity {
	@Id
	@Column(name="LICENSE_PLATE")
	private String licensePlate;
	
	@Column(name="DISPLACEMENT")
	private  double displacement;
	
	@Column(name="VEHICLE_TYPE_ID")
	private int vehicleType;
	
	
}
 