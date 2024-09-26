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
	private JButton btnVuelosNac, btnVuelosInternac, btnAniadir, btnActualizarInferior, btnMostrar, btnSalir,
			btnCambiarModo, btnBuscarCentral, btnGuardar, btnActualizar, btnEliminar, combustible;
	private JPanel panelVuelos, panelIzq, panelBuscar, panelCentral, panelInferior, panelVariable,
			panelInternationalFlight, panelNationalFlight;
//private JTextArea txtaMostrar;
	private JTextField txtPassengersNumber, txtNameCaptain, txtNameSecondCommand, txtDepartureTime, txtArrivalTime,
			txtFuelWeight, txtID, txtIsTurboProp, txtIsTurbine, txtIsVisa, txtIDVueloBuscar, txtDeparturePlace,
			txtArrivalPlace;
	private JLabel numVuelo, txtCombustible, txtNumVuelo, lblCompanyName, lblPassengersNumber, lblNameCaptain,
			lblNameSecondCommand, lblDepartureTime, lblArrivalTime, lblFuelWeight, lblBuscarPorID, lblIsTurboProp,
			lblIsTurbine, lblIsVisa, lblIDVueloBuscar, logo, lblDeparturePlace, lblArrivalPlace;
	private JComboBox<String> aerolinea, cmbIsTurbo, cmbIsTurbine, cmbVisa, arrival, arrivalInternacional, cmbBusqueda;

	private JScrollPane scrollpane;
	private final static String INT = "Internacional";
	private final static String NAC = "Nacional";

	CardLayout cardLayout = new CardLayout();

	public MenuAereolinea() {

		ventana();
		paneles();
		textfield();
		botones();
		labels();
		Combobox();

		getPanelBuscar().setVisible(false);
		getPanelCentral().setVisible(false);
		getPanelInferior().setVisible(false);
		getPanelIzq().setVisible(false);
		getPanelVariable().setVisible(false);
		getPanelVuelos().setVisible(true);

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
		setBackground(Color.white);
		setResizable(false);
		setLayout(null);
	}

	public void botones() {
		// Botones panel superior
		ImageIcon imagenVuelosNacionales = new ImageIcon("Images\\NacionaleBtn.png");
		btnVuelosNac = new JButton(imagenVuelosNacionales);
		btnVuelosNac.setBorder(null);
		btnVuelosNac.setBounds(150, 10, 320, 51);
		panelVuelos.add(btnVuelosNac);

		ImageIcon imagenVuelosInternacionales = new ImageIcon("Images\\InternacionalesBtn.png");
		btnVuelosInternac = new JButton(imagenVuelosInternacionales);
		btnVuelosInternac.setBorder(null);
		btnVuelosInternac.setBounds(520, 10, 320, 51);
		panelVuelos.add(btnVuelosInternac);

		// Botones panel izquierda (menu)
		ImageIcon imagenAseoBtn = new ImageIcon("Images\\AniadirbtnClaro.png");
		btnAniadir = new JButton(imagenAseoBtn);
		btnAniadir.setBounds(25, 25, 100, 100);
		btnAniadir.setBorder(null);
		panelIzq.add(btnAniadir);

		ImageIcon imagenBuscar = new ImageIcon("Images\\Actualizar100btnClaro.png");
		btnActualizar = new JButton(imagenBuscar);
		btnActualizar.setBounds(25, 150, 100, 100);
		btnActualizar.setBorder(null);
		panelIzq.add(btnActualizar);

		ImageIcon imagenMostrar = new ImageIcon("Images\\MostrarbtnClaro.png");
		btnMostrar = new JButton(imagenMostrar);
		btnMostrar.setBounds(25, 275, 100, 100);
		btnMostrar.setBorder(null);
		panelIzq.add(btnMostrar);

		ImageIcon imagenSalir = new ImageIcon("Images\\SalirbtnClaro.png");
		btnSalir = new JButton(imagenSalir);
		btnSalir.setBounds(25, 400, 100, 100);
		btnSalir.setBorder(null);
		panelIzq.add(btnSalir);

		ImageIcon imagenCambiarModo = new ImageIcon("Images\\ModoOscurobtnClaro.png");
		btnCambiarModo = new JButton(imagenCambiarModo);
		btnCambiarModo.setBounds(0, 510, 161, 55);
		btnCambiarModo.setBorder(null);
		panelIzq.add(btnCambiarModo);

		// Botones panel Inferior
		ImageIcon imagenGuardar = new ImageIcon("Images\\GuardarbtnClaro.png");
		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setBounds(150, 5, 75, 75);
		btnGuardar.setBorder(null);
		panelInferior.add(btnGuardar);

		ImageIcon imagenActualizar = new ImageIcon("Images\\ActualizarbtnClaro.png");

		btnActualizarInferior = new JButton(imagenActualizar);
		btnActualizarInferior.setBounds(300, 5, 75, 75);
		btnActualizarInferior.setBorder(null);
		panelInferior.add(btnActualizarInferior);

		ImageIcon imagenEliminar = new ImageIcon("Images\\EliminarbtnClaro.png");
		btnEliminar = new JButton(imagenEliminar);
		btnEliminar.setBounds(450, 5, 75, 75);
		btnEliminar.setBorder(null);
		panelInferior.add(btnEliminar);

		// Boton panel de busqueda
		ImageIcon imagenBuscarCentral = new ImageIcon("Images\\BusquedabtnClaro.png");
		btnBuscarCentral = new JButton(imagenBuscarCentral);
		btnBuscarCentral.setBounds(640, 5, 140, 38);
		btnBuscarCentral.setBorder(null);
		panelBuscar.add(btnBuscarCentral);

		ImageIcon combustibleImg = new ImageIcon("Images\\combustibleClaro.png");
		combustible = new JButton();
		combustible.setBounds(50, 340, 159, 36);
		combustible.setIcon(combustibleImg);
		combustible.setBorder(null);
		combustible.setToolTipText("Calcular combustible");
		panelCentral.add(combustible);
	}

	public void paneles() {
		panelVuelos = new JPanel();
		panelVuelos.setLayout(null);
		panelVuelos.setBounds(0, 0, 1000, 60);
		panelVuelos.setBackground(Color.white);

		panelIzq = new JPanel();
		panelIzq.setLayout(null);
		panelIzq.setBounds(0, 61, 150, 615);
		panelIzq.setBackground(Color.white);

		panelBuscar = new JPanel();
		panelBuscar.setLayout(null);
		panelBuscar.setBounds(151, 61, 850, 45);
		panelBuscar.setBackground(Color.red);

		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(151, 106, 850, 405);
		panelCentral.setBackground(Color.white);

		panelInferior = new JPanel();
		panelInferior.setLayout(null);
		panelInferior.setBounds(151, 585, 850, 90);
		panelInferior.setBackground(Color.white);

		panelNationalFlight = new JPanel();
		panelNationalFlight.setLayout(null);
		panelNationalFlight.setBounds(151, 535, 850, 75);
		panelNationalFlight.setBackground(Color.white);

		panelInternationalFlight = new JPanel();
		panelInternationalFlight.setLayout(null);
		panelInternationalFlight.setBounds(151, 535, 850, 75);
		panelInternationalFlight.setBackground(Color.white);

		panelVariable = new JPanel(cardLayout);
		panelVariable.setBounds(151, 510, 850, 75);
		panelVariable.setBackground(Color.white);
		panelVariable.add(panelInternationalFlight, INT);
		panelVariable.add(panelNationalFlight, NAC);

	}

	public void textfield() {

		// Identificador del Vuelo
		/*
		 * txtID = new JTextField(); txtID.setFont(new Font("Agency FB", Font.BOLD,
		 * 14)); txtID.setBounds(240, 55, 400, 40); panelCentral.add(txtID);
		 */

		txtPassengersNumber = new JTextField();
		txtPassengersNumber.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtPassengersNumber.setBounds(190, 125, 400, 20);
		panelCentral.add(txtPassengersNumber);

		/*
		 * txtNameCaptain = new JTextField(); txtNameCaptain.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtNameCaptain.setBounds(180, 125, 400,
		 * 20); panelCentral.add(txtNameCaptain);
		 * 
		 * txtNameSecondCommand = new JTextField(); txtNameSecondCommand.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtNameSecondCommand.setBounds(180, 125,
		 * 400, 20); panelCentral.add(txtNameSecondCommand);
		 */

		txtDepartureTime = new JTextField();
		txtDepartureTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtDepartureTime.setBounds(190, 175, 400, 20);
		panelCentral.add(txtDepartureTime);

		txtArrivalTime = new JTextField();
		txtArrivalTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtArrivalTime.setBounds(190, 225, 400, 20);
		panelCentral.add(txtArrivalTime);

		/*
		 * txtFuelWeight = new JTextField(); txtFuelWeight.setFont(new Font("Agency FB",
		 * Font.BOLD, 14)); txtFuelWeight.setBounds(180, 125, 400, 20);
		 * panelCentral.add(txtFuelWeight);
		 */

		/*
		 * txtIsTurboProp = new JTextField(); txtIsTurboProp.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtIsTurboProp.setBounds(240, 55, 400,
		 * 40); panelNationalFlight.add(txtIsTurboProp);
		 * 
		 * txtIsTurbine = new JTextField(); txtIsTurbine.setFont(new Font("Agency FB",
		 * Font.BOLD, 14)); txtIsTurbine.setBounds(240, 55, 400, 40);
		 * panelNationalFlight.add(txtIsTurbine);
		 * 
		 * 
		 * /*txtIsVisa = new JTextField(); txtIsVisa.setFont(new
		 * Font("Agency FB",Font.BOLD, 14)); txtIsVisa.setBounds(240, 55, 400, 40);
		 * panelInternationalFlight.add(txtIsVisa);
		 * 
		 * 
		 * /* txtIDVueloBuscar = new JTextField(); txtIDVueloBuscar.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtIDVueloBuscar.setBounds(240, 55, 400,
		 * 40); panelBuscar.add(txtIDVueloBuscar);
		 */

		/*
		 * txtIDVueloBuscar = new JTextField(); txtIDVueloBuscar.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtIDVueloBuscar.setBounds(240, 55, 400,
		 * 40); panelBuscar.add(txtIDVueloBuscar);
		 */

		/*
		 * txtArrivalPlace = new JTextField(); txtArrivalPlace.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtArrivalPlace.setBounds(180, 325, 400,
		 * 20); panelCentral.add(txtArrivalPlace);
		 */

		/*
		 * txtDeparturePlace = new JTextField(); txtDeparturePlace.setFont(new
		 * Font("Agency FB", Font.BOLD, 14)); txtDeparturePlace.setBounds(180, 275, 400,
		 * 20); panelCentral.add(txtDeparturePlace);
		 */

	}

	public void Combobox() {
		aerolinea = new JComboBox<String>();
		aerolinea.setBounds(190, 80, 200, 20);
		aerolinea.setToolTipText("Nombre de la compañia");
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

		cmbIsTurbine = new JComboBox<String>();
		cmbIsTurbine.setBounds(150, 25, 180, 20);
		cmbIsTurbine.setToolTipText("Selecione si o no");
		cmbIsTurbine.addItem("");
		cmbIsTurbine.addItem("Si");
		cmbIsTurbine.addItem("No");
		panelNationalFlight.add(cmbIsTurbine);

		cmbIsTurbo = new JComboBox<String>();
		cmbIsTurbo.setBounds(520, 25, 180, 20);
		cmbIsTurbo.setToolTipText("Selecione si o no");
		cmbIsTurbo.addItem("");
		cmbIsTurbo.addItem("Si");
		cmbIsTurbo.addItem("No");
		panelNationalFlight.add(cmbIsTurbo);

		cmbVisa = new JComboBox<String>();
		cmbVisa.setBounds(150, 25, 180, 20);
		cmbVisa.setToolTipText("Selecione si o no");
		cmbVisa.addItem("");
		cmbVisa.addItem("Si");
		cmbVisa.addItem("No");
		panelInternationalFlight.add(cmbVisa);

		arrival = new JComboBox<String>();
		arrival.setBounds(190, 275, 400, 20);
		arrival.setToolTipText("Seleccione el destino del avion");
		arrival.addItem("");
		arrival.addItem("Medellin");// 1
		arrival.addItem("Cartagena");// 1:30hora
		arrival.addItem("Pasto");// 2
		arrival.addItem("Cali");// 1
		arrival.addItem("Bucaramanga");// 1
		arrival.addItem("Ibague");// 1
		arrival.addItem("Pereira");// 1
		arrival.addItem("Manizales");// 1
		arrival.addItem("Monteria");// 1:30
		arrival.addItem("Barranquilla");// 1:30
		arrival.addItem("Santa Marta");// 1:30
		arrival.addItem("Cucuta");// 1

		arrival.setVisible(false);
		panelCentral.add(arrival);

		arrivalInternacional = new JComboBox<String>();
		arrivalInternacional.setBounds(190, 275, 400, 20);
		arrivalInternacional.setToolTipText("Seleccione el destino del avion");
		arrivalInternacional.addItem("");
		arrivalInternacional.addItem("Madrid");// 10
		arrivalInternacional.addItem("Barcelona");// 10
		arrivalInternacional.addItem("Lisboa");// 13
		arrivalInternacional.addItem("Paris");// 11
		arrivalInternacional.addItem("Roma");// 14
		arrivalInternacional.addItem("Bruselas");// 13
		arrivalInternacional.addItem("Berlin");// 14
		arrivalInternacional.addItem("Londres");// 10
		arrivalInternacional.addItem("Dubai");// 18
		arrivalInternacional.addItem("New York");// 6
		arrivalInternacional.addItem("Los Angeles");// 9 30 km
		arrivalInternacional.addItem("Miami");// 4
		arrivalInternacional.addItem("Otawa");// 9
		arrivalInternacional.addItem("CDMX");// 5
		arrivalInternacional.addItem("Buenos Aires");// 6 30
		arrivalInternacional.addItem("Lima");// 3
		arrivalInternacional.addItem("Santiago de Chile");// 6
		arrivalInternacional.addItem("São Paulo");// 6
		arrivalInternacional.setVisible(false);
		panelCentral.add(arrivalInternacional);

		cmbBusqueda = new JComboBox<String>();
		cmbBusqueda.setBounds(250, 10, 230, 20);

	}

	public void labels() {
		logo = new JLabel();
		logo.setBounds(450, 50, 100, 75);
		panelCentral.add(logo);

		numVuelo = new JLabel("");
		numVuelo.setVisible(false);
		numVuelo.setBounds(750, 10, 80, 70);
		numVuelo.setFont(new Font("Agency FB", Font.BOLD, 24));
		panelCentral.add(numVuelo);

		txtNumVuelo = new JLabel("Numero de vuelo:");
		txtNumVuelo.setVisible(false);
		txtNumVuelo.setBounds(600, 10, 130, 70);
		txtNumVuelo.setFont(new Font("Agency FB", Font.BOLD, 24));
		panelCentral.add(txtNumVuelo);

		lblCompanyName = new JLabel("Nombre de la compañia:");
		lblCompanyName.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblCompanyName.setBounds(35, 70, 230, 30);
		panelCentral.add(lblCompanyName);

		lblPassengersNumber = new JLabel("Numero de pasajeros:");
		lblPassengersNumber.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblPassengersNumber.setBounds(35, 120, 230, 30);
		panelCentral.add(lblPassengersNumber);

		lblDepartureTime = new JLabel("Hora de salida:");
		lblDepartureTime.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblDepartureTime.setBounds(35, 170, 230, 30);
		panelCentral.add(lblDepartureTime);

		lblArrivalTime = new JLabel("Hora de llegada:");
		lblArrivalTime.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblArrivalTime.setBounds(35, 220, 230, 30);
		panelCentral.add(lblArrivalTime);

		/*
		 * lblDeparturePlace = new JLabel("Departure place:");
		 * lblDeparturePlace.setFont(new Font("Agency FB", Font.BOLD, 18));
		 * lblDeparturePlace.setBounds(40, 270, 230, 30);
		 * panelCentral.add(lblDeparturePlace);
		 */

		lblArrivalPlace = new JLabel("Destino:");
		lblArrivalPlace.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblArrivalPlace.setBounds(35, 270, 230, 30);
		panelCentral.add(lblArrivalPlace);

		lblIsTurbine = new JLabel("¿Avion de turbina?");
		lblIsTurbine.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsTurbine.setBounds(35, 20, 230, 30);
		panelNationalFlight.add(lblIsTurbine);

		lblIsTurboProp = new JLabel("¿Avion de turbo elice?");
		lblIsTurboProp.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsTurboProp.setBounds(380, 20, 230, 30);
		panelNationalFlight.add(lblIsTurboProp);

		lblIsVisa = new JLabel("¿Necesita VISA?");
		lblIsVisa.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsVisa.setBounds(35, 20, 230, 30);
		panelInternationalFlight.add(lblIsVisa);

		lblIDVueloBuscar = new JLabel("Seleccione el número de vuelo a buscar:");
		lblIDVueloBuscar.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIDVueloBuscar.setBounds(15, 10, 230, 30);
		panelBuscar.add(lblIDVueloBuscar);

		txtCombustible = new JLabel();
		txtCombustible.setBounds(270, 320, 130, 70);
		txtCombustible.setFont(new Font("Agency FB", Font.BOLD, 24));
		panelCentral.add(txtCombustible);

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

	public String getInt() {
		return INT;
	}

	public String getNac() {
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

	public JTextField getTxtDeparturePlace() {
		return txtDeparturePlace;
	}

	public void setTxtDeparturePlace(JTextField txtDeparturePlace) {
		this.txtDeparturePlace = txtDeparturePlace;
	}

	public JTextField getTxtArrivalPlace() {
		return txtArrivalPlace;
	}

	public void setTxtArrivalPlace(JTextField txtArrivalPlace) {
		this.txtArrivalPlace = txtArrivalPlace;
	}

	public JLabel getLblDeparturePlace() {
		return lblDeparturePlace;
	}

	public void setLblDeparturePlace(JLabel lblDeparturePlace) {
		this.lblDeparturePlace = lblDeparturePlace;
	}

	public JLabel getLblArrivalPlace() {
		return lblArrivalPlace;
	}

	public void setLblArrivalPlace(JLabel lblArrivalPlace) {
		this.lblArrivalPlace = lblArrivalPlace;
	}

	public JComboBox<String> getCmbIsTurbo() {
		return cmbIsTurbo;
	}

	public void setCmbIsTurbo(JComboBox<String> cmbIsTurbo) {
		this.cmbIsTurbo = cmbIsTurbo;
	}

	public JComboBox<String> getCmbIsTurbine() {
		return cmbIsTurbine;
	}

	public void setCmbIsTurbine(JComboBox<String> cmbIsTurbine) {
		this.cmbIsTurbine = cmbIsTurbine;
	}

	public JComboBox<String> getArrival() {
		return arrival;
	}

	public void setArrival(JComboBox<String> arrival) {
		this.arrival = arrival;
	}

	public JComboBox<String> getArrivalInternacional() {
		return arrivalInternacional;
	}

	public void setArrivalInternacional(JComboBox<String> arrivalInternacional) {
		this.arrivalInternacional = arrivalInternacional;
	}

	public JComboBox<String> getCmbVisa() {
		return cmbVisa;
	}

	public void setCmbVisa(JComboBox<String> cmbVisa) {
		this.cmbVisa = cmbVisa;
	}

	public JComboBox<String> getCmbBusqueda() {
		return cmbBusqueda;
	}

	public void setCmbBusqueda(JComboBox<String> cmbBusqueda) {
		this.cmbBusqueda = cmbBusqueda;
	}

	public JButton getBtnActualizarInferior() {
		return btnActualizarInferior;
	}

	public void setBtnActualizarInferior(JButton btnActualizarInferior) {
		this.btnActualizarInferior = btnActualizarInferior;
	}

	public JLabel getNumVuelo() {
		return numVuelo;
	}

	public void setNumVuelo(JLabel numVuelo) {
		this.numVuelo = numVuelo;
	}

	public JLabel getTxtNumVuelo() {
		return txtNumVuelo;
	}

	public void setTxtNumVuelo(JLabel txtNumVuelo) {
		this.txtNumVuelo = txtNumVuelo;
	}

	public JButton getCombustible() {
		return combustible;
	}

	public void setCombustible(JButton combustible) {
		this.combustible = combustible;
	}

	public JLabel getTxtCombustible() {
		return txtCombustible;
	}

	public void setTxtCombustible(JLabel txtCombustible) {
		this.txtCombustible = txtCombustible;
	}

}
