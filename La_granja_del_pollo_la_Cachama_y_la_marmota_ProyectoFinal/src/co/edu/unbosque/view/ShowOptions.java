package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowOptions extends JFrame {

	private JPanel mainPanel, datePanel, newPersonPanel, personPanel,idPanel;
	private JComboBox<String> treatment, fechasDeReagendarCita;
	private JLabel background1, backgroundD, backgroundP, backgroundM;
	private JButton selectTreatment, home, person, doctor, menu2,newPerson,updatePerson,home2, returnMenu, selectDate;

	public ShowOptions() {
		window();
		panels();
		comboBox();
		buttons();
		backgorunds();

		add(mainPanel);
		add(datePanel);
		add(newPersonPanel);
		add(personPanel);

		mainPanel.setVisible(false);
		datePanel.setVisible(false);
		newPersonPanel.setVisible(false);
		personPanel.setVisible(false);
	}

	private void backgorunds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTratamientos\\seleccionarTratamientoC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 470, 180);
		background1.setLayout(null);
		mainPanel.add(background1);

		backgroundD = new JLabel();
		ImageIcon date = new ImageIcon("Images\\menuCitas\\sCItaC.png");
		backgroundD.setIcon(date);
		backgroundD.setBounds(0, 0, 470, 180);
		backgroundD.setLayout(null);
		datePanel.add(backgroundD);

		backgroundP = new JLabel();
		ImageIcon person = new ImageIcon("Images\\menuCitas\\mPacienteC.png");
		backgroundP.setIcon(person);
		backgroundP.setBounds(0, 0, 470, 180);
		backgroundP.setLayout(null);
		newPersonPanel.add(backgroundP);

		backgroundM = new JLabel();
		ImageIcon menu = new ImageIcon("Images\\menuAniadir\\menuPacienteC.png");
		backgroundM.setIcon(menu);
		backgroundM.setBounds(0, 0, 470, 180);
		backgroundM.setLayout(null);
		personPanel.add(backgroundM);

	}

	private void buttons() {
		selectTreatment = new JButton();
		selectTreatment.setBounds(167, 130, 157, 41);
		selectTreatment.setBorderPainted(false);
		selectTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectTreatment.setToolTipText("Seleccionar Tratamiento a mostrar");
		ImageIcon imageRegister = new ImageIcon("Images\\menuTratamientos\\selectC.png");
		Image scaledRegister = imageRegister.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		selectTreatment.setIcon(new ImageIcon(scaledRegister));
		mainPanel.add(selectTreatment);

		home = new JButton();
		home.setBounds(340, 130, 42, 42);
		home.setBorderPainted(false);
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.setToolTipText("Menú principal de tratamientos");
		ImageIcon image5 = new ImageIcon("Images\\menuTratamientos\\back1.png");
		Image scaled5 = image5.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);

		person = new JButton();
		person.setBounds(106, 51, 110, 110);
		person.setToolTipText("Menú para añadir un nuevo paciente");
		person.setBorderPainted(false);
		person.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon imageP = new ImageIcon("Images\\menuCitas\\nPacienteC.png");
		Image scaledP = imageP.getImage().getScaledInstance(110, 110, Image.SCALE_REPLICATE);
		person.setIcon(new ImageIcon(scaledP));
		newPersonPanel.add(person);

		doctor = new JButton();
		doctor.setBounds(266, 51, 110, 110);
		doctor.setToolTipText("Menú para añadir un Especialista");
		doctor.setBorderPainted(false);
		doctor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon imageD = new ImageIcon("Images\\menuCitas\\nDoctorC.png");
		Image scaledD = imageD.getImage().getScaledInstance(110, 110, Image.SCALE_REPLICATE);
		doctor.setIcon(new ImageIcon(scaledD));
		newPersonPanel.add(doctor);

		returnMenu = new JButton();
		returnMenu.setBounds(417, 135, 42, 42);
		returnMenu.setBorderPainted(false);
		returnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnMenu.setToolTipText("Menú principal");
		ImageIcon imageR = new ImageIcon("Images\\menuTratamientos\\back1.png");
		Image scaledR = imageR.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		returnMenu.setIcon(new ImageIcon(scaledR));
		newPersonPanel.add(returnMenu);

		menu2 = new JButton();
		menu2.setBounds(334, 128, 42, 42);
		menu2.setBorderPainted(false);
		menu2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		menu2.setToolTipText("Menú principal");
		menu2.setIcon(new ImageIcon(scaledR));
		datePanel.add(menu2);

		selectDate = new JButton();
		selectDate.setBounds(167, 130, 157, 41);
		selectDate.setBorderPainted(false);
		selectDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectDate.setToolTipText("Seleccionar fecha de la cita medica");
		ImageIcon imageDate = new ImageIcon("Images\\menuCitas\\seleccionarFechaC.png");
		Image scaledDate = imageDate.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		selectDate.setIcon(new ImageIcon(scaledDate));
		datePanel.add(selectDate);
		
		newPerson = new JButton();
		newPerson.setBounds(106, 51, 110, 110);
		newPerson.setToolTipText("Añadir un nuevo paciente");
		newPerson.setBorderPainted(false);
		newPerson.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon imagePerson = new ImageIcon("Images\\menuAniadir\\crearPacienteC.png");
		Image scaledPerson = imagePerson.getImage().getScaledInstance(110, 110, Image.SCALE_REPLICATE);
		newPerson.setIcon(new ImageIcon(scaledPerson));
		personPanel.add(newPerson);
		
		updatePerson = new JButton();
		updatePerson.setBounds(266, 51, 110, 110);
		updatePerson.setToolTipText("Actualizar un paciente existente");
		updatePerson.setBorderPainted(false);
		updatePerson.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon imageUP = new ImageIcon("Images\\menuAniadir\\actualizarPacienteC.png");
		Image scaledUP = imageUP.getImage().getScaledInstance(110, 110, Image.SCALE_REPLICATE);
		updatePerson.setIcon(new ImageIcon(scaledUP));
		personPanel.add(updatePerson);
		
		home2 = new JButton();
		home2.setBounds(417, 135, 42, 42);
		home2.setBorderPainted(false);
		home2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home2.setToolTipText("Menú principal de tratamientos");
		home2.setIcon(new ImageIcon(scaled5));
		personPanel.add(home2);
		
	}

	private void comboBox() {
		treatment = new JComboBox<String>();
		treatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		treatment.setBounds(176, 70, 251, 30);
		treatment.setBorder(null);
		treatment.addItem("");
		mainPanel.add(treatment);

		fechasDeReagendarCita = new JComboBox<String>();
		fechasDeReagendarCita.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fechasDeReagendarCita.setBounds(176, 70, 251, 30);
		fechasDeReagendarCita.setBorder(null);
		fechasDeReagendarCita.addItem("");
		datePanel.add(fechasDeReagendarCita);

	}

	private void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 480, 215);
		mainPanel.setLayout(null);

		datePanel = new JPanel();
		datePanel.setBounds(0, 0, 480, 215);
		datePanel.setLayout(null);

		newPersonPanel = new JPanel();
		newPersonPanel.setBounds(0, 0, 480, 215);
		newPersonPanel.setLayout(null);

		personPanel = new JPanel();
		personPanel.setBounds(0, 0, 480, 215);
		personPanel.setLayout(null);
		
		idPanel= new JPanel();
		idPanel.setBounds(0, 0, 480, 215);
		idPanel.setLayout(null);

	}

	public void window() {

		setBounds(0, 0, 480, 215);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getDatePanel() {
		return datePanel;
	}

	public void setDatePanel(JPanel datePanel) {
		this.datePanel = datePanel;
	}

	public JPanel getNewPersonPanel() {
		return newPersonPanel;
	}

	public void setNewPersonPanel(JPanel newPersonPanel) {
		this.newPersonPanel = newPersonPanel;
	}

	public JPanel getPersonPanel() {
		return personPanel;
	}

	public void setPersonPanel(JPanel personPanel) {
		this.personPanel = personPanel;
	}

	public JPanel getIdPanel() {
		return idPanel;
	}

	public void setIdPanel(JPanel idPanel) {
		this.idPanel = idPanel;
	}

	public JComboBox<String> getTreatment() {
		return treatment;
	}

	public void setTreatment(JComboBox<String> treatment) {
		this.treatment = treatment;
	}

	public JComboBox<String> getFechasDeReagendarCita() {
		return fechasDeReagendarCita;
	}

	public void setFechasDeReagendarCita(JComboBox<String> fechasDeReagendarCita) {
		this.fechasDeReagendarCita = fechasDeReagendarCita;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JLabel getBackgroundD() {
		return backgroundD;
	}

	public void setBackgroundD(JLabel backgroundD) {
		this.backgroundD = backgroundD;
	}

	public JLabel getBackgroundP() {
		return backgroundP;
	}

	public void setBackgroundP(JLabel backgroundP) {
		this.backgroundP = backgroundP;
	}

	public JLabel getBackgroundM() {
		return backgroundM;
	}

	public void setBackgroundM(JLabel backgroundM) {
		this.backgroundM = backgroundM;
	}

	public JButton getSelectTreatment() {
		return selectTreatment;
	}

	public void setSelectTreatment(JButton selectTreatment) {
		this.selectTreatment = selectTreatment;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JButton getPerson() {
		return person;
	}

	public void setPerson(JButton person) {
		this.person = person;
	}

	public JButton getDoctor() {
		return doctor;
	}

	public void setDoctor(JButton doctor) {
		this.doctor = doctor;
	}

	public JButton getMenu2() {
		return menu2;
	}

	public void setMenu2(JButton menu2) {
		this.menu2 = menu2;
	}

	public JButton getNewPerson() {
		return newPerson;
	}

	public void setNewPerson(JButton newPerson) {
		this.newPerson = newPerson;
	}

	public JButton getUpdatePerson() {
		return updatePerson;
	}

	public void setUpdatePerson(JButton updatePerson) {
		this.updatePerson = updatePerson;
	}

	public JButton getReturnMenu() {
		return returnMenu;
	}

	public void setReturnMenu(JButton returnMenu) {
		this.returnMenu = returnMenu;
	}

	public JButton getSelectDate() {
		return selectDate;
	}

	public void setSelectDate(JButton selectDate) {
		this.selectDate = selectDate;
	}

	public JButton getHome2() {
		return home2;
	}

	public void setHome2(JButton home2) {
		this.home2 = home2;
	}



}
