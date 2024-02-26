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
package practica;

import java.util.*;



public class carga {

	Scanner Entrada = new Scanner(System.in);
	public Materia[] materia;

	public carga(int tamanio) {
		
		this.materia = new Materia[tamanio];
	}
	
	public void aniadirMateria(Materia c) { // añadir las materias
		boolean encontrado = false;
		for (int i = 0; i < materia.length && !encontrado; i++) {
			if(materia[i] == null) {
				materia[i]=c;
				
				break;
			}
			
		}
	}

	public Materia escribirCalificacion(Materia c) {

		int cal1, cal2, cal3;
		double calificacion;

		System.out.println("Calificacion del primer parcial: ");
		cal1 = Entrada.nextInt();

		System.out.println("Calificacion del segundo parcial: ");
		cal2 = Entrada.nextInt();

		System.out.println("Calificacion del tercer parcial: ");
		cal3 = Entrada.nextInt();

		calificacion = (cal1 + cal2 + cal3) / 3;

		System.out.println("La calificacion de la materia " + c.getDescripcion() + " es " + calificacion);
		c.setCalificacion(calificacion);

		return c;
	}

	public void imprimirMateria() {
		for (int i = 0; i < materia.length; i++) {
			if (materia[i] != null) {
				System.out.println(materia[i]);

			}

		}

	}
	
	public boolean grupoLleno(Materia c) { 

		for (int i = 0; i < materia.length; i++) {
			if(materia[i]==null) {
				return false;
			}
			
			if (materia[i].getAlumnosActual()>= materia[i].getAlumnosMax()) {
					materia[i]=null;
				return true;

			}
			
		}
		return false;
	}

}