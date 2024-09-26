package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.InternationalFlight;
import co.edu.unbosque.model.InternationalFlightDTO;
import co.edu.unbosque.model.NationalFlight;
import co.edu.unbosque.model.NationalFlightDTO;

/**
 * La clase DataMapper proporciona métodos para transformar objetos de las clases
 * de entidad (NationalFlight, InternationalFlight) en objetos DTO (Data
 * Transfer Objects), y viceversa. Se utiliza para facilitar el transporte de
 * datos entre capas de la aplicación sin exponer directamente las entidades de
 * dominio.
 */
public class DataMapper {

    // International Flight

    /**
     * Convierte un objeto de tipo InternationalFlightDTO a InternationalFlight.
     *
     * @param dto el objeto InternationalFlightDTO a convertir.
     * @return un objeto InternationalFlight basado en los datos del DTO.
     */
	public static InternationalFlight InternationalFlightDTOToInternationalFlight(InternationalFlightDTO dto) {
		InternationalFlight entity;
		entity = new InternationalFlight(dto.getCompanyName(), dto.getPassengersNumber(), dto.getNameCaptain(),
				dto.getNameSecondCommand(), dto.getDepartureTime(), dto.getArrivalTime(), dto.getFuelWeight(),
				dto.getId(), dto.getDepartureDestination(), dto.getArrivalDestination(), dto.isVisa());
		return entity;
	}

    /**
     * Convierte un objeto de tipo InternationalFlight a InternationalFlightDTO.
     *
     * @param entity el objeto InternationalFlight a convertir.
     * @return un objeto InternationalFlightDTO basado en los datos de la entidad.
     */
	public static InternationalFlightDTO InternationalFlightToInternationalFlightDTO(InternationalFlight entity) {
		InternationalFlightDTO dto;
		dto = new InternationalFlightDTO(entity.getCompanyName(), entity.getPassengersNumber(), entity.getNameCaptain(),
				entity.getNameSecondCommand(), entity.getDepartureTime(), entity.getArrivalTime(),
				entity.getFuelWeight(), entity.getId(), entity.getDepartureDestination(),
				entity.getArrivalDestination(), entity.isVisa());
		return dto;
	}

    /**
     * Convierte una lista de objetos InternationalFlight a una lista de objetos
     * InternationalFlightDTO.
     *
     * @param entityList la lista de objetos InternationalFlight a convertir.
     * @return una lista de objetos InternationalFlightDTO.
     */
	public static ArrayList<InternationalFlightDTO> listaInternationalFlightToListaInternationalFlightDTO(
			ArrayList<InternationalFlight> entityList) {
		ArrayList<InternationalFlightDTO> dtoList = new ArrayList<>();
		for (InternationalFlight g : entityList) {
			dtoList.add(new InternationalFlightDTO(g.getCompanyName(), g.getPassengersNumber(), g.getNameCaptain(),
					g.getNameSecondCommand(), g.getDepartureTime(), g.getArrivalTime(), g.getFuelWeight(), g.getId(),
					g.getDepartureDestination(), g.getArrivalDestination(), g.isVisa()));
		}
		return dtoList;
	}

    /**
     * Convierte una lista de objetos InternationalFlightDTO a una lista de objetos
     * InternationalFlight.
     *
     * @param dtoList la lista de objetos InternationalFlightDTO a convertir.
     * @return una lista de objetos InternationalFlight.
     */
	public static ArrayList<InternationalFlight> listaInternationalFlightDTOToListaInternationalFlight(
			ArrayList<InternationalFlightDTO> dtoList) {
		ArrayList<InternationalFlight> entityList = new ArrayList<>();
		for (InternationalFlightDTO d : dtoList) {
			entityList.add(new InternationalFlight(d.getCompanyName(), d.getPassengersNumber(), d.getNameCaptain(),
					d.getNameSecondCommand(), d.getDepartureTime(), d.getArrivalTime(), d.getFuelWeight(), d.getId(),
					d.getDepartureDestination(), d.getArrivalDestination(), d.isVisa()));
		}
		return entityList;
	}

    // National Flight

    /**
     * Convierte un objeto de tipo NationalFlightDTO a NationalFlight.
     *
     * @param dto el objeto NationalFlightDTO a convertir.
     * @return un objeto NationalFlight basado en los datos del DTO.
     */
	public static NationalFlight NationalFlightDTOToNationalFlight(NationalFlightDTO dto) {
		NationalFlight entity;
		entity = new NationalFlight(dto.getCompanyName(), dto.getPassengersNumber(), dto.getNameCaptain(),
				dto.getNameSecondCommand(), dto.getDepartureTime(), dto.getArrivalTime(), dto.getFuelWeight(),
				dto.getId(), dto.getDepartureDestination(), dto.getArrivalDestination(), dto.isTurboProp(),
				dto.isTurbine());
		return entity;
	}

    /**
     * Convierte un objeto de tipo NationalFlight a NationalFlightDTO.
     *
     * @param entity el objeto NationalFlight a convertir.
     * @return un objeto NationalFlightDTO basado en los datos de la entidad.
     */
	public static NationalFlightDTO NationalFlightToNationalFlightDTO(NationalFlight entity) {
		NationalFlightDTO dto;
		dto = new NationalFlightDTO(entity.getCompanyName(), entity.getPassengersNumber(), entity.getNameCaptain(),
				entity.getNameSecondCommand(), entity.getDepartureTime(), entity.getArrivalTime(),
				entity.getFuelWeight(), entity.getId(), entity.getDepartureDestination(),
				entity.getArrivalDestination(), entity.isTurboProp(), entity.isTurbine());
		return dto;
	}

    /**
     * Convierte una lista de objetos NationalFlight a una lista de objetos
     * NationalFlightDTO.
     *
     * @param entityList la lista de objetos NationalFlight a convertir.
     * @return una lista de objetos NationalFlightDTO.
     */
	public static ArrayList<NationalFlightDTO> listaNationalFlightToListaNationalFlightDTO(
			ArrayList<NationalFlight> entityList) {
		ArrayList<NationalFlightDTO> dtoList = new ArrayList<>();
		for (NationalFlight g : entityList) {
			dtoList.add(new NationalFlightDTO(g.getCompanyName(), g.getPassengersNumber(), g.getNameCaptain(),
					g.getNameSecondCommand(), g.getDepartureTime(), g.getArrivalTime(), g.getFuelWeight(), g.getId(),
					g.getDepartureDestination(), g.getArrivalDestination(), g.isTurboProp(), g.isTurbine()));
		}
		return dtoList;
	}

    /**
     * Convierte una lista de objetos NationalFlightDTO a una lista de objetos
     * NationalFlight.
     *
     * @param dtoList la lista de objetos NationalFlightDTO a convertir.
     * @return una lista de objetos NationalFlight.
     */
	public static ArrayList<NationalFlight> listaNationalFlightDTOToListaNationalFlight(
			ArrayList<NationalFlightDTO> dtoList) {
		ArrayList<NationalFlight> entityList = new ArrayList<>();
		for (NationalFlightDTO d : dtoList) {
			entityList.add(new NationalFlight(d.getCompanyName(), d.getPassengersNumber(), d.getNameCaptain(),
					d.getNameSecondCommand(), d.getDepartureTime(), d.getArrivalTime(), d.getFuelWeight(), d.getId(),
					d.getDepartureDestination(), d.getArrivalDestination(), d.isTurboProp(), d.isTurbine()));
		}
		return entityList;
	}

}