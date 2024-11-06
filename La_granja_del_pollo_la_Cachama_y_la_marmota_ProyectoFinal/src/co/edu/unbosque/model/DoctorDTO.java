package co.edu.unbosque.model;

public class DoctorDTO extends Person {
	private String specialty;
	private String status;

	public DoctorDTO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(String specialty, String status) {
		super();
		this.specialty = specialty;
		this.status = status;
	}

	public DoctorDTO(String name, String email, int id, String specialty, String status) {
		super(name, email, id);
		this.specialty = specialty;
		this.status = status;
	}

	public DoctorDTO(String name, String email, int id) {
		super(name, email, id);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return super.toString() + "Doctor [specialty=" + specialty + ", status=" + status + "]";
	}
}
