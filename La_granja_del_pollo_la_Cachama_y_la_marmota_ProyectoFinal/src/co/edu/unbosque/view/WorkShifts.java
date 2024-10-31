package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkShifts extends JFrame {
	private JPanel mainPanel,panelSelect,panelChange;
	private JLabel background1,background2,background3;
	private JButton home,changeTurn,homeTurn,themeMain;


	public WorkShifts() {
		window();
		panels();
		inputs();
		headlines();
		buttons();
		backgrounds();
		
		panelChange.setVisible(false);
		panelSelect.setVisible(false);

		add(mainPanel);
		add(panelSelect);
		add(panelChange);
	
	}

	private void backgrounds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTurnos\\menuTurnosC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);
		
		background2 = new JLabel();
		ImageIcon imagen2 = new ImageIcon("Images\\menuTurnos\\seleccionarFechaC.png");
		background2.setIcon(imagen2);
		background2.setBounds(0, 0, 790, 565);
		background2.setLayout(null);
		panelSelect.add(background2);
		
		background3 = new JLabel();
		ImageIcon imagen3 = new ImageIcon("Images\\menuTurnos\\cambioTurnoC.png");
		background3.setIcon(imagen3);
		background3.setBounds(0, 0, 790, 565);
		background3.setLayout(null);
		panelChange.add(background3);
		
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

		panelSelect = new JPanel();
		panelSelect.setBounds(0, 0, 800, 600);
		panelSelect.setLayout(null);
		
		panelChange= new JPanel();
		panelChange.setBounds(0, 0, 800, 600);
		panelChange.setLayout(null);
	}

	public void inputs() {
		// TODO Auto-generated method stub

	}

	public void buttons() {
		home = new JButton();
		home.setBounds(655, 465, 79, 79);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal");
		ImageIcon image5 = new ImageIcon("Images\\backButtons\\1.png");
		Image scaled5 = image5.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);
		
		changeTurn= new JButton();
		changeTurn.setToolTipText("A");
		changeTurn.setBounds(274, 290, 252, 120);
		ImageIcon imageChange = new ImageIcon("Images\\menuTurnos\\3.png");
		Image scaledChange = imageChange.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		changeTurn.setIcon(new ImageIcon(scaledChange));
		mainPanel.add(changeTurn);
		
		homeTurn= new JButton();
		homeTurn.setBounds(274, 157, 252, 121);
		homeTurn.setToolTipText("D");
		ImageIcon imageTurn = new ImageIcon("Images\\menuTurnos\\1.png");
		Image scaledTurn = imageTurn.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		homeTurn.setIcon(new ImageIcon(scaledTurn));
		mainPanel.add(homeTurn);
		
		themeMain = new JButton();
		themeMain.setBounds(41, 465, 82, 79);
		themeMain.setBorderPainted(false);
		themeMain.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image1 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled1 = image1.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		themeMain.setIcon(new ImageIcon(scaled1));
		mainPanel.add(themeMain);

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

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JPanel getPanelSelect() {
		return panelSelect;
	}

	public void setPanelSelect(JPanel panelSelect) {
		this.panelSelect = panelSelect;
	}

	public JPanel getPanelChange() {
		return panelChange;
	}

	public void setPanelChange(JPanel panelChange) {
		this.panelChange = panelChange;
	}

	public JLabel getBackground2() {
		return background2;
	}

	public void setBackground2(JLabel background2) {
		this.background2 = background2;
	}

	public JButton getChangeTurn() {
		return changeTurn;
	}

	public void setChangeTurn(JButton changeTurn) {
		this.changeTurn = changeTurn;
	}

	public JButton getHomeTurn() {
		return homeTurn;
	}

	public void setHomeTurn(JButton homeTurn) {
		this.homeTurn = homeTurn;
	}

	public JButton getThemeMain() {
		return themeMain;
	}

	public void setThemeMain(JButton themeMain) {
		this.themeMain = themeMain;
	}

}
