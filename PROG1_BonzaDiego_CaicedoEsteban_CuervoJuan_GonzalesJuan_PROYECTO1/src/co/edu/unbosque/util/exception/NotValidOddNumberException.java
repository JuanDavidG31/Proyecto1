package co.edu.unbosque.util.exception;

public class NotValidOddNumberException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotValidOddNumberException() {
		super("El numero no es un impar");
	}
}
