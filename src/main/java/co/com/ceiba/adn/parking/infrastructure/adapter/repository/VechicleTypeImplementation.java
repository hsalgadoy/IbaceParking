package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.VehicleTypeMapper;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.VehicleTypeRepositoryJpa;

public class VechicleTypeImplementation implements VehicleTypeRepository {

	@Autowired
	private VehicleTypeRepositoryJpa vehicleTypeRapository;

	@Override
	public void putAviablePlacesByType(int idVehicleType, int places) {
		VehicleType vehicleType = vehicleTypeRapository.findByVehicleTypeId(idVehicleType);
		vehicleType.setSpaceAviable(places);
		vehicleTypeRapository.save(vehicleType);

	}

	@Override
	public int obtainAviablePlacesBytType(int idVehicleType) {
		return vehicleTypeRapository.findByVehicleTypeId(idVehicleType).getSpaceAviable();
	}

	@Override
	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRapository.save(vehicleType);
	}

	@Override
	public ArrayList<VehicleType> getVehicleTypes() {
		List<VehicleType> types = new ArrayList<VehicleType>();
		for (VehicleTypeEntity vehicleType : vehicleTypeRapository.findAll()) {
			types.add(VehicleTypeMapper.entityToDomain(vehicleType));
		}
		return new ArrayList<VehicleType>(types);
	}

	@Override
	public VehicleType save(VehicleType type) {
		return vehicleTypeRapository.save(type);
	}

	@Override
	public VehicleType findByVehicleTypeId(int vehicleTypeId) {
		return vehicleTypeRapository.findByVehicleTypeId(vehicleTypeId);
	}
}
