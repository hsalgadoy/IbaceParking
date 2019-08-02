package co.com.ceiba.adn.parking.domain.model;

/**
 * 
 * @author hsneider.salgado
 *
 */
		
public class VehicleType {
	public int getIdVehicleType() {
		return idVehicleType;
	}

	public double getHourValue() {
		return hourValue;
	}

	public double getDayValue() {
		return dayValue;
	}

	public String getDescription() {
		return description;
	}

	public int getParkingSpace() {
		return parkingSpace;
	}

	public int getSpaceAviable() {
		return spaceAviable;
	}

	public double getDisplacementCost() {
		return DisplacementCost;
	}

	public void setIdVehicleType(int idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public void setHourValue(double hourValue) {
		this.hourValue = hourValue;
	}

	public void setDayValue(double dayValue) {
		this.dayValue = dayValue;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public void setSpaceAviable(int spaceAviable) {
		this.spaceAviable = spaceAviable;
	}

	public void setDisplacementCost(double displacementCost) {
		DisplacementCost = displacementCost;
	}

	private int idVehicleType;
	
	private double hourValue;
	
	private double dayValue;
	
	private String description;
	
	private int parkingSpace;
	
	private int spaceAviable;
	
	private double DisplacementCost;
	
	
}
