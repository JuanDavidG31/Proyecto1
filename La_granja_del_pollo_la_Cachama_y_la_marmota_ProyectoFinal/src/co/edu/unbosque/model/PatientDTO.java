package co.edu.unbosque.model;

public class PatientDTO extends Person {
	private int age;

	public PatientDTO() {
		// TODO Auto-generated constructor stub
	}

	public PatientDTO(int age) {
		super();
		this.age = age;
	}

	public PatientDTO(String name, String gmail, int id, int age) {
		super(name, gmail, id);
		this.age = age;
	}

	public PatientDTO(String name, String gmail, int id) {
		super(name, gmail, id);
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString() + "Patient [age=" + age + "]";
	}
}
