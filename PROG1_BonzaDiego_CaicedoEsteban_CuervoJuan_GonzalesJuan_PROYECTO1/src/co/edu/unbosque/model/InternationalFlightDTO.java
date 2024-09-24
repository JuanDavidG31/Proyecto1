package co.edu.unbosque.model;

import java.io.Serializable;

public class InternationalFlightDTO extends Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination, boolean isTurboProp, boolean isTurbine) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
				departureDestination, arrivalDestination);
		this.isTurboProp = isTurboProp;
		this.isTurbine = isTurbine;
	}

	public InternationalFlightDTO(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, int id, String departureDestination,
			String arrivalDestination) {
		super(companyName, passengersNumber, nameCaptain, nameSecondCommand, departureTime, arrivalTime, fuelWeight, id,
				departureDestination, arrivalDestination);
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
