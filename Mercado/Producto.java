/*
 * -PROGRAMACION ORIENTADA A OBJETOS-
 * 
 * ALUMNO: MACBETH ADOLFO CARRILLO IBARRA
 * 
 * NO.CONTROL: 19170557
 * 
 * SEMESTRE: 5
 * 
 * PROFESOR: ALDO URIARTE PORTILLO
 * 
 */
package Semestre5;

public class Producto {

	private int idProducto;
	private float precio;
	private String tipoProducto;
	private String producto;
	
	
	
	@Override
	public String toString() {
		return "idProducto=" + idProducto + ", precio=" + precio + ", tipoProducto=" + tipoProducto
				+ ", producto=" + producto;
	}



	public Producto(int idProducto, float precio, String tipoProducto,String producto) {
		super();
		this.idProducto = idProducto;
		this.precio = precio;
		this.tipoProducto = tipoProducto;
		this.producto = producto;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public String getTipoProducto() {
		return tipoProducto;
	}



	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}



	public float getPrecio() {
		return precio;
	}



	public void setPrecio(float precio) {
		this.precio = precio;
	}



	public String getProducto() {
		return producto;
	}



	public void setProducto(String producto) {
		this.producto = producto;
	}
	
	
	
	
}
