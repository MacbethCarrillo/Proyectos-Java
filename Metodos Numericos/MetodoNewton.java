package Proyectos;

import java.util.*;

public class MetodoNewton {

	public static void main(String[] args) {
		Scanner Entrada = new Scanner(System.in);
		
		float x1=0,x2=0,error=0,fx1=0,fx2=0,fdx1=0;
		int tc=0,nc=0;
		
		System.out.println("INSTITUTO TECNLOGICO DE CULIACAN");
		System.out.println("Ing. Sistemas Computacionales");
		System.out.println("Raices de una ecuacion metodo Newton Raphson");
		System.out.println("MACBETH ADOLFO CARRILLO IBARRA");
		System.out.println("Hora: 08:00a.m a 09:00a.m");
		System.out.println();
		System.out.println("Introduzca la pregunta: ");
		Entrada.nextLine();
		
		System.out.println("Intervalo del punto x1: ");
		x1 = Entrada.nextFloat();
		System.out.println("Margen de error: ");
		error = Entrada.nextFloat();
		System.out.println("Limites de iteraciones del calculo: ");
		tc=Entrada.nextInt();
		
		nc=1;
		fx1 = (float)((float)(Math.pow(x1, 3))+(3.5*(Math.pow(x1, 2)))-40);
		
		System.out.printf("%s %13s %17s %18s %18s %17s \n","NC","X1","F(X1)","F!x1","X2","f(X2)");
		System.out.println("___________________________________________________________________________________________");
		do 
		{
			fdx1 = ((float)(3*(Math.pow(x1, 2)))+(7*(x1)));
			
			x2 = (x1-(fx1/fdx1));
			fx2 = (float)((float)(Math.pow(x2,3))+(3.5*(Math.pow(x2, 2)))-40);
			
			System.out.println("  "+nc +"\t|"+String.format("%f",x1)
			+"\t|"+String.format("%f",fx1)
			+"\t|"+String.format("%f",fdx1)
			+"\t|"+String.format("%f",x2)
			+"\t|"+String.format("%f",fx2));
			
			if(Math.abs(fx2)>error) {
				x1 = x2;
				fx1 = fx2;
				nc = nc+1;
			}
		}
		
			while ((nc <= tc)&& (Math.abs(fx2)>error)); 
				System.out.println("_____________________________________________________________________________________");
				System.out.println();
				
				if(Math.abs(fx2)<=error) {
					System.out.println("La raiz de la ecuacion= "+String.format("%8f", x2));
				}
				else{
					System.out.println("No se encontro la solucion");
				}
			}
			
		}