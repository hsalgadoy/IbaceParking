package co.com.ceiba.parkingtest.test.unitaria.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.Vehicle;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.VehicleMapper;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleEntityDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleTypeEntityDataBuilder;

public class VehicleMapperTest {
	public Vehicle vehicle;
	public VehicleEntity vehicleEntity;

	VehicleEntityDataBuilder vehicleEntityDataBuilder;
	VehicleDataBuilder vehicleDataBuilder;
	VehicleTypeEntityDataBuilder vehicleTypeEntityDataBuilder;

	@Before
	public void setUp() {
		vehicleEntityDataBuilder = new VehicleEntityDataBuilder();
		vehicleDataBuilder = new VehicleDataBuilder();
		vehicleTypeEntityDataBuilder = new VehicleTypeEntityDataBuilder();

	}

	@Test
	public void domainToEntity() {
		vehicle = vehicleDataBuilder.build();
		vehicleEntity= VehicleMapper.toEntity(vehicle);
		
		assertEquals(vehicle.getLicensePlate(), vehicleEntity.getLicensePlate());
		assertEquals(vehicle.getDisplacement(), vehicleEntity.getDisplacement(),0.01);
		assertEquals(vehicle.getVehicleType(), vehicleEntity.getVehicleType());
		
		
	}
	
	@Test
	public void entityToDomain() {
		vehicleEntity = vehicleEntityDataBuilder.build();
		vehicle= VehicleMapper.toDomain(vehicleEntity);
		
		assertEquals(vehicle.getLicensePlate(), vehicleEntity.getLicensePlate());
		assertEquals(vehicle.getDisplacement(), vehicleEntity.getDisplacement(),0.01);
		assertEquals(vehicle.getVehicleType(), vehicleEntity.getVehicleType());
		
		
	}

}
