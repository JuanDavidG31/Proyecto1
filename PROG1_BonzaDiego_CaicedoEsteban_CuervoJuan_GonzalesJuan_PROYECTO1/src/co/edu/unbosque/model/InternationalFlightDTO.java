package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase InternationalFlightDTO representa un vuelo internacional en formato 
 * Data Transfer Object (DTO). Extiende de la clase {@link Flight} e implementa 
 * la interfaz {@link Serializable} para permitir la transferencia eficiente de 
 * datos entre capas de la aplicación.
 * <p>
 * Esta clase incluye un atributo adicional {@code isVisa} que indica si se 
 * requiere visa para el vuelo. Es usada para transportar solo datos, sin lógica adicional.
 * </p>
 */
public class InternationalFlightDTO extends Flight implements Serializable {
    /**
     * El identificador de versión de la clase, utilizado en la serialización.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Indica si se requiere visa para el vuelo internacional.
     */
    private boolean isVisa;

    /**
     * Constructor vacío de la clase InternationalFlightDTO.
     */
    public InternationalFlightDTO() {
        // Constructor vacío por defecto.
    }

    /**
     * Constructor que inicializa el atributo {@code isVisa}.
     * 
     * @param isVisa indica si se requiere visa para el vuelo.
     */
    public InternationalFlightDTO(boolean isVisa) {
        super();
        this.isVisa = isVisa;
    }

    /**
     * Constructor que inicializa todos los atributos de InternationalFlightDTO, 
     * incluidos los atributos heredados de la clase {@link Flight}.
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
     * @param isVisa                 indica si se requiere visa para el vuelo.
     */
    public InternationalFlightDTO(String companyName, int passengersNumber, String nameCaptain,
                                  String nameSecondCommand, int departureTime, int arrivalTime, int fuelWeight, int id,
                                  String departureDestination, String arrivalDestination, boolean isVisa) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
              departureDestination, arrivalDestination);
        this.isVisa = isVisa;
    }

    /**
     * Constructor que inicializa los atributos heredados de la clase {@link Flight}, 
     * sin inicializar el atributo {@code isVisa}.
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
    public InternationalFlightDTO(String companyName, int passengersNumber, String nameCaptain,
                                  String nameSecondCommand, int departureTime, int arrivalTime, int fuelWeight, int id,
                                  String departureDestination, String arrivalDestination) {
        super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
              departureDestination, arrivalDestination);
    }

    /**
     * Obtiene si el vuelo internacional requiere visa.
     * 
     * @return {@code true} si el vuelo requiere visa, de lo contrario {@code false}.
     */
    public boolean isVisa() {
        return isVisa;
    }

    /**
     * Establece si el vuelo internacional requiere visa.
     * 
     * @param isVisa el valor booleano que indica si se requiere visa.
     */
    public void setVisa(boolean isVisa) {
        this.isVisa = isVisa;
    }

    /**
     * Devuelve una representación en cadena del objeto InternationalFlightDTO.
     * 
     * @return una cadena que contiene los detalles del vuelo internacional DTO, 
     * incluidos los detalles de la clase padre y el atributo {@code isVisa}.
     */
    @Override
    public String toString() {
        return super.toString() + "InternationalFlightDTO [isVisa=" + isVisa + "]";
    }
}

