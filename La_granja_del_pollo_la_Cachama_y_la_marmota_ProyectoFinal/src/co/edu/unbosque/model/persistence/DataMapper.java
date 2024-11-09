package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Appointment;
import co.edu.unbosque.model.AppointmentDTO;
import co.edu.unbosque.model.AppoitmentReport;
import co.edu.unbosque.model.AppoitmentReportDTO;
import co.edu.unbosque.model.Doctor;
import co.edu.unbosque.model.DoctorDTO;
import co.edu.unbosque.model.Patient;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.ReportMaxDoctor;
import co.edu.unbosque.model.ReportMaxDoctorDTO;
import co.edu.unbosque.model.ReportMaxSpeciality;
import co.edu.unbosque.model.ReportMaxSpecialityDTO;
import co.edu.unbosque.model.ReportPatient;
import co.edu.unbosque.model.ReportPatientDTO;
import co.edu.unbosque.model.Shifts;
import co.edu.unbosque.model.ShiftsDTO;
import co.edu.unbosque.model.ShiftsReport;
import co.edu.unbosque.model.ShiftsReportDTO;
import co.edu.unbosque.model.Treatment;
import co.edu.unbosque.model.TreatmentDTO;

public class DataMapper {

	// Reporte max especialidad

	public static ReportMaxSpeciality ReportMaxSpecialityDTOToReportMaxSpeciality(ReportMaxSpecialityDTO dto) {
		ReportMaxSpeciality entity;
		entity = new ReportMaxSpeciality(dto.getNumAppo(), dto.getName());
		return entity;
	}

	public static ReportMaxSpecialityDTO ReportMaxSpecialityToReportMaxSpecialityDTO(ReportMaxSpeciality entity) {
		ReportMaxSpecialityDTO dto;
		dto = new ReportMaxSpecialityDTO(entity.getNumAppo(), entity.getName());
		return dto;
	}

	public static ArrayList<ReportMaxSpecialityDTO> listaReportMaxSpecialityToListaReportMaxSpecialityDTO(
			ArrayList<ReportMaxSpeciality> entityList) {
		ArrayList<ReportMaxSpecialityDTO> dtoList = new ArrayList<>();
		for (ReportMaxSpeciality m : entityList) {
			dtoList.add(new ReportMaxSpecialityDTO(m.getNumAppo(), m.getName()));
		}
		return dtoList;
	}

	public static ArrayList<ReportMaxSpeciality> listaReportMaxSpecialityDTOToListaReportMaxSpeciality(
			ArrayList<ReportMaxSpecialityDTO> dtoList) {
		ArrayList<ReportMaxSpeciality> entityList = new ArrayList<>();
		for (ReportMaxSpecialityDTO d : dtoList) {
			entityList.add(new ReportMaxSpeciality(d.getNumAppo(), d.getName()));
		}
		return entityList;
	}

	// Reporte max doctor

	public static ReportMaxDoctor ReportMaxDoctorDTOToReportMaxDoctor(ReportMaxDoctorDTO dto) {
		ReportMaxDoctor entity;
		entity = new ReportMaxDoctor(dto.getNumAppo(), dto.getName(), dto.getEmail());
		return entity;
	}

	public static ReportMaxDoctorDTO ReportMaxDoctorToReportMaxDoctorDTO(ReportMaxDoctor entity) {
		ReportMaxDoctorDTO dto;
		dto = new ReportMaxDoctorDTO(entity.getNumAppo(), entity.getName(), entity.getEmail());
		return dto;
	}

	public static ArrayList<ReportMaxDoctorDTO> listaReportMaxDoctorToListaReportMaxDoctorDTO(
			ArrayList<ReportMaxDoctor> entityList) {
		ArrayList<ReportMaxDoctorDTO> dtoList = new ArrayList<>();
		for (ReportMaxDoctor m : entityList) {
			dtoList.add(new ReportMaxDoctorDTO(m.getNumAppo(), m.getName(), m.getEmail()));
		}
		return dtoList;
	}

	public static ArrayList<ReportMaxDoctor> listaReportMaxDoctorDTOToListaReportMaxDoctor(
			ArrayList<ReportMaxDoctorDTO> dtoList) {
		ArrayList<ReportMaxDoctor> entityList = new ArrayList<>();
		for (ReportMaxDoctorDTO d : dtoList) {
			entityList.add(new ReportMaxDoctor(d.getNumAppo(), d.getName(), d.getEmail()));
		}
		return entityList;
	}

