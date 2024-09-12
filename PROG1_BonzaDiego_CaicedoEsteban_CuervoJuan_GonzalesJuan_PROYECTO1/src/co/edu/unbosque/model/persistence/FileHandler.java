package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {
	private static Scanner sc;
	private static PrintWriter pw;
	private static File archivo;
	private static final String FOLDER_NAME = "data";
	
	public static void checkFolder() {
		archivo = new File(FOLDER_NAME);
		if(archivo.exists()&&archivo.isDirectory()) {
			return;
		}else {
			archivo.mkdir();
		}
	}

	public static void writeFile(String url, String content) {
		try {
			archivo = new File(FOLDER_NAME+"/"+url);
			if (!archivo.exists()) {
				archivo.createNewFile();

			}
			pw = new PrintWriter(archivo);
			pw.write(content);
			pw.close();
		}catch(FileNotFoundException e) {
			System.out.println("Error en la escritura del archivo(Texto plano)");
		}
		catch (IOException e) {
			System.out.println("Error en la correcion del archivo(Texto plano)");
		}
	}
	
	
}
