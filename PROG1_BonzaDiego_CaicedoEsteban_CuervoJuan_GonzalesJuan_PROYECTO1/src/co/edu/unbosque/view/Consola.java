/**
 * La clase Consola proporciona métodos para interactuar con el usuario a través de la consola.
 * Incluye métodos para leer diferentes tipos de datos como enteros, cadenas, booleanos, y números de punto flotante.
 */
package co.edu.unbosque.view;

import java.util.Scanner;

public class Consola {
    private Scanner sc;

    /**
     * Constructor que inicializa el objeto Scanner para la lectura desde la consola.
     */
    public Consola() {
        sc = new Scanner(System.in);
    }

    /**
     * Lee un número entero ingresado por el usuario.
     * 
     * @return el número entero leído.
     */
    public int leerEntero() {
        return sc.nextInt();
    }

    /**
     * Lee un número de tipo long ingresado por el usuario.
     * 
     * @return el número de tipo long leído.
     */
    public long leerLong() {
        return sc.nextLong();
    }

    /**
     * Lee un número de tipo double ingresado por el usuario.
     * 
     * @return el número de tipo double leído.
     */
    public double leerDouble() {
        return sc.nextDouble();
    }

    /**
     * Lee un número de tipo float ingresado por el usuario.
     * 
     * @return el número de tipo float leído.
     */
    public float leerFloat() {
        return sc.nextFloat();
    }

    /**
     * Lee una línea de texto completa ingresada por el usuario.
     * 
     * @return la línea de texto leída.
     */
    public String leerLinea() {
        return sc.nextLine();
    }

    /**
     * Lee una palabra ingresada por el usuario.
     * 
     * @return la palabra leída.
     */
    public String leerPalabra() {
        return sc.next();
    }

    /**
     * Lee una respuesta de tipo booleano ("si" o "no") ingresada por el usuario.
     * 
     * @return true si la entrada es "si", false si la entrada es "no".
     */
    public boolean leerBoolean() {
        String lectura = sc.next();
        if (lectura.toLowerCase().equals("si")) {
            return true;
        } else if (lectura.toLowerCase().equals("no")) {
            return false;
        }
        return false;
    }

    /**
     * Consume la línea actual de entrada para evitar errores en las lecturas de la consola.
     */
    public void quemarLinea() {
        sc.nextLine();
    }

    /**
     * Imprime un texto en la consola seguido de un salto de línea.
     * 
     * @param texto El texto a imprimir.
     */
    public void imprimirConSalto(String texto) {
        System.out.println(texto);
    }

    /**
     * Imprime un texto en la consola sin un salto de línea.
     * 
     * @param texto El texto a imprimir.
     */
    public void imprimirSinSalto(String texto) {
        System.out.print(texto);
    }
}