package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Treatments extends JFrame {
	private JPanel mainPanel, newTreatmentPanel, searchTreatmentPanel, finishTreatmentPanel, infoPanel;
	private JLabel background1, background2, background3, background4;
	// botones de accion
	private JButton home, searchButton, homeTreatments1, homeTreatments2, homeTreatments3, themeMain, initTreatment,
			initSearchTreatment, initFinishTreatment, register, updateTreatment, finishTreatment;
	// Botones de info
	private JButton infoName, infospecialty, infoTreatment, infoStatus, infoSearchName, selectPatient;

	JComboBox<String> status, specialty, status2, specialty2, status3;
	private JTextField name1, name2, treatmentTxt, nameS, treatmentS, nameF, treatmentF, id1, id2, id3;

	public Treatments() {
		window();
		panels();
		inputs();
		comboBox();
		buttons();
		info();
		backgrounds();

		add(mainPanel);
		add(infoPanel);
		add(newTreatmentPanel);
		add(searchTreatmentPanel);
		add(finishTreatmentPanel);

		newTreatmentPanel.setVisible(false);
		searchTreatmentPanel.setVisible(false);
		finishTreatmentPanel.setVisible(false);

		infoPanel.setVisible(true);
	}

	private void comboBox() {
		status = new JComboBox<String>();
		status.setToolTipText("Seleccione el estado del Tratamiento");
		status.setCursor(new Cursor(Cursor.HAND_CURSOR));
		status.setBounds(350, 355, 250, 30);
		status.addItem("");
		status.addItem("En tratamiento");
		status.addItem("Finalizado");
		newTreatmentPanel.add(status);

		status2 = new JComboBox<String>();
		status2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		status2.setToolTipText("Seleccione el estado del Tratamiento");
		status2.setBounds(353, 357, 250, 30);
		status2.addItem("");
		status2.addItem("En tratamiento");
		status2.addItem("Finalizado");
		searchTreatmentPanel.add(status2);

		status3 = new JComboBox<String>();
		status3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		status3.setToolTipText("Seleccione el estado del Tratamiento");
		status3.setBounds(356, 307, 250, 30);
		status3.addItem("");
		status3.addItem("En tratamiento");
		status3.addItem("Finalizado");
		finishTreatmentPanel.add(status3);

		specialty = new JComboBox<String>();
		specialty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		specialty.setToolTipText("Seleccione Una especialidad");
		specialty.setBounds(350, 280, 250, 30);
		specialty.setBorder(null);
		specialty.addItem("");
		specialty.addItem("Cirugia");
		specialty.addItem("Oncologia");
		specialty.addItem("Dermatologia");
		specialty.addItem("Neomologia");
		specialty.addItem("Cardiologia");
		specialty.addItem("MedicinaInterna");
		newTreatmentPanel.add(specialty);

		specialty2 = new JComboBox<String>();
		specialty2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		specialty2.setToolTipText("Seleccione Una especialidad");
		specialty2.setBounds(353, 275, 250, 30);
		specialty2.setBorder(null);
		specialty2.addItem("");
		specialty2.addItem("Cirugia");
		specialty2.addItem("Oncologia");
		specialty2.addItem("Dermatologia");
		specialty2.addItem("Neomologia");
		specialty2.addItem("Cardiologia");
		specialty2.addItem("MedicinaInterna");
		searchTreatmentPanel.add(specialty2);

	}

	public void window() {
		setBounds(0, 0, 800, 600);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	public void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

		newTreatmentPanel = new JPanel();
		newTreatmentPanel.setBounds(0, 0, 800, 600);
		newTreatmentPanel.setLayout(null);

		searchTreatmentPanel = new JPanel();
		searchTreatmentPanel.setBounds(0, 0, 800, 600);
		searchTreatmentPanel.setLayout(null);

		finishTreatmentPanel = new JPanel();
		finishTreatmentPanel.setBounds(0, 0, 800, 600);
		finishTreatmentPanel.setLayout(null);

		infoPanel = new JPanel();
		infoPanel.setBounds(614, 175, 40, 210);
		infoPanel.setBackground(new Color(0, 74, 173));
		infoPanel.setLayout(null);

		// new Color(0, 74, 173)
	}

	private void info() {
		// INFO CREAR TRATAMIENTO
		infoName = new JButton();
		infoName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infoName.setBounds(0, 32, 34, 34);
		infoName.setBorderPainted(false);
		infoName.setToolTipText("Nombre del Paciente");
		ImageIcon imageInfo = new ImageIcon("Images\\infoButtons\\1.png");
		Image scaledInfo = imageInfo.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);
		infoName.setIcon(new ImageIcon(scaledInfo));
		infoPanel.add(infoName);

		infospecialty = new JButton();
		infospecialty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infospecialty.setBounds(0, 74, 34, 34);
		infospecialty.setBorderPainted(false);
		infospecialty.setToolTipText("Epecialidad del tratamiento");
		infospecialty.setIcon(new ImageIcon(scaledInfo));
		infoPanel.add(infospecialty);

		infoTreatment = new JButton();
		infoTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infoTreatment.setBounds(0, 113, 34, 34);
		infoTreatment.setBorderPainted(false);
		infoTreatment.setToolTipText("Este es el tratamiento a seguir para el paciente");
		infoTreatment.setIcon(new ImageIcon(scaledInfo));
		infoPanel.add(infoTreatment);

		infoStatus = new JButton();
		infoStatus.setCursor(new Cursor(Cursor.HAND_CURSOR));
		infoStatus.setBounds(0, 155, 34, 34);
		infoStatus.setBorderPainted(false);
		infoStatus.setToolTipText("Estado del tratamiento");
		infoStatus.setIcon(new ImageIcon(scaledInfo));
		infoPanel.add(infoStatus);

	}

	private void backgrounds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTratamientos\\menuTratamientosC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);

		background2 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("Images\\menuTratamientos\\nuevoTratamientoC.png");
		background2.setIcon(imagen1);
		background2.setBounds(0, 0, 790, 565);
		background2.setLayout(null);
		newTreatmentPanel.add(background2);

		background3 = new JLabel();
		ImageIcon imagen2 = new ImageIcon("Images\\menuTratamientos\\buscarTratamientoC.png");
		background3.setIcon(imagen2);
		background3.setBounds(0, 0, 790, 565);
		background3.setLayout(null);
		searchTreatmentPanel.add(background3);

		background4 = new JLabel();
		ImageIcon imagen3 = new ImageIcon("Images\\menuTratamientos\\finalizarTratamientoC.png");
		background4.setIcon(imagen3);
		background4.setBounds(0, 0, 790, 565);
		background4.setLayout(null);
		finishTreatmentPanel.add(background4);

	}

	public void inputs() {

		id1 = new JTextField();
		id1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		id1.setBorder(null);
		id1.setBounds(350, 205, 250, 29);
		newTreatmentPanel.add(id1);

		name1 = new JTextField();
		name1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		name1.setBorder(null);
		name1.setBounds(350, 242, 250, 29);
		name1.setEditable(false);
		newTreatmentPanel.add(name1);

		treatmentTxt = new JTextField();
		treatmentTxt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		treatmentTxt.setBorder(null);
		treatmentTxt.setBounds(350, 318, 250, 29);
		newTreatmentPanel.add(treatmentTxt);
//----------------------------------------------------------------------------

		id2 = new JTextField();
		id2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		id2.setBorder(null);
		id2.setBounds(352, 196, 250, 29);
		searchTreatmentPanel.add(id2);

		nameS = new JTextField();
		nameS.setCursor(new Cursor(Cursor.HAND_CURSOR));
		nameS.setBorder(null);
		nameS.setBounds(353, 235, 250, 29);
		searchTreatmentPanel.add(nameS);

		treatmentS = new JTextField();
		treatmentS.setCursor(new Cursor(Cursor.HAND_CURSOR));
		treatmentS.setBorder(null);
		treatmentS.setBounds(352, 316, 250, 29);
		searchTreatmentPanel.add(treatmentS);

//---------------------------------------------------------------------

		id3 = new JTextField();
		id3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		id3.setBorder(null);
		id3.setBounds(356, 228, 250, 29);
		finishTreatmentPanel.add(id3);

		treatmentF = new JTextField();
		treatmentF.setCursor(new Cursor(Cursor.HAND_CURSOR));
		treatmentF.setBorder(null);
		treatmentF.setBounds(356, 266, 250, 30);
		finishTreatmentPanel.add(treatmentF);

	}

	public void buttons() {
		themeMain = new JButton();
		themeMain.setCursor(new Cursor(Cursor.HAND_CURSOR));
		themeMain.setBounds(41, 465, 82, 79);
		themeMain.setBorderPainted(false);
		themeMain.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image1 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled1 = image1.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		themeMain.setIcon(new ImageIcon(scaled1));
		mainPanel.add(themeMain);

		home = new JButton();
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.setBounds(655, 465, 79, 79);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal");
		ImageIcon image5 = new ImageIcon("Images\\backButtons\\1.png");
		Image scaled5 = image5.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);

		homeTreatments1 = new JButton();
		homeTreatments1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeTreatments1.setBounds(560, 413, 42, 42);
		homeTreatments1.setBorderPainted(false);
		homeTreatments1.setToolTipText("Menú principal");
		ImageIcon imageHome = new ImageIcon("Images\\backButtons\\m1.png");
		Image scaledHome = imageHome.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		homeTreatments1.setIcon(new ImageIcon(scaledHome));
		newTreatmentPanel.add(homeTreatments1);

		homeTreatments2 = new JButton();
		homeTreatments2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeTreatments2.setBounds(545, 420, 42, 42);
		homeTreatments2.setBorderPainted(false);
		homeTreatments2.setToolTipText("Menú principal");
		homeTreatments2.setIcon(new ImageIcon(scaledHome));
		searchTreatmentPanel.add(homeTreatments2);

		homeTreatments3 = new JButton();
		homeTreatments3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeTreatments3.setBounds(565, 409, 42, 42);
		homeTreatments3.setBorderPainted(false);
		homeTreatments3.setToolTipText("Menú principal");
		homeTreatments3.setIcon(new ImageIcon(scaledHome));
		finishTreatmentPanel.add(homeTreatments3);

		searchButton = new JButton();
		searchButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		searchButton.setBounds(0, 30, 100, 35);
		searchButton.setToolTipText("Buscar paciente");
		searchButton.setBorderPainted(false);
		ImageIcon imageSearch = new ImageIcon("Images\\menuTratamientos\\buscarC.png");
		searchButton.setIcon(imageSearch);
		infoPanel.add(searchButton);
