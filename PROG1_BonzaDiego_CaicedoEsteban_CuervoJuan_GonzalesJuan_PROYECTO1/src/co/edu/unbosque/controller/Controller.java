/**
 * La clase {@code Controller} es responsable de manejar las interacciones entre la vista y el modelo en el sistema de gestión de vuelos.
 * Implementa {@link ActionListener} para responder a eventos de acción generados en la interfaz de usuario.
 * 
 * <p>
 * El controlador se encarga de coordinar las operaciones entre la vista y el modelo, como la actualización,
 * eliminación y creación de vuelos nacionales e internacionales.
 * </p>
 * 
 * <p>
 * Algunos métodos claves incluyen:
 * <ul>
 *  <li>{@code asignarLectores()}: Asigna los eventos a los botones de la vista.</li>
 *  <li>{@code actionPerformed(ActionEvent e)}: Controla los eventos disparados por la interfaz de usuario.</li>
 *  <li>{@code eliminar(String numVuelo)}: Elimina un vuelo en base a su ID.</li>
 * </ul>
 * </p>
 * 
 * @see co.edu.unbosque.model.ModelFacade
 * @see co.edu.unbosque.view.ViewFacade
 * @see co.edu.unbosque.model.NationalFlightDTO
 * @see co.edu.unbosque.model.InternationalFlightDTO
 * 
 */
