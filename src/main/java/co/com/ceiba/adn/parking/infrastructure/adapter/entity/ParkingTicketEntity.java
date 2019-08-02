package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Entity
@Table(name="PARKING_TICKET")
public class ParkingTicketEntity {
	@Id
	@GeneratedValue
	private int ticketNumber;
	
	@ManyToOne
	@JoinColumn(name="LICENSE_PLATE", nullable=false)
	private VehicleEntity vehicle;
	
	@Column(name = "IN_TIME_DATE")
	private Date inTimeDate;
	
	@Column(name = "OUT_TIME_DATE")
	private Date outTimeDate;
	
	@Column(name = "DISPLACEMENT_COST")
	private double displacementlCost;
	
	@Column(name = "GROSS_TOTAL")
	private double grossTotal;

	public int getTicketNumber() {
		return ticketNumber;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public Date getInTimeDate() {
		return inTimeDate;
	}

	public Date getOutTimeDate() {
		return outTimeDate;
	}

	public double getDisplacementlCost() {
		return displacementlCost;
	}

	public double getGrossTotal() {
		return grossTotal;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	public void setInTimeDate(Date inTimeDate) {
		this.inTimeDate = inTimeDate;
	}

	public void setOutTimeDate(Date outTimeDate) {
		this.outTimeDate = outTimeDate;
	}

	public void setDisplacementlCost(double displacementlCost) {
		this.displacementlCost = displacementlCost;
	}

	public void setGrossTotal(double grossTotal) {
		this.grossTotal = grossTotal;
	}
	
}
