package ayuda;

public class Deposito implements Operacion{

	@Override
	public double realizarOperacion(Cuenta cta, double importe) {
		System.out.println("Cuenta: "+ cta.cveCuenta);
		System.out.println("Saldo anterior "+ cta.saldo);
		System.out.println("Deposito de: "+importe);
		cta.saldo -= importe;
		System.out.println(" Saldo actual: "+cta.saldo);
		return 0;
	}
}
