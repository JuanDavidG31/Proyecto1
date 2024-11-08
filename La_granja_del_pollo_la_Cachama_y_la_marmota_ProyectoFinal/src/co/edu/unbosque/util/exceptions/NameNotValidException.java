package co.edu.unbosque.util.exceptions;

public class NameNotValidException extends Exception {
	private static final long serialVersionUID = 1L;

	public NameNotValidException() {
		super("Los nombres solo pueden tener letras y espacios");
	}

}
