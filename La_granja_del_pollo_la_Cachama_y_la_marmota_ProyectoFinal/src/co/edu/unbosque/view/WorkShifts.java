package co.edu.unbosque.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class WorkShifts extends JFrame {
	private JPanel mainPanel, panelSelect, panelChange;
	private JLabel background1, background2, background3;
	private JButton home, changeTurn, initTurn, themeMain, generateTurns, homeTurn1, selectTurnTheme, generateChange,
			selectTurnTheme2, homeTurn2;
	private JDateChooser startDate, finishDate;
	private JTextField especialista1, especialista2, turnoActual;

	public WorkShifts() {
		window();
		panels();
		inputs();
		buttons();
		calendar();
		backgrounds();

		panelChange.setVisible(false);
		panelSelect.setVisible(false);

		add(mainPanel);
		add(panelSelect);
		add(panelChange);

	}

	private void calendar() {
		startDate = new JDateChooser();
		startDate.setBounds(106, 241, 251, 30);
		startDate.setBorder(null);
		startDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelSelect.add(startDate);

		// fecha de cita para el reagendar
		finishDate = new JDateChooser();
		finishDate.setBounds(440, 241, 251, 30);
		finishDate.setBorder(null);
		finishDate.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelSelect.add(finishDate);

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
		setBounds(0, 0, 800, 600);
		setLocationRelativeTo(null);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		panelChange = new JPanel();
		panelChange.setBounds(0, 0, 800, 600);
		panelChange.setLayout(null);
	}

	public void inputs() {
		especialista1 = new JTextField();

		especialista2 = new JTextField();

		turnoActual = new JTextField();

	}

	public void buttons() {
		home = new JButton();
		home.setBounds(655, 465, 79, 79);
		home.setBorderPainted(false);
		home.setToolTipText("Menú principal");
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ImageIcon image5 = new ImageIcon("Images\\backButtons\\1.png");
		Image scaled5 = image5.getImage().getScaledInstance(79, 79, Image.SCALE_REPLICATE);
		home.setIcon(new ImageIcon(scaled5));
		mainPanel.add(home);

		changeTurn = new JButton();
		changeTurn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changeTurn.setToolTipText("A");
		changeTurn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		changeTurn.setBounds(274, 290, 252, 120);
		ImageIcon imageInitChange = new ImageIcon("Images\\menuTurnos\\3.png");
		Image scaledInitChange = imageInitChange.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		changeTurn.setIcon(new ImageIcon(scaledInitChange));
		mainPanel.add(changeTurn);

		initTurn = new JButton();
		initTurn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		initTurn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		initTurn.setBounds(274, 157, 252, 121);
		initTurn.setToolTipText("D");
		ImageIcon imageTurn = new ImageIcon("Images\\menuTurnos\\1.png");
		Image scaledTurn = imageTurn.getImage().getScaledInstance(252, 120, Image.SCALE_REPLICATE);
		initTurn.setIcon(new ImageIcon(scaledTurn));
		mainPanel.add(initTurn);

		themeMain = new JButton();
		themeMain.setBounds(41, 465, 82, 79);
		themeMain.setBorderPainted(false);
		themeMain.setCursor(new Cursor(Cursor.HAND_CURSOR));
		themeMain.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image1 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled1 = image1.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		themeMain.setIcon(new ImageIcon(scaled1));
		mainPanel.add(themeMain);

		generateTurns = new JButton();
		generateTurns.setCursor(new Cursor(Cursor.HAND_CURSOR));
		generateTurns.setBounds(311, 421, 157, 41);
		generateTurns.setBorderPainted(false);
		generateTurns.setCursor(new Cursor(Cursor.HAND_CURSOR));
		generateTurns.setToolTipText("Registrar Tratamiento");
		ImageIcon imageRegister = new ImageIcon("Images\\menuTurnos\\turnoC.png");
		Image scaledRegister = imageRegister.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		generateTurns.setIcon(new ImageIcon(scaledRegister));
		panelSelect.add(generateTurns);

		generateChange = new JButton();
		generateChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
		generateChange.setBounds(311, 421, 157, 41);
		generateChange.setBorderPainted(false);
		generateChange.setCursor(new Cursor(Cursor.HAND_CURSOR));
		generateChange.setToolTipText("Registrar Tratamiento");
		ImageIcon imageChange = new ImageIcon("Images\\menuTurnos\\cambioC.png");
		Image scaledChange = imageChange.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		generateChange.setIcon(new ImageIcon(scaledChange));
		panelChange.add(generateChange);

		homeTurn1 = new JButton();
		homeTurn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeTurn1.setBounds(486, 420, 42, 42);
		homeTurn1.setBorderPainted(false);
		homeTurn1.setToolTipText("Menú principal");
		ImageIcon imageHome = new ImageIcon("Images\\backButtons\\m1.png");
		Image scaledHome = imageHome.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		homeTurn1.setIcon(new ImageIcon(scaledHome));
		panelSelect.add(homeTurn1);

		homeTurn2 = new JButton();
		homeTurn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeTurn2.setBounds(486, 418, 42, 42);
		homeTurn2.setBorderPainted(false);
		homeTurn2.setToolTipText("Menú principal");
		homeTurn2.setIcon(new ImageIcon(scaledHome));
		panelChange.add(homeTurn2);

		selectTurnTheme = new JButton();
		selectTurnTheme.setBounds(41, 465, 82, 79);
		selectTurnTheme.setBorderPainted(false);
		selectTurnTheme.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectTurnTheme.setToolTipText("Cambiar a tema oscuro");
		ImageIcon image2 = new ImageIcon("Images\\CambioTema\\cambioOscuro.png");
		Image scaled2 = image2.getImage().getScaledInstance(82, 79, Image.SCALE_REPLICATE);
		selectTurnTheme.setIcon(new ImageIcon(scaled2));
		panelSelect.add(selectTurnTheme);

		selectTurnTheme2 = new JButton();
		selectTurnTheme2.setBounds(41, 465, 82, 79);
		selectTurnTheme2.setBorderPainted(false);
		selectTurnTheme2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		selectTurnTheme2.setToolTipText("Cambiar a tema oscuro");
		selectTurnTheme2.setIcon(new ImageIcon(scaled2));
		panelChange.add(selectTurnTheme2);

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

	public JButton getInitTurn() {
		return initTurn;
	}

	public void setInitTurn(JButton initTurn) {
		this.initTurn = initTurn;
	}

	public JButton getThemeMain() {
		return themeMain;
	}

	public void setThemeMain(JButton themeMain) {
		this.themeMain = themeMain;
	}

	public JLabel getBackground3() {
		return background3;
	}

	public void setBackground3(JLabel background3) {
		this.background3 = background3;
	}

	public JButton getGenerateTurns() {
		return generateTurns;
	}

	public void setGenerateTurns(JButton generateTurns) {
		this.generateTurns = generateTurns;
	}

	public JButton getHomeTurn1() {
		return homeTurn1;
	}

	public void setHomeTurn1(JButton homeTurn1) {
		this.homeTurn1 = homeTurn1;
	}

	public JButton getSelectTurnTheme() {
		return selectTurnTheme;
	}

	public void setSelectTurnTheme(JButton selectTurnTheme) {
		this.selectTurnTheme = selectTurnTheme;
	}

	public JDateChooser getStartDate() {
		return startDate;
	}

	public void setStartDate(JDateChooser startDate) {
		this.startDate = startDate;
	}

	public JDateChooser getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(JDateChooser finishDate) {
		this.finishDate = finishDate;
	}

	public JButton getGenerateChange() {
		return generateChange;
	}

	public void setGenerateChange(JButton generateChange) {
		this.generateChange = generateChange;
	}

	public JButton getHomeTurn2() {
		return homeTurn2;
	}

	public void setHomeTurn2(JButton homeTurn2) {
		this.homeTurn2 = homeTurn2;
	}

	public JButton getSelectTurnTheme2() {
		return selectTurnTheme2;
	}

	public void setSelectTurnTheme2(JButton selectTurnTheme2) {
		this.selectTurnTheme2 = selectTurnTheme2;
	}

}
