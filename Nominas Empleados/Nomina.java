package proyecto2;
import java.util.Scanner;

public class Nomina {
	Trabajador[] tr;
	Scanner sc;

	public Nomina(int tam) {
		tr = new Trabajador[tam];
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Nomina n = new Nomina(10);
		n.tr = n.llenarDatos(10);
		n.tr = n.sueldoTotal(n.tr);
		n.mostrarDatosEmpleado(n.tr);
		System.out.println("");
		System.out.println("Promedio del sueldo para damas: " + n.promSueldo(n.tr, "femenino"));
		System.out.println("Promedio del sueldo para damas: " + n.promSueldo(n.tr, "masculino"));
		n.quienGanaMas(n.tr);
	}

	public Trabajador[] llenarDatos(int tam) {
		Trabajador[] t = new Trabajador[tam];
		t[0] = new Trabajador("Macbeth", "masculino", "semanal", 400, 2800);
		t[1] = new Trabajador("Arturo", "masculino", "quincenal", 435, 6525);
		t[2] = new Trabajador("Lizeth", "femenino", "mensual", 450, 13500);
		t[3] = new Trabajador("Marcella", "femenino", "semanal", 425, 2975);
		t[4] = new Trabajador("Jacobo", "masculino", "semanal", 380, 5700);
		t[5] = new Trabajador("Diana", "femenino", "semanal", 500, 7500);
		t[6] = new Trabajador("Joselyn", "femenino", "quincena", 750, 11250);
		t[7] = new Trabajador("Ramon", "masculino", "quincena", 300, 4500);
		t[8] = new Trabajador("Fernanda", "femenino", "semanal", 480, 14400);
		t[9] = new Trabajador("Ramon", "masculino", "quincena", 600, 18000);

		return t;
	}

	public double pagoHorasExtra(Trabajador emp) {
		double total = 0, costoHE;
		System.out.println("Escribe el numero de horas trabajadas de " + emp.getNombre());
		emp.setHorasTrabajadas(sc.nextInt());
		if (emp.getHorasTrabajadas() > 40) {
			costoHE = (emp.getSueldoDiario() / 8) * 2;
		} else {
			costoHE = 0;
		}
		total = (emp.getHorasTrabajadas() - 40) * costoHE;
		return total;
	}

	public Trabajador[] sueldoTotal(Trabajador[] trab) {
		for (int i = 0; i < trab.length; i++) {
			trab[i].setTotalPago(trab[i].getSdo() + pagoHorasExtra(trab[i]));
		}
		return trab;
	}

	public void mostrarDatosEmpleado(Trabajador[] trab) {
		for (Trabajador t : trab) {
			System.out.println("Nombre: " + t.getNombre() + "  Sueldo total: " + t.getTotalPago());
		}
	}

	public double promSueldo(Trabajador[] trab, String genero) {
		double prom = 0;
		int a = 0;
		for (Trabajador t : trab) {
			if (t.getGenero().equalsIgnoreCase(genero)) {
				prom += t.getSueldoDiario() * 7;
				a++;

			}

		}
		return prom / a;
	}

	public void quienGanaMas(Trabajador[] trab) {
		double mayor = 0;
		double sdo = 0;
		String nom = " ";
		String genero = " ";
		for (Trabajador t : trab) {
			sdo = (t.getHorasTrabajadas() - 40) * ((t.getSueldoDiario() / 8) * 2);
			if (sdo < 0) {
				sdo = 0;
			}
			if (((t.getSueldoDiario() * 7) + sdo) > mayor) {
				mayor = (t.getSueldoDiario() * 7) + sdo;
				nom = t.getNombre();
				genero = t.getGenero();
			}
		}

		System.out.println();
		System.out.println(
				"El empleado que mas gano en la semana es: " + nom + " con $" + mayor + " y es de genero " + genero);
	}
}