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
	
	
	public int getIdVehicleType() {
		return idVehicleType;
	}

	public String getDescription() {
		return description;
	}

	public double getHourValue() {
		return hourValue;
	}

	public double getDayValue() {
		return dayValue;
	}

	public int getParkingSpace() {
		return parkingSpace;
	}

	public int getSpaceAviable() {
		return spaceAviable;
	}

	public double getDisplacementCost() {
		return displacementCost;
	}

	public void setIdVehicleType(int idVehicleType) {
		this.idVehicleType = idVehicleType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHourValue(double hourValue) {
		this.hourValue = hourValue;
	}

	public void setDayValue(double dayValue) {
		this.dayValue = dayValue;
	}

	public void setParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public void setSpaceAviable(int spaceAviable) {
		this.spaceAviable = spaceAviable;
	}

	public void setDisplacementCost(double displacementCost) {
		this.displacementCost = displacementCost;
	}



}
