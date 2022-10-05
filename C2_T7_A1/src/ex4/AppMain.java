package ex4;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import ex3.Utilidades;

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
			System.out.println("5. Generar Comanda");
			System.out.println("6. Salir");
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
				guardarComanda(inventario);
				break;
			case 6:
				System.out.println("Sesión finalizada.");
				break;

			default:
				System.out.println("Error");
				break;
			}

		} while (opcion != 6);

	}

	public static void llenarInventario(Hashtable<String, ArrayList<Double>> inventario) {
		// Precio, IVA, Stock
		ArrayList<Double> producto1 = new ArrayList<>();
		producto1.add(20.0);
		producto1.add(21.0);
		producto1.add(1.0);

		inventario.put("Pantalon", producto1);

		ArrayList<Double> producto2 = new ArrayList<>();
		producto2.add(15.0);
		producto2.add(21.0);
		producto2.add(3.0);

		inventario.put("Camiseta", producto2);

		ArrayList<Double> producto3 = new ArrayList<>();
		producto3.add(5.0);
		producto3.add(21.0);
		producto3.add(10.0);

		inventario.put("Gorra", producto3);

		ArrayList<Double> producto4 = new ArrayList<>();
		producto4.add(22.0);
		producto4.add(21.0);
		producto4.add(6.0);

		inventario.put("Camisa", producto4);

		ArrayList<Double> producto5 = new ArrayList<>();
		producto5.add(30.0);
		producto5.add(21.0);
		producto5.add(9.0);

		inventario.put("Chaqueta", producto5);

		ArrayList<Double> producto6 = new ArrayList<>();
		producto6.add(25.0);
		producto6.add(21.0);
		producto6.add(4.0);

		inventario.put("Sudadera", producto6);

		ArrayList<Double> producto7 = new ArrayList<>();
		producto7.add(5.0);
		producto7.add(21.0);
		producto7.add(23.0);

		inventario.put("Ropa Interior", producto7);

		ArrayList<Double> producto8 = new ArrayList<>();
		producto8.add(35.0);
		producto8.add(21.0);
		producto8.add(3.0);

		inventario.put("Vestido", producto8);

		ArrayList<Double> producto9 = new ArrayList<>();
		producto9.add(15.0);
		producto9.add(21.0);
		producto9.add(8.0);

		inventario.put("Zapatos", producto9);

		ArrayList<Double> producto10 = new ArrayList<>();
		producto10.add(50.0);
		producto10.add(21.0);
		producto10.add(2.0);

		inventario.put("Traje", producto10);

	}

	public static void mostrarInventario(Hashtable<String, ArrayList<Double>> inventario) {

		System.out.println("\nLista de Productos \n");

		inventario.forEach((k, v) -> {
			System.out.println("Producto: " + k);
			System.out.println(" Precio: " + v.get(0));
			System.out.println(" IVA: " + v.get(1));
			System.out.println(" Stock: " + v.get(2));

		});

	}

	public static void añadirArticulo(Hashtable<String, ArrayList<Double>> inventario) {

		System.out.println("Indique el nombre del articulo: ");
		String nombre = Utilidades.leerCadena();

		System.out.println("Indique el precio del articulo: ");
		double precio = Utilidades.leerDouble();

		ArrayList<Double> producto = new ArrayList<>();
		producto.add(precio);
		producto.add(21.0);
		producto.add(1.0);

		inventario.put(nombre, producto);

		System.out.println("Articulo añadido.");
	}

	public static void mostrarArticulo(Hashtable<String, ArrayList<Double>> inventario) {
		System.out.println("Indique el nombre del articulo: ");
		String nombre = Utilidades.leerCadena();

		inventario.forEach((k, v) -> {
			if (k.equals(nombre)) {
				System.out.println(
						"Producto: " + k + " Precio: " + v.get(0) + " IVA: " + v.get(1) + " Stock: " + v.get(2));
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

				v.set(23, stock);

				System.out.println("Stock modificado");
			}
		});
	}

	public static void guardarComanda(Hashtable<String, ArrayList<Double>> inventario) {
		String nom = "";
		double sumaPrecio = 0;
		double sumaPrecioIVA = 0.0;
		int cantidadTotal = 0;
		Hashtable<String, ArrayList<Double>> comanda = new Hashtable<String, ArrayList<Double>>();
		
		do {
			System.out.println("Indique el nombre del producto que quiera añadir: (escriba 'final' para terminar su comanda)");
			nom = Utilidades.leerCadena();
			switch (nom) {
			case "Pantalon":
				ArrayList<Double> a1 = inventario.get(nom);
				
				ArrayList<Double> producto1 = new ArrayList<>();

				producto1.add(a1.get(0));
				producto1.add(a1.get(1));
				producto1.add(1.0);
				
				
				comanda.put(nom, producto1);
				
				sumaPrecio = sumaPrecio + a1.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a1.get(0)+(a1.get(0)*(a1.get(1)/100)));
				cantidadTotal++;
				
				System.out.println("Producto añadido");

				break;
			case "Camiseta":
				ArrayList<Double> a2 = inventario.get(nom);

				ArrayList<Double> producto2 = new ArrayList<>();

				producto2.add(a2.get(0));
				producto2.add(a2.get(1));
				producto2.add(1.0);
				
				comanda.put(nom, producto2);
				
				sumaPrecio = sumaPrecio + a2.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a2.get(0)+(a2.get(0)*(a2.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Gorra":
				ArrayList<Double> a3 = inventario.get(nom);

				ArrayList<Double> producto3 = new ArrayList<>();

				producto3.add(a3.get(0));
				producto3.add(a3.get(1));
				producto3.add(1.0);
				
				comanda.put(nom, producto3);
				
				sumaPrecio = sumaPrecio + a3.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a3.get(0)+(a3.get(0)*(a3.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Camisa":
				ArrayList<Double> a4 = inventario.get(nom);

				ArrayList<Double> producto4 = new ArrayList<>();

				producto4.add(a4.get(0));
				producto4.add(a4.get(1));
				producto4.add(1.0);
				
				
				comanda.put(nom, producto4);
				
				sumaPrecio = sumaPrecio + a4.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a4.get(0)+(a4.get(0)*(a4.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;

			case "Chaqueta":
				ArrayList<Double> a5 = inventario.get(nom);

				ArrayList<Double> producto5 = new ArrayList<>();

				producto5.add(a5.get(0));
				producto5.add(a5.get(1));
				producto5.add(1.0);
				
				comanda.put(nom, producto5);
				
				sumaPrecio = sumaPrecio + a5.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a5.get(0)+(a5.get(0)*(a5.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Sudadera":
				ArrayList<Double> a6 = inventario.get(nom);

				ArrayList<Double> producto6 = new ArrayList<>();

				producto6.add(a6.get(0));
				producto6.add(a6.get(1));
				producto6.add(1.0);
				
				comanda.put(nom, producto6);
				
				sumaPrecio = sumaPrecio + a6.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a6.get(0)+(a6.get(0)*(a6.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Ropa Interior":
				ArrayList<Double> a7 = inventario.get(nom);

				ArrayList<Double> producto7 = new ArrayList<>();

				producto7.add(a7.get(0));
				producto7.add(a7.get(1));
				producto7.add(1.0);
				
				comanda.put(nom, producto7);
				
				sumaPrecio = sumaPrecio + a7.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a7.get(0)+(a7.get(0)*(a7.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Vestido":
				ArrayList<Double> a8 = inventario.get(nom);

				ArrayList<Double> producto8 = new ArrayList<>();

				producto8.add(a8.get(0));
				producto8.add(a8.get(1));
				producto8.add(1.0);
				
				comanda.put(nom, producto8);
				
				sumaPrecio = sumaPrecio + a8.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a8.get(0)+(a8.get(0)*(a8.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;

			case "Zapatos":
				ArrayList<Double> a9 = inventario.get(nom);

				ArrayList<Double> producto9 = new ArrayList<>();

				producto9.add(a9.get(0));
				producto9.add(a9.get(1));
				producto9.add(1.0);
				
				comanda.put(nom, producto9);
				
				sumaPrecio = sumaPrecio + a9.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a9.get(0)+(a9.get(0)*(a9.get(1)/100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Traje":
				ArrayList<Double> a10 = inventario.get(nom);

				ArrayList<Double> producto10 = new ArrayList<>();

				producto10.add(a10.get(0));
				producto10.add(a10.get(1));
				producto10.add(1.0);
				
				comanda.put(nom, producto10);

				sumaPrecio = sumaPrecio + a10.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a10.get(0)+(a10.get(0)*(a10.get(1)/100)));
				cantidadTotal++;
				
				System.out.println("Producto añadido");

				break;

			case "final":
				System.out.println("Fin de comanda");
				System.out.println("--------------------------------");
				break;

			default:
				System.out.println("Error");
				break;
			}

		} while (nom.contains("final") != true);

		mostrarComanda(comanda, sumaPrecio, sumaPrecioIVA, cantidadTotal);
	}

	public static void mostrarComanda(Hashtable<String, ArrayList<Double>> comanda, double sumaPrecio, double sumaPrecioIVA, int cantidadTotal) {
		System.out.println("Comanda:");

		comanda.forEach((k, v) -> {

			if (v.get(2) > 0.0) {
				System.out.println("Nombre del producto: " + k);
				System.out.println(" IVA:" + v.get(1));
				System.out.println(" Precio Bruto: " + v.get(0));
				System.out.println(" Precio + IVA: " + (v.get(0) + (v.get(0) * (v.get(1) / 100))));
				System.out.println(" Cantidad: " + v.get(2));
				
			}
		});

		System.out.println("Precio Total Bruto: " + sumaPrecio);
		System.out.println("Precio Total + IVA: " + sumaPrecioIVA);
		System.out.println("Articulos totales: " + cantidadTotal);

		System.out.println("Cuanto dinero va a dar?");
		double pago = Utilidades.leerDouble();

		System.out.println("Se le devolveran: " + (pago - sumaPrecioIVA) + " euros.");

	}
}
