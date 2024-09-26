package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InternationalFlight;
import co.edu.unbosque.model.InternationalFlightDTO;

public class InternationalFlightDAO implements CRUDOperation<InternationalFlightDTO, InternationalFlight> {
	private ArrayList<InternationalFlight> listaInternationalFlight;
	private final String FILE_NAME = "InternationalFlight.csv";
	private final String SERIAL_NAME = "InternationalFlight.dat";

	public InternationalFlightDAO() {
		// listaInternationalFlight = new ArrayList<>();
		FileHandler.checkFolder();
		readSerilized();
	}

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

	@Override
	public ArrayList<InternationalFlightDTO> getAll() {
		return DataMapper.listaInternationalFlightToListaInternationalFlightDTO(listaInternationalFlight);

	}

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

	public void writeFile() {
		String content = "";
		for (InternationalFlight m : listaInternationalFlight) {
			content += m.getId() + ";";
			content += m.getCompanyName() + ";";
			content += m.getDepartureTime() + ";";
			content += m.getArrivalTime() + ";";
			content += m.getNameCaptain() + ";";
			content += m.getNameSecondCommand() + ";";
			content += m.getPassengersNumber() + ";";
			content += m.getFuelWeight() + ";";
			content += m.isVisa() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public ArrayList<InternationalFlight> getListaInternationalFlight() {
		return listaInternationalFlight;
	}

	public void setListaInternationalFlight(ArrayList<InternationalFlight> listaInternationalFlight) {
		this.listaInternationalFlight = listaInternationalFlight;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaInternationalFlight);
	}

	public void readSerilized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaInternationalFlight = new ArrayList<>();
		} else {
			listaInternationalFlight = (ArrayList<InternationalFlight>) content;

		}
	}

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
