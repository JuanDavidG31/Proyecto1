package co.edu.unbosque.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MenuAereolinea extends JFrame {
	private JButton btnVuelosNac, btnVuelosInternac, btnAniadir, btnBuscarIzq, btnMostrar, btnSalir, btnCambiarModo,
			btnBuscarCentral, btnGuardar, btnActualizar, btnEliminar;
	private JPanel panelVuelos, panelIzq, panelBuscar, panelCentral, panelInferior, panelVariable,
			panelInternationalFlight, panelNationalFlight;
//private JTextArea txtaMostrar;
	private JTextField txtCompanyName, txtPassengersNumber, txtNameCaptain, txtNameSecondCommand, txtDepartureTime,
			txtArrivalTime, txtFuelWeight, txtID, txtIsTurboProp, txtIsTurbine, txtIsVisa, txtIDVueloBuscar;
	private JLabel lblNombre, lblCompanyName, lblPassengersNumber, lblNameCaptain, lblNameSecondCommand,
			lblDepartureTime, lblArrivalTime, lblFuelWeight, lblBuscarPorID, lblIsTurboProp, lblIsTurbine, lblIsVisa,
			lblIDVueloBuscar, logo;
	private JComboBox<String> aerolinea;

	private JScrollPane scrollpane;
	private final static String INT = "Internacional";
	private final static String NAC = "Nacional";

	CardLayout cardLayout = new CardLayout();

	public MenuAereolinea() {

		ventana();
		paneles();
		textfield();
		labels();
		Combobox();

		getPanelBuscar().setVisible(false);
		getPanelCentral().setVisible(true);
		getPanelInferior().setVisible(false);
		getPanelIzq().setVisible(false);
		getPanelVariable().setVisible(false);
		getPanelVuelos().setVisible(false);
		
		add(panelBuscar);
		add(panelCentral);
		add(panelInferior);
		add(panelIzq);
		add(panelVariable);
		add(panelVuelos);

		
	}

	public void ventana() {
		setBounds(50, 50, 1000, 700);
		setTitle("Aeropuerto el Dorado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
	}

	public void botones() {
		// Botones panel superior
		ImageIcon imagenVuelosNacionales = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnVuelosNac = new JButton(imagenVuelosNacionales);
		btnVuelosNac.setBounds(635, 0, 426, 88);
		panelVuelos.add(btnVuelosNac);

		ImageIcon imagenVuelosInternacionales = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnVuelosInternac = new JButton(imagenVuelosInternacionales);
		btnVuelosInternac.setBounds(635, 0, 426, 88);
		panelVuelos.add(btnVuelosInternac);

		// Botones panel izquierda (menu)
		ImageIcon imagenAseoBtn = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnAniadir = new JButton(imagenAseoBtn);
		btnAniadir.setBounds(635, 0, 426, 88);
		panelIzq.add(btnAniadir);

		ImageIcon imagenBuscar = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnBuscarIzq = new JButton(imagenBuscar);
		btnBuscarIzq.setBounds(635, 0, 426, 88);
		panelIzq.add(btnBuscarIzq);

		ImageIcon imagenMostrar = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnMostrar = new JButton(imagenMostrar);
		btnMostrar.setBounds(635, 0, 426, 88);
		panelIzq.add(btnMostrar);

		ImageIcon imagenCambiarModo = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnCambiarModo = new JButton(imagenCambiarModo);
		btnCambiarModo.setBounds(635, 0, 426, 88);
		panelIzq.add(btnCambiarModo);

		ImageIcon imagenSalir = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnSalir = new JButton(imagenSalir);
		btnSalir.setBounds(635, 0, 426, 88);
		panelIzq.add(btnSalir);

		// Botones panel Inferior
		ImageIcon imagenGuardar = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setBounds(635, 0, 426, 88);
		panelInferior.add(btnGuardar);

		ImageIcon imagenActualizar = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnActualizar = new JButton(imagenActualizar);
		btnActualizar.setBounds(635, 0, 426, 88);
		panelInferior.add(btnActualizar);

		// Boton panel de busqueda
		ImageIcon imagenBuscarCentral = new ImageIcon("src/co/edu/unbosque/view/bntAseo.png");
		btnBuscarCentral = new JButton(imagenBuscarCentral);
		btnBuscarCentral.setBounds(635, 0, 426, 88);
		panelBuscar.add(btnBuscarCentral);
	}

	public void paneles() {
		panelVuelos = new JPanel();
		panelVuelos.setLayout(null);
		panelVuelos.setBounds(0, 0, 1000, 60);
		panelVuelos.setBackground(Color.green);

		panelIzq = new JPanel();
		panelIzq.setLayout(null);
		panelIzq.setBounds(0, 61, 150, 615);
		panelIzq.setBackground(Color.blue);

		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setBounds(151, 61, 850, 45);
		panelBuscar.setBackground(Color.red);

		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(151, 106, 850, 430);
		panelCentral.setBackground(Color.white);

		panelInferior = new JPanel();
		panelInferior.setLayout(null);
		panelInferior.setBounds(151, 610, 850, 90);
		panelInferior.setBackground(Color.yellow);

		panelNationalFlight = new JPanel();
		panelNationalFlight.setLayout(null);
		panelNationalFlight.setBounds(151, 535, 850, 75);
		panelNationalFlight.setBackground(Color.orange);

		panelInternationalFlight = new JPanel();
		panelInternationalFlight.setLayout(null);
		panelInternationalFlight.setBounds(151, 535, 850, 75);
		panelInternationalFlight.setBackground(Color.magenta);

		panelVariable = new JPanel(cardLayout);
		panelVariable.setBounds(151, 535, 850, 75);
		panelVariable.setBackground(Color.gray);
		panelVariable.add(panelInternationalFlight, INT);
		panelVariable.add(panelNationalFlight, NAC);

	}

	public void textfield() {

		// Identificador del Vuelo
		txtID = new JTextField();
		txtID.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtID.setBounds(240, 55, 400, 40);
		panelCentral.add(txtID);

		txtCompanyName = new JTextField();
		txtCompanyName.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtCompanyName.setBounds(240, 55, 400, 40);
		panelCentral.add(txtCompanyName);

		txtPassengersNumber = new JTextField();
		txtPassengersNumber.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtPassengersNumber.setBounds(240, 55, 400, 40);
		panelCentral.add(txtPassengersNumber);

		txtNameCaptain = new JTextField();
		txtNameCaptain.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtNameCaptain.setBounds(240, 55, 400, 40);
		panelCentral.add(txtNameCaptain);

		txtNameSecondCommand = new JTextField();
		txtNameSecondCommand.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtNameSecondCommand.setBounds(240, 55, 400, 40);
		panelCentral.add(txtNameSecondCommand);

		txtDepartureTime = new JTextField();
		txtDepartureTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtDepartureTime.setBounds(240, 55, 400, 40);
		panelCentral.add(txtDepartureTime);

		txtArrivalTime = new JTextField();
		txtArrivalTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtArrivalTime.setBounds(240, 55, 400, 40);
		panelCentral.add(txtArrivalTime);

		txtFuelWeight = new JTextField();
		txtFuelWeight.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtFuelWeight.setBounds(240, 55, 400, 40);
		panelCentral.add(txtFuelWeight);

		txtIsTurboProp = new JTextField();
		txtIsTurboProp.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtIsTurboProp.setBounds(240, 55, 400, 40);
		panelNationalFlight.add(txtIsTurboProp);

		txtIsTurbine = new JTextField();
		txtIsTurbine.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtIsTurbine.setBounds(240, 55, 400, 40);
		panelNationalFlight.add(txtIsTurbine);

		txtIsVisa = new JTextField();
		txtIsVisa.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtIsVisa.setBounds(240, 55, 400, 40);
		panelInternationalFlight.add(txtIsVisa);

		txtIDVueloBuscar = new JTextField();
		txtIDVueloBuscar.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtIDVueloBuscar.setBounds(240, 55, 400, 40);
		panelBuscar.add(txtIDVueloBuscar);

	}

	public void Combobox() {
		aerolinea = new JComboBox<String>();
		aerolinea.setBounds(100	, 100, 200, 100);
		aerolinea.setToolTipText("Seleccione la aerolinea");
		aerolinea.addItem("");
		aerolinea.addItem("Avianca");
		aerolinea.addItem("Latam");
		aerolinea.addItem("Wingo");
		aerolinea.addItem("Clic");
		aerolinea.addItem("JetSmart");
		aerolinea.addItem("Satena");
		aerolinea.addItem("Air Canada");
		aerolinea.addItem("KLM");
		aerolinea.addItem("Iberia");
		aerolinea.addItem("Emirates");
		aerolinea.addItem("Delta");

		panelCentral.add(aerolinea);
	}

	public void labels() {
		logo = new JLabel();
		logo.setBounds(150, 150, 100, 50);
		panelCentral.add(logo);
	}
	// Getters and Setters

	public JButton getBtnVuelosNac() {
		return btnVuelosNac;
	}

	public void setBtnVuelosNac(JButton btnVuelosNac) {
		this.btnVuelosNac = btnVuelosNac;
	}

	public JButton getBtnVuelosInternac() {
		return btnVuelosInternac;
	}

	public void setBtnVuelosInternac(JButton btnVuelosInternac) {
		this.btnVuelosInternac = btnVuelosInternac;
	}

	public JButton getBtnAniadir() {
		return btnAniadir;
	}

	public void setBtnAniadir(JButton btnAniadir) {
		this.btnAniadir = btnAniadir;
	}

	public JButton getBtnBuscarIzq() {
		return btnBuscarIzq;
	}

	public void setBtnBuscarIzq(JButton btnBuscarIzq) {
		this.btnBuscarIzq = btnBuscarIzq;
	}

	public JButton getBtnMostrar() {
		return btnMostrar;
	}

	public void setBtnMostrar(JButton btnMostrar) {
		this.btnMostrar = btnMostrar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnCambiarModo() {
		return btnCambiarModo;
	}

	public void setBtnCambiarModo(JButton btnCambiarModo) {
		this.btnCambiarModo = btnCambiarModo;
	}

	public JButton getBtnBuscarCentral() {
		return btnBuscarCentral;
	}

	public void setBtnBuscarCentral(JButton btnBuscarCentral) {
		this.btnBuscarCentral = btnBuscarCentral;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public void setBtnActualizar(JButton btnActualizar) {
		this.btnActualizar = btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JPanel getPanelVuelos() {
		return panelVuelos;
	}

	public void setPanelVuelos(JPanel panelVuelos) {
		this.panelVuelos = panelVuelos;
	}

	public JPanel getPanelIzq() {
		return panelIzq;
	}

	public void setPanelIzq(JPanel panelIzq) {
		this.panelIzq = panelIzq;
	}

	public JPanel getPanelBuscar() {
		return panelBuscar;
	}

	public void setPanelBuscar(JPanel panelBuscar) {
		this.panelBuscar = panelBuscar;
	}

	public JPanel getPanelCentral() {
		return panelCentral;
	}

	public void setPanelCentral(JPanel panelCentral) {
		this.panelCentral = panelCentral;
	}

	public JPanel getPanelInferior() {
		return panelInferior;
	}

	public void setPanelInferior(JPanel panelInferior) {
		this.panelInferior = panelInferior;
	}

	public JPanel getPanelVariable() {
		return panelVariable;
	}

	public void setPanelVariable(JPanel panelVariable) {
		this.panelVariable = panelVariable;
	}

	public JTextField getTxtCompanyName() {
		return txtCompanyName;
	}

	public void setTxtCompanyName(JTextField txtCompanyName) {
		this.txtCompanyName = txtCompanyName;
	}

	public JTextField getTxtPassengersNumber() {
		return txtPassengersNumber;
	}

	public void setTxtPassengersNumber(JTextField txtPassengersNumber) {
		this.txtPassengersNumber = txtPassengersNumber;
	}

	public JTextField getTxtNameCaptain() {
		return txtNameCaptain;
	}

	public void setTxtNameCaptain(JTextField txtNameCaptain) {
		this.txtNameCaptain = txtNameCaptain;
	}

	public JTextField getTxtNameSecondCommand() {
		return txtNameSecondCommand;
	}

	public void setTxtNameSecondCommand(JTextField txtNameSecondCommand) {
		this.txtNameSecondCommand = txtNameSecondCommand;
	}

	public JTextField getTxtDepartureTime() {
		return txtDepartureTime;
	}

	public void setTxtDepartureTime(JTextField txtDepartureTime) {
		this.txtDepartureTime = txtDepartureTime;
	}

	public JTextField getTxtArrivalTime() {
		return txtArrivalTime;
	}

	public void setTxtArrivalTime(JTextField txtArrivalTime) {
		this.txtArrivalTime = txtArrivalTime;
	}

	public JTextField getTxtFuelWeight() {
		return txtFuelWeight;
	}

	public void setTxtFuelWeight(JTextField txtFuelWeight) {
		this.txtFuelWeight = txtFuelWeight;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JTextField getTxtIsTurboProp() {
		return txtIsTurboProp;
	}

	public void setTxtIsTurboProp(JTextField txtIsTurboProp) {
		this.txtIsTurboProp = txtIsTurboProp;
	}

	public JTextField getTxtIsTurbine() {
		return txtIsTurbine;
	}

	public void setTxtIsTurbine(JTextField txtIsTurbine) {
		this.txtIsTurbine = txtIsTurbine;
	}

	public JTextField getTxtIsVisa() {
		return txtIsVisa;
	}

	public void setTxtIsVisa(JTextField txtIsVisa) {
		this.txtIsVisa = txtIsVisa;
	}

	public JTextField getTxtIDVueloBuscar() {
		return txtIDVueloBuscar;
	}

	public void setTxtIDVueloBuscar(JTextField txtIDVueloBuscar) {
		this.txtIDVueloBuscar = txtIDVueloBuscar;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblCompanyName() {
		return lblCompanyName;
	}

	public void setLblCompanyName(JLabel lblCompanyName) {
		this.lblCompanyName = lblCompanyName;
	}

	public JLabel getLblPassengersNumber() {
		return lblPassengersNumber;
	}

	public void setLblPassengersNumber(JLabel lblPassengersNumber) {
		this.lblPassengersNumber = lblPassengersNumber;
	}

	public JLabel getLblNameCaptain() {
		return lblNameCaptain;
	}

	public void setLblNameCaptain(JLabel lblNameCaptain) {
		this.lblNameCaptain = lblNameCaptain;
	}

	public JLabel getLblNameSecondCommand() {
		return lblNameSecondCommand;
	}

	public void setLblNameSecondCommand(JLabel lblNameSecondCommand) {
		this.lblNameSecondCommand = lblNameSecondCommand;
	}

	public JLabel getLblDepartureTime() {
		return lblDepartureTime;
	}

	public void setLblDepartureTime(JLabel lblDepartureTime) {
		this.lblDepartureTime = lblDepartureTime;
	}

	public JLabel getLblArrivalTime() {
		return lblArrivalTime;
	}

	public void setLblArrivalTime(JLabel lblArrivalTime) {
		this.lblArrivalTime = lblArrivalTime;
	}

	public JLabel getLblFuelWeight() {
		return lblFuelWeight;
	}

	public void setLblFuelWeight(JLabel lblFuelWeight) {
		this.lblFuelWeight = lblFuelWeight;
	}

	public JLabel getLblBuscarPorID() {
		return lblBuscarPorID;
	}

	public void setLblBuscarPorID(JLabel lblBuscarPorID) {
		this.lblBuscarPorID = lblBuscarPorID;
	}

	public JLabel getLblIsTurboProp() {
		return lblIsTurboProp;
	}

	public void setLblIsTurboProp(JLabel lblIsTurboProp) {
		this.lblIsTurboProp = lblIsTurboProp;
	}

	public JLabel getLblIsTurbine() {
		return lblIsTurbine;
	}

	public void setLblIsTurbine(JLabel lblIsTurbine) {
		this.lblIsTurbine = lblIsTurbine;
	}

	public JLabel getLblIsVisa() {
		return lblIsVisa;
	}

	public void setLblIsVisa(JLabel lblIsVisa) {
		this.lblIsVisa = lblIsVisa;
	}

	public JLabel getLblIDVueloBuscar() {
		return lblIDVueloBuscar;
	}

	public void setLblIDVueloBuscar(JLabel lblIDVueloBuscar) {
		this.lblIDVueloBuscar = lblIDVueloBuscar;
	}

	public JScrollPane getScrollpane() {
		return scrollpane;
	}

	public void setScrollpane(JScrollPane scrollpane) {
		this.scrollpane = scrollpane;
	}

	public JPanel getPanelInternationalFlight() {
		return panelInternationalFlight;
	}

	public void setPanelInternationalFlight(JPanel panelInternationalFlight) {
		this.panelInternationalFlight = panelInternationalFlight;
	}

	public JPanel getPanelNationalFlight() {
		return panelNationalFlight;
	}

	public void setPanelNationalFlight(JPanel panelNationalFlight) {
		this.panelNationalFlight = panelNationalFlight;
	}

	public static String getInt() {
		return INT;
	}

	public static String getNac() {
		return NAC;
	}

	public JComboBox<String> getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(JComboBox<String> aerolinea) {
		this.aerolinea = aerolinea;
	}

	public JLabel getLogo() {
		return logo;
	}

	public void setLogo(JLabel logo) {
		this.logo = logo;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	

}
