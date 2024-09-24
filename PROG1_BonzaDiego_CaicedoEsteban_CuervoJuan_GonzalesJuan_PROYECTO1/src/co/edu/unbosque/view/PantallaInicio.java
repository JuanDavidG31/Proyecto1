package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PantallaInicio extends JFrame{
	
	private JButton btnCliente, btnAereolinea;
	private JLabel lblFondo;
	
	public PantallaInicio() {
		ventana();
		labels();
		botones();
	}
	
	public void ventana() {
		setBounds(50, 50, 700, 560);
		setTitle("Aeropuerto el Dorado");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
	}
	
	public void botones() {
		ImageIcon btnClienteImg = new ImageIcon("Images\\btnCliente.png");
		btnCliente = new JButton(btnClienteImg);
		btnCliente.setBounds(140, 320, 418, 30);
		add(btnCliente);
		
		ImageIcon btnAereolineaImg = new ImageIcon("Images\\btnAerolinea.png");
		btnAereolinea = new JButton(btnAereolineaImg);
		btnAereolinea.setBounds(140, 250, 418, 30);
		add(btnAereolinea);
	}
	
	public void labels() {
		lblFondo = new JLabel(new ImageIcon("Images\\pantallaInicioDorado.png"));
		setContentPane(lblFondo);
	}

	public JButton getBtnCliente() {
		return btnCliente;
	}

	public void setBtnCliente(JButton btnCliente) {
		this.btnCliente = btnCliente;
	}

	public JButton getBtnAereolinea() {
		return btnAereolinea;
	}

	public void setBtnAereolinea(JButton btnAereolinea) {
		this.btnAereolinea = btnAereolinea;
	}

	public JLabel getLblFondo() {
		return lblFondo;
	}

	public void setLblFondo(JLabel lblFondo) {
		this.lblFondo = lblFondo;
	}
	
	

}
