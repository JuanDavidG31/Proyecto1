package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

/**
 * La interfaz CRUDOperation define las operaciones básicas de CRUD 
 * (Crear, Leer, Actualizar y Eliminar) que se pueden realizar sobre un conjunto de datos.
 * 
 * <p>Esta interfaz es genérica y puede aplicarse a diferentes tipos de datos, 
 * definidos por los parámetros de tipo D y E.</p>
 * 
 * @param <D> El tipo de dato que se gestiona en las operaciones CRUD
 * @param <E> El tipo de dato que se utiliza para buscar elementos
 * @version 1.0
 */
public interface CRUDOperation<D, E> {
    
    /**
     * Muestra todos los datos en formato de cadena.
     * 
     * @return Una cadena de texto con la representación de todos los elementos
     */
    public String showAll();

    /**
     * Obtiene una lista de todos los datos.
     * 
     * @return Un ArrayList que contiene todos los elementos
     */
    public ArrayList<D> getAll();

    /**
     * Añade un nuevo dato a la lista.
     * 
     * @param newData El nuevo dato que se va a añadir
     * @return true si el dato fue añadido con éxito, false en caso contrario
     */
    public boolean add(D newData);

    /**
     * Elimina un dato de la lista.
     * 
     * @param toDelete El dato que se desea eliminar
     * @return true si el dato fue eliminado con éxito, false en caso contrario
     */
    public boolean delete(D toDelete);

    /**
     * Busca un elemento en la lista.
     * 
     * @param toFind El elemento que se desea buscar
     * @return El elemento encontrado o null si no se encuentra
     */
    public E find(E toFind);

    /**
     * Realiza una segunda búsqueda de un elemento en la lista. Puede tener un propósito
     * distinto al método find.
     * 
     * @param toFind El elemento que se desea buscar
     * @return El elemento encontrado o null si no se encuentra
     */
    public E find2(E toFind);

    /**
     * Actualiza un dato existente con nueva información.
     * 
     * @param previous El dato previo que se va a actualizar
     * @param newData El nuevo dato que reemplaza al anterior
     * @return true si el dato fue actualizado con éxito, false en caso contrario
     */
    public boolean update(D previous, D newData);
}