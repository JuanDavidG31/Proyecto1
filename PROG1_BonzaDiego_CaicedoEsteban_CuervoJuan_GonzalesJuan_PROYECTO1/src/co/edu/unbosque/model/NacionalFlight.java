package co.edu.unbosque.model;

public class NacionalFlight extends Flight {
	private boolean isVisa;

	public NacionalFlight() {

	}

	public NacionalFlight(boolean isVisa) {
		super();
		this.isVisa = isVisa;
	}

	public NacionalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, boolean isVisa) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight);
		this.isVisa = isVisa;
	}

	public NacionalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight);
		// TODO Auto-generated constructor stub
	}

	public boolean isVisa() {
		return isVisa;
	}

	public void setVisa(boolean isVisa) {
		this.isVisa = isVisa;
	}

	@Override
	public String toString() {
		return super.toString() + "VueloNacional [isVisa=" + isVisa + "]";
	}

}
