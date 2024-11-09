package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ReportMaxSpeciality;
import co.edu.unbosque.model.ReportMaxSpecialityDTO;

public class ReportMaxSpecialityDAO implements CRUDOperation<ReportMaxSpecialityDTO, ReportMaxSpeciality> {
	private ArrayList<ReportMaxSpeciality> reportMaxSpecialityList;
	private final String FILE_NAME = "reportMaxSpeciality.csv";
	private final String SERIAL_NAME = "reportMaxSpeciality.dat";

	public ReportMaxSpecialityDAO() {

		FileHandler.checkFolder();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (reportMaxSpecialityList.isEmpty()) {
			return "No hay ReportMaxSpecialitys en la lista";
		} else {
			for (ReportMaxSpeciality ReportMaxSpeciality : reportMaxSpecialityList) {
				rta += ReportMaxSpeciality;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ReportMaxSpecialityDTO> getAll() {
		return DataMapper.listaReportMaxSpecialityToListaReportMaxSpecialityDTO(reportMaxSpecialityList);

	}

	@Override
	public boolean add(ReportMaxSpecialityDTO newData) {
		if (find(DataMapper.ReportMaxSpecialityDTOToReportMaxSpeciality(newData)) == null) {
			reportMaxSpecialityList.add(DataMapper.ReportMaxSpecialityDTOToReportMaxSpeciality(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(ReportMaxSpecialityDTO toDelete) {
		ReportMaxSpeciality found = find(DataMapper.ReportMaxSpecialityDTOToReportMaxSpeciality(toDelete));
		if (found != null) {
			reportMaxSpecialityList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ReportMaxSpeciality find(ReportMaxSpeciality toFind) {

		ReportMaxSpeciality found = null;
		if (!reportMaxSpecialityList.isEmpty()) {
			for (ReportMaxSpeciality ReportMaxSpeciality : reportMaxSpecialityList) {
				if (ReportMaxSpeciality.getName().equals(toFind.getName())) {
					found = ReportMaxSpeciality;
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
	public ReportMaxSpeciality find2(ReportMaxSpeciality toFind) {

		ReportMaxSpeciality found = null;
		if (!reportMaxSpecialityList.isEmpty()) {
			for (ReportMaxSpeciality ReportMaxSpeciality : reportMaxSpecialityList) {
				if (ReportMaxSpeciality.getNumAppo() == toFind.getNumAppo()) {
					found = ReportMaxSpeciality;
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
	public boolean update(ReportMaxSpecialityDTO previous, ReportMaxSpecialityDTO newData) {
		ReportMaxSpeciality found = find(DataMapper.ReportMaxSpecialityDTOToReportMaxSpeciality(previous));
		if (found != null) {
			reportMaxSpecialityList.remove(found);
			reportMaxSpecialityList.add(DataMapper.ReportMaxSpecialityDTOToReportMaxSpeciality(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (ReportMaxSpeciality m : reportMaxSpecialityList) {
			content += "Numero de repeticion = " + m.getNumAppo() + ";";
			content += "Nombre = " + m.getName() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			reportMaxSpecialityList = new ArrayList<>();
		} else {
			reportMaxSpecialityList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				ReportMaxSpeciality tempo = new ReportMaxSpeciality();
				tempo.setNumAppo(Integer.parseInt(cols[0]));
				tempo.setName(cols[1]);
				reportMaxSpecialityList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, reportMaxSpecialityList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			reportMaxSpecialityList = new ArrayList<>();
		} else {
			reportMaxSpecialityList = (ArrayList<ReportMaxSpeciality>) content;
		}
	}
}
