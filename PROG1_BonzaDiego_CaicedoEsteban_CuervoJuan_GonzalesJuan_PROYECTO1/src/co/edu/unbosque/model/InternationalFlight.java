package co.edu.unbosque.model;

public class InternationalFlight extends Flight {
	private boolean isTurboProp;
	private boolean isTurbine;

	public InternationalFlight() {
		// TODO Auto-generated constructor stub
	}

	public InternationalFlight(boolean isTurboProp, boolean isTurbine) {
		super();
		this.isTurboProp = isTurboProp;
		this.isTurbine = isTurbine;
	}

	public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, boolean isTurboProp, boolean isTurbine) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight);
		this.isTurboProp = isTurboProp;
		this.isTurbine = isTurbine;
	}

	public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight);
		// TODO Auto-generated constructor stub
	}

	public boolean isTurboProp() {
		return isTurboProp;
	}

	public void setTurboProp(boolean isTurboProp) {
		this.isTurboProp = isTurboProp;
	}

	public boolean isTurbine() {
		return isTurbine;
	}

	public void setTurbine(boolean isTurbine) {
		this.isTurbine = isTurbine;
	}

	@Override
	public String toString() {
		return super.toString() + " \n Is TurboProp :" + isTurboProp + " \n Is Turbine :" + isTurbine + "";
	}

}
