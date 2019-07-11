package co.com.ceiba.adn.parking.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	private boolean DisplacementlCost;
	
	private double grossTotal;
	
}
