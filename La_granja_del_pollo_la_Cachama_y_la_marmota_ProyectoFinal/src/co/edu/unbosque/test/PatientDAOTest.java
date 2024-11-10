package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.PatientDTO;
import co.edu.unbosque.model.persistence.PatientDAO;

public class PatientDAOTest {
	static int numeroPrueba = 1;
	static PatientDAO patientDAO;

	@BeforeClass
	public static void antesQueTodo() {

		patientDAO = new PatientDAO();
		System.out.println("Iniciando las pruebas de la clase PatientDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + numeroPrueba);
	}

	@Test
	public void verificarAñadir() {
		String nombre = "Paciente";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}
		PatientDTO patientDTO = new PatientDTO(nombre, email + "@gmail.com", 1, 30);
		patientDAO.add(patientDTO);

		PatientDTO ultimoPaciente = patientDAO.getAll().get(patientDAO.getAll().size() - 1);
		assertTrue(patientDTO.getName().equals(ultimoPaciente.getName())
				&& patientDTO.getEmail().equals(ultimoPaciente.getEmail()));

		patientDAO.delete(patientDTO);
	}

	@Test
	public void verificarActualizar() {
		String nombre = "Paciente";
		String email = "";
		String nombreNuevo = "Paciente";
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

		PatientDTO patientDTO = new PatientDTO(nombre, email + "@gmail.com", 1, 30);
		PatientDTO nuevoPatientDTO = new PatientDTO(nombreNuevo, emailNuevo + "@gmail.com", 1, 35);

		patientDAO.add(patientDTO);
		patientDAO.update(patientDTO, nuevoPatientDTO);

		PatientDTO patientActualizado = patientDAO.getAll().get(patientDAO.getAll().size() - 1);
		assertTrue(nuevoPatientDTO.getName().equals(patientActualizado.getName())
				&& nuevoPatientDTO.getAge() == patientActualizado.getAge());

		patientDAO.delete(nuevoPatientDTO);
	}

	@Test
	public void verificarEliminar() {
		String nombre = "Paciente";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		PatientDTO patientDTO = new PatientDTO(nombre, email + "@gmail.com", 1, 30);
		patientDAO.add(patientDTO);

		boolean eliminado = patientDAO.delete(patientDTO);
		assertTrue(eliminado);
	}

	@Test
	public void verificarMostrarTodo() {
		String nombre = "Paciente";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		PatientDTO patientDTO = new PatientDTO(nombre, email + "@gmail.com", 1, 30);
		patientDAO.add(patientDTO);

		assertTrue(!patientDAO.getAll().isEmpty());

		patientDAO.delete(patientDTO);
	}

	@Test
	public void verificarMostrar() {
		boolean mostrar = false;
		String nombre = "Paciente";
		String email = "";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				email += rnd.nextInt(10);
			}
		}

		PatientDTO patientDTO = new PatientDTO(nombre, email + "@gmail.com", 1, 30);
		patientDAO.add(patientDTO);

		if (!patientDAO.showAll().isEmpty()) {
			mostrar = true;
		}
		assertTrue(mostrar);

		patientDAO.delete(patientDTO);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase PatientDAO");
		System.out.println("Número de pruebas realizadas: " + (numeroPrueba - 1));
	}
}