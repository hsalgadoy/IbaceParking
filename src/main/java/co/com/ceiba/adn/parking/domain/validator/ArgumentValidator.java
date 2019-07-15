package co.com.ceiba.adn.parking.domain.validator;

import co.com.ceiba.adn.parking.domain.exception.ParkingException;
import lombok.Data;

/**
 * 
 * @author hsneider.salgado
 *
 */
@Data
public final class ArgumentValidator {

	private ArgumentValidator() {
		
	}
	
	public static void required(Object object, String warningMesage) {
		if (object == null)
			throw new ParkingException(warningMesage);
	}

	public static void greaterThanZeroValidation(int value, String warningMesage) {
		if (value > 0)
			throw new ParkingException(warningMesage);

	}
}
