package co.edu.unbosque.model;

import java.io.Serializable;

public class InternationalFlight extends Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isVisa;

	public InternationalFlight() {
		// TODO Auto-generated constructor stub
	}

	public InternationalFlight(boolean isVisa) {
		super();
		this.isVisa = isVisa;
	}

	public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination, boolean isVisa) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
				departureDestination, arrivalDestination);
		this.isVisa = isVisa;
	}

	public InternationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
				departureDestination, arrivalDestination);
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
		return super.toString() + "InternationalFlight [isVisa=" + isVisa + "]";
	}

}
