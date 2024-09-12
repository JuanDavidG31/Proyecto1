package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.InternationalFlightDAO;
import co.edu.unbosque.model.persistence.NationalFlightDAO;

public class ModelFacade {
	private InternationalFlightDAO international;
	private NationalFlightDAO national;

	public ModelFacade() {
		international = new InternationalFlightDAO();
		national = new NationalFlightDAO();
	}

	public InternationalFlightDAO getInternational() {
		return international;
	}

	public void setInternational(InternationalFlightDAO international) {
		this.international = international;
	}

	public NationalFlightDAO getNational() {
		return national;
	}

	public void setNational(NationalFlightDAO national) {
		this.national = national;
	}

}
