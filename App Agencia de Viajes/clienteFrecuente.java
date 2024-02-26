package ok;
import java.util.*;
public class clienteFrecuente extends Cliente {
	Scanner ent = new Scanner(System.in);
	
	public clienteFrecuente(String nombre, String apellido, String origen, String distino) {
		super(nombre, apellido, origen, distino);
	}

	public void promocion(int montoDestino , double montoTotal) {

		System.out.println("Cuanto es el peso de su maleta?: ");
		int peso = ent.nextInt();
		
		if(peso >= 25) {
			System.out.println("Su maleta pesa mas de 25kg (Costo adicional $100)");
			montoTotal = montoDestino +100;
			
			System.out.println("Su monto toal es "+montoTotal);
		}else {
			montoTotal = montoDestino;
			System.out.println("Su monto toal es "+montoTotal);
		}
		
	}


}

