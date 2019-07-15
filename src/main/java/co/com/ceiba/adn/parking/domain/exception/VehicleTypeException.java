package co.com.ceiba.adn.parking.domain.exception;

public class VehicleTypeException extends RuntimeException {

	private static final long serialVersionUID = -2543098941823417639L;

	public VehicleTypeException(String errorVehicleType) {
		super(errorVehicleType);
	}

}
