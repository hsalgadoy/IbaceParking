package com.ceiba.adn.parking.domain.entity;

import com.ceiba.adn.parking.domain.validator.ArgumentValidator;

import lombok.Data;

import javax.persistence.Id;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Data
public class Vehicle {
	@Id
	private	 String licensePlate;
	private  int displacement;
	private	VehicleTypeEnum vehicleType;
	
public Vehicle(String licensePlate, int displacement, VehicleTypeEnum vehicleType) {
		
		ArgumentValidator.required(licensePlate, "Es Necesario Ingresar un Numero de Placa");
		ArgumentValidator.GreaterThanZeroValidation(displacement, "El cilindrage debe ser mayor a cero");
		ArgumentValidator.required(vehicleType, "Tipo de veiculo Obligatorio");
		
		this.licensePlate = licensePlate;
		this.displacement = displacement;
		this.vehicleType = vehicleType;
	}
	
}
