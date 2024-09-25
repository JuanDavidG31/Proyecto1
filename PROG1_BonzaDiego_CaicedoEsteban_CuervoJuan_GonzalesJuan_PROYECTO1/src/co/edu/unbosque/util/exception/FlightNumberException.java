package co.edu.unbosque.util.exception;

public class FlightNumberException extends Exception {

	public FlightNumberException() {
		super("Los datos no pueden tienen simbolos diferentes a numeros");
	}

}
