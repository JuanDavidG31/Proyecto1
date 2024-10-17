package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorkShifts extends JFrame {
	private JPanel mainPanel;

	public WorkShifts() {
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
		// TODO Auto-generated method stub

	}

	public void buttons() {
		// TODO Auto-generated method stub

	}

	public void textFields() {
		// TODO Auto-generated method stub

	}

	public void headlines() {
		// TODO Auto-generated method stub

	}
}
