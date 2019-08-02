package co.com.ceiba.adn.parking.domain.model;

/**
 * 
 * @author hsneider.salgado
 *
 */

public class Vehicle {

	private String licenseplate;

	private double displacemen;

	private int vehicletype;

	public String getLicensePlate() {
		return licenseplate;
	}

	public double getDisplacement() {
		return displacemen;
	}

	public int getVehicleType() {
		return vehicletype;
	}

	public void setLicensePlate(String licensePlate) {
		this.licenseplate = licensePlate;
	}

	public void setDisplacement(double displacement) {
		this.displacemen = displacement;
	}

	public void setVehicleType(int vehicleType) {
		this.vehicletype = vehicleType;
	}
}
 