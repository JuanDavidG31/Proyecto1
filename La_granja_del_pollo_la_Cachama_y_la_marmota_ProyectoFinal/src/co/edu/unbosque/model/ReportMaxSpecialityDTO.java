package co.edu.unbosque.model;

public class ReportMaxSpecialityDTO {
	private int numAppo;
	private String name;

	public ReportMaxSpecialityDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReportMaxSpecialityDTO(int numAppo, String name) {
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
