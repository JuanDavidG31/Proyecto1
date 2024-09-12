package co.edu.unbosque.util.exception;

public class IdentificationNotValidException extends Exception {
	private static final long serialVersionUID = 1L;

	public IdentificationNotValidException() {
		super("Los numeros de identificacion no tienen simbolos diferentes a numeros");
	}

}
