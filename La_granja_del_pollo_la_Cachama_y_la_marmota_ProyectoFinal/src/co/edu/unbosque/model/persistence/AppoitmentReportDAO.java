package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.AppoitmentReport;
import co.edu.unbosque.model.AppoitmentReportDTO;

public class AppoitmentReportDAO implements CRUDOperation<AppoitmentReportDTO, AppoitmentReport> {
	private ArrayList<AppoitmentReport> appoitmentReportList;
	private final String FILE_NAME = "appoitmentReport.csv";
	private final String SERIAL_NAME = "appoitmentReport.dat";

	public AppoitmentReportDAO() {
		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (appoitmentReportList.isEmpty()) {
			return "No hay citas en la lista";
		} else {
			for (AppoitmentReport Appoitment : appoitmentReportList) {
				rta += Appoitment;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<AppoitmentReportDTO> getAll() {
		return DataMapper.listaAppoitmentReportToListaAppoitmentReportDTO(appoitmentReportList);

	}

	@Override
	public boolean add(AppoitmentReportDTO newData) {

		appoitmentReportList.add(DataMapper.AppoitmentReportDTOToAppoitmentReport(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(AppoitmentReportDTO toDelete) {
		AppoitmentReport found = find2(DataMapper.AppoitmentReportDTOToAppoitmentReport(toDelete));
		if (found != null) {
			appoitmentReportList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AppoitmentReport find(AppoitmentReport toFind) {

		AppoitmentReport found = null;
		if (!appoitmentReportList.isEmpty()) {
			for (AppoitmentReport Appoitment : appoitmentReportList) {
				if (Appoitment.getId() == toFind.getId()) {
					found = Appoitment;
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
	public AppoitmentReport find2(AppoitmentReport toFind) {

		AppoitmentReport found = null;
		if (!appoitmentReportList.isEmpty()) {
			for (AppoitmentReport Appoitment : appoitmentReportList) {
				if (Appoitment.getAppointmentNum() == toFind.getAppointmentNum()) {
					found = Appoitment;
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
	public boolean update(AppoitmentReportDTO previous, AppoitmentReportDTO newData) {
		AppoitmentReport found = find2(DataMapper.AppoitmentReportDTOToAppoitmentReport(previous));
		if (found != null) {
			appoitmentReportList.remove(found);
			appoitmentReportList.add(DataMapper.AppoitmentReportDTOToAppoitmentReport(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (AppoitmentReport m : appoitmentReportList) {
			content += "ID = " + m.getId() + ";";
			content += "DOCTOR = " + m.getDoctor() + ";";
			content += "Speciality = " + m.getSpecialty() + ";";
			content += "Date = " + m.getDate() + ";";
			content += "Appoint num = " + m.getAppointmentNum() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			appoitmentReportList = new ArrayList<>();
		} else {
			appoitmentReportList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				AppoitmentReport tempo = new AppoitmentReport();
				int id = Integer.parseInt(cols[0]);
				tempo.setId(id);
				tempo.setDoctor(cols[1]);
				tempo.setSpecialty(cols[2]);
				tempo.setDate(cols[3]);
				int AppoitmentReport = Integer.parseInt(cols[4]);
				tempo.setAppointmentNum(AppoitmentReport);
				appoitmentReportList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, appoitmentReportList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			appoitmentReportList = new ArrayList<>();
		} else {
			appoitmentReportList = (ArrayList<AppoitmentReport>) content;
		}
	}
}
