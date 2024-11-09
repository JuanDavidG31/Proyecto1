package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ReportMaxDoctor;
import co.edu.unbosque.model.ReportMaxDoctorDTO;

public class ReportMaxDoctorDAO implements CRUDOperation<ReportMaxDoctorDTO, ReportMaxDoctor> {
	private ArrayList<ReportMaxDoctor> reportMaxDoctorList;
	private final String FILE_NAME = "reportMaxDoctor.csv";
	private final String SERIAL_NAME = "reportMaxDoctor.dat";

	public ReportMaxDoctorDAO() {

		FileHandler.checkFolder();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (reportMaxDoctorList.isEmpty()) {
			return "No hay ReportMaxDoctors en la lista";
		} else {
			for (ReportMaxDoctor ReportMaxDoctor : reportMaxDoctorList) {
				rta += ReportMaxDoctor;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ReportMaxDoctorDTO> getAll() {
		return DataMapper.listaReportMaxDoctorToListaReportMaxDoctorDTO(reportMaxDoctorList);

	}

	@Override
	public boolean add(ReportMaxDoctorDTO newData) {
		if (find(DataMapper.ReportMaxDoctorDTOToReportMaxDoctor(newData)) == null) {
			reportMaxDoctorList.add(DataMapper.ReportMaxDoctorDTOToReportMaxDoctor(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(ReportMaxDoctorDTO toDelete) {
		ReportMaxDoctor found = find(DataMapper.ReportMaxDoctorDTOToReportMaxDoctor(toDelete));
		if (found != null) {
			reportMaxDoctorList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ReportMaxDoctor find(ReportMaxDoctor toFind) {

		ReportMaxDoctor found = null;
		if (!reportMaxDoctorList.isEmpty()) {
			for (ReportMaxDoctor ReportMaxDoctor : reportMaxDoctorList) {
				if (ReportMaxDoctor.getEmail().equals(toFind.getEmail())) {
					found = ReportMaxDoctor;
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
	public ReportMaxDoctor find2(ReportMaxDoctor toFind) {

		ReportMaxDoctor found = null;
		if (!reportMaxDoctorList.isEmpty()) {
			for (ReportMaxDoctor ReportMaxDoctor : reportMaxDoctorList) {
				if (ReportMaxDoctor.getNumAppo() == toFind.getNumAppo()) {
					found = ReportMaxDoctor;
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
	public boolean update(ReportMaxDoctorDTO previous, ReportMaxDoctorDTO newData) {
		ReportMaxDoctor found = find(DataMapper.ReportMaxDoctorDTOToReportMaxDoctor(previous));
		if (found != null) {
			reportMaxDoctorList.remove(found);
			reportMaxDoctorList.add(DataMapper.ReportMaxDoctorDTOToReportMaxDoctor(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (ReportMaxDoctor m : reportMaxDoctorList) {
			content += "Numero de repeticion = " + m.getNumAppo() + ";";
			content += "Nombre = " + m.getName() + ";";
			content += "Email" + m.getEmail() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			reportMaxDoctorList = new ArrayList<>();
		} else {
			reportMaxDoctorList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				ReportMaxDoctor tempo = new ReportMaxDoctor();
				tempo.setNumAppo(Integer.parseInt(cols[0]));
				tempo.setName(cols[1]);
				tempo.setEmail(cols[2]);
				reportMaxDoctorList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, reportMaxDoctorList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			reportMaxDoctorList = new ArrayList<>();
		} else {
			reportMaxDoctorList = (ArrayList<ReportMaxDoctor>) content;
		}
	}
}
