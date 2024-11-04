package co.edu.unbosque.model;

public class DoctorDTO extends Person {
	private String specialty;
	private boolean director;

	public DoctorDTO() {
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(String specialty, boolean director) {
		super();
		this.specialty = specialty;
		this.director = director;
	}

	public DoctorDTO(String name, String gmail, int id, String specialty, boolean director) {
		super(name, gmail, id);
		this.specialty = specialty;
		this.director = director;
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

	public boolean isDirector() {
		return director;
	}

	public void setDirector(boolean director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return super.toString() + "Doctor [specialty=" + specialty + ", director=" + director + "]";
	}
}
