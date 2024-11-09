package co.edu.unbosque.model;

import java.io.Serializable;

public class ReportPatient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int id;
	private String email;

	public ReportPatient() {
		// TODO Auto-generated constructor stub
	}

	public ReportPatient(String name, int id, String email) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ReportPatient [name=" + name + ", id=" + id + ", email=" + email + "]";
	}

}
