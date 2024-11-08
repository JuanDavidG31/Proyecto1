package co.edu.unbosque.util.exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionChecker {

	public static void dateException(Date fecha) throws DateFormatNotValidException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fechaComoTexto = formato.format(fecha);
		String patronFecha = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
		Pattern pattern = Pattern.compile(patronFecha);
		Matcher matcher = pattern.matcher(fechaComoTexto);

		if (!matcher.find()) {
			throw new DateFormatNotValidException();
		}

		formato.setLenient(false);

		try {
			formato.parse(fechaComoTexto);
		} catch (ParseException e) {
			throw new DateFormatNotValidException();
		}
	}

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
		Pattern p = Pattern.compile("[^a-zA-Z ]");
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
