package co.edu.unbosque.view;

public class ViewFacade {
	private HomeWindow home;
	private Schedule schedule;
	private WorkShifts shifts;
	private Treatments treatments;
	private ShowTreatment showTreatment;

	public ViewFacade() {
		home = new HomeWindow();
		schedule = new Schedule();
		shifts = new WorkShifts();
		treatments = new Treatments();
		showTreatment = new ShowTreatment();
	}

	public HomeWindow getHome() {
		return home;
	}

	public void setHome(HomeWindow home) {
		this.home = home;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public WorkShifts getShifts() {
		return shifts;
	}

	public void setShifts(WorkShifts shifts) {
		this.shifts = shifts;
	}

	public Treatments getTreatments() {
		return treatments;
	}

	public void setTreatments(Treatments treatments) {
		this.treatments = treatments;
	}

	public ShowTreatment getShowTreatment() {
		return showTreatment;
	}

	public void setShowTreatment(ShowTreatment showTreatment) {
		this.showTreatment = showTreatment;
	}

}
