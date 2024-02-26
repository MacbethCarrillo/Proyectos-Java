package ok;

public class clienteBasico extends Cliente {

	
	public clienteBasico(String nombre, String apellido, String origen, String distino) {
		super(nombre, apellido, origen, distino);
	}

	public void promocion(int montoDestino, double montoTotal) {

		montoTotal = montoDestino+150;
		
		System.out.println("Monto Total: "+montoTotal);
		
	}
}
