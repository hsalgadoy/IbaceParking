package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import java.time.LocalDateTime;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;

public class ParkingTicketDataBuilder {

	private static final int TICKET_NUM = 1;
	private static final String IN_DATE = "10/06/2019 07:00:00";
	private static final String OUT_DATE = "10/06/2019 20:00:00";
	private static final Vehicle VEHICLE_T = new VehicleDataBuilder().build() ;
	private static final double TOTAL_TICKET = 6000;

	private long TicketNumber;

	private Vehicle vehicle = new VehicleDataBuilder().build();

	private LocalDateTime inTimeDate;

	private LocalDateTime outTimeDate;

	private double grossTotal;
	
	
	public ParkingTicketDataBuilder() {
		this.TicketNumber = TICKET_NUM;
		this.inTimeDate = LocalDateTime.parse(IN_DATE);
		this.outTimeDate = LocalDateTime.parse(OUT_DATE);
		this.vehicle= VEHICLE_T;
		this.grossTotal = TOTAL_TICKET;
	}

	public ParkingTicketDataBuilder withVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	public ParkingTicketDataBuilder withTicketNumber(long ticketNumber) {
		TicketNumber = ticketNumber;
		return this;
	}



	public ParkingTicketDataBuilder withInTimeDate(LocalDateTime inTimeDate) {
		this.inTimeDate = inTimeDate;
		return this;
	}

	public ParkingTicketDataBuilder withOutTimeDate(LocalDateTime outTimeDate) {
		this.outTimeDate = outTimeDate;
		return this;
	}

	public ParkingTicketDataBuilder withGrossTotal(double grossTotal) {
		this.grossTotal = grossTotal;
		return this;
	}
	

	public ParkingTicket build() {
		ParkingTicket ticket = new ParkingTicket();
		ticket.setGrossTotal(this.grossTotal);
		ticket.setInTimeDate(this.inTimeDate);
		ticket.setOutTimeDate(this.outTimeDate);
		ticket.setVehicle(this.vehicle);
		ticket.setTicketNumber(this.TicketNumber);
		return ticket;
	}

	

}
