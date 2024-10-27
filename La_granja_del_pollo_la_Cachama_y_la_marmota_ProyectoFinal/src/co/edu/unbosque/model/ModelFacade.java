package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PatientDAO;
import co.edu.unbosque.model.persistence.TreatmentDAO;

public class ModelFacade {
	private PatientDAO patient;
	private TreatmentDAO treatment;

	public ModelFacade() {
		patient = new PatientDAO();
		treatment = new TreatmentDAO();
	}

	public PatientDAO getPatient() {
		return patient;
	}

	public void setPatient(PatientDAO patient) {
		this.patient = patient;
	}

	public TreatmentDAO getTreatment() {
		return treatment;
	}

	public void setTreatment(TreatmentDAO treatment) {
		this.treatment = treatment;
	}

}
