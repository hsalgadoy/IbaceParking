package co.com.ceiba.adn.parking.infrastructure.adapter.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.adn.parking.domain.model.ParkingTicket;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.ParkingTicketEntity;

@Component
public final class ParkingTicketMapper {

	public static ParkingTicket toDomain(ParkingTicketEntity entity) {
		ParkingTicket parkingTicket = new ParkingTicket();
		parkingTicket.setInTimeDate(entity.getInTimeDate());
		parkingTicket.setOutTimeDate(entity.getOutTimeDate());
		parkingTicket.setGrossTotal(entity.getGrossTotal());
		parkingTicket.setTicketNumber(entity.getTicketNumber());
		parkingTicket.setVehicle(VehicleMapper.toDomain(entity.getVehicle()));
		return parkingTicket;
	}

	public static ParkingTicketEntity toEntity(ParkingTicket domain) {
		ParkingTicketEntity parkingTicketEntity = new ParkingTicketEntity();
		
		parkingTicketEntity.setTicketNumber(domain.getTicketNumber());
		parkingTicketEntity.setInTimeDate(domain.getInTimeDate());
		parkingTicketEntity.setOutTimeDate(domain.getOutTimeDate());
		parkingTicketEntity.setVehicle(VehicleMapper.toEntity(domain.getVehicle()));
		parkingTicketEntity.setGrossTotal(domain.getGrossTotal());
		
		
		return parkingTicketEntity;
	}
	
}
