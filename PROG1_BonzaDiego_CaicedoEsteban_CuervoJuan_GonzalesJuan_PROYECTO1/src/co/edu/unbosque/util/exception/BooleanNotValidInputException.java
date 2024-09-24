package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se recibe una entrada de tipo booleano que no es válida.
 * 
 * Esta excepción indica que la entrada debe ser "si" o "no".
 */
public class BooleanNotValidInputException extends Exception {

    /**
     * Constructor por defecto que inicializa la excepción con un mensaje predeterminado.
     */
    public BooleanNotValidInputException() {
        super("La entrada de booleano no puede ser diferente a 'si' o a 'no'");
    }
}
