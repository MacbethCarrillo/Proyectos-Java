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
package Tarea2_9;

public class Alumno {
	private String nControl, nombre, apellido, sexo, carrera;
	private double promedio;

	public Alumno(String nControl, String nombre, String apellido, String sexo, String carrera, double promedio) {
		this.nControl = nControl;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.carrera = carrera;
		this.promedio = promedio;
	}
	
	public Alumno(String nombre,String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getnControl() {
		return nControl;
	}

	public void setnControl(String nControl) {
		this.nControl = nControl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

}