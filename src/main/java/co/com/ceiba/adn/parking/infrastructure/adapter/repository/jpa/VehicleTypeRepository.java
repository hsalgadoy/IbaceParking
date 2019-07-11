package co.com.ceiba.adn.parking.infrastructure.adapter.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.ceiba.adn.parking.infrastructure.adapter.entity.VehicleTypeEntity;
/**
 * 
 * @author hsneider.salgado
 *
 */
@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleTypeEntity, Integer>{

}
