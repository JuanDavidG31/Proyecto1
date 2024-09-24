package co.edu.unbosque.controller;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.InternationalFlightDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf = new ModelFacade();
	private ViewFacade vf = new ViewFacade();

	public Controller() {

		mf = new ModelFacade();
		vf = new ViewFacade();

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
		vf.getMa().getBtnGuardar().setActionCommand("");

		vf.getMa().getBtnMostrar().addActionListener(this);
		vf.getMa().getBtnMostrar().setActionCommand("");

		vf.getMa().getBtnVuelosInternac().addActionListener(this);
		vf.getMa().getBtnVuelosInternac().setActionCommand("");

		vf.getMa().getBtnVuelosNac().addActionListener(this);
		vf.getMa().getBtnVuelosNac().setActionCommand("");

	}

	public void actionPerformed(ActionEvent e) {
		String aerolinea = "";

		switch (e.getActionCommand()) {

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
			} else if (vf.getMa().getAerolinea().getSelectedItem().equals("")) {
				vf.getMa().getLogo().setIcon(null);

			}

			break;
		case "btnSalir":
			System.exit(0);
			break;

		default:
			break;
		}

	}

	public int incNumReceipt() {
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
		return (int) (Math.random() * 1000 + 1);
	}

	public void combustibleNacional() {

	}

	public void combustibleInternacional() {

	}
}
