package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.TreatmentDTO;
import co.edu.unbosque.model.persistence.TreatmentDAO;

public class TreatmentDAOTest {
	static int numeroPrueba = 1;
	static TreatmentDAO treatmentDAO;

	@BeforeClass
	public static void antesQueTodo() {

		treatmentDAO = new TreatmentDAO();
		System.out.println("Iniciando las pruebas de la clase TreatmentDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + numeroPrueba);
	}

	@Test
	public void verificarAñadir() {
		String name = "Tratamiento";
		String specialty = "Cardiologia";
		String treatment = "Terapia Cardiaca";
		String verified = "si";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				name += rnd.nextInt(10);
				treatment += rnd.nextInt(20);
			}
		}

		TreatmentDTO treatmentDTO = new TreatmentDTO(name, specialty, treatment, verified);
		treatmentDAO.add(treatmentDTO);

		TreatmentDTO ultimoTratamiento = treatmentDAO.getAll().get(treatmentDAO.getAll().size() - 1);
		assertTrue(treatmentDTO.getName().equals(ultimoTratamiento.getName())
				&& treatmentDTO.getSpecialty().equals(ultimoTratamiento.getSpecialty()));

		treatmentDAO.delete(treatmentDTO);
	}

	@Test
	public void verificarActualizar() {
		String name = "Tratamiento";
		String specialty = "Cardiologia";
		String treatment = "Terapia Cardiaca";
		String verified = "si";
		String nameNuevo = "Nuevo Tratamiento";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				name += rnd.nextInt(10);
				nameNuevo += rnd.nextInt(20);
			}
		}

		TreatmentDTO treatmentDTO = new TreatmentDTO(name, specialty, treatment, verified);
		TreatmentDTO nuevoTreatmentDTO = new TreatmentDTO(nameNuevo, specialty, treatment, "No");

		treatmentDAO.add(treatmentDTO);
		treatmentDAO.update(treatmentDTO, nuevoTreatmentDTO);

		TreatmentDTO tratamientoActualizado = treatmentDAO.getAll().get(treatmentDAO.getAll().size() - 1);
		assertTrue(nuevoTreatmentDTO.getName().equals(tratamientoActualizado.getName()));

		treatmentDAO.delete(nuevoTreatmentDTO);
	}

	@Test
	public void verificarEliminar() {
		String name = "Tratamiento";
		String specialty = "Cardiologia";
		String treatment = "Terapia Cardiaca";
		String verified = "si";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				name += rnd.nextInt(10);
			}
		}

		TreatmentDTO treatmentDTO = new TreatmentDTO(name, specialty, treatment, verified);
		treatmentDAO.add(treatmentDTO);

		boolean eliminado = treatmentDAO.delete(treatmentDTO);
		assertTrue(eliminado);
	}

	@Test
	public void verificarMostrarTodo() {
		String name = "Tratamiento";
		String specialty = "Cardiologia";
		String treatment = "Terapia Cardiaca";
		String verified = "si";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				name += rnd.nextInt(10);
			}
		}

		TreatmentDTO treatmentDTO = new TreatmentDTO(name, specialty, treatment, verified);
		treatmentDAO.add(treatmentDTO);

		assertTrue(!treatmentDAO.getAll().isEmpty());

		treatmentDAO.delete(treatmentDTO);
	}

	@Test
	public void verificarMostrar() {
		boolean mostrar = false;
		String name = "Tratamiento";
		String specialty = "Cardiologia";
		String treatment = "Terapia Cardiaca";
		String verified = "si";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				name += rnd.nextInt(10);
			}
		}

		TreatmentDTO treatmentDTO = new TreatmentDTO(name, specialty, treatment, verified);
		treatmentDAO.add(treatmentDTO);

		if (!treatmentDAO.showAll().isEmpty()) {
			mostrar = true;
		}
		assertTrue(mostrar);

		treatmentDAO.delete(treatmentDTO);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase TreatmentDAO");
		System.out.println("Número de pruebas realizadas: " + (numeroPrueba - 1));
	}
}
