package co.edu.unbosque.util.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase ExceptionChecker. Proporciona varios métodos para validar diferentes
 * tipos de entradas y lanza excepciones personalizadas cuando los datos no
 * cumplen con los criterios esperados.
 * 
 * @autor (Tu nombre)
 * @version 1.0
 */
public class ExceptionChecker {

	/**
	 * Verifica si el valor booleano de entrada es válido (debe ser "si" o "no"). Si
	 * el valor no es válido, lanza la excepción BooleanNotValidInputException.
	 * 
	 * @param bo la entrada booleana en formato de cadena
	 * @throws BooleanNotValidInputException si la entrada no es "si" o "no"
	 */
	public static void BooleanNotValidInput(String bo) throws BooleanNotValidInputException {
		String f = bo.toLowerCase();
		if (!f.equals("si") && !f.equals("no")) {
			throw new BooleanNotValidInputException();
		}
	}

	/**
	 * Verifica si un número de tiempo es negativo. Si el número es negativo, lanza
	 * la excepción CheckNegativeTime.
	 * 
	 * @param numero el valor del tiempo en formato entero
	 * @throws CheckNegativeTime si el número es negativo
	 */
	public static void checkNegativeTime(int numero) throws CheckNegativeTime {
		if (numero < 0) {
			throw new CheckNegativeTime();
		}
	}

	/**
	 * Verifica si el número de vuelo contiene caracteres no numéricos. Si se
	 * encuentra un carácter no numérico, lanza la excepción FlightNumberException.
	 * 
	 * @param number el número de vuelo en formato de cadena
	 * @throws FlightNumberException si la cadena contiene caracteres no numéricos
	 */
	public static void NotValidNumber(String number) throws FlightNumberException {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(number);
		if (m.find()) {
			throw new FlightNumberException();
		}
	}

	/**
	 * Verifica si el número de pasajeros es mayor a 300. Si el número es mayor a
	 * 300, lanza la excepción PassengersNumberException.
	 * 
	 * @param number el número de pasajeros en formato de cadena
	 * @throws PassengersNumberException si el número de pasajeros es mayor a 300
	 */
	public static void PassengersNotValidNumber(String number) throws PassengersNumberException {
		int numero = Integer.parseInt(number);
		if (numero > 300) {
			throw new PassengersNumberException();
		}
	}

	/**
	 * Verifica si el número de pasajeros es negativo. Si el número es negativo,
	 * lanza la excepción PassengersNegativeNumberException.
	 * 
	 * @param number el número de pasajeros en formato de cadena
	 * @throws PassengersNegativeNumberException si el número de pasajeros es
	 *                                           negativo
	 */
	public static void PassengersNegativeNumber(String number) throws PassengersNegativeNumberException {
		int numero = Integer.parseInt(number);
		if (numero < 0) {
			throw new PassengersNegativeNumberException();
		}
	}

	/**
	 * Verifica si el tiempo proporcionado supera las 24 horas (formato militar). Si
	 * el valor es mayor a 2400, lanza la excepción MilitaryHourException.
	 * 
	 * @param time el tiempo en formato entero (formato militar)
	 * @throws MilitaryHourException si el tiempo es mayor a 2400
	 */
	public static void MilitaryHour(int time) throws MilitaryHourException {
		int hours = time / 100;
		int minutes = time % 100;

		if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59) {
			throw new MilitaryHourException();
		}
	}

}
