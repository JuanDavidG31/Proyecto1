package co.edu.unbosque.model;

import java.io.Serializable;

public class Appointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String doctor;
	private String specialty;
	private String date;
	private int appointmentNum;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id, String doctor, String specialty, String date, int appointmentNum) {
		super();
		this.id = id;
		this.doctor = doctor;
		this.specialty = specialty;
		this.date = date;
		this.appointmentNum = appointmentNum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Appointment [id=" + id + ", doctor=" + doctor + ", specialty=" + specialty + ", date=" + date
				+ ", appointmentNum=" + appointmentNum + "]";
	}

}
