package co.edu.unbosque.controller;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.ReportMaxDoctorDTO;
import co.edu.unbosque.model.ReportMaxSpecialityDTO;
import co.edu.unbosque.model.ReportPatientDTO;
import co.edu.unbosque.model.ShiftsDTO;
import co.edu.unbosque.model.ShiftsReportDTO;
import co.edu.unbosque.model.AppointmentDTO;
import co.edu.unbosque.model.AppoitmentReportDTO;
import co.edu.unbosque.model.DoctorDTO;
import co.edu.unbosque.model.TreatmentDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.exceptions.AgeNotValidException;
import co.edu.unbosque.util.exceptions.DateFormatNotValidException;
import co.edu.unbosque.util.exceptions.EmailNotValidException;
import co.edu.unbosque.util.exceptions.ExceptionChecker;
import co.edu.unbosque.util.exceptions.IdentificationNotValidException;
import co.edu.unbosque.util.exceptions.NameNotValidException;
import co.edu.unbosque.util.order.NumReportDocOrder;
import co.edu.unbosque.util.order.NumReportSpecialityOrder;
import co.edu.unbosque.util.order.idDoctorOrder;
import co.edu.unbosque.util.order.nameSpecialityTurnOrder;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {
	private ModelFacade mf;
	private static ViewFacade vf;
	private static int checkWindowTreatment = 0;
	private int schedule = 0;
	private int person = 0;
	private static int sendEmail = 0;
	private boolean darkMode = false;
	private ArrayList<DoctorDTO> doctor;
	private ArrayList<TreatmentDTO> treat;
	private ArrayList<PatientDTO> patient;
	private ArrayList<AppointmentDTO> appointment;
	private ArrayList<ShiftsDTO> shift;
	private ArrayList<ReportPatientDTO> reportPat;
	private ArrayList<AppoitmentReportDTO> appointReport;
	private ArrayList<ReportMaxDoctorDTO> reportDoc;
	private ArrayList<ReportMaxSpecialityDTO> reportSpe;
	private ArrayList<ShiftsReportDTO> turnReport;
	private String FOLDER_NAME = "data";

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();

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

		vf.getHome().getCreate().addActionListener(this);
		vf.getHome().getCreate().setActionCommand("initAddPerson");
		// schedule Buttons

		vf.getSchedule().getSpecialty().addActionListener(this);
		vf.getSchedule().getSpecialty().setActionCommand("selectDoctorCreatedApp");

		vf.getSchedule().getSelectPatient().addActionListener(this);
		vf.getSchedule().getSelectPatient().setActionCommand("selectPat");

		vf.getSchedule().getScheduleButton().addActionListener(this);
		vf.getSchedule().getScheduleButton().setActionCommand("scheduleMenu");

		vf.getSchedule().getRescheduleButton().addActionListener(this);
		vf.getSchedule().getRescheduleButton().setActionCommand("reSchedleMenu");

		vf.getSchedule().getCancelButton().addActionListener(this);
		vf.getSchedule().getCancelButton().setActionCommand("cancelMenu");

		vf.getSchedule().getGenerate().addActionListener(this);
		vf.getSchedule().getGenerate().setActionCommand("generatedAppointment");

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

		vf.getTreatments().getSelectPatient().addActionListener(this);
		vf.getTreatments().getSelectPatient().setActionCommand("selectCreateTre");

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

		vf.getShowOptions().getHome().addActionListener(this);
		vf.getShowOptions().getHome().setActionCommand("sTreatmentBack");

		vf.getShowOptions().getSelectTreatment().addActionListener(this);
		vf.getShowOptions().getSelectTreatment().setActionCommand("selectTreatments");

		// Turnos

		vf.getShifts().getGenerateChange().addActionListener(this);
		vf.getShifts().getGenerateChange().setActionCommand("changeTurn");

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

		vf.getShifts().getHomeTurn2().addActionListener(this);
		vf.getShifts().getHomeTurn2().setActionCommand("homeTurn");

		vf.getShifts().getGenerateTurns().addActionListener(this);
		vf.getShifts().getGenerateTurns().setActionCommand("generateTurn");

		// popups

		vf.getShowOptions().getNewPerson().addActionListener(this);
		vf.getShowOptions().getNewPerson().setActionCommand("initNewPerson");

		vf.getShowOptions().getUpdatePerson().addActionListener(this);
		vf.getShowOptions().getUpdatePerson().setActionCommand("initUpdatePerson");

		vf.getShowOptions().getNewDoctor().addActionListener(this);
		vf.getShowOptions().getNewDoctor().setActionCommand("initNewDoctor");

		vf.getShowOptions().getUpdateDoctor().addActionListener(this);
		vf.getShowOptions().getUpdateDoctor().setActionCommand("initUpdateDoctor");

		vf.getShowOptions().getPerson().addActionListener(this);
		vf.getShowOptions().getPerson().setActionCommand("initMenuPerson");

		vf.getShowOptions().getDoctor().addActionListener(this);
		vf.getShowOptions().getDoctor().setActionCommand("initMenuDoctor");

		vf.getShowOptions().getReturnMenu().addActionListener(this);
		vf.getShowOptions().getReturnMenu().setActionCommand("backHome");

		vf.getShowOptions().getHome2().addActionListener(this);
		vf.getShowOptions().getHome2().setActionCommand("backInitPerson");

		vf.getShowOptions().getHome3().addActionListener(this);
		vf.getShowOptions().getHome3().setActionCommand("backInitDoctor");
		

		// add Person

		vf.getPersonMenu().getUpdateDoctor().addActionListener(this);
		vf.getPersonMenu().getUpdateDoctor().setActionCommand("updateDoctor");

		vf.getPersonMenu().getUpdatePerson().addActionListener(this);
		vf.getPersonMenu().getUpdatePerson().setActionCommand("updatePerson");

		vf.getPersonMenu().getHomeD().addActionListener(this);
		vf.getPersonMenu().getHomeD().setActionCommand("backHomeD");

		vf.getPersonMenu().getHomeUDoctor().addActionListener(this);
		vf.getPersonMenu().getHomeUDoctor().setActionCommand("backHomeD");

		vf.getPersonMenu().getHomeUPerson().addActionListener(this);
		vf.getPersonMenu().getHomeUPerson().setActionCommand("backHomeP");

		vf.getPersonMenu().getHomeP().addActionListener(this);
		vf.getPersonMenu().getHomeP().setActionCommand("backHomeP");

		vf.getPersonMenu().getCreatePerson().addActionListener(this);
		vf.getPersonMenu().getCreatePerson().setActionCommand("createPatient");

		vf.getPersonMenu().getCreateDoctor().addActionListener(this);
		vf.getPersonMenu().getCreateDoctor().setActionCommand("createDoctor");

		vf.getShowOptions().getMenu2().addActionListener(this);
		vf.getShowOptions().getMenu2().setActionCommand("backSelectDate");

		// Para seleccionar la fecha
		vf.getShowOptions().getSelectDate().addActionListener(this);
		vf.getShowOptions().getSelectDate().setActionCommand("selectDate");

		vf.getHome().getReport().addActionListener(this);
		vf.getHome().getReport().setActionCommand("initReports");

		// reports
		vf.getReports().getExit().addActionListener(this);
		vf.getReports().getExit().setActionCommand("backReports");

		vf.getReports().getTheme().addActionListener(this);
		vf.getReports().getTheme().setActionCommand("theme");

		vf.getReports().getReport1().addActionListener(this);
		vf.getReports().getReport1().setActionCommand("report1");

		vf.getReports().getReport2().addActionListener(this);
		vf.getReports().getReport2().setActionCommand("report2");

		vf.getReports().getReport3().addActionListener(this);
		vf.getReports().getReport3().setActionCommand("report3");

		vf.getReports().getReport4().addActionListener(this);
		vf.getReports().getReport4().setActionCommand("report4");

		vf.getReports().getReport5().addActionListener(this);
		vf.getReports().getReport5().setActionCommand("report5");

		vf.getReports().getReport6().addActionListener(this);
		vf.getReports().getReport6().setActionCommand("report6");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {

		case "report1":

			eliminarArchivos(FOLDER_NAME, "reportPatient");

			patient = new ArrayList<PatientDTO>();
			patient = mf.getPatient().getAll();

			for (PatientDTO pa : patient) {

				mf.getReportPatient().add(new ReportPatientDTO(pa.getName(), pa.getId(), pa.getEmail()));

			}

			reportPat = new ArrayList<ReportPatientDTO>();
			reportPat = mf.getReportPatient().getAll();

			if (!reportPat.isEmpty()) {

				showReports("data/reportPatient.csv");
			} else {
				JOptionPane.showMessageDialog(null, "No existen pacientes");

			}

			break;
		case "report2":

			treat = new ArrayList<>();
			treat = mf.getTreatment().getAll();

			if (!treat.isEmpty()) {

				showReports("data/treatment.csv");
			} else {
				JOptionPane.showMessageDialog(null, "No existen tratamientos");

			}

			break;
		case "report3":
			appointReport = new ArrayList<>();
			appointReport = mf.getAppointmentReport().getAll();
			if (!appointReport.isEmpty()) {

				showReports("data/appoitmentReport.csv");

			} else {
				JOptionPane.showMessageDialog(null, "No existen citas");

			}

			break;
		case "report4":

			eliminarArchivos(FOLDER_NAME, "reportMaxDoctor");

			appointment = new ArrayList<AppointmentDTO>();
			appointment = mf.getAppointment().getAll();
			doctor = new ArrayList<>();
			doctor = mf.getDoctor().getAll();

			ArrayList<String> existDoc = new ArrayList<>();

			for (AppointmentDTO app : appointment) {

				if (existDoc.contains(app.getDoctor())) {
					continue;
				} else {
					existDoc.add(app.getDoctor());
				}

				int frecuency = 0;

				for (AppointmentDTO app2 : appointment) {

					if (app2.getDoctor().equals(app.getDoctor())) {
						frecuency++;
					}

				}

				for (DoctorDTO dc : doctor) {

					String name = dc.getName();

					if (name.equals(app.getDoctor())) {
						mf.getReportMaxDoc().add(new ReportMaxDoctorDTO(frecuency, name, dc.getEmail()));
						break;
					} else {
						continue;
					}

				}

			}

			reportDoctorOrder();

			reportDoc = new ArrayList<>();
			reportDoc = mf.getReportMaxDoc().getAll();

			if (!reportDoc.isEmpty()) {

				showReports("data/reportMaxDoctor.csv");
			} else {
				JOptionPane.showMessageDialog(null, "No existen doctores con citas");

			}

			break;
		case "report5":

			eliminarArchivos(FOLDER_NAME, "reportMaxSpeciality");

			appointment = new ArrayList<AppointmentDTO>();
			appointment = mf.getAppointment().getAll();
			doctor = new ArrayList<>();
			doctor = mf.getDoctor().getAll();

			ArrayList<String> existSpe = new ArrayList<>();

			for (AppointmentDTO app : appointment) {

				if (existSpe.contains(app.getSpecialty())) {
					continue;
				} else {
					existSpe.add(app.getSpecialty());
				}

				int frecuency = 0;

				for (AppointmentDTO app2 : appointment) {

					if (app2.getSpecialty().equals(app.getSpecialty())) {
						frecuency++;
					}

				}

				for (DoctorDTO dc : doctor) {

					String spec = dc.getSpecialty();

					if (spec.equals(app.getSpecialty())) {
						mf.getReportMaxSpe().add(new ReportMaxSpecialityDTO(frecuency, spec));
						break;
					} else {
						continue;
					}

				}

			}

			reportSpeOrder();

			reportSpe = new ArrayList<>();
			reportSpe = mf.getReportMaxSpe().getAll();

			if (!reportSpe.isEmpty()) {

				showReports("data/reportMaxSpeciality.csv");
			} else {
				JOptionPane.showMessageDialog(null, "No existen especialidades con citas");

			}

			break;
		case "report6":

			turnReport = new ArrayList<>();
			turnReport = mf.getShiftReport().getAll();

			if (!turnReport.isEmpty()) {

				showReports("data/shiftsReport.csv");

			} else {
				JOptionPane.showMessageDialog(null, "No existe historial de turnos");
			}

			break;
		case "backReports":
			vf.getReports().setVisible(false);
			vf.getHome().setVisible(true);
			break;
		case "initReports":
			vf.getHome().setVisible(false);
			vf.getReports().setVisible(true);

			// setInactive();
			// showReports("dataa/appointment.csv");
			break;
		case "initNewDoctor":
			vf.getShowOptions().setVisible(false);
			vf.getPersonMenu().getDoctorPanel().setVisible(true);
			vf.getPersonMenu().setVisible(true);
			break;
		case "initUpdateDoctor":
			vf.getShowOptions().setVisible(false);
			vf.getPersonMenu().getDoctorUpdatePanel().setVisible(true);
			vf.getPersonMenu().setVisible(true);
			break;

		case "updateDoctor":

			if (vf.getPersonMenu().getDoctorUpdateId().getText().toString().equals("")
					|| vf.getPersonMenu().getDoctorUpdateName().getText().toString().equals("")
					|| vf.getPersonMenu().getEmailUpdateDoctor().getText().toString().equals("")
					|| vf.getPersonMenu().getSpecialityUpdate().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				updateDoctor();

			}

			break;

		case "updatePerson":

			if (vf.getPersonMenu().getPatientUpdateId().getText().toString().equals("")
					|| vf.getPersonMenu().getPatientUpdateName().getText().toString().equals("")
					|| vf.getPersonMenu().getPatientUpdateAge().getText().toString().equals("")
					|| vf.getPersonMenu().getEmailUpdatePatient().getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				updatePerson();

			}

			break;
		case "theme":
			showScheduleInfo();
			infoTreatment();
			changeTheme();
			break;
		case "backInitPerson":
			vf.getShowOptions().getNewPersonPanel().setVisible(true);
			vf.getShowOptions().getPersonPanel().setVisible(false);
			break;
		case"backInitDoctor":
			vf.getShowOptions().getNewPersonPanel().setVisible(true);
			vf.getShowOptions().getDoctorPanel().setVisible(false);
			break;
		case "initUpdatePerson":
			person = 2;
			vf.getShowOptions().setVisible(false);
			vf.getShowOptions().getPersonPanel().setVisible(false);
			vf.getPersonMenu().getPersonUpdatePanel().setVisible(true);
			vf.getPersonMenu().setVisible(true);
			break;
		case "initNewPerson":
			person = 1;
			vf.getShowOptions().setVisible(false);
			vf.getShowOptions().getPersonPanel().setVisible(false);
			vf.getPersonMenu().getPersonPanel().setVisible(true);
			vf.getPersonMenu().setVisible(true);
			break;
		case "selectDate":
			if (schedule == 2) {
				showScheduleInfo();

				if (vf.getShowOptions().getFechasDeReagendarCita().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					String date = vf.getShowOptions().getFechasDeReagendarCita().getSelectedItem().toString();

					appointment = new ArrayList<>();
					appointment = mf.getAppointment().getAll();

					for (int i = 0; i < appointment.size(); i++) {

						String tDate = appointment.get(i).getDate();
						if (date.equals(tDate)) {

							vf.getSchedule().getAppointmentNumbers()
									.setText(String.valueOf(appointment.get(i).getAppointmentNum()));
							vf.getShowOptions().setVisible(false);
							vf.getShowOptions().getDatePanel().setVisible(false);
							vf.getSchedule().getReSchedulePanel().setVisible(true);
							vf.getShowOptions().getDatePanel().setVisible(false);
							vf.getSchedule().setVisible(true);
						}

					}

				}

			} else if (schedule == 3) {
				showScheduleInfo();

				// para llenar la info de cancelar
				if (vf.getShowOptions().getFechasDeReagendarCita().getSelectedItem().toString().equals("")) {

					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					String date = vf.getShowOptions().getFechasDeReagendarCita().getSelectedItem().toString();

					appointment = new ArrayList<>();
					appointment = mf.getAppointment().getAll();

					for (int i = 0; i < appointment.size(); i++) {

						String tDate = appointment.get(i).getDate();
						if (date.equals(tDate)) {

							vf.getSchedule().getAppointmentNumber()
									.setText(String.valueOf(appointment.get(i).getAppointmentNum()));
							vf.getShowOptions().setVisible(false);
							vf.getShowOptions().getDatePanel().setVisible(false);
							vf.getSchedule().getCancelPanel().setVisible(true);
							vf.getShowOptions().getDatePanel().setVisible(false);
							vf.getSchedule().setVisible(true);
						}

					}

				}

			}

			break;
		case "backSelectDate":
			if (schedule == 2) {
				vf.getShowOptions().setVisible(false);
				vf.getSchedule().getReSchedulePanel().setVisible(true);
				vf.getSchedule().setVisible(true);
				showScheduleInfo();
			} else if (schedule == 3) {
				vf.getShowOptions().setVisible(false);
				vf.getSchedule().getCancelPanel().setVisible(true);
				vf.getSchedule().setVisible(true);
				showScheduleInfo();
			}
			break;

		case "changeTurn":

			if (vf.getShifts().getId1().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				changeTurn();

			}

			break;

		case "generateTurn":

			if (vf.getShifts().getStartDate().getDate() == null) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				generTurn();
			}

			break;
		case "backHomeP":
			if (person == 1) {

				vf.getPersonMenu().setVisible(false);
				vf.getPersonMenu().getPersonPanel().setVisible(false);
				vf.getShowOptions().getNewPersonPanel().setVisible(true);
				vf.getShowOptions().setVisible(true);

			} else if (person == 2) {
				vf.getPersonMenu().setVisible(false);
				vf.getPersonMenu().getPersonUpdatePanel().setVisible(false);
				vf.getShowOptions().getNewPersonPanel().setVisible(true);
				vf.getShowOptions().setVisible(true);
			}

			break;
		case "backHomeD":
			vf.getShowOptions().getDoctorPanel().setVisible(false);

			if (vf.getPersonMenu().getDoctorPanel().isVisible() == true) {

				vf.getPersonMenu().setVisible(false);

				vf.getPersonMenu().getDoctorPanel().setVisible(false);

				vf.getShowOptions().getNewPersonPanel().setVisible(true);

				vf.getShowOptions().setVisible(true);

			} else if (vf.getPersonMenu().getDoctorUpdatePanel().isVisible() == true) {

				vf.getPersonMenu().setVisible(false);

				vf.getPersonMenu().getDoctorUpdatePanel().setVisible(false);

				vf.getShowOptions().getDoctorPanel().setVisible(false);

				vf.getShowOptions().getNewPersonPanel().setVisible(true);

				vf.getShowOptions().setVisible(true);
			}

			break;
		case "backHome":
			vf.getShowOptions().setVisible(false);
			vf.getShowOptions().getNewPersonPanel().setVisible(false);
			vf.getHome().setVisible(true);
			break;
		case "initMenuDoctor":

			vf.getShowOptions().getNewPersonPanel().setVisible(false);
			vf.getShowOptions().getDoctorPanel().setVisible(true);

			break;
		case "initMenuPerson":

			vf.getShowOptions().getNewPersonPanel().setVisible(false);
			vf.getShowOptions().getPersonPanel().setVisible(true);
			vf.getShowOptions().getNewPerson().setVisible(true);

			break;
		case "initAddPerson":
			vf.getHome().setVisible(false);
			vf.getShowOptions().setVisible(true);
			vf.getShowOptions().getNewPersonPanel().setVisible(true);
			vf.getShowOptions().getDoctorPanel().setVisible(false);
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

			checkWindowTreatment = 0;
			if (vf.getTreatments().getNewTreatmentPanel().isVisible()) {

				vf.getTreatments().getId1().setText(null);
				vf.getTreatments().getName1().setText(null);
				vf.getTreatments().getSpecialty().setSelectedItem("");
				vf.getTreatments().getTreatmentTxt().setText(null);
				vf.getTreatments().getStatus().setSelectedIndex(0);
				vf.getTreatments().getNewTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();

			} else if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {

				vf.getTreatments().getId2().setText(null);
				vf.getTreatments().getSearchTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();

			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				vf.getTreatments().getId3().setText(null);
				vf.getTreatments().getFinishTreatmentPanel().setVisible(false);
				vf.getTreatments().getMainPanel().setVisible(true);
				infoTreatment();
			}

			break;
		case "sTreatmentBack":

			if (checkWindowTreatment == 2) {

				vf.getShowOptions().setVisible(false);
				vf.getShowOptions().getMainPanel().setVisible(false);
				vf.getTreatments().getFinishTreatmentPanel().setVisible(false);
				vf.getTreatments().getSearchTreatmentPanel().setVisible(true);
				vf.getTreatments().setVisible(true);
				// infoTreatment();

			} else if (checkWindowTreatment == 3) {

				vf.getShowOptions().setVisible(false);
				vf.getShowOptions().getMainPanel().setVisible(false);
				vf.getTreatments().getSearchTreatmentPanel().setVisible(false);
				vf.getTreatments().getFinishTreatmentPanel().setVisible(true);
				vf.getTreatments().setVisible(true);

				// infoTreatment();
			}
			break;
		case "initTreatment":
			checkWindowTreatment = 1;
			infoTreatment();
			vf.getTreatments().getMainPanel().setVisible(false);
			vf.getTreatments().getNewTreatmentPanel().setVisible(true);

			infoTreatment();
			break;
		case "searchTreatment":
			checkWindowTreatment = 2;
			infoTreatment();

			vf.getTreatments().getStatus2().setSelectedItem(null);
			vf.getTreatments().getTreatmentS().setText(null);
			vf.getTreatments().getSpecialty2().setSelectedItem(null);
			vf.getTreatments().getNameS().setText(null);
			vf.getTreatments().getNameS().setEnabled(false);
			vf.getTreatments().getTreatmentS().setEnabled(false);

			vf.getTreatments().getStatus2().enable(false);
			vf.getTreatments().getSpecialty2().enable(false);

			vf.getTreatments().getMainPanel().setVisible(false);
			vf.getTreatments().getSearchTreatmentPanel().setVisible(true);

			infoTreatment();
			break;
		case "finishTreatment":
			checkWindowTreatment = 3;
			infoTreatment();

			vf.getTreatments().getStatus3().setSelectedItem(null);
			vf.getTreatments().getTreatmentF().setText(null);
			vf.getTreatments().getId3().setText(null);

			vf.getTreatments().getTreatmentF().setEnabled(false);
			vf.getTreatments().getStatus3().enable(false);

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
			vf.getSchedule().getReSchedulePanel().setVisible(false);
			vf.getSchedule().getSchedulePanel().setVisible(false);
			vf.getSchedule().getCancelPanel().setVisible(false);
			vf.getSchedule().getInfoPanel().setVisible(false);
			break;
		case "homeSchedule":
			vf.getHome().setVisible(false);
			vf.getSchedule().setVisible(true);
			break;
		case "homeTreatment":
			checkWindowTreatment = 0;
			vf.getTreatments().getTreatmentS().setText(null);
			vf.getTreatments().getSpecialty2().setSelectedItem(null);
			vf.getTreatments().getStatus2().setSelectedItem(null);
			vf.getTreatments().getNameS().setText(null);
			vf.getHome().setVisible(false);
			vf.getTreatments().setVisible(true);
			break;
		case "scheduleMenu":
			schedule = 1;
			sendEmail = 1;
			vf.getSchedule().getName1().setEditable(false);
			vf.getSchedule().getEmail().setEditable(false);
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getSchedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;
		case "reSchedleMenu":
			schedule = 2;
			sendEmail = 2;
			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getReSchedulePanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;
		case "cancelMenu":
			schedule = 3;
			sendEmail = 3;

			vf.getSchedule().getMainPanel().setVisible(false);
			vf.getSchedule().getCancelPanel().setVisible(true);
			vf.getSchedule().getInfoPanel().setVisible(true);

			showScheduleInfo();

			break;

		case "finishTre":
			infoTreatment();
			if (vf.getTreatments().getId3().getText().equals("")
					|| vf.getTreatments().getTreatmentF().getText().equals("")
					|| vf.getTreatments().getStatus3().getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				finishTre();

			}

			break;

		case "selectTreatments":
			infoTreatment();
			if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {

				if (vf.getShowOptions().getTreatment().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
					vf.getShowOptions().getMainPanel().setVisible(true);
				} else {

					String item = vf.getShowOptions().getTreatment().getSelectedItem().toString();

					treat = new ArrayList<>();
					treat = mf.getTreatment().getAll();

					for (int it = 0; it < treat.size(); it++) {

						String item2 = treat.get(it).getTreatment();

						if (item.equals(item2)) {

							String speciality = treat.get(it).getSpecialty();
							String status = treat.get(it).getVerified();

							vf.getTreatments().getSpecialty2().setSelectedItem(speciality);
							vf.getTreatments().getTreatmentS().setText(item);
							vf.getTreatments().getStatus2().setSelectedItem(status);

							vf.getTreatments().getSpecialty2().enable(true);
							vf.getTreatments().getTreatmentS().enable(true);
							vf.getTreatments().getStatus2().enable(false);

							vf.getShowOptions().setVisible(false);
							vf.getTreatments().setVisible(true);

							vf.getTreatments().getSpecialty2().setVisible(true);
							vf.getTreatments().getTreatmentS().setEditable(true);
							vf.getTreatments().getTreatmentS().setVisible(true);
							// vf.getTreatments().getStatus2().enable(false);

							break;
						} else {
							continue;
						}

					}

				}
			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				if (vf.getShowOptions().getTreatment().getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					String item = vf.getShowOptions().getTreatment().getSelectedItem().toString();

					treat = new ArrayList<>();
					treat = mf.getTreatment().getAll();

					for (int it = 0; it < treat.size(); it++) {

						String item2 = treat.get(it).getTreatment();

						if (item.equals(item2)) {

							String status = treat.get(it).getVerified();

							vf.getTreatments().getTreatmentF().setText(item);
							vf.getTreatments().getStatus3().setSelectedItem(status);

							vf.getShowOptions().setVisible(false);
							vf.getTreatments().setVisible(true);

							vf.getTreatments().getTreatmentF().setEditable(true);
							vf.getTreatments().getTreatmentF().setVisible(true);
							vf.getTreatments().getStatus3().enable(false);
							break;
						} else {
							continue;
						}

					}

				}

			}

			break;

		case "search":

			infoTreatment();
			if (vf.getTreatments().getSearchTreatmentPanel().isVisible()) {
				if (vf.getTreatments().getId2().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean en = false;
					String id2 = vf.getTreatments().getId2().getText().toString();

					boolean checkId = idCheckException(id2);

					if (checkId) {
						vf.getTreatments().getId2().setText(null);
						JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

					} else {

						int id = Integer.parseInt(id2);

						appointment = new ArrayList<>();
						appointment = mf.getAppointment().getAll();

						for (int p = 0; p < appointment.size(); p++) {

							int tId = appointment.get(p).getId();
							if (id == tId) {
								patient = new ArrayList<>();
								patient = mf.getPatient().getAll();

								for (int pa = 0; pa < patient.size(); pa++) {

									int tIds = patient.get(pa).getId();

									if (tIds == id) {

										vf.getTreatments().getNameS().setText(patient.get(pa).getName());
										en = true;
									} else {
										continue;
									}

								}
							} else {
								continue;
							}

						}

						if (en) {

							String name = vf.getTreatments().getNameS().getText().toString();

							treat = new ArrayList<>();
							treat = mf.getTreatment().getAll();

							for (int i = 0; i < treat.size(); i++) {
								String tName = treat.get(i).getName();

								if (name.equals(tName)) {

									ArrayList<String> nameToSearch = new ArrayList<>();
									for (TreatmentDTO t : treat) {
										nameToSearch.add(t.getName());
									}

									int frecuency = Collections.frequency(nameToSearch, name);

									if (frecuency == 1) {

										String treatment = treat.get(i).getTreatment();
										String speciality = treat.get(i).getSpecialty();
										String status = treat.get(i).getVerified();

										vf.getTreatments().getSpecialty2().setSelectedItem(speciality);
										vf.getTreatments().getTreatmentS().setText(treatment);
										vf.getTreatments().getStatus2().setSelectedItem(status);

										vf.getTreatments().getSpecialty2().setVisible(true);
										vf.getTreatments().getTreatmentS().setVisible(true);
										vf.getTreatments().getSpecialty2().setEditable(true);
										vf.getTreatments().getTreatmentS().setEditable(true);
										vf.getTreatments().getStatus2().enable(false);

									} else {

										vf.getShowOptions().setVisible(true);
										vf.getShowOptions().getMainPanel().setVisible(true);
										vf.getTreatments().setVisible(false);

										String content = "";
										for (int n = 0; n < treat.size(); n++) {

											String na = treat.get(n).getName().toString();

											if (na.equals(name)) {

												content += treat.get(n).getTreatment() + ",";

											} else {
												continue;
											}

										}

										String[] con = content.split(",");
										vf.getShowOptions().getTreatment().removeAllItems();
										vf.getShowOptions().getTreatment().addItem("");
										for (int t = 0; t < con.length; t++) {

											vf.getShowOptions().getTreatment().addItem(con[t]);

										}

									}

									break;

								} else {
									continue;
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "No existe la cedula");
							vf.getTreatments().getId2().setText(null);
						}
					}
				}
			} else if (vf.getTreatments().getFinishTreatmentPanel().isVisible()) {

				if (vf.getTreatments().getId3().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					boolean en = false;
					String id2 = vf.getTreatments().getId3().getText().toString();

					boolean checkId = idCheckException(id2);

					if (checkId) {
						vf.getTreatments().getId3().setText(null);
						JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

					} else {
						int id = Integer.parseInt(id2);
						appointment = new ArrayList<>();
						appointment = mf.getAppointment().getAll();

						for (int p = 0; p < appointment.size(); p++) {

							int tId = appointment.get(p).getId();
							if (id == tId) {
								en = true;
							} else {
								continue;
							}

						}

						if (en) {
							String name = null;

							patient = new ArrayList<>();
							patient = mf.getPatient().getAll();

							for (int pa = 0; pa < patient.size(); pa++) {

								int tIds = patient.get(pa).getId();

								if (tIds == id) {

									name = patient.get(pa).getName();

								} else {
									continue;
								}

							}

							treat = new ArrayList<>();
							treat = mf.getTreatment().getAll();

							for (int i = 0; i < treat.size(); i++) {
								String tName = treat.get(i).getName();

								if (name.equals(tName)) {

									ArrayList<String> nameToSearch = new ArrayList<>();
									for (TreatmentDTO t : treat) {
										nameToSearch.add(t.getName());
									}

									int frecuency = Collections.frequency(nameToSearch, name);

									if (frecuency == 1) {
										String treatment = treat.get(i).getTreatment();
										String status = treat.get(i).getVerified();

										vf.getTreatments().getTreatmentF().setText(treatment);
										vf.getTreatments().getStatus3().setSelectedItem(status);

										vf.getTreatments().getTreatmentF().setVisible(true);
										vf.getTreatments().getStatus3().setVisible(true);

										break;
									} else {

										vf.getShowOptions().setVisible(true);
										vf.getShowOptions().getMainPanel().setVisible(true);
										vf.getTreatments().setVisible(false);

										String content = "";
										for (int n = 0; n < treat.size(); n++) {

											String na = treat.get(n).getName().toString();

											if (na.equals(name)) {

												content += treat.get(n).getTreatment() + ",";

											} else {
												continue;
											}

										}

										String[] con = content.split(",");
										vf.getShowOptions().getTreatment().removeAllItems();
										vf.getShowOptions().getTreatment().addItem("");
										for (int t = 0; t < con.length; t++) {

											vf.getShowOptions().getTreatment().addItem(con[t]);

										}

										break;
									}

								} else {
									continue;
								}
							}

						} else {
							JOptionPane.showMessageDialog(null, "No existe la cedula");
							vf.getTreatments().getId3().setText(null);
						}
					}
				}
			}
			break;

		case "selectDoctorCreatedApp":

			vf.getSchedule().getDoctor().removeAllItems();
			vf.getSchedule().getDoctor().addItem("");

			String item = vf.getSchedule().getSpecialty().getSelectedItem().toString();

			if (item.equals("Cirugia")) {

				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("Cirugia")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}
						}

					} else {
						continue;
					}

				}

			} else if (item.equals("Oncologia")) {

				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("Oncologia")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}

						}

					} else {
						continue;
					}

				}

			} else if (item.equals("Dermatologia")) {

				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("Dermatologia")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}

						}

					} else {
						continue;
					}

				}

			} else if (item.equals("Neumologia")) {

				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("Neumologia")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}

						}

					} else {
						continue;
					}

				}

			} else if (item.equals("Cardiologia")) {

				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("Cardiologia")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}

						}

					} else {
						continue;
					}

				}

			} else if (item.equals("MedicinaInterna")) {
				shift = new ArrayList<>();
				shift = mf.getShift().getAll();

				for (int i = 0; i < shift.size(); i++) {

					String speciality = shift.get(i).getSpecialty();

					if (item.equals(speciality)) {

						for (ShiftsDTO sh : shift) {

							if (sh.getSpecialty().equals("MedicinaInterna")) {

								boolean exists = false;
								for (int j = 0; j < vf.getSchedule().getDoctor().getItemCount(); j++) {
									if (vf.getSchedule().getDoctor().getItemAt(j).equals(sh.getName())) {
										exists = true;
										break;
									}
								}

								if (!exists) {
									vf.getSchedule().getDoctor().addItem(sh.getName());
								}

							}

						}

					} else {
						continue;
					}

				}

			}

			break;

		case "updateTre":
			infoTreatment();
			if (vf.getTreatments().getId2().getText().toString().equals("")
					|| vf.getTreatments().getNameS().getText().toString().equals("")
					|| vf.getTreatments().getSpecialty2().getSelectedItem().toString().equals("")
					|| vf.getTreatments().getTreatmentS().getText().toString().equals("")
					|| vf.getTreatments().getStatus2().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				updateTre();

			}

			break;

		case "selectCreateTre":
			infoTreatment();
			boolean enter = true;
			appointment = new ArrayList<>();
			appointment = mf.getAppointment().getAll();
			String id5 = vf.getTreatments().getId1().getText().toString();

			boolean checkId = idCheckException(id5);

			if (checkId) {
				vf.getTreatments().getId1().setText(null);
				JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

			} else {

				int id3 = Integer.parseInt(id5);

				for (int a = 0; a < appointment.size(); a++) {
					int tId = appointment.get(a).getId();

					if (id3 == tId) {
						enter = false;
						patient = new ArrayList<>();
						patient = mf.getPatient().getAll();

						for (int pa = 0; pa < patient.size(); pa++) {

							int tIds = patient.get(pa).getId();

							if (tIds == id3) {

								vf.getTreatments().getName1().setText(patient.get(pa).getName());
								vf.getTreatments().getStatus().setSelectedIndex(1);

							}

						}

					} else {
						continue;
					}
				}
			}

			if (enter) {
				vf.getTreatments().getId1().setText(null);
				JOptionPane.showMessageDialog(null, "El paciente no existe");

			}
			break;

		case "registerTre":
			if (vf.getTreatments().getName1().getText().toString().equals("")
					|| vf.getTreatments().getSpecialty().getSelectedItem().toString().equals("")
					|| vf.getTreatments().getTreatmentTxt().getText().toString().equals("")
					|| vf.getTreatments().getStatus().getSelectedItem().toString().equals("")
					|| vf.getTreatments().getId1().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				registerTre();
				infoTreatment();

			}
			break;

		case "selectPat":
			vf.getShowOptions().getDoctorPanel().setVisible(false);
			vf.getShowOptions().getIdPanel().setVisible(false);
			vf.getShowOptions().getMainPanel().setVisible(false);

			if (vf.getSchedule().getSchedulePanel().isVisible()) {

				if (vf.getSchedule().getId().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {

					boolean enter3 = true;
					String id10 = vf.getSchedule().getId().getText().toString();

					boolean checkTId = idCheckException(id10);

					if (checkTId) {
						vf.getSchedule().getId().setText(null);
						JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

					} else {

						int id2 = Integer.parseInt(id10);

						patient = new ArrayList<>();
						patient = mf.getPatient().getAll();

						for (int i = 0; i < patient.size(); i++) {
							int oldI = patient.get(i).getId();

							if (oldI == id2) {

								vf.getSchedule().getName1().setText(patient.get(i).getName());
								vf.getSchedule().getEmail().setText(patient.get(i).getEmail());
								enter3 = false;
								JOptionPane.showMessageDialog(null,
										"Verifica que el nombre y el correo sean correctos, si no actualizalos");

								break;
							} else {
								continue;
							}

						}
						if (enter3) {
							JOptionPane.showMessageDialog(null, "El paciente no existe");
							vf.getSchedule().getId().setText(null);
						}
					}
				}
			} else if (vf.getSchedule().getReSchedulePanel().isVisible()) {

				if (vf.getSchedule().getId2().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean enter1 = true;
					String id20 = vf.getSchedule().getId2().getText().toString();

					boolean checkTId = idCheckException(id20);

					if (checkTId) {
						vf.getSchedule().getId2().setText(null);
						JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");
					} else {
						int id = Integer.parseInt(id20);
						appointment = new ArrayList<>();
						appointment = mf.getAppointment().getAll();

						for (int i = 0; i < appointment.size(); i++) {
							int tID = appointment.get(i).getId();

							if (tID == id) {

								ArrayList<Integer> ids = new ArrayList<>();
								for (AppointmentDTO ap : appointment) {
									ids.add(ap.getId());
								}

								int frecuency = Collections.frequency(ids, id);

								if (frecuency == 1) {

									vf.getSchedule().getAppointmentNumbers()
											.setText(String.valueOf(appointment.get(i).getAppointmentNum()));

									JOptionPane.showMessageDialog(null,
											"La fecha de la cita es " + appointment.get(i).getDate());
									enter1 = false;
								} else {

									String content = "";
									for (int n = 0; n < appointment.size(); n++) {

										int tIds = appointment.get(n).getId();

										if (tIds == id) {

											content += appointment.get(n).getDate() + ",";

										} else {
											continue;
										}

									}

									String[] con = content.split(",");
									vf.getShowOptions().getFechasDeReagendarCita().removeAllItems();
									vf.getShowOptions().getFechasDeReagendarCita().addItem("");
									for (int t = 0; t < con.length; t++) {

										vf.getShowOptions().getFechasDeReagendarCita().addItem(con[t]);

									}
									vf.getSchedule().setVisible(false);
									vf.getShowOptions().getDatePanel().setVisible(true);
									vf.getShowOptions().setVisible(true);
									enter1 = false;

								}

								break;

							} else {
								continue;
							}
						}
						if (enter1) {
							JOptionPane.showMessageDialog(null, "No existe cita con la cedula digitada ");
							vf.getSchedule().getId2().setText(null);
						}
					}
				}

			} else if (vf.getSchedule().getCancelPanel().isVisible()) {

				if (vf.getSchedule().getId3().getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					boolean enter1 = true;
					String id30 = vf.getSchedule().getId3().getText().toString();

					boolean checkTId = idCheckException(id30);

					if (checkTId) {
						vf.getSchedule().getId3().setText(null);
						JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");
					} else {

						int id = Integer.parseInt(id30);

						appointment = new ArrayList<>();
						appointment = mf.getAppointment().getAll();

						for (int i = 0; i < appointment.size(); i++) {
							int tID = appointment.get(i).getId();

							if (tID == id) {

								ArrayList<Integer> ids = new ArrayList<>();
								for (AppointmentDTO ap : appointment) {
									ids.add(ap.getId());
								}

								int frecuency = Collections.frequency(ids, id);

								if (frecuency == 1) {

									vf.getSchedule().getAppointmentNumber()
											.setText(String.valueOf(appointment.get(i).getAppointmentNum()));

									JOptionPane.showMessageDialog(null,
											"La fecha de la cita es " + appointment.get(i).getDate());
									enter1 = false;
								} else {

									String content = "";
									for (int n = 0; n < appointment.size(); n++) {

										int tIds = appointment.get(n).getId();

										if (tIds == id) {

											content += appointment.get(n).getDate() + ",";

										} else {
											continue;
										}

									}

									String[] con = content.split(",");
									vf.getShowOptions().getFechasDeReagendarCita().removeAllItems();
									vf.getShowOptions().getFechasDeReagendarCita().addItem("");
									for (int t = 0; t < con.length; t++) {

										vf.getShowOptions().getFechasDeReagendarCita().addItem(con[t]);

									}
									vf.getSchedule().setVisible(false);
									vf.getShowOptions().getDatePanel().setVisible(true);
									vf.getShowOptions().setVisible(true);
									enter1 = false;
								}

								break;

							} else {
								continue;
							}
						}
						if (enter1) {
							JOptionPane.showMessageDialog(null, "No existe cita con la cedula digitada ");
							vf.getSchedule().getId3().setText(null);
						}
					}
				}
			}
			break;

		case "createPatient":

			if (vf.getPersonMenu().getPatientId().getText().toString().equals("")
					|| vf.getPersonMenu().getPatientName().getText().toString().equals("")
					|| vf.getPersonMenu().getPatientAge().getText().toString().equals("")
					|| vf.getPersonMenu().getEmailPatient().getText().toString().equals("")) {

				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				createPatient();

			}

			break;

		case "createDoctor":

			if (vf.getPersonMenu().getDoctorId().getText().toString().equals("")
					|| vf.getPersonMenu().getDoctorName().getText().toString().equals("")
					|| vf.getPersonMenu().getEmailDoctor().getText().toString().equals("")
					|| vf.getPersonMenu().getSpeciality().getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				createDoctor();

			}

			break;

		case "generatedAppointment":

			if (vf.getSchedule().getDoctor().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getSpecialty().getSelectedItem().toString().equals("")
					|| vf.getSchedule().getName1().getText().toString().equals("")
					|| vf.getSchedule().getDate1().getDate() == null
					|| vf.getSchedule().getId().getText().toString().equals("")
					|| vf.getSchedule().getEmail().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				generatedAppointment();

			}

			break;

		case "reGenerated":

			if (vf.getSchedule().getAppointmentNumbers().getText().toString().equals("")
					|| vf.getSchedule().getDate2().getDate() == null
					|| vf.getSchedule().getId2().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				reGenerated();

			}

			break;
		case "cancel":

			if (vf.getSchedule().getAppointmentNumber().getText().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese los valores requeridos", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {

				cancel();

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
			showScheduleInfo();
			infoTreatment();
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

			ImageIcon schedulePanelClear = new ImageIcon("Images\\menuCitas\\agendarClaro.png");
			vf.getSchedule().getBackground2().setIcon(schedulePanelClear);

			ImageIcon reSchedulePanelClear = new ImageIcon("Images\\menuCitas\\reagendarCita.png");
			vf.getSchedule().getBackground3().setIcon(reSchedulePanelClear);

			ImageIcon cancelPanelClear = new ImageIcon("Images\\menuCitas\\cancelarCita.png");
			vf.getSchedule().getBackground4().setIcon(cancelPanelClear);

			showScheduleInfo();

			ImageIcon infoClear = new ImageIcon("Images\\infoButtons\\1.png");
			Image scaledInfoClear = infoClear.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);
			vf.getSchedule().getInfoDate().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoDoctor().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoEmail().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoName().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoNDate().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoNum().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfoNumCancel().setIcon(new ImageIcon(scaledInfoClear));
			vf.getSchedule().getInfospecialty().setIcon(new ImageIcon(scaledInfoClear));

			darkMode = false;

		} else {
			showScheduleInfo();
			infoTreatment();
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

			showScheduleInfo();

			ImageIcon infoDark = new ImageIcon("Images\\infoButtons\\2.png");
			Image scaledInfoDark = infoDark.getImage().getScaledInstance(34, 34, Image.SCALE_SMOOTH);

			vf.getSchedule().getInfoDate().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoDoctor().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoEmail().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoName().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoNDate().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoNum().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfoNumCancel().setIcon(new ImageIcon(scaledInfoDark));
			vf.getSchedule().getInfospecialty().setIcon(new ImageIcon(scaledInfoDark));

			darkMode = true;
		}
	}

	public void showScheduleInfo() {
		if (schedule == 1) {
			vf.getSchedule().getInfoNumCancel().setVisible(false);
			vf.getSchedule().getInfoNDate().setVisible(false);
			vf.getSchedule().getInfoNum().setVisible(false);

			vf.getSchedule().getSelectPatient().setBounds(0, 0, 111, 40);

			vf.getSchedule().getInfoDate().setVisible(true);
			vf.getSchedule().getInfoDoctor().setVisible(true);
			vf.getSchedule().getInfoEmail().setVisible(true);
			vf.getSchedule().getInfoName().setVisible(true);
			vf.getSchedule().getInfospecialty().setVisible(true);
		} else if (schedule == 2) {
			vf.getSchedule().getInfoNumCancel().setVisible(false);
			vf.getSchedule().getInfoDate().setVisible(false);
			vf.getSchedule().getInfoDoctor().setVisible(false);
			vf.getSchedule().getInfoEmail().setVisible(false);
			vf.getSchedule().getInfoName().setVisible(false);
			vf.getSchedule().getInfospecialty().setVisible(false);
			vf.getSchedule().getSelectPatient().setBounds(0, 27, 111, 40);
			vf.getSchedule().getInfoNDate().setVisible(true);
			vf.getSchedule().getInfoNum().setVisible(true);
		} else if (schedule == 3) {
			vf.getSchedule().getInfoNDate().setVisible(false);
			vf.getSchedule().getInfoNum().setVisible(false);
			vf.getSchedule().getInfoDate().setVisible(false);
			vf.getSchedule().getInfoDoctor().setVisible(false);
			vf.getSchedule().getInfoEmail().setVisible(false);
			vf.getSchedule().getInfoName().setVisible(false);
			vf.getSchedule().getInfospecialty().setVisible(false);

			vf.getSchedule().getSelectPatient().setBounds(0, 70, 111, 40);
			vf.getSchedule().getInfoNumCancel().setVisible(true);
		} else if (schedule == 0) {
			vf.getSchedule().getInfoNumCancel().setVisible(false);
			vf.getSchedule().getInfoNDate().setVisible(false);
			vf.getSchedule().getInfoNum().setVisible(false);
			vf.getSchedule().getInfoDate().setVisible(false);
			vf.getSchedule().getInfoDoctor().setVisible(false);
			vf.getSchedule().getInfoEmail().setVisible(false);
			vf.getSchedule().getInfoName().setVisible(false);
			vf.getSchedule().getInfospecialty().setVisible(false);

		}

	}

	public static  void infoTreatment() {

		if (checkWindowTreatment == 1) {// Principal

			vf.getTreatments().getInfoPanel().setBounds(610, 170, 123, 220);

			vf.getTreatments().getInfoName().setVisible(true);
			vf.getTreatments().getInfoName().setBounds(0, 70, 34, 34);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 144, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 181, 34, 34);

			vf.getTreatments().getInfospecialty().setVisible(true);
			vf.getTreatments().getInfospecialty().setBounds(0, 107, 34, 34);

			vf.getTreatments().getSelectPatient().setVisible(true);
			vf.getTreatments().getSelectPatient().setBounds(0, 28, 111, 40);

		}  if (checkWindowTreatment == 2) {// Buscar
			vf.getTreatments().getInfoPanel().setBounds(614, 170, 130, 220);

			vf.getTreatments().getInfoName().setVisible(true);
			vf.getTreatments().getInfoName().setBounds(0, 62, 34, 34);

			vf.getTreatments().getSearchButton().setVisible(true);
			vf.getTreatments().getSearchButton().setBounds(0, 24, 100, 35);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 144, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 183, 34, 34);

			vf.getTreatments().getInfospecialty().setVisible(true);
			vf.getTreatments().getInfospecialty().setBounds(0, 104, 34, 34);

			// vf.getTreatments().getInfoName().setVisible(false);

		}  if (checkWindowTreatment == 3) {// Finish
			vf.getTreatments().getInfoPanel().setBounds(614, 170, 130, 210);

			vf.getTreatments().getSearchButton().setBounds(0, 53, 100, 35);
			vf.getTreatments().getSearchButton().setVisible(true);

			vf.getTreatments().getInfoTreatment().setVisible(true);
			vf.getTreatments().getInfoTreatment().setBounds(0, 93, 34, 34);

			vf.getTreatments().getInfoStatus().setVisible(true);
			vf.getTreatments().getInfoStatus().setBounds(0, 135, 34, 34);
		}  if (checkWindowTreatment == 0) {
			vf.getTreatments().getSearchButton().setVisible(false);
			vf.getTreatments().getInfoTreatment().setVisible(false);
			vf.getTreatments().getInfospecialty().setVisible(false);
			vf.getTreatments().getInfoName().setVisible(false);
			vf.getTreatments().getInfoStatus().setVisible(false);
			vf.getTreatments().getSelectPatient().setVisible(false);
			//vf.getTreatments().getInfoPanel().setVisible(false);
			

		}

	}

	public int appoitment() {
		int num = 0;
		main: while (true) {
			boolean frist = false;
			num = random();

			appointment = new ArrayList<>();
			appointment = mf.getAppointment().getAll();
			second: for (int i = 0; i < appointment.size(); i++) {

				if (appointment.isEmpty()) {
					break main;
				} else {

					if (appointment.get(i).getAppointmentNum() == num) {
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

	private static void generateEmail(String destinatario, String asunto, String cuerpo) {
		Properties prop = FileHandler.loadProperties("mail.properties");

		String remitente = prop.getProperty("mail.email.sender");

		String claveemail = prop.getProperty("mail.password.sender");

		Properties props = System.getProperties();
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.user", remitente);
		props.put("mail.smtp.clave", claveemail);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(remitente));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			message.setSubject(asunto);
			message.setText(cuerpo);
			Transport transport = session.getTransport("smtp");
			transport.connect("smtp.gmail.com", remitente, claveemail);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (MessagingException me) {
			JOptionPane.showMessageDialog(null, "El correo no se ha podido enviar, contacte a soporte", "Error Mail",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void generTurn() {

		boolean tShift = false;

		doctor = new ArrayList<>();
		doctor = mf.getDoctor().getAll();

		List<Integer> ids = new ArrayList<>();

		shift = new ArrayList<>();
		shift = mf.getShift().getAll();

		if (!shift.isEmpty()) {

			for (ShiftsDTO sh : shift) {

				ids.add(sh.getId());

			}

			tShift = true;

		}

		List<String> especialidad1 = new ArrayList<>();
		List<String> especialidad2 = new ArrayList<>();
		List<String> especialidad3 = new ArrayList<>();
		List<String> especialidad4 = new ArrayList<>();
		List<String> especialidad5 = new ArrayList<>();
		List<String> especialidad6 = new ArrayList<>();

		String espe1 = "Cirugia";
		String espe2 = "Oncologia";
		String espe3 = "Dermatologia";
		String espe4 = "Neumologia";
		String espe5 = "Cardiologia";
		String espe6 = "MedicinaInterna";

		Date d = vf.getShifts().getStartDate().getDate();
		SimpleDateFormat formatoF = new SimpleDateFormat("dd/MM/yyyy");
		String dat = formatoF.format(d);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DAY_OF_MONTH, 7);

		Date nuevaFecha = calendar.getTime();
		SimpleDateFormat formatoF2 = new SimpleDateFormat("dd/MM/yyyy");
		String dat2 = formatoF2.format(nuevaFecha);

		vf.getShifts().getFinishDate().setDate(nuevaFecha);

		for (int i = 0; i < doctor.size(); i++) {

			f: for (int n = 0; n < vf.getPersonMenu().getSpeciality().getItemCount(); n++) {
				String item = vf.getPersonMenu().getSpeciality().getItemAt(n);
				if (item.equals("")) {

					continue f;

				}
				if (item.equals(espe1)) {

					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe1)) {

							if (especialidad1.contains(doc.getName())) {

							} else {

								especialidad1.add(doc.getName());
							}

						}

					}

				} else if (item.equals(espe2)) {
					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe2)) {

							if (especialidad2.contains(doc.getName())) {

							} else {

								especialidad2.add(doc.getName());
							}

						}

					}
				} else if (item.equals(espe3)) {
					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe3)) {

							if (especialidad3.contains(doc.getName())) {

							} else {

								especialidad3.add(doc.getName());
							}

						}

					}
				} else if (item.equals(espe4)) {
					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe4)) {

							if (especialidad4.contains(doc.getName())) {

							} else {

								especialidad4.add(doc.getName());
							}

						}

					}
				} else if (item.equals(espe5)) {
					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe5)) {

							if (especialidad5.contains(doc.getName())) {

							} else {

								especialidad5.add(doc.getName());
							}

						}

					}
				} else if (item.equals(espe6)) {
					for (DoctorDTO doc : doctor) {

						if (doc.getSpecialty().equals(espe6)) {

							if (especialidad6.contains(doc.getName())) {

							} else {

								especialidad6.add(doc.getName());
							}

						}

					}
				}
			}

		}

		boolean t1 = true, t2 = true, t3 = true, t4 = true, t5 = true, t6 = true;
		boolean t11 = true, t22 = true, t33 = true, t44 = true, t55 = true, t66 = true;

		Random random = new Random();
		wh: while (t1 || t2 || t3 || t4 || t5 || t6 || t11 || t22 || t33 || t44 || t55 || t66) {

			int indice1 = random.nextInt(especialidad1.size());
			int indice11 = random.nextInt(especialidad1.size());
			String nombreEspe1 = especialidad1.get(indice1);
			String nombreEspe11 = especialidad1.get(indice11);

			int indice2 = random.nextInt(especialidad2.size());
			int indice22 = random.nextInt(especialidad2.size());
			String nombreEspe2 = especialidad2.get(indice2);
			String nombreEspe22 = especialidad2.get(indice22);

			int indice3 = random.nextInt(especialidad3.size());
			int indice33 = random.nextInt(especialidad3.size());
			String nombreEspe3 = especialidad3.get(indice3);
			String nombreEspe33 = especialidad3.get(indice33);

			int indice4 = random.nextInt(especialidad4.size());
			int indice44 = random.nextInt(especialidad4.size());
			String nombreEspe4 = especialidad4.get(indice4);
			String nombreEspe44 = especialidad4.get(indice44);

			int indice5 = random.nextInt(especialidad5.size());
			int indice55 = random.nextInt(especialidad5.size());
			String nombreEspe5 = especialidad5.get(indice5);
			String nombreEspe55 = especialidad5.get(indice55);

			int indice6 = random.nextInt(especialidad6.size());
			int indice66 = random.nextInt(especialidad6.size());
			String nombreEspe6 = especialidad6.get(indice6);
			String nombreEspe66 = especialidad6.get(indice66);

			if (nombreEspe11.equals(nombreEspe1) || nombreEspe22.equals(nombreEspe2) || nombreEspe33.equals(nombreEspe3)
					|| nombreEspe44.equals(nombreEspe4) || nombreEspe55.equals(nombreEspe5)
					|| nombreEspe66.equals(nombreEspe6)) {
				continue wh;
			} else {

				for (int t = 0; t < doctor.size(); t++) {

					String name = doctor.get(t).getName();

					if (name.equals(nombreEspe1)) {

						if (t1 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe1))) {
									t1 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}

					} else if (name.equals(nombreEspe11)) {

						if (t11 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe11))) {
									t11 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}

					else if (name.equals(nombreEspe2)) {

						if (t2 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe2))) {
									t2 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					} else if (name.equals(nombreEspe22)) {
						if (t22 == false) {

						} else {
							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe22))) {
									t22 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}

					else if (name.equals(nombreEspe3)) {

						if (t3 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe3))) {
									t3 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}

					} else if (name.equals(nombreEspe33)) {
						if (t33 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe33))) {
									t33 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}
					if (name.equals(nombreEspe4)) {
						if (t4 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe4))) {
									t4 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}

					} else if (name.equals(nombreEspe44)) {
						if (t44 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe44))) {
									t44 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}
					if (name.equals(nombreEspe5)) {

						if (t5 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe5))) {
									t5 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}

					} else if (name.equals(nombreEspe55)) {
						if (t55 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe55))) {
									t55 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}

					else if (name.equals(nombreEspe6)) {

						if (t6 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe6))) {
									t6 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}

					}

					else if (name.equals(nombreEspe66)) {
						if (t66 == false) {

						} else {

							if (doctor.get(t).getStatus().equals("inactivo")) {
								int ident = doctor.get(t).getId();
								String email = doctor.get(t).getEmail();
								String speciality = doctor.get(t).getSpecialty();

								mf.getDoctor().update(new DoctorDTO(null, null, ident, null, null),
										new DoctorDTO(name, email, ident, speciality, "activo"));

								if (mf.getShift().add(new ShiftsDTO(dat, dat2, speciality, ident, nombreEspe66))) {
									t66 = false;

								} else {
									// JOptionPane.showMessageDialog(null, "No se pudo crear el turno ");
								}

							}
						}
					}
				}
			}
		}

		if (tShift) {

			f: for (int i = 0; i < shift.size(); i++) {

				int id = shift.get(i).getId();

				if (ids.get(i) == id) {
					String date1 = shift.get(i).getDate1();
					String date2 = shift.get(i).getDate2();
					String tSpeciality = shift.get(i).getSpecialty();
					String tName = shift.get(i).getName();
					p: for (int n = 0; n < doctor.size(); n++) {

						int tId = doctor.get(n).getId();

						if (tId == ids.get(i)) {

							String status = doctor.get(n).getStatus();

							if (status.equals("activo")) {

								String name = doctor.get(n).getName();
								String email = doctor.get(n).getEmail();
								String speciality = doctor.get(n).getSpecialty();

								mf.getShiftReport()
										.add(new ShiftsReportDTO(date1, date2, tSpeciality, ids.get(i), tName, false));

								mf.getDoctor().update(new DoctorDTO(null, null, ids.get(i), null, null),
										new DoctorDTO(name, email, ids.get(i), speciality, "inactivo"));

								mf.getShift().delete(new ShiftsDTO(null, null, null, ids.get(i), null));

							}
							if (shift.isEmpty()) {
								break f;
							}

						} else {
							continue p;
						}

					}

				} else {
					continue f;
				}

			}

		}

		if (tShift) {
			JOptionPane.showMessageDialog(null, "Nuevo de turno");
		}

		if (t1 == false || t2 == false || t3 == false || t4 == false || t5 == false || t6 == false || t11 == false
				|| t22 == false || t33 == false || t44 == false || t55 == false || t66 == false) {
			JOptionPane.showMessageDialog(null, "Turno creado en la fecha " + dat);
			turnNameSpeciality();
			doctorOrderId();

		}

	}

	public void setInactive() {

		doctor = new ArrayList<DoctorDTO>();
		doctor = mf.getDoctor().getAll();

		for (DoctorDTO dc : doctor) {

			mf.getDoctor().update(new DoctorDTO(null, null, dc.getId(), null, null),
					new DoctorDTO(dc.getName(), dc.getEmail(), dc.getId(), dc.getSpecialty(), "inactivo"));

		}
		doctorOrderId();
	}

	public static void sendEmail(String email, String subject, String message) {

		JDialog loadingDialog = new JDialog();
		loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		loadingDialog.setSize(200, 50);
		loadingDialog.setLocationRelativeTo(null);
		loadingDialog.setUndecorated(true);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		loadingDialog.add(new JLabel("Enviando Correo..."), "North");
		loadingDialog.add(progressBar, "Center");

		SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {

				generateEmail(email, subject, message);
				return null;
			}

			@Override
			protected void done() {
				panelsEmails();
				loadingDialog.dispose();
				JOptionPane.showMessageDialog(null, "Correo enviado con éxito");
			}
		};

		loadingDialog.setVisible(true);
		worker.execute();
	}

	public static void panelsEmails() {

		if (vf.getPersonMenu().getPersonPanel().isVisible()) {
			vf.getShowOptions().getNewPersonPanel().setVisible(false);
			vf.getPersonMenu().getPersonPanel().setVisible(false);
			vf.getPersonMenu().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (vf.getPersonMenu().getDoctorPanel().isVisible()) {

			vf.getShowOptions().getNewPersonPanel().setVisible(false);
			vf.getPersonMenu().getDoctorPanel().setVisible(false);
			vf.getPersonMenu().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (vf.getPersonMenu().getUpdatePerson().isVisible()) {

			vf.getPersonMenu().getPersonUpdatePanel().setVisible(false);
			vf.getPersonMenu().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (vf.getPersonMenu().getUpdateDoctor().isVisible()) {

			vf.getPersonMenu().getUpdateDoctor().setVisible(false);
			vf.getPersonMenu().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (sendEmail == 1) {

			vf.getSchedule().getSchedulePanel().setVisible(false);
			vf.getSchedule().getMainPanel().setVisible(true);
			vf.getSchedule().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (sendEmail == 2) {

			vf.getSchedule().getReSchedulePanel().setVisible(false);
			vf.getSchedule().getMainPanel().setVisible(true);
			vf.getSchedule().setVisible(false);
			vf.getHome().setVisible(true);

		}
		if (sendEmail == 3) {

			vf.getSchedule().getCancelPanel().setVisible(false);
			vf.getSchedule().getMainPanel().setVisible(true);
			vf.getSchedule().setVisible(false);
			vf.getHome().setVisible(true);
		}
		if (sendEmail == 4) {
			vf.getTreatments().getNewTreatmentPanel().setVisible(false);
			vf.getTreatments().getMainPanel().setVisible(true);
			vf.getTreatments().setVisible(false);
			vf.getHome().setVisible(true);
			checkWindowTreatment =0;
			infoTreatment();

		}
		if (sendEmail == 5) {
			vf.getTreatments().getSearchTreatmentPanel().setVisible(false);
			vf.getTreatments().getMainPanel().setVisible(true);
			vf.getTreatments().setVisible(false);
			vf.getHome().setVisible(true);
			checkWindowTreatment = 0;
			infoTreatment();
		}
		if (sendEmail == 6) {
			vf.getTreatments().getFinishTreatmentPanel().setVisible(false);
			vf.getTreatments().getMainPanel().setVisible(true);
			vf.getTreatments().setVisible(false);
			vf.getHome().setVisible(true);
			checkWindowTreatment = 0;
			infoTreatment();
		}

	}

	public void doctorOrderId() {

		doctor = new ArrayList<DoctorDTO>();
		doctor = mf.getDoctor().getAll();
		Collections.sort(doctor, new idDoctorOrder());

		for (DoctorDTO dc : doctor) {

			mf.getDoctor().update(new DoctorDTO(null, null, dc.getId(), null, null),
					new DoctorDTO(dc.getName(), dc.getEmail(), dc.getId(), dc.getSpecialty(), dc.getStatus()));

		}

	}

	public void turnNameSpeciality() {

		shift = new ArrayList<ShiftsDTO>();
		shift = mf.getShift().getAll();
		Collections.sort(shift, new nameSpecialityTurnOrder());

		for (ShiftsDTO sh : shift) {

			mf.getShift().update(new ShiftsDTO(null, null, null, sh.getId(), null),
					new ShiftsDTO(sh.getDate1(), sh.getDate2(), sh.getSpecialty(), sh.getId(), sh.getName()));

		}

	}

	public boolean idCheckException(String id) {
		try {
			ExceptionChecker.IdentificationNotValidNumber(id);
		} catch (IdentificationNotValidException e) {
			return true;
		}
		return false;
	}

	public void cancel() {
		sendEmail = 3;
		int appoint = Integer.parseInt(vf.getSchedule().getAppointmentNumber().getText().toString());

		appointment = new ArrayList<>();
		appointment = mf.getAppointment().getAll();

		p: for (int i = 0; i < appointment.size(); i++) {
			int ap = appointment.get(i).getAppointmentNum();

			if (ap == appoint) {

				mf.getAppointmentReport()
						.add(new AppoitmentReportDTO(appointment.get(i).getId(), appointment.get(i).getDoctor(),
								appointment.get(i).getSpecialty(), appointment.get(i).getDate(),
								appointment.get(i).getAppointmentNum(), false));

				if (mf.getAppointment().delete(new AppointmentDTO(0, null, null, null, appoint))) {

					String speciality = appointment.get(i).getSpecialty();
					String date = appointment.get(i).getDate();
					String name = null;
					String email = null;
					int id = 0;
					patient = new ArrayList<PatientDTO>();
					patient = mf.getPatient().getAll();

					for (PatientDTO pa : patient) {

						id = pa.getId();

						if (id == appointment.get(i).getId()) {
							name = pa.getName();
							email = pa.getEmail();

							break;

						}

					}

					JOptionPane.showMessageDialog(null, "Cita de numero " + appoint + " eliminado exitosamente");

					vf.getSchedule().getAppointmentNumber().setText(null);
					vf.getSchedule().getId3().setText(null);
					Properties prop = FileHandler.loadProperties("mail.properties");

					String subject = prop.getProperty("mail.appointment.canceled.subject");

					String body = prop.getProperty("mail.appointment.canceled.body");

					String message = body.replace("{nombrePaciente}", name)
							.replace("{numeroIdentificacion}", String.valueOf(id))
							.replace("{numeroCita}", String.valueOf(appoint)).replace("{especialidadCita}", speciality)
							.replace("{fechaCita}", date);
					sendEmail(email, subject, message);
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

	public void reGenerated() {
		sendEmail = 2;
		int appoint = Integer.parseInt(vf.getSchedule().getAppointmentNumbers().getText().toString());
		Date tDates = vf.getSchedule().getDate2().getDate();

		boolean checkDate = dateCheckException(tDates);

		if (checkDate) {
			vf.getSchedule().getDate2().setDate(null);
			JOptionPane.showMessageDialog(null, "La fecha tiene caracteres incorrectos");

		} else {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			String date = formatoFecha.format(tDates);

			appointment = new ArrayList<>();
			appointment = mf.getAppointment().getAll();

			p: for (int i = 0; i < appointment.size(); i++) {
				int ap = appointment.get(i).getAppointmentNum();

				if (ap == appoint) {
					String doctor = appointment.get(i).getDoctor();
					String specialty = appointment.get(i).getSpecialty();
					int id = appointment.get(i).getId();

					if (mf.getAppointment().update(new AppointmentDTO(0, null, null, null, appoint),
							new AppointmentDTO(id, doctor, specialty, date, appoint))) {

						String name = null;
						String email = null;

						patient = new ArrayList<PatientDTO>();
						patient = mf.getPatient().getAll();

						for (PatientDTO pa : patient) {

							int tIds = pa.getId();

							if (tIds == id) {
								name = pa.getName();
								email = pa.getEmail();
								break;

							}

						}

						JOptionPane.showMessageDialog(null, "Cita de numero " + appoint + " actualizado exitosamente");
						vf.getSchedule().getId2().setText(null);
						vf.getSchedule().getAppointmentNumbers().setText(null);
						vf.getSchedule().getDate2().setDate(null);

						Properties prop = FileHandler.loadProperties("mail.properties");

						String subject = prop.getProperty("mail.appointment.rescheduled.subject");

						String body = prop.getProperty("mail.appointment.rescheduled.body");

						String message = body.replace("{nombrePaciente}", name)
								.replace("{numeroIdentificacion}", String.valueOf(id))
								.replace("{numeroCita}", String.valueOf(appoint))
								.replace("{especialidadCita}", specialty).replace("{fechaCita}", date)
								.replace("{nombreDoctor}", doctor);
						sendEmail(email, subject, message);

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
	}

	public void generatedAppointment() {

		String id = vf.getSchedule().getId().getText().toString();

		boolean checkId = idCheckException(id);

		if (checkId) {
			vf.getSchedule().getId().setText(null);
			JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

		} else {
			int tId = Integer.parseInt(id);
			patient = new ArrayList<>();
			patient = mf.getPatient().getAll();
			for (int i = 0; i < patient.size(); i++) {

				int oldId = patient.get(i).getId();

				if (oldId == tId) {

					String doctor = vf.getSchedule().getDoctor().getSelectedItem().toString();
					String specialty = vf.getSchedule().getSpecialty().getSelectedItem().toString();

					String name = vf.getSchedule().getName1().getText().toString();
					String email = vf.getSchedule().getEmail().getText().toString();

					Date tDate = vf.getSchedule().getDate1().getDate();
					SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
					String date = formatoFecha.format(tDate);

					boolean checkDate = dateCheckException(tDate);

					if (checkDate) {
						JOptionPane.showMessageDialog(null, "La fecha tiene caracteres incorrectos");
						vf.getSchedule().getDate1().setDate(null);
					} else {

						int appoitment = appoitment();

						if (mf.getAppointment().add(new AppointmentDTO(tId, doctor, specialty, date, appoitment))) {

							JOptionPane.showMessageDialog(null,
									"Cita de numero " + appoitment + " creado exitosamente");
							vf.getSchedule().getId().setText(null);
							vf.getSchedule().getName1().setText(null);
							vf.getSchedule().getEmail().setText(null);
							vf.getSchedule().getSpecialty().setSelectedItem("");
							vf.getSchedule().getDoctor().setSelectedItem("");
							vf.getSchedule().getDate1().setCalendar(null);
							// ENVIO DE NOTIFICACION MEDIANTE CORREO GMAIL
							Properties prop = FileHandler.loadProperties("mail.properties");

							String subject = prop.getProperty("mail.appointment.scheduled.subject");

							String body = prop.getProperty("mail.appointment.scheduled.body");

							String message = body.replace("{nombrePaciente}", name)
									.replace("{numeroIdentificacion}", String.valueOf(id))
									.replace("{numeroCita}", String.valueOf(appoitment))
									.replace("{especialidadCita}", specialty).replace("{fechaCita}", date)
									.replace("{nombreDoctor}", doctor);

							sendEmail(email, subject, message);
							/*
							 * vf.getSchedule().getSchedulePanel().setVisible(false);
							 * vf.getSchedule().getMainPanel().setVisible(true);
							 * vf.getSchedule().setVisible(false); vf.getHome().setVisible(true);
							 */
						} else {

							JOptionPane.showMessageDialog(null, "No se pudo crear");

						}

						break;
					}
				} else {
					continue;
				}

			}
		}
	}

	public void createDoctor() {
		int contador = 0;
		String speciality = vf.getPersonMenu().getSpeciality().getSelectedItem().toString();

		boolean checkSpeciality = nameCheckException(speciality);

		if (checkSpeciality) {
			vf.getPersonMenu().getSpeciality().setSelectedItem("");
			JOptionPane.showMessageDialog(null, "La especialidad tiene caracteres incorrectos");
		} else {

			doctor = new ArrayList<>();
			doctor = mf.getDoctor().getAll();

			for (int i = 0; i < doctor.size(); i++) {

				String spe = doctor.get(i).getSpecialty();

				if (spe.equals(speciality)) {
					contador++;
					continue;
				}

			}

			if (contador < 8) {

				String id2 = vf.getPersonMenu().getDoctorId().getText().toString();
				String name = vf.getPersonMenu().getDoctorName().getText().toString();
				String email = vf.getPersonMenu().getEmailDoctor().getText().toString();

				boolean checkId = idCheckException(id2);
				boolean checkName = nameCheckException(name);
				boolean checkEmail = emailCheckException(email);

				if (checkId) {
					vf.getPersonMenu().getDoctorId().setText(null);
					JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");
				} else if (checkEmail) {
					vf.getPersonMenu().getEmailDoctor().setText(null);
					JOptionPane.showMessageDialog(null, "El email tiene caracteres incorrectos");
				} else if (checkName) {
					vf.getPersonMenu().getDoctorName().setText(null);
					JOptionPane.showMessageDialog(null, "El nombre tiene caracteres incorrectos");
				} else {

					int id = Integer.parseInt(id2);

					if (mf.getDoctor().add(new DoctorDTO(name, email, id, speciality, "inactivo"))) {
						JOptionPane.showMessageDialog(null, "Doctor creado con exito");
						vf.getPersonMenu().getDoctorId().setText(null);
						vf.getPersonMenu().getDoctorName().setText(null);
						vf.getPersonMenu().getEmailDoctor().setText(null);
						vf.getPersonMenu().getSpeciality().setSelectedItem("");

						Properties prop = FileHandler.loadProperties("mail.properties");

						String subject = prop.getProperty("mail.doctor.welcome.subject");

						String body = prop.getProperty("mail.doctor.welcome.body");

						String message = body.replace("{nombreDoctor}", name).replace("{especialidad}", speciality)
								.replace("{numeroIdentificacion}", String.valueOf(id)).replace("{correoDoctor}", email);

						doctorOrderId();
						sendEmail(email, subject, message);

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo crear");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "No pueden existir mas de 7 doctores por especialidad");
			}
		}
	}

	public void createPatient() {

		String identi2 = vf.getPersonMenu().getPatientId().getText().toString();
		String name = vf.getPersonMenu().getPatientName().getText().toString();
		String age2 = vf.getPersonMenu().getPatientAge().getText().toString();
		String email = vf.getPersonMenu().getEmailPatient().getText().toString();
		boolean checkId = idCheckException(identi2);
		boolean checkAge = ageCheckException(age2);
		boolean checkName = nameCheckException(name);
		boolean checkEmail = emailCheckException(email);

		if (checkId) {
			vf.getPersonMenu().getPatientId().setText(null);
			JOptionPane.showMessageDialog(null, "El id no puede contener caracteres especiales");
		} else if (checkAge) {
			vf.getPersonMenu().getPatientAge().setText(null);
			JOptionPane.showMessageDialog(null, "La edad no puede contener caracteres especiales");
		} else if (checkName) {
			vf.getPersonMenu().getPatientName().setText(null);
			JOptionPane.showMessageDialog(null, "El nombre no tiene un formato correcto");
		} else if (checkEmail) {
			vf.getPersonMenu().getEmailPatient().setText(null);
			JOptionPane.showMessageDialog(null, "El email no tiene un formato correcto");
		} else {

			int identi = Integer.parseInt(identi2);
			int age = Integer.parseInt(age2);

			if (mf.getPatient().add(new PatientDTO(name, email, identi, age))) {
				vf.getPersonMenu().getPatientId().setText(null);
				vf.getPersonMenu().getPatientName().setText(null);
				vf.getPersonMenu().getPatientAge().setText(null);
				vf.getPersonMenu().getEmailPatient().setText(null);
				JOptionPane.showMessageDialog(null, "Paciente creado con exito");

				Properties prop = FileHandler.loadProperties("mail.properties");

				String subject = prop.getProperty("mail.patient.creation.subject");

				String body = prop.getProperty("mail.patient.creation.body");

				String message = body.replace("{nombrePaciente}", name)
						.replace("{numeroIdentificacion}", String.valueOf(identi)).replace("{correo}", email);

				sendEmail(email, subject, message);

			} else {
				JOptionPane.showMessageDialog(null, "No se pudo crear");
			}
		}
	}

	public void registerTre() {
		checkWindowTreatment=0;
		sendEmail = 4;
		boolean enter = true;
		String name = vf.getTreatments().getName1().getText().toString();
		String specialty = vf.getTreatments().getSpecialty().getSelectedItem().toString();
		String treatment = vf.getTreatments().getTreatmentTxt().getText().toString();
		String status = vf.getTreatments().getStatus().getSelectedItem().toString();

		boolean checkTreatment = nameCheckException(treatment);
		boolean checkName = nameCheckException(name);

		if (checkName) {
			vf.getTreatments().getName1().setText(null);
			JOptionPane.showMessageDialog(null, "El nombre tiene caracteres incorrectos");

		} else if (checkTreatment) {
			vf.getTreatments().getTreatmentTxt().setText(null);
			JOptionPane.showMessageDialog(null, "El tratamiento tiene caracteres incorrectos");

		} else {

			patient = new ArrayList<>();
			patient = mf.getPatient().getAll();
			newP: for (int i = 0; i < patient.size(); i++) {

				String oldName = patient.get(i).getName();

				if (name.equals(oldName)) {

					enter = false;

					if (mf.getTreatment().add(new TreatmentDTO(name, specialty, treatment, status))) {

						String email = patient.get(i).getEmail();

						JOptionPane.showMessageDialog(null, "Tratamiento creado correctamente");
						vf.getTreatments().getId1().setText(null);
						vf.getTreatments().getName1().setText(null);
						vf.getTreatments().getSpecialty().setSelectedItem("");
						vf.getTreatments().getTreatmentTxt().setText(null);
						vf.getTreatments().getStatus().setSelectedItem("");

						Properties prop = FileHandler.loadProperties("mail.properties");

						String subject = prop.getProperty("mail.treatment.assigned.subject");

						String body = prop.getProperty("mail.treatment.assigned.body");

						String message = body.replace("{nombrePaciente}", name).replace("{especialidad}", specialty)
								.replace("{tratamiento}", treatment);

						sendEmail(email, subject, message);
						infoTreatment();
						checkWindowTreatment=1;

					} else {
						JOptionPane.showMessageDialog(null, "No se pudo crear");
					}

					break newP;
				} else {
					continue newP;
				}

			}

			if (enter) {
				JOptionPane.showMessageDialog(null, "El paciente no existe");
			}
		}
	}

	public void updateTre() {
		sendEmail = 5;
		checkWindowTreatment=0;
		boolean verf = true;
		String email = null;
		String treatment = vf.getTreatments().getTreatmentS().getText().toString();
		String speciality = vf.getTreatments().getSpecialty2().getSelectedItem().toString();
		String status = vf.getTreatments().getStatus2().getSelectedItem().toString();
		String name = vf.getTreatments().getNameS().getText().toString();
		String id = vf.getTreatments().getId2().getText().toString();

		boolean checkTreatment = nameCheckException(treatment);
		boolean checkName = nameCheckException(name);

		if (checkName) {
			vf.getTreatments().getNameS().setText(null);
			JOptionPane.showMessageDialog(null, "El nombre tiene caracteres incorrectos");

		} else if (checkTreatment) {
			vf.getTreatments().getTreatmentS().setText(null);
			JOptionPane.showMessageDialog(null, "El tratamiento tiene caracteres incorrectos");

		} else {

			treat = new ArrayList<>();
			treat = mf.getTreatment().getAll();

			main: for (int i = 0; i < treat.size(); i++) {

				String treatment2 = treat.get(i).getTreatment();
				String speciality2 = treat.get(i).getSpecialty();
				String status2 = treat.get(i).getVerified();
				String name2 = treat.get(i).getName();

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

					patient = new ArrayList<PatientDTO>();
					patient = mf.getPatient().getAll();
					int tId = Integer.parseInt(id);
					for (PatientDTO pa : patient) {

						int tIds = pa.getId();

						if (tIds == tId) {
							email = pa.getEmail();
						}

					}

					JOptionPane.showMessageDialog(null, "Tratamiento actualizado correctamente");
					vf.getTreatments().getId2().setText(null);
					vf.getTreatments().getTreatmentS().setText(null);
					vf.getTreatments().getSpecialty2().setSelectedItem(null);
					vf.getTreatments().getStatus2().setSelectedItem(null);
					vf.getTreatments().getNameS().setText(null);

					Properties prop = FileHandler.loadProperties("mail.properties");

					String subject = prop.getProperty("mail.treatment.updated.subject");

					String body = prop.getProperty("mail.treatment.updated.body");

					String message = body.replace("{nombrePaciente}", name).replace("{especialidad}", speciality)
							.replace("{tratamiento}", treatment).replace("{estadoTratamiento}", status);

					sendEmail(email, subject, message);
					infoTreatment();

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo actualizar");
				}
			}
		}
	}

	public void finishTre() {
		checkWindowTreatment=0;
		sendEmail = 6;
		boolean verf2 = true;
		String name = null;
		String email = null;
		String treatment = vf.getTreatments().getTreatmentF().getText().toString();
		String status = vf.getTreatments().getStatus3().getSelectedItem().toString();
		String id2 = vf.getTreatments().getId3().getText().toString();

		boolean checkId = idCheckException(id2);
		boolean checkTreatment = nameCheckException(treatment);

		if (checkId) {
			vf.getTreatments().getId3().setText(null);
			JOptionPane.showMessageDialog(null, "El id tiene caracteres incorrectos");

		} else if (checkTreatment) {
			vf.getTreatments().getTreatmentF().setText(null);
			JOptionPane.showMessageDialog(null, "El tratamiento tiene caracteres incorrectos");

		} else {

			int id = Integer.parseInt(id2);

			patient = new ArrayList<>();
			patient = mf.getPatient().getAll();

			for (int pa = 0; pa < patient.size(); pa++) {

				int tIds = patient.get(pa).getId();

				if (tIds == id) {

					name = patient.get(pa).getName();
					email = patient.get(pa).getEmail();

				} else {
					continue;
				}

			}
			String speciality = "";

			treat = new ArrayList<>();
			treat = mf.getTreatment().getAll();

			main: for (int i = 0; i < treat.size(); i++) {

				String name2 = treat.get(i).getName();
				speciality = treat.get(i).getSpecialty();
				if (name.equals(name2)) {

					if (status.equals("Finalizado")) {
						JOptionPane.showMessageDialog(null, "No se puede finalizar el tratamiento", "Error",
								JOptionPane.ERROR_MESSAGE);
						verf2 = false;

						break main;

					} else {
						verf2 = true;
					}

				} else {
					continue main;
				}

			}

			if (verf2) {

				vf.getTreatments().getStatus3().setSelectedItem("Finalizado");
				status = vf.getTreatments().getStatus3().getSelectedItem().toString();

				if (mf.getTreatment().update2(new TreatmentDTO(null, null, treatment, null),
						new TreatmentDTO(name, speciality, treatment, status))) {
					JOptionPane.showMessageDialog(null, "Tratamiento finalizado correctamente");
					vf.getTreatments().getTreatmentF().setText(null);
					vf.getTreatments().getStatus3().setSelectedItem(null);
					vf.getTreatments().getId3().setText(null);

					Properties prop = FileHandler.loadProperties("mail.properties");

					String subject = prop.getProperty("mail.treatment.completed.subject");

					String body = prop.getProperty("mail.treatment.completed.body");

					String message = body.replace("{nombrePaciente}", name).replace("{especialidad}", speciality)
							.replace("{tratamiento}", treatment).replace("{estadoTratamiento}", status);

					sendEmail(email, subject, message);
					infoTreatment();

				} else {
					JOptionPane.showMessageDialog(null, "No se pudo finalizar el tratamiento ");
				}
			}
		}
	}

	public void changeTurn() {
		boolean enter = true;

		String id3 = vf.getShifts().getId1().getText().toString();
		String id4 = vf.getShifts().getId2().getText().toString();

		boolean checkId = idCheckException(id3);
		boolean checkId2 = idCheckException(id4);

		if (checkId) {
			vf.getShifts().getId1().setText(null);
			JOptionPane.showMessageDialog(null, "El id1 tiene caracteres incorrectos");

		} else if (checkId2) {
			vf.getShifts().getId1().setText(null);
			JOptionPane.showMessageDialog(null, "El id2 tiene caracteres incorrectos");

		} else {

			int id = Integer.parseInt(id3);

			shift = new ArrayList<ShiftsDTO>();
			shift = mf.getShift().getAll();
			doctor = new ArrayList<DoctorDTO>();
			doctor = mf.getDoctor().getAll();

			for (int i = 0; i < shift.size(); i++) {

				int tId = shift.get(i).getId();

				if (id == tId) {
					boolean exist = false;

					int id2 = Integer.parseInt(id4);

					for (DoctorDTO dc : doctor) {

						if (dc.getId() == id2) {

							if (dc.getStatus().equals("inactivo")) {

								exist = true;
								break;
							}

						} else {
							continue;
						}

					}

					if (exist == false) {
						break;
					}

					if (exist) {

						for (ShiftsDTO sh : shift) {

							if (sh.getId() == id) {

								String date1 = null;
								String date2 = null;
								String speciality = null;
								String name = null;

								for (int d = 0; d < doctor.size(); d++) {

									int tIds = doctor.get(d).getId();

									if (tIds == id2) {

										date1 = sh.getDate1();
										date2 = sh.getDate2();
										speciality = doctor.get(d).getSpecialty();
										name = doctor.get(d).getName();

										if (mf.getShift().update(new ShiftsDTO(null, null, null, id, null),
												new ShiftsDTO(date1, date2, speciality, id2, name))) {
											JOptionPane.showMessageDialog(null, "Cambio realizado");

											enter = false;
											SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
											Date tDate1 = null;
											Date tDate2 = null;
											try {
												tDate1 = formato.parse(date1);
												tDate2 = formato.parse(date2);
											} catch (ParseException e1) {
												e1.printStackTrace();
											}

											vf.getShifts().getStartDate2().setDate(tDate1);
											vf.getShifts().getFinishDate2().setEnabled(true);
											vf.getShifts().getFinishDate2().setDate(tDate2);
											vf.getShifts().getId1().setText(null);
											vf.getShifts().getId2().setText(null);
											doctorOrderId();
											turnNameSpeciality();
											break;
										} else {

											JOptionPane.showMessageDialog(null, "no se pudo hacer el cambio");
										}

									} else {
										continue;
									}

								}
								break;
							}
							for (DoctorDTO dc : doctor) {

								if (dc.getId() == id) {

									if (mf.getDoctor().update(new DoctorDTO(null, null, id, null, null), new DoctorDTO(
											dc.getName(), dc.getEmail(), id, dc.getSpecialty(), "inactivo"))) {

									}

								}
								if (dc.getId() == id2) {

									if (mf.getDoctor().update(new DoctorDTO(null, null, id2, null, null), new DoctorDTO(
											dc.getName(), dc.getEmail(), id2, dc.getSpecialty(), "activo"))) {

									}

								}

							}
						}

					}
					break;
				} else {
					continue;
				}

			}
			if (enter) {
				vf.getShifts().getStartDate2().setDate(null);
				vf.getShifts().getFinishDate2().setDate(null);
				vf.getShifts().getId1().setText(null);
				vf.getShifts().getId2().setText(null);
				JOptionPane.showMessageDialog(null, "El cambio no se puede realizar, cambias los ids");

			}
		}
	}

	public void updatePerson() {
		boolean ent = true;
		String id2 = vf.getPersonMenu().getPatientUpdateId().getText().toString();
		boolean checkId = idCheckException(id2);

		if (checkId) {
			vf.getPersonMenu().getPatientUpdateId().setText(null);
			JOptionPane.showMessageDialog(null, "El id no puede contener caracteres especiales");

		} else {
			int id = Integer.parseInt(id2);
			patient = new ArrayList<>();
			patient = mf.getPatient().getAll();

			for (int i = 0; i < patient.size(); i++) {

				int tId = patient.get(i).getId();

				if (id == tId) {

					String name = vf.getPersonMenu().getPatientUpdateName().getText().toString();
					String age2 = vf.getPersonMenu().getPatientUpdateAge().getText().toString();
					String email = vf.getPersonMenu().getEmailUpdatePatient().getText().toString();

					boolean checkName = nameCheckException(name);
					boolean checkEmail = emailCheckException(email);
					boolean checkAge = ageCheckException(age2);

					if (checkEmail) {
						vf.getPersonMenu().getEmailUpdatePatient().setText(null);
						JOptionPane.showMessageDialog(null, "El email no esta en el formato correcto");
					} else if (checkName) {
						vf.getPersonMenu().getPatientUpdateName().setText(null);
						JOptionPane.showMessageDialog(null, "El nombre no esta en el formato correcto");
					} else if (checkAge) {
						vf.getPersonMenu().getPatientUpdateAge().setText(null);
						JOptionPane.showMessageDialog(null, "La edad no puede contener caracteres especiales");
					} else {

						int age = Integer.parseInt(age2);

						if (mf.getPatient().update(new PatientDTO(null, null, id, 0),
								new PatientDTO(name, email, id, age))) {
							JOptionPane.showMessageDialog(null, "Paciente actualizado");
							vf.getPersonMenu().getPatientUpdateId().setText(null);
							vf.getPersonMenu().getPatientUpdateName().setText(null);
							vf.getPersonMenu().getPatientUpdateAge().setText(null);
							vf.getPersonMenu().getEmailUpdatePatient().setText(null);

							Properties prop = FileHandler.loadProperties("mail.properties");

							String subject = prop.getProperty("mail.patient.update.subject");

							String body = prop.getProperty("mail.patient.update.body");

							String message = body.replace("{nombrePaciente}", name)
									.replace("{numeroIdentificacion}", String.valueOf(id))
									.replace("{correoPaciente}", email).replace("{edadPaciente}", String.valueOf(age));

							sendEmail(email, subject, message);
						} else {
							JOptionPane.showMessageDialog(null, "No se pudo actualizar el paciente");
						}

						ent = false;
					}
				} else {
					continue;
				}

			}

			if (ent) {
				vf.getPersonMenu().getPatientUpdateId().setText(null);
				vf.getPersonMenu().getPatientUpdateName().setText(null);
				vf.getPersonMenu().getPatientUpdateAge().setText(null);
				vf.getPersonMenu().getEmailUpdatePatient().setText(null);
				JOptionPane.showMessageDialog(null, "El paciente no existe", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void updateDoctor() {

		boolean enter = true;
		doctor = new ArrayList<>();
		doctor = mf.getDoctor().getAll();

		String id2 = vf.getPersonMenu().getDoctorUpdateId().getText().toString();

		boolean checkId = idCheckException(id2);

		if (checkId) {
			vf.getPersonMenu().getDoctorUpdateId().setText(null);
			JOptionPane.showMessageDialog(null, "El id no puede contener caracteres especiales");

		} else {

			int id = Integer.parseInt(id2);

			for (int i = 0; i < doctor.size(); i++) {

				int tIds = doctor.get(i).getId();
				if (tIds == id) {

					String name = vf.getPersonMenu().getDoctorUpdateName().getText().toString();
					String email = vf.getPersonMenu().getEmailUpdateDoctor().getText().toString();
					String speciality = vf.getPersonMenu().getSpecialityUpdate().getSelectedItem().toString();

					boolean checkName = nameCheckException(name);
					boolean checkEmail = emailCheckException(email);
					boolean checkSpeciality = nameCheckException(speciality);

					if (checkName) {
						vf.getPersonMenu().getDoctorUpdateName().setText(null);
						JOptionPane.showMessageDialog(null, "El nombre tiene caracteres incorrectos");
					} else if (checkEmail) {
						vf.getPersonMenu().getEmailUpdateDoctor().setText(null);
						JOptionPane.showMessageDialog(null, "El email tiene caracteres incorrectos");
					} else if (checkSpeciality) {
						JOptionPane.showMessageDialog(null, "La especialidad tiene caracteres incorrectos");
						vf.getPersonMenu().getSpecialityUpdate().setSelectedItem("");
					} else {

						String status = doctor.get(i).getStatus();

						if (mf.getDoctor().update(new DoctorDTO(null, null, id, null, null),
								new DoctorDTO(name, email, id, speciality, status))) {
							JOptionPane.showMessageDialog(null, "Se actualizo el doctor");
							vf.getPersonMenu().getDoctorUpdateId().setText(null);
							vf.getPersonMenu().getDoctorUpdateName().setText(null);
							vf.getPersonMenu().getEmailUpdateDoctor().setText(null);
							vf.getPersonMenu().getSpecialityUpdate().setSelectedItem("");
							enter = false;
							Properties prop = FileHandler.loadProperties("mail.properties");

							String subject = prop.getProperty("mail.doctor.update.subject");

							String body = prop.getProperty("mail.doctor.update.body");

							String message = body.replace("{nombreDoctor}", name)
									.replace("{numeroIdentificacion}", String.valueOf(id))
									.replace("{correoDoctor}", email).replace("{especialidad}", speciality);

							sendEmail(email, subject, message);
							doctorOrderId();

						} else {
							JOptionPane.showMessageDialog(null, "No se pudo actualizar el doctor");
						}
					}
				}
			}
		}
		if (enter) {
			vf.getPersonMenu().getDoctorUpdateId().setText(null);
			vf.getPersonMenu().getDoctorUpdateName().setText(null);
			vf.getPersonMenu().getEmailUpdateDoctor().setText(null);
			vf.getPersonMenu().getSpecialityUpdate().setSelectedItem("");
			JOptionPane.showMessageDialog(null, "El doctor no existe");
		}
	}

	public boolean nameCheckException(String name) {

		try {
			ExceptionChecker.NameNotValid(name);
		} catch (NameNotValidException e) {
			return true;
		}
		return false;

	}

	public boolean emailCheckException(String email) {
		try {
			ExceptionChecker.checkEmail(email);
		} catch (EmailNotValidException e) {
			return true;
		}
		return false;
	}

	public boolean ageCheckException(String age) {

		try {
			ExceptionChecker.AgeNotValidNumber(age);
		} catch (AgeNotValidException e) {
			return true;
		}
		return false;
	}

	public boolean dateCheckException(Date date) {
		try {
			ExceptionChecker.dateException(date);
		} catch (DateFormatNotValidException e) {
			return true;
		}
		return false;
	}

	public void showReports(String rutaArchivo) {

		try {
			File archivo = new File(rutaArchivo);

			if (!archivo.exists()) {
				JOptionPane.showMessageDialog(null, "El archivo no existe");

				return;
			}

			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();

				desktop.open(archivo);

			} else {

			}
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public void reportDoctorOrder() {

		reportDoc = new ArrayList<>();
		reportDoc = mf.getReportMaxDoc().getAll();

		Collections.sort(reportDoc, new NumReportDocOrder());

		for (ReportMaxDoctorDTO re : reportDoc) {

			mf.getReportMaxDoc().update(new ReportMaxDoctorDTO(0, null, re.getEmail()),
					new ReportMaxDoctorDTO(re.getNumAppo(), re.getName(), re.getEmail()));

		}

	}

	public void reportSpeOrder() {

		reportSpe = new ArrayList<>();
		reportSpe = mf.getReportMaxSpe().getAll();

		Collections.sort(reportSpe, new NumReportSpecialityOrder());

		for (ReportMaxSpecialityDTO re : reportSpe) {

			mf.getReportMaxSpe().update(new ReportMaxSpecialityDTO(0, re.getName()),
					new ReportMaxSpecialityDTO(re.getNumAppo(), re.getName()));

		}

	}

	public static void eliminarArchivos(String folderName, String fileName) {
		File archivo;
		archivo = new File(folderName + "/" + fileName + ".dat");
		archivo.delete();
		archivo = new File(folderName + "/" + fileName + ".csv");
		archivo.delete();
	}
}
