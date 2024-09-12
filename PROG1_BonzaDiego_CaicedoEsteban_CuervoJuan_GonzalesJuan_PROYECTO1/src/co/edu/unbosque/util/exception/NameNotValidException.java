package co.edu.unbosque.util.exception;

public class NameNotValidException extends Exception {
	

	public NameNotValidException() {
		super("Los nombres solo pueden tener letras y espacios");
	}

}
