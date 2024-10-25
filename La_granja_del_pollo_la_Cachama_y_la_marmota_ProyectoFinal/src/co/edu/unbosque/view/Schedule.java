package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Schedule extends JFrame {
	private JPanel mainPanel, schedulePanel, reschedulePanel, cancelPanel, infoPanel;
	private JTextField name1, email, appointmentNumber;
	private JComboBox<String> doctor, specialty;
	private JButton generate, home, scheduleButton, rescheduleButton, cancelButton, reGenerate, 
	cancel,homeSchedule,homeReschedule,homeCancel;
	private JButton themeMain, schTheme, reTheme, canTheme, infoName, infoEmail, infospecialty, 
	infoDoctor, infoDate,infoNDate,infoNum,infoNumCancel;
	private JLabel background1, background2, background3, background4;

	public Schedule() {
		window();
		panels();
		inputs();
		comboBox();
		headlines();
		info();
		buttons();
		backgorunds();

		add(mainPanel);
		add(infoPanel);
		add(schedulePanel);
		add(reschedulePanel);
		add(cancelPanel);

		schedulePanel.setVisible(false);
		reschedulePanel.setVisible(false);
		cancelPanel.setVisible(false);
		infoPanel.setVisible(false);
	}

	private void info() {
		infoName = new JButton();
		infoName.setBounds(0, 2, 34, 34);
		infoName.setBorderPainted(false);
		infoName.setToolTipText("");
		ImageIcon image12 = new ImageIcon("Images\\infoButtons\\1.png");
		Image scaled12 = image12.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);
		infoName.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoName);
		
		infoEmail = new JButton();
		infoEmail.setBounds(0, 43, 34, 34);
		infoEmail.setBorderPainted(false);
		infoEmail.setToolTipText("");
		infoEmail.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoEmail);
		
		infospecialty = new JButton();
		infospecialty.setBounds(0, 84, 34, 34);
		infospecialty.setBorderPainted(false);
		infospecialty.setToolTipText("");
		infospecialty.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infospecialty);
	
		infoDoctor = new JButton();
		infoDoctor.setBounds(0, 125, 34, 34);
		infoDoctor.setBorderPainted(false);
		infoDoctor.setToolTipText("");
		infoDoctor.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoDoctor);
		
		infoDate = new JButton();
		infoDate.setBounds(0, 167, 34, 34);
		infoDate.setBorderPainted(false);
		infoDate.setToolTipText("");
		infoDate.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoDate);
		
		infoNDate = new JButton();
		infoNDate.setBounds(0, 74, 34, 34);
		infoNDate.setBorderPainted(false);
		infoNDate.setToolTipText("");
		infoNDate.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoNDate);
		
		infoNum = new JButton();
		infoNum.setBounds(0, 117, 34, 34);
		infoNum.setBorderPainted(false);
		infoNum.setToolTipText("");
		infoNum.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoNum);
		
		infoNumCancel = new JButton();
		infoNumCancel.setBounds(0, 90, 34, 34);
		infoNumCancel.setBorderPainted(false);
		infoNumCancel.setToolTipText("");
		infoNumCancel.setIcon(new ImageIcon(scaled12));
		infoPanel.add(infoNumCancel);
	}

	private void backgorunds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuCitas\\menuControlCitasClaro.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);

		background2 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("Images\\menuCitas\\agendarCita.png");
		background2.setIcon(imagen1);
		background2.setBounds(0, 0, 790, 565);
		background2.setLayout(null);
		schedulePanel.add(background2);

		background3 = new JLabel();
		ImageIcon imagen2 = new ImageIcon("Images\\menuCitas\\reagendarCita.png");
		background3.setIcon(imagen2);
		background3.setBounds(0, 0, 790, 565);
		background3.setLayout(null);
		reschedulePanel.add(background3);

		background4 = new JLabel();
		ImageIcon imagen3 = new ImageIcon("Images\\menuCitas\\cancelarCita.png");
		background4.setIcon(imagen3);
		background4.setBounds(0, 0, 790, 565);
		background4.setLayout(null);
		cancelPanel.add(background4);

	}

	public void window() {
		setBounds(0, 0, 800, 600); // Window position and size (where it starts in x, where it starts in y,
									// wide,high)
		setTitle(""); // tittle on window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Close window and close the software
		setResizable(false);
		setLayout(null);

	}

	public void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

		schedulePanel = new JPanel();
		schedulePanel.setBounds(0, 0, 800, 600);
		schedulePanel.setLayout(null);

		reschedulePanel = new JPanel();
		reschedulePanel.setBounds(0, 0, 800, 600);
		reschedulePanel.setLayout(null);

		cancelPanel = new JPanel();
		cancelPanel.setBounds(0, 0, 800, 600);
		cancelPanel.setLayout(null);

		infoPanel = new JPanel();
		infoPanel.setBounds(614, 170, 40, 210);
		infoPanel.setBackground(new Color(0, 74, 173));
		infoPanel.setLayout(null);
	}

	private void comboBox() {
		doctor = new JComboBox<String>();
		doctor.setBounds(356, 297, 251, 30);
		doctor.addItem("");
		doctor.addItem("nombre 1");
		doctor.addItem("nombre 2");
		doctor.addItem("nombre 3");
		doctor.addItem("nombre 4");
		doctor.addItem("nombre 5");
		doctor.addItem("nombre 6");
		doctor.addItem("nombre 7");
		schedulePanel.add(doctor);

		specialty = new JComboBox<String>();
		specialty.setBounds(356, 256, 251, 30);
		specialty.addItem("");
		specialty.addItem("1");
		specialty.addItem("2");
		specialty.addItem("3");
		specialty.addItem("4");
		specialty.addItem("5");
		specialty.addItem("6");
		specialty.addItem("7");
		schedulePanel.add(specialty);

	}

	public void inputs() {
		name1 = new JTextField();
		name1.setBorder(null);
		name1.setBounds(356, 175, 251, 30);
		schedulePanel.add(name1);

		email = new JTextField();
		email.setBorder(null);
		email.setBounds(356, 215, 251, 30);
		schedulePanel.add(email);

		appointmentNumber = new JTextField();
		appointmentNumber.setBorder(null);
		appointmentNumber.setBounds(354, 245, 251, 30);
		cancelPanel.add(appointmentNumber);
		

	}

	public void buttons() {

		themeMain = new JButton();
		themeMain.setBounds(41, 465, 82, 79);
		themeMain.setBorderPainted(false);
		themeMain.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image1 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled1 = image1.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		themeMain.setIcon(new ImageIcon(scaled1));
		mainPanel.add(themeMain);

		schTheme = new JButton();
		schTheme.setBounds(41, 465, 82, 79);
		schTheme.setBorderPainted(false);
		schTheme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image2 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled2 = image2.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		schTheme.setIcon(new ImageIcon(scaled2));
		schedulePanel.add(schTheme);

		reTheme = new JButton();
		reTheme.setBounds(41, 465, 82, 79);
		reTheme.setBorderPainted(false);
		reTheme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image3 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled3 = image3.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		reTheme.setIcon(new ImageIcon(scaled3));
		reschedulePanel.add(reTheme);

		canTheme = new JButton();
		canTheme.setBounds(41, 465, 82, 79);
		canTheme.setBorderPainted(false);
		canTheme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image4 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled4 = image4.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		canTheme.setIcon(new ImageIcon(scaled4));
		cancelPanel.add(canTheme);

		home = new JButton();
		home.setBounds(655, 465, 79, 79);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal");
		ImageIcon image5 = new ImageIcon("Images\\backButtons\\1.png");
		Image scaled5 = image5.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);

		scheduleButton = new JButton();
		scheduleButton.setBounds(274, 101, 251, 118);
		scheduleButton.setBorderPainted(false);
		scheduleButton.setToolTipText("Agendar una nueva cita medica");
		ImageIcon image6 = new ImageIcon("Images\\menuCitas\\1.png");
		Image scaled6 = image6.getImage().getScaledInstance(252, 118, Image.SCALE_REPLICATE);
		scheduleButton.setIcon(new ImageIcon(scaled6));
		mainPanel.add(scheduleButton);

		rescheduleButton = new JButton();
		rescheduleButton.setBounds(275, 235, 250, 118);
		rescheduleButton.setBorderPainted(false);
		rescheduleButton.setToolTipText("Re-Agendar una nueva cita medica");
		ImageIcon image7 = new ImageIcon("Images\\menuCitas\\3.png");
		Image scaled7 = image7.getImage().getScaledInstance(252, 118, Image.SCALE_REPLICATE);
		rescheduleButton.setIcon(new ImageIcon(scaled7));
		mainPanel.add(rescheduleButton);

		cancelButton = new JButton();
		cancelButton.setBounds(276, 370, 245, 112);
		cancelButton.setBorderPainted(false);
		cancelButton.setToolTipText("Cancelar una nueva cita medica");
		ImageIcon image8 = new ImageIcon("Images\\menuCitas\\5.png");
		Image scaled8 = image8.getImage().getScaledInstance(252, 118, Image.SCALE_REPLICATE);
		cancelButton.setIcon(new ImageIcon(scaled8));
		mainPanel.add(cancelButton);

		generate = new JButton();
		generate.setBounds(352, 422, 160, 40);
		generate.setBorderPainted(false);
		generate.setToolTipText("Agendar cita medica");
		ImageIcon image9 = new ImageIcon("Images\\botonesCitas\\agendarClaro.png");
		generate.setIcon(image9);
		schedulePanel.add(generate);

		reGenerate = new JButton();
		reGenerate.setBounds(348, 375, 160, 40);
		reGenerate.setBorderPainted(false);
		reGenerate.setToolTipText("Reagendar cita medica");
		ImageIcon image10 = new ImageIcon("Images\\botonesCitas\\reagendarClaro.png");
		reGenerate.setIcon(image10);
		reschedulePanel.add(reGenerate);

		cancel = new JButton();
		cancel.setBounds(348, 375, 160, 40);
		cancel.setBorderPainted(false);
		cancel.setToolTipText("Cancelar cita medica");
		ImageIcon image11 = new ImageIcon("Images\\botonesCitas\\cancelarClaro.png");
		cancel.setIcon(image11);
		cancelPanel.add(cancel);
		
		homeSchedule = new JButton();
		homeSchedule.setBounds(565, 419, 42, 42);
		homeSchedule.setBorderPainted(false);
		homeSchedule.setToolTipText("Menú principal");
		ImageIcon image13 = new ImageIcon("Images\\backButtons\\m1.png");
		Image scaled13 = image13.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		homeSchedule.setIcon(new ImageIcon(scaled13));
		schedulePanel.add(homeSchedule);
		
		homeReschedule = new JButton();
		homeReschedule.setBounds(560, 373, 42, 42);
		homeReschedule.setBorderPainted(false);
		homeReschedule.setToolTipText("Menú principal");
		ImageIcon image14 = new ImageIcon("Images\\backButtons\\m1.png");
		Image scaled14 = image14.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		homeReschedule.setIcon(new ImageIcon(scaled14));
		reschedulePanel.add(homeReschedule);

		homeCancel = new JButton();
		homeCancel.setBounds(560, 373, 42, 42);
		homeCancel.setBorderPainted(false);
		homeCancel.setToolTipText("Menú principal");
		ImageIcon image15 = new ImageIcon("Images\\backButtons\\m1.png");
		Image scaled15 = image15.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		homeCancel.setIcon(new ImageIcon(scaled15));
		cancelPanel.add(homeCancel);


	}

	public void headlines() {
		// TODO Auto-generated method stub

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JTextField getName1() {
		return name1;
	}

	public void setName1(JTextField name1) {
		this.name1 = name1;
	}

	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JComboBox<String> getDoctor() {
		return doctor;
	}

	public void setDoctor(JComboBox<String> doctor) {
		this.doctor = doctor;
	}

	public JComboBox<String> getSpecialty() {
		return specialty;
	}

	public void setSpecialty(JComboBox<String> specialty) {
		this.specialty = specialty;
	}

	public JButton getGenerate() {
		return generate;
	}

	public void setGenerate(JButton generate) {
		this.generate = generate;
	}

	public JPanel getSchedulePanel() {
		return schedulePanel;
	}

	public void setSchedulePanel(JPanel schedulePanel) {
		this.schedulePanel = schedulePanel;
	}

	public JPanel getReschedulePanel() {
		return reschedulePanel;
	}

	public void setReschedulePanel(JPanel reschedulePanel) {
		this.reschedulePanel = reschedulePanel;
	}

	public JPanel getCancelPanel() {
		return cancelPanel;
	}

	public void setCancelPanel(JPanel cancelPanel) {
		this.cancelPanel = cancelPanel;
	}

	public JButton getThemeMain() {
		return themeMain;
	}

	public void setThemeMain(JButton themeMain) {
		this.themeMain = themeMain;
	}

	public JButton getSchTheme() {
		return schTheme;
	}

	public void setSchTheme(JButton schTheme) {
		this.schTheme = schTheme;
	}

	public JButton getReTheme() {
		return reTheme;
	}

	public void setReTheme(JButton reTheme) {
		this.reTheme = reTheme;
	}

	public JButton getCanTheme() {
		return canTheme;
	}

	public void setCanTheme(JButton canTheme) {
		this.canTheme = canTheme;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JLabel getBackground2() {
		return background2;
	}

	public void setBackground2(JLabel background2) {
		this.background2 = background2;
	}

	public JLabel getBackground3() {
		return background3;
	}

	public void setBackground3(JLabel background3) {
		this.background3 = background3;
	}

	public JLabel getBackground4() {
		return background4;
	}

	public void setBackground4(JLabel background4) {
		this.background4 = background4;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JButton getScheduleButton() {
		return scheduleButton;
	}

	public void setScheduleButton(JButton scheduleButton) {
		this.scheduleButton = scheduleButton;
	}

	public JButton getRescheduleButton() {
		return rescheduleButton;
	}

	public void setRescheduleButton(JButton rescheduleButton) {
		this.rescheduleButton = rescheduleButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(JPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public JTextField getAppointmentNumber() {
		return appointmentNumber;
	}

	public void setAppointmentNumber(JTextField appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}

	public JButton getReGenerate() {
		return reGenerate;
	}

	public void setReGenerate(JButton reGenerate) {
		this.reGenerate = reGenerate;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public JButton getInfoName() {
		return infoName;
	}

	public void setInfoName(JButton infoName) {
		this.infoName = infoName;
	}

	public JButton getInfoEmail() {
		return infoEmail;
	}

	public void setInfoEmail(JButton infoEmail) {
		this.infoEmail = infoEmail;
	}

	public JButton getInfospecialty() {
		return infospecialty;
	}

	public void setInfospecialty(JButton infospecialty) {
		this.infospecialty = infospecialty;
	}

	public JButton getInfoDoctor() {
		return infoDoctor;
	}

	public void setInfoDoctor(JButton infoDoctor) {
		this.infoDoctor = infoDoctor;
	}

	public JButton getInfoDate() {
		return infoDate;
	}

	public void setInfoDate(JButton infoDate) {
		this.infoDate = infoDate;
	}

	public JButton getInfoNDate() {
		return infoNDate;
	}

	public void setInfoNDate(JButton infoNDate) {
		this.infoNDate = infoNDate;
	}

	public JButton getInfoNum() {
		return infoNum;
	}

	public void setInfoNum(JButton infoNum) {
		this.infoNum = infoNum;
	}

	public JButton getInfoNumCancel() {
		return infoNumCancel;
	}

	public void setInfoNumCancel(JButton infoNumCancel) {
		this.infoNumCancel = infoNumCancel;
	}

	public JButton getHomeSchedule() {
		return homeSchedule;
	}

	public void setHomeSchedule(JButton homeSchedule) {
		this.homeSchedule = homeSchedule;
	}

	public JButton getHomeReschedule() {
		return homeReschedule;
	}

	public void setHomeReschedule(JButton homeReschedule) {
		this.homeReschedule = homeReschedule;
	}

	public JButton getHomeCancel() {
		return homeCancel;
	}

	public void setHomeCancel(JButton homeCancel) {
		this.homeCancel = homeCancel;
	}

}
