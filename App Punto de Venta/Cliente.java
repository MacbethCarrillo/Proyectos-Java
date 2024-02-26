package proyecto;

import java.util.*;

public class Cliente {

	protected String nombre;
	protected int edad;
	double descuento, total;
	ArrayList<Producto> productos = new ArrayList<>();
	Scanner Entrada = new Scanner(System.in);

	public Cliente() {
	}

	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public void promocionSemanal(ArrayList<Producto> productos, String diaSemana) {

		

		switch (diaSemana) {
		case "Lunes":
		case "Jueves":
			System.out.println("HOY HAY 25% DE DESCUENTO EN CARNICERIA Y LACTEOS");
			for (Producto p : productos) {
				System.out.println();
				if (p.getTipo().equalsIgnoreCase("carniceria") || p.getTipo().equalsIgnoreCase("lacteo")) {

					descuento = -(p.getPrecio() * p.getCant()) * 0.15;

					total=  (p.getPrecio() * p.getCant())- descuento;
				}

			}
			System.out.println("El total fue "+total);
			break;
			
		case "Martes":
		case "Sabado":
			
			System.out.println("HOY NO HAY DESCUENTOS");
			break;

		case "Miercoles":
			System.out.println("HOY HAY 20% DE DESCUENTO EN FRUTAS Y VERDURAS");
			for (Producto p : productos) {
				if (p.getTipo().equalsIgnoreCase("frutas")) {
					descuento = (p.getPrecio() * p.getCant()) * 0.20;
					total=  (p.getPrecio() * p.getCant()) - descuento;
					
				}
				
			}
			break;

		case "Viernes":
		case "Domingo":
			System.out.println("HOY HAY 10% DE DESCUENTO EN TODA LA TIENDA");
			for (Producto p : productos) {
				descuento = -(p.getPrecio() * p.getCant()) * 0.10;
				total=  (p.getPrecio() * p.getCant())- descuento;
				
			}
			System.out.println("El total fue "+total);
			break;
		}
	}


	public void RetirarProductosMarca(ArrayList<Producto> productos , double total) {
		boolean existe = false;
		
		System.out.println("----------------------------------------");
		System.out.println("Introduzca la clave del producto a comprar:");
		String clave = Entrada.next();
		System.out.println("Introduzca la descripcion del producto a comprar");
		String marca = Entrada.next();
		System.out.println("Introduzca el importe:");
		int importe = Entrada.nextInt();
		
		for (Producto p : productos) {
			if (p.getIdProd().equals(clave) && p.getDescrip().equals(marca)) {
				existe = true;
				System.out.println("La marca proporcionada es correcta");
				if(importe >= (p.getPrecio()*p.getCant())) {
					System.out.println("Compra realizada correctamente");
					System.out.println("El total fue "+total);
					break;
				}else {
					System.out.println("No dispone del suficiente dinero");
				}
	
			}else {
				System.out.println("Clave incorrecta o descripcion");
			}
		}
		

	}
}
