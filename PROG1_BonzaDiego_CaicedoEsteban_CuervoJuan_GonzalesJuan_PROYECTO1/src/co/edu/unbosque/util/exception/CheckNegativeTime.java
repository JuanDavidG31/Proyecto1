package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se intenta establecer un tiempo negativo.
 * 
 * <p>
 * Esta clase extiende {@link Exception} y proporciona un mensaje de error 
 * predeterminado que indica que la hora no puede ser negativa.
 * </p>
 */
public class CheckNegativeTime extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto de la excepción CheckNegativeTime.
     * 
     * <p>
     * Este constructor llama al constructor de la superclase 
     * {@link Exception} con un mensaje predeterminado que indica 
     * que la hora no puede ser negativa.
     * </p>
     */
    public CheckNegativeTime() {
        super("La hora no puede ser negativa");
    }
}
