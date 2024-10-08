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
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * Clase que representa la interfaz gráfica de la aplicación de la aerolínea.
 * Extiende de JFrame para crear la ventana principal del programa.
 * Contiene todos los paneles, botones, etiquetas y campos de texto necesarios 
 * para la gestión de vuelos nacionales e internacionales.
 */
public class MenuAereolinea extends JFrame {
	// Botones de la interfaz
	private JButton btnVuelosNac, btnVuelosInternac, btnAniadir, btnActualizarInferior, btnMostrar, btnSalir,
			btnCambiarModo, btnGuardar, btnActualizar, btnEliminar, btnCombustible;
	// Paneles de la interfaz
	private JPanel panelVuelos, panelIzq, panelCentral, panelInferior, panelVariable, panelInternationalFlight,
			panelNationalFlight, panelMostrarJTableNacional, panelMostrarJTableOInternacional;
	 // Campos de texto
	private JTextField txtPassengersNumber, txtDepartureTime, txtArrivalTime;
	// Etiquetas
	private JLabel numVuelo, txtCombustible, txtNumVuelo, lblCompanyName, lblPassengersNumber, lblDepartureTime,
			lblArrivalTime, lblIsTurboProp, lblIsTurbine, lblIsVisa, logo, lblArrivalPlace;
	// ComboBox
	private JComboBox<String> aerolinea, cmbIsTurbo, cmbIsTurbine, cmbVisa, arrival, arrivalInternacional, cmbBusqueda;
	// Iconos de imágenes
	private ImageIcon imagenCambiarModo, imagenCambiarModoOscuro, imagenGuardar, imagenGuardarOscuro, imagenActualizar,
			imagenActualizarOscuro, imagenEliminar, imagenEliminarOscuro, imagenVuelosNacionales,
			imagenVuelosNacionalesOscuro, imagenVuelosInternacionales, imagenVuelosInternacionalesOscuro, imagenAniadir,
			imagenAniadirOscuro, imagenActualizarIzq, imagenActualizarIzqOscuro, imagenMostrar, imagenMostrarOscuro,
			imagenSalir, imagenSalirOscuro, imagenCombustible, imagenCombustibleOscuro;
	 // ScrollPane y JTable
	private JScrollPane scrollpaneNac, scrollpaneInt;
	private JTable tablaVuelosNacional, tablaVuelosInterNacional;
	// Constantes para identificación de vuelos
	private final static String INT = "Internacional";
	private final static String NAC = "Nacional";
	// Layout para la gestión de paneles
	CardLayout cardLayout = new CardLayout();
	
	
	/**
     * Constructor de la clase MenuAereolinea.
     * Inicializa la ventana y todos sus componentes.
     */
	public MenuAereolinea() {

		ventana();
		paneles();
		textfield();
		botones();
		labels();
		Combobox();
		//jTables();
		// Inicializa la visibilidad de los paneles
		getPanelCentral().setVisible(false);
		getPanelInferior().setVisible(false);
		getPanelIzq().setVisible(false);
		getPanelVariable().setVisible(false);
		getPanelVuelos().setVisible(true);
		getPanelMostrarJTableNacional().setVisible(false);
		getPanelMostrarJTableOInternacional().setVisible(false);
		// Agrega los paneles a la ventana
		add(panelCentral);
		add(panelInferior);
		add(panelIzq);
		add(panelVariable);
		add(panelVuelos);
		add(panelMostrarJTableNacional);
		add(panelMostrarJTableOInternacional);

	}
	/**
     * Configura la ventana principal de la aplicación.
     */
	public void ventana() {
		setBounds(50, 50, 1000, 700);
		setTitle("Aeropuerto el Dorado");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.white);
		setResizable(false);
		setLayout(null);
	}
	/**
     * Configura los botones de la interfaz.
     */
	public void botones() {
		// Configuración de botones y sus imágenes para el panel superior
		imagenVuelosNacionales = new ImageIcon("Images\\NacionaleBtn.png");
		imagenVuelosNacionalesOscuro = new ImageIcon("Images\\btnNacionalesOscuro.png");
		btnVuelosNac = new JButton(imagenVuelosNacionales);
		btnVuelosNac.setBorder(null);
		btnVuelosNac.setBounds(150, 3, 320, 51);
		panelVuelos.add(btnVuelosNac);

		imagenVuelosInternacionales = new ImageIcon("Images\\InternacionalesBtn.png");
		imagenVuelosInternacionalesOscuro = new ImageIcon("Images\\btnInternacionalesOscuro.png");
		btnVuelosInternac = new JButton(imagenVuelosInternacionales);
		btnVuelosInternac.setBorder(null);
		btnVuelosInternac.setBounds(520, 3, 320, 51);
		panelVuelos.add(btnVuelosInternac);

		 // Configuración de botones para el panel izquierdo (menu)
		imagenAniadir = new ImageIcon("Images\\AniadirbtnClaro.png");
		imagenAniadirOscuro = new ImageIcon("Images\\btnAniadirOscuro.png");
		btnAniadir = new JButton(imagenAniadir);
		btnAniadir.setBounds(25, 25, 100, 100);
		btnAniadir.setBorder(null);
		panelIzq.add(btnAniadir);

		imagenActualizarIzq = new ImageIcon("Images\\Actualizar100btnClaro.png");
		imagenActualizarIzqOscuro = new ImageIcon("Images\\btnActualizar100Oscuro.png");
		btnActualizar = new JButton(imagenActualizarIzq);
		btnActualizar.setBounds(25, 150, 100, 100);
		btnActualizar.setBorder(null);
		panelIzq.add(btnActualizar);

		imagenMostrar = new ImageIcon("Images\\MostrarbtnClaro.png");
		imagenMostrarOscuro = new ImageIcon("Images\\btnMostrarOscuro.png");

		btnMostrar = new JButton(imagenMostrar);
		btnMostrar.setBounds(25, 275, 100, 100);
		btnMostrar.setBorder(null);
		panelIzq.add(btnMostrar);

		imagenSalir = new ImageIcon("Images\\SalirbtnClaro.png");
		imagenSalirOscuro = new ImageIcon("Images\\btnSalirOscuro.png");
		btnSalir = new JButton(imagenSalir);
		btnSalir.setBounds(25, 400, 100, 100);
		btnSalir.setBorder(null);
		panelIzq.add(btnSalir);

		imagenCambiarModo = new ImageIcon("Images\\ModoOscurobtnClaro.png");
		imagenCambiarModoOscuro = new ImageIcon("Images\\btnModoOscuroOscuro.png");
		btnCambiarModo = new JButton(imagenCambiarModo);
		btnCambiarModo.setBounds(0, 510, 161, 55);
		btnCambiarModo.setBorder(null);
		panelIzq.add(btnCambiarModo);

		// Configuración de botones para el panel Inferior
		imagenGuardar = new ImageIcon("Images\\GuardarbtnClaro.png");
		imagenGuardarOscuro = new ImageIcon("Images\\btnGuardarOscuro.png");
		btnGuardar = new JButton(imagenGuardar);
		btnGuardar.setBounds(150, 5, 75, 75);
		btnGuardar.setBorder(null);
		panelInferior.add(btnGuardar);

		imagenActualizar = new ImageIcon("Images\\ActualizarbtnClaro.png");
		imagenActualizarOscuro = new ImageIcon("Images\\btnActualizarOscuro.png");
		btnActualizarInferior = new JButton(imagenActualizar);
		btnActualizarInferior.setBounds(300, 5, 75, 75);
		btnActualizarInferior.setBorder(null);
		panelInferior.add(btnActualizarInferior);

		imagenEliminar = new ImageIcon("Images\\EliminarbtnClaro.png");
		imagenEliminarOscuro = new ImageIcon("Images\\btnEliminarOscuro.png");
		btnEliminar = new JButton(imagenEliminar);
		btnEliminar.setBounds(450, 5, 75, 75);
		btnEliminar.setBorder(null);
		panelInferior.add(btnEliminar);

		imagenCombustible = new ImageIcon("Images\\combustibleClaro.png");
		imagenCombustibleOscuro = new ImageIcon("Images\\combustibleOscuro.png");
		btnCombustible = new JButton(imagenCombustible);
		btnCombustible.setBounds(50, 395, 159, 36);
		btnCombustible.setToolTipText("Calcular combustible");
		btnCombustible.setBorder(null);
		panelCentral.add(btnCombustible);


	}
	/**
     * Configura los paneles de la interfaz.
     */
	public void paneles() {
		panelVuelos = new JPanel();
		panelVuelos.setLayout(null);
		panelVuelos.setBounds(0, 0, 1000, 60);
		panelVuelos.setBackground(Color.white);

		panelIzq = new JPanel();
		panelIzq.setLayout(null);
		panelIzq.setBounds(0, 61, 150, 615);
		panelIzq.setBackground(Color.white);

		panelCentral = new JPanel();
		panelCentral.setLayout(null);
		panelCentral.setBounds(151, 61, 850, 450);
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
		
		panelMostrarJTableNacional = new JPanel();
		panelMostrarJTableNacional.setLayout(null);
		panelMostrarJTableNacional.setBounds(151, 61, 850, 525);
		panelMostrarJTableNacional.setBackground(Color.white);
		
		panelMostrarJTableOInternacional = new JPanel();
		panelMostrarJTableOInternacional.setLayout(null);
		panelMostrarJTableOInternacional.setBounds(151, 61, 850, 525);
		panelMostrarJTableOInternacional.setBackground(Color.white);
		

	}
	/**
     * Configura los campos de texto de la interfaz.
     */
	public void textfield() {

		txtPassengersNumber = new JTextField();
		txtPassengersNumber.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtPassengersNumber.setBounds(190, 125, 400, 20);
		panelCentral.add(txtPassengersNumber);

		txtDepartureTime = new JTextField();
		txtDepartureTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtDepartureTime.setBounds(190, 175, 400, 20);
		panelCentral.add(txtDepartureTime);

		txtArrivalTime = new JTextField();
		txtArrivalTime.setFont(new Font("Agency FB", Font.BOLD, 14));
		txtArrivalTime.setBounds(190, 225, 400, 20);
		panelCentral.add(txtArrivalTime);
	}
	/**
     * Configura los combo boxes de la interfaz.
     */
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
	