package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import co.edu.unbosque.model.InternationalFlightDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;
import co.edu.unbosque.model.persistence.DataMapper;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exception.BooleanNotValidInputException;
import co.edu.unbosque.util.exception.CheckNegativeTime;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.MilitaryHourException;
import co.edu.unbosque.util.exception.PassengersNegativeNumberException;
import co.edu.unbosque.util.exception.PassengersNumberException;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	
	/** Facade del modelo que maneja la lógica de los vuelos */
	private ModelFacade mf = new ModelFacade();
	/** Facade de la vista que maneja la interfaz de usuario */
	private ViewFacade vf = new ViewFacade();
	/** Número del vuelo seleccionado */
	private int numSeleccionado = 0;
	/** ID del vuelo actual */
	private int id = 0;
	/** Aerolínea seleccionada */
	private String aerolinea = "";
	/** DTO para vuelos nacionales */
	private NationalFlightDTO na;
	/** DTO para vuelos internacionales */
	private InternationalFlightDTO in;
	  /** Duración de vuelos internacionales */
	private int duracionInternacional = 0;
	 /** Duración de vuelos nacionales */
	private int duracionNacional = 0;
	 /** Número de vuelo a actualizar */
	private int numActualizar = 0;
	/** Modo oscuro activado o no */
	boolean modoOscuro = false;

	/**
     * Constructor de la clase {@code Controller}.
     * Inicializa los objetos de la vista y del modelo, y asigna los eventos de la interfaz.
     */
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		na = new NationalFlightDTO();
		in = new InternationalFlightDTO();
		vf.getPi().setVisible(true);
		asignarLectores();

	}

	public void run() {

	}
	/**
     * Asigna los eventos de acción a los componentes de la interfaz de usuario.
     */
	public void asignarLectores() {
		vf.getPi().getBtnAereolinea().addActionListener(this);
		vf.getPi().getBtnAereolinea().setActionCommand("btnAreolinea");

		vf.getPi().getBtnCliente().addActionListener(this);
		vf.getPi().getBtnCliente().setActionCommand("btnCliente");

		vf.getMa().getAerolinea().addActionListener(this);
		vf.getMa().getAerolinea().setActionCommand("seleccionarAerolinea");

		vf.getMa().getBtnAniadir().addActionListener(this);
		vf.getMa().getBtnAniadir().setActionCommand("btnAniadir");

		vf.getMa().getBtnActualizar().addActionListener(this);
		vf.getMa().getBtnActualizar().setActionCommand("mostrarActualizar");

		vf.getMa().getBtnSalir().addActionListener(this);
		vf.getMa().getBtnSalir().setActionCommand("btnSalir");

		vf.getMa().getBtnCambiarModo().addActionListener(this);
		vf.getMa().getBtnCambiarModo().setActionCommand("btnCambiarModo");

		vf.getMa().getBtnGuardar().addActionListener(this);
		vf.getMa().getBtnGuardar().setActionCommand("guardar");

		vf.getMa().getBtnEliminar().addActionListener(this);
		vf.getMa().getBtnEliminar().setActionCommand("eliminar");

		vf.getMa().getBtnMostrar().addActionListener(this);
		vf.getMa().getBtnMostrar().setActionCommand("btnMostrar");

		vf.getMa().getBtnVuelosInternac().addActionListener(this);
		vf.getMa().getBtnVuelosInternac().setActionCommand("internacional");

		vf.getMa().getBtnVuelosNac().addActionListener(this);
		vf.getMa().getBtnVuelosNac().setActionCommand("nacional");

		vf.getMa().getBtnActualizarInferior().addActionListener(this);
		vf.getMa().getBtnActualizarInferior().setActionCommand("actualizar");

		vf.getMa().getBtnCombustible().addActionListener(this);
		vf.getMa().getBtnCombustible().setActionCommand("combustible");
	}

	 /**
     * Método que responde a las acciones de los botones en la vista.
     * Controla el flujo lógico para actualizar, mostrar, eliminar o agregar vuelos.
     *
     * @param e Evento de acción disparado desde la vista
     */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "combustible":
			if (numSeleccionado == 1) {
				int pasajerosNac = Integer.parseInt(vf.getMa().getTxtPassengersNumber().getText());

				int combustible = combustibleNacional(pasajerosNac);
				vf.getMa().getTxtCombustible().setText(combustible + " kg");
			} else if (numSeleccionado == 2) {
				int pasajerosInt = Integer.parseInt(vf.getMa().getTxtPassengersNumber().getText());
				int combustible = combustibleIntercional(pasajerosInt);
				vf.getMa().getTxtCombustible().setText(combustible + " kg");
			}
			break;
		case "actualizar":
			switch (numActualizar) {
			case 1:
				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbIsTurbine().getSelectedItem().toString().equals("")
						|| vf.getMa().getCmbIsTurbo().getSelectedItem().toString().equals("")
						|| vf.getMa().getArrival().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = "";
					String passengers = "";
					String departureTime = "";
					String arrivalTime = "";
					String departurePlace = "";
					String arrival = "";
					String turbine = "";
					String turbo = "";

					try {
						company = aerolinea;
						passengers = vf.getMa().getTxtPassengersNumber().getText().toString();
						departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
						arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
						departurePlace = "Bogota";
						arrival = vf.getMa().getArrival().getSelectedItem().toString();
						turbine = vf.getMa().getCmbIsTurbine().getSelectedItem().toString();
						turbo = vf.getMa().getCmbIsTurbo().getSelectedItem().toString();

					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					int conditionNum1 = passengersException(passengers);
					boolean theTurbine = convBolean(turbine);
					boolean theTurbo = convBolean(turbo);
					int thePassengers = Integer.parseInt(passengers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);
					int conditionTime = timeException(theArraivalTime, theDepartureTime);
					int combustibleNac = combustibleNacional(thePassengers);

					if (conditionNum1 == 0 && conditionTime == 0) {

						ArrayList<NationalFlightDTO> s1;
						s1 = new ArrayList<>();
						s1 = mf.getNational().getAll();
						m: for (int i = 0; i < s1.size(); i++) {
							int theId = s1.get(i).getId();
							if (id == theId) {
								String cap = s1.get(i).getNameCaptain();
								String sub = s1.get(i).getNameSecondCommand();

								mf.getNational()
										.update(new NationalFlightDTO(null, 0, null, null, 0, 0, 0, id, null, null,
												false, false),
												new NationalFlightDTO(company, thePassengers, cap, sub,
														theDepartureTime, theArraivalTime, combustibleNac, id,
														departurePlace, arrival, theTurbo, theTurbine));
								JOptionPane.showMessageDialog(null, "Vuelo numero " + id + " actualizado exitosamente");
								reiniciarInputsInt();
								reiniciarInputsNac();
								break m;

							} else {
								continue m;
							}

						}
					} else if (conditionNum1 == 1) {
						vf.getMa().getTxtPassengersNumber().setText(null);
					} else if (conditionTime == 1) {
						vf.getMa().getTxtArrivalTime().setText(null);
					} else if (conditionTime == 2) {
						vf.getMa().getTxtDepartureTime().setText(null);
					}
				}
				break;
			case 2:
				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbVisa().getSelectedItem().toString().equals("")
						|| vf.getMa().getArrivalInternacional().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = "";
					String passengers = "";
					String departureTime = "";
					String arrivalTime = "";
					String departurePlace = "";
					String arrival = "";
					String visa = "";

					try {
						company = aerolinea;
						passengers = vf.getMa().getTxtPassengersNumber().getText().toString();
						departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
						arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
						departurePlace = "Bogota";
						visa = vf.getMa().getCmbVisa().getSelectedItem().toString();
						arrival = vf.getMa().getArrivalInternacional().getSelectedItem().toString();
					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					int conditionNum1 = passengersException(passengers);

					boolean theVisa = convBolean(visa);

					int thePassengers = Integer.parseInt(passengers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);
					int combustibleInt = combustibleIntercional(thePassengers);

					int conditionTime = timeException(theArraivalTime, theDepartureTime);
					int conditionNum = passengersException(passengers);

					if (conditionNum == 0 && conditionTime == 0) {
						ArrayList<InternationalFlightDTO> i1;
						i1 = new ArrayList<>();
						i1 = mf.getInternational().getAll();
						m1: for (int i = 0; i < i1.size(); i++) {
							int theId = i1.get(i).getId();

							if (id == theId) {
								String cap = i1.get(i).getNameCaptain();
								String sub = i1.get(i).getNameSecondCommand();
								mf.getInternational().update(
										new InternationalFlightDTO(null, 0, null, null, 0, 0, 0, id, null, null, false),
										new InternationalFlightDTO(company, thePassengers, cap, sub, theDepartureTime,
												theArraivalTime, combustibleInt, id, departurePlace, arrival, theVisa));
								JOptionPane.showMessageDialog(null, "Vuelo numero " + id + " actualizado exitosamente");
								reiniciarInputsInt();
								reiniciarInputsNac();
								break m1;
							} else {
								continue m1;
							}

						}

					} else if (conditionNum1 == 1) {
						vf.getMa().getTxtPassengersNumber().setText(null);
					} else if (conditionTime == 1) {
						vf.getMa().getTxtArrivalTime().setText(null);
					} else if (conditionTime == 2) {
						vf.getMa().getTxtDepartureTime().setText(null);
					}
				}
				break;
			default:
				break;
			}

			break;

		case "mostrarActualizar":
			boolean funcion = false;
			boolean funcion2 = false;
			try {
				String numAct = JOptionPane.showInputDialog("ingrese el numero de vuelo a actualizar");
				vf.getMa().getNumVuelo().setText(numAct);
				id = Integer.parseInt(numAct);
			} catch (NumberFormatException x) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			ArrayList<NationalFlightDTO> s1;
			s1 = new ArrayList<>();
			s1 = mf.getNational().getAll();

			m: for (int i = 0; i < s1.size(); i++) {
				int theId = s1.get(i).getId();
				if (id == theId) {
					funcion = true;
					mostrarActualizar1();
					numActualizar = 1;
					break m;
				} else {
					continue;
				}
			}

			ArrayList<InternationalFlightDTO> i1;
			i1 = new ArrayList<>();
			i1 = mf.getInternational().getAll();

			m: for (int i = 0; i < i1.size(); i++) {
				int theId = i1.get(i).getId();
				if (id == theId) {
					funcion2 = true;
					mostrarActualizar2();
					numActualizar = 2;
					break m;
				} else {
					continue;
				}

			}

			if (funcion == false && funcion2 == false) {
				vf.getMa().getNumVuelo().setText("No existe");
				JOptionPane.showMessageDialog(null, "No existe el vuelo digitado", "Error", JOptionPane.ERROR_MESSAGE);
			}

			break;

		case "eliminar":
			String numVuelo = JOptionPane.showInputDialog("ingrese el numero de vuelo a eliminar");

			eliminar(numVuelo);

			break;
			
			/**
		     * Elimina un vuelo basado en su número de vuelo.
		     *
		     * @param numVuelo El número de vuelo a eliminar
		     */
			
		case "btnCambiarModo":
			/**
			 * Maneja el evento de cambio de modo (claro/oscuro) en la interfaz.
			 * Dependiendo del estado actual de `modoOscuro`, cambia el tema visual de
			 * la aplicación, alterando los colores de fondo, iconos y etiquetas.
			 * 
			 * @param event El evento generado al presionar el botón de cambio de modo.
			 */

			if (modoOscuro) {
				// Cambiar iconos de los botones a modo claro
				vf.getMa().getBtnCambiarModo().setIcon(vf.getMa().getImagenCambiarModo());
				vf.getMa().getBtnActualizar().setIcon(vf.getMa().getImagenActualizarIzq());
				vf.getMa().getBtnActualizarInferior().setIcon(vf.getMa().getImagenActualizar());
				vf.getMa().getBtnEliminar().setIcon(vf.getMa().getImagenEliminar());
				vf.getMa().getBtnGuardar().setIcon(vf.getMa().getImagenGuardar());
				vf.getMa().getBtnMostrar().setIcon(vf.getMa().getImagenMostrar());
				vf.getMa().getBtnSalir().setIcon(vf.getMa().getImagenSalir());
				vf.getMa().getBtnVuelosInternac().setIcon(vf.getMa().getImagenVuelosInternacionales());
				vf.getMa().getBtnVuelosNac().setIcon(vf.getMa().getImagenVuelosNacionales());
				vf.getMa().getBtnAniadir().setIcon(vf.getMa().getImagenAniadir());
				vf.getMa().getBtnCombustible().setIcon(vf.getMa().getImagenCombustible());

				 // Cambiar colores de los paneles a modo claro
				vf.getMa().getPanelCentral().setBackground(Color.white);
				vf.getMa().getPanelInferior().setBackground(Color.white);
				vf.getMa().getPanelInternationalFlight().setBackground(Color.white);
				vf.getMa().getPanelIzq().setBackground(Color.white);
				vf.getMa().getPanelNationalFlight().setBackground(Color.white);
				vf.getMa().getPanelVariable().setBackground(Color.white);
				vf.getMa().getPanelVuelos().setBackground(Color.white);

				vf.getMa().getPanelMostrarJTableNacional().setBackground(Color.white);
				vf.getMa().getPanelMostrarJTableOInternacional().setBackground(Color.white);

				// Cambiar colores de las etiquetas a modo claro
				vf.getMa().getLblArrivalPlace().setForeground(Color.black);
				vf.getMa().getLblArrivalTime().setForeground(Color.black);
				vf.getMa().getLblCompanyName().setForeground(Color.black);
				vf.getMa().getLblDepartureTime().setForeground(Color.black);
				vf.getMa().getLblIsTurbine().setForeground(Color.black);
				vf.getMa().getLblIsTurboProp().setForeground(Color.black);
				vf.getMa().getLblIsVisa().setForeground(Color.black);
				vf.getMa().getLblPassengersNumber().setForeground(Color.black);
				vf.getMa().getNumVuelo().setForeground(Color.black);
				vf.getMa().getTxtNumVuelo().setForeground(Color.black);
				// Establecer el modo oscuro como desactivado
				modoOscuro = false;
			} else {
				// Cambiar iconos de los botones a modo oscuro
				vf.getMa().getBtnCambiarModo().setIcon(vf.getMa().getImagenCambiarModoOscuro());
				vf.getMa().getBtnActualizar().setIcon(vf.getMa().getImagenActualizarIzqOscuro());
				vf.getMa().getBtnActualizarInferior().setIcon(vf.getMa().getImagenActualizarOscuro());
				vf.getMa().getBtnEliminar().setIcon(vf.getMa().getImagenEliminarOscuro());
				vf.getMa().getBtnGuardar().setIcon(vf.getMa().getImagenGuardarOscuro());
				vf.getMa().getBtnMostrar().setIcon(vf.getMa().getImagenMostrarOscuro());
				vf.getMa().getBtnSalir().setIcon(vf.getMa().getImagenSalirOscuro());
				vf.getMa().getBtnVuelosInternac().setIcon(vf.getMa().getImagenVuelosInternacionalesOscuro());
				vf.getMa().getBtnVuelosNac().setIcon(vf.getMa().getImagenVuelosNacionalesOscuro());
				vf.getMa().getBtnAniadir().setIcon(vf.getMa().getImagenAniadirOscuro());
				vf.getMa().getBtnCombustible().setIcon(vf.getMa().getImagenCombustibleOscuro());

				// Cambiar colores de los paneles a modo oscuro
				vf.getMa().getPanelCentral().setBackground(Color.black);
				vf.getMa().getPanelInferior().setBackground(Color.black);
				vf.getMa().getPanelInternationalFlight().setBackground(Color.black);
				vf.getMa().getPanelIzq().setBackground(Color.black);
				vf.getMa().getPanelNationalFlight().setBackground(Color.black);
				vf.getMa().getPanelVariable().setBackground(Color.black);
				vf.getMa().getPanelVuelos().setBackground(Color.black);

				vf.getMa().getPanelMostrarJTableNacional().setBackground(Color.black);
				vf.getMa().getPanelMostrarJTableOInternacional().setBackground(Color.black);

				/// Cambiar colores de las etiquetas a modo oscuro
				vf.getMa().getLblArrivalPlace().setForeground(Color.white);
				vf.getMa().getLblArrivalTime().setForeground(Color.white);
				vf.getMa().getLblCompanyName().setForeground(Color.white);
				vf.getMa().getLblDepartureTime().setForeground(Color.white);
				vf.getMa().getLblIsTurbine().setForeground(Color.white);
				vf.getMa().getLblIsTurboProp().setForeground(Color.white);
				vf.getMa().getLblIsVisa().setForeground(Color.white);
				vf.getMa().getLblPassengersNumber().setForeground(Color.white);
				vf.getMa().getNumVuelo().setForeground(Color.white);
				vf.getMa().getTxtNumVuelo().setForeground(Color.white);
				// Establecer el modo oscuro como activado
				modoOscuro = true;
			}
			break;
			
			////
			/**
			 * Controla las acciones relacionadas con la selección de vuelos y aerolíneas.
			 *
			 * @param comando el comando que activa una acción específica (internacional, nacional, btnAniadir, guardar, etc.)
			 */
			
			/**
	         * Selecciona un vuelo internacional.
	         * Muestra el panel correspondiente y desactiva el menú.
	         * Muestra un mensaje de confirmación de selección de vuelo.
	         */
		case "internacional":
			numSeleccionado = 2;
			vf.getMa().getArrivalInternacional().setVisible(true);
			desactivarMenuVariables();
			JOptionPane.showMessageDialog(null, "Vuelo internacional seleccionado");
			break;
			/**
	         * Selecciona un vuelo nacional.
	         * Muestra el panel correspondiente y desactiva el menú.
	         * Muestra un mensaje de confirmación de selección de vuelo.
	         */
		case "nacional":

			numSeleccionado = 1;
			vf.getMa().getArrival().setVisible(true);
			desactivarMenuVariables();
			JOptionPane.showMessageDialog(null, "Vuelo nacional seleccionado");
			break;
			
			/**
	         * Muestra el panel de añadir un nuevo vuelo.
	         */
		case "btnAniadir":
			mostrarAniadir();
			break;
			/**
	         * Guarda los datos de un vuelo dependiendo si es nacional o internacional.
	         * Verifica que todos los campos requeridos sean ingresados.
	         * Realiza cálculos sobre los valores introducidos.
	         * Muestra un mensaje de error o confirmación según sea el caso.
	         */
		case "guardar":
			/**
             * Guarda un vuelo nacional.
             */
			switch (numSeleccionado) {
			case 1:
				// Verificación de campos vacíos y manejo de excepciones
				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbIsTurbine().getSelectedItem().toString().equals("")
						|| vf.getMa().getCmbIsTurbo().getSelectedItem().toString().equals("")
						|| vf.getMa().getArrival().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = "";
					String passengers = "";
					String departureTime = "";
					String arrivalTime = "";
					String departurePlace = "";
					String arrival = "";
					String turbine = "";
					String turbo = "";
					try {
						company = aerolinea;
						passengers = vf.getMa().getTxtPassengersNumber().getText().toString();
						departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
						arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
						departurePlace = "Bogota";
						arrival = vf.getMa().getArrival().getSelectedItem().toString();
						turbine = vf.getMa().getCmbIsTurbine().getSelectedItem().toString();
						turbo = vf.getMa().getCmbIsTurbo().getSelectedItem().toString();

					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					int conditionNum1 = passengersException(passengers);
					boolean theTurbine = convBolean(turbine);
					boolean theTurbo = convBolean(turbo);
					int thePassengers = Integer.parseInt(passengers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);
					int conditionTime = timeException(theArraivalTime, theDepartureTime);
					int combustibleNac = combustibleNacional(thePassengers);

					int num = incNum();
					boolean condition = booleanException(turbine);
					boolean condition2 = booleanException(turbo);

					if (conditionNum1 == 0 && conditionTime == 0) {

						if (condition == true || condition2 == true) {
							JOptionPane.showMessageDialog(null, "Solamente debe digitar si o no", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

						mf.getNational()
								.add(na = new NationalFlightDTO(company, thePassengers, verificarNombreCap(),
										verificarNombreSubCap(), theDepartureTime, theArraivalTime, combustibleNac, num,
										departurePlace, arrival, theTurbo, theTurbine));

						JOptionPane.showMessageDialog(null, "Vuelo numero " + num + " creado exitosamente");

						reiniciarInputsNac();
					} else if (conditionNum1 == 1) {
						vf.getMa().getTxtPassengersNumber().setText(null);
					} else if (conditionTime == 1) {
						vf.getMa().getTxtArrivalTime().setText(null);
					} else if (conditionTime == 2) {
						vf.getMa().getTxtDepartureTime().setText(null);
					}
				}

				break;
				/**
                 * Guarda un vuelo internacional.
                 */
			case 2:
				// Verificación de campos vacíos y manejo de excepciones
				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbVisa().getSelectedItem().toString().equals("")
						|| vf.getMa().getArrivalInternacional().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = "";
					String passengers = "";
					String departureTime = "";
					String arrivalTime = "";
					String departurePlace = "";
					String arrivalInt = "";
					String visa = "";

					try {
						company = aerolinea;
						passengers = vf.getMa().getTxtPassengersNumber().getText().toString();
						departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
						arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
						departurePlace = "Bogota";
						visa = vf.getMa().getCmbVisa().getSelectedItem().toString();
						arrivalInt = vf.getMa().getArrivalInternacional().getSelectedItem().toString();
					} catch (NumberFormatException x) {
						JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					boolean theVisa = convBolean(visa);

					int thePassengers = Integer.parseInt(passengers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);
					int flightNum = incNum();
					int conditionNum1 = passengersException(passengers);
					int conditionTime = timeException(theArraivalTime, theDepartureTime);
					int combustibleInt = combustibleIntercional(thePassengers);
					boolean condition = booleanException(visa);

					if (conditionNum1 == 0 && conditionTime == 0) {

						if (condition == true) {
							JOptionPane.showMessageDialog(null, "Solamente debe digitar si o no", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

						mf.getInternational()
								.add(in = new InternationalFlightDTO(company, thePassengers, verificarNombreCap(),
										verificarNombreSubCap(), theDepartureTime, theArraivalTime, combustibleInt,
										flightNum, departurePlace, arrivalInt, theVisa));

						JOptionPane.showMessageDialog(null, "Vuelo numero " + flightNum + " creado exitosamente");

						reiniciarInputsInt();
					} else if (conditionNum1 == 1) {
						vf.getMa().getTxtPassengersNumber().setText(null);
					} else if (conditionTime == 1) {
						vf.getMa().getTxtArrivalTime().setText(null);
					} else if (conditionTime == 2) {
						vf.getMa().getTxtDepartureTime().setText(null);
					}
				}
				break;
			default:
				break;
			}

			break;
			/**
	         * Muestra el panel de aerolíneas.
	         */
		case "btnAreolinea":
			vf.getPi().setVisible(false);
			vf.getMa().setVisible(true);
			vf.getMa().getPanelVuelos().setVisible(true);
			vf.getMa().getPanelVuelos().setVisible(true);
			break;
		case "btnCliente":

			break;
			/**
	         * Maneja la selección de una aerolínea y muestra el logo correspondiente.
	         */
		case "seleccionarAerolinea":
			if (vf.getMa().getAerolinea().getSelectedItem().equals("Avianca")) {

				ImageIcon avianca = new ImageIcon("Images\\Avianca.png");

				Image resizedA = avianca.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);

				vf.getMa().getLogo().setIcon(new ImageIcon(resizedA));
				aerolinea = "Avianca";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Latam")) {

				ImageIcon latam = new ImageIcon("Images\\Latam.png");
				Image resizedL = latam.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedL));
				aerolinea = "Latam";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Wingo")) {

				ImageIcon wingo = new ImageIcon("Images\\Wingo.png");
				Image resizedW = wingo.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedW));
				aerolinea = "Wingo";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Clic")) {

				ImageIcon clic = new ImageIcon("Images\\Clic.png");
				Image resizedC = clic.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedC));
				aerolinea = "Clic";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("JetSmart")) {

				ImageIcon jetSmart = new ImageIcon("Images\\jetsmart.png");
				Image resizedJ = jetSmart.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedJ));
				aerolinea = "Jet Smart";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Satena")) {

				ImageIcon satena = new ImageIcon("Images\\Satena.png");
				Image resizedS = satena.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedS));
				aerolinea = "Satena";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Air Canada")) {

				ImageIcon airCanada = new ImageIcon("Images\\AirCanada.png");
				Image resizedAC = airCanada.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedAC));
				aerolinea = "Air Canada";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("KLM")) {

				ImageIcon klm = new ImageIcon("Images\\Klm.png");
				Image resizedK = klm.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedK));
				aerolinea = "KLM";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Iberia")) {

				ImageIcon iberia = new ImageIcon("Images\\Iberia.png");
				Image resizedI = iberia.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedI));
				aerolinea = "Iberia";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Emirates")) {

				ImageIcon emirates = new ImageIcon("Images\\Emirates.png");
				Image resizedE = emirates.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedE));
				aerolinea = "Emirates";

			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("Delta")) {

				ImageIcon delta = new ImageIcon("Images\\Delta.png");
				Image resizedD = delta.getImage().getScaledInstance(100, 75, Image.SCALE_REPLICATE);
				vf.getMa().getLogo().setIcon(new ImageIcon(resizedD));
				aerolinea = "Delta";
			}

			break;
			
			/**
	         * Cierra la aplicación.
	         */
		case "btnSalir":
			System.exit(0);
			break;

			//
			
			/**
			 * Muestra la información de vuelos nacionales o internacionales en una tabla, dependiendo de la selección del usuario.
			 *
			 * <p>Este método es parte de un control de interfaz gráfica que permite al usuario visualizar 
			 * los vuelos disponibles en función de su selección. Si el usuario selecciona la opción de vuelos nacionales, 
			 * se despliega una tabla con los detalles de dichos vuelos. Si selecciona vuelos internacionales, 
			 * se muestra otra tabla con información pertinente.</p>
			 *
			 * <p>El método realiza lo siguiente:</p>
			 * <ol>
			 *   <li>Declara un arreglo de títulos de columnas para la tabla de vuelos nacionales o internacionales.</li>
			 *   <li>Obtiene la lista de vuelos nacionales o internacionales mediante la clase de manejo de vuelos (mf).</li>
			 *   <li>Inicializa un arreglo bidimensional para almacenar los datos de los vuelos.</li>
			 *   <li>Configura la visibilidad de los paneles en la interfaz gráfica para mostrar la tabla correspondiente.</li>
			 *   <li>Rellena el arreglo de datos con la información de cada vuelo (como número de vuelo, aerolínea, hora de salida, etc.).</li>
			 *   <li>Crea un objeto JTable para mostrar la información y la agrega a un JScrollPane para permitir el desplazamiento.</li>
			 *   <li>Configura el modo de redimensionamiento de la tabla y ajusta su tamaño en el panel correspondiente.</li>
			 * </ol>
			 *
			 * <p>Al finalizar, el método se encarga de mostrar la tabla de vuelos nacionales o internacionales en 
			 * el panel correspondiente y oculta el resto de elementos de la interfaz.</p>
			 *
			 * @throws NullPointerException si el objeto de la clase de manejo de vuelos (mf) es nulo o si 
			 *                              no se puede obtener la lista de vuelos.
			 * @throws ArrayIndexOutOfBoundsException si la lista de vuelos está vacía o si hay un error al acceder 
			 *                                         a los índices del arreglo de datos.
			 */

		case "btnMostrar":

			switch (numSeleccionado) {
			case 1:
				String titulosNac[] = { "Numero de Vuelo", "Aerolinea", "Hora de salida", "Hora de llegada", "Origen",
						"Destino", "Nombre Capitan", "Nombre del Segundo al Mando", "Numero de Pasajeros",
						"Combustible", "Avion de turbina", "Avion de elice" };
				ArrayList<NationalFlightDTO> naList = mf.getNational().getAll();
				String datosNac[][] = new String[naList.size()][12];

				vf.getMa().getPanelMostrarJTableNacional().setVisible(true);
				vf.getMa().getPanelMostrarJTableOInternacional().setVisible(false);
				vf.getMa().getPanelCentral().setVisible(false);
				vf.getMa().getPanelVariable().setVisible(false);
				int i = 0;
				for (NationalFlightDTO naDTO : naList) {
					datosNac[i][0] = Integer.toString(naDTO.getId());
					datosNac[i][1] = naDTO.getCompanyName();
					datosNac[i][2] = Integer.toString(naDTO.getDepartureTime());
					datosNac[i][3] = Integer.toString(naDTO.getArrivalTime());
					datosNac[i][4] = naDTO.getDepartureDestination();
					datosNac[i][5] = naDTO.getArrivalDestination();
					datosNac[i][6] = naDTO.getNameCaptain();
					datosNac[i][7] = naDTO.getNameSecondCommand();
					datosNac[i][8] = Integer.toString(naDTO.getPassengersNumber());
					datosNac[i][9] = Integer.toString(naDTO.getFuelWeight());
					datosNac[i][10] = Boolean.toString(naDTO.isTurbine());
					datosNac[i][11] = Boolean.toString(naDTO.isTurboProp());
					i++;

				}

				JTable jtNac = new JTable(datosNac, titulosNac);
				jtNac.setEnabled(true);
				jtNac.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 10, 820, 505);
				vf.getMa().getPanelMostrarJTableNacional().add(scrollPane);
				scrollPane.setViewportView(jtNac);
				break;
			case 2:
				String titulosInt[] = { "Numero de Vuelo", "Aerolinea", "Hora de salida", "Hora de llegada", "Origen",
						"Destino", "Nombre Capitan", "Nombre del Segundo al Mando", "Numero de Pasajeros",
						"Combustible", "Necesita VISA" };
				ArrayList<InternationalFlightDTO> intList = mf.getInternational().getAll();
				String datosInt[][] = new String[intList.size()][11];

				vf.getMa().getPanelMostrarJTableOInternacional().setVisible(true);
				vf.getMa().getPanelMostrarJTableNacional().setVisible(false);
				vf.getMa().getPanelCentral().setVisible(false);
				vf.getMa().getPanelVariable().setVisible(false);
				int in = 0;
				for (InternationalFlightDTO intDTO : intList) {
					datosInt[in][0] = Integer.toString(intDTO.getId());
					datosInt[in][1] = intDTO.getCompanyName();
					datosInt[in][2] = Integer.toString(intDTO.getDepartureTime());
					datosInt[in][3] = Integer.toString(intDTO.getArrivalTime());
					datosInt[in][4] = intDTO.getDepartureDestination();
					datosInt[in][5] = intDTO.getArrivalDestination();
					datosInt[in][6] = intDTO.getNameCaptain();
					datosInt[in][7] = intDTO.getNameSecondCommand();
					datosInt[in][8] = Integer.toString(intDTO.getPassengersNumber());
					datosInt[in][9] = Integer.toString(intDTO.getFuelWeight());
					datosInt[in][10] = Boolean.toString(intDTO.isVisa());
					in++;

				}

				JTable jtInt = new JTable(datosInt, titulosInt);
				jtInt.setEnabled(true);
				jtInt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				JScrollPane scrollPaneInt = new JScrollPane();
				scrollPaneInt.setBounds(10, 10, 820, 505);
				vf.getMa().getPanelMostrarJTableOInternacional().add(scrollPaneInt);
				scrollPaneInt.setViewportView(jtInt);
				break;

			default:
				break;
			}

			break;

		default:
			break;
		}

	}
	
	/**
	 * Muestra el panel para añadir un nuevo vuelo. 
	 * <p>Este método configura la interfaz gráfica para permitir al usuario 
	 * ingresar los detalles de un nuevo vuelo, ocultando componentes que no son 
	 * relevantes y mostrando el panel adecuado dependiendo de si se trata de un 
	 * vuelo nacional o internacional.</p>
	 */
	public void mostrarAniadir() {
		vf.getMa().getPanelCentral().setVisible(true);
		vf.getMa().getPanelVariable().setVisible(true);
		vf.getMa().getTxtNumVuelo().setVisible(false);
		vf.getMa().getNumVuelo().setVisible(false);
		vf.getMa().getPanelMostrarJTableNacional().setVisible(false);
		vf.getMa().getPanelMostrarJTableOInternacional().setVisible(false);
		if (numSeleccionado == 1) {
			vf.getMa().getCardLayout().show(vf.getMa().getPanelVariable(), vf.getMa().getNac());
			vf.getMa().getArrivalInternacional().setVisible(false);
		} else if (numSeleccionado == 2) {
			vf.getMa().getCardLayout().show(vf.getMa().getPanelVariable(), vf.getMa().getInt());
			vf.getMa().getArrival().setVisible(false);
		}
	}
	/**
	 * Muestra el panel para actualizar un vuelo nacional.
	 * <p>Este método configura la interfaz gráfica para permitir al usuario 
	 * actualizar los detalles de un vuelo nacional. Se asegura de que el panel 
	 * correspondiente esté visible y que los campos se limpien o se preparen 
	 * adecuadamente para la entrada de datos.</p>
	 *
	 * @throws NullPointerException si los componentes del panel son nulos.
	 */
	public void mostrarActualizar1() {
		vf.getMa().getPanelCentral().setVisible(true);
		vf.getMa().getPanelVariable().setVisible(true);
		vf.getMa().getTxtNumVuelo().setVisible(true);
		vf.getMa().getNumVuelo().setVisible(true);
		vf.getMa().getPanelMostrarJTableNacional().setVisible(false);
		vf.getMa().getPanelMostrarJTableOInternacional().setVisible(false);

		vf.getMa().getCardLayout().show(vf.getMa().getPanelVariable(), vf.getMa().getNac());
		vf.getMa().getArrivalInternacional().setVisible(false);
		vf.getMa().getAerolinea().setVisible(true);
		vf.getMa().getAerolinea().setSelectedIndex(0);
		vf.getMa().getLogo().setIcon(null);
		vf.getMa().getTxtPassengersNumber().setText(null);
		vf.getMa().getTxtDepartureTime().setText(null);
		vf.getMa().getTxtArrivalTime().setText(null);
		vf.getMa().getArrival().setVisible(true);
		vf.getMa().getArrival().setSelectedIndex(0);
		vf.getMa().getCmbIsTurbine().setSelectedIndex(0);
		vf.getMa().getCmbIsTurbo().setSelectedIndex(0);

	}
	/**
	 * Muestra el panel para actualizar un vuelo internacional.
	 * <p>Este método configura la interfaz gráfica para permitir al usuario 
	 * actualizar los detalles de un vuelo internacional. Se asegura de que el 
	 * panel correspondiente esté visible y que los campos se limpien o se 
	 * preparen adecuadamente para la entrada de datos.</p>
	 *
	 * @throws NullPointerException si los componentes del panel son nulos.
	 */
	public void mostrarActualizar2() {
		vf.getMa().getArrival().setVisible(false);

		vf.getMa().getPanelCentral().setVisible(true);
		vf.getMa().getPanelVariable().setVisible(true);
		vf.getMa().getTxtNumVuelo().setVisible(true);
		vf.getMa().getNumVuelo().setVisible(true);
		vf.getMa().getCardLayout().show(vf.getMa().getPanelVariable(), vf.getMa().getInt());
		vf.getMa().getArrivalInternacional().setVisible(true);
		vf.getMa().getAerolinea().setVisible(true);
		vf.getMa().getAerolinea().setSelectedIndex(0);
		vf.getMa().getArrivalInternacional().setSelectedIndex(0);
		vf.getMa().getLogo().setIcon(null);
		vf.getMa().getTxtPassengersNumber().setText(null);
		vf.getMa().getTxtDepartureTime().setText(null);
		vf.getMa().getTxtArrivalTime().setText(null);
		vf.getMa().getCmbVisa().setSelectedIndex(0);
	}
	/**
	 * Desactiva el menú de variables y oculta los paneles de entrada de datos.
	 * <p>Este método es útil para restablecer el estado de la interfaz 
	 * gráfica y asegurarse de que no se muestren elementos innecesarios.</p>
	 */
	public void desactivarMenuVariables() {
		vf.getMa().getPanelIzq().setVisible(true);
		vf.getMa().getPanelInferior().setVisible(true);
		vf.getMa().getPanelCentral().setVisible(false);
		vf.getMa().getPanelVariable().setVisible(false);
		// vf.getMa().getPanelVuelos().setVisible(true);
	}
	/**
	 * Genera un número de vuelo único que no se repita entre vuelos internacionales 
	 * y nacionales.
	 * <p>Este método genera un número aleatorio y verifica que no exista ya en 
	 * las listas de vuelos existentes. Si el número ya existe, se vuelve a 
	 * generar hasta encontrar uno que sea único.</p>
	 *
	 * @return un número entero que representa un número de vuelo único.
	 */
	public int incNum() {
		int num = 0;
		main: while (true) {
			boolean frist = false;
			boolean second = false;
			num = random();

			ArrayList<InternationalFlightDTO> in;
			in = new ArrayList<>();
			in = mf.getInternational().getAll();
			second: for (int i = 0; i < in.size(); i++) {

				if (in.isEmpty()) {
					break main;
				} else {

					if (in.get(i).getId() == num) {
						frist = true;
						break second;
					} else {
						continue second;
					}

				}

			}

			ArrayList<NationalFlightDTO> na;
			na = new ArrayList<>();
			na = mf.getNational().getAll();
			third: for (int i = 0; i < na.size(); i++) {

				if (na.isEmpty()) {
					break main;
				} else {

					if (na.get(i).getId() == num) {
						second = true;
						break third;
					} else {
						continue third;
					}

				}

			}

			if (frist == true || second == true) {
				continue main;
			} else {
				break main;
			}
		}

		return num;
	}
