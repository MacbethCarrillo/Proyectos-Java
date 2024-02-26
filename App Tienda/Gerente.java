package Proyecto;

import java.util.*;
		
public class Gerente extends Usuario {

	public Gerente() {
	}

	public Gerente(int id, String nombre, String tipo, String contrasenia) {
		super(id, nombre, tipo, contrasenia);
	}

	Scanner Entrada = new Scanner(System.in);

	@Override
	protected int menu() {
		boolean salir = true;
		while (salir) {
			int op;
			System.out.println("MENU DE GERENTE");
			System.out.println("_______________________________");
			System.out.println("1.-Vender");
			System.out.println("2.-Existencia del producto");
			System.out.println("3.-Ver ventas totales");
			System.out.println("4.-Agregar un producto nuevo");
			System.out.println("5.-Salir");
			System.out.println("_______________________________");
			op = Entrada.nextInt();

			switch (op) {
			case 1:
				System.out.println();

				break;
				
			case 2: 
				consultarExistencia();
				break;
			case 3:
				//falta ver ventas
				break;
			case 4:
				aggProducto();
				
				break;
			case 5:
				System.out.println("Saliendo...");
				System.out.println();
				salir = false;
				break;

			}
		}
		return 0;
	}
	
	public void aggProducto() {//Productos p

		int idProd, cantidad;
		String descripcion;
		double precio;

		System.out.println("Digite el id: ");
		idProd = Entrada.nextInt();
		System.out.println("Inserte el nombre del producto: ");
		descripcion = Entrada.next();
		System.out.println("Ingrese cuantos productos tiene: ");
		cantidad = Entrada.nextInt();
		System.out.println("Ingrese el precio: ");
		precio = Entrada.nextDouble();
		productos.add(new Productos(idProd, descripcion, cantidad, precio));
		//productos.add(p);

	}

}
