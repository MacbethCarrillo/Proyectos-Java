package a;

import java.util.ArrayList;
import java.util.Scanner;

public class Cartas {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<ArrayList> cartas = new ArrayList<ArrayList>();
		ArrayList<ArrayList> cartasJugadores = new ArrayList<ArrayList>();
		int[] manosGanadas = new int[4];

		// Agregar cartas al arreglo principal
		for (int i = 0; i < 4; i++) {
			ArrayList cartas2 = new ArrayList();
			for (int j = 2; j < 14; j++) {
				if (j > 7 && j < 10)
					continue;
				cartas2.add(j);
			}
			cartas.add(i, cartas2);
		}

		// System.out.println("Cuantas juegos quiere jugar?");

		// Repartir cartas a los jugadores
		for (int i = 0; i < 4; i++) {
			ArrayList cj = new ArrayList();
			for (int j = 0; j < 10; j++) {
				Carta c;
				do {
					c = new Carta();
				} while (!cartas.get(c.type).contains(c.value));
				cartas.get(c.type).remove(cartas.get(c.type).indexOf(c.value));
				cj.add(c);
				c.jugador = i;
			}
			cartasJugadores.add(i, cj);
		}

		/*
		 * for(int i=0;i<4;i++) { System.out.println("Jugador "+i); for(int
		 * j=0;j<10;j++) { Carta c=(Carta)cartasJugadores.get(i).get(j);
		 * System.out.println("Carta tipo "+c.type+" valor: "+c.value); } }
		 */
		for (int i = 0; i < 10; i++) {
			Carta cj1 = (Carta) cartasJugadores.get(0).get(cartasJugadores.get(0).size() - 1);
			Carta cj2 = (Carta) cartasJugadores.get(1).get(cartasJugadores.get(1).size() - 1);
			Carta cj3 = (Carta) cartasJugadores.get(2).get(cartasJugadores.get(2).size() - 1);
			Carta cj4 = (Carta) cartasJugadores.get(3).get(cartasJugadores.get(3).size() - 1);
			Carta m = cj1;
			if (cj2.value > m.value)
				m = cj2;
			if (cj3.value > m.value)
				m = cj3;
			if (cj4.value > m.value)
				m = cj4;
			if (m.value == cj1.value && m.jugador != 1 && m.type > cj1.type) {
				m = cj1;
			}
			if (m.value == cj2.value && m.jugador != 2 && m.type > cj2.type) {
				m = cj2;
			}
			if (m.value == cj3.value && m.jugador != 3 && m.type > cj3.type) {
				m = cj3;
			}
			if (m.value == cj4.value && m.jugador != 4 && m.type > cj4.type) {
				m = cj4;
			}

			System.out.println("Gano jugador " + (m.jugador+1) + " con la carta del tipo " + m.type + " y valor " + m.value);
			cartasJugadores.get(0).remove(cj1);
			cartasJugadores.get(1).remove(cj2);
			cartasJugadores.get(2).remove(cj3);
			cartasJugadores.get(3).remove(cj4);
			manosGanadas[m.jugador]++;
		}
		System.out.println("El jugador 1 ganó "+manosGanadas[0]+" veces");
		System.out.println("El jugador 2 ganó "+manosGanadas[1]+" veces");
		System.out.println("El jugador 3 ganó "+manosGanadas[2]+" veces");
		System.out.println("El jugador 4 ganó "+manosGanadas[3]+" veces");

	}

}

class Carta {
	int type, value, jugador;

	public Carta(int value) {
		this.value = value;
	}

	public Carta() {
		double a = Math.random();
		int t = 0;
		if (a > 0.25 && a <= 0.5)
			t = 1;
		if (a > 0.5 && a <= 0.75)
			t = 2;
		if (a > 0.75)
			t = 3;
		double b = Math.random();
		int carta = 13;
		if (b > 0.1 && b <= 0.2)
			carta = 12;
		if (b > 0.2 && b <= 0.3)
			carta = 11;
		if (b > 0.3 && b <= 0.4)
			carta = 10;
		if (b > 0.4 && b <= 0.5)
			carta = 7;
		if (b > 0.5 && b <= 0.6)
			carta = 6;
		if (b > 0.6 && b <= 0.7)
			carta = 5;
		if (b > 0.7 && b <= 0.8)
			carta = 4;
		if (b > 0.8 && b <= 0.9)
			carta = 3;
		if (b > 0.9)
			carta = 2;
		this.type = t;
		this.value = carta;
	}
}
