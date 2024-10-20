package co.edu.unbosque.view;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Schedule extends JFrame {
	private JPanel mainPanel;
	private JTextField name, email;
	private JComboBox<String> doctor, specialty;

	public Schedule() {
		window();
		panels();
		inputs();
		comboBox();
		headlines();
		buttons();

		add(mainPanel);
	}

	public void panels() {
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 600);
		mainPanel.setLayout(null);

	}

	private void comboBox() {
		doctor = new JComboBox<String>();
		mainPanel.add(doctor);

		specialty = new JComboBox<String>();
		mainPanel.add(specialty);

	}

	public void window() {
		setBounds(0, 0, 800, 600); // Window position and size (where it starts in x, where it starts in y,
									// wide,high)
		setTitle(""); // tittle on window
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Close window and close the software
		setResizable(false);
		setLayout(null);

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
