package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Appointment;
import co.edu.unbosque.model.AppointmentDTO;
import co.edu.unbosque.model.Patient;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.Treatment;
import co.edu.unbosque.model.TreatmentDTO;

public class DataMapper {

	// Paciente

	public static Patient PatientDTOToPatient(PatientDTO dto) {
		Patient entity;
		entity = new Patient(dto.getName(), dto.getGmail(), dto.getId(), dto.getAge());
		return entity;
	}

	public static PatientDTO PatientToPatientDTO(Patient entity) {
		PatientDTO dto;
		dto = new PatientDTO(entity.getName(), entity.getGmail(), entity.getId(), entity.getAge());
		return dto;
	}

	public static ArrayList<PatientDTO> listaPatientToListaPatientDTO(ArrayList<Patient> entityList) {
		ArrayList<PatientDTO> dtoList = new ArrayList<>();
		for (Patient m : entityList) {
			dtoList.add(new PatientDTO(m.getName(), m.getGmail(), m.getId(), m.getAge()));
		}
		return dtoList;
	}

	public static ArrayList<Patient> listaPatientDTOToListaPatient(ArrayList<PatientDTO> dtoList) {
		ArrayList<Patient> entityList = new ArrayList<>();
		for (PatientDTO d : dtoList) {
			entityList.add(new Patient(d.getName(), d.getGmail(), d.getId(), d.getAge()));
		}
		return entityList;
	}

	// Cita

	public static Appointment AppoitmentDTOToAppoitment(AppointmentDTO dto) {
		Appointment entity;
		entity = new Appointment(dto.getName(), dto.getDoctor(), dto.getSpecialty(), dto.getDate(),
				dto.getAppointmentNum());
		return entity;
	}

	public static AppointmentDTO AppoitmentToAppoitmentDTO(Appointment entity) {
		AppointmentDTO dto;
		dto = new AppointmentDTO(entity.getName(), entity.getDoctor(), entity.getSpecialty(), entity.getDate(),
				entity.getAppointmentNum());
		return dto;
	}

	public static ArrayList<AppointmentDTO> listaAppoitmentToListaAppoitmentDTO(ArrayList<Appointment> entityList) {
		ArrayList<AppointmentDTO> dtoList = new ArrayList<>();
		for (Appointment m : entityList) {
			dtoList.add(new AppointmentDTO(m.getName(), m.getDoctor(), m.getSpecialty(), m.getDate(),
					m.getAppointmentNum()));
		}
		return dtoList;
	}

	public static ArrayList<Appointment> listaAppoitmentDTOToListaAppoitment(ArrayList<AppointmentDTO> dtoList) {
		ArrayList<Appointment> entityList = new ArrayList<>();
		for (AppointmentDTO d : dtoList) {
			entityList.add(
					new Appointment(d.getName(), d.getDoctor(), d.getSpecialty(), d.getDate(), d.getAppointmentNum()));
		}
		return entityList;
	}

	// Tratamiento

	public static Treatment TreatmentDTOToTreatment(TreatmentDTO dto) {
		Treatment entity;
		entity = new Treatment(dto.getName(), dto.getSpecialty(), dto.getTreatment(), dto.getVerified());
		return entity;
	}

	public static TreatmentDTO TreatmentToTreatmentDTO(Treatment entity) {
		TreatmentDTO dto;
		dto = new TreatmentDTO(entity.getName(), entity.getSpecialty(), entity.getTreatment(), entity.getVerified());
		return dto;
	}

	public static ArrayList<TreatmentDTO> listaTreatmentToListaTreatmentDTO(ArrayList<Treatment> entityList) {
		ArrayList<TreatmentDTO> dtoList = new ArrayList<>();
		for (Treatment m : entityList) {
			dtoList.add(new TreatmentDTO(m.getName(), m.getSpecialty(), m.getTreatment(), m.getVerified()));
		}
		return dtoList;
	}

	public static ArrayList<Treatment> listaTreatmentDTOToListaTreatment(ArrayList<TreatmentDTO> dtoList) {
		ArrayList<Treatment> entityList = new ArrayList<>();
		for (TreatmentDTO d : dtoList) {
			entityList.add(new Treatment(d.getName(), d.getSpecialty(), d.getTreatment(), d.getVerified()));
		}
		return entityList;
	}

}
