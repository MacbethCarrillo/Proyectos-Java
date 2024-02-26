
import java.util.*;
public class aplAgendaContactos {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		DirectorioT agendaTelefonica = new DirectorioT(10);

		boolean salir = false;
		int opcion, idContacto = 0, numTelefonico;
		String nombre;
		String apellido;
		String alias;
		String tipoTelefono;
		String email;
		Contacto c;

		while (!salir) {
			System.out.println("");
			System.out.println("1.-Agregar Contacto");
			System.out.println("2.-Imprimir directorio telefonico");
			System.out.println("3.-Imprimir ordenado por tipo de telefono");
			System.out.println("4.-Buscar un contacto");
			System.out.println("5.-Eliminar contacto");
			System.out.println("6.-Consultar un contacto");
			System.out.println("7.-SALIR");
			opcion = sn.nextInt();

			switch (opcion) {
			case 1:

				idContacto += 1;
				System.out.println("Escribe un nombre: ");
				nombre = sn.next();
				System.out.println("Escriba su apellido: ");
				apellido = sn.next();
				System.out.println("Escriba un alias: ");
				alias = sn.next();
				System.out.println("Escriba tipo de telefono: (movil, casa, oficina)");
				tipoTelefono = sn.next();
				System.out.println("Escriba su email: ");
				email = sn.next();
				System.out.println("Escribe un numero telefonico: ");
				numTelefonico = sn.nextInt();

				c = new Contacto(idContacto, nombre, apellido, alias, tipoTelefono, email, numTelefonico);
				if (agendaTelefonica.existeContacto(c)) {
					idContacto -= 1;
					System.out.println("El contacto ya existe, no agregado");
				} else {
					agendaTelefonica.aniadirContactos(c);

				}
				break;

			case 2:

				agendaTelefonica.imprimirDirectorio();

				break;

			case 3:

				agendaTelefonica.buscarTipoTelefono();

				break;

			case 4:

				agendaTelefonica.buscarNombre();

				break;

			case 5:

				System.out.println("Escriba el nombre: ");
				nombre = sn.next();

				c = new Contacto(nombre, 0);

				agendaTelefonica.eliminarContacto(c);

				break;

			case 6:

				agendaTelefonica.consultarContacto();

				break;

			case 7:
				System.out.println("Hasta luego");
				salir = true;

				break;

			}

		}

	}

}