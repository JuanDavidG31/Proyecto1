package co.edu.unbosque.util.order;

import java.util.Comparator;

import co.edu.unbosque.model.ShiftsDTO;

public class nameSpecialityTurnOrder implements Comparator<ShiftsDTO> {

	@Override
	public int compare(ShiftsDTO o1, ShiftsDTO o2) {
		if (o1.getSpecialty().compareTo(o2.getSpecialty()) > 0) {
			return 1;
		} else if (o1.getSpecialty().compareTo(o2.getSpecialty()) < 0) {
			return -1;
		}
		return 0;
	}

}
