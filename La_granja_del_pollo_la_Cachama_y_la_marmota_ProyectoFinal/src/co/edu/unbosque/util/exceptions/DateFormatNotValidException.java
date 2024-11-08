package co.edu.unbosque.util.exceptions;

public class DateFormatNotValidException extends Exception {


	private static final long serialVersionUID = 1L;
	
	public DateFormatNotValidException() {
		super ("La fecha no puede contener caracteres especiales y tiene que estar en el formato dd/MM/yyy");
	}

}
