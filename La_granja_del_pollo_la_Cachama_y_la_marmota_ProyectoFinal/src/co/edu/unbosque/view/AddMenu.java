package co.edu.unbosque.view;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel personPanel, doctorPanel;
	private JLabel background1, background2;
	private JTextField patientId, doctorId, doctorName, patientName, patientAge, emailDoctor, emailPatient;
	private JComboBox<String> speciality;
	private JButton createPerson, createDoctor, homeP, homeD;

	public AddMenu() {
		window();
		panels();
		inputs();
		comboBox();
		info();
		buttons();
		backGrounds();

		personPanel.setVisible(false);
		doctorPanel.setVisible(false);

		add(personPanel);
		add(doctorPanel);
	}

	private void comboBox() {
		speciality = new JComboBox<String>();
		speciality.setBounds(356, 305, 251, 30);
		speciality.setCursor(new Cursor(Cursor.HAND_CURSOR));
		speciality.addItem("");
		speciality.addItem("1");
		speciality.addItem("2");
		speciality.addItem("3");
		speciality.addItem("4");
		speciality.addItem("5");
		speciality.addItem("6");
		speciality.addItem("7");
		doctorPanel.add(speciality);

	}

	private void info() {

	}

	private void inputs() {
		patientId = new JTextField();
		patientId.setBounds(356, 198, 251, 30);
		patientId.setCursor(new Cursor(Cursor.HAND_CURSOR));
		patientId.setBorder(null);
		personPanel.add(patientId);

		doctorId = new JTextField();
		doctorId.setCursor(new Cursor(Cursor.HAND_CURSOR));
		doctorId.setBounds(356, 198, 251, 30);
		doctorId.setBorder(null);
		doctorPanel.add(doctorId);

		patientName = new JTextField();
		patientName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		patientName.setBounds(356, 236, 251, 30);
		patientName.setBorder(null);
		personPanel.add(patientName);

		doctorName = new JTextField();
		doctorName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		doctorName.setBounds(356, 236, 251, 30);
		doctorName.setBorder(null);
		doctorPanel.add(doctorName);

		patientAge = new JTextField();
		patientAge.setCursor(new Cursor(Cursor.HAND_CURSOR));
		patientAge.setBounds(356, 274, 251, 30);
		patientAge.setBorder(null);
		personPanel.add(patientAge);

		emailDoctor = new JTextField();
		emailDoctor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		emailDoctor.setBounds(356, 270, 251, 30);
		emailDoctor.setBorder(null);
		doctorPanel.add(emailDoctor);

		emailPatient = new JTextField();
		emailPatient.setCursor(new Cursor(Cursor.HAND_CURSOR));
		emailPatient.setBounds(356, 312, 251, 30);
		emailPatient.setBorder(null);
		personPanel.add(emailPatient);

	}

	private void window() {
		setBounds(0, 0, 800, 600);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	private void backGrounds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuAniadir\\crearPaClaro.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		personPanel.add(background1);

		background2 = new JLabel();
		ImageIcon doctor = new ImageIcon("Images\\menuAniadir\\crearDoClaro.png");
		background2.setIcon(doctor);
		background2.setBounds(0, 0, 790, 565);
		background2.setLayout(null);
		doctorPanel.add(background2);
	}

	private void buttons() {
		createPerson = new JButton();
		createPerson.setBounds(328, 385, 162, 38);
		createPerson.setBorder(null);
		createPerson.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon createP = new ImageIcon("Images\\menuAniadir\\anadirPaC.png");
		createPerson.setIcon(createP);
		personPanel.add(createPerson);

		createDoctor = new JButton();
		createDoctor.setBounds(327, 385, 162, 38);
		createDoctor.setBorder(null);
		createDoctor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon createD = new ImageIcon("Images\\menuAniadir\\anadirDoC.png");
		createDoctor.setIcon(createD);
		doctorPanel.add(createDoctor);

		homeP = new JButton();
		homeP.setBounds(528, 382, 42, 42);
		homeP.setBorderPainted(false);
		homeP.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeP.setToolTipText("Menú principal");
		ImageIcon image13 = new ImageIcon("Images\\backButtons\\m1.png");
		homeP.setIcon(image13);
		personPanel.add(homeP);

		homeD = new JButton();
		homeD.setBounds(515, 382, 42, 42);
		homeD.setBorderPainted(false);
		homeD.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeD.setToolTipText("Menú principal");
		homeD.setIcon(image13);
		doctorPanel.add(homeD);

	}

	private void panels() {
		personPanel = new JPanel();
		personPanel.setBounds(0, 0, 800, 600);
		personPanel.setLayout(null);

		doctorPanel = new JPanel();
		doctorPanel.setBounds(0, 0, 800, 600);
		doctorPanel.setLayout(null);

	}

	public JPanel getPersonPanel() {
		return personPanel;
	}

	public void setPersonPanel(JPanel personPanel) {
		this.personPanel = personPanel;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JPanel getDoctorPanel() {
		return doctorPanel;
	}

	public void setDoctorPanel(JPanel doctorPanel) {
		this.doctorPanel = doctorPanel;
	}

	public JLabel getBackground2() {
		return background2;
	}

	public void setBackground2(JLabel background2) {
		this.background2 = background2;
	}

	public JTextField getPatientId() {
		return patientId;
	}

	public void setPatientId(JTextField patientId) {
		this.patientId = patientId;
	}

	public JTextField getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(JTextField doctorId) {
		this.doctorId = doctorId;
	}

	public JTextField getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(JTextField doctorName) {
		this.doctorName = doctorName;
	}

	public JTextField getPatientName() {
		return patientName;
	}

	public void setPatientName(JTextField patientName) {
		this.patientName = patientName;
	}

	public JTextField getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(JTextField patientAge) {
		this.patientAge = patientAge;
	}

	public JTextField getEmailDoctor() {
		return emailDoctor;
	}

	public void setEmailDoctor(JTextField emailDoctor) {
		this.emailDoctor = emailDoctor;
	}

	public JTextField getEmailPatient() {
		return emailPatient;
	}

	public void setEmailPatient(JTextField emailPatient) {
		this.emailPatient = emailPatient;
	}

	public JComboBox<String> getSpeciality() {
		return speciality;
	}

	public void setSpeciality(JComboBox<String> speciality) {
		this.speciality = speciality;
	}

	public JButton getCreatePerson() {
		return createPerson;
	}

	public void setCreatePerson(JButton createPerson) {
		this.createPerson = createPerson;
	}

	public JButton getCreateDoctor() {
		return createDoctor;
	}

	public void setCreateDoctor(JButton createDoctor) {
		this.createDoctor = createDoctor;
	}

	public JButton getHomeP() {
		return homeP;
	}

	public void setHomeP(JButton homeP) {
		this.homeP = homeP;
	}

	public JButton getHomeD() {
		return homeD;
	}

	public void setHomeD(JButton homeD) {
		this.homeD = homeD;
	}

}
