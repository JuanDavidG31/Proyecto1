package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InternationalFlight;
import co.edu.unbosque.model.InternationalFlightDTO;
import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;

public class DataMapper {

	// International Flight

	public static InternationalFlight InternationalFlightDTOToInternationalFlight(InternationalFlightDTO dto) {
		InternationalFlight entity;
		entity = new InternationalFlight(dto.getCompanyName(), dto.getPassengersNumber(), dto.getNameCaptain(),
				dto.getNameSecondCommand(), dto.getDepartureTime(), dto.getArrivalTime(), dto.getFuelWeight(), dto.getId(),
				dto.isTurbine(), dto.isTurboProp());
		return entity;
	}

	public static InternationalFlightDTO InternationalFlightToInternationalFlightDTO(InternationalFlight entity) {
		InternationalFlightDTO dto;
		dto = new InternationalFlightDTO(entity.getCompanyName(), entity.getPassengersNumber(), entity.getNameCaptain(),
				entity.getNameSecondCommand(), entity.getDepartureTime(), entity.getArrivalTime(),
				entity.getFuelWeight(),entity.getId(), entity.isTurbine(), entity.isTurboProp());
		return dto;
	}

	public static ArrayList<InternationalFlightDTO> listaInternationalFlightToListaInternationalFlightDTO(
			ArrayList<InternationalFlight> entityList) {
		ArrayList<InternationalFlightDTO> dtoList = new ArrayList<>();
		for (InternationalFlight g : entityList) {
			dtoList.add(new InternationalFlightDTO(g.getCompanyName(), g.getPassengersNumber(), g.getNameCaptain(),
					g.getNameSecondCommand(), g.getDepartureTime(), g.getArrivalTime(), g.getFuelWeight(),g.getId(),
					g.isTurbine(), g.isTurboProp()));
		}
		return dtoList;
	}

	public static ArrayList<InternationalFlight> listaInternationalFlightDTOToListaInternationalFlight(
			ArrayList<InternationalFlightDTO> dtoList) {
		ArrayList<InternationalFlight> entityList = new ArrayList<>();
		for (InternationalFlightDTO d : dtoList) {
			entityList.add(new InternationalFlight(d.getCompanyName(), d.getPassengersNumber(), d.getNameCaptain(),
					d.getNameSecondCommand(), d.getDepartureTime(), d.getArrivalTime(), d.getFuelWeight(),d.getId(),
					d.isTurbine(), d.isTurboProp()));
		}
		return entityList;
	}

	// National Flight

	public static NationalFlight NationalFlightDTOToNationalFlight(NationalFlightDTO dto) {
		NationalFlight entity;
		entity = new NationalFlight(dto.getCompanyName(), dto.getPassengersNumber(), dto.getNameCaptain(),
				dto.getNameSecondCommand(), dto.getDepartureTime(), dto.getArrivalTime(), dto.getFuelWeight(),dto.getId(),
				dto.isVisa());
		return entity;
	}

	public static NationalFlightDTO NationalFlightToNationalFlightDTO(NationalFlight entity) {
		NationalFlightDTO dto;
		dto = new NationalFlightDTO(entity.getCompanyName(), entity.getPassengersNumber(), entity.getNameCaptain(),
				entity.getNameSecondCommand(), entity.getDepartureTime(), entity.getArrivalTime(),
				entity.getFuelWeight(),entity.getId(), entity.isVisa());
		return dto;
	}

	public static ArrayList<NationalFlightDTO> listaNationalFlightToListaNationalFlightDTO(
			ArrayList<NationalFlight> entityList) {
		ArrayList<NationalFlightDTO> dtoList = new ArrayList<>();
		for (NationalFlight g : entityList) {
			dtoList.add(new NationalFlightDTO(g.getCompanyName(), g.getPassengersNumber(), g.getNameCaptain(),
					g.getNameSecondCommand(), g.getDepartureTime(), g.getArrivalTime(), g.getFuelWeight(),g.getId(), g.isVisa()));
		}
		return dtoList;
	}

	public static ArrayList<NationalFlight> listaNationalFlightDTOToListaNationalFlight(
			ArrayList<NationalFlightDTO> dtoList) {
		ArrayList<NationalFlight> entityList = new ArrayList<>();
		for (NationalFlightDTO d : dtoList) {
			entityList.add(new NationalFlight(d.getCompanyName(), d.getPassengersNumber(), d.getNameCaptain(),
					d.getNameSecondCommand(), d.getDepartureTime(), d.getArrivalTime(), d.getFuelWeight(),d.getId(), d.isVisa()));
		}
		return entityList;
	}

}