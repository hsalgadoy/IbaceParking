package co.com.ceiba.adn.parking.domain.model;


import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author hsneider.salgado
 *
 */
public enum VehicleTypeEnum {
	
	MOTORBYKE(500F,4000F, 10),
	CAR(1000F,8000F,20);
	//variables for enum type car
	@Getter
	@Setter
	private float hourPrice;
	@Getter
	@Setter
	private float dayPrice;
	// max quantity on parking for each type
	@Getter
	@Setter
	private int maxQuantity;
	
	private VehicleTypeEnum(float hourPrice, float dayPrice, int maxQuantity) {
		this.hourPrice = hourPrice;
		this.dayPrice = dayPrice;
		this.maxQuantity = maxQuantity;
	}
}
