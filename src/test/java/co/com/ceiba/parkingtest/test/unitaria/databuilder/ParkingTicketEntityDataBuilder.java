package co.com.ceiba.parkingtest.test.unitaria.databuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

public class ParkingTicketEntityDataBuilder {

	private static final int TICKET_NUM = 1;
	private static final String IN_DATE = "10/06/2019 07:00:00";
	private static final String OUT_DATE = "10/06/2019 20:00:00";
	private static final VehicleEntity VEHICLE_T = new VehicleEntityDataBuilder().build();
	private static final double TOTAL_TICKET = 6000;

	public final SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy hh:mm");

	private VehicleEntity vehicle;
	private int ticketNumber;
	private Date inTimeDate;
	private Date outTimeDate;
	private double grossTotal;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	public ParkingTicketEntityDataBuilder() throws ParseException {
		this.ticketNumber = TICKET_NUM;
		this.inTimeDate = formato.parse(IN_DATE);
		this.outTimeDate = formato.parse(OUT_DATE);
		this.vehicle = VEHICLE_T;
		this.grossTotal = TOTAL_TICKET;
	}

	public ParkingTicketEntityDataBuilder withVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
		return this;
	}

	public ParkingTicketEntityDataBuilder withTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
		return this;
	}

	public ParkingTicketEntityDataBuilder withInTimeDate(Date inTimeDate) {
		this.inTimeDate = inTimeDate;
		return this;
	}

	public ParkingTicketEntityDataBuilder withOutTimeDate(Date outTimeDate) {
		this.outTimeDate = outTimeDate;
		return this;
	}

	public ParkingTicketEntityDataBuilder withGrossTotal(double grossTotal) {
		this.grossTotal = grossTotal;
		return this;
	}

	public ParkingTicketEntity build() {
		ParkingTicketEntity ticket = new ParkingTicketEntity();
		ticket.setGrossTotal(this.grossTotal);
		ticket.setInTimeDate(this.inTimeDate);
		ticket.setOutTimeDate(this.outTimeDate);
		ticket.setVehicle(this.vehicle);
		ticket.setTicketNumber(this.ticketNumber);
		return ticket;
	}

}
