package proyecto;

public class Producto {

	protected String idProd, descrip, tipo, uM;
	protected double cant, precio, importe, descuento, total;

	public Producto() {}
	
	public Producto(String idProd, String descrip, String tipo, String uM, double cant, double precio, double importe,
			double descuento, double total) {
		
		this.idProd = idProd;
		this.descrip = descrip;
		this.tipo = tipo;
		this.uM = uM;
		this.cant = cant;
		this.precio = precio;
		this.importe = importe;
		this.descuento = descuento;
		this.total = total;
	}

	public Producto(String idProd , String descrip, double precio, String uM , double cant, String tipo) {
		this.idProd = idProd;
		this.descrip = descrip;
		this.precio = precio;
		this.uM = uM;
		this.cant = cant;
		this.tipo = tipo;
	}
	
	
	

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getuM() {
		return uM;
	}

	public void setuM(String uM) {
		this.uM = uM;
	}

	public double getCant() {
		return cant;
	}

	public void setCant(double cant) {
		this.cant = cant;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "idProd=" + idProd + ", descrip=" + descrip + ", precio=" + precio + ", uM=" + uM  + ", cant=" + cant + ", tipo=" + tipo + "]";
	}

}
