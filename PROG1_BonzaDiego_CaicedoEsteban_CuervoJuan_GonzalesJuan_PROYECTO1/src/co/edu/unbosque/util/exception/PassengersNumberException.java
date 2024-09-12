package co.edu.unbosque.util.exception;

public class PassengersNumberException extends Exception {
public PassengersNumberException() {
super("El numero de pasajeros no puede ser negativo");
}
}
