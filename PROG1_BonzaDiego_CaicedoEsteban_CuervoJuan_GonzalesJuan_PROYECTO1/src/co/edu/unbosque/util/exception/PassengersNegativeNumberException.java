package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se intenta establecer un número negativo de pasajeros.
 * 
 * <p>
 * Esta clase extiende {@link Exception} y proporciona un mensaje de error 
 * predeterminado que indica que el número de pasajeros no puede ser negativo.
 * </p>
 * 
 */
public class PassengersNegativeNumberException extends Exception {
    
    /**
     * Constructor por defecto de la excepción PassengersNegativeNumberException.
     * 
     * <p>
     * Este constructor llama al constructor de la superclase 
     * {@link Exception} con un mensaje predeterminado que indica 
     * que el número de pasajeros no puede ser negativo.
     * </p>
     */
    public PassengersNegativeNumberException() {
        super("El número de pasajeros no puede ser negativo");
    }
}
