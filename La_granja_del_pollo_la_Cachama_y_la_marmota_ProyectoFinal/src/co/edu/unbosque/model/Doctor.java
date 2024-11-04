package co.edu.unbosque.model;

import java.io.Serializable;

public class Doctor extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String specialty;

	public Doctor() {
		// TODO Auto-generated constructor stub
	}

	public Doctor(String specialty) {
		super();
		this.specialty = specialty;
	}

	public Doctor(String name, String gmail, int id, String specialty) {
		super(name, gmail, id);
		this.specialty = specialty;
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

	@Override
	public String toString() {
		return super.toString() + "Doctor [specialty=" + specialty + "]";
	}

}
