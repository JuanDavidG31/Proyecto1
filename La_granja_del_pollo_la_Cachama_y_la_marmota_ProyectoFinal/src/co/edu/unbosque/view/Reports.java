package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Reports extends JFrame {
	private JPanel mainPanel;
	private JButton exit,theme,report1,report2,report3,report4,report5,report6;
	private JLabel background1;

	public Reports() {
		window();
		panels();
		buttons();
		images();

		add(mainPanel);
	}

	private void window() {
		setBounds(0, 0, 800, 600);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	private void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

	}

	private void buttons() {
		report1 = new JButton("1");
		report1.setBounds(216, 147, 124, 124);
		report1.setBorderPainted(false);
		report1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report1.setToolTipText("Añadir un nuevo usuario");
		ImageIcon image1 = new ImageIcon("Images\\reportes\\.png");
		report1.setIcon(image1);
		mainPanel.add(report1);

		report2 = new JButton("2");
		report2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report2.setBounds(367, 147, 124, 124);
		report2.setBorderPainted(false);
		report2.setToolTipText("Menú de citas medicas");
		ImageIcon image2 = new ImageIcon("Images\\reportes\\.png");
		report2.setIcon(image2);
		mainPanel.add(report2);

		report3 = new JButton("3");
		report3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report3.setBounds(518, 147, 124, 124);
		report3.setBorderPainted(false);
		report3.setToolTipText("Menú de turnos para especialistas");
		ImageIcon image3 = new ImageIcon("Images\\reportes\\.png");
		report3.setIcon(image3);
		mainPanel.add(report3);

		report4 = new JButton("4");
		report4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report4.setBounds(216, 294, 124, 124);
		report4.setBorderPainted(false);
		report4.setToolTipText("Menú de tratamientos de pacientes");
		ImageIcon image4 = new ImageIcon("Images\\reportes\\.png");
		report4.setIcon(image4);
		mainPanel.add(report4);

		report5 = new JButton("5");
		report5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report5.setBounds(367, 294, 124, 124);
		report5.setBorderPainted(false);
		report5.setToolTipText("Generar reporte semanal");
		ImageIcon image5 = new ImageIcon("Images\\reportes\\reporteClaro.png");
		report5.setIcon(image5);
		mainPanel.add(report5);
		
		report6 = new JButton("6");
		report6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		report6.setBounds(518, 294, 124, 124);
		report6.setBorderPainted(false);
		report6.setToolTipText("Generar reporte semanal");
		ImageIcon image6 = new ImageIcon("Images\\reportes\\reporteClaro.png");
		report6.setIcon(image6);
		mainPanel.add(report6);

		theme = new JButton();
		theme.setCursor(new Cursor(Cursor.HAND_CURSOR));
		theme.setBounds(41, 465, 82, 79);
		theme.setBorderPainted(false);
		theme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon imageTheme = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaledTheme = imageTheme.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		theme.setIcon(new ImageIcon(scaledTheme));
		mainPanel.add(theme);

		exit = new JButton();
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setBounds(655, 463, 79, 79);
		exit.setBorderPainted(false);
		exit.setToolTipText("Salir del programa");
		ImageIcon imageE = new ImageIcon("Images\\backButtons\\salirProgramaC.png");
		Image scaledE = imageE.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		exit.setIcon(new ImageIcon(scaledE));
		mainPanel.add(exit);

	}

	private void images() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\reportes\\menuC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JButton getTheme() {
		return theme;
	}

	public void setTheme(JButton theme) {
		this.theme = theme;
	}

	public JButton getReport1() {
		return report1;
	}

	public void setReport1(JButton report1) {
		this.report1 = report1;
	}

	public JButton getReport2() {
		return report2;
	}

	public void setReport2(JButton report2) {
		this.report2 = report2;
	}

	public JButton getReport3() {
		return report3;
	}

	public void setReport3(JButton report3) {
		this.report3 = report3;
	}

	public JButton getReport4() {
		return report4;
	}

	public void setReport4(JButton report4) {
		this.report4 = report4;
	}

	public JButton getReport5() {
		return report5;
	}

	public void setReport5(JButton report5) {
		this.report5 = report5;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JButton getReport6() {
		return report6;
	}

	public void setReport6(JButton report6) {
		this.report6 = report6;
	}
	

}
