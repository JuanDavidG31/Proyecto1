package co.edu.unbosque.model;

import java.io.Serializable;

public abstract class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String companyName;
	private int passengersNumber;
	private String nameCaptain;
	private String nameSecondCommand;
	private int departureTime;
	private int arrivalTime;
	private int fuelWeight;
	private String id;
	private String departureDestination;
	private String arrivalDestination;

	public Flight() {

	}

	public Flight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, String id, String departureDestination,
			String arrivalDestination) {
		super();
		this.companyName = companyName;
		this.passengersNumber = passengersNumber;
		this.nameCaptain = nameCaptain;
		this.nameSecondCommand = nameSecondCommand;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fuelWeight = fuelWeight;
		this.id = id;
		this.departureDestination = departureDestination;
		this.arrivalDestination = arrivalDestination;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getPassengersNumber() {
		return passengersNumber;
	}

	public void setPassengersNumber(int passengersNumber) {
		this.passengersNumber = passengersNumber;
	}

	public String getNameCaptain() {
		return nameCaptain;
	}

	public void setNameCaptain(String nameCaptain) {
		this.nameCaptain = nameCaptain;
	}

	public String getNameSecondCommand() {
		return nameSecondCommand;
	}

	public void setNameSecondCommand(String nameSecondCommand) {
		this.nameSecondCommand = nameSecondCommand;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getFuelWeight() {
		return fuelWeight;
	}

	public void setFuelWeight(int fuelWeight) {
		this.fuelWeight = fuelWeight;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepartureDestination() {
		return departureDestination;
	}

	public void setDepartureDestination(String departureDestination) {
		this.departureDestination = departureDestination;
	}

	public String getArrivalDestination() {
		return arrivalDestination;
	}

	public void setArrivalDestination(String arrivalDestination) {
		this.arrivalDestination = arrivalDestination;
	}

	@Override
	public String toString() {
		return "Flight [companyName=" + companyName + ", passengersNumber=" + passengersNumber + ", nameCaptain="
				+ nameCaptain + ", nameSecondCommand=" + nameSecondCommand + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", fuelWeight=" + fuelWeight + ", id=" + id
				+ ", departureDestination=" + departureDestination + ", arrivalDestination=" + arrivalDestination + "]";
	}

}
