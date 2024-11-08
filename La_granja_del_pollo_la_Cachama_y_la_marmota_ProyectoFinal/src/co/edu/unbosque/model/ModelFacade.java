package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AppointmentDAO;
import co.edu.unbosque.model.persistence.AppoitmentReportDAO;
import co.edu.unbosque.model.persistence.DoctorDAO;
import co.edu.unbosque.model.persistence.PatientDAO;
import co.edu.unbosque.model.persistence.ShiftsDAO;
import co.edu.unbosque.model.persistence.ShiftsReportDAO;
import co.edu.unbosque.model.persistence.TreatmentDAO;

public class ModelFacade {
	private AppointmentDAO appointment;
	private AppoitmentReportDAO appointmentReport;
	private TreatmentDAO treatment;
	private PatientDAO patient;
	private DoctorDAO doctor;
	private ShiftsDAO shift;
	private ShiftsReportDAO shiftReport;

	public ModelFacade() {
		appointment = new AppointmentDAO();
		treatment = new TreatmentDAO();
		patient = new PatientDAO();
		doctor = new DoctorDAO();
		shift = new ShiftsDAO();
		shiftReport = new ShiftsReportDAO();
		appointmentReport = new AppoitmentReportDAO();
	}

	public AppointmentDAO getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentDAO appointment) {
		this.appointment = appointment;
	}

	public TreatmentDAO getTreatment() {
		return treatment;
	}

	public void setTreatment(TreatmentDAO treatment) {
		this.treatment = treatment;
	}

	public PatientDAO getPatient() {
		return patient;
	}

	public void setPatient(PatientDAO patient) {
		this.patient = patient;
	}

	public DoctorDAO getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorDAO doctor) {
		this.doctor = doctor;
	}

	public ShiftsDAO getShift() {
		return shift;
	}

	public void setShift(ShiftsDAO shift) {
		this.shift = shift;
	}

	public ShiftsReportDAO getShiftReport() {
		return shiftReport;
	}

	public void setShiftReport(ShiftsReportDAO shiftReport) {
		this.shiftReport = shiftReport;
	}

	public AppoitmentReportDAO getAppointmentReport() {
		return appointmentReport;
	}

	public void setAppointmentReport(AppoitmentReportDAO appointmentReport) {
		this.appointmentReport = appointmentReport;
	}

}
