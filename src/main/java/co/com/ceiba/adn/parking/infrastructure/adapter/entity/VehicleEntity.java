package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import co.com.ceiba.adn.parking.domain.model.VehicleTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Setter
@Getter
@Entity
@Table(name="vehicle")
public class VehicleEntity {
	
	@Id
	private String licensePlate;
	
	@Column
	private int displacement;
	
	@Column
	private VehicleTypeEnum vehicleType;


	
	
	

}
