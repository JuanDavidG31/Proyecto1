/**
 * Paquete que contiene las clases del modelo para el sistema de vuelos.
 */
package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * Representa un vuelo internacional en el sistema de vuelos.
 * Esta clase extiende {@link Flight} e implementa {@link Serializable}.
 * Incluye atributos adicionales específicos de los vuelos internacionales, como
 * si se requiere visa para los pasajeros.
 * 
 * <p> La clase proporciona constructores para crear instancias con y sin el
 * requisito de visa, así como métodos para acceder y modificar el atributo de
 * la visa.
 * </p>
 * 
 * <p>
 * Ejemplo de uso:
 * <pre>
 * {@code
 * InternationalFlight vuelo = new InternationalFlight("Aerolínea", 200, "John Doe", "Jane Smith", 800, 1100, 5000, 1, "Nueva York", "París", true);
 * System.out.println(vuelo);
 * }
 * </pre>
 * </p>
 * 
 * @see Flight
 * @see Serializable
 */
public class InternationalFlight extends Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Indica si se requiere una visa para el vuelo internacional.
     */
    private boolean isVisa;

    /**
     * Constructor por defecto que crea una instancia de {@code InternationalFlight}.
     */
    public InternationalFlight() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que crea una instancia de {@code InternationalFlight} con el atributo de visa.
     * 
     * @param isVisa Indica si el vuelo requiere una visa.
     */
    public InternationalFlight(boolean isVisa) {
        super();
        this.isVisa = isVisa;
    }

    /**
     * Constructor que crea una instancia de {@code InternationalFlight} con todos los atributos del vuelo y el requisito de visa.
     * 
     * @param companyName Nombre de la compañía aérea.
     * @param passengersNumber Número de pasajeros.
     * @param nameCaptain Nombre del capitán.
     * @param nameSecondCommand Nombre del segundo al mando.
     * @param departureTime Hora de salida.
     * @param arrivalTime Hora de llegada.
     * @param fuelWeight Peso del combustible.
     * @param id Identificador del vuelo.
     * @param departureDestination Destino de salida.
     * @param arrivalDestination Destino de llegada.
     * @param isVisa Indica si se requiere visa.
     */
    public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
            int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
            String arrivalDestination, boolean isVisa) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
                departureDestination, arrivalDestination);
        this.isVisa = isVisa;
    }

    /**
     * Constructor que crea una instancia de {@code InternationalFlight} sin el requisito de visa.
     * 
     * @param companyName Nombre de la compañía aérea.
     * @param passengersNumber Número de pasajeros.
     * @param nameCaptain Nombre del capitán.
     * @param nameSecondCommand Nombre del segundo al mando.
     * @param departureTime Hora de salida.
     * @param arrivalTime Hora de llegada.
     * @param fuelWeight Peso del combustible.
     * @param id Identificador del vuelo.
     * @param departureDestination Destino de salida.
     * @param arrivalDestination Destino de llegada.
     */
    public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
            int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
            String arrivalDestination) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
                departureDestination, arrivalDestination);
        // TODO Auto-generated constructor stub
    }

    /**
     * Devuelve si se requiere una visa para el vuelo internacional.
     * 
     * @return {@code true} si se requiere visa, {@code false} de lo contrario.
     */
    public boolean isVisa() {
        return isVisa;
    }

    /**
     * Establece si se requiere una visa para el vuelo internacional.
     * 
     * @param isVisa {@code true} si se requiere visa, {@code false} de lo contrario.
     */
    public void setVisa(boolean isVisa) {
        this.isVisa = isVisa;
    }

    /**
     * Devuelve una representación en cadena de texto del vuelo internacional, incluyendo el estado de la visa.
     * 
     * @return Cadena de texto que representa el vuelo internacional.
     */
    @Override
    public String toString() {
        return super.toString() + "InternationalFlight [isVisa=" + isVisa + "]";
    }
}

