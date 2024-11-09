package co.edu.unbosque.model;

public class ReportMaxDoctorDTO {
	private int numAppo;
	private String name;
	private String email;

	public ReportMaxDoctorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReportMaxDoctorDTO(int numAppo, String name, String email) {
		super();
		this.numAppo = numAppo;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ReportMaxDoctor [numAppo=" + numAppo + ", name=" + name + ", email=" + email + "]";
	}
}
