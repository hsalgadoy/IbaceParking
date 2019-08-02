package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Entity
public class VehicleEntity {
	@Id
	@Column(name="LICENSE_PLATE")
	private String licensePlate;
	
	@Column(name="DISPLACEMENT")
	private  double displacement;
	
	public String getLicensePlate() {
		return licensePlate;
	}

	public double getDisplacement() {
		return displacement;
	}

	public int getVehicleType() {
		return vehicleType;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setDisplacement(double displacement) {
		this.displacement = displacement;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	@Column(name="VEHICLE_TYPE_ID")
	private int vehicleType;
	
	
}
 