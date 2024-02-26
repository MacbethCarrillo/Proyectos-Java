package ayuda;

public class Cuenta {

	String cveCuenta, nombre, tipoCuenta, nip, vencimiento;
	double saldo;
	
	public Cuenta(String cveCuenta, String nombre, String tipoCuenta, String nip, String vencimiento, double saldo) {
		super();
		this.cveCuenta = cveCuenta;
		this.nombre = nombre;
		this.tipoCuenta = tipoCuenta;
		this.nip = nip;
		this.vencimiento = vencimiento;
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cuenta [cveCuenta=" + cveCuenta + ", nombre=" + nombre + ", saldo=" + saldo + "]";
	}
	
	
}
