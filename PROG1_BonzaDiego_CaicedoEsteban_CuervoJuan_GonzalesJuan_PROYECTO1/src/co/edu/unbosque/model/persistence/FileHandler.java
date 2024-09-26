package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * La clase FileHandler proporciona métodos estáticos para manejar la lectura y escritura
 * de archivos de texto plano y objetos serializados. Además, se encarga de verificar
 * y crear las carpetas necesarias para almacenar los archivos.
 * 
 * @autor (Tu nombre)
 * @version 1.0
 */
public class FileHandler {

	private static PrintWriter pw;
	private static File archivo;
	private static Scanner sc;
	private static final String FOLDER_NAME = "data";
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	private static FileInputStream fis;
	private static ObjectInputStream ois;


    /**
     * Lee un archivo serializado desde una ubicación especificada.
     * 
     * @param url la ruta del archivo serializado.
     * @return el objeto deserializado si el archivo se leyó correctamente, o null si hubo un error.
     */
	public static Object readSerialized(String url) {
		try {
			archivo = new File(FOLDER_NAME +"/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);
			Object content = ois.readObject();
			fis.close();
			ois.close();
			return content;
		} catch (IOException e) {
			System.out.println("Error en la lectura del archivo serializado");
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en la lectura del archivo serializado(class not found)");
			// e.printStackTrace();
		}
		return null;

	}

    /**
     * Escribe un objeto serializado en un archivo especificado.
     * 
     * @param url la ruta del archivo donde se almacenará el objeto.
     * @param content el objeto a ser serializado y almacenado.
     */
	public static void writerSerialized(String url, Object content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			fos = new FileOutputStream(archivo);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(content);
			fos.close();
			oos.close();
		} catch (IOException e) {
			System.out.println("Error en la escritura del archivo");
		}
	}

    /**
     * Verifica si la carpeta de almacenamiento existe. Si no existe, la crea.
     */
	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if (archivo.exists() && archivo.isDirectory()) {
			return;
		} else {
			archivo.mkdir();
		}
	}

    /**
     * Escribe contenido de texto en un archivo especificado.
     * 
     * @param url la ruta del archivo de texto donde se almacenará el contenido.
     * @param content el contenido a escribir en el archivo.
     */
	public static void writeFile(String url, String content) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error en la escritura del archivo(Texto plano)");
		} catch (IOException e) {
			System.out.println("Error en la correcion del archivo(Texto plano)");
		}
	}
	
    /**
     * Lee el contenido de un archivo de texto especificado.
     * 
     * @param url la ruta del archivo de texto a leer.
     * @return el contenido del archivo como una cadena de texto, o null si hubo un error.
     */
	public static String readFile(String url) {
		try {
			archivo = new File(FOLDER_NAME + "/" + url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			sc = new Scanner(archivo);
			String content = "";
			while (sc.hasNext()) {
				content += sc.nextLine() + "\n";
			}
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}