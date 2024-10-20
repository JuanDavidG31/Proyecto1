package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.PatientDAO;

public class ModelFacade {
	private PatientDAO patient;

	public ModelFacade() {
		patient = new PatientDAO();
	}

	public PatientDAO getPatient() {
		return patient;
	}

	public void setPatient(PatientDAO patient) {
		this.patient = patient;
	}

}
