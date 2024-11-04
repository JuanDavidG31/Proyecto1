package co.edu.unbosque.model;

import java.io.Serializable;

public class Shifts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private String specialty;
	private int id;
	private String name;

	public Shifts() {
		// TODO Auto-generated constructor stub
	}

	public Shifts(String date, String specialty, int id, String name) {
		super();
		this.date = date;
		this.specialty = specialty;
		this.id = id;
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Shifts [date=" + date + ", specialty=" + specialty + ", id=" + id + ", name=" + name + "]";
	}

}
