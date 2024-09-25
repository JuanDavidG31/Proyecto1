package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.InternationalFlightDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;
import co.edu.unbosque.util.exception.BooleanNotValidInputException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf = new ModelFacade();
	private ViewFacade vf = new ViewFacade();
	private int numSeleccionado = 0;
	private String aerolinea = "";
	private NationalFlightDTO na;
	private InternationalFlightDTO in;
	private int distanceInternacional = 0;
	private int distanceNacional = 0;

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
		vf.getMa().getBtnActualizar().setActionCommand("btnActualizar");

		vf.getMa().getBtnBuscarIzq().addActionListener(this);
		vf.getMa().getBtnBuscarIzq().setActionCommand("btnBuscar");

		vf.getMa().getBtnSalir().addActionListener(this);
		vf.getMa().getBtnSalir().setActionCommand("btnSalir");

		vf.getMa().getBtnBuscarCentral().addActionListener(this);
		vf.getMa().getBtnBuscarCentral().setActionCommand("");

		vf.getMa().getBtnBuscarIzq().addActionListener(this);
		vf.getMa().getBtnBuscarIzq().setActionCommand("");

		vf.getMa().getBtnCambiarModo().addActionListener(this);
		vf.getMa().getBtnCambiarModo().setActionCommand("");

		vf.getMa().getBtnEliminar().addActionListener(this);
		vf.getMa().getBtnEliminar().setActionCommand("");

		vf.getMa().getBtnGuardar().addActionListener(this);
		vf.getMa().getBtnGuardar().setActionCommand("guardar");

		vf.getMa().getBtnMostrar().addActionListener(this);
		vf.getMa().getBtnMostrar().setActionCommand("");

		vf.getMa().getBtnVuelosInternac().addActionListener(this);
		vf.getMa().getBtnVuelosInternac().setActionCommand("internacional");

		vf.getMa().getBtnVuelosNac().addActionListener(this);
		vf.getMa().getBtnVuelosNac().setActionCommand("nacional");
	}

	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "internacional":
			numSeleccionado = 2;
			vf.getMa().getArrivalInternacional().setVisible(true);
			JOptionPane.showMessageDialog(null, "Vuelo nacional internacional seleccionado");

			break;
		case "nacional":
			numSeleccionado = 1;
			vf.getMa().getArrival().setVisible(true);
			JOptionPane.showMessageDialog(null, "Vuelo nacional seleccionado");

			break;

		case "guardar":
			// distanciaNacional();
			switch (numSeleccionado) {
			case 1:

				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbIsTurbine().getSelectedItem().toString().equals("")
						|| vf.getMa().getCmbIsTurbo().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = aerolinea;
					String passangers = vf.getMa().getTxtPassengersNumber().getText().toString();
					String departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
					String arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
					String departurePlace = "Bogota";
					String turbine = vf.getMa().getCmbIsTurbine().getSelectedItem().toString();
					String turbo = vf.getMa().getCmbIsTurbo().getSelectedItem().toString();
					String arrival = vf.getMa().getArrival().getSelectedItem().toString();

					boolean theTurbine = convBolean(turbine);
					boolean theTurbo = convBolean(turbo);
					int thePassangers = Integer.parseInt(passangers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);

					boolean condition = booleanException(turbine);
					boolean condition2 = booleanException(turbo);
					if (condition == true || condition2 == true) {
						JOptionPane.showMessageDialog(null, "Solamente debe digitar si o no", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					mf.getNational()
							.add(na = new NationalFlightDTO(company, thePassangers, null, null, theDepartureTime,
									theArraivalTime, 0, incNum(), departurePlace, arrival, theTurbo, theTurbine));
					JOptionPane.showMessageDialog(null, "Vuelo creado exitosamente");
				}

				break;
			case 2:
				if (vf.getMa().getTxtDepartureTime().getText().equals("")
						|| vf.getMa().getTxtArrivalTime().getText().equals("")
						|| vf.getMa().getAerolinea().getSelectedItem().toString().equals("")
						|| vf.getMa().getTxtPassengersNumber().getText().equals("")
						|| vf.getMa().getCmbIsTurbine().getSelectedItem().toString().equals("")
						|| vf.getMa().getCmbIsTurbo().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {
					String company = aerolinea;
					String passangers = vf.getMa().getTxtPassengersNumber().getText().toString();
					String departureTime = vf.getMa().getTxtDepartureTime().getText().toString();
					String arrivalTime = vf.getMa().getTxtArrivalTime().getText().toString();
					String departurePlace = "Bogota";
					String visa = vf.getMa().getCmbIsTurbine().getSelectedItem().toString();
					String arrival = vf.getMa().getArrival().getSelectedItem().toString();

					boolean theVisa = convBolean(visa);

					int thePassangers = Integer.parseInt(passangers);
					int theDepartureTime = Integer.parseInt(departureTime);
					int theArraivalTime = Integer.parseInt(arrivalTime);

					boolean condition = booleanException(visa);

					if (condition == true) {
						JOptionPane.showMessageDialog(null, "Solamente debe digitar si o no", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					mf.getInternational().add(in = new InternationalFlightDTO(company, thePassangers, null, null,
							theDepartureTime, theArraivalTime, 0, incNum(), departurePlace, arrival, theVisa));
					JOptionPane.showMessageDialog(null, "Vuelo creado exitosamente");
				}
				break;
			default:
				break;
			}

			break;

		case "btnAreolinea":
			vf.getPi().setVisible(false);
			vf.getMa().setVisible(true);
			vf.getMa().getPanelVuelos().setVisible(true);
			vf.getMa().getPanelVuelos().setVisible(true);
			break;
		case "btnCliente":

			break;
		case "seleccionarAerolinea":
			if (vf.getMa().getAerolinea().getSelectedItem().equals("Avianca")) {

				ImageIcon avianca = new ImageIcon("Images\\Avianca.png");

				Image resizedA = avianca.getImage().getScaledInstance(100, 65, Image.SCALE_REPLICATE);

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
		case "btnSalir":
			System.exit(0);
			break;

		default:
			break;
		}

	}

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

	public int random() {
		return (int) (Math.random() * 1000 + 10);
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

	public int eliminar() {

		return 0;

	}

	public void distanciaNacional() {
		String nacional = vf.getMa().getArrival().getSelectedItem().toString();

		switch (nacional) {
		case "Medellin":
			distanceNacional = 217;
			break;
		case "Cartagena":
			distanceNacional = 656;

			break;
		case "Pasto":
			distanceNacional = 507;

			break;
		case "Cali":
			distanceNacional = 279;
			break;
		case "Bucaramanga":
			distanceNacional = 290;

			break;
		case "Ibague":
			distanceNacional = 113;

			break;
		case "Pereira":
			distanceNacional = 177;

			break;
		case "Manizales":
			distanceNacional = 150;

			break;
		case "Monteria":
			distanceNacional = 494;

			break;
		case "Barranquilla":
			distanceNacional = 692;

			break;
		case "Santa Marta":
			distanceNacional = 714;

			break;
		case "Cucuta":
			distanceNacional = 402;

			break;
		default:
			break;
		}
	}

	public void distanciaInternacional() {

		String internacional = vf.getMa().getArrivalInternacional().getSelectedItem().toString();

		switch (internacional) {
		case "Madrid":
			distanceInternacional = 8039;
			break;
		case "Barcelona":
			distanceInternacional = 8522;
			break;
		case "Lisboa":
			distanceInternacional = 7523;
			break;
		case "Paris":
			distanceInternacional = 8639;
			break;
		case "Roma":
			distanceInternacional = 9355;
			break;
		case "Bruselas":
			distanceInternacional = 8800;
			break;
		case "Berlin":
			distanceInternacional = 9421;
			break;
		case "Londres":
			distanceInternacional = 8503;
			break;
		case "Dubai":
			distanceInternacional = 13622;
			break;
		case "New York":
			distanceInternacional = 4002;
			break;
		case "Los Angeles":
			distanceInternacional = 5597;
			break;
		case "Miami":
			distanceInternacional = 2433;
			break;
		case "Otawa":
			distanceInternacional = 4527;
			break;
		case "CDMX":
			distanceInternacional = 3157;
			break;
		case "Buenos Aires":
			distanceInternacional = 4694;
			break;
		case "Lima":
			distanceInternacional = 1888;
			break;
		case "Santiago de Chile":
			distanceInternacional = 4255;
			break;
		case "São Paulo":
			distanceInternacional = 4340;
			break;

		default:
			break;
		}
	}

	public int combustibleInt(int distance, int pasajeros) {

		return 0;
	}

	public int combustibleNac(int distance, int pasajeros) {

		return 0;
	}
  
	public int pesoPasajeros(int pasajeros) {
	  
	  int pesoPersona=70;
	  int pesototal=pesoPersona*pasajeros;
	  
	  return pesototal;
  }
}
