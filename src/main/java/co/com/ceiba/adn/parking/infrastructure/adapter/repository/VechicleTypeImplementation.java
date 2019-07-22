package co.com.ceiba.adn.parking.infrastructure.adapter.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.domain.model.VehicleType;
import co.com.ceiba.adn.parking.domain.repository.VehicleTypeRepository;
import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;
import co.com.ceiba.adn.parking.infrastructure.adapter.mapper.VehicleTypeMapper;
import co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa.VehicleTypeRepositoryJpa;

@Repository
public class VechicleTypeImplementation implements VehicleTypeRepository {
 
	@Autowired
	private VehicleTypeRepositoryJpa vehicleTypeRapository;

	@Override
	public void putAviablePlacesByType(int idVehicleType, int places) {
		VehicleType vehicleType = VehicleTypeMapper.entityToDomain(vehicleTypeRapository.findByIdVehicleType(idVehicleType));
		vehicleType.setSpaceAviable(places);
		vehicleTypeRapository.save(vehicleType);

	}

	@Override
	public int obtainAviablePlacesBytType(int idVehicleType) {
		return vehicleTypeRapository.findByIdVehicleType(idVehicleType).getSpaceAviable();
	}

	@Override
	public void saveVehicleType(VehicleType vehicleType) {
		vehicleTypeRapository.save(vehicleType);
	}

	@Override
	public ArrayList<VehicleType> getVehicleTypes() {
		List<VehicleType> types = new ArrayList<>();
		for (VehicleTypeEntity vehicleType : vehicleTypeRapository.findAll()) {
			types.add(VehicleTypeMapper.entityToDomain(vehicleType));
		}
		return new ArrayList<>(types);
	}

	@Override
	public VehicleType save(VehicleType type) {
		return vehicleTypeRapository.save(type);
	}

	@Override
	public VehicleType findByVehicleTypeId(int idVehicleType) {
		return VehicleTypeMapper.entityToDomain(vehicleTypeRapository.findByIdVehicleType(idVehicleType));
	}
}
