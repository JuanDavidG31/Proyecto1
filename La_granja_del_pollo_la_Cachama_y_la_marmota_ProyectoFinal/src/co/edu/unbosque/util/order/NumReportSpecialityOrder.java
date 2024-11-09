package co.edu.unbosque.util.order;

import java.util.Comparator;

import co.edu.unbosque.model.ReportMaxSpecialityDTO;

public class NumReportSpecialityOrder implements Comparator<ReportMaxSpecialityDTO> {

	@Override
	public int compare(ReportMaxSpecialityDTO o1, ReportMaxSpecialityDTO o2) {
		if (o1.getNumAppo() < o2.getNumAppo()) {
			return 1;
		} else if (o1.getNumAppo() > o2.getNumAppo()) {
			return -1;
		}
		return 0;
	}

}
