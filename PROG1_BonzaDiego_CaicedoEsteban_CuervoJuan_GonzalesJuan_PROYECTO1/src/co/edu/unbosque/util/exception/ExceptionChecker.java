package co.edu.unbosque.util.exception;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void CheckNegativeNumer(int numero) throws NegativeNumberException {
		if (numero < 0) {
			throw new NegativeNumberException();
		}
	}

	public static void IdentificationNotValidNumber(int number) throws IdentificationNotValidException {
		Pattern p = Pattern.compile("[^0-9]"); 
		Matcher m = p.matcher(Integer.toString(number));
		if (m.find()) {
			throw new IdentificationNotValidException();
		}
	}

	public static void NameNotValid(String nombre) throws NameNotValidException {
		Pattern p = Pattern.compile("[^a-zA-Z 6]"); 
		Matcher m = p.matcher(nombre);
		if (m.find()) {
			throw new NameNotValidException();
		}
	}
	
	public static void NotValidOddNumber(int numero) throws NotValidOddNumberException {
		if(numero%2 == 0) {
			throw new NotValidOddNumberException();
		}
	}
	
	public static void NotValidEvenNumber(int numero) throws NotValidEvenNumberException {
		if(numero%2 != 0) {
			throw new NotValidEvenNumberException();
		}
	}


}
