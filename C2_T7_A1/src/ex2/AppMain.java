package ex2;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

public class AppMain {

	public static void main(String[] args) {
		// Declaración de Variables
		Hashtable<String, ArrayList<Double>> inventarioSuper = new Hashtable<String, ArrayList<Double>>();

		llenarInventario(inventarioSuper);

		mostrarInventario(inventarioSuper);
		guardarComanda(inventarioSuper);

	}

	// Este método llena el Hashtable con 4 productos, cada uno de ellos, con
	// nombre, que funciona como key, precio, IVA asociado al producto y cantidad
	// comprada.
	public static void llenarInventario(Hashtable<String, ArrayList<Double>> inventarioSuper) {
		// Precio bruto, IVA, cantidad
		ArrayList<Double> producto1 = new ArrayList<>();
		producto1.add(8.0);
		producto1.add(21.0);
		producto1.add(0.0);

		inventarioSuper.put("Cesta Fruta", producto1);

		ArrayList<Double> producto2 = new ArrayList<>();
		producto2.add(3.0);
		producto2.add(21.0);
		producto2.add(0.0);

		inventarioSuper.put("Verduras", producto2);

		ArrayList<Double> producto3 = new ArrayList<>();
		producto3.add(5.0);
		producto3.add(4.0);
		producto3.add(0.0);

		inventarioSuper.put("Lasaña", producto3);

		ArrayList<Double> producto4 = new ArrayList<>();
		producto4.add(2.0);
		producto4.add(4.0);
		producto4.add(0.0);

		inventarioSuper.put("Pizza", producto4);

	}

	// Este método muestra todo el contenido del Hashtable usando Enumeration
	public static void mostrarInventario(Hashtable<String, ArrayList<Double>> inventarioSuper) {
		Enumeration<String> keys = inventarioSuper.keys();
		Enumeration<ArrayList<Double>> enumeration = inventarioSuper.elements();

		System.out.println("Lista de Productos");

		while (keys.hasMoreElements()) {
			System.out.println("Nombre del producto: " + keys.nextElement());
			System.out.println(" Precios: " + enumeration.nextElement());

		}
		System.out.println("------------------------------------");

	}

	// Este método pregunta al usuario que productos quiere comprar y los va
	// guardando
	public static void guardarComanda(Hashtable<String, ArrayList<Double>> inventarioSuper) {
		String nom = "a";
		double sumaPrecio = 0;
		double sumaPrecioIVA = 0.0;
		int cantidadTotal = 0;

		do {
			nom = JOptionPane.showInputDialog(
					"Indique el nombre del producto que quiera añadir: (escriba 'final' para terminar su comanda)");

			switch (nom) {
			case "Verduras":
				ArrayList<Double> a1 = inventarioSuper.get(nom);

				a1.set(2, a1.get(2) + 1);

				sumaPrecio = sumaPrecio + a1.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a1.get(0) + (a1.get(0) * (a1.get(1) / 100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Cesta Fruta":
				ArrayList<Double> a2 = inventarioSuper.get(nom);

				a2.set(2, a2.get(2) + 1);

				sumaPrecio = sumaPrecio + a2.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a2.get(0) + (a2.get(0) * (a2.get(1) / 100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Lasaña":
				ArrayList<Double> a3 = inventarioSuper.get(nom);

				a3.set(2, a3.get(2) + 1);

				sumaPrecio = sumaPrecio + a3.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a3.get(0) + (a3.get(0) * (a3.get(1) / 100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "Pizza":
				ArrayList<Double> a4 = inventarioSuper.get(nom);

				a4.set(2, a4.get(2) + 1);

				sumaPrecio = sumaPrecio + a4.get(0);
				sumaPrecioIVA = sumaPrecioIVA + (a4.get(0) + (a4.get(0) * (a4.get(1) / 100)));
				cantidadTotal++;

				System.out.println("Producto añadido");

				break;
			case "final":
				System.out.println("Fin de comanda");
				System.out.println("--------------------------------");
				break;

			default:
				break;
			}

		} while (nom.contains("final") != true);

		mostrarComanda(inventarioSuper, sumaPrecio, sumaPrecioIVA, cantidadTotal);

	}

	// Este método muestra la comanda total al usuario: todos los productos que ha
	// comprado, el precio total, con y sin IVA. Además pide el cobro de la comanda
	// y calcula el dinero a devolver
	public static void mostrarComanda(Hashtable<String, ArrayList<Double>> inventarioSuper, double sumaPrecio,
			double sumaPrecioIVA, int cantidadTotal) {

		System.out.println("Comanda:");

		inventarioSuper.forEach((k, v) -> {

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

		String p = JOptionPane.showInputDialog("Cuanto dinero va a dar?");

		double pago = Double.parseDouble(p);

		System.out.println("Se le devolveran: " + (pago - sumaPrecioIVA) + " euros.");

	}
}
