package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase NationalFlightDTO representa la versión Data Transfer Object (DTO) de un vuelo nacional.
 * Hereda de la clase {@link Flight} e implementa la interfaz {@link Serializable}, permitiendo la 
 * transferencia de datos de manera eficiente entre capas de la aplicación.
 * <p>
 * Esta clase contiene atributos específicos de los vuelos nacionales, como si el avión tiene turbohélice 
 * o turbina. Se utiliza en situaciones donde solo se necesita transportar los datos sin la lógica adicional 
 * del modelo.
 * </p>
 */
public class NationalFlightDTO extends Flight implements Serializable {
    /**
     * El identificador de versión de la clase, utilizado en la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Indica si el vuelo nacional utiliza un avión con turbohélice.
     */
    private boolean isTurboProp;

    /**
     * Indica si el vuelo nacional utiliza un avión con turbina.
     */
    private boolean isTurbine;

    /**
     * Constructor vacío de la clase NationalFlightDTO.
     */
    public NationalFlightDTO() {

    }

    /**
     * Constructor que inicializa los atributos específicos de NationalFlightDTO.
     * 
     * @param isTurboProp   indica si el vuelo utiliza turbohélice.
     * @param isTurbine     indica si el vuelo utiliza turbina.
     */
    public NationalFlightDTO(boolean isTurboProp, boolean isTurbine) {
        super();
        this.isTurboProp = isTurboProp;
        this.isTurbine = isTurbine;
    }

    /**
     * Constructor que inicializa todos los atributos de NationalFlightDTO, incluidos los atributos
     * heredados de la clase {@link Flight}.
     * 
     * @param companyName            nombre de la compañía aérea.
     * @param passengersNumber       número de pasajeros.
     * @param nameCaptain            nombre del capitán.
     * @param nameSecondCommand      nombre del segundo al mando.
     * @param departureTime          hora de salida.
     * @param arrivalTime            hora de llegada.
     * @param fuelWeight             peso del combustible.
     * @param id                     identificador del vuelo.
     * @param departureDestination   destino de salida.
     * @param arrivalDestination     destino de llegada.
     * @param isTurboProp            indica si el vuelo utiliza turbohélice.
     * @param isTurbine              indica si el vuelo utiliza turbina.
     */
    public NationalFlightDTO(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
                             int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
                             String arrivalDestination, boolean isTurboProp, boolean isTurbine) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
                departureDestination, arrivalDestination);
        this.isTurboProp = isTurboProp;
        this.isTurbine = isTurbine;
    }

    /**
     * Constructor que inicializa los atributos heredados de la clase {@link Flight}, sin inicializar los atributos 
     * específicos de NationalFlightDTO.
     * 
     * @param companyName            nombre de la compañía aérea.
     * @param passengersNumber       número de pasajeros.
     * @param nameCaptain            nombre del capitán.
     * @param nameSecondCommand      nombre del segundo al mando.
     * @param departureTime          hora de salida.
     * @param arrivalTime            hora de llegada.
     * @param fuelWeight             peso del combustible.
     * @param id                     identificador del vuelo.
     * @param departureDestination   destino de salida.
     * @param arrivalDestination     destino de llegada.
     */
    public NationalFlightDTO(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
                             int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
                             String arrivalDestination) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
                departureDestination, arrivalDestination);
    }

    /**
     * Obtiene si el vuelo nacional utiliza un avión con turbohélice.
     * 
     * @return {@code true} si el avión tiene turbohélice, de lo contrario {@code false}.
     */
    public boolean isTurboProp() {
        return isTurboProp;
    }

    /**
     * Establece si el vuelo nacional utiliza un avión con turbohélice.
     * 
     * @param isTurboProp el valor booleano que indica si el avión tiene turbohélice.
     */
    public void setTurboProp(boolean isTurboProp) {
        this.isTurboProp = isTurboProp;
    }

    /**
     * Obtiene si el vuelo nacional utiliza un avión con turbina.
     * 
     * @return {@code true} si el avión tiene turbina, de lo contrario {@code false}.
     */
    public boolean isTurbine() {
        return isTurbine;
    }

    /**
     * Establece si el vuelo nacional utiliza un avión con turbina.
     * 
     * @param isTurbine el valor booleano que indica si el avión tiene turbina.
     */
    public void setTurbine(boolean isTurbine) {
        this.isTurbine = isTurbine;
    }

    /**
     * Devuelve una representación en cadena del objeto NationalFlightDTO.
     * 
     * @return una cadena que contiene los detalles del vuelo nacional DTO, incluidos los detalles de la clase
     *         padre y los atributos específicos de NationalFlightDTO.
     */
    @Override
    public String toString() {
        return super.toString() + "NationalFlightDTO [isTurboProp=" + isTurboProp + ", isTurbine=" + isTurbine + "]";
    }

}
