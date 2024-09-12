package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
	private Scanner sc;

	public Consola() {
		sc = new Scanner(System.in);
	}

	public int leerEntero() {
		return sc.nextInt();
	}

	public long leerLong() {
		return sc.nextLong();
	}

	public double leerDouble() {
		return sc.nextDouble();
	}

	public float leerFloat() {
		return sc.nextFloat();
	}

	public String leerLinea() {
		return sc.nextLine();
	}

	public String leerPalabra() {
		return sc.next();
	}

	public boolean leerBoolean() {
		String lectura = sc.next();
		if (lectura.toLowerCase().equals("si")) {
			return true;
		} else if (lectura.toLowerCase().equals("no")) {
			return false;
		}
		return false;
	}

	public void quemarLinea() {
		sc.nextLine();
	}

	public void imprimirConSalto(String texto) {
		System.out.println(texto);
	}

	public void imprimirSinSalto(String text) {
		System.out.print(text);
	}
}
