package a;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoFinal {

	public static void main(String[] args) {
		DecimalFormat f = new DecimalFormat("0.00000"); //Formato para los numeros aleatorios
		//Variables totales para la tabla final
		double[] salario = { 0, 0, 0, 0 };
		double[] salarioextra = { 0, 0, 0, 0 };
		double[] ociocamion = { 0, 0, 0, 0 };
		double[] operacionalmacen = { 0, 0, 0, 0 };
		double[] costostotales = { 0, 0, 0, 0 };
		
		//Leer el numero de turnos
		Scanner scn=new Scanner(System.in);
		System.out.print("Ingrese el total de turnos: ");
		int n = scn.nextInt();
		
		//Ciclo de los equipos de 3 al 6
		for (int ne = 3; ne < 7; ne++) {
			//Ciclo de los turnos de 0 a n
			for (int t = 0; t < n; t++) {
				
				System.out.println("Equipo "+(ne)+" Turno "+(t+1)+"/"+n);
				
				//Inicializacion de variables con el formato de hora
				//Posicion 0 para las horas y 1 para los minutos
				int[] tiempollegada = { 11, 00 }; //Tiempo llegada
				int[] tiempoinicio = { 11, 00 };  //Tiempo de inicio de servicio
				int[] tiempoterminacion = { 11, 00 }; //Tiempo de terminacion de servicio
				int[] tiempo2ocamionantes = { 00, 00 }; //Tiempo auxiliar de la cola
				
				// double a[]=
				// {0,0.48355,0.98977,0.06533,0.45128,0.15486,0.19241,0.15997,0.67940,0.90872,0.58997,0.68691,0.73488};
				// double b[] =
				// {0.83761,0.14387,0.51321,0.72472,0.05466,0.84609,0.29735,0.59076,0.76355,0.29549,0.61958,0.17267,0.10061};
				// int x=0;
				
				boolean tomaronalimentos = false; //Variable para saber si ya tomaron alimentos
				
				double a = 0; //Inicializacion primer numero aleatorio
				int cola = 0; //Inicializacion del tamaño de la cola
				int esperacamiontotal = 0; //Total de minutos de la espera del camion
				
				//Impresión de cabeceras
				System.out.println("Num Aleatorio\tTiempo entre llegadas\tTiempo de llegada\tIniciacion del servicio\t\tNumero aleatorio\tTiempo de servicio\tTerminacion del servicio\tOcio del personal\tTiempo de espera del camion\tLongitud de la cola");
				
				//Mientras la hora de inicio sea menor a 7 o si la hora es igual a 7 y los minutos menores a 30
				while (tiempoinicio[0] < 19 || (tiempoinicio[0] == 19 && tiempoinicio[1] < 30)) {
					cola = 0;
					// if(x>12) break;
					int tll = TiempoEntreLlegadas(a); //Obtenemos el tiempo entre llegadas segun la transformada inversa
					tiempollegada = SumaHora(tiempollegada, tll); //El tiempo llegada seria el tiempo llegada anterior más el tiempo obtenido de la tranformada inversa
					int ocio = 0, esperacamion = 0; //Inicializamos el ocio y la espera del camion
					
					
					//Si el tiempo de llegada es menor al de la iniciacion del servicio del 2o camion anterior 
					if (tiempollegada[0] < tiempo2ocamionantes[0] || (tiempollegada[0] == tiempo2ocamionantes[0] && tiempollegada[1] < tiempo2ocamionantes[1])) {
						cola++; //La cola se aumenta
					} else
						cola = 0; 
					//Si el tiempo de llegada es menor al de la iniciacion del servicio del camion anterior
					if (tiempollegada[0] < tiempoinicio[0]	|| (tiempollegada[0] == tiempoinicio[0] && tiempollegada[1] < tiempoinicio[1])) {
						cola++; //La cola se aumenta
					} else
						cola = 0;

					
					//Se actualiza el tiempo del 2o camion anterior
					tiempo2ocamionantes = tiempoinicio.clone();

					//Si el tiempo de terminacion del camion anterior anterior es mayor al de la llegada
					if (tiempoterminacion[0] > tiempollegada[0] || (tiempoterminacion[0] == tiempollegada[0] && tiempoterminacion[1] > tiempollegada[1])) {
						//El tiempo de inicio será el tiempo de terminacion del camion anterior
						tiempoinicio[0] = tiempoterminacion[0];
						tiempoinicio[1] = tiempoterminacion[1];

						//Si son las 3 y no han comido, el tiempo de inicio y la espera incrementan 30min (lo que tardan en comer)
						if (tiempoterminacion[0] == 15 && !tomaronalimentos) {
							tiempoinicio = SumaHora(tiempoinicio, 30);
							tomaronalimentos = true;
							esperacamion += (tiempoinicio[0] - tiempollegada[0]) * 60 + tiempoinicio[1]- tiempollegada[1];
						} else //Sino, la epsera camion es la diferencia entre el tiempo de terminacion del camion anterior menos el tiempo de llegada del cmaion actual
							esperacamion += (tiempoterminacion[0] - tiempollegada[0]) * 60 + tiempoterminacion[1]- tiempollegada[1];
					} else {
						//Si el tiempo de terminacion del camion anterior es menor al del tiempo de llegada
						//El tiempo de inicio del servicio es igual al tiempo de llegada
						tiempoinicio[0] = tiempollegada[0];
						tiempoinicio[1] = tiempollegada[1];
						//El ocio incrementa con la diferencia entre el tiempo de llegada actual y el tiempo de terminacion anterior
						ocio += (tiempollegada[0] - tiempoterminacion[0]) * 60 + tiempollegada[1]- tiempoterminacion[1];
						cola = 0;
					}

					//Si el tiempo de llegada es menor al tiempo de inicio
					if (tiempollegada[0] < tiempoinicio[0] || (tiempollegada[0] == tiempoinicio[0] && tiempollegada[1] < tiempoinicio[1])) {
						cola++;
					} else
						cola = 0;
					
					//Si no hay ocio ni espera del camion, la cola vale 0
					if (esperacamion == 0 && ocio == 0) {
						cola = 0;
					}
					
					
					//Si el tiempo de inicio sobrepasa las 7:30 que es la hora en la que el almacen cierra, se cierra el ciclo
					if (tiempoinicio[0] > 19 || (tiempoinicio[0] == 19 && tiempoinicio[1] >= 30))
						break;
					
					double b = Math.random(); //Se genera el siguiente numero aleatorio

					//Si el tiempo en la que terminan el servicio es la hora de comida (3) van a tomar alimento, y la hora de inicio del siguiente camion aumenta 30min
					if (tiempoterminacion[0] == 15 && !tomaronalimentos) {
						tiempoinicio = SumaHora(tiempoinicio, 30);
						tomaronalimentos = true;
					}
					
					//Se asigna el tiempo del servicio según la transformada inversa y el numero de personas en el equipo sgeun las tablas de las imagenes
					int ts=0;
					switch(ne) {
					case 3:
						ts = TiempoDeServicio3personas(b);break;
					case 4:
						ts = TiempoDeServicio4personas(b);break;
					case 5:
						ts = TiempoDeServicio5personas(b);break;
					case 6:
						ts = TiempoDeServicio6personas(b);break;
					}
					
					//Se suma el tiempo de servicio mas el tiempo de inicio para obtener la hora de terminacion
					tiempoterminacion = SumaHora(tiempoinicio, ts);
					//Se suma la espera del camion
					esperacamiontotal += esperacamion;
					//Se imprimen los datos del camion
					System.out.println(f.format(a) + "\t\t\t" + tll + "\t\t\t" + hora(tiempollegada) + "\t\t\t"	+ hora(tiempoinicio) + "\t\t\t" + f.format(b) + "\t\t\t" + ts + "\t\t\t\t" + hora(tiempoterminacion)+ "\t\t\t\t" + ocio + "\t\t\t" + esperacamion + "\t\t\t\t" + cola);
					
					//Se genera un nuevo numero aleatorio
					a = Math.random();
					// x++;
				}
				
				int[] extra = RestaHora(tiempoterminacion, 1170); //Se obtiene el tiempo extra que el equipo trabajó
				//Se determina el salario extra con los minutos de tiempo extra se multiplica por 37.5 que vale una hora extra y por el tamaño del equipo
				double salarioextrax = 37.5d * ((extra[0] * 60 + extra[1]) / 60d) * ne;
				
				//Se imprimen los resultados del turno
				System.out.println("Salario: " + (200 * ne)); //8horas * 25 pago por hora * personas en el equipo
				if(salarioextrax<0) salarioextrax=0; //Si no trabajaron horas extras, el salario extra es 0
				System.out.println("Salario extra: " + salarioextrax);
				double salariototal=(salarioextrax + 200 * ne);
				System.out.println("Salario total: " + salariototal);
				System.out.println("Espera del camion: " + (esperacamiontotal / 60d * 100));
				
				//Se obtienen las horas que el almacen estuvo abierto, restando la hora en la que terminó menos la hora que abrió (usando minutos)
				int[] horasabierto = RestaHora(tiempoterminacion, 11 * 60);
				
				double ha = horasabierto[0] + horasabierto[1] / 60d; //Se determinan las horas que estuvo abierto
				
				//Se imprimen los resultados del turno
				System.out.println("Operacion del almacen: " + (ha * 500));
				System.out.println("Espera total: " + ((ha * 500) + esperacamiontotal / 60d * 100));
				System.out.println("Costo total: " + ((ha * 500) + esperacamiontotal / 60d * 100 + salariototal));
				
				//Se suman los datos a las variables totales para la tabla final
				salario[ne - 3] += (200 * ne);
				salarioextra[ne - 3] += salarioextrax;
				ociocamion[ne - 3] += (esperacamiontotal / 60d * 100);
				operacionalmacen[ne - 3] += (ha * 500);
				costostotales[ne - 3] += (ha * 500) + esperacamiontotal / 60d * 100+ salariototal;
				System.out.println();
			}
		}
		
		
		//Tabla final con los resultados de los promedios por equipo
		f = new DecimalFormat("00.00000");
		System.out.println("Equipo\tSalario normal\tSalario extra\tOcio camion\tOperacion almacen\tCosto totales");
		double menor=costostotales[0]/n;
		int equipo=0;
		for (int i = 0; i < 4; i++) {
			System.out.println((i + 3) + "\t" + (salario[i] / n) + "\t\t" + f.format(salarioextra[i] / n) + "\t"+ f.format(ociocamion[i] / n) + "\t" + f.format(operacionalmacen[i] / n) + "\t\t"+ f.format(costostotales[i] / n));
			//Se determina el menor costo y el equipo
			if(costostotales[i]/n<menor) {
				menor=costostotales[i]/n;
				equipo=i;
			}
		}
		System.out.println("El equipo de "+(equipo+3)+" personas es el más barato, costando $"+menor);
	}

	public static String hora(int[] h) { //Metodo para mostrar la hora de vector a un formato de 00:00 y formato de 12 horas
		int[] r = h.clone();
		if (r[0] > 12)
			r[0] -= 12;
		DecimalFormat fh = new DecimalFormat("00");
		return fh.format(r[0]) + ":" + fh.format(r[1]);
	}

	public static int TiempoEntreLlegadas(double a) {
		int x = 0;
		if (a > 0)
			x = 20;
		if (a >= 0.02 && a < 0.1)
			x = 25;
		if (a >= 0.1 && a < 0.22)
			x = 30;
		if (a >= 0.22 && a < 0.47)
			x = 35;
		if (a >= 0.47 && a < 0.67)
			x = 40;
		if (a >= 0.67 && a < 0.82)
			x = 45;
		if (a >= 0.82 && a < 0.92)
			x = 50;
		if (a >= 0.92 && a < 0.97)
			x = 55;
		if (a >= 0.97)
			x = 60;
		return x;
	}

	public static int TiempoDeServicio3personas(double a) {
		int x = 20;
		if (a >= 0.05 && a < 0.15)
			x = 25;
		if (a >= 0.15 && a < 0.35)
			x = 30;
		if (a >= 0.35 && a < 0.60)
			x = 35;
		if (a >= 0.60 && a < 0.72)
			x = 40;
		if (a >= 0.72 && a < 0.82)
			x = 45;
		if (a >= 0.82 && a < 0.90)
			x = 50;
		if (a >= 0.90 && a < 0.96)
			x = 55;
		if (a >= 0.96)
			x = 60;
		return x;
	}

	public static int TiempoDeServicio4personas(double a) {
		int x = 15;
		if (a >= 0.05 && a < 0.20)
			x = 20;
		if (a >= 0.20 && a < 0.40)
			x = 25;
		if (a >= 0.40 && a < 0.60)
			x = 30;
		if (a >= 0.60 && a < 0.75)
			x = 35;
		if (a >= 0.75 && a < 0.87)
			x = 40;
		if (a >= 0.87 && a < 0.95)
			x = 45;
		if (a >= 0.95 && a < 0.99)
			x = 50;
		if (a >= 0.99)
			x = 55;
		return x;
	}

	public static int TiempoDeServicio5personas(double a) {
		int x = 10;
		if (a >= 0.1 && a < 0.28)
			x = 15;
		if (a >= 0.28 && a < 0.5)
			x = 20;
		if (a >= 0.5 && a < 0.68)
			x = 25;
		if (a >= 0.68 && a < 0.78)
			x = 30;
		if (a >= 0.78 && a < 0.86)
			x = 35;
		if (a >= 0.86 && a < 0.92)
			x = 40;
		if (a >= 0.92 && a < 0.97)
			x = 45;
		if (a >= 0.97)
			x = 50;
		return x;
	}

	public static int TiempoDeServicio6personas(double a) {
		int x = 5;
		if (a >= 0.12 && a < 0.27)
			x = 10;
		if (a >= 0.27 && a < 0.53)
			x = 15;
		if (a >= 0.53 && a < 0.68)
			x = 20;
		if (a >= 0.68 && a < 0.80)
			x = 25;
		if (a >= 0.80 && a < 0.88)
			x = 30;
		if (a >= 0.88 && a < 0.94)
			x = 35;
		if (a >= 0.94 && a < 0.98)
			x = 40;
		if (a >= 0.98)
			x = 45;
		return x;
	}

	//Metodo para sumar minutos a las horas y regresa un vector
	public static int[] SumaHora(int[] hora, int min) {
		int[] res = { hora[0], hora[1] };
		res[1] += min;
		res[0] += res[1] / 60;
		res[1] -= ((int) (res[1] / 60)) * 60;
		return res;
	}

	//Metodo para restar minutos a las horas y regresa un vector
	public static int[] RestaHora(int[] hora, int min) {
		int[] res = { hora[0], hora[1] };
		res[1] -= min;
		while (res[1] < 0) {
			res[0]--;
			res[1] += 60;
		}
		return res;
	}

}
