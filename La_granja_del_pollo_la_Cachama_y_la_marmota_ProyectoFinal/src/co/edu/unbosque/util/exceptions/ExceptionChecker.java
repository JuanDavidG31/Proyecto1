package co.edu.unbosque.util.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {
	public static void IdentificationNotValidNumber(String number) throws IdentificationNotValidException {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(number);
		if (m.find()) {
			throw new IdentificationNotValidException();
		}
		if (number.length() < 5 || number.length() > 10) {
			throw new IdentificationNotValidException();
		}
	}

	public static void AgeNotValidNumber(String age) throws AgeNotValidException {
		Pattern p = Pattern.compile("[^0-9]");
		Matcher m = p.matcher(age);
		if (m.find()) {
			throw new AgeNotValidException();
		}
		int ageValue;
		try {
			ageValue = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			throw new AgeNotValidException();
		}

		if (ageValue < 0 || ageValue > 120) {
			throw new AgeNotValidException();
		}
	}

	public static void NameNotValid(String nombre) throws NameNotValidException {
		Pattern p = Pattern.compile("[^a-zA-Z 6]");
		Matcher m = p.matcher(nombre);
		if (m.find()) {
			throw new NameNotValidException();
		}
	}

	public static void checkEmail(String email) throws EmailNotValidException {
		String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new EmailNotValidException();
		}

	}
}
