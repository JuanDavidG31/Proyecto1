package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Appointment;
import co.edu.unbosque.model.AppointmentDTO;
import co.edu.unbosque.model.Doctor;
import co.edu.unbosque.model.DoctorDTO;
import co.edu.unbosque.model.Patient;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.Shifts;
import co.edu.unbosque.model.ShiftsDTO;
import co.edu.unbosque.model.Treatment;
import co.edu.unbosque.model.TreatmentDTO;

public class DataMapper {

	// Turnos

	public static Shifts ShiftsDTOToShifts(ShiftsDTO dto) {
		Shifts entity;
		entity = new Shifts(dto.getDate(), dto.getSpecialty(), dto.getId(), dto.getName());
		return entity;
	}

	public static ShiftsDTO ShiftsToShiftsDTO(Shifts entity) {
		ShiftsDTO dto;
		dto = new ShiftsDTO(entity.getDate(), entity.getSpecialty(), entity.getId(), entity.getName());
		return dto;
	}

	public static ArrayList<ShiftsDTO> listaShiftsToListaShiftsDTO(ArrayList<Shifts> entityList) {
		ArrayList<ShiftsDTO> dtoList = new ArrayList<>();
		for (Shifts m : entityList) {
			dtoList.add(new ShiftsDTO(m.getDate(), m.getSpecialty(), m.getId(), m.getName()));
		}
		return dtoList;
	}

	public static ArrayList<Shifts> listaShiftsDTOToListaShifts(ArrayList<ShiftsDTO> dtoList) {
		ArrayList<Shifts> entityList = new ArrayList<>();
		for (ShiftsDTO d : dtoList) {
			entityList.add(new Shifts(d.getDate(), d.getSpecialty(), d.getId(), d.getName()));
		}
		return entityList;
	}

	// Doctor

	public static Doctor DoctorDTOToDoctor(DoctorDTO dto) {
		Doctor entity;
		entity = new Doctor(dto.getName(), dto.getEmail(), dto.getId(), dto.getSpecialty());
		return entity;
	}

	public static DoctorDTO DoctorToDoctorDTO(Doctor entity) {
		DoctorDTO dto;
		dto = new DoctorDTO(entity.getName(), entity.getEmail(), entity.getId(), entity.getSpecialty());
		return dto;
	}

	public static ArrayList<DoctorDTO> listaDoctorToListaDoctorDTO(ArrayList<Doctor> entityList) {
		ArrayList<DoctorDTO> dtoList = new ArrayList<>();
		for (Doctor m : entityList) {
			dtoList.add(new DoctorDTO(m.getName(), m.getEmail(), m.getId(), m.getSpecialty()));
		}
		return dtoList;
	}

	public static ArrayList<Doctor> listaDoctorDTOToListaDoctor(ArrayList<DoctorDTO> dtoList) {
		ArrayList<Doctor> entityList = new ArrayList<>();
		for (DoctorDTO d : dtoList) {
			entityList.add(new Doctor(d.getName(), d.getEmail(), d.getId(), d.getSpecialty()));
		}
		return entityList;
	}

	// Paciente

	public static Patient PatientDTOToPatient(PatientDTO dto) {
		Patient entity;
		entity = new Patient(dto.getName(), dto.getEmail(), dto.getId(), dto.getAge());
		return entity;
	}

	public static PatientDTO PatientToPatientDTO(Patient entity) {
		PatientDTO dto;
		dto = new PatientDTO(entity.getName(), entity.getEmail(), entity.getId(), entity.getAge());
		return dto;
	}

	public static ArrayList<PatientDTO> listaPatientToListaPatientDTO(ArrayList<Patient> entityList) {
		ArrayList<PatientDTO> dtoList = new ArrayList<>();
		for (Patient m : entityList) {
			dtoList.add(new PatientDTO(m.getName(), m.getEmail(), m.getId(), m.getAge()));
		}
		return dtoList;
	}

	public static ArrayList<Patient> listaPatientDTOToListaPatient(ArrayList<PatientDTO> dtoList) {
		ArrayList<Patient> entityList = new ArrayList<>();
		for (PatientDTO d : dtoList) {
			entityList.add(new Patient(d.getName(), d.getEmail(), d.getId(), d.getAge()));
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
