package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleEntity;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleRepositoryJPA extends JpaRepository<VehicleEntity, String>{
	

}