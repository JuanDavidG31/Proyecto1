package co.edu.unbosque.model;

public class InternationalFlightDTO extends Flight {
	private boolean isTurboProp;
	private boolean isTurbine;

	public InternationalFlightDTO() {
		// TODO Auto-generated constructor stub
	}

	public InternationalFlightDTO(boolean isTurboProp, boolean isTurbine) {
		super();
		this.isTurboProp = isTurboProp;
		this.isTurbine = isTurbine;
	}

	public InternationalFlightDTO(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight,String id, boolean isTurboProp, boolean isTurbine) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id);
		this.isTurboProp = isTurboProp;
		this.isTurbine = isTurbine;
	}

	public InternationalFlightDTO(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, String id) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id);
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
