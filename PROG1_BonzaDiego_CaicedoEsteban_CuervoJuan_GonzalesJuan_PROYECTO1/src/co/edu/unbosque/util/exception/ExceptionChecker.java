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

	public static void checkNegativeTime(int numero) throws CheckNegativeTime {
		if (numero < 0) {
			throw new CheckNegativeTime();
		}
	}

	public static void NotValidNumber(String number) throws FlightNumberException {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(number);
		if (m.find()) {
			throw new FlightNumberException();
		}
	}

	public static void PassengersNotValidNumber(String number) throws PassengersNumberException {
		int numero = Integer.parseInt(number);
		if (numero > 300) {
			throw new PassengersNumberException();

		}

	}

	public static void PassengersNegativeNumber(String number) throws PassengersNegativeNumberException {
		int numero = Integer.parseInt(number);
		if (numero < 0) {
			throw new PassengersNegativeNumberException();
		}
	}

	public static void MilitaryHour(int time) throws MilitaryHourException {
		if (time > 2400) {
			throw new MilitaryHourException();
		}
	}
}
