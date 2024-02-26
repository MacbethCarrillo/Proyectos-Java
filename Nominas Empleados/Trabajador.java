package proyecto2;

public class Trabajador {
	private String nombre, genero, tipoPago;
	private int horasTrabajadas, horasExtra;
	private double sueldoDiario, sdo, totalPago;

	public Trabajador() {}
	public Trabajador(String nombre, String genero, String tipoPago, double sueldoDiario, double sdo) {
		this.nombre = nombre;
		this.genero = genero;
		this.tipoPago = tipoPago;
		this.sueldoDiario = sueldoDiario;
		this.sdo = sdo;
	}
	
	public double getSdo() {
		return sdo;
	}
	public void setSdo(double sdo) {
		this.sdo = sdo;
	}
	//metodos get y set
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	public int getHorasExtra() {
		return horasExtra;
	}
	public void setHorasExtra(int horasExtra) {
		this.horasExtra = horasExtra;
	}
	public double getSueldoDiario() {
		return sueldoDiario;
	}
	public void setSueldoDiario(double sueldoDiario) {
		this.sueldoDiario = sueldoDiario;
	}
	public double getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}	
}