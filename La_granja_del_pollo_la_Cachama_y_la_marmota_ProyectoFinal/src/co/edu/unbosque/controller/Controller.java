package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.TreatmentDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;
	private PatientDTO pa;
	private TreatmentDTO tr;
	private int checkWindow = 0;
	private boolean darkMode = false;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		pa = new PatientDTO();
		tr = new TreatmentDTO();

		assignReaders();
		vf.getHome().setVisible(true);

		showScheduleInfo();
		infoTreatment();

	}

	public void assignReaders() {

		// Home Buttons
		vf.getHome().getExit().addActionListener(this);
		vf.getHome().getExit().setActionCommand("exit");

		vf.getHome().getTheme().addActionListener(this);
		vf.getHome().getTheme().setActionCommand("theme");

		vf.getHome().getSchedule().addActionListener(this);
		vf.getHome().getSchedule().setActionCommand("homeSchedule");

		vf.getHome().getTreatment().addActionListener(this);
		vf.getHome().getTreatment().setActionCommand("homeTreatment");

		vf.getHome().getTurn().addActionListener(this);
		vf.getHome().getTurn().setActionCommand("homeTurn");

		vf.getHome().getReport().addActionListener(this);
		vf.getHome().getReport().setActionCommand("homeReport");

		vf.getHome().getTurn().addActionListener(this);
		vf.getHome().getTurn().setActionCommand("initGenerateTurns");

		// schedule Buttons

		vf.getSchedule().getScheduleButton().addActionListener(this);
		vf.getSchedule().getScheduleButton().setActionCommand("scheduleMenu");

		vf.getSchedule().getRescheduleButton().addActionListener(this);
		vf.getSchedule().getRescheduleButton().setActionCommand("reSchedleMenu");

		vf.getSchedule().getCancelButton().addActionListener(this);
		vf.getSchedule().getCancelButton().setActionCommand("cancelMenu");

		vf.getSchedule().getGenerate().addActionListener(this);
		vf.getSchedule().getGenerate().setActionCommand("generatedPatient");

		vf.getSchedule().getReGenerate().addActionListener(this);
		vf.getSchedule().getReGenerate().setActionCommand("reGenerated");

		vf.getSchedule().getCancel().addActionListener(this);
		vf.getSchedule().getCancel().setActionCommand("cancel");

		vf.getSchedule().getHomeSchedule().addActionListener(this);
		vf.getSchedule().getHomeSchedule().setActionCommand("backHomeSchedule");

		vf.getSchedule().getHomeReschedule().addActionListener(this);
		vf.getSchedule().getHomeReschedule().setActionCommand("backHomeSchedule");

		vf.getSchedule().getHomeCancel().addActionListener(this);
		vf.getSchedule().getHomeCancel().setActionCommand("backHomeSchedule");

		vf.getSchedule().getHome().addActionListener(this);
		vf.getSchedule().getHome().setActionCommand("backMainMenu");

		vf.getSchedule().getThemeMain().addActionListener(this);
		vf.getSchedule().getThemeMain().setActionCommand("theme");

		vf.getSchedule().getSchTheme().addActionListener(this);
		vf.getSchedule().getSchTheme().setActionCommand("theme");

		vf.getSchedule().getReTheme().addActionListener(this);
		vf.getSchedule().getReTheme().setActionCommand("theme");

		vf.getSchedule().getCanTheme().addActionListener(this);
		vf.getSchedule().getCanTheme().setActionCommand("theme");

		// Treatments

		vf.getTreatments().getThemeMain().addActionListener(this);
		vf.getTreatments().getThemeMain().setActionCommand("theme");

		vf.getTreatments().getHome().addActionListener(this);
		vf.getTreatments().getHome().setActionCommand("backMainMenu");

		vf.getTreatments().getInitTreatment().addActionListener(this);
		vf.getTreatments().getInitTreatment().setActionCommand("initTreatment");

		vf.getTreatments().getInitSearchTreatment().addActionListener(this);
		vf.getTreatments().getInitSearchTreatment().setActionCommand("searchTreatment");

		vf.getTreatments().getInitFinishTreatment().addActionListener(this);
		vf.getTreatments().getInitFinishTreatment().setActionCommand("finishTreatment");

		vf.getTreatments().getHomeTreatments1().addActionListener(this);
		vf.getTreatments().getHomeTreatments1().setActionCommand("homeTreatments");

		vf.getTreatments().getHomeTreatments2().addActionListener(this);
		vf.getTreatments().getHomeTreatments2().setActionCommand("homeTreatments");

		vf.getTreatments().getHomeTreatments3().addActionListener(this);
		vf.getTreatments().getHomeTreatments3().setActionCommand("homeTreatments");

		vf.getTreatments().getRegister().addActionListener(this);
		vf.getTreatments().getRegister().setActionCommand("registerTre");

		vf.getTreatments().getUpdateTreatment().addActionListener(this);
		vf.getTreatments().getUpdateTreatment().setActionCommand("updateTre");

		vf.getTreatments().getSearchButton().addActionListener(this);
		vf.getTreatments().getSearchButton().setActionCommand("search");

		vf.getTreatments().getFinishTreatment().addActionListener(this);
		vf.getTreatments().getFinishTreatment().setActionCommand("finishTre");

		vf.getShowTreatment().getHome().addActionListener(this);
		vf.getShowTreatment().getHome().setActionCommand("sTreatmentBack");

		vf.getShowTreatment().getSelectTreatment().addActionListener(this);
		vf.getShowTreatment().getSelectTreatment().setActionCommand("selectTreatments");

		// Turnos

		vf.getShifts().getHome().addActionListener(this);
		vf.getShifts().getHome().setActionCommand("backMainMenu");

		vf.getShifts().getChangeTurn().addActionListener(this);
		vf.getShifts().getChangeTurn().setActionCommand("initChangeTurn");

		vf.getShifts().getInitTurn().addActionListener(this);
		vf.getShifts().getInitTurn().setActionCommand("initMakeTurns");

		vf.getShifts().getHomeTurn1().addActionListener(this);
		vf.getShifts().getHomeTurn1().setActionCommand("homeTurn");

		vf.getShifts().getSelectTurnTheme().addActionListener(this);
		vf.getShifts().getSelectTurnTheme().setActionCommand("theme");

		vf.getShifts().getSelectTurnTheme2().addActionListener(this);
		vf.getShifts().getSelectTurnTheme2().setActionCommand("theme");

		vf.getShifts().getGenerateChange().addActionListener(this);
		vf.getShifts().getGenerateChange().setActionCommand("cambio");

		vf.getShifts().getHomeTurn2().addActionListener(this);
		vf.getShifts().getHomeTurn2().setActionCommand("homeTurn");
	}

	@SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "theme":
			changeTheme();
			break;
		case "homeTurn":
			if (vf.getShifts().getPanelSelect().isVisible()) {
				vf.getShifts().getPanelSelect().setVisible(false);
				vf.getShifts().getMainPanel().setVisible(true);
			} else if (vf.getShifts().getPanelChange().isVisible()) {
				vf.getShifts().getPanelChange().setVisible(false);
				vf.getShifts().getMainPanel().setVisible(true);
			}
			break;
		case "initMakeTurns":
			vf.getShifts().getMainPanel().setVisible(false);
			vf.getShifts().getPanelSelect().setVisible(true);
			break;
		case "initChangeTurn":
			vf.getShifts().getMainPanel().setVisible(false);
			vf.getShifts().getPanelChange().setVisible(true);
			break;

		case "initGenerateTurns":
			vf.getHome().setVisible(false);
			vf.getShifts().setVisible(true);
			break;
		case "homeTreatments":
			checkWindow = 0;
			if (vf.getTreatments().getNewTreatmentPanel().isVisible()) {

				vf.getTreatments().getNewTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();

			} else if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {

				vf.getTreatments().getSearchTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();

			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				vf.getTreatments().getFinishTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();
			}

			break;
		case "sTreatmentBack":

			if (checkWindow == 1) {

				vf.getShowTreatment().setVisible(false);
				vf.getTreatments().setVisible(true);
				vf.getTreatments().getSearchTreatmentPanel().setVisible(true);
				infoTreatment();

			} else if (checkWindow == 2) {

				vf.getShowTreatment().setVisible(false);
				vf.getTreatments().setVisible(true);
				vf.getTreatments().getFinishTreatmentPanel().setVisible(true);
				infoTreatment();
			}

			break;
		case "initTreatment":
			checkWindow = 1;
			vf.getTreatments().getMainPanel().setVisible(false);
			vf.getTreatments().getNewTreatmentPanel().setVisible(true);

			infoTreatment();
			break;
		case "searchTreatment":
			checkWindow = 2;
			vf.getTreatments().getStatus2().setSelectedItem(null);
			vf.getTreatments().getTreatmentS().setText(null);
			vf.getTreatments().getSpecialty2().setSelectedItem(null);
			vf.getTreatments().getNameS().setText(null);
			vf.getTreatments().getSpecialty2().setVisible(false);
			vf.getTreatments().getTreatmentS().setEditable(false);
			vf.getTreatments().getTreatmentS().setVisible(false);
			// vf.getTreatments().getStatus2().setVisible(false);
			vf.getTreatments().getStatus2().enable(false);
			vf.getTreatments().getMainPanel().setVisible(false);
			vf.getTreatments().getSearchTreatmentPanel().setVisible(true);

			infoTreatment();
			break;
		case "finishTreatment":
			checkWindow = 3;
			vf.getTreatments().getStatus3().setSelectedItem(null);
			vf.getTreatments().getTreatmentF().setText(null);
			vf.getTreatments().getNameF().setText(null);

			vf.getTreatments().getTreatmentF().setEditable(false);
			vf.getTreatments().getTreatmentF().setVisible(false);
			vf.getTreatments().getStatus3().setVisible(false);

			vf.getTreatments().getMainPanel().setVisible(false);
			vf.getTreatments().getFinishTreatmentPanel().setVisible(true);
			infoTreatment();
			break;
		case "backMainMenu":

			if (vf.getSchedule().isVisible()) {
				vf.getSchedule().setVisible(false);
				vf.getHome().setVisible(true);
			} else if (vf.getTreatments().isVisible()) {
				vf.getTreatments().setVisible(false);
				vf.getHome().setVisible(true);
			} else if (vf.getShifts().isVisible()) {
				vf.getShifts().setVisible(false);
				vf.getHome().setVisible(true);

			}

			break;
		case "backHomeSchedule":
			vf.getSchedule().getMainPanel().setVisible(true);
			vf.getSchedule().getReschedulePanel().setVisible(false);
			vf.getSchedule().getSchedulePanel().setVisible(false);
			vf.getSchedule().getCancelPanel().setVisible(false);
			vf.getSchedule().getInfoPanel().setVisible(false);
			break;
		case "homeSchedule":
			vf.getHome().setVisible(false);
			vf.getSchedule().setVisible(true);
			break;
		case "homeTreatment":
			checkWindow = 0;
			vf.getTreatments().getTreatmentS().setText(null);
			vf.getTreatments().getSpecialty2().setSelectedItem(null);
			vf.getTreatments().getStatus2().setSelectedItem(null);
			vf.getTreatments().getNameS().setText(null);
			vf.getHome().setVisible(false);
			vf.getTreatments().setVisible(true);
			break;
		case "scheduleMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getSchedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;
		case "reSchedleMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getReschedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;
		case "cancelMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getCancelPanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;

		case "finishTre":
			boolean verf2 = true;

			if (vf.getTreatments().getNameF().getText().equals("")
					|| vf.getTreatments().getTreatmentF().getText().equals("")
					|| vf.getTreatments().getStatus3().getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String treatment = vf.getTreatments().getTreatmentF().getText().toString();
				String status = vf.getTreatments().getStatus3().getSelectedItem().toString();
				String name = vf.getTreatments().getNameF().getText().toString();
				String speciality = "";
				ArrayList<TreatmentDTO> t2;
				t2 = new ArrayList<>();
				t2 = mf.getTreatment().getAll();

				main: for (int i = 0; i < t2.size(); i++) {

					String status2 = t2.get(i).getVerified();
					String name2 = t2.get(i).getName();
					speciality = t2.get(i).getSpecialty();
					if (status.equals(status2) && !name.equals(name2)) {
						JOptionPane.showMessageDialog(null, "No se puede finalizar el tratamiento", "Error",
								JOptionPane.ERROR_MESSAGE);
						verf2 = false;

						break main;

					} else {
						continue main;
					}

				}

				if (verf2) {

					vf.getTreatments().getStatus3().setSelectedItem("Finalizado");
					status = vf.getTreatments().getStatus3().getSelectedItem().toString();

					if (mf.getTreatment().update(new TreatmentDTO(name, null, null, null),
							new TreatmentDTO(name, speciality, treatment, status))) {
						JOptionPane.showMessageDialog(null, "Tratamiento finalizado correctamente");
						vf.getTreatments().getTreatmentF().setText(null);
						vf.getTreatments().getStatus3().setSelectedItem(null);
						vf.getTreatments().getNameF().setText(null);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo finalizar el tratamiento ");
					}
				}
			}

			break;

		case "selectTreatments":

			if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {

				if (vf.getShowTreatment().getTreatment().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					String item = vf.getShowTreatment().getTreatment().getSelectedItem().toString();

					ArrayList<TreatmentDTO> tItem;
					tItem = new ArrayList<>();
					tItem = mf.getTreatment().getAll();

					for (int it = 0; it < tItem.size(); it++) {

						String item2 = tItem.get(it).getTreatment();

						if (item.equals(item2)) {

							String speciality = tItem.get(it).getSpecialty();
							String status = tItem.get(it).getVerified();

							vf.getTreatments().getSpecialty2().setSelectedItem(speciality);
							vf.getTreatments().getTreatmentS().setText(item);
							vf.getTreatments().getStatus2().setSelectedItem(status);

							vf.getShowTreatment().setVisible(false);
							vf.getTreatments().setVisible(true);

							vf.getTreatments().getSpecialty2().setVisible(true);
							vf.getTreatments().getTreatmentS().setEditable(true);
							vf.getTreatments().getTreatmentS().setVisible(true);
							vf.getTreatments().getStatus2().enable(true);
							break;
						} else {
							continue;
						}

					}

				}
			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				if (vf.getShowTreatment().getTreatment().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					String item = vf.getShowTreatment().getTreatment().getSelectedItem().toString();

					ArrayList<TreatmentDTO> tItem;
					tItem = new ArrayList<>();
					tItem = mf.getTreatment().getAll();

					for (int it = 0; it < tItem.size(); it++) {

						String item2 = tItem.get(it).getTreatment();

						if (item.equals(item2)) {

							String status = tItem.get(it).getVerified();

							vf.getTreatments().getTreatmentF().setText(item);
							vf.getTreatments().getStatus3().setSelectedItem(status);

							vf.getShowTreatment().setVisible(false);
							vf.getTreatments().setVisible(true);

							vf.getTreatments().getTreatmentF().setEditable(true);
							vf.getTreatments().getTreatmentF().setVisible(true);
							vf.getTreatments().getStatus3().enable(true);
							break;
						} else {
							continue;
						}

					}

				}

			}

			break;

		case "search":
			if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {
				if (vf.getTreatments().getNameS().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					String name = vf.getTreatments().getNameS().getText().toString();

					ArrayList<TreatmentDTO> tre;
					tre = new ArrayList<>();
					tre = mf.getTreatment().getAll();

					for (int i = 0; i < tre.size(); i++) {
						String tName = tre.get(i).getName();

						if (name.equals(tName)) {

							ArrayList<String> nameToSearch = new ArrayList<>();
							for (TreatmentDTO t : tre) {
								nameToSearch.add(t.getName());
							}

							int frecuency = Collections.frequency(nameToSearch, name);

							if (frecuency == 1) {

								String treatment = tre.get(i).getTreatment();
								String speciality = tre.get(i).getSpecialty();
								String status = tre.get(i).getVerified();

								vf.getTreatments().getSpecialty2().setSelectedItem(speciality);
								vf.getTreatments().getTreatmentS().setText(treatment);
								vf.getTreatments().getStatus2().setSelectedItem(status);

								vf.getTreatments().getSpecialty2().setVisible(true);
								vf.getTreatments().getTreatmentS().setEditable(true);
								vf.getTreatments().getTreatmentS().setVisible(true);
								vf.getTreatments().getStatus2().enable(true);
							} else {

								vf.getShowTreatment().setVisible(true);
								vf.getTreatments().setVisible(false);

								String content = "";
								for (int n = 0; n < tre.size(); n++) {

									String na = tre.get(n).getName().toString();

									if (na.equals(name)) {

										content += tre.get(n).getTreatment() + " ";

									} else {
										continue;
									}

								}

								String[] con = content.split(" ");
								vf.getShowTreatment().getTreatment().removeAllItems();
								vf.getShowTreatment().getTreatment().addItem("");
								for (int t = 0; t < con.length; t++) {

									vf.getShowTreatment().getTreatment().addItem(con[t]);

								}

							}

							break;

						} else {
							continue;
						}
					}

				}
			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				if (vf.getTreatments().getNameF().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					String name = vf.getTreatments().getNameF().getText().toString();

					ArrayList<TreatmentDTO> tr;
					tr = new ArrayList<>();
					tr = mf.getTreatment().getAll();

					for (int i = 0; i < tr.size(); i++) {
						String tName = tr.get(i).getName();

						if (name.equals(tName)) {

							ArrayList<String> nameToSearch = new ArrayList<>();
							for (TreatmentDTO t : tr) {
								nameToSearch.add(t.getName());
							}

							int frecuency = Collections.frequency(nameToSearch, name);

							if (frecuency == 1) {
								String treatment = tr.get(i).getTreatment();
								String status = tr.get(i).getVerified();

								vf.getTreatments().getTreatmentF().setText(treatment);
								vf.getTreatments().getStatus3().setSelectedItem(status);

								vf.getTreatments().getTreatmentF().setVisible(true);
								vf.getTreatments().getStatus3().setVisible(true);

								break;
							} else {

								vf.getShowTreatment().setVisible(true);
								vf.getTreatments().setVisible(false);

								String content = "";
								for (int n = 0; n < tr.size(); n++) {

									String na = tr.get(n).getName().toString();

									if (na.equals(name)) {

										content += tr.get(n).getTreatment() + " ";

									} else {
										continue;
									}

								}

								String[] con = content.split(" ");
								vf.getShowTreatment().getTreatment().removeAllItems();
								vf.getShowTreatment().getTreatment().addItem("");
								for (int t = 0; t < con.length; t++) {

									vf.getShowTreatment().getTreatment().addItem(con[t]);

								}

								break;
							}

						} else {
							continue;
						}
					}

				}

			}
			break;

		case "updateTre":

			boolean verf = true;

			if (vf.getTreatments().getSpecialty2().getSelectedItem().toString().equals("")
					|| vf.getTreatments().getTreatmentS().getText().toString().equals("")
					|| vf.getTreatments().getStatus2().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String treatment = vf.getTreatments().getTreatmentS().getText().toString();
				String speciality = vf.getTreatments().getSpecialty2().getSelectedItem().toString();
				String status = vf.getTreatments().getStatus2().getSelectedItem().toString();
				String name = vf.getTreatments().getNameS().getText().toString();

				ArrayList<TreatmentDTO> t;
				t = new ArrayList<>();
				t = mf.getTreatment().getAll();

				main: for (int i = 0; i < t.size(); i++) {

					String treatment2 = t.get(i).getTreatment();
					String speciality2 = t.get(i).getSpecialty();
					String status2 = t.get(i).getVerified();
					String name2 = t.get(i).getName();

					if (treatment.equals(treatment2) && speciality.equals(speciality2) && status.equals(status2)
							&& name.equals(name2)) {
						JOptionPane.showMessageDialog(null, "No se cambio ningun valor para actualizar", "Error",
								JOptionPane.ERROR_MESSAGE);
						verf = false;

						break main;

					} else {

						continue main;
					}

				}

				if (verf) {

					if (mf.getTreatment().update(new TreatmentDTO(name, null, null, null),
							new TreatmentDTO(name, speciality, treatment, status))) {
						JOptionPane.showMessageDialog(null, "Tratamiento actualizado correctamente");

						vf.getTreatments().getTreatmentS().setText(null);
						vf.getTreatments().getSpecialty2().setSelectedItem(null);
						vf.getTreatments().getStatus2().setSelectedItem(null);
						vf.getTreatments().getNameS().setText(null);
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo actualizar");
					}
				}
			}

			break;
		case "registerTre":

			boolean enter = true;

			if (vf.getTreatments().getName1().getText().toString().equals("")
					|| vf.getTreatments().getSpecialty().getSelectedItem().toString().equals("")
					|| vf.getTreatments().getTreatmentTxt().getText().toString().equals("")
					|| vf.getTreatments().getStatus().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String name = vf.getTreatments().getName1().getText().toString();

				ArrayList<PatientDTO> newPat;
				newPat = new ArrayList<>();
				newPat = mf.getPatient().getAll();
				newP: for (int i = 0; i < newPat.size(); i++) {

					String oldName = newPat.get(i).getName();

					if (name.equals(oldName)) {

						enter = false;

						String specialty = vf.getTreatments().getSpecialty().getSelectedItem().toString();
						String treatment = vf.getTreatments().getTreatmentTxt().getText().toString();
						String status = vf.getTreatments().getStatus().getSelectedItem().toString();

						if (mf.getTreatment().add(new TreatmentDTO(name, specialty, treatment, status))) {
							JOptionPane.showMessageDialog(null, "Tratamiento creado correctamente");
							vf.getTreatments().getName1().setText(null);
							vf.getTreatments().getSpecialty().setSelectedItem("");
							vf.getTreatments().getTreatmentTxt().setText(null);
							vf.getTreatments().getStatus().setSelectedItem("");
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo crear");
						}

						break newP;
					} else {
						continue newP;
					}

				}

			}
			if (enter) {
				JOptionPane.showMessageDialog(null, "El paciente no existe");
			}
			break;

		case "generatedPatient":

			if (vf.getSchedule().getDoctor().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getEmail().getText().toString().equals("")
					|| vf.getSchedule().getSpecialty().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getName1().getText().toString().equals("")
					|| vf.getSchedule().getDate1().getDate() == null) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String name = vf.getSchedule().getName1().getText().toString();
				String doctor = vf.getSchedule().getDoctor().getSelectedItem().toString();
				String specialty = vf.getSchedule().getSpecialty().getSelectedItem().toString();
				String gmail = vf.getSchedule().getEmail().getText().toString();

				Date tDate = vf.getSchedule().getDate1().getDate();
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				String date = formatoFecha.format(tDate);

				int appoitment = appoitment();

				if (mf.getPatient().add(pa = new PatientDTO(name, gmail, 0, 0, doctor, specialty, date, appoitment))) {

					JOptionPane.showMessageDialog(null, "Cita de numero " + appoitment + " creado exitosamente");

					// ENVIO DE NOTIFICACION MEDIANTE CORREO GMAIL

				} else {

					JOptionPane.showMessageDialog(null, "No se pudo crear");

				}

			}

			break;

		case "reGenerated":

			if (vf.getSchedule().getAppointmentNumbers().getText().toString().equals("")
					|| vf.getSchedule().getDate2().getDate() == null) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int appoint = Integer.parseInt(vf.getSchedule().getAppointmentNumbers().getText().toString());
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				String date = formatoFecha.format(vf.getSchedule().getDate2().getDate());
				ArrayList<PatientDTO> pat;
				pat = new ArrayList<>();
				pat = mf.getPatient().getAll();

				p: for (int i = 0; i < pat.size(); i++) {
					int ap = pat.get(i).getAppointmentNum();

					if (ap == appoint) {
						String doctor = pat.get(i).getDoctor();
						String specialty = pat.get(i).getSpecialty();
						String name = pat.get(i).getName();
						String gmail = pat.get(i).getGmail();

						if (mf.getPatient().update(new PatientDTO(null, null, 0, 0, null, null, null, appoint),
								new PatientDTO(name, gmail, 0, 0, doctor, specialty, date, appoint))) {

							JOptionPane.showMessageDialog(null,
									"Cita de numero " + appoint + " actualizado exitosamente");

							vf.getSchedule().getAppointmentNumber().setText("");

							break p;
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo actualizar");
							break p;

						}

					} else {
						continue p;
					}

				}

			}

			break;
		case "cancel":

			if (vf.getSchedule().getAppointmentNumber().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int appoint = Integer.parseInt(vf.getSchedule().getAppointmentNumber().getText().toString());

				ArrayList<PatientDTO> pat;
				pat = new ArrayList<>();
				pat = mf.getPatient().getAll();

				p: for (int i = 0; i < pat.size(); i++) {
					int ap = pat.get(i).getAppointmentNum();

					if (ap == appoint) {

						if (mf.getPatient().delete(new PatientDTO(null, null, 0, 0, null, null, null, appoint))) {

							JOptionPane.showMessageDialog(null,
									"Cita de numero " + appoint + " eliminado exitosamente");

							vf.getSchedule().getAppointmentNumber().setText("");

							break p;
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo eliminar");
							break p;

						}

					} else {
						continue p;
					}

				}

			}

			break;
		case "exit":
			JOptionPane.showMessageDialog(vf.getHome(), "Esta saliendo del programa");
			System.exit(0);
			break;
		default:
			break;
		}

	}

	public void changeTheme() {
		showScheduleInfo();
		infoTreatment();
		if (darkMode) {

			// Home

			ImageIcon homeClear = new ImageIcon("Images\\menuInicial\\Menu.png");
			vf.getHome().getBackground1().setIcon(homeClear);

			ImageIcon scheduleClear = new ImageIcon("Images\\menuInicial\\agendarClaro.png");
			vf.getHome().getSchedule().setIcon(scheduleClear);

			ImageIcon themeClear = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
			vf.getHome().getTheme().setIcon(themeClear);

			ImageIcon homeTreatmentClear = new ImageIcon("Images\\menuInicial\\tratamientoClaro.png");
			vf.getHome().getTreatment().setIcon(homeTreatmentClear);

			ImageIcon homeReportClear = new ImageIcon("Images\\menuInicial\\reporteClaro.png");
			vf.getHome().getReport().setIcon(homeReportClear);

			ImageIcon homeTurnClear = new ImageIcon("Images\\menuInicial\\turnoClaro.png");
			vf.getHome().getTurn().setIcon(homeTurnClear);

			ImageIcon exitCl = new ImageIcon("Images\\backButtons\\salirProgramaC.png");
			vf.getHome().getExit().setIcon(exitCl);

			// Agendar

			ImageIcon scheduleHomeClear = new ImageIcon("Images\\menuCitas\\menuControlCitasClaro.png");
			vf.getSchedule().getBackground1().setIcon(scheduleHomeClear);

			ImageIcon scheduleC = new ImageIcon("Images\\menuCitas\\1.png");
			vf.getSchedule().getScheduleButton().setIcon(scheduleC);

			ImageIcon reScheduleC = new ImageIcon("Images\\menuCitas\\3.png");
			vf.getSchedule().getRescheduleButton().setIcon(reScheduleC);

			ImageIcon cancelScheduleC = new ImageIcon("Images\\menuCitas\\5.png");
			vf.getSchedule().getCancelButton().setIcon(cancelScheduleC);

			vf.getSchedule().getThemeMain().setIcon(themeClear);

			vf.getSchedule().getInfoPanel().setBackground(new Color(0, 74, 173));

			ImageIcon homeBClear = new ImageIcon("Images\\backButtons\\1.png");
			vf.getSchedule().getHome().setIcon(homeBClear);

			ImageIcon schedulePanelClear = new ImageIcon("Images\\menuCitas\\agendarCita.png");
			vf.getSchedule().getBackground2().setIcon(schedulePanelClear);

			ImageIcon reSchedulePanelClear = new ImageIcon("Images\\menuCitas\\reagendarCita.png");
			vf.getSchedule().getBackground3().setIcon(reSchedulePanelClear);

			ImageIcon cancelPanelClear = new ImageIcon("Images\\menuCitas\\cancelarCita.png");
			vf.getSchedule().getBackground4().setIcon(cancelPanelClear);

			darkMode = false;

		} else {

			// Home

			ImageIcon homeDark = new ImageIcon("Images\\menuInicial\\MenuOscuro.png");
			vf.getHome().getBackground1().setIcon(homeDark);

			ImageIcon scheduleDark = new ImageIcon("Images\\menuInicial\\agendarOscuro.png");
			vf.getHome().getSchedule().setIcon(scheduleDark);

			ImageIcon themeDark = new ImageIcon("Images\\CambioTema\\cambioClaro.png");
			vf.getHome().getTheme().setIcon(themeDark);

			ImageIcon homeTreatmentDark = new ImageIcon("Images\\menuInicial\\tratamientoOscuro.png");
			vf.getHome().getTreatment().setIcon(homeTreatmentDark);

			ImageIcon homeReportDark = new ImageIcon("Images\\menuInicial\\reporteOscuro.png");
			vf.getHome().getReport().setIcon(homeReportDark);

			ImageIcon homeTurnDark = new ImageIcon("Images\\menuInicial\\turnoOscuro.png");
			vf.getHome().getTurn().setIcon(homeTurnDark);

			ImageIcon exitOS = new ImageIcon("Images\\backButtons\\salirProgramaO.png");
			vf.getHome().getExit().setIcon(exitOS);

			// Agendar

			ImageIcon scheduleHomeDark = new ImageIcon("Images\\menuCitas\\menuAgendarOscuro.png");
			vf.getSchedule().getBackground1().setIcon(scheduleHomeDark);

			ImageIcon scheduleD = new ImageIcon("Images\\menuCitas\\2.png");
			vf.getSchedule().getScheduleButton().setIcon(scheduleD);

			ImageIcon reScheduleD = new ImageIcon("Images\\menuCitas\\4.png");
			vf.getSchedule().getRescheduleButton().setIcon(reScheduleD);

			ImageIcon cancelScheduleD = new ImageIcon("Images\\menuCitas\\6.png");
			vf.getSchedule().getCancelButton().setIcon(cancelScheduleD);

			vf.getSchedule().getThemeMain().setIcon(themeDark);

			vf.getSchedule().getInfoPanel().setBackground(Color.BLACK);

			ImageIcon homeBDark = new ImageIcon("Images\\backButtons\\2.png");
			vf.getSchedule().getHome().setIcon(homeBDark);

			ImageIcon schedulePanelDark = new ImageIcon("Images\\menuCitas\\agendarOscuro.png");
			vf.getSchedule().getBackground2().setIcon(schedulePanelDark);

			ImageIcon reSchedulePanelDark = new ImageIcon("Images\\menuCitas\\reagendarOscuro.png");
			vf.getSchedule().getBackground3().setIcon(reSchedulePanelDark);

			ImageIcon cancelPanelDark = new ImageIcon("Images\\menuCitas\\cancelarOscuro.png");
			vf.getSchedule().getBackground4().setIcon(cancelPanelDark);

			darkMode = true;
		}
	}

	public void showScheduleInfo() {
		if (vf.getSchedule().getSchedulePanel().isVisible()) {
			vf.getSchedule().getInfoDate().setVisible(true);
			vf.getSchedule().getInfoDoctor().setVisible(true);
			vf.getSchedule().getInfoEmail().setVisible(true);
			vf.getSchedule().getInfoName().setVisible(true);
			vf.getSchedule().getInfospecialty().setVisible(true);
		} else if (vf.getSchedule().getSchedulePanel().isVisible() == false) {
			vf.getSchedule().getInfoDate().setVisible(false);
			vf.getSchedule().getInfoDoctor().setVisible(false);
			vf.getSchedule().getInfoEmail().setVisible(false);
			vf.getSchedule().getInfoName().setVisible(false);
			vf.getSchedule().getInfospecialty().setVisible(false);
		}
		if (vf.getSchedule().getReschedulePanel().isVisible()) {
			vf.getSchedule().getInfoNDate().setVisible(true);
			vf.getSchedule().getInfoNum().setVisible(true);
		} else if (vf.getSchedule().getReschedulePanel().isVisible() == false) {
			vf.getSchedule().getInfoNDate().setVisible(false);
			vf.getSchedule().getInfoNum().setVisible(false);
		}
		if (vf.getSchedule().getCancelPanel().isVisible() == true) {
			vf.getSchedule().getInfoNumCancel().setVisible(true);
		} else if (vf.getSchedule().getCancelPanel().isVisible() == false) {
			vf.getSchedule().getInfoNumCancel().setVisible(false);

		}
	}

	public void infoTreatment() {
		/*
		 * if (vf.getTreatments().getMainPanel().isVisible()) {
		 * vf.getTreatments().getSearchButton().setVisible(false);
		 * vf.getTreatments().getInfoTreatment().setVisible(false);
		 * vf.getTreatments().getInfospecialty().setVisible(false);
		 * vf.getTreatments().getInfoName().setVisible(false);
		 * vf.getTreatments().getInfoStatus().setVisible(false);
		 * 
		 * }
		 */

		if (checkWindow == 1) {// Principal

			vf.getTreatments().getInfoPanel().setBounds(614, 170, 40, 210);

			vf.getTreatments().getInfoName().setVisible(true);
			vf.getTreatments().getInfoName().setBounds(0, 32, 34, 34);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 113, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 155, 34, 34);

			vf.getTreatments().getInfospecialty().setVisible(true);
			vf.getTreatments().getInfospecialty().setBounds(0, 74, 34, 34);

			// vf.getTreatments().getInfoSearchName().setVisible(false);
		} else if (checkWindow == 2) {// Buscar
			vf.getTreatments().getInfoPanel().setBounds(614, 170, 130, 210);

			vf.getTreatments().getSearchButton().setVisible(true);
			vf.getTreatments().getSearchButton().setBounds(0, 30, 100, 35);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 113, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 155, 34, 34);

			vf.getTreatments().getInfospecialty().setVisible(true);
			vf.getTreatments().getInfospecialty().setBounds(0, 74, 34, 34);

			// vf.getTreatments().getInfoName().setVisible(false);

		} else if (checkWindow == 3) {// Finish
			vf.getTreatments().getInfoPanel().setBounds(614, 170, 130, 210);

			vf.getTreatments().getSearchButton().setBounds(0, 53, 100, 35);
			vf.getTreatments().getSearchButton().setVisible(true);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 93, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 135, 34, 34);
		} else if (checkWindow == 0) {
			vf.getTreatments().getSearchButton().setVisible(false);
			vf.getTreatments().getInfoTreatment().setVisible(false);
			vf.getTreatments().getInfospecialty().setVisible(false);
			vf.getTreatments().getInfoName().setVisible(false);
			vf.getTreatments().getInfoStatus().setVisible(false);

		}

	}

	public int appoitment() {
		int num = 0;
		main: while (true) {
			boolean frist = false;
			num = random();

			ArrayList<PatientDTO> in;
			in = new ArrayList<>();
			in = mf.getPatient().getAll();
			second: for (int i = 0; i < in.size(); i++) {

				if (in.isEmpty()) {
					break main;
				} else {

					if (in.get(i).getAppointmentNum() == num) {
						frist = true;
						break second;
					} else {
						continue second;
					}

				}

			}

			if (frist == true) {
				continue main;
			} else {
				break main;
			}
		}

		return num;
	}

	public int random() {
		return (int) (Math.random() * 10000 + 100);
	}

}
