package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.AppointmentDAO;
import co.edu.unbosque.model.persistence.PatientDAO;
import co.edu.unbosque.model.persistence.TreatmentDAO;

public class ModelFacade {
	private AppointmentDAO appointment;
	private TreatmentDAO treatment;
	private PatientDAO patient;

	public ModelFacade() {
		appointment = new AppointmentDAO();
		treatment = new TreatmentDAO();
		patient = new PatientDAO();
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

}
