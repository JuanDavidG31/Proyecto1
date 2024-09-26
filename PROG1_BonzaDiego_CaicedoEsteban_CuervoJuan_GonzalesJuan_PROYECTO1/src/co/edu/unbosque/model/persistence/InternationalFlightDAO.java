package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InternationalFlight;
import co.edu.unbosque.model.InternationalFlightDTO;

/**
 * La clase InternationalFlightDAO implementa las operaciones CRUD (Crear, Leer,
 * Actualizar, Borrar) para gestionar los vuelos internacionales en el sistema.
 * Maneja la persistencia de datos, permitiendo guardar los vuelos en archivos
 * CSV y archivos serializados.
 * 
 * @autor (Tu nombre)
 * @version 1.0
 */
public class InternationalFlightDAO implements CRUDOperation<InternationalFlightDTO, InternationalFlight> {
	private ArrayList<InternationalFlight> listaInternationalFlight;
	private final String FILE_NAME = "InternationalFlight.csv"; // Nombre del archivo CSV para almacenar datos
	private final String SERIAL_NAME = "InternationalFlight.dat"; // Nombre del archivo serializado para almacenar datos

	/**
	 * Constructor de la clase InternationalFlightDAO. Inicializa la lista de vuelos
	 * internacionales y verifica la existencia de la carpeta de archivos.
	 */
	public InternationalFlightDAO() {
		FileHandler.checkFolder(); // Verifica o crea la carpeta necesaria para almacenar archivos
		readSerilized(); // Lee los datos serializados si existen
	}

	/**
	 * Muestra todos los vuelos internacionales en la lista.
	 * 
	 * @return una cadena con todos los vuelos internacionales o un mensaje si la
	 *         lista está vacía.
	 */
	@Override
	public String showAll() {
		String rta = "";
		if (listaInternationalFlight.isEmpty()) {
			return "No hay InternationalFlights en la lista";
		} else {
			for (InternationalFlight InternationalFlight : listaInternationalFlight) {
				rta += InternationalFlight;
			}
			return rta;
		}
	}

	/**
	 * Devuelve una lista de objetos InternationalFlightDTO que representan todos
	 * los vuelos internacionales.
	 * 
	 * @return una lista de objetos InternationalFlightDTO.
	 */
	@Override
	public ArrayList<InternationalFlightDTO> getAll() {
		return DataMapper.listaInternationalFlightToListaInternationalFlightDTO(listaInternationalFlight);
	}

	/**
	 * Agrega un nuevo vuelo internacional a la lista, si no existe previamente.
	 * 
	 * @param newData el objeto InternationalFlightDTO que representa el nuevo vuelo
	 *                a agregar.
	 * @return true si el vuelo fue agregado exitosamente, false si ya existía.
	 */
	@Override
	public boolean add(InternationalFlightDTO newData) {
		if (find(DataMapper.InternationalFlightDTOToInternationalFlight(newData)) == null) {
			listaInternationalFlight.add(DataMapper.InternationalFlightDTOToInternationalFlight(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Elimina un vuelo internacional de la lista.
	 * 
	 * @param toDelete el objeto InternationalFlightDTO que representa el vuelo a
	 *                 eliminar.
	 * @return true si el vuelo fue eliminado, false si no se encontró.
	 */
	@Override
	public boolean delete(InternationalFlightDTO toDelete) {
		InternationalFlight found = find(DataMapper.InternationalFlightDTOToInternationalFlight(toDelete));
		if (found != null) {
			listaInternationalFlight.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Busca un vuelo internacional en la lista por su ID.
	 * 
	 * @param toFind el objeto InternationalFlight a buscar.
	 * @return el vuelo internacional si fue encontrado, o null si no se encuentra.
	 */
	@Override
	public InternationalFlight find(InternationalFlight toFind) {

		InternationalFlight found = null;
		if (!listaInternationalFlight.isEmpty()) {
			for (InternationalFlight InternationalFlight : listaInternationalFlight) {
				if (InternationalFlight.getId() == toFind.getId()) {
					found = InternationalFlight;
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
	 * Actualiza un vuelo internacional en la lista.
	 * 
	 * @param previous el objeto InternationalFlightDTO que representa el vuelo
	 *                 previo.
	 * @param newData  el objeto InternationalFlightDTO que contiene los nuevos
	 *                 datos.
	 * @return true si el vuelo fue actualizado, false si no se encontró.
	 */
	@Override
	public boolean update(InternationalFlightDTO previous, InternationalFlightDTO newData) {
		InternationalFlight found = find(DataMapper.InternationalFlightDTOToInternationalFlight(previous));
		if (found != null) {
			listaInternationalFlight.remove(found);
			listaInternationalFlight.add(DataMapper.InternationalFlightDTOToInternationalFlight(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Escribe los datos de los vuelos internacionales en un archivo CSV.
	 */
	public void writeFile() {
		String content = "";
		for (InternationalFlight m : listaInternationalFlight) {
			content += m.getId() + ";";
			content += m.getCompanyName() + ";";
			content += m.getDepartureTime() + ";";
			content += m.getArrivalTime() + ";";
			content += m.getDepartureDestination() + ";";
			content += m.getArrivalDestination() + ";";
			content += m.getNameCaptain() + ";";
			content += m.getNameSecondCommand() + ";";
			content += m.getPassengersNumber() + ";";
			content += m.getFuelWeight() + ";";
			content += m.isVisa() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	/**
	 * Devuelve la lista de vuelos internacionales.
	 * 
	 * @return la lista de vuelos internacionales.
	 */
	public ArrayList<InternationalFlight> getListaInternationalFlight() {
		return listaInternationalFlight;
	}

	/**
	 * Establece la lista de vuelos internacionales.
	 * 
	 * @param listaInternationalFlight la lista de vuelos internacionales a
	 *                                 establecer.
	 */
	public void setListaInternationalFlight(ArrayList<InternationalFlight> listaInternationalFlight) {
		this.listaInternationalFlight = listaInternationalFlight;
	}

	/**
	 * Devuelve el nombre del archivo CSV donde se guardan los vuelos
	 * internacionales.
	 * 
	 * @return el nombre del archivo CSV.
	 */
	public String getFILE_NAME() {
		return FILE_NAME;
	}

	/**
	 * Escribe los datos de los vuelos internacionales en un archivo serializado.
	 */
	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaInternationalFlight);
	}

	/**
	 * Lee los datos de los vuelos internacionales desde un archivo serializado.
	 */
	public void readSerilized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaInternationalFlight = new ArrayList<>();
		} else {
			listaInternationalFlight = (ArrayList<InternationalFlight>) content;

		}
	}

	/**
	 * Busca un vuelo internacional en la lista por su destino de llegada.
	 * 
	 * @param toFind el objeto InternationalFlight a buscar.
	 * @return el vuelo internacional si fue encontrado, o null si no se encuentra.
	 */
	@Override
	public InternationalFlight find2(InternationalFlight toFind) {
		InternationalFlight found = null;
		if (!listaInternationalFlight.isEmpty()) {
			for (InternationalFlight InternationalFlight : listaInternationalFlight) {
				if (InternationalFlight.getArrivalDestination().equals(toFind.getArrivalDestination())) {
					found = InternationalFlight;
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
}
