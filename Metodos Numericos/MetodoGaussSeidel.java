package Proyectos;

import java.util.*;;

public class MetodoGaussSeidel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numEcuaciones, tc, contador = 0;
		double error, errorTotal = 0;
		System.out.println("\t\tINSTITUTO TECNOLOGICO DE CULIACAN");
		System.out.println("\t\tIng. Sistemas Computacionales\n");
		System.out.println("Macbeth Adolfo Carrillo Ibarra");
		System.out.println("Solucion de Sistemas de ecuaciones. Metodo de Gauss Seidel");
		System.out.println("De 08:00 a 09:00 horas");

		System.out.println(" ");
		String auxiliar = "";
		System.out.print("Ingrese el numero de ecuaciones que tiene el problema: ");
		numEcuaciones = scan.nextInt();
		auxiliar = scan.nextLine();

		String[] resultados = new String[numEcuaciones];
		double[] vant = new double[numEcuaciones];
		double[] vact = new double[numEcuaciones];

		for (int i = 0; i < numEcuaciones; i++) {
			System.out.print("Ingrese el nombre del concepto de X" + (i + 1) + ": ");
			auxiliar = scan.nextLine();
			resultados[i] = auxiliar;
			System.out.print("Ingrese el valor inicial de X" + (i + 1) + ": ");
			vant[i] = scan.nextDouble();
			scan.nextLine();
			vact[i] = 0;
			System.out.println("");
		}

		double[][] Matriz = new double[numEcuaciones][numEcuaciones + 1];

		System.out.println("Ingrese el numero maximo de calculos a realizar: ");
		tc = scan.nextInt();
		System.out.println("Ingrese el tamaño del error");
		error = scan.nextDouble();

		System.out.println("\nCaptura de datos  de la matriz:");
		for (int i = 0; i < numEcuaciones; i++) {
			System.out.println("Ingrese los datos de la ecuacion " + (i + 1) + ":");
			for (int j = 0; j < numEcuaciones + 1; j++) {
				if (j == numEcuaciones)
					System.out.print("Resultado de ecuacion: ");
				else
					System.out.print("x" + (j + 1) + ": ");
				Matriz[i][j] = scan.nextInt();
			}
		}

		System.out.println("\t\tINSTITUTO TECNOLOGICO DE CULIACAN");
		System.out.println("\t\tIng. Sistemas Computacionales\n");
		System.out.println("Macbeth Adolfo Carrillo Ibarra");
		System.out.println("Solucion de Sistemas de ecuaciones. Metodo de Gauss Seidel");
		System.out.println("De 08:00 a 09:00 horas");

		System.out.println("Pregunta: Cual es el precio de la Vitamina B , C , D y E.");

		System.out.println(
				"\n--------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print("No.\t\t");
		for (int i = 0; i < numEcuaciones; i++)
			System.out.print(resultados[i] + "\t\t");
		System.out.println("ErrorTotal");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.print(contador + "\t\t");

		for (int i = 0; i < numEcuaciones; i++) {
			System.out.print("| " + String.format("%.6f", vant[i]) + "\t\t");
		}

		System.out.println(errorTotal);
		do {

			errorTotal = 0;
			for (int i = 0; i < numEcuaciones; i++) {
				errorTotal = errorTotal + (Math.abs((Math.abs(vact[i]) - (Math.abs(vant[i])))));
			}
			
			for (int i = 0; i < numEcuaciones; i++) {
				double suma = 0;
				double coef = Matriz[i][i];
				suma = Matriz[i][numEcuaciones];
				for (int j = 0; j < numEcuaciones; j++) {
					if (j == i)
						;
					else if (j < i)
						suma = suma + (Matriz[i][j] * (-1) * vact[j]);
					else
						suma = suma + (Matriz[i][j] * (-1) * vant[j]);
				}
				vact[i] = suma / coef;
			}

			contador++;
			System.out.print(contador + "\t\t");
			for (int i = 0; i < numEcuaciones; i++) {
				System.out.print("| " + String.format("%.6f", vact[i]) + "\t\t");
				vant[i] = vact[i];
			}
			System.out.println(errorTotal);

			if (errorTotal < error)
				break;
		} while (contador < tc);
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println("\nRESULTADOS:");
		for (int i = 0; i < numEcuaciones; i++) {
			System.out.println(resultados[i] + " = " + String.format("%.6f", vact[i]) + " " + " Cajas");
		}

		scan.close();
	}

}