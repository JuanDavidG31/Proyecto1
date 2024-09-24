package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;

public class NationalFlightDAO implements CRUDOperation<NationalFlightDTO, NationalFlight> {
	private ArrayList<NationalFlight> listaNationalFlight;
	private final String FILE_NAME = "NationalFlight.csv";
	private final String SERIAL_NAME = "NationalFlight.dat";

	public NationalFlightDAO() {
		listaNationalFlight = new ArrayList<>();
		FileHandler.checkFolder();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (listaNationalFlight.isEmpty()) {
			return "No hay NationalFlights en la lista";
		} else {
			for (NationalFlight NationalFlight : listaNationalFlight) {
				rta += NationalFlight;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<NationalFlightDTO> getAll() {
		return DataMapper.listaNationalFlightToListaNationalFlightDTO(listaNationalFlight);

	}

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

	@Override
	public boolean delete(NationalFlightDTO toDelete) {
		NationalFlight found = find(DataMapper.NationalFlightDTOToNationalFlight(toDelete));
		if (found != null) {
			return listaNationalFlight.remove(found);
		} else {
			return false;
		}
	}

	@Override
	public NationalFlight find(NationalFlight toFind) {

		NationalFlight found = null;
		if (!listaNationalFlight.isEmpty()) {
			for (NationalFlight NationalFlight : listaNationalFlight) {
				if (NationalFlight.getId().equals(toFind.getId())) {
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

	public void writeFile() {
		String content = "";
		for (NationalFlight m : listaNationalFlight) {
			content += m.getArrivalTime() + ";";
			content += m.getCompanyName() + ";";
			content += m.getDepartureTime() + ";";
			content += m.getFuelWeight() + ";";
			content += m.getNameCaptain() + ";";
			content += m.getNameSecondCommand() + ";";
			content += m.getPassengersNumber() + ";";
			content += m.isVisa() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public ArrayList<NationalFlight> getListaNationalFlight() {
		return listaNationalFlight;
	}

	public void setListaNationalFlight(ArrayList<NationalFlight> listaNationalFlight) {
		this.listaNationalFlight = listaNationalFlight;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, listaNationalFlight);
	}

	public void readSerilized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			listaNationalFlight = new ArrayList<>();
		} else {
			listaNationalFlight = (ArrayList<NationalFlight>)content;
			
			}
		}

	@Override
	public NationalFlight find2(NationalFlight toFind) {
		// TODO Auto-generated method stub
		return null;
	}
}
