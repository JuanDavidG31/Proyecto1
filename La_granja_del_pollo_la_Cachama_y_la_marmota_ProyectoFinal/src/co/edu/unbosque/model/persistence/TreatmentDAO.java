package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Treatment;
import co.edu.unbosque.model.TreatmentDTO;

public class TreatmentDAO implements CRUDOperation<TreatmentDTO, Treatment> {

	private ArrayList<Treatment> TreatmentList;
	private final String FILE_NAME = "treatment.csv";
	private final String SERIAL_NAME = "treatment.dat";
	private final String FILE_NAME2 = "treatmentForm.csv";
	private final String SERIAL_NAME2 = "treatmentForm.dat";

	public TreatmentDAO() {

		FileHandler.checkFolder();
		readSerizalized();
		// readSerizalized2();
		// readFile2();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (TreatmentList.isEmpty()) {
			return "No hay Treatments en la lista";
		} else {
			for (Treatment Treatment : TreatmentList) {
				rta += Treatment;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<TreatmentDTO> getAll() {
		return DataMapper.listaTreatmentToListaTreatmentDTO(TreatmentList);

	}

	@Override
	public boolean add(TreatmentDTO newData) {
		if (find2(DataMapper.TreatmentDTOToTreatment(newData)) == null) {
			TreatmentList.add(DataMapper.TreatmentDTOToTreatment(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	public boolean add2(TreatmentDTO newData) {
		if (TreatmentList.add(DataMapper.TreatmentDTOToTreatment(newData))) {
			writeFile2();
			writeSerialized2();
			return true;

		}
		return false;

	}

	@Override
	public boolean delete(TreatmentDTO toDelete) {
		Treatment found = find(DataMapper.TreatmentDTOToTreatment(toDelete));
		if (found != null) {
			TreatmentList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Treatment find(Treatment toFind) {

		Treatment found = null;
		if (!TreatmentList.isEmpty()) {
			for (Treatment Treatment : TreatmentList) {
				if (Treatment.getName().equals(toFind.getName())) {
					found = Treatment;
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
	public Treatment find2(Treatment toFind) {

		Treatment found = null;
		if (!TreatmentList.isEmpty()) {
			for (Treatment Treatment : TreatmentList) {
				if (Treatment.getTreatment().equals(toFind.getTreatment())) {
					found = Treatment;
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
	public boolean update(TreatmentDTO previous, TreatmentDTO newData) {
		Treatment found = find(DataMapper.TreatmentDTOToTreatment(previous));
		if (found != null) {
			TreatmentList.remove(found);
			TreatmentList.add(DataMapper.TreatmentDTOToTreatment(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Treatment m : TreatmentList) {
			content += m.getName() + ";";
			content += m.getSpecialty() + ";";
			content += m.getTreatment() + ";";
			content += m.getVerified() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void writeFile2() {
		String content = "";
		for (Treatment m : TreatmentList) {
			content += m.getName() + ";";
			content += m.getSpecialty() + ";";
			content += m.getTreatment() + ";";
			content += m.getVerified() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME2, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			TreatmentList = new ArrayList<>();
		} else {
			TreatmentList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Treatment tempo = new Treatment();
				tempo.setName(cols[0]);
				tempo.setSpecialty(cols[1]);
				tempo.setTreatment(cols[2]);
				tempo.setVerified(cols[3]);
				TreatmentList.add(tempo);
			}
		}

	}

	public void readFile2() {
		String content = FileHandler.readFile(FILE_NAME2);

		if (content.equals("") || content == null) {
			TreatmentList = new ArrayList<>();
		} else {
			TreatmentList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Treatment tempo = new Treatment();
				tempo.setName(cols[0]);
				tempo.setSpecialty(cols[1]);
				tempo.setTreatment(cols[2]);
				tempo.setVerified(cols[3]);
				TreatmentList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, TreatmentList);
	}

	public void writeSerialized2() {
		FileHandler.writerSerialized(SERIAL_NAME2, TreatmentList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			TreatmentList = new ArrayList<>();
		} else {
			TreatmentList = (ArrayList<Treatment>) content;
		}
	}

	public void readSerizalized2() {
		Object content = FileHandler.readSerialized(SERIAL_NAME2);
		if (content == null) {
			TreatmentList = new ArrayList<>();
		} else {
			TreatmentList = (ArrayList<Treatment>) content;
		}
	}

}
