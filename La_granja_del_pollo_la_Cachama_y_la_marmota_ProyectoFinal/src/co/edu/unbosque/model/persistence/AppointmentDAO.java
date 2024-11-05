package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Appointment;
import co.edu.unbosque.model.AppointmentDTO;

public class AppointmentDAO implements CRUDOperation<AppointmentDTO, Appointment> {
	private ArrayList<Appointment> appointmentList;
	private final String FILE_NAME = "appointment.csv";
	private final String SERIAL_NAME = "appointment.dat";

	public AppointmentDAO() {

		FileHandler.checkFolder();
		// readFile();
		readSerizalized();
	}

	@Override
	public String showAll() {
		String rta = "";
		if (appointmentList.isEmpty()) {
			return "No hay citas en la lista";
		} else {
			for (Appointment Appoitment : appointmentList) {
				rta += Appoitment;
			}
			return rta;
		}
	}

	@Override
	public ArrayList<AppointmentDTO> getAll() {
		return DataMapper.listaAppoitmentToListaAppoitmentDTO(appointmentList);

	}

	@Override
	public boolean add(AppointmentDTO newData) {
		if (find2(DataMapper.AppoitmentDTOToAppoitment(newData)) == null) {
			appointmentList.add(DataMapper.AppoitmentDTOToAppoitment(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean delete(AppointmentDTO toDelete) {
		Appointment found = find2(DataMapper.AppoitmentDTOToAppoitment(toDelete));
		if (found != null) {
			appointmentList.remove(found);
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Appointment find(Appointment toFind) {

		Appointment found = null;
		if (!appointmentList.isEmpty()) {
			for (Appointment Appoitment : appointmentList) {
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
	public Appointment find2(Appointment toFind) {

		Appointment found = null;
		if (!appointmentList.isEmpty()) {
			for (Appointment Appoitment : appointmentList) {
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
	public boolean update(AppointmentDTO previous, AppointmentDTO newData) {
		Appointment found = find2(DataMapper.AppoitmentDTOToAppoitment(previous));
		if (found != null) {
			appointmentList.remove(found);
			appointmentList.add(DataMapper.AppoitmentDTOToAppoitment(newData));
			writeFile();
			writeSerialized();
			return true;
		} else {
			return false;
		}
	}

	public void writeFile() {
		String content = "";
		for (Appointment m : appointmentList) {
			content += m.getId() + ";";
			content += m.getDoctor() + ";";
			content += m.getSpecialty() + ";";
			content += m.getDate() + ";";
			content += m.getAppointmentNum() + ";";
			content += "\n";
		}
		FileHandler.writeFile(FILE_NAME, content);
	}

	public void readFile() {
		String content = FileHandler.readFile(FILE_NAME);

		if (content.equals("") || content == null) {
			appointmentList = new ArrayList<>();
		} else {
			appointmentList = new ArrayList<>();
			String[] rows = content.split("\n");
			for (String row : rows) {
				String[] cols = row.split(";");
				Appointment tempo = new Appointment();
				int id = Integer.parseInt(cols[0]);
				tempo.setId(id);
				tempo.setDoctor(cols[1]);
				tempo.setSpecialty(cols[2]);
				tempo.setDate(cols[3]);
				int appointment = Integer.parseInt(cols[4]);
				tempo.setAppointmentNum(appointment);
				appointmentList.add(tempo);
			}
		}

	}

	public void writeSerialized() {
		FileHandler.writerSerialized(SERIAL_NAME, appointmentList);
	}

	public void readSerizalized() {
		Object content = FileHandler.readSerialized(SERIAL_NAME);
		if (content == null) {
			appointmentList = new ArrayList<>();
		} else {
			appointmentList = (ArrayList<Appointment>) content;
		}
	}
}
