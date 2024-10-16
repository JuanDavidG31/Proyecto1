package co.edu.unbosque.view;

public class ViewFacade {
	private HomeWindow home;
	private Schedule schedule;
	private WorkShifts shifts;
	private Treatments treatemnets;

	public ViewFacade() {
		home= new HomeWindow();
		schedule= new Schedule();
		shifts= new WorkShifts();
		treatemnets= new Treatments();
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

	public Treatments getTreatemnets() {
		return treatemnets;
	}

	public void setTreatemnets(Treatments treatemnets) {
		this.treatemnets = treatemnets;
	}
	
}
