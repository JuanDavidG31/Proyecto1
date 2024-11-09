package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ReportPatient;
import co.edu.unbosque.model.ReportPatientDTO;

public class ReportPatientDAO implements CRUDOperation<ReportPatientDTO, ReportPatient> {
	private ArrayList<ReportPatient> reportPatientList;
	private final String FILE_NAME = "reportPatient.csv";
	private final String SERIAL_NAME = "reportPatient.dat";

	public ReportPatientDAO() {

		FileHandler.checkFolder();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (reportPatientList.isEmpty()) {
			return "No hay ReportPatients en la lista";
		} else {
			for (ReportPatient ReportPatient : reportPatientList) {
				rta += ReportPatient;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ReportPatientDTO> getAll() {
		return DataMapper.listaReportPatientToListaReportPatientDTO(reportPatientList);

	}

	@Override
	public boolean add(ReportPatientDTO newData) {
		if (find2(DataMapper.ReportPatientDTOToReportPatient(newData)) == null) {
			reportPatientList.add(DataMapper.ReportPatientDTOToReportPatient(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(ReportPatientDTO toDelete) {
		ReportPatient found = find2(DataMapper.ReportPatientDTOToReportPatient(toDelete));
		if (found != null) {
			reportPatientList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ReportPatient find(ReportPatient toFind) {

		ReportPatient found = null;
		if (!reportPatientList.isEmpty()) {
			for (ReportPatient ReportPatient : reportPatientList) {
				if (ReportPatient.getName().equals(toFind.getName())) {
					found = ReportPatient;
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
	public ReportPatient find2(ReportPatient toFind) {

		ReportPatient found = null;
		if (!reportPatientList.isEmpty()) {
			for (ReportPatient ReportPatient : reportPatientList) {
				if (ReportPatient.getId() == toFind.getId()) {
					found = ReportPatient;
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
	public boolean update(ReportPatientDTO previous, ReportPatientDTO newData) {
		ReportPatient found = find2(DataMapper.ReportPatientDTOToReportPatient(previous));
		if (found != null) {
			reportPatientList.remove(found);
			reportPatientList.add(DataMapper.ReportPatientDTOToReportPatient(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public boolean update2(ReportPatientDTO previous, ReportPatientDTO newData) {
		ReportPatient found = find2(DataMapper.ReportPatientDTOToReportPatient(previous));
		if (found != null) {
			reportPatientList.remove(found);
			reportPatientList.add(DataMapper.ReportPatientDTOToReportPatient(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (ReportPatient m : reportPatientList) {
			content += "Name =  " + m.getName() + ";";
			content += "Id = " + m.getId() + ";";
			content += "Email = " + m.getEmail() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			reportPatientList = new ArrayList<>();
		} else {
			reportPatientList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				ReportPatient tempo = new ReportPatient();
				tempo.setName(cols[0]);
				int id = Integer.parseInt(cols[1]);
				tempo.setId(id);
				tempo.setEmail(cols[2]);
				reportPatientList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, reportPatientList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			reportPatientList = new ArrayList<>();
		} else {
			reportPatientList = (ArrayList<ReportPatient>) content;
		}
	}

}
