package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InternationalFlight;
import co.edu.unbosque.model.InternationalFlightDTO;

public class InternationalFlightDAO implements CRUDOperation<InternationalFlightDTO, InternationalFlight>{
	private ArrayList<InternationalFlight> listaInternationalFlight;
	private final String FILE_NAME = "InternationalFlight.csv";

	public InternationalFlightDAO() {
		listaInternationalFlight = new ArrayList<>();
		FileHandler.checkFolder();
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
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(InternationalFlightDTO toDelete) {
		InternationalFlight found = find(DataMapper.InternationalFlightDTOToInternationalFlight(toDelete));
		if (found != null) {
			return listaInternationalFlight.remove(found);
		} else {
			return false;
		}
	}

	@Override
	public InternationalFlight find(InternationalFlight toFind) {

		InternationalFlight found = null;
		if (!listaInternationalFlight.isEmpty()) {
			for (InternationalFlight InternationalFlight : listaInternationalFlight) {
				if (InternationalFlight.getId().equals(toFind.getId())) {
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
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (InternationalFlight m : listaInternationalFlight) {
			content += m.getArrivalTime() + ";";
			content += m.getCompanyName() + ";";
			content += m.getDepartureTime() + ";";
			content += m.getFuelWeight() + ";";
			content += m.getNameCaptain() + ";";
			content += m.getNameSecondCommand() + ";";
			content += m.getPassengersNumber() + ";";
			content += m.isTurbine() + ";";
			content += m.isTurboProp() + ";";
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

}
