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

public class Grupo {

	public Alumno[] alumnos;

	public Grupo() { // le da valor al arreglo

		this.alumnos = new Alumno[10];

	}

	public Grupo(int tamanio) { // cuantos contactos

		this.alumnos = new Alumno[tamanio];

	}
	//10-----------------------------------------
	public int totalMujeres() {
		int total=0;
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getSexo().equalsIgnoreCase("femenino")) {
				total++;
			}
		}
		return total;
	}
	//11-----------------------------------------
	public void promedioGrupal() {
		for (int i = 0; i < alumnos.length; i++) {
			if (alumnos[i].getCarrera().equalsIgnoreCase("sistemas")) {
				System.out.println(alumnos[i].getPromedio());
			}
			
		}	
	}
	
	public int reprobados() {
		int totalReprobados=0;
		for (int i = 0; i < alumnos.length; i++) {
			if(alumnos[i].getPromedio() < 70) {
				totalReprobados++;
			}
		}
		return totalReprobados;
	}
}