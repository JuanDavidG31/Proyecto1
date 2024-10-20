package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;
	private PatientDTO pa;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		pa = new PatientDTO();
		assignReaders();
		vf.getHome().setVisible(true);
	}

	public void assignReaders() {
		vf.getHome().getSchedule().addActionListener(this);
		vf.getHome().getSchedule().setActionCommand("scheduleInit");
		vf.getSchedule().getGenerate().addActionListener(this);
		vf.getSchedule().getGenerate().setActionCommand("generatedPatient");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "scheduleInit":
			vf.getHome().setVisible(false);
			vf.getSchedule().setVisible(true);
			break;

		case "generatedPatient":
			
			String doctor = vf.getSchedule().getDoctor().getSelectedItem().toString();
			String specialty = vf.getSchedule().getSpecialty().getSelectedItem().toString();
			String name = vf.getSchedule().getName().toString();
			String gmail = vf.getSchedule().getEmail().getText().toString();
			
			mf.getPatient().add(pa = new PatientDTO(name, gmail, 0, 0, doctor, specialty, null, 0));
			
			break;

		default:
			break;
		}

	}

}
