package util;

import contador.Contador;
import hilos.Hilo;


public class LanzarPrograma {

	public static void main(String[] args) {

	//------------------------------------------------------------------------------------------
		// si se quiere recibir por argumento el fichero de texto:
		// descomentar la linea de abajo. y comentar la siguiente
		 //String nombreFicheroEntrada = args[0];
		
		//para recibir cinco palabras por argumento, previamente va el nombre del fichero de texto
		/*
		String palabra1 = args[1];
		String palabra2 = args[2];
		String palabra3 = args[3];
		String palabra4 = args[4];
		String palabra5 = args[5];*/
	//	----------------------------------------------------------------------------------------------
		
		

		String nombreFicheroEntrada = "texto2.txt";
		// esta en la carpeta raiz por eso no se pone la ruta

		// los hilos reciben por parametros el nombre fichero y la palabra, en este
		// caso puede ser cualquier palabra
		
		
		String palabra1="la";
		String palabra2="le";
		String palabra3="li";
		String palabra4="lo";
		String palabra5="lu";
	
		
		
		Contador contador1= new Contador(0);
		Contador contador2= new Contador(0);
		Contador contador3= new Contador(0);
		Contador contador4= new Contador(0);
		Contador contador5= new Contador(0);
		
		
		
		
		Hilo h1 = new Hilo(nombreFicheroEntrada, palabra1,contador1);
		Hilo h2 = new Hilo(nombreFicheroEntrada, palabra2,contador2);
		Hilo h3 = new Hilo(nombreFicheroEntrada, palabra3,contador3);
		Hilo h4 = new Hilo(nombreFicheroEntrada, palabra4,contador4);
		Hilo h5 = new Hilo(nombreFicheroEntrada, palabra5,contador5);
	
		Thread t1 = new Thread(h1);
		Thread t2 = new Thread(h2);
		Thread t3 = new Thread(h3);
		Thread t4 = new Thread(h4);
		Thread t5 = new Thread(h5);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
	
		// join para que esperar a que termine cada hilo
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();

		} catch (InterruptedException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Hilo "+ t1.getName() + " cuenta  la PALABRA: " + palabra1 + "  aparece " + contador1.getCont() + " veces");
		System.out.println("Hilo "+ t2.getName() + " cuenta  la PALABRA: " + palabra2 + "  aparece " + contador2.getCont() + " veces");
		System.out.println("Hilo "+ t3.getName() + " cuenta  la PALABRA: " + palabra3 + "  aparece " + contador3.getCont() + " veces");
		System.out.println("Hilo "+ t4.getName() + " cuenta  la PALABRA: " + palabra4 + "  aparece " + contador4.getCont() + " veces");
		System.out.println("Hilo "+ t5.getName() + " cuenta  la PALABRA: " + palabra5 + "  aparece " + contador5.getCont() + " veces");
		
		 System.out.println("estado:"+ t1.getName() + " "  +t1.getState());
		 System.out.println("estado:"+ t2.getName() + " " +t2.getState());
		 System.out.println("estado:"+ t3.getName() + " " +t3.getState());
		 System.out.println("estado:"+ t4.getName() + " " +t4.getState());
		 System.out.println("estado:"+ t5.getName() + " " +t5.getState());

		System.out.println("Fin del programa");

	}

}

