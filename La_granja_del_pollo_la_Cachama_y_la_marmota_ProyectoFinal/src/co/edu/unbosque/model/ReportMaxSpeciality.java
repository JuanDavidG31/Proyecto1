package co.edu.unbosque.model;

import java.io.Serializable;

public class ReportMaxSpeciality implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numAppo;
	private String name;

	public ReportMaxSpeciality() {
		// TODO Auto-generated constructor stub
	}

	public ReportMaxSpeciality(int numAppo, String name) {
		super();
		this.numAppo = numAppo;
		this.name = name;
	}

	public int getNumAppo() {
		return numAppo;
	}

	public void setNumAppo(int numAppo) {
		this.numAppo = numAppo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ReportMaxSpeciality [numAppo=" + numAppo + ", name=" + name + "]";
	}

}
