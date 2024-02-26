package a;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dardos {
	static int n, d = 400;
	static ArrayList cx = new ArrayList();
	static ArrayList cy = new ArrayList();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Ingrese la cantidad de dardos: ");
		n = scn.nextInt();
		int na = 0;
		System.out.println("N\tx\ty\tH");
		for (int i = 0; i < n; i++) {
			int x = (int) (Math.random() * d);
			int y = (int) (Math.random() * d);
			cx.add(x);
			cy.add(y);
			System.out.println(i + "\t" + x + "\t" + y + "\t" + (int) Math.sqrt(x * x + y * y));
			x -= d / 2;
			y -= d / 2;
			if ((int) (Math.sqrt(x * x + y * y)) <= (int) (d / 2))
				na++;
		}
		System.out.println("Aciertos: " + na);
		System.out.println("Fallos: " + (n - na));
		System.out.println("Valor de Pi: " + (double) ((double) na / n) * 4);
		
		JFrame j = new JFrame("Dardos");
		j.setVisible(true);
		j.setSize(d + 20, d + 50);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, d, d);
				g.setColor(Color.BLUE);
				g.fillOval(0, 0, d, d);
				g.setColor(Color.WHITE);
				g.drawLine(0, d / 2, d, d / 2);
				g.drawLine(d / 2, 0, d / 2, d);
				g.setColor(Color.RED);
				for (int i = 0; i < n; i++) {
					g.fillOval((int) cx.get(i), (int) cy.get(i), 5, 5);
				}
			}
		};
		j.add(p);
	}
}
