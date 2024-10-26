package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private ViewFacade vf;
	private PatientDTO pa;
	boolean darkMode = false;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		pa = new PatientDTO();

		assignReaders();
		vf.getHome().setVisible(true);

		hideInfoSchedule();

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

		vf.getTreatemnets().getThemeMain().addActionListener(this);
		vf.getTreatemnets().getThemeMain().setActionCommand("theme");

		vf.getTreatemnets().getHome().addActionListener(this);
		vf.getTreatemnets().getHome().setActionCommand("backMainMenu");
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "theme":
			changeTheme();
			break;
		case "backMainMenu":
			
			if (vf.getSchedule().isVisible()) {
				vf.getSchedule().setVisible(false);
				vf.getHome().setVisible(true);
			} else if (vf.getTreatemnets().isVisible()) {
				vf.getTreatemnets().setVisible(false);
				vf.getHome().setVisible(true);
			}else if (vf.getShifts().isVisible()) {
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
			vf.getHome().setVisible(false);
			vf.getTreatemnets().setVisible(true);
			break;
		case "scheduleMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getSchedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			hideInfoCancel();
			hideInfoReSchedule();
			showInfoSchedule();
			break;
		case "reSchedleMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getReschedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			hideInfoCancel();
			hideInfoSchedule();
			showInfoReSchedule();
			break;
		case "cancelMenu":
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getCancelPanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			hideInfoSchedule();
			hideInfoReSchedule();
			showInfoCancel();
			break;

		case "generatedPatient":

			if (vf.getSchedule().getDoctor().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getEmail().getText().toString().equals("")
					|| vf.getSchedule().getSpecialty().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getName1().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				String doctor = vf.getSchedule().getDoctor().getSelectedItem().toString();
				String specialty = vf.getSchedule().getSpecialty().getSelectedItem().toString();
				String name = vf.getSchedule().getName1().getText().toString();
				String gmail = vf.getSchedule().getEmail().getText().toString();

				Date tDate = vf.getSchedule().getDate1().getDate();
				SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
				String date = formatoFecha.format(tDate);

				int appoitment = appoitment();

				if (mf.getPatient().add(pa = new PatientDTO(name, gmail, 0, 0, doctor, specialty, date, appoitment))) {

					JOptionPane.showMessageDialog(null, "Cita de numero " + appoitment + " creado exitosamente");

					// ENVIO DE NOTIFICACION MEDIANTE CORREO GMAiL

				} else {

					JOptionPane.showMessageDialog(null, "No se pudo crear");

				}

			}

			break;

		case "reGenerated":

			if (vf.getSchedule().getAppointmentNumber().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int appoint = Integer.parseInt(vf.getSchedule().getAppointmentNumber().getText().toString());
				String date = "date";
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

	public void showInfoSchedule() {
		vf.getSchedule().getInfoDate().setVisible(true);
		vf.getSchedule().getInfoDoctor().setVisible(true);
		vf.getSchedule().getInfoEmail().setVisible(true);
		vf.getSchedule().getInfoName().setVisible(true);
		vf.getSchedule().getInfospecialty().setVisible(true);

	}

	public void showInfoReSchedule() {
		vf.getSchedule().getInfoNDate().setVisible(true);
		vf.getSchedule().getInfoNum().setVisible(true);
	}

	public void showInfoCancel() {
		vf.getSchedule().getInfoNumCancel().setVisible(true);

	}

	public void hideInfoSchedule() {
		vf.getSchedule().getInfoDate().setVisible(false);
		vf.getSchedule().getInfoDoctor().setVisible(false);
		vf.getSchedule().getInfoEmail().setVisible(false);
		vf.getSchedule().getInfoName().setVisible(false);
		vf.getSchedule().getInfospecialty().setVisible(false);
	}

	public void hideInfoReSchedule() {
		vf.getSchedule().getInfoNDate().setVisible(false);
		vf.getSchedule().getInfoNum().setVisible(false);
	}

	public void hideInfoCancel() {
		vf.getSchedule().getInfoNumCancel().setVisible(false);

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
