package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.hibernate.SQLQuery.ReturnProperty;
import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;

@Component
public final class ParkingTicketMapper {

	public static ParkingTicket toDomain(ParkingTicketEntity entity) {
		ParkingTicket parkingTicket = new ParkingTicket();
		parkingTicket.setDisplacementCost((entity.getDisplacementlCost()));
		parkingTicket.setInTimeDate(entity.getInTimeDate());
		parkingTicket.setOutTimeDate(entity.getOutTimeDate());
		parkingTicket.setGrossTotal(entity.getGrossTotal());
		parkingTicket.setTicketNumber(entity.getTicketNumber());
		parkingTicket.setVehicle(VehicleMapper.toDomain(entity.getVehicle()));
		return parkingTicket;
	}

	public static ParkingTicketEntity toEntity(ParkingTicket domain) {
		ParkingTicketEntity parkingTicketEntity = new ParkingTicketEntity();
		
		return parkingTicketEntity;
	}
	
}
