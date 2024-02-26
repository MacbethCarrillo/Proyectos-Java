package a;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ruleta {

	public static void main(String[] args) {

		// Configuracion de la interfaz grafica y tabla
		String[] columnNames = { "Juego", "Num iteracion", "$ antes de girar", "Apuesta", "Num aleatorio", "Color",
				"¿Ganó?", "$ despues de girar", "¿Se llegó a USD$1000?" };

		int TotalGanadas1 = 0, TotalGanadas2 = 0;

		System.out.print("¿Cuantos juegos desea simular? ");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		// Configuración tabla jugador 1
		DefaultTableModel dtm1 = new DefaultTableModel(new Object[][] {}, columnNames);
		JFrame f1 = new JFrame("Jugador 1");
		f1.resize(800, 400);
		JTable t1 = new JTable(dtm1);
		t1.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane js1 = new JScrollPane(t1);
		js1.setVisible(true);
		f1.add(js1);
		f1.setVisible(true);

		// Configuración tabla jugador 1
		DefaultTableModel dtm2 = new DefaultTableModel(new Object[][] {}, columnNames);
		JFrame f2 = new JFrame("Jugador 2");
		f2.resize(800, 400);
		JTable t2 = new JTable(dtm2);
		t2.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane js2 = new JScrollPane(t2);
		js2.setVisible(true);
		f2.add(js2);
		f2.setVisible(true);

		for (int i = 0; i < n; i++) { // Ciclo de juegos
			int ganadas1 = 0, ganadas2 = 0;
			dtm1.addRow(new Object[] { i + 1 });
			dtm2.addRow(new Object[] { i + 1 });
			// Inicializacion de variables
			int dineroJ1 = 200, dineroJ2 = 200;
			int apuesta1 = 1, apuesta2 = 1;
			int ronda = 0;
			while ((dineroJ1 > 0 || dineroJ2 > 0) && dineroJ1 < 1000 && dineroJ2 < 1000) { // Mientras ninguno de los 2 haya ganado o perdido
				ronda++;
				String color = "rojo";
				int dineroantes1 = dineroJ1;
				int dineroantes2 = dineroJ2;
				double a;
				do {
					a = Math.random();
					if (a > 10.0 / 22 && a <= 20.0 / 22)
						color = "negro";
					if (a > 20.0 / 22)
						color = "verde";
					if (color.equals("verde")) {
						dtm1.addRow(new Object[] { "", ronda, dineroantes1, apuesta1, a, color, "Nulo", dineroJ1,
								(dineroJ1 >= 1000 ? "Si" : "No") });
						dtm2.addRow(new Object[] { "", ronda, dineroantes2, apuesta2, a, color, "Nulo", dineroJ2,
								(dineroJ2 >= 1000 ? "Si" : "No") });
						ronda++;
					}
				} while (color.equals("verde")); // Mientras el color sea verde
				int apuestaAntes1 = apuesta1;
				int apuestaAntes2 = apuesta2;
				if (color == "rojo") { // Cuando ganan
					if (dineroJ1 > 0 && dineroJ1 < 1000)
						dineroJ1 += apuesta1;
					if (dineroJ2 > 0 && dineroJ2 < 1000) {
						dineroJ2 += apuesta2;
						apuesta2 = 1;
					}
				} else { // Cuando pierden
					if (dineroJ1 > 0 || dineroJ1 < 1000)
						dineroJ1 -= apuesta1;
					if (dineroJ2 > 0 || dineroJ2 < 1000) {
						dineroJ2 -= apuesta2;
						apuesta2 *= 2;
						if (apuesta2 > dineroJ2) // Si la apuesta es mayor al dinero que tiene, la apuesta es todo el dinero
							apuesta2 = dineroJ2;
						if (apuesta2 >= 1000) // Si la apuesta supera el limite, apuesta es 1
							apuesta2 = 1;
					}
				}
				dtm1.addRow(new Object[] { "", ronda, dineroantes1, apuestaAntes1, a, color,
						(color == "rojo") ? "Si" : "No", dineroJ1, (dineroJ1 >= 1000 ? "Si" : "No") });
				dtm2.addRow(new Object[] { "", ronda, dineroantes2, apuestaAntes2, a, color,
						(color == "rojo") ? "Si" : "No", dineroJ2, (dineroJ2 >= 1000 ? "Si" : "No") });
				if (dineroJ1 >= 1000) // Si el jugador 1 ha superado los 1000dlrs
					ganadas1++;
				if (dineroJ2 >= 1000) // Si el jugador 2 ha superado los 1000dlrs
					ganadas2++;
			}

			// Imprimir los resultados
			if (ganadas1 == 0 && ganadas2 == 0)
				System.out.println("Juego " + (i + 1) + ":No es recomendable ninguna estrategia");
			if (ganadas1 > ganadas2)
				System.out.println("Juego " + (i + 1) + ":Es recomendable la estrategia 1");
			if (ganadas2 > ganadas1)
				System.out.println("Juego " + (i + 1) + ":Es recomendable la estrategia 2");
			TotalGanadas1 += ganadas1;
			TotalGanadas2 += ganadas2;
		}
		// Probabilidades de los juegos en total
		System.out.println();
		System.out.println("La probabilidad de ganar con la estrategia 1 es de: " + (TotalGanadas1 * 1.0 / n) + "% "
				+ TotalGanadas1 + "/" + n);
		System.out.println("La probabilidad de ganar con la estrategia 2 es de: " + (TotalGanadas2 * 1.0 / n) + "% "
				+ TotalGanadas2 + "/" + n);
	}

}
