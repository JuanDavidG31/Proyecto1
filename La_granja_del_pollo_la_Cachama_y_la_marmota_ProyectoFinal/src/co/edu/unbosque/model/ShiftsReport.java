package co.edu.unbosque.model;

import java.io.Serializable;

public class ShiftsReport extends Shifts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean report;

	public ShiftsReport() {

	}

	public ShiftsReport(boolean report) {
		super();
		this.report = report;
	}

	public ShiftsReport(String date1, String date2, String specialty, int id, String name, boolean report) {
		super(date1, date2, specialty, id, name);
		this.report = report;
	}

	public ShiftsReport(String date1, String date2, String specialty, int id, String name) {
		super(date1, date2, specialty, id, name);
		// TODO Auto-generated constructor stub
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return super.toString() + "ShiftsReport [report=" + report + "]";
	}

}
