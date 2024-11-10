package co.edu.unbosque.view;


import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeWindow extends JFrame {
	private JPanel mainPanel;
	private JButton schedule, exit, turn, treatment, report, theme, create,users;
	private JLabel background1;

	public HomeWindow() {
		window();
		panels();
		buttons();
		images();

		add(mainPanel);
	}

	public void window() {
		setBounds(0, 0, 800, 600); 
		setTitle(""); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
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

	public void buttons() {

		create = new JButton();
		create.setBounds(262, 75, 124, 124);
		create.setBorderPainted(false);
		create.setCursor(new Cursor(Cursor.HAND_CURSOR));
		create.setToolTipText("Añadir un nuevo usuario");
		ImageIcon image6 = new ImageIcon("Images\\menuInicial\\agregarClaro.png");
		create.setIcon(image6);
		mainPanel.add(create);

		schedule = new JButton();
		schedule.setCursor(new Cursor(Cursor.HAND_CURSOR));
		schedule.setBounds(414, 75, 124, 124);
		schedule.setBorderPainted(false);
		schedule.setToolTipText("Menú de citas medicas");
		ImageIcon image1 = new ImageIcon("Images\\menuInicial\\agendarClaro.png");
		schedule.setIcon(image1);
		mainPanel.add(schedule);

		turn = new JButton();
		turn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		turn.setBounds(262, 224, 124, 124);
		turn.setBorderPainted(false);
		turn.setToolTipText("Menú de turnos para especialistas");
		ImageIcon image2 = new ImageIcon("Images\\menuInicial\\turnoClaro.png");
		turn.setIcon(image2);
		mainPanel.add(turn);

		treatment = new JButton();
		treatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		treatment.setBounds( 416, 224, 124, 124);
		treatment.setBorderPainted(false);
		treatment.setToolTipText("Menú de tratamientos de pacientes");
		ImageIcon image3 = new ImageIcon("Images\\menuInicial\\tratamientoClaro.png");
		treatment.setIcon(image3);
		mainPanel.add(treatment);

		report = new JButton();
		report.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report.setBounds(261, 373, 124, 124);
		report.setBorderPainted(false);
		report.setToolTipText("Generar reporte semanal");
		ImageIcon image4 = new ImageIcon("Images\\menuInicial\\reporteClaro.png");
		report.setIcon(image4);
		mainPanel.add(report);

		users = new JButton();
		users.setCursor(new Cursor(Cursor.HAND_CURSOR));
		users.setBounds(414, 375, 124, 124);
		users.setBorderPainted(false);
		users.setToolTipText("Generar reporte semanal");
		ImageIcon imageU = new ImageIcon("Images\\menuInicial\\inicioC.png");
		users.setIcon(imageU);
		mainPanel.add(users);
		
		theme = new JButton();
		theme.setCursor(new Cursor(Cursor.HAND_CURSOR));
		theme.setBounds(41, 465, 82, 79);
		theme.setBorderPainted(false);
		theme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image5 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled5 = image5.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		theme.setIcon(new ImageIcon(scaled5));
		mainPanel.add(theme);

		exit = new JButton();
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setBounds(655, 450, 79, 79);
		exit.setBorderPainted(false);
		exit.setToolTipText("Salir del programa");
		ImageIcon imageE = new ImageIcon("Images\\backButtons\\salirProgramaC.png");
		Image scaledE = imageE.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		exit.setIcon(new ImageIcon(scaledE));
		mainPanel.add(exit);

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

	public JButton getCreate() {
		return create;
	}

	public void setCreate(JButton create) {
		this.create = create;
	}

	public JButton getUsersButton() {
		return users;
	}

	public void setUsersButton(JButton users) {
		this.users = users;
	}

}
