package co.edu.unbosque.model;

public class DoctorDTO extends Person {
	private String specialty;

	public DoctorDTO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(String specialty) {
		super();
		this.specialty = specialty;
	}

	public DoctorDTO(String name, String gmail, int id, String specialty) {
		super(name, gmail, id);
		this.specialty = specialty;
	}

	public DoctorDTO(String name, String gmail, int id) {
		super(name, gmail, id);
		// TODO Auto-generated constructor stub
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	@Override
	public String toString() {
		return super.toString() + "Doctor [specialty=" + specialty + "]";
	}
}
