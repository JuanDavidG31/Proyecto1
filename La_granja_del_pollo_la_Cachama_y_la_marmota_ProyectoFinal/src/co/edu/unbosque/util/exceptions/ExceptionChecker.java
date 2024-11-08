package co.edu.unbosque.util.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {
	public static void IdentificationNotValidNumber(int number) throws IdentificationNotValidException {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(Integer.toString(number));
		if (m.find()) {
			throw new IdentificationNotValidException();
		}
	}
}