////
	public int random() {
		return (int) (Math.random() * 10000 + 100);
	}

	/**
	 * Convierte una cadena de texto a un valor booleano. Acepta "si" (o "Si") como
	 * verdadero y "no" (o "No") como falso.
	 * 
	 * @param text La cadena de texto a convertir.
	 * @return true si el texto es "si", false si es "no", y false si el texto no es
	 *         reconocido.
	 */
	public boolean convBolean(String text) {
		// Convertir el texto a minúsculas para comparación
		String txt = text.toLowerCase();

		// Comparar el texto con las opciones válidas
		if (txt.equals("si")) {
			return true; // Retornar verdadero si el texto es "si"
		} else if (txt.equals("no")) {
			return false; // Retornar falso si el texto es "no"
		}

		return false; // Retornar falso si el texto no es válido
	}

	/**
	 * Verifica si la entrada booleana es válida utilizando el validador de
	 * excepciones.
	 * 
	 * @param bo La cadena de texto que se desea validar como entrada booleana.
	 * @return true si se lanza una excepción de entrada no válida; false si la
	 *         entrada es válida.
	 */
	public boolean booleanException(String bo) {
		try {
			ExceptionChecker.BooleanNotValidInput(bo);
		} catch (BooleanNotValidInputException e) {
			return true;
		}
		return false;
	}

	public int passengersException(String passengers) {
		try {
			ExceptionChecker.PassengersNegativeNumber(passengers);
		} catch (PassengersNegativeNumberException e) {
			JOptionPane.showMessageDialog(vf.getMa(), "la cantidad de personas no puede ser negativa", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 1;
			// TODO: handle exception
		}
		try {
			ExceptionChecker.PassengersNotValidNumber(passengers);
		} catch (PassengersNumberException e) {
			JOptionPane.showMessageDialog(vf.getMa(), "la cantidad de personas no puede ser mayor a 300", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 1;
		}
		return 0;

	}

	public int timeException(int arrival, int departure) {
		try {

			ExceptionChecker.checkNegativeTime(departure);
		} catch (CheckNegativeTime e) {
			JOptionPane.showMessageDialog(vf.getMa(), "La hora de salida no puede ser negativa", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 2;
		}
		try {
			ExceptionChecker.MilitaryHour(departure);
		} catch (MilitaryHourException e) {
			JOptionPane.showMessageDialog(vf.getMa(), "La hora de salida debe estar en formato militar", "Error",
					JOptionPane.ERROR_MESSAGE);
			// TODO: handle exception
			return 2;
		}
		try {
			ExceptionChecker.checkNegativeTime(arrival);
		} catch (CheckNegativeTime e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(vf.getMa(), "La hora de llegada no puede ser negativa", "Error",
					JOptionPane.ERROR_MESSAGE);
			return 1;
		}
		try {
			ExceptionChecker.MilitaryHour(arrival);
		} catch (MilitaryHourException e) {
			JOptionPane.showMessageDialog(vf.getMa(), "La hora de llegada debe estar en formato militar", "Error",
					JOptionPane.ERROR_MESSAGE);

			return 1;
		}

		return 0;
	}
/////
	
	/**
	 * Elimina un vuelo dado su número de vuelo.
	 * <p>Este método busca el vuelo en las listas de vuelos internacionales y 
	 * nacionales, y lo elimina si se encuentra. Se muestra un mensaje de éxito 
	 * o de error según corresponda.</p>
	 *
	 * @param numVuelo el número de vuelo que se desea eliminar.
	 * @throws NumberFormatException si el número de vuelo no es un entero válido.
	 */
	public void eliminar(String numVuelo) {

		int theNum = Integer.parseInt(numVuelo);

		ArrayList<InternationalFlightDTO> in;
		in = new ArrayList<>();
		in = mf.getInternational().getAll();
		for (int i = 0; i < in.size(); i++) {

			int num = in.get(i).getId();

			if (num == theNum) {

				if (mf.getInternational()
						.delete(new InternationalFlightDTO(null, 0, null, null, 0, 0, 0, theNum, null, null, false))) {
					JOptionPane.showMessageDialog(null, "vuelo " + numVuelo + " eliminado correctamente");
					break;

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el vuelo", "Error",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}
			}

		}

		ArrayList<NationalFlightDTO> na;
		na = new ArrayList<>();
		na = mf.getNational().getAll();

		for (int i = 0; i < na.size(); i++) {

			int num = na.get(i).getId();

			if (num == theNum) {

				if (mf.getNational().delete(
						new NationalFlightDTO(null, 0, null, null, 0, 0, 0, theNum, null, null, false, false))) {
					JOptionPane.showMessageDialog(null, "vuelo " + numVuelo + " eliminado correctamente");
					break;

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el vuelo", "Error",
							JOptionPane.ERROR_MESSAGE);
					continue;
				}
			}

		}

	}
	/**
	 * Calcula la duración del vuelo nacional basado en la ciudad de destino seleccionada.
	 * <p>Este método asigna un valor a la variable {@code duracionNacional} 
	 * dependiendo de la ciudad de llegada seleccionada.</p>
	 */
	public void distanciaNacional() {
		String nacional = vf.getMa().getArrival().getSelectedItem().toString();

		switch (nacional) {
		case "Medellin":
			duracionNacional = 1;
			break;
		case "Cartagena":
			duracionNacional = 2;

			break;
		case "Pasto":
			duracionNacional = 2;

			break;
		case "Cali":
			duracionNacional = 1;
			break;
		case "Bucaramanga":
			duracionNacional = 1;

			break;
		case "Ibague":
			duracionNacional = 1;

			break;
		case "Pereira":
			duracionNacional = 1;

			break;
		case "Manizales":
			duracionNacional = 1;

			break;
		case "Monteria":
			duracionNacional = 2;

			break;
		case "Barranquilla":
			duracionNacional = 2;

			break;
		case "Santa Marta":
			duracionNacional = 2;

			break;
		case "Cucuta":
			duracionNacional = 1;

			break;
		default:
			break;
		}
	}
	/**
	 * Calcula la duración del vuelo internacional basado en la ciudad de destino seleccionada.
	 * <p>Este método asigna un valor a la variable {@code duracionInternacional} 
	 * dependiendo de la ciudad de llegada seleccionada.</p>
	 */
	public void distanciaInternacional() {
		String internacional = vf.getMa().getArrivalInternacional().getSelectedItem().toString();

		switch (internacional) {
		case "Madrid":
			duracionInternacional = 10;
			break;
		case "Barcelona":
			duracionInternacional = 10;
			break;
		case "Lisboa":
			duracionInternacional = 13;
			break;
		case "Paris":
			duracionInternacional = 11;
			break;
		case "Roma":
			duracionInternacional = 14;
			break;
		case "Bruselas":
			duracionInternacional = 13;
			break;
		case "Berlin":
			duracionInternacional = 14;
			break;
		case "Londres":
			duracionInternacional = 10;
			break;
		case "Dubai":
			duracionInternacional = 18;
			break;
		case "New York":
			duracionInternacional = 6;
			break;
		case "Los Angeles":
			duracionInternacional = 9;
			break;
		case "Miami":
			duracionInternacional = 4;
			break;
		case "Otawa":
			duracionInternacional = 9;
			break;
		case "CDMX":
			duracionInternacional = 5;
			break;
		case "Buenos Aires":
			duracionInternacional = 7;
			break;
		case "Lima":
			duracionInternacional = 3;
			break;
		case "Santiago de Chile":
			duracionInternacional = 6;
			break;
		case "São Paulo":
			duracionInternacional = 6;
			break;
		default:
			break;
		}
	}
	/**
	 * Calcula el consumo de combustible para un vuelo nacional dado el número de pasajeros.
	 * <p>Este método utiliza una fórmula que considera la duración del vuelo, 
	 * el peso del avión vacío, y otros factores para calcular el total de 
	 * combustible necesario.</p>
	 *
	 * @param pasajeros el número de pasajeros a bordo.
	 * @return el total de combustible estimado en litros.
	 */
	public int combustibleNacional(int pasajeros) {
		int duracion = duracionNacional;
		int cantMotor = 2400;
		int tierra = 100;
		int reserva = 600;
		int avionVacio = 43000;
		int personas = pasajeros * 70;
		int pesoTotal = (personas + avionVacio);
		int estimado = (duracion * cantMotor);
		int total = estimado + tierra + reserva + pesoTotal;
		return total;
	}
	/**
	 * Calcula el consumo de combustible para un vuelo internacional dado el número de pasajeros.
	 * <p>Este método utiliza una fórmula que considera la duración del vuelo, 
	 * el peso del avión vacío, y otros factores para calcular el total de 
	 * combustible necesario.</p>
	 *
	 * @param pasajeros el número de pasajeros a bordo.
	 * @return el total de combustible estimado en litros.
	 */
	public int combustibleIntercional(int pasajeros) {
		int duracion = duracionInternacional;
		int cantMotor = 4800;
		int tierra = 100;
		int reserva = 600;
		int avionVacio = 250000;
		int personas = pasajeros * 70;
		int pesoTotal = (personas + avionVacio);
		int estimado = (duracion * cantMotor);
		int total = estimado + tierra + reserva + pesoTotal;
		return total;
	}
	/**
	 * Reinicia los campos de entrada para un vuelo nacional.
	 * <p>Este método establece todos los campos de entrada relacionados con 
	 * un vuelo nacional a sus valores predeterminados.</p>
	 */
	public void reiniciarInputsNac() {
		vf.getMa().getAerolinea().setSelectedIndex(0);
		vf.getMa().getLogo().setIcon(null);
		// vf.getMa().getArrival().setVisible(true);
		vf.getMa().getArrival().setSelectedIndex(0);
		vf.getMa().getTxtPassengersNumber().setText(null);
		vf.getMa().getTxtDepartureTime().setText(null);
		vf.getMa().getTxtArrivalTime().setText(null);
		vf.getMa().getCmbIsTurbine().setSelectedIndex(0);
		vf.getMa().getCmbIsTurbo().setSelectedIndex(0);
		vf.getMa().getTxtCombustible().setText(null);
	}
	/**
	 * Reinicia los campos de entrada para un vuelo internacional.
	 * <p>Este método establece todos los campos de entrada relacionados con 
	 * un vuelo internacional a sus valores predeterminados.</p>
	 */
	public void reiniciarInputsInt() {
		vf.getMa().getAerolinea().setSelectedIndex(0);
		vf.getMa().getLogo().setIcon(null);
		// vf.getMa().getArrivalInternacional().setVisible(true);
		vf.getMa().getArrivalInternacional().setSelectedIndex(0);
		vf.getMa().getTxtPassengersNumber().setText(null);
		vf.getMa().getTxtDepartureTime().setText(null);
		vf.getMa().getTxtArrivalTime().setText(null);
		vf.getMa().getCmbVisa().setSelectedIndex(0);
		vf.getMa().getTxtCombustible().setText(null);
	}
	/**
	 * Obtiene un nombre aleatorio desde un archivo CSV.
	 * <p>Este método lee un archivo llamado "nombres.csv" y retorna un 
	 * nombre aleatorio de entre los nombres listados en el archivo.</p>
	 *
	 * @return un nombre aleatorio, o {@code null} si no se pudo obtener ningún nombre.
	 */
	public static String obtenerNombres() {
		List<String[]> datos = new ArrayList<>();
		String linea;
		String separador = ",";

		try (BufferedReader br = new BufferedReader(new FileReader("data" + "/" + "nombres.csv"))) {
			while ((linea = br.readLine()) != null) {

				String[] valores = linea.split(separador);
				datos.add(valores);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (datos.isEmpty()) {
			return null;
		}

		Random rand = new Random();

		String[] filaAleatoria = datos.get(rand.nextInt(datos.size()));

		return filaAleatoria[rand.nextInt(filaAleatoria.length)];
	}
	/**
	 * Verifica y obtiene un nombre de capitán que no esté ya asignado a 
	 * algún vuelo internacional o nacional.
	 * <p>Este método genera nombres aleatorios hasta encontrar uno que no 
	 * coincida con los nombres de capitán ya utilizados.</p>
	 *
	 * @return un nombre de capitán que no se haya utilizado previamente.
	 */
	public String verificarNombreCap() {

		String name = "";
		main: while (true) {
			boolean frist = false;
			boolean second = false;
			name = obtenerNombres();

			ArrayList<InternationalFlightDTO> in;
			in = new ArrayList<>();
			in = mf.getInternational().getAll();
			second: for (int i = 0; i < in.size(); i++) {

				if (in.isEmpty()) {
					break main;
				} else {

					if (in.get(i).getNameCaptain().equals(name)) {
						frist = true;
						break second;
					} else {
						continue second;
					}

				}

			}

			ArrayList<NationalFlightDTO> na;
			na = new ArrayList<>();
			na = mf.getNational().getAll();
			third: for (int i = 0; i < na.size(); i++) {

				if (na.isEmpty()) {
					break main;
				} else {

					if (na.get(i).getNameCaptain().equals(name)) {
						second = true;
						break third;
					} else {
						continue third;
					}

				}

			}

			if (frist == true || second == true) {
				continue main;
			} else {
				break main;
			}
		}

		return name;

	}
	/**
	 * Verifica y obtiene un nombre de copiloto que no esté ya asignado a 
	 * algún vuelo internacional o nacional.
	 * <p>Este método genera nombres aleatorios hasta encontrar uno que no 
	 * coincida con los nombres de copiloto ya utilizados.</p>
	 *
	 * @return un nombre de copiloto que no se haya utilizado previamente.
	 */
	public String verificarNombreSubCap() {

		String name = "";
		main: while (true) {
			boolean frist = false;
			boolean second = false;
			name = obtenerNombres();

			ArrayList<InternationalFlightDTO> in;
			in = new ArrayList<>();
			in = mf.getInternational().getAll();
			second: for (int i = 0; i < in.size(); i++) {

				if (in.isEmpty()) {
					break main;
				} else {

					if (in.get(i).getNameSecondCommand().equals(name)) {
						frist = true;
						break second;
					} else {
						continue second;
					}

				}

			}

			ArrayList<NationalFlightDTO> na;
			na = new ArrayList<>();
			na = mf.getNational().getAll();
			third: for (int i = 0; i < na.size(); i++) {

				if (na.isEmpty()) {
					break main;
				} else {

					if (na.get(i).getNameSecondCommand().equals(name)) {
						second = true;
						break third;
					} else {
						continue third;
					}

				}

			}

			if (frist == true || second == true) {
				continue main;
			} else {
				break main;
			}
		}

		return name;
	}

}
