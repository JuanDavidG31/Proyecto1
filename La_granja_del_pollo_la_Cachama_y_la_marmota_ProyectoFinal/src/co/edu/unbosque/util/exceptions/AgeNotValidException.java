package co.edu.unbosque.util.exceptions;

public class AgeNotValidException extends Exception {


	private static final long serialVersionUID = 1L;
	
	public AgeNotValidException() {
		super("La edad no tienen simbolos diferentes a numeros");
	}

}
