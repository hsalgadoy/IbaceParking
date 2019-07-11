package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class VehicleEntity {
	@Id
	@Column(name="LICENSE_PLATE", nullable=false, length=6 )
	private String licensePlate;
	
	@Column(name="DISPLACEMENT")
	private  double displacement;
	@ManyToOne
	@JoinColumn(name="ID_VEHICLE_TYPE", nullable=false)
	private VehicleTypeEntity vehicleType;
	
	
}
 