package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.DoctorDTO;
import co.edu.unbosque.model.persistence.DoctorDAO;

public class DoctorDAOTest {
	static int numeroPrueba = 1;
	static DoctorDAO doctorDAO;

	@BeforeClass
	public static void antesQueTodo() {

		doctorDAO = new DoctorDAO();
		System.out.println("Iniciando las pruebas de la clase DoctorDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + numeroPrueba);
	}

	@Test
	public void verificarAñadir() {
		String nombre = "Dr.";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}
		DoctorDTO doctorDTO = new DoctorDTO(nombre, email + "@example.com", 1, "Cardiología", "Activo");
		doctorDAO.add(doctorDTO);

		DoctorDTO ultimoDoctor = doctorDAO.getAll().get(doctorDAO.getAll().size() - 1);
		assertTrue(doctorDTO.getName().equals(ultimoDoctor.getName())
				&& doctorDTO.getEmail().equals(ultimoDoctor.getEmail()));

		doctorDAO.delete(doctorDTO);
	}

	@Test
	public void verificarActualizar() {
		String nombre = "Dr.";
		String email = "";
		String nombreNuevo = "Dr.";
		String emailNuevo = "";

		Random rnd = new Random();
		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
				nombreNuevo += rnd.nextInt(20);
				emailNuevo += rnd.nextInt(20);
			}
		}

		DoctorDTO doctorDTO = new DoctorDTO(nombre, email + "@example.com", 1, "Cardiología", "Activo");
		DoctorDTO nuevoDoctorDTO = new DoctorDTO(nombreNuevo, emailNuevo + "@example.com", 1, "Neurología", "Inactivo");

		doctorDAO.add(doctorDTO);
		doctorDAO.update(doctorDTO, nuevoDoctorDTO);

		DoctorDTO doctorActualizado = doctorDAO.getAll().get(doctorDAO.getAll().size() - 1);
		assertTrue(nuevoDoctorDTO.getName().equals(doctorActualizado.getName())
				&& nuevoDoctorDTO.getSpecialty().equals(doctorActualizado.getSpecialty()));

		doctorDAO.delete(nuevoDoctorDTO);
	}

	@Test
	public void verificarEliminar() {
		String nombre = "Dr.";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		DoctorDTO doctorDTO = new DoctorDTO(nombre, email + "@example.com", 1, "Cardiología", "Activo");
		doctorDAO.add(doctorDTO);

		boolean eliminado = doctorDAO.delete(doctorDTO);
		assertTrue(eliminado);
	}

	@Test
	public void verificarMostrarTodo() {
		String nombre = "Dr.";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		DoctorDTO doctorDTO = new DoctorDTO(nombre, email + "@example.com", 1, "Cardiología", "Activo");
		doctorDAO.add(doctorDTO);

		assertTrue(!doctorDAO.getAll().isEmpty());

		doctorDAO.delete(doctorDTO);
	}

	@Test
	public void verificarMostrar() {
		boolean mostrar = false;
		String nombre = "Dr.";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		DoctorDTO doctorDTO = new DoctorDTO(nombre, email + "@example.com", 1, "Cardiología", "Activo");
		doctorDAO.add(doctorDTO);

		if (!doctorDAO.showAll().isEmpty()) {
			mostrar = true;
		}
		assertTrue(mostrar);

		doctorDAO.delete(doctorDTO);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase DoctorDAO");
		System.out.println("Número de pruebas realizadas: " + (numeroPrueba - 1));
	}
}