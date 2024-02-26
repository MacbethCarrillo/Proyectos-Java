package ok;
import java.util.*;

public class clienteRegular extends Cliente{
	Scanner ent = new Scanner(System.in);
	
	public clienteRegular(String nombre, String apellido, String origen, String distino) {
		super(nombre, apellido, origen, distino);
	}

	public void promocion(int montoDestino, double montoTotal) {
		
		System.out.println("Se le hara un costo adicional por elegir un asiento ($150)");
		System.out.println("Cuanto es el peso de su maleta?: ");
		int peso = ent.nextInt();
		
		if(peso < 25) {
			System.out.println("Su maleta pesa menos de 25kg (Descuento del 40%)");
			montoTotal = montoDestino - 0.40;
			
			System.out.println("Su monto toal es "+montoTotal);
		}else {
			montoTotal = montoDestino + 150;
			System.out.println("Su monto total es "+montoTotal);
		}
	}

}

