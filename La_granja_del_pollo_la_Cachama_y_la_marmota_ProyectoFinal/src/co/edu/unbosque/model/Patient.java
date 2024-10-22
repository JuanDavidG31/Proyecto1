package co.edu.unbosque.model;

import java.io.Serializable;

public class Patient extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String doctor;
	private String specialty;
	private String date;
	private int appointmentNum;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String gmail, int age, int id) {
		super(name, gmail, age, id);
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String gmail, int age, int id, String doctor, String specialty, String date,
			int appointmentNum) {
		super(name, gmail, age, id);
		this.doctor = doctor;
		this.specialty = specialty;
		this.date = date;
		this.appointmentNum = appointmentNum;
	}

	public Patient(String doctor, String specialty, String date, int appointmentNum) {
		super();
		this.doctor = doctor;
		this.specialty = specialty;
		this.date = date;
		this.appointmentNum = appointmentNum;
	}
	

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAppointmentNum() {
		return appointmentNum;
	}

	public void setAppointmentNum(int appointmentNum) {
		this.appointmentNum = appointmentNum;
	}

	@Override
	public String toString() {
		return super.toString() + "Patient [doctor=" + doctor + ", specialty=" + specialty + ", date=" + date
				+ ", appointmentNum=" + appointmentNum + "]";
	}

}
