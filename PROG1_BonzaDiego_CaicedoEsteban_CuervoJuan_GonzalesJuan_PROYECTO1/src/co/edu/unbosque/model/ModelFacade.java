package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.InternationalFlightDAO;
import co.edu.unbosque.model.persistence.NationalFlightDAO;

/**
 * La clase ModelFacade actúa como un intermediario (fachada) entre las operaciones del modelo 
 * y otras capas de la aplicación, proporcionando acceso a los DAOs de vuelos internacionales 
 * y nacionales. 
 * 
 * <p>Facilita la interacción con los objetos de datos sin que otras partes de la aplicación necesiten 
 * conocer los detalles internos de la implementación.</p>
 * 
 * @version 1.0
 */
public class ModelFacade {
    
    /**
     * Objeto DAO para gestionar los datos de vuelos internacionales.
     */
    private InternationalFlightDAO international;

    /**
     * Objeto DAO para gestionar los datos de vuelos nacionales.
     */
    private NationalFlightDAO national;

    /**
     * Constructor por defecto que inicializa los DAOs de vuelos internacionales y nacionales.
     */
    public ModelFacade() {
        international = new InternationalFlightDAO();
        national = new NationalFlightDAO();
    }

    /**
     * Obtiene el DAO de vuelos internacionales.
     * 
     * @return Objeto InternationalFlightDAO que gestiona los vuelos internacionales.
     */
    public InternationalFlightDAO getInternational() {
        return international;
    }

    /**
     * Establece el DAO de vuelos internacionales.
     * 
     * @param international El nuevo objeto InternationalFlightDAO a establecer.
     */
    public void setInternational(InternationalFlightDAO international) {
        this.international = international;
    }

    /**
     * Obtiene el DAO de vuelos nacionales.
     * 
     * @return Objeto NationalFlightDAO que gestiona los vuelos nacionales.
     */
    public NationalFlightDAO getNational() {
        return national;
    }

    /**
     * Establece el DAO de vuelos nacionales.
     * 
     * @param national El nuevo objeto NationalFlightDAO a establecer.
     */
    public void setNational(NationalFlightDAO national) {
        this.national = national;
    }

}