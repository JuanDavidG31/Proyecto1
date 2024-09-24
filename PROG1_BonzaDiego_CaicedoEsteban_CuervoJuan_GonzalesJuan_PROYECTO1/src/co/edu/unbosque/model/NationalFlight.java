package co.edu.unbosque.model;

import java.io.Serializable;

public class NationalFlight extends Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isVisa;

	public NationalFlight() {

	}

	public NationalFlight(boolean isVisa) {
		super();
		this.isVisa = isVisa;
	}

	public NationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination, boolean isVisa) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,
				id, departureDestination,arrivalDestination);
		this.isVisa = isVisa;
	}

	public NationalFlight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight,
				id,departureDestination, arrivalDestination);
		
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
