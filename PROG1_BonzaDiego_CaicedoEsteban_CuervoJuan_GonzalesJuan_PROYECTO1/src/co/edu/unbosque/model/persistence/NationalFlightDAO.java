package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;

/**
 * La clase NationalFlightDAO implementa las operaciones CRUD (Crear, Leer, Actualizar, Borrar) 
 * para la gestión de vuelos nacionales en el sistema. Maneja la persistencia de datos, 
 * permitiendo guardar los vuelos en archivos CSV y archivos serializados.
 * 
 */
public class NationalFlightDAO implements CRUDOperation<NationalFlightDTO, NationalFlight> {
    private ArrayList<NationalFlight> listaNationalFlight;
    private final String FILE_NAME = "nationalFlight.csv"; // Nombre del archivo CSV para almacenar datos
    private final String SERIAL_NAME = "nationalFlight.dat"; // Nombre del archivo serializado para almacenar datos

    /**
     * Constructor de la clase NationalFlightDAO.
     * Inicializa la lista de vuelos nacionales y verifica la existencia de la carpeta de archivos.
     */
    public NationalFlightDAO() {
        FileHandler.checkFolder(); // Verifica o crea la carpeta necesaria para almacenar archivos
        readSerilized(); // Lee los datos serializados si existen
    }

    /**
     * Muestra todos los vuelos nacionales en la lista.
     * 
     * @return una cadena con todos los vuelos nacionales o un mensaje si la lista está vacía.
     */
    @Override
    public String showAll() {
        String rta = "";
        if (listaNationalFlight.isEmpty()) {
            return "No hay Users en la lista"; // Mensaje si no hay vuelos
        } else {
            for (NationalFlight user : listaNationalFlight) {
                rta += user;
            }
            return rta;
        }
    }

    /**
     * Devuelve una lista de objetos NationalFlightDTO que representan todos los vuelos nacionales.
     * 
     * @return una lista de objetos NationalFlightDTO.
     */
    @Override
    public ArrayList<NationalFlightDTO> getAll() {
        return DataMapper.listaNationalFlightToListaNationalFlightDTO(listaNationalFlight);
    }

    /**
     * Agrega un nuevo vuelo nacional a la lista, si no existe previamente.
     * 
     * @param newData el objeto NationalFlightDTO que representa el nuevo vuelo a agregar.
     * @return true si el vuelo fue agregado exitosamente, false si ya existía.
     */
    @Override
    public boolean add(NationalFlightDTO newData) {
        if (find(DataMapper.NationalFlightDTOToNationalFlight(newData)) == null) {
            listaNationalFlight.add(DataMapper.NationalFlightDTOToNationalFlight(newData));
            writeFile();
            writeSerialized();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Elimina un vuelo nacional de la lista.
     * 
     * @param toDelete el objeto NationalFlightDTO que representa el vuelo a eliminar.
     * @return true si el vuelo fue eliminado, false si no se encontró.
     */
    @Override
    public boolean delete(NationalFlightDTO toDelete) {
        NationalFlight found = find(DataMapper.NationalFlightDTOToNationalFlight(toDelete));
        if (found != null) {
            listaNationalFlight.remove(found);
            writeFile();
            writeSerialized();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un vuelo nacional en la lista por su ID.
     * 
     * @param toFind el objeto NationalFlight a buscar.
     * @return el vuelo nacional si fue encontrado, o null si no se encuentra.
     */
    @Override
    public NationalFlight find(NationalFlight toFind) {

		NationalFlight found = null;
		if (!listaNationalFlight.isEmpty()) {
			for (NationalFlight NationalFlight : listaNationalFlight) {
				if (NationalFlight.getId() == toFind.getId()) {
					found = NationalFlight;
					return found;
				} else {
					continue;
				}
			}
		} else {
			return null;
		}
		return null;
	}

    /**
     * Actualiza un vuelo nacional en la lista.
     * 
     * @param previous el objeto NationalFlightDTO que representa el vuelo previo.
     * @param newData el objeto NationalFlightDTO que contiene los nuevos datos.
     * @return true si el vuelo fue actualizado, false si no se encontró.
     */
    @Override
	public boolean update(NationalFlightDTO previous, NationalFlightDTO newData) {
		NationalFlight found = find(DataMapper.NationalFlightDTOToNationalFlight(previous));
		if (found != null) {
			listaNationalFlight.remove(found);
			listaNationalFlight.add(DataMapper.NationalFlightDTOToNationalFlight(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

    /**
     * Escribe los datos de los vuelos nacionales en un archivo CSV.
     */
    public void writeFile() {
		String content = "";
		for (NationalFlight m : listaNationalFlight) {
			content += m.getId() + ";";
			content += m.getCompanyName() + ";";
			content += m.getArrivalTime() + ";";
			content += m.getDepartureTime() + ";";
			content += m.getDepartureDestination() + ";";
			content += m.getArrivalDestination() + ";";
			content += m.getNameCaptain() + ";";
			content += m.getNameSecondCommand() + ";";
			content += m.getPassengersNumber() + ";";
			content += m.getFuelWeight() + ";";
			content += m.isTurbine() + ";";
			content += m.isTurboProp() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

    /**
     * Devuelve la lista de vuelos nacionales.
     * 
     * @return la lista de vuelos nacionales.
     */
    public ArrayList<NationalFlight> getListaNationalFlight() {
        return listaNationalFlight;
    }

    /**
     * Establece la lista de vuelos nacionales.
     * 
     * @param listaNationalFlight la lista de vuelos nacionales a establecer.
     */
    public void setListaNationalFlight(ArrayList<NationalFlight> listaNationalFlight) {
        this.listaNationalFlight = listaNationalFlight;
    }

    /**
     * Devuelve el nombre del archivo CSV donde se guardan los vuelos nacionales.
     * 
     * @return el nombre del archivo CSV.
     */
    public String getFILE_NAME() {
        return FILE_NAME;
    }

    /**
     * Escribe los datos de los vuelos nacionales en un archivo serializado.
     */
    public void writeSerialized() {
        FileHandler.writerSerialized(SERIAL_NAME, listaNationalFlight);
    }

    /**
     * Lee los datos de los vuelos nacionales desde un archivo serializado.
     */
    public void readSerilized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaNationalFlight = new ArrayList<>();
		} else {
			listaNationalFlight = (ArrayList<NationalFlight>) content;

		}
	}

    /**
     * Método find2 pendiente de implementación.
     * 
     * @param toFind el objeto NationalFlight a buscar.
     * @return null por defecto.
     */
    @Override
    public NationalFlight find2(NationalFlight toFind) {
        // TODO Auto-generated method stub
        return null;
    }
}

