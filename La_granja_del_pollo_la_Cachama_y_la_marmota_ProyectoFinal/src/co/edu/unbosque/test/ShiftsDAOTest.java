package co.edu.unbosque.test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.ShiftsDTO;
import co.edu.unbosque.model.persistence.ShiftsDAO;

public class ShiftsDAOTest {
	static int numeroPrueba = 1;
	static ShiftsDAO shiftsDAO;

	@BeforeClass
	public static void antesQueTodo() {

		shiftsDAO = new ShiftsDAO();
		System.out.println("Iniciando las pruebas de la clase ShiftsDAO");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("Iniciando la prueba " + numeroPrueba);
	}

	@Test
	public void verificarAñadir() {
		String nombre = "Turno";
		String fecha1 = "2024-11-09";
		String fecha2 = "2024-11-10";
		String especialidad = "Medicina";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				especialidad += rnd.nextInt(10);
			}
		}

		ShiftsDTO shiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidad, 1, nombre);
		shiftsDAO.add(shiftsDTO);

		ShiftsDTO ultimoTurno = shiftsDAO.getAll().get(shiftsDAO.getAll().size() - 1);
		assertTrue(shiftsDTO.getName().equals(ultimoTurno.getName())
				&& shiftsDTO.getSpecialty().equals(ultimoTurno.getSpecialty()));

		shiftsDAO.delete(shiftsDTO);
	}

	@Test
	public void verificarActualizar() {
		String nombre = "Turno";
		String fecha1 = "2024-11-09";
		String fecha2 = "2024-11-10";
		String especialidad = "Medicina";
		String nombreNuevo = "Nuevo Turno";
		String especialidadNueva = "Cirugía";

		Random rnd = new Random();
		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				especialidad += rnd.nextInt(10);
				nombreNuevo += rnd.nextInt(20);
				especialidadNueva += rnd.nextInt(20);
			}
		}

		ShiftsDTO shiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidad, 1, nombre);
		ShiftsDTO nuevoShiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidadNueva, 1, nombreNuevo);

		shiftsDAO.add(shiftsDTO);
		shiftsDAO.update(shiftsDTO, nuevoShiftsDTO);

		ShiftsDTO turnoActualizado = shiftsDAO.getAll().get(shiftsDAO.getAll().size() - 1);
		assertTrue(nuevoShiftsDTO.getName().equals(turnoActualizado.getName())
				&& nuevoShiftsDTO.getSpecialty().equals(turnoActualizado.getSpecialty()));

		shiftsDAO.delete(nuevoShiftsDTO);
	}

	@Test
	public void verificarEliminar() {
		String nombre = "Turno";
		String fecha1 = "2024-11-09";
		String fecha2 = "2024-11-10";
		String especialidad = "Medicina";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				especialidad += rnd.nextInt(10);
			}
		}

		ShiftsDTO shiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidad, 1, nombre);
		shiftsDAO.add(shiftsDTO);

		boolean eliminado = shiftsDAO.delete(shiftsDTO);
		assertTrue(eliminado);
	}

	@Test
	public void verificarMostrarTodo() {
		String nombre = "Turno";
		String fecha1 = "2024-11-09";
		String fecha2 = "2024-11-10";
		String especialidad = "Medicina";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				especialidad += rnd.nextInt(10);
			}
		}

		ShiftsDTO shiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidad, 1, nombre);
		shiftsDAO.add(shiftsDTO);

		assertTrue(!shiftsDAO.getAll().isEmpty());

		shiftsDAO.delete(shiftsDTO);
	}

	@Test
	public void verificarMostrar() {
		boolean mostrar = false;
		String nombre = "Turno";
		String fecha1 = "2024-11-09";
		String fecha2 = "2024-11-10";
		String especialidad = "Medicina";
		Random rnd = new Random();

		for (int i = 0; i < 7; i++) {
			if (i < 4) {
				nombre += rnd.nextInt(10);
				especialidad += rnd.nextInt(10);
			}
		}

		ShiftsDTO shiftsDTO = new ShiftsDTO(fecha1, fecha2, especialidad, 1, nombre);
		shiftsDAO.add(shiftsDTO);

		if (!shiftsDAO.showAll().isEmpty()) {
			mostrar = true;
		}
		assertTrue(mostrar);

		shiftsDAO.delete(shiftsDTO);
	}

	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despuesDeTodo() {
		System.out.println("Finalizando las pruebas de la clase ShiftsDAO");
		System.out.println("Número de pruebas realizadas: " + (numeroPrueba - 1));
	}
}