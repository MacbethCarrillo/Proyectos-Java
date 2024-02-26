package a;

import java.util.Scanner;

import javax.swing.JFrame;

import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;

public class Paracaidas { //Equipo 3
	
	public static void main(String[] args) {
		double v = 0, v2 = -1, g = 9.8, m, c = 12.5; //Definimos variables
		Scanner scn = new Scanner(System.in); //Definimos scn
		DecimalFormat f = new DecimalFormat("0.000000"); //Definimos objeto para aplicar formato de decimales
		System.out.print("Masa del paracaidista en kg: ");
		m = scn.nextDouble(); //Leemos la masa del paracaidista
		int t = 0; //Inicializamos t
		System.out.println();
		System.out.println("T\tV ");
		XYSeries vel = new XYSeries("Velocidad"); //Creamos la tabla para el gráfico
		while (!f.format(v).equals(f.format(v2))) { //Mientras no haya ningun valor repetido
			System.out.println(t+"\t"+f.format(v)); //Mostrar los valores
			vel.add(t, v); //Añadimos los valores a la tabla
			t++;
			v2 = v;
			v = ((g * m) / c) * (1 - Math.pow(Math.E, -(c / m) * t));
		}
		System.out.println("Velocidad antes de que se abra el paracaidas: "+f.format(v2));
		XYSeriesCollection dataset = new XYSeriesCollection(); //Creamos objeto de los datos de las tablas
		dataset.addSeries(vel); //Añadimos la tabla
		JFreeChart lineChart = ChartFactory.createXYLineChart("Velocidad de paracaidista con "+m+"kg de masa", "Tiempo", "Velocidad", dataset); //Inicializamos el gráfico
		ChartPanel panel = new ChartPanel(lineChart); //Creamos un panel
		JFrame ventana = new JFrame("Grafica Paracaidas | Equipo 3"); //Creamos una interfaz
		//Propiedades de la interfaz
		ventana.setVisible(true); 
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel); //Añadimos el panel a la interfaz
	}
}