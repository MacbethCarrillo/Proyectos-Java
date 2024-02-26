package ayuda;
import java.util.*;

public class CambiarNIP implements Operacion{

	@Override
	public double realizarOperacion(Cuenta cta, double importe) {
		Scanner Entrada = new Scanner(System.in);
		System.out.println("Cuenta: "+ cta.cveCuenta);
		System.out.println("Ingresa el NIP anterior: ");
		String nipAnt = Entrada.next();
		
		if(nipAnt.equalsIgnoreCase(cta.nip)) {
			System.out.println("Ingresa el nuevo NIP: ");
			cta.nip = Entrada.next();
			return 1;
		}
		System.out.println("NIP INCORRECTO");
		return 0;
		}

}
