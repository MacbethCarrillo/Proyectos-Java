package a;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Aguja {
	static ArrayList ca=new ArrayList();
	static ArrayList cp=new ArrayList();
	static int n,s=10;
	static double l,d;
	
	public static boolean interseccion(double p,double l,double a,double d) {
		return (((p+l*Math.sin(a)/2>=d) && (p-l*Math.sin(a)/2<=d))||(p+l*Math.sin(a)/2>=0) && (p-l*Math.sin(a)/2<=0));
	}
	
	public static void main(String[] args) {
		XYSeries vel = new XYSeries("Velocidad"); //Creamos la tabla para el gráfico
		JFrame f=new JFrame("Aguja de buffon");
		System.out.print("Numero de lanzamientos: ");
		Scanner scn=new Scanner(System.in);
		n=scn.nextInt();
		System.out.print("Tamaño de la aguja: ");
		l=scn.nextDouble();
		System.out.print("Tamaño entre lineas: ");
		d=scn.nextDouble();
		int intersecciones=0;
		for(int i=0;i<n;i++) {
			double a=Math.random()*Math.PI;
			double p = Math.random()*d;
			ca.add(a);
			System.out.println("a: "+a);
			cp.add(p);
			if(interseccion(p,l,a,d)){
				intersecciones++;
			}
			if(intersecciones>0) {
			double pi=(2*l*n)/(d*intersecciones);
			vel.add(i, pi);}
		}
		double pi=(2*l*n)/(d*intersecciones);
		System.out.println(pi);
		
		JPanel p=new JPanel() {
			@Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            	g.setColor(Color.BLACK);
                for(int i=0;i<n*10;i+=d*s) {
                	g.drawLine(i*s, 0, i*s, 800);
                }
                for(int i=0;i<n;i++) {
                	if(interseccion((double)cp.get(i),l,(double)ca.get(i),d))
                    	g.setColor(Color.RED);
                	else
                    	g.setColor(Color.BLUE);
                    g.drawLine(
                    		(int)((((l/2)*Math.sin((double)ca.get(i))))*s),
                    		(int)((((l/2)*Math.cos((double)ca.get(i))))*s),
                    		(int)(((l/2)*Math.sin((double)ca.get(i))+10)*s),
                    		(int)(((l/2)*Math.cos((double)ca.get(i))+10)*s)
                    );
                    
                } 
			}
		};
		f.add(p);
		f.setVisible(true);
		f.setSize(800,800);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		XYSeriesCollection dataset = new XYSeriesCollection(); //Creamos objeto de los datos de las tablas
		dataset.addSeries(vel); //Añadimos la tabla
		JFreeChart lineChart = ChartFactory.createXYLineChart("xd", "Tiempo", "Velocidad", dataset); //Inicializamos el gráfico
		ChartPanel panel = new ChartPanel(lineChart); //Creamos un panel
		JFrame ventana = new JFrame("Grafica Paracaidas | Equipo 3"); //Creamos una interfaz
		//Propiedades de la interfaz
		ventana.setVisible(true); 
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel); //Añadimos el panel a la interfaz
	}

}
