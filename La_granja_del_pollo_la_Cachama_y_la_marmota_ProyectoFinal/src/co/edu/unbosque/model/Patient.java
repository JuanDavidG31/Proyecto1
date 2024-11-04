package co.edu.unbosque.model;

import java.io.Serializable;

public class Patient extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int age;

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Patient(int age) {
		super();
		this.age = age;
	}

	public Patient(String name, String gmail, int id, int age) {
		super(name, gmail, id);
		this.age = age;
	}

	public Patient(String name, String gmail, int id) {
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
