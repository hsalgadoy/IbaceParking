package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

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
public class ParkingTicketEntity {
	@Id
	@GeneratedValue
	private long TicketNumber;
	
	@ManyToOne
	@JoinColumn(name="LICENSE_PLATE", nullable=false)
	private VehicleEntity vehicle;
	
	@Column(name = "IN_TIME_DATE")
	private LocalDateTime inTimeDate;
	
	@Column(name = "OUT_TIME_DATE")
	private LocalDateTime outTimeDate;
	
	@Column(name = "DISPLACEMENT_COST")
	private double DisplacementlCost;
	
	@Column(name = "GROSS_TOTAL")
	private double grossTotal;
	
}
