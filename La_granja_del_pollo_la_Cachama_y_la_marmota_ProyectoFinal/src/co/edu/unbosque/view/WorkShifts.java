package co.edu.unbosque.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorkShifts extends JFrame {
	private JPanel mainPanel;
	private JLabel background1;
	private JButton home;

	public WorkShifts() {
		window();
		panels();
		inputs();
		headlines();
		buttons();
		backgrounds();
		

		add(mainPanel);
	}

	private void backgrounds() {
		background1 = new JLabel();
		ImageIcon imagen = new ImageIcon("Images\\menuTurnos\\menuTurnosC.png");
		background1.setIcon(imagen);
		background1.setBounds(0, 0, 790, 565);
		background1.setLayout(null);
		mainPanel.add(background1);
		
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

}
