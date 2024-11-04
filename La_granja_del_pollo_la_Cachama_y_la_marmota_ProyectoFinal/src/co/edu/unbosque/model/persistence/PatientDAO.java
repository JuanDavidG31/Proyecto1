package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Patient;
import co.edu.unbosque.model.PatientDTO;

public class PatientDAO implements CRUDOperation<PatientDTO, Patient> {
	private ArrayList<Patient> patientList;
	private final String FILE_NAME = "patient.csv";
	private final String SERIAL_NAME = "patient.dat";

	public PatientDAO() {

		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (patientList.isEmpty()) {
			return "No hay pacientes en la lista";
		} else {
			for (Patient Patient : patientList) {
				rta += Patient;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<PatientDTO> getAll() {
		return DataMapper.listaPatientToListaPatientDTO(patientList);

	}

	@Override
	public boolean add(PatientDTO newData) {
		if (find(DataMapper.PatientDTOToPatient(newData)) == null) {
			patientList.add(DataMapper.PatientDTOToPatient(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(PatientDTO toDelete) {
		Patient found = find2(DataMapper.PatientDTOToPatient(toDelete));
		if (found != null) {
			patientList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Patient find(Patient toFind) {

		Patient found = null;
		if (!patientList.isEmpty()) {
			for (Patient Patient : patientList) {
				if (Patient.getName().equals(toFind.getName())) {
					found = Patient;
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
	public Patient find2(Patient toFind) {

		Patient found = null;
		if (!patientList.isEmpty()) {
			for (Patient Patient : patientList) {
				if (Patient.getId() == toFind.getId()) {
					found = Patient;
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
	public boolean update(PatientDTO previous, PatientDTO newData) {
		Patient found = find2(DataMapper.PatientDTOToPatient(previous));
		if (found != null) {
			patientList.remove(found);
			patientList.add(DataMapper.PatientDTOToPatient(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Patient m : patientList) {
			content += m.getName() + ";";
			content += m.getGmail() + ";";
			content += m.getId() + ";";
			content += m.getAge() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			patientList = new ArrayList<>();
		} else {
			patientList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Patient tempo = new Patient();
				tempo.setName(cols[0]);
				tempo.setGmail(cols[1]);
				int id = Integer.parseInt(cols[2]);
				tempo.setId(id);
				int age = Integer.parseInt(cols[3]);
				tempo.setAge(age);
				patientList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, patientList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			patientList = new ArrayList<>();
		} else {
			patientList = (ArrayList<Patient>) content;
		}
	}
}
