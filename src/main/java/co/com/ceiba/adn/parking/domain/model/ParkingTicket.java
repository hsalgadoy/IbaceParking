package co.com.ceiba.adn.parking.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Entity
@Getter
@Setter
@Table(name="PARKING_TICKET")
public class ParkingTicket {
	
	private long TicketNumber;
	
	private Vehicle vehicle;
	
	private LocalDateTime inTimeDate;
	
	private LocalDateTime outTimeDate;
	
	private double DisplacementCost;
	
	private double grossTotal;
	
}
