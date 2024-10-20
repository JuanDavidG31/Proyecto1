package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		assignReaders();
		vf.getHome().setVisible(true);
	}

	public void assignReaders() {
		vf.getHome().getSchedule().addActionListener(this);
		vf.getHome().getSchedule().setActionCommand("scheduleInit");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "scheduleInit":
			vf.getHome().setVisible(false);
			vf.getSchedule().setVisible(true);
			break;

		default:
			break;
		}

	}

}
