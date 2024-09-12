package co.edu.unbosque.util.exception;

public class NegativeNumberException extends Exception{
	private static final long serialVersionUID = 1L;

	public NegativeNumberException() {
		super("El numero no puede ser negativo");
	}

}
