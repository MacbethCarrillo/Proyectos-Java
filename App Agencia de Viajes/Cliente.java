package ok;

import java.util.*;

public class Cliente {

	protected String nombre, apellido, origen, distino;
	Scanner ent = new Scanner(System.in);
	double montoTotal;
	double monto;

	public Cliente(String nombre, String apellido, String origen, String distino) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.origen = origen;
		this.distino = distino;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDistino() {
		return distino;
	}

	public void setDistino(String distino) {
		this.distino = distino;
	}

	public boolean validarMonto(int montoDestino, String distino) {
		String distinoviaje;
		System.out.println("Para confirmar inserte el destino de nuevo: ");
		distinoviaje = ent.next();
		System.out.println("Introduzca el monto total: ");
		monto = ent.nextInt();

		if (monto >= montoDestino && distino.equalsIgnoreCase(distinoviaje)) {
			System.out.println("El monto es correcto");
			return true;
		}
		System.out.println("No se pudo procesar su viaje...");
		return false;
	}

	public void promocion(int montoDestino, double montoTotal) {

	}

}

//nombre, apellido, origen, destino.
