package co.com.ceiba.adn.parking.domain.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author hsneider.salgado
 *
 */

@Getter
@Setter
public class ParkingTicket {
	
	private long TicketNumber;

	private Vehicle vehicle;

	private Date inTimeDate;

	private Date outTimeDate;

	private double grossTotal;
	
	
	
	
}
