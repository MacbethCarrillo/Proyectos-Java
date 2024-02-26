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

import java.util.*;

public class Operaciones {
	Scanner Entrada = new Scanner(System.in);
	int numA;

	//1-----------------------------------------------------------------
	public void numAleatorio() {
		numA = (int) (Math.random() * 99) + 1;
		System.out.println(numA);
	}
	//
	public void multiplo4(int num) {
		System.out.println("Los multiplos de 4 del numero " + num + " son:");
		for (int i = 0; i < num; i++) {
			if (i % 4 == 0) {
				System.out.println(i);
			}
		}
	}
	//2-----------------------------------------------------------------
	public void numConLetras() {

		System.out.println("Coloque el numero del 0 al 10:");
		int op = Entrada.nextInt();
		switch (op) {
		case 0:
			System.out.println("El numero en letras es Cero");
			break;
		case 1:
			System.out.println("El numero en letras es Uno");
			break;
		case 2:
			System.out.println("El numero en letras es Dos");
			break;
		case 3:
			System.out.println("El numero en letras es Tres");
			break;
		case 4:
			System.out.println("El numero en letras es Cuatro");
			break;
		case 5:
			System.out.println("El numero en letras es Cinco");
			break;
		case 6:
			System.out.println("El numero en letras es Seis");
			break;
		case 7:
			System.out.println("El numero en letras es Siete");
			break;
		case 8:
			System.out.println("El numero en letras es Ocho");
			break;
		case 9:
			System.out.println("El numero en letras es Nueve");
			break;
		case 10:
			System.out.println("El numero en letras es Diez");
			break;

		default:
			System.out.println("El numero instertado no es del 0 al 10 (No se pudo realizar la operacion)");
		}
	}
	//3-----------------------------------------------------------------
	public void Limite() {
		for (int i = 0; i < numA; i++) {
			if (i % 4 == 0) {
				System.out.println(i);
			}
		}
	}
	//4-----------------------------------------------------------------
	public void Conversion() {

		double pesos;
		double dolares;

		System.out.println("DOLAR ESTADO UNIDENSE: 20,67MXN");
		System.out.println("Escriba la cantidad en pesos Mexicanos:");
		pesos = Entrada.nextDouble();

		dolares = (pesos / 20.67);

		System.out.println("La conversion de " + pesos + " MX " + "a dolares es " + dolares + " Dolares");

	}
	//5-----------------------------------------------------------------
	public void arreglos() {

		int arreglo[][] = new int[2][2];
		int sumaFila[] = new int[2];

		for (int i = 0; i < arreglo.length; i++) {
			for (int j = 0; j < arreglo.length; j++) {

				arreglo[i][j] = (int) (Math.random() * 49) + 1;

				sumaFila[i] += arreglo[i][j];

				System.out.print("   [" + arreglo[i][j] + "]  ");

			}
			System.out.println("");
			System.out.println("Suma de la fila " + (i + 1) + " es: " + sumaFila[i]);
			sumaFila[i] = 0;
		}

	}
	//6-----------------------------------------------------------------
	public int contVeces(String frase) {
		int total = 0;
		for (int i = 0; i < frase.length(); i++) {
			char car = frase.charAt(i);
			if (car == 'a' || car == 'A') {

				total++;
			}
		}
		return total;
	}
	//7-----------------------------------------------------------------
	public void cadenasIguales() {
		boolean igual;
		System.out.println("Inserte la frase 1");
		String frase1 = Entrada.nextLine();

		System.out.println("Inserte la frase 2");
		String frase2 = Entrada.nextLine();

		if (frase1.equals(frase2)) {
			System.out.println("Las frases son iguales");
			igual = true;
		} else {
			System.out.println("Las frases son diferentes");
			igual = false;
		}

	}
	//7  DE OTRA MANERA-----------------------------------------------------------------
		public boolean encontrarFrase(String subpalabra) {

			String frase = "";
			String[] palabras = frase.split(" ");
			for (int i = 0; i < palabras.length; i++) {
				if (palabras[i].equalsIgnoreCase(subpalabra)) {
					return true;
				}
			}
			return false;
		}

	//8-----------------------------------------------------------------
	public void contarPalabras(String palabra1) {
		int numPalabras = 1;

		for (int i = 0; i < palabra1.length(); i++) {
			if ((palabra1.charAt(i) == ' ') && (palabra1.charAt(i + 1) != ' ')) {
				numPalabras++;
			}
		}
		System.out.println("La cantidad de palabras es: " + numPalabras);
	}
	//9-----------------------------------------------------------------
	public int contarLetras(String palabra) {
		int numLetras = 0;

		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) != ' ') {
				numLetras++;

			}
		}
		return numLetras;
	}
}
