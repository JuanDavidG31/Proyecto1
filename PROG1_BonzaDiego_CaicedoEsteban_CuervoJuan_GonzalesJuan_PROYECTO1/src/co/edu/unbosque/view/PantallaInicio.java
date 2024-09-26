package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase PantallaInicio representa la ventana inicial de la aplicación de Aeropuerto el Dorado.
 * 
 * Esta clase hereda de JFrame y tiene dos botones (btnCliente y btnAereolinea) y un fondo.
 * Los botones permiten la interacción con la interfaz, permitiendo al usuario escoger entre las opciones de cliente o aerolínea.
 * El fondo es una imagen que decora la ventana principal.
 * 
 * @author [Nombre del autor]
 */
public class PantallaInicio extends JFrame {

    // Botón que representa la opción para los clientes
    private JButton btnCliente;
    
    // Botón que representa la opción para las aerolíneas
    private JButton btnAereolinea;
    
    // Etiqueta para el fondo de la pantalla
    private JLabel lblFondo;

    /**
     * Constructor de la clase PantallaInicio.
     * Inicializa la ventana, los botones y el fondo.
     */
    public PantallaInicio() {
        ventana();
        labels();
        botones();
    }

    /**
     * Configura las propiedades de la ventana, como su tamaño, título, posición y comportamiento de cierre.
     * Establece la ventana con dimensiones de 700x560 píxeles y desactiva el redimensionado.
     */
    public void ventana() {
        setBounds(50, 50, 700, 560);
        setTitle("Aeropuerto el Dorado");
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false);
        setLayout(null);
    }

    /**
     * Crea los botones de cliente y aerolínea, les asigna sus imágenes y los agrega a la ventana.
     * Los botones se posicionan dentro del marco utilizando coordenadas y tamaños específicos.
     */
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

    /**
     * Configura el fondo de la ventana con una imagen y la asigna como contenido principal.
     */
    public void labels() {
        lblFondo = new JLabel(new ImageIcon("Images\\pantallaInicioDorado.png"));
        setContentPane(lblFondo);
    }

    /**
     * Retorna el botón asociado con la opción de cliente.
     * 
     * @return el botón de cliente.
     */
    public JButton getBtnCliente() {
        return btnCliente;
    }

    /**
     * Asigna un nuevo botón para la opción de cliente.
     * 
     * @param btnCliente el nuevo botón a asignar.
     */
    public void setBtnCliente(JButton btnCliente) {
        this.btnCliente = btnCliente;
    }

    /**
     * Retorna el botón asociado con la opción de aerolínea.
     * 
     * @return el botón de aerolínea.
     */
    public JButton getBtnAereolinea() {
        return btnAereolinea;
    }

    /**
     * Asigna un nuevo botón para la opción de aerolínea.
     * 
     * @param btnAereolinea el nuevo botón a asignar.
     */
    public void setBtnAereolinea(JButton btnAereolinea) {
        this.btnAereolinea = btnAereolinea;
    }

    /**
     * Retorna la etiqueta del fondo de la ventana.
     * 
     * @return la etiqueta del fondo.
     */
    public JLabel getLblFondo() {
        return lblFondo;
    }

    /**
     * Asigna una nueva etiqueta de fondo.
     * 
     * @param lblFondo la nueva etiqueta de fondo.
     */
    public void setLblFondo(JLabel lblFondo) {
        this.lblFondo = lblFondo;
    }

}