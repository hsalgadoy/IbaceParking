package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import java.util.Date;

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
	
}
