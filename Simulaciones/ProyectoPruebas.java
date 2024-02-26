package a;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProyectoPruebas {
	public static double num[];
	public static DecimalFormat Formato;
	public static int percent;
	
	public static double[] chi5= {3.8415,
			5.9915,
			7.8147,
			9.4877,
			11.0705,
			12.5916,
			14.0671,
			15.5073,
			16.919,
			18.307,
			19.6752,
			21.0261,
			22.362,
			23.6848,
			24.9958,
			26.2962,
			27.5871,
			28.8693,
			30.1435,
			31.4104,
			32.6706,
			33.9245,
			35.1725,
			36.415,
			37.6525,
			38.8851,
			40.1133,
			41.3372,
			42.5569,
			43.773,
			44.9853,
			46.1942,
			47.3999,
			48.6024,
			49.8018,
			50.9985,
			52.1923,
			53.3835,
			54.5722,
			55.7585
};

	public static double[] chi10= {
			2.7055,
			4.6052,
			6.2514,
			7.7794,
			9.2363,
			10.6446,
			12.017,
			13.3616,
			14.6837,
			15.9872,
			17.275,
			18.5493,
			19.8119,
			21.0641,
			22.3071,
			23.5418,
			24.769,
			25.9894,
			27.2036,
			28.412,
			29.6151,
			30.8133,
			32.0069,
			33.1962,
			34.3816,
			35.5632,
			36.7412,
			37.9159,
			39.0875,
			40.256,
			41.4217,
			42.5847,
			43.7452,
			44.9032,
			46.0588,
			47.2122,
			48.3634,
			49.5126,
			50.6598,
			51.805,
	};

	public static double[] kolmogorov5= {0.97500,
			0.84189,
			0.70760,
			0.62394,
			0.56328,
			0.51926,
			0.48342,
			0.45427,
			0.43001,
			0.40925,
			0.39122,
			0.37543,
			0.36143,
			0.34890,
			0.33750,
			0.32733,
			0.31796,
			0.30936,
			0.30143,
			0.29408,
			0.28724,
			0.28087,
			0.27491,
			0.26931,
			0.26404,
			0.25908,
			0.25438,
			0.24993,
			0.24571,
			0.24170,
			0.23788,
			0.23424,
			0.23076,
			0.22743,
			0.22425,
			0.22119,
			0.21826,
			0.21544,
			0.21273,
			0.21012,
			0.20760,
			0.20517,
			0.20283,
			0.20056,
			0.19837,
			0.19625,
			0.19420,
			0.19221,
			0.19028,
			0.18841,
			}; 
	
	public static double[] kolmogorov10= {0.95000,
			0.77639,
			0.63604,
			0.56522,
			0.50945,
			0.46799,
			0.43607,
			0.40962,
			0.38746,
			0.36866,
			0.35242,
			0.33815,
			0.32549,
			0.31417,
			0.30397,
			0.29472,
			0.28627,
			0.27851,
			0.27136,
			0.26473,
			0.25858,
			0.25283,
			0.24746,
			0.24242,
			0.23768,
			0.23320,
			0.22898,
			0.22497,
			0.22117,
			0.21756,
			0.21412,
			0.21085,
			0.20771,
			0.21472,
			0.20185,
			0.19910,
			0.19646,
			0.19392,
			0.19148,
			0.18913,
			0.18687,
			0.18468,
			0.18257,
			0.18051,
			0.17856,
			0.17665,
			0.17481,
			0.17301,
			0.17128,
			0.16959,};
	
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int o=0;
		do {
			System.out.println("1.- Chi Cuadrada");
			System.out.println("2.- Kolmogorov");
			System.out.println("3.- Series");
			System.out.println("4.- Huecos o Distancias");
			System.out.println("5.- Poker");
			System.out.println("6.- Generar nuevos numeros");
			System.out.println("7.- Salir");
			System.out.print("Ingresar opcion: ");
			o=scn.nextInt();
			if(o<6)
			do {System.out.println("1.- 5%");
			System.out.println("2.- 10%");
			System.out.print("Ingrese valor de porcentaje: ");
			int a=scn.nextInt();
			if(a==1)
				percent=5;
			if(a==2)
				percent=10;
			}while(percent!=5 && percent!=10);
			if(o<6 && num==null) {
				generarNumeros();
			}
			switch(o) {
			case 1:
				chicuadrada();
				break;
			case 2:
				kolmogorov();
				break;
			case 3:
				int t;
				do{System.out.print("Total de intervalos: ");
				t=scn.nextInt();}while(t<2 || t>6);
				series(t);
				break;
			case 4:
				System.out.print("Ingrese el valor de a: ");
				double a=scn.nextDouble();
				System.out.print("Ingrese el valor de b: ");
				huecos(a,scn.nextDouble());
				break;
			case 5:
				poker();
				break;
			case 6:
				generarNumeros();
				break;
			case 7:
				System.out.println("El programa ha finalizado");
				break;
				
			}
		}while(o!=7);
	}
	
	public static void chicuadrada() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Formato=new DecimalFormat("0.0000");
		int k=(int) Math.sqrt(num.length);
		double[] intervals=new double[k];
		int c=0;
		for(double i=((double)k)/num.length;i<1;i+=((double)k)/num.length) {
			intervals[c]=i;
			
			c++;
		}
		intervals[k-1]=1;
		int[] o=new int[k];
		for(int i=0;i<num.length;i++) {
			if(num[i]<=intervals[0]) {
				o[0]++;
			}
			for(int j=1;j<k;j++) {
				if(num[i]>intervals[j-1] && num[i]<=intervals[j]) {
					o[j]++;
				}
			}
		}
		double e=num.length/((double)k);
		double[] resta=new double[k];
		for(int i=0;i<k;i++) {
			resta[i]=o[i]-e;
		}
		double[] restacuadrada=new double[k];
		double chicuadrada=0;
		for(int i=0;i<k;i++) {
			restacuadrada[i]=Math.pow(resta[i],2)/e;
			chicuadrada+=restacuadrada[i];
		}
		System.out.println("i\t\to\te\t\to-e\t\t(o-e)^2/e");
		for(int i=0;i<k;i++) {
			System.out.println(Formato.format(intervals[i])+"\t\t"+o[i]+"\t"+Formato.format(e)+"\t\t"+Formato.format(resta[i])+"\t\t"+Formato.format(restacuadrada[i]));
			dataset.setValue(o[i],"Intervalos", Formato.format(intervals[i]));
			dataset.setValue(e,"Esperado", Formato.format(intervals[i]));
		}
		System.out.println("\nxo^2: "+chicuadrada);
		double x=(percent==5)?chi5[k-2]:chi10[k-2];
		System.out.println("x^2 ("+(k-1)+","+percent+"): "+x);
		System.out.println("Los numeros "+((chicuadrada>x)?"no ":"")+"estan uniformemente distribuidos\n");
		JFreeChart lineChart = ChartFactory.createBarChart3D("Grafica", "", "", dataset); //Inicializamos el gráfico
		ChartPanel panel = new ChartPanel(lineChart); //Creamos un panel
		JFrame ventana = new JFrame("Grafica Chi Cuadrada | Equipo 3"); //Creamos una interfaz
		//Propiedades de la interfaz
		ventana.setVisible(true); 
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel); //Añadimos el panel a la interfaz
	}
	
	public static void kolmogorov() {
		XYSeries ui = new XYSeries("Ui"); //Creamos la tabla para el gráfico
		XYSeries in = new XYSeries("i/N"); //Creamos la tabla para el gráfico
		Formato=new DecimalFormat("0.00000");
		double[] num2=num.clone();
		for(int i=0;i<num2.length;i++) {
			for(int j=0;j<num2.length-1;j++) {
				if(num2[j]>num2[j+1]) {
					double a=num2[j];
					num2[j]=num2[j+1];
					num2[j+1]=a;
				}
			}
		}
		System.out.println("Ordenados");
		for(int i=0;i<num2.length;i++) {
			System.out.println(num2[i]);
		}
		double[] division=new double[num2.length];
		for(int i=0;i<num2.length;i++) {
			division[i]=((double)i)/num2.length+0.02;
		}
		double[] di=new double[num2.length];
		double res=0;
		int resi=0;
		for(int i=0;i<num2.length;i++) {
			di[i]=Math.abs(num2[i]-division[i]);
			if(di[i]>res) {
				res=di[i];
				resi=i;
			}
		}
		System.out.println("i\tui\t\ti/N\t\tdi");
		for(int i=0;i<num2.length;i++) {
			System.out.println((i+1)+"\t"+num2[i]+"\t\t"+Formato.format(division[i])+"\t\t"+Formato.format(di[i]));
			ui.add(i, num2[i]); //Añadimos los valores a la tabla
			in.add(i, division[i]); //Añadimos los valores a la tabla
		}
		System.out.println("\nDi: "+res+"\tEn i="+resi);
		double x;
		if(num.length<=50)
			x=(percent==5)?kolmogorov5[num.length-1]:kolmogorov10[num.length-1];
		else
			x=((percent==5)?1.36:1.22)/Math.sqrt(num.length);
		System.out.println("D("+(num.length)+","+percent+"): "+x);
		System.out.println("Los numeros "+((res>x)?"no ":"")+"estan uniformemente distribuidos\n");
		
		
		XYSeriesCollection dataset = new XYSeriesCollection(); //Creamos objeto de los datos de las tablas
		dataset.addSeries(ui); //Añadimos la tabla
		dataset.addSeries(in); //Añadimos la tabla
		XYSeries d=new XYSeries("D");
		d.add(resi,division[resi]);
		d.add(resi,num2[resi]);
		dataset.addSeries(d);
		JFreeChart lineChart = ChartFactory.createXYLineChart("Grafica", "i", "", dataset); //Inicializamos el gráfico
		ChartPanel panel = new ChartPanel(lineChart); //Creamos un panel
		JFrame ventana = new JFrame("Grafica Kolmogorov | Equipo 3"); //Creamos una interfaz
		//Propiedades de la interfaz
		ventana.setVisible(true); 
		ventana.setSize(800, 600);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.add(panel); //Añadimos el panel a la interfaz
		
	}
	
	public static void series(int t) {
		double[] u2=new double[num.length];
		double[] intervals=new double[t+1];
		for(int i=0;i<=t;i++) {
			intervals[i]=(double)(i)/t;
		System.out.println(intervals[i]);}
		for(int i=0;i<num.length-1;i++) 
			u2[i]=num[i+1];
		u2[num.length-1]=u2[num.length-2];
		int[][] puntos=new int[t][t];
		for(int n=0;n<num.length;n++)
			for(int i=0;i<t;i++)
				if(num[n]>intervals[i] && num[n]<=intervals[i+1])
					for(int i2=0;i2<t;i2++)
						if(u2[n]>intervals[i2] && u2[n]<=intervals[i2+1]) {
							puntos[i][i2]++;break;}
		double e=num.length/(t*t);
		
		System.out.println("\nObservados");
		for(int i=t;i>0;i--) {
			System.out.print(intervals[i]+"\t");
			for(int j=0;j<t;j++) { 
				System.out.print(puntos[i-1][j]+"\t");
			}
			System.out.println();
		}
		System.out.print("X\t");
		for(int i=1;i<=t;i++)
			System.out.print(intervals[i]+"\t");
		System.out.println("\n\nEsperados");
		for(int i=t;i>0;i--) {
			System.out.print(intervals[i]+"\t");
			for(int j=0;j<t;j++) { 
				System.out.print(e+"\t");
			}
			System.out.println();
		}
		System.out.print("X\t");
		for(int i=1;i<=t;i++)
			System.out.print(intervals[i]+"\t");
		
		System.out.println("\n\nTablita");
		double res=0;
		for(int i=t;i>0;i--) {
			System.out.print(intervals[i]+"\t");
			for(int j=0;j<t;j++) { 
				System.out.print((Math.pow(puntos[i-1][j]-e,2)/e)+"\t");
				res+=(Math.pow(puntos[i-1][j]-e,2)/e);
			}
			System.out.println();
		}
		System.out.print("X\t");
		for(int i=1;i<=t;i++)
			System.out.print(intervals[i]+"\t");
		System.out.println("\nxo^2: "+res);
		double x=(percent==5)?chi5[t*t-2]:chi10[t*t-2];
		System.out.println("x^2 ("+(t*t-1)+","+percent+"): "+x);
		System.out.println("Los numeros "+((res>x)?"no ":"")+"son independientes\n");
		
		JPanel p = new JPanel() {
			@Override
			public void paint(Graphics g) {
				int l=500;
				for(int i=0;i<=t;i++) {
					g.drawLine(0, i*l/t, l, i*l/t);
					g.drawLine(i*l/t, 0, i*l/t,l);
				}
				g.setColor(Color.RED);
				for(int i=0;i<num.length;i++) {
					g.drawOval((int)((u2[i])*l)-2,(int)((1-num[i])*l)-2, 5, 5);
				}
			}
		};
		p.setSize(520, 520);
		JFrame f = new JFrame("Grafica Series");
		f.setSize(520, 550);
		f.setLayout(null);
		f.add(p);
		f.setVisible(true);
	}
	
	public static void poker() {
		Formato=new DecimalFormat("00000");
		String[] nnums=new String[num.length];
		for(int i=0;i<num.length;i++) {
			nnums[i]=Formato.format((num[i]*100000));
		}
		int[] totales=new int[7];
		System.out.println("i\tri\t\tEvento");
		for(int i=0;i<num.length;i++) {
			int[] repeticiones=new int[10];
			for(int j=0;j<5;j++) {
				repeticiones[Integer.parseInt(nnums[i].substring(j,j+1))]++;
			}
			int pares=0,tercias=0,pok=0,quintilla=0;
			for(int j=0;j<10;j++) {
				if(repeticiones[j]==2)
					pares++;
				if(repeticiones[j]==3)
					tercias++;
				if(repeticiones[j]==4)
					pok++;
				if(repeticiones[j]==5)
					quintilla++;
			}
			System.out.print((i+1)+"\t"+num[i]+"\t\t");
			if(pares==1 && tercias==0) {
				System.out.println("1 Par");totales[1]++;}
			else
			if(pares==2) {
				System.out.println("2 Pares");totales[3]++;}
			else
			if(pares==0 && tercias==1) {
				System.out.println("Tercia");totales[2]++;}
			else
			if(pares==1 && tercias==1) {
				System.out.println("Full");totales[4]++;}
			else
			if(pok==1) {
				System.out.println("Poker");totales[5]++;}
			else
			if(quintilla==1) {
				System.out.println("Quintilla");totales[6]++;}
			else {
				System.out.println("Pachuca");totales[0]++;}
		}
		String[] nombres= {"Pachuca","1 Par","Tercia","2 Pares","Full","Poker","Quintilla"};
		double[] esperados= {0.3024,0.504,0.072,0.108,0.009,0.0045,0.0001};
		System.out.println("\nEvento\t\tFO\tPE\t\tFE\t\t(FO-FE)\t\t(FO-FE)^2/FE");
		double res=0;
		Formato=new DecimalFormat("00.00000");
		for(int i=0;i<7;i++) {
			System.out.print((i<6)?(nombres[i]+"\t\t"):(nombres[i]+"\t"));
			System.out.println(totales[i]+"\t"+Formato.format(esperados[i])+"\t"+Formato.format(esperados[i]*num.length)+"\t"+Formato.format(totales[i]-(esperados[i]*num.length))+"\t"+Formato.format((Math.pow(totales[i]-(esperados[i]*num.length), 2)/(esperados[i]*num.length))));
			res+=(Math.pow(totales[i]-(esperados[i]*num.length), 2)/(esperados[i]*num.length));
		}
		System.out.println("\nxo^2: "+res);
		double x=(percent==5)?chi5[5]:chi10[5];
		System.out.println("x^2 (6,"+percent+"): "+x);
		System.out.println("Los numeros "+((res>x)?"no ":"")+"son independientes\n");
	}
	
	public static void generarNumeros() {
		Scanner scn=new Scanner(System.in);
		int n;
		do {
			System.out.print("Total de numeros aleatorios (Debe de ser >=34): ");
			n=scn.nextInt();}while(n<34);
		num=new double[n];
		for(int i=0;i<n;i++) {
			num[i]=(double)Math.round(Math.random() * 100000d) / 100000d;
		}
		for(int i=0;i<n;i++) {
			System.out.println(num[i]);
		}
	}

	public static void huecos(double a, double b) {
		Formato=new DecimalFormat("0.0000");
		double t=b-a;
		ArrayList huecos=new ArrayList();
		int[] e=new int[num.length];
		for(int i=0;i<num.length;i++) {
			if(num[i]<=b && num[i]>=a)
				e[i]=1;
			else
				e[i]=0;
		}
		System.out.println("i\tUi\t\te");
		for(int i=0;i<e.length;i++)
			System.out.println((i+1)+"\t"+num[i]+"\t\t"+e[i]);
		
		int numhuecos=0;
		int na=2;
		System.out.println();
		for(int i=0;i<num.length;i++) {
			 if(e[i]!=na && na!=2) {
				 huecos.add(numhuecos);
				 numhuecos=0;
			 }
			 if(e[i]==1) {
					 numhuecos=0;
					 na=e[i];
			 }else {
				 numhuecos++;
				 na=e[i];
			 }
		}
		huecos.add(numhuecos);
		
		System.out.println("Huecos");
		for(int j=0;j<huecos.size();j++) {
			System.out.println(huecos.get(j));
		}
		System.out.println();
		int nhuecos=0;
		for(int i=1;i<num.length;i++) {
			if(huecos.contains(i))
				continue;
			else {nhuecos=i;break;}
		}
		int[] o=new int[nhuecos];
		for(int i=0;i<nhuecos;i++) {
			for(int j=0;j<huecos.size();j++) {
				if((int)huecos.get(j)==i) {
					o[i]++;
					continue;
				}
			}
		}
		int sumaoi=0;
		for(int i=0;i<nhuecos;i++) {
			sumaoi+=o[i];
		}
		double res=0;
		System.out.println("i\tpi\toi\tei\t\t(oi-ei)\t\t(oi-ei)^2/ei");
		for(int i=0;i<nhuecos;i++) {
			double pi=Math.pow(1-t,i)*t;
			double ei=huecos.size()*pi;
			System.out.println(i+"\t"+Formato.format(pi)+"\t"+o[i]+"\t"+Formato.format(ei)+"\t\t"+Formato.format(o[i]-(ei))+"\t\t"+Formato.format(Math.pow((o[i]-ei), 2)/ei));
			res+=Math.pow((o[i]-ei), 2)/ei;
		}
		double pi=Math.pow(1-t,nhuecos);
		double ei=huecos.size()*pi;
		System.out.println("n>="+(nhuecos)+"\t"+Formato.format(pi)+"\t"+(huecos.size()-sumaoi)+"\t"+Formato.format(ei)+"\t\t"+Formato.format((huecos.size()-sumaoi)-(ei))+"\t\t"+Formato.format(Math.pow(((huecos.size()-sumaoi)-ei), 2)/ei));
		res+=Math.pow(((huecos.size()-sumaoi)-ei), 2)/ei;
		System.out.println("\nxo^2: "+res);
		double x=(percent==5)?chi5[nhuecos-1]:chi10[nhuecos-1];
		System.out.println("x^2 ("+(nhuecos)+","+percent+"): "+x);
		System.out.println("Los numeros "+((res>x)?"no ":"")+"son independientes\n");
		
	}

}
