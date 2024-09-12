package co.edu.unbosque.util.exception;

public class NotValidEvenNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotValidEvenNumberException() {
		super("El numero no es par");
	}
}
