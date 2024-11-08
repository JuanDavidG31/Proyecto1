package co.edu.unbosque.model;

import java.io.Serializable;

public class AppoitmentReport extends Appointment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean report;

	public AppoitmentReport() {
		// TODO Auto-generated constructor stub
	}

	public AppoitmentReport(boolean report) {
		super();
		this.report = report;
	}

	public AppoitmentReport(int id, String doctor, String specialty, String date, int appointmentNum, boolean report) {
		super(id, doctor, specialty, date, appointmentNum);
		this.report = report;
	}

	public AppoitmentReport(int id, String doctor, String specialty, String date, int appointmentNum) {
		super(id, doctor, specialty, date, appointmentNum);
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
		return super.toString() + "AppoitmentReport [report=" + report + "]";
	}

}
