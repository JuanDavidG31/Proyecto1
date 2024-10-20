package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Patient;
import co.edu.unbosque.model.PatientDTO;

public class DataMapper {

	public static Patient PatientDTOToPatient(PatientDTO dto) {
		Patient entity;
		entity = new Patient(dto.getName(), dto.getGmail(), dto.getAge(), dto.getId(), dto.getDoctor(),
				dto.getSpecialty(), dto.getDate(), dto.getAppointmentNum());
		return entity;
	}

	public static PatientDTO PatientToPatientDTO(Patient entity) {
		PatientDTO dto;
		dto = new PatientDTO(entity.getName(), entity.getGmail(), entity.getAge(), entity.getId(), entity.getDoctor(),
				entity.getSpecialty(), entity.getDate(), entity.getAppointmentNum());
		return dto;
	}

	public static ArrayList<PatientDTO> listaPatientToListaPatientDTO(ArrayList<Patient> entityList) {
		ArrayList<PatientDTO> dtoList = new ArrayList<>();
		for (Patient m : entityList) {
			dtoList.add(new PatientDTO(m.getName(), m.getGmail(), m.getAge(), m.getId(), m.getDoctor(),
					m.getSpecialty(), m.getDate(), m.getAppointmentNum()));
		}
		return dtoList;
	}

	public static ArrayList<Patient> listaPatientDTOToListaPatient(ArrayList<PatientDTO> dtoList) {
		ArrayList<Patient> entityList = new ArrayList<>();
		for (PatientDTO d : dtoList) {
			entityList.add(new Patient(d.getName(), d.getGmail(), d.getAge(), d.getId(), d.getDoctor(),
					d.getSpecialty(), d.getDate(), d.getAppointmentNum()));
		}
		return entityList;
	}
}
