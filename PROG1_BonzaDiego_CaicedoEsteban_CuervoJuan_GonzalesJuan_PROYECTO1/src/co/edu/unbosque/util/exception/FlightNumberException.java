/**
 * La clase FlightNumberException es una excepción personalizada que se lanza
 * cuando el número de identificación de un vuelo contiene caracteres no numéricos.
 */
package co.edu.unbosque.util.exception;

public class FlightNumberException extends Exception {

    /**
     * Constructor que lanza una excepción con un mensaje por defecto.
     * El mensaje indica que los números de identificación no deben contener símbolos
     * diferentes a números.
     */
    public FlightNumberException() {
        super("Los números de identificación no tienen símbolos diferentes a números");
    }
}