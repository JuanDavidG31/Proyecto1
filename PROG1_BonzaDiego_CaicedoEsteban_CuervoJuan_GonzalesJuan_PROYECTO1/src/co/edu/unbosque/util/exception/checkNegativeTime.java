package co.edu.unbosque.util.exception;

public class CheckNegativeTime extends Exception{
	private static final long serialVersionUID = 1L;

	public CheckNegativeTime() {
		super("La hora no puede ser negativa");
	}

}
