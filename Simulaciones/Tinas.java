package a;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tinas {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("¿Cuántos años se desea simular? ");		//Se pregunta los años
		int n = scn.nextInt();
		
		//Se imprimen la cabeceras de la tabla de consola
		System.out.println("N\tDia\tTina\t\t#AleaR\t\tPeso simulado\tPeso sim acumulado\t¿Excede Capacidad?\tDinero acumulado");
		
		int costoPromedioAnual=0; //Se inicializa la variable de costo de promedio anual
		
		//Configuracion de las tablas de interfaz
		String[] columnNames={"N","Dia","Tina","#AleaR","Peso sim","Peso sim acumulado","¿Excede Capacidad?","Dinero acumulado"};
		
		for (int añ = 0; añ < n; añ++) { 	//ciclo de años
			int dinero=0;					//Inicializamos la variable de costo anual
			
			//Configuracion de la interfaz grafica y tabla
			JFrame f=new JFrame("Año "+(añ+1));
			f.resize(800,400);
			DefaultTableModel dtm=new DefaultTableModel(new Object[][]{},columnNames);
			JTable t=new JTable(dtm);
			t.setFont(new Font("Arial",Font.PLAIN,16));
			JScrollPane js=new JScrollPane(t);
			js.setVisible(true);
			f.add(js);
			f.setVisible(true);
			System.out.println((añ+1));
			dtm.addRow(new Object[]{añ+1});
			for(int d = 0; d < 260; d++) {	 	//Ciclo de los dias del año
				int PesoAcumulado=0; 			//Inicializamos el peso del dia
				System.out.println("\t"+(d+1));
				dtm.addRow(new Object[]{"",d+1});
				for (int i = 0; i < 5; i++) { 	//Ciclo de las 5 tinas
					double a = Math.random();	//Se genera el num aleatorio
					int x;
					
					//Se siguen las formulas anteriormente planteadas
					if (a < 0.5)
						x = (int) Math.round(190 + Math.sqrt(800 * a));
					else if (a > 0.5)
						x = (int) Math.round(230 + Math.sqrt(800 * (1 - a)));
					else
						x = 210;
					PesoAcumulado+=x; 		//Se incrementa el peso acumulado
					
					//Impresiones de tablas
					System.out.print("\t"+"\t"+(i+1)+"\t"+a+"\t"+x+"\t\t"+PesoAcumulado);
					if(i<4) {
						System.out.println();
						dtm.addRow(new Object[]{"","",i+1,a,x,PesoAcumulado,"",""});
					}
					else
						if(PesoAcumulado>1000) { 		//Si el peso es mayor a una tonelada
							dinero+=200; 				//Se incrementa el dinero a 200
							System.out.println("\t\t\tsi\t\t\t"+dinero);
							dtm.addRow(new Object[]{"","",i+1,a,x,PesoAcumulado,"Si",dinero});
						}else {
							System.out.println("\t\t\tno\t\t\t----");
							dtm.addRow(new Object[] {"","",i+1,a,x,PesoAcumulado,"No","---"});
						}
				}
			}
			dtm.addRow(new Object[]{"","","","","","","",dinero});
			costoPromedioAnual+=dinero;
		}
		if(costoPromedioAnual/n<60000)  	//Si el costo promedio anual es menor a lo que cuesta el camion
			System.out.println("Conviene seguir igual. Gastaria $"+(costoPromedioAnual/n)); //Conviene seguir igual
		else
			System.out.println("Conviene comprar camión. Le sobrarían $"+((costoPromedioAnual/n)-60000)); //Sino conviene comprar el camion

	}

}
