package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Shifts;
import co.edu.unbosque.model.ShiftsDTO;

public class ShiftsDAO implements CRUDOperation<ShiftsDTO, Shifts> {

	private ArrayList<Shifts> shiftsList;
	private final String FILE_NAME = "shifts.csv";
	private final String SERIAL_NAME = "shifts.dat";

	public ShiftsDAO() {

		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (shiftsList.isEmpty()) {
			return "No hay turnos en la lista";
		} else {
			for (Shifts Shifts : shiftsList) {
				rta += Shifts;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ShiftsDTO> getAll() {
		return DataMapper.listaShiftsToListaShiftsDTO(shiftsList);

	}

	@Override
	public boolean add(ShiftsDTO newData) {
		if (find2(DataMapper.ShiftsDTOToShifts(newData)) == null) {
			shiftsList.add(DataMapper.ShiftsDTOToShifts(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(ShiftsDTO toDelete) {
		Shifts found = find2(DataMapper.ShiftsDTOToShifts(toDelete));
		if (found != null) {
			shiftsList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Shifts find(Shifts toFind) {

		Shifts found = null;
		if (!shiftsList.isEmpty()) {
			for (Shifts Shifts : shiftsList) {
				if (Shifts.getName().equals(toFind.getName())) {
					found = Shifts;
					return found;
				} else {
					continue; // las sig lineas desps de continue no se ejecutan, saltan a la sig iteracion
				}
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public Shifts find2(Shifts toFind) {

		Shifts found = null;
		if (!shiftsList.isEmpty()) {
			for (Shifts Shifts : shiftsList) {
				if (Shifts.getId() == toFind.getId()) {
					found = Shifts;
					return found;
				} else {
					continue; // las sig lineas desps de continue no se ejecutan, saltan a la sig iteracion
				}
			}
		} else {
			return null;
		}
		return null;
	}

	@Override
	public boolean update(ShiftsDTO previous, ShiftsDTO newData) {
		Shifts found = find2(DataMapper.ShiftsDTOToShifts(previous));
		if (found != null) {
			shiftsList.remove(found);
			shiftsList.add(DataMapper.ShiftsDTOToShifts(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Shifts m : shiftsList) {
			content += m.getDate1() + ";";
			content += m.getDate2() + ";";
			content += m.getSpecialty() + ";";
			content += m.getId() + ";";
			content += m.getName() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			shiftsList = new ArrayList<>();
		} else {
			shiftsList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Shifts tempo = new Shifts();
				tempo.setDate1(cols[0]);
				tempo.setDate2(cols[1]);
				tempo.setSpecialty(cols[2]);
				int id = Integer.parseInt(cols[3]);
				tempo.setId(id);
				tempo.setName(cols[4]);
				shiftsList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, shiftsList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			shiftsList = new ArrayList<>();
		} else {
			shiftsList = (ArrayList<Shifts>) content;
		}
	}

}
