package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {
	
	
	/**
	 * Verifica si la entrada de booleano es válida.
	 *
	 * @param bo La entrada de tipo booleano como cadena.
	 * @throws BooleanNotValidInputException si la entrada no es "si" o "no".
	 */
	public static void BooleanNotValidInput(String bo) throws BooleanNotValidInputException {
		String f = bo.toLowerCase();
		if (!f.equals("si") && !f.equals("no")) {
			throw new BooleanNotValidInputException();
		}
	}

	public static void CheckNegativeNumer(int numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void IdentificationFlightNotValidNumber(String number) throws FlightNumberException {
		Pattern p = Pattern.compile("[^0-9]"); 
		Matcher m = p.matcher(number);
		if (m.find()) {
			throw new FlightNumberException();
		}
	}

	public static void NameNotValid(String nombre) throws NameNotValidException {
		Pattern p = Pattern.compile("[^a-zA-Z ]"); 
		Matcher m = p.matcher(nombre);
		if (m.find()) {
			throw new NameNotValidException();
		}
	}
	public static void PassengersNotValidNumber(String number) throws PassengersNumberException {
		Pattern p = Pattern.compile("[^0-9]"); 
		Matcher m = p.matcher(number);
		if (m.find()) {
			throw new PassengersNumberException();
		}
	}
	


}
