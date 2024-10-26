package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Treatments extends JFrame {
	private JPanel mainPanel, newTreatmentPanel, searchTreatmentPanel, finishTreatmentPanel;
	private JLabel background1, background2, background3, background4;
	private JButton home, themeMain, initTreatment, initSearchTreatment, initFinishTreatment;

	public Treatments() {
		window();
		panels();
		inputs();

		backgrounds();
		buttons();

		add(mainPanel);
		add(newTreatmentPanel);
		add(searchTreatmentPanel);
		add(finishTreatmentPanel);
		
		newTreatmentPanel.setVisible(false);
		searchTreatmentPanel.setVisible(false);
		finishTreatmentPanel.setVisible(false);
		//infoPanel.setVisible(false);
	}

	

	public void window() {
		setBounds(0, 0, 800, 600);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);

	}

	public void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

		newTreatmentPanel = new JPanel();
		newTreatmentPanel.setBounds(0, 0, 800, 600);
		newTreatmentPanel.setLayout(null);

		searchTreatmentPanel = new JPanel();
		searchTreatmentPanel.setBounds(0, 0, 800, 600);
		searchTreatmentPanel.setLayout(null);

		finishTreatmentPanel = new JPanel();
		finishTreatmentPanel.setBounds(0, 0, 800, 600);
		finishTreatmentPanel.setLayout(null);

	}
	private void backgrounds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTratamientos\\menuTratamientosC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);

		background2 = new JLabel();
		ImageIcon imagen1 = new ImageIcon("Images\\menuTratamientos\\nuevoTratamientoC.png");
		background2.setIcon(imagen1);
		background2.setBounds(0, 0, 790, 565);
		background2.setLayout(null);
		newTreatmentPanel.add(background2);

		background3 = new JLabel();
		ImageIcon imagen2 = new ImageIcon("Images\\menuTratamientos\\buscarTratamientoC.png");
		background3.setIcon(imagen2);
		background3.setBounds(0, 0, 790, 565);
		background3.setLayout(null);
		searchTreatmentPanel.add(background3);

		background4 = new JLabel();
		ImageIcon imagen3 = new ImageIcon("Images\\menuTratamientos\\finalizarTratamientoC.png");
		background4.setIcon(imagen3);
		background4.setBounds(0, 0, 790, 565);
		background4.setLayout(null);
		finishTreatmentPanel.add(background4);

	}
	public void inputs() {
		// TODO Auto-generated method stub

	}

	public void buttons() {
		themeMain = new JButton();
		themeMain.setBounds(41, 465, 82, 79);
		themeMain.setBorderPainted(false);
		themeMain.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image1 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled1 = image1.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		themeMain.setIcon(new ImageIcon(scaled1));
		mainPanel.add(themeMain);

		home = new JButton();
		home.setBounds(655, 465, 79, 79);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal");
		ImageIcon image5 = new ImageIcon("Images\\backButtons\\1.png");
		Image scaled5 = image5.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);
		
//entrar a cada funcion de ese menu 
		
		initTreatment = new JButton();
		initTreatment.setBounds(273, 102, 252, 120);
		ImageIcon image6 = new ImageIcon("Images\\menuTratamientos\\bNewClear.png");
		Image scaled6 = image6.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initTreatment.setIcon(new ImageIcon(scaled6));
		mainPanel.add(initTreatment);

		initSearchTreatment = new JButton();
		initSearchTreatment.setBounds(273, 234, 252, 120);
		ImageIcon image7 = new ImageIcon("Images\\menuTratamientos\\bSearchClear.png");
		Image scaled7 = image7.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initSearchTreatment.setIcon(new ImageIcon(scaled7));
		mainPanel.add(initSearchTreatment);

		initFinishTreatment = new JButton();
		initFinishTreatment.setBounds(273, 366, 252, 120);
		ImageIcon image8 = new ImageIcon("Images\\menuTratamientos\\bFinishClear.png");
		Image scaled8 = image8.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initFinishTreatment.setIcon(new ImageIcon(scaled8));
		mainPanel.add(initFinishTreatment);

	}

	public void textFields() {
		// TODO Auto-generated method stub

	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JPanel getNewTreatmentPanel() {
		return newTreatmentPanel;
	}

	public void setNewTreatmentPanel(JPanel newTreatmentPanel) {
		this.newTreatmentPanel = newTreatmentPanel;
	}

	public JPanel getSearchTreatmentPanel() {
		return searchTreatmentPanel;
	}

	public void setSearchTreatmentPanel(JPanel searchTreatmentPanel) {
		this.searchTreatmentPanel = searchTreatmentPanel;
	}

	public JPanel getFinishTreatmentPanel() {
		return finishTreatmentPanel;
	}

	public void setFinishTreatmentPanel(JPanel finishTreatmentPanel) {
		this.finishTreatmentPanel = finishTreatmentPanel;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JLabel getBackground2() {
		return background2;
	}

	public void setBackground2(JLabel background2) {
		this.background2 = background2;
	}

	public JLabel getBackground3() {
		return background3;
	}

	public void setBackground3(JLabel background3) {
		this.background3 = background3;
	}

	public JLabel getBackground4() {
		return background4;
	}

	public void setBackground4(JLabel background4) {
		this.background4 = background4;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JButton getThemeMain() {
		return themeMain;
	}

	public void setThemeMain(JButton themeMain) {
		this.themeMain = themeMain;
	}

	public JButton getInitTreatment() {
		return initTreatment;
	}

	public void setInitTreatment(JButton initTreatment) {
		this.initTreatment = initTreatment;
	}

	public JButton getInitSearchTreatment() {
		return initSearchTreatment;
	}

	public void setInitSearchTreatment(JButton initSearchTreatment) {
		this.initSearchTreatment = initSearchTreatment;
	}

	public JButton getInitFinishTreatment() {
		return initFinishTreatment;
	}

	public void setInitFinishTreatment(JButton initFinishTreatment) {
		this.initFinishTreatment = initFinishTreatment;
	}

}
