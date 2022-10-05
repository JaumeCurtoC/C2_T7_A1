package ex3;

import java.util.ArrayList;
import java.util.Hashtable;

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, ArrayList<Double>> inventario = new Hashtable<String, ArrayList<Double>>();
		int opcion = 0;

		llenarInventario(inventario);

		do {

			System.out.println("\n\nCONTROL DE LA TIENDA");
			System.out.println("===================");
			System.out.println("1. Ver Inventario");
			System.out.println("2. Añadir Artículo");
			System.out.println("3. Cambiar Stock");
			System.out.println("4. Ver Articulo");
			System.out.println("5. Salir");
			System.out.print("Introduzca una opción: ");
			opcion = Utilidades.leerInt();

			switch (opcion) {
			case 1:
				mostrarInventario(inventario);
				break;
			case 2:
				añadirArticulo(inventario);
				break;
			case 3:
				cambiarStock(inventario);
				break;
			case 4:
				mostrarArticulo(inventario);
				break;
			case 5:
				System.out.println("Sesión finalizada.");
				break;

			default:
				System.out.println("Error");
				break;
			}

		} while (opcion != 5);

	}

	public static void llenarInventario(Hashtable<String, ArrayList<Double>> inventario) {
		//Precio, Stock
		ArrayList<Double> producto1 = new ArrayList<>();
		producto1.add(20.0);
		producto1.add(1.0);

		inventario.put("Pantalón", producto1);

		ArrayList<Double> producto2 = new ArrayList<>();
		producto2.add(15.0);
		producto2.add(3.0);

		inventario.put("Camiseta", producto2);

		ArrayList<Double> producto3 = new ArrayList<>();
		producto3.add(5.0);
		producto3.add(10.0);

		inventario.put("Gorra", producto3);

		ArrayList<Double> producto4 = new ArrayList<>();
		producto4.add(22.0);
		producto4.add(6.0);

		inventario.put("Camisa", producto4);

		ArrayList<Double> producto5 = new ArrayList<>();
		producto5.add(30.0);
		producto5.add(9.0);

		inventario.put("Chaqueta", producto5);

		ArrayList<Double> producto6 = new ArrayList<>();
		producto6.add(25.0);
		producto6.add(4.0);

		inventario.put("Sudadera", producto6);

		ArrayList<Double> producto7 = new ArrayList<>();
		producto7.add(5.0);
		producto7.add(23.0);

		inventario.put("Ropa Interior", producto7);

		ArrayList<Double> producto8 = new ArrayList<>();
		producto8.add(35.0);
		producto8.add(3.0);

		inventario.put("Vestido", producto8);

		ArrayList<Double> producto9 = new ArrayList<>();
		producto9.add(15.0);
		producto9.add(8.0);

		inventario.put("Zapatos", producto9);

		ArrayList<Double> producto10 = new ArrayList<>();
		producto10.add(50.0);
		producto10.add(2.0);

		inventario.put("Traje", producto10);

	}

	public static void mostrarInventario(Hashtable<String, ArrayList<Double>> inventario) {

		System.out.println("\nLista de Productos \n");

		inventario.forEach((k, v)->{
			System.out.println("Producto: " + k);
			System.out.println(" Precio: " + v.get(0));
			System.out.println(" Stock: " + v.get(1));
			
		});

	}

	public static void añadirArticulo(Hashtable<String, ArrayList<Double>> inventario) {

		System.out.println("Indique el nombre del articulo: ");
		String nombre = Utilidades.leerCadena();

		System.out.println("Indique el precio del articulo: ");
		double precio = Utilidades.leerDouble();
		
		ArrayList<Double> producto = new ArrayList<>();
		producto.add(precio);
		producto.add(1.0);

		inventario.put(nombre, producto);

		System.out.println("Articulo añadido.");
	}

	public static void mostrarArticulo(Hashtable<String, ArrayList<Double>> inventario) {
		System.out.println("Indique el nombre del articulo: ");
		String nombre = Utilidades.leerCadena();

		inventario.forEach((k, v) -> {
			if (k.equals(nombre)) {
				System.out.println("Producto: " + k + " Precio: " + v.get(0) + " Stock: " + v.get(1));
			}
		});
	}

	public static void cambiarStock(Hashtable<String, ArrayList<Double>> inventario) {
		System.out.println("Indique el nombre del articulo: ");
		String nombre = Utilidades.leerCadena();

		inventario.forEach((k, v) -> {
			if (k.equals(nombre)) {
				System.out.println("Indique el stock actual: ");
				double stock = Utilidades.leerDouble();
				
				v.set(1, stock);
				
				System.out.println("Stock modificado");
			}
		});
	}

}
