package co.edu.unbosque.model;


public class TreatmentDTO{

	private String name;
	private String specialty;
	private String treatment;
	private String verified;

	public TreatmentDTO() {
		// TODO Auto-generated constructor stub
	}

	public TreatmentDTO(String name, String specialty, String treatment, String verified) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.treatment = treatment;
		this.verified = verified;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	@Override
	public String toString() {
		return "Treatment [name=" + name + ", specialty=" + specialty + ", treatment=" + treatment + ", verified="
				+ verified + "]";
	}
}