//entrar a cada funcion de ese menu 

		initTreatment = new JButton();
		initTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		initTreatment.setBounds(273, 102, 252, 120);
		ImageIcon image6 = new ImageIcon("Images\\menuTratamientos\\bNewClear.png");
		Image scaled6 = image6.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initTreatment.setIcon(new ImageIcon(scaled6));
		mainPanel.add(initTreatment);

		initSearchTreatment = new JButton();
		initSearchTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		initSearchTreatment.setBounds(273, 234, 252, 120);
		ImageIcon image7 = new ImageIcon("Images\\menuTratamientos\\bSearchClear.png");
		Image scaled7 = image7.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initSearchTreatment.setIcon(new ImageIcon(scaled7));
		mainPanel.add(initSearchTreatment);

		initFinishTreatment = new JButton();
		initFinishTreatment.setBounds(273, 366, 252, 120);
		initFinishTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon image8 = new ImageIcon("Images\\menuTratamientos\\bFinishClear.png");
		Image scaled8 = image8.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initFinishTreatment.setIcon(new ImageIcon(scaled8));
		mainPanel.add(initFinishTreatment);

		register = new JButton();
		register.setBounds(351, 412, 157, 41);
		register.setCursor(new Cursor(Cursor.HAND_CURSOR));
		register.setBorderPainted(false);
		register.setToolTipText("Registrar Tratamiento");
		ImageIcon imageRegister = new ImageIcon("Images\\menuTratamientos\\registrarC.png");
		Image scaledRegister = imageRegister.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		register.setIcon(new ImageIcon(scaledRegister));
		newTreatmentPanel.add(register);

		updateTreatment = new JButton();
		updateTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		updateTreatment.setBounds(340, 421, 157, 41);
		updateTreatment.setBorderPainted(false);
		updateTreatment.setToolTipText("Actualizar tratamiento del paciente");
		ImageIcon imageUpdate = new ImageIcon("Images\\menuTratamientos\\actualizarC.png");
		Image scaledUpdate = imageUpdate.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		updateTreatment.setIcon(new ImageIcon(scaledUpdate));
		searchTreatmentPanel.add(updateTreatment);

		finishTreatment = new JButton();
		finishTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		finishTreatment.setBounds(356, 410, 157, 41);
		finishTreatment.setBorderPainted(false);
		finishTreatment.setToolTipText("finalizar tratamiento del paciente");
		ImageIcon imageFinish = new ImageIcon("Images\\menuTratamientos\\finalizarC.png");
		Image scaledFinish = imageFinish.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		finishTreatment.setIcon(new ImageIcon(scaledFinish));
		finishTreatmentPanel.add(finishTreatment);

		selectPatient = new JButton();
		selectPatient.setBounds(0, 0, 111, 40);
		selectPatient.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectPatient.setToolTipText("Hacer busqueda del numero de identificación");
		selectPatient.setBorderPainted(false);
		ImageIcon image16 = new ImageIcon("Images\\menuCitas\\selectC.png");
		Image scaled16 = image16.getImage().getScaledInstance(111, 40, Image.SCALE_SMOOTH);
		selectPatient.setIcon(new ImageIcon(scaled16));
		infoPanel.add(selectPatient);
	}

	public JButton getRegister() {
		return register;
	}

	public JButton getSelectPatient() {
		return selectPatient;
	}

	public void setSelectPatient(JButton selectPatient) {
		this.selectPatient = selectPatient;
	}

	public JTextField getName2() {
		return name2;
	}

	public void setName2(JTextField name2) {
		this.name2 = name2;
	}

	public JTextField getId1() {
		return id1;
	}

	public void setId1(JTextField id1) {
		this.id1 = id1;
	}

	public JTextField getId2() {
		return id2;
	}

	public void setId2(JTextField id2) {
		this.id2 = id2;
	}

	public JTextField getId3() {
		return id3;
	}

	public void setId3(JTextField id3) {
		this.id3 = id3;
	}

	public void setRegister(JButton register) {
		this.register = register;
	}

	public void textFields() {
		// TODO Auto-generated method stub

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getNewTreatmentPanel() {
		return newTreatmentPanel;
	}

	public void setNewTreatmentPanel(JPanel newTreatmentPanel) {
		this.newTreatmentPanel = newTreatmentPanel;
	}

	public JPanel getSearchTreatmentPanel() {
		return searchTreatmentPanel;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public void setSearchTreatmentPanel(JPanel searchTreatmentPanel) {
		this.searchTreatmentPanel = searchTreatmentPanel;
	}

	public JPanel getFinishTreatmentPanel() {
		return finishTreatmentPanel;
	}

	public void setFinishTreatmentPanel(JPanel finishTreatmentPanel) {
		this.finishTreatmentPanel = finishTreatmentPanel;
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

	public JButton getThemeMain() {
		return themeMain;
	}

	public void setThemeMain(JButton themeMain) {
		this.themeMain = themeMain;
	}

	public JButton getInitTreatment() {
		return initTreatment;
	}

	public void setInitTreatment(JButton initTreatment) {
		this.initTreatment = initTreatment;
	}

	public JButton getInitSearchTreatment() {
		return initSearchTreatment;
	}

	public void setInitSearchTreatment(JButton initSearchTreatment) {
		this.initSearchTreatment = initSearchTreatment;
	}

	public JButton getInitFinishTreatment() {
		return initFinishTreatment;
	}

	public void setInitFinishTreatment(JButton initFinishTreatment) {
		this.initFinishTreatment = initFinishTreatment;
	}

	public JPanel getInfoPanel() {
		return infoPanel;
	}

	public void setInfoPanel(JPanel infoPanel) {
		this.infoPanel = infoPanel;
	}

	public JButton getInfoName() {
		return infoName;
	}

	public void setInfoName(JButton infoName) {
		this.infoName = infoName;
	}

	public JButton getInfospecialty() {
		return infospecialty;
	}

	public void setInfospecialty(JButton infospecialty) {
		this.infospecialty = infospecialty;
	}

	public JButton getInfoTreatment() {
		return infoTreatment;
	}

	public void setInfoTreatment(JButton infoTreatment) {
		this.infoTreatment = infoTreatment;
	}

	public JButton getInfoStatus() {
		return infoStatus;
	}

	public void setInfoStatus(JButton infoStatus) {
		this.infoStatus = infoStatus;
	}

	public JButton getInfoSearchName() {
		return infoSearchName;
	}

	public void setInfoSearchName(JButton infoSearchName) {
		this.infoSearchName = infoSearchName;
	}

	public JButton getHomeTreatments1() {
		return homeTreatments1;
	}

	public void setHomeTreatments1(JButton homeTreatments1) {
		this.homeTreatments1 = homeTreatments1;
	}

	public JButton getHomeTreatments2() {
		return homeTreatments2;
	}

	public void setHomeTreatments2(JButton homeTreatments2) {
		this.homeTreatments2 = homeTreatments2;
	}

	public JButton getHomeTreatments3() {
		return homeTreatments3;
	}

	public void setHomeTreatments3(JButton homeTreatments3) {
		this.homeTreatments3 = homeTreatments3;
	}

	public JTextField getName1() {
		return name1;
	}

	public void setName1(JTextField name1) {
		this.name1 = name1;
	}

	public JTextField getTreatmentTxt() {
		return treatmentTxt;
	}

	public void setTreatmentTxt(JTextField treatmentTxt) {
		this.treatmentTxt = treatmentTxt;
	}

	public JComboBox<String> getStatus() {
		return status;
	}

	public void setStatus(JComboBox<String> status) {
		this.status = status;
	}

	public JComboBox<String> getSpecialty() {
		return specialty;
	}

	public void setSpecialty(JComboBox<String> specialty) {
		this.specialty = specialty;
	}

	public JButton getUpdateTreatment() {
		return updateTreatment;
	}

	public void setUpdateTreatment(JButton updateTreatment) {
		this.updateTreatment = updateTreatment;
	}

	public JButton getFinishTreatment() {
		return finishTreatment;
	}

	public void setFinishTreatment(JButton finishTreatment) {
		this.finishTreatment = finishTreatment;
	}

	public JComboBox<String> getStatus2() {
		return status2;
	}

	public void setStatus2(JComboBox<String> status2) {
		this.status2 = status2;
	}

	public JComboBox<String> getSpecialty2() {
		return specialty2;
	}

	public void setSpecialty2(JComboBox<String> specialty2) {
		this.specialty2 = specialty2;
	}

	public JComboBox<String> getStatus3() {
		return status3;
	}

	public void setStatus3(JComboBox<String> status3) {
		this.status3 = status3;
	}

	public JTextField getNameS() {
		return nameS;
	}

	public void setNameS(JTextField nameS) {
		this.nameS = nameS;
	}

	public JTextField getTreatmentS() {
		return treatmentS;
	}

	public void setTreatmentS(JTextField treatmentS) {
		this.treatmentS = treatmentS;
	}

	public JTextField getNameF() {
		return nameF;
	}

	public void setNameF(JTextField nameF) {
		this.nameF = nameF;
	}

	public JTextField getTreatmentF() {
		return treatmentF;
	}

	public void setTreatmentF(JTextField treatmentF) {
		this.treatmentF = treatmentF;
	}

}
