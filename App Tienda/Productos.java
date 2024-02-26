package Proyecto;

public class Productos {
	protected String descripcion;
	protected int cantidad, idProd;
	protected double precio;
	
	public Productos() {
	}

	public Productos(int idProd, String descripcion, int cantidad, double precio) {
		this.idProd = idProd;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio = precio;

	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getIdProd() {
		return idProd;
	}

	public double getPrecio() {
		return precio;
	}
	

}
