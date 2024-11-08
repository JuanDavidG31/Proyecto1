package co.edu.unbosque.util.order;

import java.util.Comparator;

import co.edu.unbosque.model.DoctorDTO;

public class idDoctorOrder implements Comparator<DoctorDTO> {

	@Override
	public int compare(DoctorDTO o1, DoctorDTO o2) {
		if (o1.getId() > o2.getId()) {
			return 1;
		} else if (o1.getId() < o2.getId()) {
			return -1;
		}
		return 0;
	}

}
