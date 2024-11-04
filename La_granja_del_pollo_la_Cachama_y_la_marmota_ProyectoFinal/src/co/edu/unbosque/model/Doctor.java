package co.edu.unbosque.model;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String specialty;
	private boolean director;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(String specialty, boolean director) {
		super();
		this.specialty = specialty;
		this.director = director;
	}

	public Doctor(String name, String gmail, int id, String specialty, boolean director) {
		super(name, gmail, id);
		this.specialty = specialty;
		this.director = director;
	}

	public Doctor(String name, String gmail, int id) {
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
