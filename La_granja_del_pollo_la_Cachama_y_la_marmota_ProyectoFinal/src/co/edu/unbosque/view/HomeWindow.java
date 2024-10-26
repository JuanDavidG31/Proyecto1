package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeWindow extends JFrame {
	private JPanel mainPanel;
	private JButton schedule,exit, turn, treatment, report, theme;
	private JLabel background1;

	public HomeWindow() {
		window();
		panels();
		inputs();
		headlines();
		buttons();
		images();

		add(mainPanel);
	}

	public void window() {
		setBounds(0, 0, 800, 600); // Window position and size (where it starts in x, where it starts in y,
									// wide,high)
		setTitle(""); // tittle on window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Close window and close the software
		setResizable(false);
		setLayout(null);

	}

	public void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

	}

	public void images() {

		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuInicial\\Menu.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);
	}

	public void inputs() {

	}

	public void buttons() {
		schedule = new JButton();
		schedule.setBounds(244, 140, 124, 124);
		schedule.setBorderPainted(false);
		schedule.setToolTipText("Menú de citas medicas");
		ImageIcon image1 = new ImageIcon("Images\\menuInicial\\agendarClaro.png");
		//Image scaled1 = image1.getImage().getScaledInstance(137, 137, Image.SCALE_REPLICATE);
		//schedule.setIcon(new ImageIcon(scaled1));
		schedule.setIcon(image1);
		mainPanel.add(schedule);

		turn = new JButton();
		turn.setBounds(432, 140, 124, 124);
		turn.setBorderPainted(false);
		turn.setToolTipText("Menú de turnos para especialistas");
		ImageIcon image2 = new ImageIcon("Images\\menuInicial\\turnoClaro.png");
		Image scaled2 = image2.getImage().getScaledInstance(137, 137, Image.SCALE_REPLICATE);
		turn.setIcon(new ImageIcon(scaled2));
		mainPanel.add(turn);

		treatment = new JButton();
		treatment.setBounds(243, 315, 124, 124);
		treatment.setBorderPainted(false);
		treatment.setToolTipText("Menú de tratamientos de pacientes");
		ImageIcon image3 = new ImageIcon("Images\\menuInicial\\tratamientoClaro.png");
		Image scaled3 = image3.getImage().getScaledInstance(137, 137, Image.SCALE_REPLICATE);
		treatment.setIcon(new ImageIcon(scaled3));
		mainPanel.add(treatment);

		report = new JButton();
		report.setBounds(432, 315, 124, 124);
		report.setBorderPainted(false);
		report.setToolTipText("Generar reporte semanal");
		ImageIcon image4 = new ImageIcon("Images\\menuInicial\\reporteClaro.png");
		Image scaled4 = image4.getImage().getScaledInstance(137, 137, Image.SCALE_REPLICATE);
		report.setIcon(new ImageIcon(scaled4));
		mainPanel.add(report);

		theme = new JButton();
		theme.setBounds(41, 465, 82, 79);
		theme.setBorderPainted(false);
		theme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image5 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled5 = image5.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		theme.setIcon(new ImageIcon(scaled5));
		mainPanel.add(theme);
		
		exit= new JButton();
		exit.setBounds(655, 450, 79, 79);
		exit.setBorderPainted(false);
		exit.setToolTipText("Salir del programa");
		ImageIcon imageE = new ImageIcon("Images\\backButtons\\salirProgramaC.png");
		Image scaledE = imageE.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		exit.setIcon(new ImageIcon(scaledE));
		mainPanel.add(exit);

	}

	public void textFields() {
		// TODO Auto-generated method stub

	}

	public void headlines() {
		// TODO Auto-generated method stub

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JButton getSchedule() {
		return schedule;
	}

	public void setSchedule(JButton schedule) {
		this.schedule = schedule;
	}

	public JButton getTurn() {
		return turn;
	}

	public void setTurn(JButton turn) {
		this.turn = turn;
	}

	public JButton getTreatment() {
		return treatment;
	}

	public void setTreatment(JButton treatment) {
		this.treatment = treatment;
	}

	public JButton getReport() {
		return report;
	}

	public void setReport(JButton report) {
		this.report = report;
	}

	public JButton getTheme() {
		return theme;
	}

	public void setTheme(JButton theme) {
		this.theme = theme;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	

}
