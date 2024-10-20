package co.edu.unbosque.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Schedule extends JFrame {
	private JPanel mainPanel;
	private JTextField name, email;
	private JComboBox<String> doctor, specialty;
	private JButton generate;

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
		doctor.setBounds(100, 100, 150, 100);
		doctor.addItem("medico");
		doctor.addItem("nombre 1");
		doctor.addItem("nombre 2");
		doctor.addItem("nombre 3");
		doctor.addItem("nombre 4");
		doctor.addItem("nombre 5");
		doctor.addItem("nombre 6");
		doctor.addItem("nombre 7");
		mainPanel.add(doctor);

		specialty = new JComboBox<String>();
		specialty.setBounds(200, 200, 150, 100);
		specialty.addItem("especialidad");
		specialty.addItem("1");
		specialty.addItem("2");
		specialty.addItem("3");
		specialty.addItem("4");
		specialty.addItem("5");
		specialty.addItem("6");
		specialty.addItem("7");
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
		name = new JTextField("nombre");
		name.setBounds(300, 300, 150, 50);
		mainPanel.add(name);

		email = new JTextField("correo electronico");
		email.setBounds(400, 400, 150, 50);
		mainPanel.add(email);

	}

	public void buttons() {
		generate= new JButton("Agendar");
		generate.setBounds(500, 500, 100, 50);
		mainPanel.add(generate);

	}

	public void textFields() {
		// TODO Auto-generated method stub

	}

	public void headlines() {
		// TODO Auto-generated method stub

	}

}
