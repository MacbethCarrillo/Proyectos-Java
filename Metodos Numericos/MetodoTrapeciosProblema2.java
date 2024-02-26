package Proyectos;

import java.util.*;;

public class MetodoTrapeciosProblema2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int tp, np = 0;
		double error, errorP = 0, vCalc, h, ah = 0, fa = 0, fah = 0, area = 0, a = 0, b = 0, n = 0, ca = 0;

		System.out.println("\t\tINSTITUTO TECNOLOGICO DE CULIACAN");
		System.out.println("\t\tIng. Sistemas Computacionales\n");
		System.out.println("Carrillo Ibarra Macbeth Adolfo");
		System.out.println("Metodo de los trapecios.");
		System.out.println("De 08:00 a 09:00 horas");

		System.out.println(" ");
		System.out.print("Cual es la pregunta del problema?: ");
		String preg = scan.nextLine();
		String auxiliar = "";
		System.out.print("Cual es la unidad que se va a manejar?: ");
		String unidad = scan.nextLine();
		System.out.print("Cual es el valor real?: ");
		double vReal = scan.nextDouble();
		auxiliar = scan.nextLine();
		System.out.print("Cual es el punto inicial del intervalo? ");
		a = scan.nextDouble();
		System.out.print("Cual es el punto final del intervalo? ");
		b = scan.nextInt();
		System.out.print("Cual es el numero de trapecio inicial? ");
		n = scan.nextInt();
		System.out.print("Cual es el error permitido? ");
		error = scan.nextDouble();
		System.out.print("Cuantps procesos se van a realizar? ");
		tp = scan.nextInt();
		ca = a;

		System.out.println("\t\tINSTITUTO TECNOLOGICO DE CULIACAN");
		System.out.println("\t\tIng. Sistemas Computacionales\n");
		System.out.println("Carrillo Ibarra Macbeth Adolfo");
		System.out.println("Metodo de los trapecios.");
		System.out.println("De 08:00 a 09:00 horas");
		System.out.println("Pregunta: " + preg);
		System.out.println("");

		do {
			System.out.println("Proceso #" + (np + 1));
			System.out.printf("| %10s | %10s | %10s | %10s | %10s | %10s|%n", "Trapecio", "a", "a+h", "f(a)", "f(a+h)",
					"Area");
			System.out.println("-------------------------------------------------------------------------------");
			np++;
			vCalc = 0;
			h = (b - a) / n;

			for (double i = 1; i <= n; i++) {
				ah = a + h;
				fa = Math.pow(a, 3) - Math.sin(a + 1);
				fah = Math.pow(ah, 3) - Math.sin(ah + 1);
				area = (h / 2) * (fa + fah);
				vCalc += area;
				System.out.printf("| %10.0f | %10f | %10f |%10f |%10f |%10f |%n", i, a, ah, fa, fah, area);
				a = ah;
			}
			errorP = Math.abs(vReal - vCalc);
			System.out.println("");
			a = ca;
			n = n * 2;
		} while (np < tp && error < errorP);

		System.out.println("---------------------------");
		System.out.println("\t Resultados");
		System.out.println("---------------------------");
		if (errorP < error) {
			System.out.println("No. de procesos: " + np);
			System.out.println("Valor real de la integral: " + vReal + " " + unidad);
			System.out.println("Valor calculado por Trapecios: " + vCalc + " " + unidad);
			System.out.println("Error del problema: " + error);
			System.out.println("Error del metodo: " + errorP);
		} else if (np == tp) {
			System.out.println("La mejor aproximacion no se ha encontrado en " + tp + "procesos");
		}
	}
}
