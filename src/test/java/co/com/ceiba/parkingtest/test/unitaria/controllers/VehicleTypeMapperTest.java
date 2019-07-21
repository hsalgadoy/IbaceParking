package co.com.ceiba.parkingtest.test.unitaria.controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.VehicleTypeMapper;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleTypeDataBuilder;
import co.com.ceiba.parkingtest.test.unitaria.databuilder.VehicleTypeEntityDataBuilder;

public class VehicleTypeMapperTest {

	VehicleType type;
	VehicleTypeEntity typeEntity;

	VehicleTypeDataBuilder typeBuilder;
	VehicleTypeEntityDataBuilder typeEntityBuilder;

	@Before
	public void setUp() {
		typeBuilder = new VehicleTypeDataBuilder();
		typeEntityBuilder = new VehicleTypeEntityDataBuilder();
	}

	@Test
	public void domainToEntity() {
		type = typeBuilder.build();
		typeEntity = VehicleTypeMapper.domainToEntity(type);
		assertEquals(type.getDayValue(), typeEntity.getDayValue(), 0.01);
		assertEquals(type.getDescription(), typeEntity.getDescription());
		assertEquals(type.getDisplacementCost(), typeEntity.getDisplacementCost(), 0.01);
		assertEquals(type.getHourValue(), typeEntity.getHourValue(), 0.01);
		assertEquals(type.getIdVehicleType(), typeEntity.getIdVehicleType());
		assertEquals(type.getParkingSpace(), typeEntity.getParkingSpace());
		assertEquals(type.getSpaceAviable(), typeEntity.getSpaceAviable(), 0.01);

	}

	@Test
	public void entotyToDomain() {
		typeEntity = typeEntityBuilder.build();
		type = VehicleTypeMapper.entityToDomain(typeEntity);
		assertEquals(type.getDayValue(), typeEntity.getDayValue(), 0.01);
		assertEquals(type.getDescription(), typeEntity.getDescription());
		assertEquals(type.getDisplacementCost(), typeEntity.getDisplacementCost(), 0.01);
		assertEquals(type.getHourValue(), typeEntity.getHourValue(), 0.01);
		assertEquals(type.getIdVehicleType(), typeEntity.getIdVehicleType());
		assertEquals(type.getParkingSpace(), typeEntity.getParkingSpace());
		assertEquals(type.getSpaceAviable(), typeEntity.getSpaceAviable(), 0.01);

	}

}
