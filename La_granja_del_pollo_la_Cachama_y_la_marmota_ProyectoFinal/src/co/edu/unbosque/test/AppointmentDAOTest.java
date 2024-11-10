package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.AppointmentDTO;
import co.edu.unbosque.model.persistence.AppointmentDAO;

public class AppointmentDAOTest {
	static int numeroPrueba = 1;
	static AppointmentDAO appointmentDAO;

	@BeforeClass
	public static void antesQueTodo() {
		appointmentDAO = new AppointmentDAO();
		System.out.println("Iniciando las pruebas de la clase AppointmentDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + numeroPrueba);
	}

	@Test
	public void verificarAñadir() {

		String doctor = "PEPE";
		String specialty = "Cardiologia";
		String date = "2024/11/09";
		int appointmentNum = 1;
		int id = 100;
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				doctor += rnd.nextInt(10);
			}
		}

		AppointmentDTO appointmentDTO = new AppointmentDTO(id, doctor, specialty, date, appointmentNum);
		appointmentDAO.add(appointmentDTO);

		AppointmentDTO ultimoCita = appointmentDAO.getAll().get(appointmentDAO.getAll().size() - 1);
		assertTrue(appointmentDTO.getDoctor().equals(ultimoCita.getDoctor())
				&& appointmentDTO.getSpecialty().equals(ultimoCita.getSpecialty()));

		appointmentDAO.delete(appointmentDTO);
	}

	@Test
	public void verificarActualizar() {

		String doctor = "PEPE";
		String specialty = "Cardiologia";
		String date = "2024-11/09";
		int appointmentNum = 1;
		int id = 100;
		String doctorNuevo = "PEPE2";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				doctor += rnd.nextInt(10);
				doctorNuevo += rnd.nextInt(20);
			}
		}

		AppointmentDTO appointmentDTO = new AppointmentDTO(id, doctor, specialty, date, appointmentNum);
		AppointmentDTO nuevoAppointmentDTO = new AppointmentDTO(id, doctorNuevo, specialty, date, appointmentNum);

		appointmentDAO.add(appointmentDTO);
		appointmentDAO.update(appointmentDTO, nuevoAppointmentDTO);

		AppointmentDTO citaActualizada = appointmentDAO.getAll().get(appointmentDAO.getAll().size() - 1);
		assertTrue(nuevoAppointmentDTO.getDoctor().equals(citaActualizada.getDoctor()));

		appointmentDAO.delete(nuevoAppointmentDTO);
	}

	@Test
	public void verificarEliminar() {

		String doctor = "PEPE";
		String specialty = "Cardiologia";
		String date = "2024/11/09";
		int appointmentNum = 1;
		int id = 100;
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				doctor += rnd.nextInt(10);
			}
		}

		AppointmentDTO appointmentDTO = new AppointmentDTO(id, doctor, specialty, date, appointmentNum);
		appointmentDAO.add(appointmentDTO);

		boolean eliminado = appointmentDAO.delete(appointmentDTO);
		assertTrue(eliminado);
	}

	@Test
	public void verificarMostrarTodo() {

		String doctor = "PEPE";
		String specialty = "Cardiologia";
		String date = "2024/11/09";
		int appointmentNum = 1;
		int id = 100;
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				doctor += rnd.nextInt(10);
			}
		}

		AppointmentDTO appointmentDTO = new AppointmentDTO(id, doctor, specialty, date, appointmentNum);
		appointmentDAO.add(appointmentDTO);

		assertTrue(!appointmentDAO.getAll().isEmpty());

		appointmentDAO.delete(appointmentDTO);
	}

	@Test
	public void verificarMostrar() {
		boolean mostrar = false;

		String doctor = "PEPE";
		String specialty = "Cardiologia";
		String date = "2024/11/09";
		int appointmentNum = 1;
		int id = 100;
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				doctor += rnd.nextInt(10);
			}
		}

		AppointmentDTO appointmentDTO = new AppointmentDTO(id, doctor, specialty, date, appointmentNum);
		appointmentDAO.add(appointmentDTO);

		if (!appointmentDAO.showAll().isEmpty()) {
			mostrar = true;
		}
		assertTrue(mostrar);

		appointmentDAO.delete(appointmentDTO);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase AppointmentDAO");
		System.out.println("Número de pruebas realizadas: " + (numeroPrueba - 1));
	}
}
