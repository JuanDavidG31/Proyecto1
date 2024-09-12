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
			int departureTime, int arrivalTime, int fuelWeight,String id, boolean isVisa) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,id);
		this.isVisa = isVisa;
	}

	public NacionalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight,String id) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,id);
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
		return super.toString() + "\n Is Visa :" + isVisa + "";
	}

}
