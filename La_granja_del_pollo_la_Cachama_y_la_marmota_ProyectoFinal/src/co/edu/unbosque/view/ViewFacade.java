package co.edu.unbosque.view;

public class ViewFacade {
	private HomeWindow home;
	private Schedule schedule;
	private WorkShifts shifts;
	private Treatments treatments;
	private ShowOptions ShowOptions;
	private AddMenu personMenu;
	private Reports reports;
	private User users;

	public ViewFacade() {
		home = new HomeWindow();
		schedule = new Schedule();
		shifts = new WorkShifts();
		treatments = new Treatments();
		ShowOptions = new ShowOptions();
		personMenu= new AddMenu();
		reports= new Reports();
		users= new User();
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

	public ShowOptions getShowOptions() {
		return ShowOptions;
	}

	public void setShowOptions(ShowOptions ShowOptions) {
		this.ShowOptions = ShowOptions;
	}

	public AddMenu getPersonMenu() {
		return personMenu;
	}

	public void setPersonMenu(AddMenu personMenu) {
		this.personMenu = personMenu;
	}

	public Reports getReports() {
		return reports;
	}

	public void setReports(Reports reports) {
		this.reports = reports;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

}
