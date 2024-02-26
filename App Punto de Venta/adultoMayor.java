package proyecto;

import java.util.ArrayList;

public class adultoMayor extends Cliente{

	public adultoMayor() {}
	
	public adultoMayor(String nombre, int edad) {
		super(nombre , edad);
		
	}
	
	
	public void promocionSemanal(ArrayList<Producto> productos, String diaSemana) {				

		System.out.println("HOY HAY 10% DE DESCUENTO EN TODA LA TIENDA");
		for (Producto p : productos) {
			
			descuento = (p.getPrecio() * p.getCant()) * 0.15;
			total=  (p.getPrecio() * p.getCant())- descuento ;
			
			break;
		}
	}
}
