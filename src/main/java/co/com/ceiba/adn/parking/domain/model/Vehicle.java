package co.com.ceiba.adn.parking.domain.model;

/**
 * 
 * @author hsneider.salgado
 *
 */


public class Vehicle {

	private String licensePlate;

	private double displacement;

	private int vehicleType;

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
				
	
	
	
	
}
 