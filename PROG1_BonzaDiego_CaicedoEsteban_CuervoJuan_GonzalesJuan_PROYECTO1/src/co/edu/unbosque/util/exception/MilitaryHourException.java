package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se proporciona una hora que no está en formato militar.
 * 
 * <p>
 * Esta clase extiende {@link Exception} y proporciona un mensaje de error 
 * predeterminado que indica que la hora debe estar en formato militar (2400).
 * </p>
 */
public class MilitaryHourException extends Exception {
    
    /**
     * Constructor por defecto de la excepción MilitaryHourException.
     * 
     * <p>
     * Este constructor llama al constructor de la superclase 
     * {@link Exception} con un mensaje predeterminado que indica 
     * que la hora debe estar en formato militar 2400.
     * </p>
     */
    public MilitaryHourException() {
        super("La hora debe estar en formato militar 2400");
    }
}
