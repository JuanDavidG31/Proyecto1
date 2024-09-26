package co.edu.unbosque.view;

/**
 * La clase ViewFacade actúa como una fachada que facilita la interacción con las vistas
 * de la aplicación, simplificando el acceso a las interfaces gráficas de usuario.
 * 
 * Esta clase encapsula las vistas {@link PantallaInicio} y {@link MenuAereolinea}, 
 * proporcionando métodos de acceso y modificación para cada una de ellas.
 * 
 * El patrón de diseño "Fachada" se utiliza para ocultar la complejidad del sistema
 * proporcionando una interfaz simple a las operaciones más complejas.
 * 
 */
public class ViewFacade {
    
    // Instancia de PantallaInicio, que representa la ventana inicial de la aplicación.
    private PantallaInicio pi;
    
    // Instancia de MenuAereolinea, que representa el menú de la aerolínea en la aplicación.
    private MenuAereolinea ma;

    /**
     * Constructor de la clase ViewFacade.
     * Inicializa las instancias de PantallaInicio y MenuAereolinea.
     */
    public ViewFacade() {
        pi = new PantallaInicio();
        ma = new MenuAereolinea();
    }

    /**
     * Obtiene la instancia de PantallaInicio.
     * 
     * @return la instancia de PantallaInicio.
     */
    public PantallaInicio getPi() {
        return pi;
    }

    /**
     * Asigna una nueva instancia de PantallaInicio.
     * 
     * @param pi la nueva instancia de PantallaInicio a asignar.
     */
    public void setPi(PantallaInicio pi) {
        this.pi = pi;
    }

    /**
     * Obtiene la instancia de MenuAereolinea.
     * 
     * @return la instancia de MenuAereolinea.
     */
    public MenuAereolinea getMa() {
        return ma;
    }

    /**
     * Asigna una nueva instancia de MenuAereolinea.
     * 
     * @param ma la nueva instancia de MenuAereolinea a asignar.
     */
    public void setMa(MenuAereolinea ma) {
        this.ma = ma;
    }

}
