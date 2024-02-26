package ok;
import java.util.*;

public class aplVolaris {

	public static void main(String[] args) {

		Scanner ent = new Scanner(System.in);
		String distino;	int montoDestino;
		String op;
		double montoTotal = 0;
		while (true) {
			
			System.out.println("**********VOLARIS CIUDAD CULIACAN**********");
			System.out.println("DESTINOS:");
			System.out.println("CANADA - $4000");
			System.out.println("ITALIA - $6000");
			System.out.println("CHINA - $8000");
			System.out.println("**********VOLARIS CIUDAD CULIACAN**********");
			System.out.println();
			System.out.println();
			
			Cliente c = new Cliente("Macbeth", "Carrillo" , "Culiacan" , "");
			clienteBasico cb = new clienteBasico("Aldo", "Uriarte" , "Culiacan" , "");
			clienteFrecuente cf = new clienteFrecuente("Dora" , "Ibarra", "Culiacan", "");
			clienteRegular cr = new clienteRegular("Lizeth", "Gaxiola" , "Culiacan", "");
			
			System.out.println("A donde desea viajar?: ");
			distino = ent.nextLine();
			
			switch(distino) {
			case "canada": 
				montoDestino = 4000;
				distino = "canada";
				if(c.validarMonto(montoDestino, distino)==true) {
					System.out.println("Que tipo de cliente es? (Basico)   (Frecuente)   (Regular)");
					op = ent.next();
					if(op.equalsIgnoreCase("basico")) {
						cb.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("frecuente")) {
						cf.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("regular")) {
						cr.promocion(montoDestino, montoTotal);
					}
				}//cierra el if del destino
				
				break;
				
			case "italia": 
				montoDestino = 6000;
				distino = "italia";
				if(c.validarMonto(montoDestino, distino)==true) {
					System.out.println("Que tipo de cliente es? (Basico)   (Frecuente)   (Regular)");
					op = ent.next();
					if(op.equalsIgnoreCase("basico")) {
						cb.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("frecuente")) {
						cf.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("regular")) {
						cr.promocion(montoDestino, montoTotal);
					}
				}//cierra el if del destino
				break;
				
			case "china": 
				montoDestino = 8000;
				distino = "china";
				if(c.validarMonto(montoDestino, distino)==true) {
					System.out.println("Que tipo de cliente es? (Basico)   (Frecuente)   (Regular)");
					op = ent.next();
					if(op.equalsIgnoreCase("basico")) {
						cb.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("frecuente")) {
						cf.promocion(montoDestino, montoTotal);
					}
					else if(op.equalsIgnoreCase("regular")) {
						cr.promocion(montoDestino, montoTotal);
					}
				}//cierra el if del destino3
				break;
				
			}
			
		}

	}

}
