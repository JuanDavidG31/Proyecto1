package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class User extends JFrame {
	private JPanel mainPanel;
	private JTextField userName;
	private JPasswordField password;
	private JLabel background1;
	private JButton returnMenu, login,show,hide;

	public User() {
		window();
		panels();
		buttons();
		inputs();
		backgorunds();

		add(mainPanel);
	}

	private void window() {
		setBounds(0, 0, 480, 215);
		setTitle("");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);

	}

	private void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 480, 215);
		mainPanel.setLayout(null);

	}

	private void inputs() {
		userName = new JTextField();
		userName.setBounds(172, 43, 251, 30);
		userName.setCursor(new Cursor(Cursor.HAND_CURSOR));
		userName.setBorder(null);
		mainPanel.add(userName);

		password = new JPasswordField();
		password.setEchoChar('•');
		password.setBounds(172, 86, 251, 30);
		password.setCursor(new Cursor(Cursor.HAND_CURSOR));
		password.setBorder(null);
		mainPanel.add(password);

	}

	private void backgorunds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuUsuarios\\menuC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 470, 180);
		background1.setLayout(null);
		mainPanel.add(background1);

	}

	private void buttons() {

		login = new JButton();
		login.setBounds(167, 130, 157, 41);
		login.setBorderPainted(false);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		login.setToolTipText("Iniciar Sesión como especialista");
		ImageIcon imageRegister = new ImageIcon("Images\\menuUsuarios\\ingresarC.png");
		Image scaledRegister = imageRegister.getImage().getScaledInstance(157, 41, Image.SCALE_REPLICATE);
		login.setIcon(new ImageIcon(scaledRegister));
		mainPanel.add(login);

		show = new JButton();
		show.setBounds(424, 78, 42, 42);
		show.setBorderPainted(false);
		show.setCursor(new Cursor(Cursor.HAND_CURSOR));
		show.setToolTipText("Mostrar contraseña");
		ImageIcon imageS = new ImageIcon("Images\\menuUsuarios\\ShowC.png");
		Image scaledS = imageS.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		show.setIcon(new ImageIcon(scaledS));
		mainPanel.add(show);

		hide = new JButton();
		hide.setVisible(false);
		hide.setBounds(424, 78, 42, 42);
		hide.setBorderPainted(false);
		hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hide.setToolTipText("Ocultar Contraseña");
		ImageIcon imageh = new ImageIcon("Images\\menuUsuarios\\hideC.png");
		Image scaledh = imageh.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		hide.setIcon(new ImageIcon(scaledh));
		mainPanel.add(hide);
		
		returnMenu = new JButton();
		returnMenu.setBounds(334, 131, 42, 42);
		returnMenu.setBorderPainted(false);
		returnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		returnMenu.setToolTipText("Menú principal");
		ImageIcon imageR = new ImageIcon("Images\\backButtons\\back1.png");
		Image scaledR = imageR.getImage().getScaledInstance(42, 42, Image.SCALE_REPLICATE);
		returnMenu.setIcon(new ImageIcon(scaledR));
		mainPanel.add(returnMenu);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public JTextField getUserName() {
		return userName;
	}

	public void setUserName(JTextField userName) {
		this.userName = userName;
	}

	public JPasswordField getPassword() {
		return password;
	}

	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	public JLabel getBackground1() {
		return background1;
	}

	public void setBackground1(JLabel background1) {
		this.background1 = background1;
	}

	public JButton getReturnMenu() {
		return returnMenu;
	}

	public void setReturnMenu(JButton returnMenu) {
		this.returnMenu = returnMenu;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getShow() {
		return show;
	}

	public void setShow(JButton show) {
		this.show = show;
	}

	public JButton getHide() {
		return hide;
	}

	public void setHide(JButton hide) {
		this.hide = hide;
	}

}
