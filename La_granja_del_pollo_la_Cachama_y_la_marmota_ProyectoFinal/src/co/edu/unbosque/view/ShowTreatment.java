package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowTreatment extends JFrame {

	private JPanel mainPanel;
	private JComboBox<String> treatment;
	private JLabel background1;
	private JButton selectTreatment, home;

	public ShowTreatment() {
		window();
		panels();
		comboBox();
		buttons();
		backgorunds();

		add(mainPanel);

	}

	private void backgorunds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTratamientos\\seleccionarTratamientoC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 470, 180);
		background1.setLayout(null);
		mainPanel.add(background1);

	}

	private void buttons() {
		selectTreatment = new JButton();
		selectTreatment.setBounds(167, 130, 157, 41);
		selectTreatment.setBorderPainted(false);
		selectTreatment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectTreatment.setToolTipText("Seleccionar Tratamiento a mostrar");
		ImageIcon imageRegister = new ImageIcon("Images\\menuTratamientos\\selectC.png");
		Image scaledRegister = imageRegister.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		selectTreatment.setIcon(new ImageIcon(scaledRegister));
		mainPanel.add(selectTreatment);

		home = new JButton();
		home.setBounds(340, 130, 42, 42);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal de tratamientos");
		ImageIcon image5 = new ImageIcon("Images\\menuTratamientos\\back1.png");
		Image scaled5 = image5.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);
	}

	private void comboBox() {
		treatment = new JComboBox<String>();
		treatment.setBounds(176, 70, 251, 30);
		treatment.setBorder(null);
		treatment.addItem("");
		mainPanel.add(treatment);
	}

	private void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 480, 215);
		mainPanel.setLayout(null);

	}

	public void window() {
		setBounds(0, 0, 480, 215);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JComboBox<String> getTreatment() {
		return treatment;
	}

	public void setTreatment(JComboBox<String> treatment) {
		this.treatment = treatment;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JButton getSelectTreatment() {
		return selectTreatment;
	}

	public void setSelectTreatment(JButton selectTreatment) {
		this.selectTreatment = selectTreatment;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

}
