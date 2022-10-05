package ex1;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class AppMain {

	public static void main(String[] args) {
		// Declaración de Variables
		Hashtable<String, Integer> alumnoMedia = new Hashtable<String, Integer>();
		
		contarAlumnos(alumnoMedia);
		mostrarAlumnos(alumnoMedia);
	}
	
	public static void contarAlumnos(Hashtable<String, Integer> alumnoMedia) {
		String a = JOptionPane.showInputDialog("Cuantos alumnos hay?");
		
		int alumnos = Integer.parseInt(a);
		
		//Por cada alumno usaremos un método para introducir sus datos
		for (int i = 0; i < alumnos; i++) {
			introducirAlumnos(alumnoMedia);
		}
	}
	
	public static void introducirAlumnos(Hashtable<String, Integer> alumnoMedia) {
		String n = JOptionPane.showInputDialog("Nombre del alumno:");
		int m = 0;
		
		//En el curso hay cuatro asignaturas, así que pedimos notas para cada alumno 4 veces.
		for (int i = 0; i < 4; i++) {
			String nt = JOptionPane.showInputDialog("Introduzca la nota de la asignatura " + (i+1));
			
			int nota = Integer.parseInt(nt);
			
			//Después de parsear la nota, hacemos la media
			m = m + nota;
		}
		
		int media = m/4;
	
		//Y la guardamos en el Hashtable
		alumnoMedia.put(n, media);
		
	}
	
	public static void mostrarAlumnos(Hashtable<String, Integer> alumnoMedia) {
		//Enumeramos el contenido del Hashtable para acceder de forma individual
		Enumeration<String> keys = alumnoMedia.keys();
		Enumeration<Integer> enumeration = alumnoMedia.elements();
		
		while (keys.hasMoreElements()) {
			System.out.println("Nombre del alumne: "+ keys.nextElement());
			System.out.println(" Nota Media: "+ enumeration.nextElement());
			
		}
		
	}

}
