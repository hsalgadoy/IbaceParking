package co.com.ceiba.adn.parking.domain.model;

import java.util.Date;
/**
 * 
 * @author hsneider.salgado
 *
 */

public class ParkingTicket {
	
	private int TicketNumber;

	private Vehicle vehicle;

	private Date inTimeDate;

	public int getTicketNumber() {
		return TicketNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Date getInTimeDate() {
		return inTimeDate;
	}

	public Date getOutTimeDate() {
		return outTimeDate;
	}

	public double getDisplacementCost() {
		return displacementCost;
	}

	public double getGrossTotal() {
		return grossTotal;
	}

	public void setTicketNumber(int ticketNumber) {
		TicketNumber = ticketNumber;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setInTimeDate(Date inTimeDate) {
		this.inTimeDate = inTimeDate;
	}

	public void setOutTimeDate(Date outTimeDate) {
		this.outTimeDate = outTimeDate;
	}

	public void setDisplacementCost(double displacementCost) {
		this.displacementCost = displacementCost;
	}

	public void setGrossTotal(double grossTotal) {
		this.grossTotal = grossTotal;
	}

	private Date outTimeDate;
	
	private double displacementCost;

	private double grossTotal;
	
	
	
}
