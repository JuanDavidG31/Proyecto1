package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * La clase abstracta Flight representa un vuelo general con detalles
 * como el nombre de la compañía, número de pasajeros, miembros de la tripulación,
 * horarios y peso del combustible.
 * 
 * <p>Implementa la interfaz Serializable para permitir la serialización de objetos.
 * Esta clase sirve como base para diferentes tipos de vuelos, proporcionando
 * propiedades y métodos comunes.</p>
 * 
 */
public abstract class Flight implements Serializable {

    /**
     * Identificador de versión de la clase Flight. Se utiliza durante el proceso 
     * de deserialización para verificar la compatibilidad de versiones.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Nombre de la compañía aérea.
     */
    private String companyName;

    /**
     * Número de pasajeros a bordo.
     */
    private int passengersNumber;

    /**
     * Nombre del capitán del vuelo.
     */
    private String nameCaptain;

    /**
     * Nombre del segundo al mando.
     */
    private String nameSecondCommand;

    /**
     * Hora de salida del vuelo en formato de 24 horas (ej. 1300 para 1:00 PM).
     */
    private int departureTime;

    /**
     * Hora de llegada del vuelo en formato de 24 horas (ej. 1500 para 3:00 PM).
     */
    private int arrivalTime;

    /**
     * Peso del combustible en el vuelo (en kilogramos).
     */
    private int fuelWeight;

    /**
     * Identificador único del vuelo.
     */
    private int id;

    /**
     * Destino de salida del vuelo.
     */
    private String departureDestination;

    /**
     * Destino de llegada del vuelo.
     */
    private String arrivalDestination;

    /**
     * Constructor por defecto de la clase Flight.
     */
    public Flight() {
    }

    /**
     * Constructor que inicializa todos los atributos del vuelo.
     * 
     * @param companyName Nombre de la compañía aérea
     * @param passengersNumber Número de pasajeros a bordo
     * @param nameCaptain Nombre del capitán del vuelo
     * @param nameSecondCommand Nombre del segundo al mando
     * @param departureTime Hora de salida del vuelo
     * @param arrivalTime Hora de llegada del vuelo
     * @param fuelWeight Peso del combustible
     * @param id Identificador único del vuelo
     * @param departureDestination Destino de salida
     * @param arrivalDestination Destino de llegada
     */
    public Flight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
                  int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
                  String arrivalDestination) {
        this.companyName = companyName;
        this.passengersNumber = passengersNumber;
        this.nameCaptain = nameCaptain;
        this.nameSecondCommand = nameSecondCommand;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.fuelWeight = fuelWeight;
        this.id = id;
        this.departureDestination = departureDestination;
        this.arrivalDestination = arrivalDestination;
    }

    /**
     * Obtiene el nombre de la compañía aérea.
     * 
     * @return Nombre de la compañía aérea
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Establece el nombre de la compañía aérea.
     * 
     * @param companyName Nombre de la compañía aérea
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Obtiene el número de pasajeros a bordo.
     * 
     * @return Número de pasajeros
     */
    public int getPassengersNumber() {
        return passengersNumber;
    }

    /**
     * Establece el número de pasajeros a bordo.
     * 
     * @param passengersNumber Número de pasajeros
     */
    public void setPassengersNumber(int passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    /**
     * Obtiene el nombre del capitán del vuelo.
     * 
     * @return Nombre del capitán
     */
    public String getNameCaptain() {
        return nameCaptain;
    }

    /**
     * Establece el nombre del capitán del vuelo.
     * 
     * @param nameCaptain Nombre del capitán
     */
    public void setNameCaptain(String nameCaptain) {
        this.nameCaptain = nameCaptain;
    }

    /**
     * Obtiene el nombre del segundo al mando.
     * 
     * @return Nombre del segundo al mando
     */
    public String getNameSecondCommand() {
        return nameSecondCommand;
    }

    /**
     * Establece el nombre del segundo al mando.
     * 
     * @param nameSecondCommand Nombre del segundo al mando
     */
    public void setNameSecondCommand(String nameSecondCommand) {
        this.nameSecondCommand = nameSecondCommand;
    }

    /**
     * Obtiene la hora de salida del vuelo.
     * 
     * @return Hora de salida
     */
    public int getDepartureTime() {
        return departureTime;
    }

    /**
     * Establece la hora de salida del vuelo.
     * 
     * @param departureTime Hora de salida
     */
    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Obtiene la hora de llegada del vuelo.
     * 
     * @return Hora de llegada
     */
    public int getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Establece la hora de llegada del vuelo.
     * 
     * @param arrivalTime Hora de llegada
     */
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Obtiene el peso del combustible del vuelo.
     * 
     * @return Peso del combustible en kilogramos
     */
    public int getFuelWeight() {
        return fuelWeight;
    }

    /**
     * Establece el peso del combustible del vuelo.
     * 
     * @param fuelWeight Peso del combustible
     */
    public void setFuelWeight(int fuelWeight) {
        this.fuelWeight = fuelWeight;
    }

    /**
     * Obtiene el identificador único del vuelo.
     * 
     * @return Identificador del vuelo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del vuelo.
     * 
     * @param id Identificador del vuelo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el destino de salida del vuelo.
     * 
     * @return Destino de salida
     */
    public String getDepartureDestination() {
        return departureDestination;
    }

    /**
     * Establece el destino de salida del vuelo.
     * 
     * @param departureDestination Destino de salida
     */
    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    /**
     * Obtiene el destino de llegada del vuelo.
     * 
     * @return Destino de llegada
     */
    public String getArrivalDestination() {
        return arrivalDestination;
    }

    /**
     * Establece el destino de llegada del vuelo.
     * 
     * @param arrivalDestination Destino de llegada
     */
    public void setArrivalDestination(String arrivalDestination) {
        this.arrivalDestination = arrivalDestination;
    }

    /**
     * Devuelve una representación en cadena del vuelo.
     * 
     * @return Cadena de texto que describe el vuelo
     */
    @Override
    public String toString() {
        return "Flight [companyName=" + companyName + ", passengersNumber=" + passengersNumber + ", nameCaptain="
                + nameCaptain + ", nameSecondCommand=" + nameSecondCommand + ", departureTime=" + departureTime
                + ", arrivalTime=" + arrivalTime + ", fuelWeight=" + fuelWeight + ", id=" + id
                + ", departureDestination=" + departureDestination + ", arrivalDestination=" + arrivalDestination + "]";
    }
}
