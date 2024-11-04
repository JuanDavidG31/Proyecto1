package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Doctor;
import co.edu.unbosque.model.DoctorDTO;

public class DoctorDAO implements CRUDOperation<DoctorDTO, Doctor> {

	private ArrayList<Doctor> doctorList;
	private final String FILE_NAME = "doctor.csv";
	private final String SERIAL_NAME = "doctor.dat";

	public DoctorDAO() {

		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (doctorList.isEmpty()) {
			return "No hay doctores en la lista";
		} else {
			for (Doctor Doctor : doctorList) {
				rta += Doctor;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<DoctorDTO> getAll() {
		return DataMapper.listaDoctorToListaDoctorDTO(doctorList);

	}

	@Override
	public boolean add(DoctorDTO newData) {
		if (find(DataMapper.DoctorDTOToDoctor(newData)) == null) {
			doctorList.add(DataMapper.DoctorDTOToDoctor(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(DoctorDTO toDelete) {
		Doctor found = find2(DataMapper.DoctorDTOToDoctor(toDelete));
		if (found != null) {
			doctorList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Doctor find(Doctor toFind) {

		Doctor found = null;
		if (!doctorList.isEmpty()) {
			for (Doctor Doctor : doctorList) {
				if (Doctor.getName().equals(toFind.getName())) {
					found = Doctor;
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
	public Doctor find2(Doctor toFind) {

		Doctor found = null;
		if (!doctorList.isEmpty()) {
			for (Doctor Doctor : doctorList) {
				if (Doctor.getId() == toFind.getId()) {
					found = Doctor;
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
	public boolean update(DoctorDTO previous, DoctorDTO newData) {
		Doctor found = find2(DataMapper.DoctorDTOToDoctor(previous));
		if (found != null) {
			doctorList.remove(found);
			doctorList.add(DataMapper.DoctorDTOToDoctor(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Doctor m : doctorList) {
			content += m.getName() + ";";
			content += m.getGmail() + ";";
			content += m.getId() + ";";
			content += m.getSpecialty() + ";";
			content += m.isDirector() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			doctorList = new ArrayList<>();
		} else {
			doctorList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Doctor tempo = new Doctor();
				tempo.setName(cols[0]);
				tempo.setGmail(cols[1]);
				int id = Integer.parseInt(cols[2]);
				tempo.setId(id);
				tempo.setSpecialty(cols[3]);
				boolean director = false;
				if (cols[4].toLowerCase() == "si") {
					director = true;
				}
				tempo.setDirector(director);
				doctorList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, doctorList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			doctorList = new ArrayList<>();
		} else {
			doctorList = (ArrayList<Doctor>) content;
		}
	}

}
