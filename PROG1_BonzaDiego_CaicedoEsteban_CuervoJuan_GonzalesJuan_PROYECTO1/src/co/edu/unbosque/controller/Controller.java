package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener{
	private ModelFacade mf = new ModelFacade();
	private ViewFacade vf= new ViewFacade();
	public Controller() {

  	mf = new ModelFacade();
		vf = new ViewFacade();
  
		vf.getPi().setVisible(true);
		vf.getMa().getPanelBuscar().setVisible(false);
		vf.getMa().getPanelCentral().setVisible(false);
		vf.getMa().getPanelInferior().setVisible(false);
		vf.getMa().getPanelIzq().setVisible(false);
		vf.getMa().getPanelVariable().setVisible(false);
		vf.getMa().getPanelVuelos().setVisible(false);
		
		asignarLectores();
	}
	
	public void asignarLectores() {
		vf.getPi().getBtnAereolinea().setActionCommand("btnAreolinea");
		vf.getPi().getBtnAereolinea().addActionListener(this);
		
		vf.getPi().getBtnCliente().setActionCommand("btnCliente");
		vf.getPi().getBtnCliente().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "btnAreolinea":
			vf.getPi().setVisible(false);
			vf.getMa().setVisible(true);
			vf.getMa().getPanelVuelos().setVisible(true);
			break;
		case "btnCliente":
			
			break;
		
		default:
			break;
		}

	
	}
	public void run() {


	}
}
