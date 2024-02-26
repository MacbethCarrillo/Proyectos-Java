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

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner Entrada = new Scanner(System.in);
		int opc;
		Menu m = new Menu();
		Operaciones op = new Operaciones();
		Grupo g = new Grupo(10);
		g.alumnos[0] = new Alumno("19170557", "macbeth", "carrillo", "masculino", "sistemas", 80);
		g.alumnos[1] = new Alumno("54646847", "fernanda", "gaxiola", "femenino", "contabilidad", 100);
		g.alumnos[2] = new Alumno("54641268", "kassandra", "meza", "femenino", "energias renovables", 94);
		g.alumnos[3] = new Alumno("39941268", "beatriz", "medina", "femenino", "bioquimica", 87);
		g.alumnos[4] = new Alumno("51987124", "omar", "cazarez", "masculino", "odontologia", 66);
		g.alumnos[5] = new Alumno("04840426", "maximiliano", "rodriguez", "masculino", "sistemas", 88);
		g.alumnos[6] = new Alumno("56487423", "jonathan", "ortiz", "masculino", "sistemas", 64);
		g.alumnos[7] = new Alumno("82346788", "maria", "milan", "femenino", "arquitectura", 98);
		g.alumnos[8] = new Alumno("65781267", "daniel", "palazuelos", "masculino", "psicologia", 82);
		g.alumnos[9] = new Alumno("32174687", "alan", "hernandez", "masculino", "sistemas", 100);

//		String nControl, String nombre, String apellido, String sexo, String carrera, double promedio

		do {
			opc = m.menu();
			switch (opc) {

			case 1:
				System.out.println("Ejercicio 1");
				System.out.println();
				System.out.print("El numero es ");
				op.numAleatorio();
				System.out.println();
				break;

			case 2:
				System.out.println("Ejercicio 2");
				System.out.println();
				op.numConLetras();
				System.out.println();
				break;

			case 3:
				System.out.println("Ejercicio 3");
				System.out.println();
				op.Limite();
				System.out.println();
				break;

			case 4:
				System.out.println("Ejercicio 4");
				System.out.println();
				op.Conversion();
				System.out.println();
				break;

			case 5:
				System.out.println("Ejercicio 5");
				System.out.println();
				op.arreglos();
				System.out.println();
				break;
			case 6:
				String frase;
				System.out.println("Ejercicio  6.");
				System.out.println("Escriba la frase: ");
				frase = Entrada.nextLine();
				System.out.println("Se encontraron " + op.contVeces(frase) + " letras a");
				System.out.println("En la frase: " + frase);
				System.out.println();
				break;

			case 7:
				System.out.println("Ejercicio 7");
				System.out.println();
				op.cadenasIguales();
				System.out.println();
				break;

			case 8:
				System.out.println("Ejercicio 8");
				System.out.println();
				System.out.println("Escriba la frase:");
				String palabra1 = Entrada.nextLine();
				op.contarPalabras(palabra1);
				System.out.println();
				break;

			case 9:
				System.out.println("Ejercicio 9");
				System.out.println();
				System.out.println("Escriba la palabra: (Sin espacios)");
				String palabra = Entrada.next();
				System.out.print("Total de letras que contiene: ");
				System.out.println(op.contarLetras(palabra));
				System.out.println();
				break;

			case 10:
				System.out.println("Ejercicio 10");
				System.out.println();
				System.out.println("La cantidad de mujeres es: " + g.totalMujeres());
				System.out.println();
				break;

			case 11:
				System.out.println("Ejercicio 11");
				System.out.println();
				System.out.println("El promedio del grupo de sistemas son: ");
				g.promedioGrupal();
				System.out.println();
				break;
			case 12:
				System.out.println("Ejercicio 12");
				System.out.println();
				System.out.println("La cantidad de alumnos reprobados es: " + g.reprobados());
				System.out.println();
				break;
			}
		} while (opc >= 1 && opc <= 12);
	}

	public int menu() {
		System.out.println("Menu de opciones");
		System.out.println("1. Generar un numero aleatorio");
		System.out.println("2. Convertir numero a letra");
		System.out.println("3. Multiplo de 4");
		System.out.println("4. Convertir tipo de cambios");
		System.out.println("5. Suma de dos arreglos");
		System.out.println("6. Numero de veces que contien un caracter en una cadena");
		System.out.println("7. Cadenas iguales");
		System.out.println("8. Contar el numero de palabras en una frase");
		System.out.println("9. Sub palabras dentro de una frase");
		System.out.println("10.  Numero de mujeres en un arreglo");
		System.out.println("11. Promedio de un grupo de alumnos en un arreglo");
		System.out.println("12. Alumnos reprobados dentro de un arreglo");
		System.out.println("13. Salir");
		Scanner Entrada = new Scanner(System.in);
		return Entrada.nextInt();
	}
}
