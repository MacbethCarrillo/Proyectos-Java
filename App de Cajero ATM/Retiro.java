package ayuda;

public class Retiro implements Operacion{

	@Override
	public double realizarOperacion(Cuenta cta, double importe) {
		System.out.println("Cuenta: "+ cta.cveCuenta);
		System.out.println("Saldo anterior "+ cta.saldo);
		System.out.println("Retiro de: "+importe);
		cta.saldo -= importe;
		return cta.saldo;
	}
}
