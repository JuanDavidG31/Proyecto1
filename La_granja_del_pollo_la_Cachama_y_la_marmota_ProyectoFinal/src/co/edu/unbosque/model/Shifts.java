package co.edu.unbosque.model;

import java.io.Serializable;

public class Shifts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date1;
	private String date2;
	private String specialty;
	private int id;
	private String name;

	public Shifts() {
		// TODO Auto-generated constructor stub
	}

	public Shifts(String date1, String date2, String specialty, int id, String name) {
		super();
		this.date1 = date1;
		this.date2 = date2;
		this.specialty = specialty;
		this.id = id;
		this.name = name;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
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
		return "Shifts [date1=" + date1 + ", date2=" + date2 + ", specialty=" + specialty + ", id=" + id + ", name="
				+ name + "]";
	}

}
