/**
 * Clase principal del sistema de vuelos. Esta clase inicia la ejecución del programa.
 * 
 * <p>La clase {@code AplMain} contiene el método {@code main} que crea una instancia del
 * controlador {@link Controller} para manejar la lógica del sistema de vuelos.
 * </p>
 * 
 * <p>
 * Ejemplo de uso:
 * <pre>
 * {@code
 * AplMain.main(new String[] {});
 * }
 * </pre>
 * </p>
 * 
 * @see Controller
 */
package co.edu.unbosque.controller;

public class AplMain {

    /**
     * Método principal que inicia la ejecución del programa.
     * 
     * @param args Los argumentos de línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        // Crea una instancia del controlador para manejar la lógica del sistema.
        Controller c = new Controller();
    }

}
