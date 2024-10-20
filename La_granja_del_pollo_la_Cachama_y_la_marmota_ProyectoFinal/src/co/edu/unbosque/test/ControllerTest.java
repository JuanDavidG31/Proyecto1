package co.edu.unbosque.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class ControllerTest {
	static int numeroPrueba = 1;

	@BeforeClass
	public static void antesQueTodo() {
		System.out.println("iniciando las pruebas de la clase mainTest");
	}

	@Before
	public void antesDeCadaPrueba() {
		System.out.println("iniciando la prueba " + numeroPrueba);
	}
	
	
	
	
	
	@After
	public void despuesDeCadaPrueba() {
		System.out.println("Finalizando la prueba " + numeroPrueba);
		numeroPrueba++;
	}

	@AfterClass
	public static void despueDeTodo() {
		System.out.println("Finalizando las pruebas de la clase main");
		System.out.println("numero de pruebas realizadas ");
	}
}
