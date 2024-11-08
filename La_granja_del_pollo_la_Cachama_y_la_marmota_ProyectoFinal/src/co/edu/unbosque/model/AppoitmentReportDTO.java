package co.edu.unbosque.model;

public class AppoitmentReportDTO extends Appointment {

	boolean report;

	public AppoitmentReportDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppoitmentReportDTO(boolean report) {
		super();
		this.report = report;
	}

	public AppoitmentReportDTO(int id, String doctor, String specialty, String date, int appointmentNum,
			boolean report) {
		super(id, doctor, specialty, date, appointmentNum);
		this.report = report;
	}

	public AppoitmentReportDTO(int id, String doctor, String specialty, String date, int appointmentNum) {
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
