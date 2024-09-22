package co.edu.unbosque.view;

public class ViewFacade {
	
	PantallaInicio pi;
	MenuAereolinea ma;
	
	public ViewFacade() {
		pi = new PantallaInicio();
		ma = new MenuAereolinea();
	}

	public PantallaInicio getPi() {
		return pi;
	}

	public void setPi(PantallaInicio pi) {
		this.pi = pi;
	}

	public MenuAereolinea getMa() {
		return ma;
	}

	public void setMa(MenuAereolinea ma) {
		this.ma = ma;
	}
	
	
	
	

}
