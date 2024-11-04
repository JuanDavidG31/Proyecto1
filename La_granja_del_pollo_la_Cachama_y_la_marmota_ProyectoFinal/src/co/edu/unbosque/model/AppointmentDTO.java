package co.edu.unbosque.model;

public class AppointmentDTO {
	private String name;
	private String doctor;
	private String specialty;
	private String date;
	private int appointmentNum;

	public AppointmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppointmentDTO(String name, String doctor, String specialty, String date, int appointmentNum) {
		super();
		this.name = name;
		this.doctor = doctor;
		this.specialty = specialty;
		this.date = date;
		this.appointmentNum = appointmentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Appointment [name=" + name + ", doctor=" + doctor + ", specialty=" + specialty + ", date=" + date
				+ ", appointmentNum=" + appointmentNum + "]";
	}
}
