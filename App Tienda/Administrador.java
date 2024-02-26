package Proyecto;

import java.util.*;;

public class Administrador extends Usuario {
	ArrayList<Productos> productos = new ArrayList<>();
	ArrayList<Usuario> usuarios = new ArrayList<>();
	Productos p;
	
	Scanner Entrada = new Scanner(System.in);

	public Administrador() {
	}

	public Administrador(int id, String nombre, String tipo, String contrasenia) {
		super(id, nombre, tipo, contrasenia);

	}

	@Override
	protected int menu() {
		boolean salir = true;
		while (salir) {
			int op;
			System.out.println("MENU DE ADMIN");
			System.out.println("_______________________________");
			System.out.println("0.-Agregar Usuario");
			System.out.println("1.-Vender");
			System.out.println("2.-Existencia del producto");
			System.out.println("3.-Ver ventas totales");
			System.out.println("4.-Agregar un producto nuevo");
			System.out.println("5.-Salir");
			System.out.println("_______________________________");
			op = Entrada.nextInt();

			switch (op) {
			case 0:
				aggUsuario();
				break;
				
			case 1:
				
				vender(p);
				break;
				
			case 2:
				consultarExistencia();
				
				break;
				
			case 3:
				
				//falta ver ventas totales
				
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

	public void aggUsuario() {

		String nombre, tipo, contrasenia;
		int id;
		System.out.println("Escriba el id correspondiente: ");
		id = Entrada.nextInt();
		Entrada.nextLine();
		System.out.println("Cual es su nombre?: ");
		nombre = Entrada.nextLine();
		System.out.println("Cual sera su cargo?: (Gerente, Cajero)");
		tipo = Entrada.next();
		System.out.println("Cual sera su contraseña?: ");
		contrasenia = Entrada.next();
		if (tipo.equalsIgnoreCase("gerente")) {
			usuarios.add(new Gerente(id, nombre, tipo, contrasenia));
		} 
		if(tipo.equalsIgnoreCase("cajero")) {	
			usuarios.add(new Cajero(id, nombre, tipo, contrasenia));
		}

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
