package hilos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import contador.Contador;

//clase hilo cuenta palabra
public class Hilo implements Runnable {

	String nombreFichero;
	String palabra;
	Contador contador;

	public Hilo(String nombreFichero, String palabra, Contador contador) {

		this.nombreFichero = nombreFichero;
		this.palabra = palabra;
		this.contador = contador;

	}

	@Override
	public void run() {
		// leerFichero(nombreFichero, vocal);

		File f = new File(nombreFichero);
		FileReader fr = null;
		BufferedReader br = null;
		leerFichero(f, fr, br, contador, nombreFichero, palabra);

	}

	public static void leerFichero(File f, FileReader fr, BufferedReader br, Contador contador, String nombreFich,
			String palabra) {

		try {

			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String lineaLeida;

			while ((lineaLeida = br.readLine()) != null) {
				// dividimos las lineas por un espacio
				String[] palabras = lineaLeida.split(" ");

				for (int i = 0; i < palabras.length; i++) {
					if (palabras[i].equals(palabra))
						contador.incrementar();

				}

			}

			// System.out.println("La PALABRA " + palabra + " aparece " + contador.getCont() + " veces");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