////
	/**
	 * Este método configura y añade varias etiquetas (`JLabel`) a diferentes paneles de la interfaz gráfica de usuario.
	 * Las etiquetas se utilizan para mostrar información relacionada con vuelos, como el número de vuelo, nombre de la 
	 * compañía, número de pasajeros, horas de salida y llegada, destino, y otros datos importantes.
	 * 
	 * Las etiquetas se añaden a dos paneles principales:
	 * - `panelCentral`: Contiene información relacionada con el vuelo y su estado.
	 * - `panelNationalFlight` y `panelInternationalFlight`: Contienen información específica sobre vuelos nacionales e internacionales.
	 * 
	 * En particular, este método realiza lo siguiente:
	 * 
	 * - Crea una etiqueta de logo (`logo`) y la añade al `panelCentral`.
	 * - Configura y oculta temporalmente las etiquetas del número de vuelo (`numVuelo`) y el texto asociado (`txtNumVuelo`).
	 * - Añade etiquetas para el nombre de la compañía, número de pasajeros, hora de salida y llegada, destino y combustible.
	 * - Configura etiquetas adicionales en el panel de vuelos nacionales e internacionales para datos como si el avión es de 
	 *   turbina, turbohélice o si se requiere VISA para vuelos internacionales.
	 * 
	 * Configuraciones específicas:
	 * - Las etiquetas utilizan la fuente "Agency FB" con tamaños y estilos diferentes, como negrita.
	 * - Las posiciones y dimensiones de las etiquetas se establecen mediante el método `setBounds()`, que define su ubicación
	 *   y tamaño en el panel correspondiente.
	 * 
	 * No retorna ningún valor.
	 */
	
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

		lblArrivalPlace = new JLabel("Destino:");
		lblArrivalPlace.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblArrivalPlace.setBounds(35, 270, 230, 30);
		panelCentral.add(lblArrivalPlace);

		lblIsTurbine = new JLabel("¿Avion de turbina?");
		lblIsTurbine.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsTurbine.setBounds(35, 20, 230, 30);
		panelNationalFlight.add(lblIsTurbine);

		lblIsTurboProp = new JLabel("¿Avion de turbo helice?");
		lblIsTurboProp.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsTurboProp.setBounds(380, 20, 230, 30);
		panelNationalFlight.add(lblIsTurboProp);

		lblIsVisa = new JLabel("¿Necesita VISA?");
		lblIsVisa.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblIsVisa.setBounds(35, 20, 230, 30);
		panelInternationalFlight.add(lblIsVisa);

		txtCombustible = new JLabel();
		txtCombustible.setBounds(270, 320, 130, 70);
		txtCombustible.setFont(new Font("Agency FB", Font.BOLD, 24));
		panelCentral.add(txtCombustible);

	}
	
	/*public void jTables() {
		tablaVuelosInterNacional = new JTable();
		
		scrollpaneInt = new JScrollPane();
		
		tablaVuelosNacional = new JTable();
		
		scrollpaneNac = new JScrollPane();
	}*/
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

	public JLabel getTxtCombustible() {
		return txtCombustible;
	}

	public void setTxtCombustible(JLabel txtCombustible) {
		this.txtCombustible = txtCombustible;
	}

	public ImageIcon getImagenCambiarModo() {
		return imagenCambiarModo;
	}

	public void setImagenCambiarModo(ImageIcon imagenCambiarModo) {
		this.imagenCambiarModo = imagenCambiarModo;
	}

	public ImageIcon getImagenCambiarModoOscuro() {
		return imagenCambiarModoOscuro;
	}

	public void setImagenCambiarModoOscuro(ImageIcon imagenCambiarModoOscuro) {
		this.imagenCambiarModoOscuro = imagenCambiarModoOscuro;
	}

	public ImageIcon getImagenGuardar() {
		return imagenGuardar;
	}

	public void setImagenGuardar(ImageIcon imagenGuardar) {
		this.imagenGuardar = imagenGuardar;
	}

	public ImageIcon getImagenGuardarOscuro() {
		return imagenGuardarOscuro;
	}

	public void setImagenGuardarOscuro(ImageIcon imagenGuardarOscuro) {
		this.imagenGuardarOscuro = imagenGuardarOscuro;
	}

	public ImageIcon getImagenActualizar() {
		return imagenActualizar;
	}

	public void setImagenActualizar(ImageIcon imagenActualizar) {
		this.imagenActualizar = imagenActualizar;
	}

	public ImageIcon getImagenActualizarOscuro() {
		return imagenActualizarOscuro;
	}

	public void setImagenActualizarOscuro(ImageIcon imagenActualizarOscuro) {
		this.imagenActualizarOscuro = imagenActualizarOscuro;
	}

	public ImageIcon getImagenEliminar() {
		return imagenEliminar;
	}

	public void setImagenEliminar(ImageIcon imagenEliminar) {
		this.imagenEliminar = imagenEliminar;
	}

	public ImageIcon getImagenEliminarOscuro() {
		return imagenEliminarOscuro;
	}

	public void setImagenEliminarOscuro(ImageIcon imagenEliminarOscuro) {
		this.imagenEliminarOscuro = imagenEliminarOscuro;
	}

	public ImageIcon getImagenVuelosNacionales() {
		return imagenVuelosNacionales;
	}

	public void setImagenVuelosNacionales(ImageIcon imagenVuelosNacionales) {
		this.imagenVuelosNacionales = imagenVuelosNacionales;
	}

	public ImageIcon getImagenVuelosNacionalesOscuro() {
		return imagenVuelosNacionalesOscuro;
	}

	public void setImagenVuelosNacionalesOscuro(ImageIcon imagenVuelosNacionalesOscuro) {
		this.imagenVuelosNacionalesOscuro = imagenVuelosNacionalesOscuro;
	}

	public ImageIcon getImagenVuelosInternacionales() {
		return imagenVuelosInternacionales;
	}

	public void setImagenVuelosInternacionales(ImageIcon imagenVuelosInternacionales) {
		this.imagenVuelosInternacionales = imagenVuelosInternacionales;
	}

	public ImageIcon getImagenVuelosInternacionalesOscuro() {
		return imagenVuelosInternacionalesOscuro;
	}

	public void setImagenVuelosInternacionalesOscuro(ImageIcon imagenVuelosInternacionalesOscuro) {
		this.imagenVuelosInternacionalesOscuro = imagenVuelosInternacionalesOscuro;
	}

	public ImageIcon getImagenAniadir() {
		return imagenAniadir;
	}

	public void setImagenAniadir(ImageIcon imagenAniadir) {
		this.imagenAniadir = imagenAniadir;
	}

	public ImageIcon getImagenAniadirOscuro() {
		return imagenAniadirOscuro;
	}

	public void setImagenAniadirOscuro(ImageIcon imagenAniadirOscuro) {
		this.imagenAniadirOscuro = imagenAniadirOscuro;
	}

	public ImageIcon getImagenActualizarIzq() {
		return imagenActualizarIzq;
	}

	public void setImagenActualizarIzq(ImageIcon imagenActualizarIzq) {
		this.imagenActualizarIzq = imagenActualizarIzq;
	}

	public ImageIcon getImagenActualizarIzqOscuro() {
		return imagenActualizarIzqOscuro;
	}

	public void setImagenActualizarIzqOscuro(ImageIcon imagenActualizarIzqOscuro) {
		this.imagenActualizarIzqOscuro = imagenActualizarIzqOscuro;
	}

	public ImageIcon getImagenMostrar() {
		return imagenMostrar;
	}

	public void setImagenMostrar(ImageIcon imagenMostrar) {
		this.imagenMostrar = imagenMostrar;
	}

	public ImageIcon getImagenMostrarOscuro() {
		return imagenMostrarOscuro;
	}

	public void setImagenMostrarOscuro(ImageIcon imagenMostrarOscuro) {
		this.imagenMostrarOscuro = imagenMostrarOscuro;
	}

	public ImageIcon getImagenSalir() {
		return imagenSalir;
	}

	public void setImagenSalir(ImageIcon imagenSalir) {
		this.imagenSalir = imagenSalir;
	}

	public ImageIcon getImagenSalirOscuro() {
		return imagenSalirOscuro;
	}

	public void setImagenSalirOscuro(ImageIcon imagenSalirOscuro) {
		this.imagenSalirOscuro = imagenSalirOscuro;
	}

	public JButton getBtnCombustible() {
		return btnCombustible;
	}

	public void setBtnCombustible(JButton btnCombustible) {
		this.btnCombustible = btnCombustible;
	}

	public ImageIcon getImagenCombustible() {
		return imagenCombustible;
	}

	public void setImagenCombustible(ImageIcon imagenCombustible) {
		this.imagenCombustible = imagenCombustible;
	}

	public ImageIcon getImagenCombustibleOscuro() {
		return imagenCombustibleOscuro;
	}

	public void setImagenCombustibleOscuro(ImageIcon imagenCombustibleOscuro) {
		this.imagenCombustibleOscuro = imagenCombustibleOscuro;
	}

	public JPanel getPanelMostrarJTableNacional() {
		return panelMostrarJTableNacional;
	}

	public void setPanelMostrarJTableNacional(JPanel panelMostrarJTableNacional) {
		this.panelMostrarJTableNacional = panelMostrarJTableNacional;
	}

	public JPanel getPanelMostrarJTableOInternacional() {
		return panelMostrarJTableOInternacional;
	}

	public void setPanelMostrarJTableOInternacional(JPanel panelMostrarJTableOInternacional) {
		this.panelMostrarJTableOInternacional = panelMostrarJTableOInternacional;
	}

	public JScrollPane getScrollpaneNac() {
		return scrollpaneNac;
	}

	public void setScrollpaneNac(JScrollPane scrollpaneNac) {
		this.scrollpaneNac = scrollpaneNac;
	}

	public JScrollPane getScrollpaneInt() {
		return scrollpaneInt;
	}

	public void setScrollpaneInt(JScrollPane scrollpaneInt) {
		this.scrollpaneInt = scrollpaneInt;
	}

	public JTable getTablaVuelosNacional() {
		return tablaVuelosNacional;
	}

	public void setTablaVuelosNacional(JTable tablaVuelosNacional) {
		this.tablaVuelosNacional = tablaVuelosNacional;
	}

	public JTable getTablaVuelosInterNacional() {
		return tablaVuelosInterNacional;
	}

	public void setTablaVuelosInterNacional(JTable tablaVuelosInterNacional) {
		this.tablaVuelosInterNacional = tablaVuelosInterNacional;
	}
	
	
}
