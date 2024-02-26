package a;

import java.awt.Font;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Cajero {

	public static void main(String[] args) {
		String[] columnNames = {"Simulacion","Usuario","#alea1","Tiempo Entre Llegada","Momento de Llegada","Tiempo Inicia Servicio","Tiempo Espera/Atencion","#alea2","Operacion","Tiempo de Operación","Tiempo Termina el Servicio"};
		DefaultTableModel dtm = new DefaultTableModel(new Object[][] {}, columnNames);
		JFrame f = new JFrame("Cajero");
		f.resize(800, 600);
		JTable t = new JTable(dtm);
		t.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane js = new JScrollPane(t);
		js.setVisible(true);
		f.add(js);
		
		System.out.print("¿Cuantas simulaciones quiere? ");
		Scanner scn=new Scanner(System.in);
		int n=scn.nextInt();
		double tte=0;
		for(int i=0;i<n;i++) {
			dtm.addRow(new Object[] {i+1});
			double mLla=0;
			double TTa=0;
			double momentoLlegada;
			for(int j=0;j<100;j++) {
				double a=Math.random();
				double tiempoLlegada=-Math.log((1-a))*2;
				momentoLlegada=tiempoLlegada+mLla;
				double ti=tiempoLlegada;
				if(tiempoLlegada<TTa) {
					ti+=TTa;
				}

				double b=Math.random();
				String evento="Consulta de Saldo";
				int to=80;
				if(b>0.25 && b<=0.5) {
					evento="Otros";
					to=50;
				}
				if(b>0.5 && b<=0.85) {
					evento="Retiros";
					to=120;
				}
				if(b>0.85) {
					evento="Transferencia";
					to=60;
				}
				dtm.addRow(new Object[] {"",j+1,a,tiempoLlegada,momentoLlegada,ti,(ti-momentoLlegada),b,evento,to,(ti+to)});
				
				
				mLla=momentoLlegada;
				TTa=ti+to;
			}
			System.out.println("El total de tiempo de espera en la simulacion "+(i+1)+" es: "+TTa+" segundos");
			tte+=TTa;
		}
		f.setVisible(true);
		System.out.println("El total tiempo de espera en las "+n+" simulaciones es de: "+tte);
		System.out.println("En promedio, "+(tte/(n*100))+" segundos por cada cliente");
	}

}
