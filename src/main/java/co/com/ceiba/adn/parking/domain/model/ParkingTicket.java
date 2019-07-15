package co.com.ceiba.adn.parking.domain.model;

import java.time.LocalDateTime;

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
	
	private LocalDateTime inTimeDate;
	
	private LocalDateTime outTimeDate;
	
	
	
	private double grossTotal;
	
}
