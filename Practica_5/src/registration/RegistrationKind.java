package registration;

/**
 * 
 * Clase enum que representa los tipos de registro posibles
 * @author Alejandro López Martínez y Sofía García Héras
 * 
*/
public enum RegistrationKind {
	FULL (1100), MEMBER (900), STUDENT (450);

	private final int price;
	/**
	 * Constructor de la clase RegistrationKind
	 * @param price Precio del registro
	 */
	RegistrationKind(int price) {
		this.price = price;
	}
	/**
	 * Método que devuelve el precio del registro
	 * @return Precio del registro
	 */
	public double getPrice() {
		return this.price;
	}	
}