	// Reporte paciente

	public static ReportPatient ReportPatientDTOToReportPatient(ReportPatientDTO dto) {
		ReportPatient entity;
		entity = new ReportPatient(dto.getName(), dto.getId(), dto.getEmail());
		return entity;
	}

	public static ReportPatientDTO ReportPatientToReportPatientDTO(ReportPatient entity) {
		ReportPatientDTO dto;
		dto = new ReportPatientDTO(entity.getName(), entity.getId(), entity.getEmail());
		return dto;
	}

	public static ArrayList<ReportPatientDTO> listaReportPatientToListaReportPatientDTO(
			ArrayList<ReportPatient> entityList) {
		ArrayList<ReportPatientDTO> dtoList = new ArrayList<>();
		for (ReportPatient m : entityList) {
			dtoList.add(new ReportPatientDTO(m.getName(), m.getId(), m.getEmail()));
		}
		return dtoList;
	}

	public static ArrayList<ReportPatient> listaReportPatientDTOToListaReportPatient(
			ArrayList<ReportPatientDTO> dtoList) {
		ArrayList<ReportPatient> entityList = new ArrayList<>();
		for (ReportPatientDTO d : dtoList) {
			entityList.add(new ReportPatient(d.getName(), d.getId(), d.getEmail()));
		}
		return entityList;
	}

	// Turnos

	public static ShiftsReport ShiftsReportDTOToShiftsReport(ShiftsReportDTO dto) {
		ShiftsReport entity;
		entity = new ShiftsReport(dto.getDate1(), dto.getDate2(), dto.getSpecialty(), dto.getId(), dto.getName(),
				dto.isReport());
		return entity;
	}

	public static ShiftsReportDTO ShiftsReportToShiftsReportDTO(ShiftsReport entity) {
		ShiftsReportDTO dto;
		dto = new ShiftsReportDTO(entity.getDate1(), entity.getDate2(), entity.getSpecialty(), entity.getId(),
				entity.getName(), entity.isReport());
		return dto;
	}

	public static ArrayList<ShiftsReportDTO> listaShiftsReportToListaShiftsReportDTO(
			ArrayList<ShiftsReport> entityList) {
		ArrayList<ShiftsReportDTO> dtoList = new ArrayList<>();
		for (ShiftsReport m : entityList) {
			dtoList.add(new ShiftsReportDTO(m.getDate1(), m.getDate2(), m.getSpecialty(), m.getId(), m.getName(),
					m.isReport()));
		}
		return dtoList;
	}

	public static ArrayList<ShiftsReport> listaShiftsReportDTOToListaShiftsReport(ArrayList<ShiftsReportDTO> dtoList) {
		ArrayList<ShiftsReport> entityList = new ArrayList<>();
		for (ShiftsReportDTO d : dtoList) {
			entityList.add(new ShiftsReport(d.getDate1(), d.getDate2(), d.getSpecialty(), d.getId(), d.getName(),
					d.isReport()));
		}
		return entityList;
	}

	public static Shifts ShiftsDTOToShifts(ShiftsDTO dto) {
		Shifts entity;
		entity = new Shifts(dto.getDate1(), dto.getDate2(), dto.getSpecialty(), dto.getId(), dto.getName());
		return entity;
	}

	public static ShiftsDTO ShiftsToShiftsDTO(Shifts entity) {
		ShiftsDTO dto;
		dto = new ShiftsDTO(entity.getDate1(), entity.getDate2(), entity.getSpecialty(), entity.getId(),
				entity.getName());
		return dto;
	}

	public static ArrayList<ShiftsDTO> listaShiftsToListaShiftsDTO(ArrayList<Shifts> entityList) {
		ArrayList<ShiftsDTO> dtoList = new ArrayList<>();
		for (Shifts m : entityList) {
			dtoList.add(new ShiftsDTO(m.getDate1(), m.getDate2(), m.getSpecialty(), m.getId(), m.getName()));
		}
		return dtoList;
	}

	public static ArrayList<Shifts> listaShiftsDTOToListaShifts(ArrayList<ShiftsDTO> dtoList) {
		ArrayList<Shifts> entityList = new ArrayList<>();
		for (ShiftsDTO d : dtoList) {
			entityList.add(new Shifts(d.getDate1(), d.getDate2(), d.getSpecialty(), d.getId(), d.getName()));
		}
		return entityList;
	}

	// Doctor

