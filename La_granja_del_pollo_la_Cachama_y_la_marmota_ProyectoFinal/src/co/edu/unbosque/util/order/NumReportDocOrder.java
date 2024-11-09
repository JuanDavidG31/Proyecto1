package co.edu.unbosque.util.order;

import java.util.Comparator;

import co.edu.unbosque.model.ReportMaxDoctorDTO;

public class NumReportDocOrder implements Comparator<ReportMaxDoctorDTO> {

	@Override
	public int compare(ReportMaxDoctorDTO o1, ReportMaxDoctorDTO o2) {
		if (o1.getNumAppo() < o2.getNumAppo()) {
			return 1;
		} else if (o1.getNumAppo() > o2.getNumAppo()) {
			return -1;
		}
		return 0;
	}

}
