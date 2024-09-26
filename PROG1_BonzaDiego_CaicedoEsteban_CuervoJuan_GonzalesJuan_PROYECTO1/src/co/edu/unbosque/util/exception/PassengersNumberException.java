/**
 * La clase PassengersNumberException es una excepción personalizada que se lanza
 * cuando el número de pasajeros es negativo. 
 */
package co.edu.unbosque.util.exception;

public class PassengersNumberException extends Exception {

    /**
     * Constructor que lanza una excepción con un mensaje por defecto.
     * El mensaje indica que el número de pasajeros no puede ser negativo.
     */
    public PassengersNumberException() {
        super("El número de pasajeros no puede ser negativo");
    }
}