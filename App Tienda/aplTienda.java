package Proyecto;

import java.util.*;

public class aplTienda {

	static ArrayList<Productos> productos = new ArrayList<>();
	static ArrayList<Usuario> usuarios = new ArrayList<>();

	public static void main(String[] args) {
		Scanner Entrada = new Scanner(System.in);
		int tipoEmpleado;
		String cargo;

		productos.add(new Productos(1, "Rancheritos", 10, 15.50));
		productos.add(new Productos(2, "Tostitos", 6, 18));
		productos.add(new Productos(3, "Agua 1L", 15, 9.50));

		usuarios.add(new Administrador(1, "mac", "administrador", "123"));
		usuarios.add(new Gerente(2, "alan", "gerente", "987"));
		usuarios.add(new Cajero(3, "gilberto", "cajero", "abc"));

		Gerente G = new Gerente();
		Administrador A = new Administrador();
		Cajero C = new Cajero();

		
		
		while (true) {
			System.out.println("Que tipo de empleado es?");
			System.out.println("1-Administrador, 2-Gerente, 3-Cajero");
			tipoEmpleado = Entrada.nextInt();

			switch (tipoEmpleado) {
			case 1:
				cargo = "administrador";
				if (A.validarLogin(usuarios, cargo) == true) {
					A.menu();
				}

				break;

			case 2:
				cargo = "gerente";
				if (G.validarLogin(usuarios, cargo) == true) {
					G.menu();
				}
				break;

			case 3:
				cargo = "cajero";
				if (C.validarLogin(usuarios, cargo) == true) {
					C.menu();
				}
				break;
			default:
				System.out.println("Introduzca uno de los cargos");
				break;
			}
		}
	}

}