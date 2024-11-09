package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.ShiftsReport;
import co.edu.unbosque.model.ShiftsReportDTO;

public class ShiftsReportDAO implements CRUDOperation<ShiftsReportDTO, ShiftsReport> {

	private ArrayList<ShiftsReport> shiftsReportList;
	private final String FILE_NAME = "shiftsReport.csv";
	private final String SERIAL_NAME = "shiftsReport.dat";

	public ShiftsReportDAO() {
		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (shiftsReportList.isEmpty()) {
			return "No hay turnos en la lista";
		} else {
			for (ShiftsReport ShiftsReport : shiftsReportList) {
				rta += ShiftsReport;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<ShiftsReportDTO> getAll() {
		return DataMapper.listaShiftsReportToListaShiftsReportDTO(shiftsReportList);

	}

	@Override
	public boolean add(ShiftsReportDTO newData) {

		shiftsReportList.add(DataMapper.ShiftsReportDTOToShiftsReport(newData));
		writeFile();
		writeSerialized();
		return true;

	}

	@Override
	public boolean delete(ShiftsReportDTO toDelete) {
		ShiftsReport found = find2(DataMapper.ShiftsReportDTOToShiftsReport(toDelete));
		if (found != null) {
			shiftsReportList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ShiftsReport find(ShiftsReport toFind) {

		ShiftsReport found = null;
		if (!shiftsReportList.isEmpty()) {
			for (ShiftsReport ShiftsReport : shiftsReportList) {
				if (ShiftsReport.getName().equals(toFind.getName())) {
					found = ShiftsReport;
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
	public ShiftsReport find2(ShiftsReport toFind) {

		ShiftsReport found = null;
		if (!shiftsReportList.isEmpty()) {
			for (ShiftsReport ShiftsReport : shiftsReportList) {
				if (ShiftsReport.getId() == toFind.getId()) {
					found = ShiftsReport;
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
	public boolean update(ShiftsReportDTO previous, ShiftsReportDTO newData) {
		ShiftsReport found = find2(DataMapper.ShiftsReportDTOToShiftsReport(previous));
		if (found != null) {
			shiftsReportList.remove(found);
			shiftsReportList.add(DataMapper.ShiftsReportDTOToShiftsReport(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (ShiftsReport m : shiftsReportList) {
			content += "Fecha inicio = " + m.getDate1() + ";";
			content += "Fecha fin = " + m.getDate2() + ";";
			content += "Especialidad = " + m.getSpecialty() + ";";
			content += "Id = " + m.getId() + ";";
			content += "Nombre = " + m.getName() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			shiftsReportList = new ArrayList<>();
		} else {
			shiftsReportList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				ShiftsReport tempo = new ShiftsReport();
				tempo.setDate1(cols[0]);
				tempo.setDate2(cols[1]);
				tempo.setSpecialty(cols[2]);
				int id = Integer.parseInt(cols[3]);
				tempo.setId(id);
				tempo.setName(cols[4]);
				shiftsReportList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, shiftsReportList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			shiftsReportList = new ArrayList<>();
		} else {
			shiftsReportList = (ArrayList<ShiftsReport>) content;
		}
	}
}