	public static Doctor DoctorDTOToDoctor(DoctorDTO dto) {
		Doctor entity;
		entity = new Doctor(dto.getName(), dto.getEmail(), dto.getId(), dto.getSpecialty(), dto.getStatus());
		return entity;
	}

	public static DoctorDTO DoctorToDoctorDTO(Doctor entity) {
		DoctorDTO dto;
		dto = new DoctorDTO(entity.getName(), entity.getEmail(), entity.getId(), entity.getSpecialty(),
				entity.getStatus());
		return dto;
	}

	public static ArrayList<DoctorDTO> listaDoctorToListaDoctorDTO(ArrayList<Doctor> entityList) {
		ArrayList<DoctorDTO> dtoList = new ArrayList<>();
		for (Doctor m : entityList) {
			dtoList.add(new DoctorDTO(m.getName(), m.getEmail(), m.getId(), m.getSpecialty(), m.getStatus()));
		}
		return dtoList;
	}

	public static ArrayList<Doctor> listaDoctorDTOToListaDoctor(ArrayList<DoctorDTO> dtoList) {
		ArrayList<Doctor> entityList = new ArrayList<>();
		for (DoctorDTO d : dtoList) {
			entityList.add(new Doctor(d.getName(), d.getEmail(), d.getId(), d.getSpecialty(), d.getStatus()));
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

	public static AppoitmentReport AppoitmentReportDTOToAppoitmentReport(AppoitmentReportDTO dto) {
		AppoitmentReport entity;
		entity = new AppoitmentReport(dto.getId(), dto.getDoctor(), dto.getSpecialty(), dto.getDate(),
				dto.getAppointmentNum());
		return entity;
	}

	public static AppoitmentReportDTO AppoitmentReportToAppoitmentReportDTO(AppoitmentReport entity) {
		AppoitmentReportDTO dto;
		dto = new AppoitmentReportDTO(entity.getId(), entity.getDoctor(), entity.getSpecialty(), entity.getDate(),
				entity.getAppointmentNum());
		return dto;
	}

	public static ArrayList<AppoitmentReportDTO> listaAppoitmentReportToListaAppoitmentReportDTO(
			ArrayList<AppoitmentReport> entityList) {
		ArrayList<AppoitmentReportDTO> dtoList = new ArrayList<>();
		for (AppoitmentReport m : entityList) {
			dtoList.add(new AppoitmentReportDTO(m.getId(), m.getDoctor(), m.getSpecialty(), m.getDate(),
					m.getAppointmentNum()));
		}
		return dtoList;
	}

	public static ArrayList<AppoitmentReport> listaAppoitmentReportDTOToListaAppoitmentReport(
			ArrayList<AppoitmentReportDTO> dtoList) {
		ArrayList<AppoitmentReport> entityList = new ArrayList<>();
		for (AppoitmentReportDTO d : dtoList) {
			entityList.add(new AppoitmentReport(d.getId(), d.getDoctor(), d.getSpecialty(), d.getDate(),
					d.getAppointmentNum()));
		}
		return entityList;
	}

	public static Appointment AppoitmentDTOToAppoitment(AppointmentDTO dto) {
		Appointment entity;
		entity = new Appointment(dto.getId(), dto.getDoctor(), dto.getSpecialty(), dto.getDate(),
				dto.getAppointmentNum());
		return entity;
	}

	public static AppointmentDTO AppoitmentToAppoitmentDTO(Appointment entity) {
		AppointmentDTO dto;
		dto = new AppointmentDTO(entity.getId(), entity.getDoctor(), entity.getSpecialty(), entity.getDate(),
				entity.getAppointmentNum());
		return dto;
	}

	public static ArrayList<AppointmentDTO> listaAppoitmentToListaAppoitmentDTO(ArrayList<Appointment> entityList) {
		ArrayList<AppointmentDTO> dtoList = new ArrayList<>();
		for (Appointment m : entityList) {
			dtoList.add(
					new AppointmentDTO(m.getId(), m.getDoctor(), m.getSpecialty(), m.getDate(), m.getAppointmentNum()));
		}
		return dtoList;
	}

	public static ArrayList<Appointment> listaAppoitmentDTOToListaAppoitment(ArrayList<AppointmentDTO> dtoList) {
		ArrayList<Appointment> entityList = new ArrayList<>();
		for (AppointmentDTO d : dtoList) {
			entityList.add(
					new Appointment(d.getId(), d.getDoctor(), d.getSpecialty(), d.getDate(), d.getAppointmentNum()));
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
