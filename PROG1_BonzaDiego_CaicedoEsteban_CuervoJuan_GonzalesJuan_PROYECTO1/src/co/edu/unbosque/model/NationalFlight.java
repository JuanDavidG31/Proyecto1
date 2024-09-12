package co.edu.unbosque.model;

public class NationalFlight extends Flight {
	private boolean isVisa;

	public NationalFlight() {

	}

	public NationalFlight(boolean isVisa) {
		super();
		this.isVisa = isVisa;
	}

	public NationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, String id, boolean isVisa) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,
				id);
		this.isVisa = isVisa;
	}

	public NationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, String id) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,
				id);
		
	}

	public boolean isVisa() {
		return isVisa;
	}

	public void setVisa(boolean isVisa) {
		this.isVisa = isVisa;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Is Visa :" + isVisa + "";
	}

}
