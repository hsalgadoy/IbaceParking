package co.com.ceiba.adn.parking.infrastructure.adapter.entity;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Setter
@Getter
public class TicketEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime entranceDate;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime departureDate;
	private Vehicle vehicle;
	private boolean payment = false;

}
