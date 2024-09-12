package co.edu.unbosque.model;

public abstract class Flight {

	private String companyName;
	private int passengersNumber;
	private String nameCaptain;
	private String nameSecondCommand;
	private int departureTime;
	private int arrivalTime;
	private int fuelWeight;
	private String id;

	public Flight() {

	}

	public Flight(String companyName, int passengersNumber, String nameCaptain, String nameSecondCommand,
			int departureTime, int arrivalTime, int fuelWeight, String id) {
		super();
		this.companyName = companyName;
		this.passengersNumber = passengersNumber;
		this.nameCaptain = nameCaptain;
		this.nameSecondCommand = nameSecondCommand;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fuelWeight = fuelWeight;
		this.id = id;
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

	@Override
	public String toString() {
		return "Fly [companyName=" + companyName + ", passengersNumber=" + passengersNumber + ", nameCaptain="
				+ nameCaptain + ", nameSecondCommand=" + nameSecondCommand + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", fuelWeight=" + fuelWeight + "]";
	}

}
