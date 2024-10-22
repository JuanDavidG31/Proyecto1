package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomeWindow extends JFrame {
	private JPanel mainPanel;
	private JButton schedule;

	public HomeWindow() {
		window();
		panels();
		inputs();
		headlines();
		buttons();

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

	public void inputs() {
		

	}

	public void buttons() {
		schedule = new JButton("agendar");
		schedule.setBounds(50, 50, 150, 100);
		mainPanel.add(schedule);

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
	
}
