package ex4;

import java.util.Scanner;

public class Utilidades {
	
	public static String leerCadena(){
		Scanner sc = new Scanner(System.in);
		String cad = sc.nextLine();
		return cad;
		
	}
	
	public static Double leerDouble() {
		Scanner sc = new Scanner(System.in);
		Double doble = sc.nextDouble();
		return doble;
	}
	
	public static int leerInt(){
		Scanner sc = new Scanner(System.in);
		int entero = sc.nextInt();
		return entero;
	}

}