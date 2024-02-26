import java.util.*;

public class DirectorioT {

	Scanner sn = new Scanner(System.in);
	private Contacto[] contactos;

	public DirectorioT() { // digitos de los contactos

		this.contactos = new Contacto[10];

	}

	public DirectorioT(int tamanio) { // cuantos contactos

		this.contactos = new Contacto[tamanio];

	}

	public void aniadirContactos(Contacto c) { // añadir los contactos

		boolean encontrado = false;
		for (int i = 0; i < contactos.length && !encontrado; i++) {
			if (contactos[i] == null) {
				contactos[i] = c;
				encontrado = true;
			}
		}

		if (encontrado) {
			System.out.println("Se ha añadido el contacto");
		} else {
			System.out.println("No se agrego");
		}

	}// cierra añadir contactos alv

	public void imprimirDirectorio() { // imprime todos los contacos

		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null) {
				System.out.println(contactos[i]);

			}

		}
	} // ciera imprimir el directorio

	public void buscarNombre() {// busca por nombre

		int op;
		boolean encontrado = false;
		System.out.println("Como quiere buscarlo: (1.-ID Contacto) (2.-Nombre)");
		op = sn.nextInt();
		switch (op) {

		case 1:
			System.out.println("Ingrese el id: ");
			int id = sn.nextInt();
			for (int i = 0; i < contactos.length; i++) {

				if (id == contactos[i].getIdContacto()) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su nombre es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());

					encontrado = true;

				}
			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;

		case 2:
			System.out.println("Ingrese el nombre:");
			String nombre = sn.next();

			for (int i = 0; i < contactos.length; i++) {
				if (nombre.equals(contactos[i].getNombre())) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su nombre es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());

					encontrado = true;

				}

			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;

		}

	}// cierra buscar por nombre

	
	
	public void buscarTipoTelefono() { // busca por tipo de telefono
		boolean encontrado = false;
		System.out.println("Movil:");
		for (int i = 0; i < contactos.length; i++) {

			if (contactos[i] != null && contactos[i].getTipoTelefono().equalsIgnoreCase("MOVIL")) {

				System.out.println(contactos[i]);

				encontrado = true;

			}
		}
		System.out.println();
		System.out.println("Casa:");
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null && contactos[i].getTipoTelefono().equalsIgnoreCase("CASA")) {
				System.out.println(contactos[i]);
			}
		}
		System.out.println();
		System.out.println("Oficina:");

		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null && contactos[i].getTipoTelefono().equalsIgnoreCase("OFICINA")) {
				System.out.println(contactos[i]);
			}
		}

	} // cierra tipo telefono

	public void eliminarContacto(Contacto c) {// elimina el contacto

		boolean encontrado = false;
		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null && contactos[i].equals(c)) {
				contactos[i] = null;
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No se ha elminado");
		} else {
			System.out.println("Contacto eliminado");
		}
	}// cierra elminar contacto

	public boolean existeContacto(Contacto c) { // existe contacto //solo valida el nombre

		for (int i = 0; i < contactos.length; i++) {
			if (contactos[i] != null && c.getNumTelefonico() == (contactos[i].getNumTelefonico())) {

				return true;

			}

		}
		return false;
	}// cierra existe contacto

	public void consultarContacto() {
		int op;
		boolean encontrado = false;
		System.out.println("Como quiere buscarlo: (1.-ID Contacto) (2.-Nombre)  (3.-Alias)   (4.-Numero de telefono)");
		op = sn.nextInt();
		switch (op) {

		case 1:
			System.out.println("Ingrese el id: ");
			int id = sn.nextInt();
			for (int i = 0; i < contactos.length; i++) {

				if (id == contactos[i].getIdContacto()) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su apellido es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());
					System.out.println("Su numero de telefono es " + contactos[i].getNumTelefonico());
					encontrado = true;

				}
			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;

		case 2:
			System.out.println("Ingrese el nombre:");
			String nombre = sn.next();

			for (int i = 0; i < contactos.length; i++) {
				if (nombre.equals(contactos[i].getNombre())) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su apellido es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());
					System.out.println("Su numero de telefono es " + contactos[i].getNumTelefonico());

					encontrado = true;

				}

			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;

		case 3:

			System.out.println("Inserte el Alias: ");
			String alias = sn.next();

			for (int i = 0; i < contactos.length; i++) {
				if (alias.equals(contactos[i].getAlias())) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su apellido es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());
					System.out.println("Su numero de telefono es " + contactos[i].getNumTelefonico());
					encontrado = true;

				}
			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;

		case 4:

			System.out.println("Inserte el numero de telefono: ");
			int numTelefono = sn.nextInt();

			for (int i = 0; i < contactos.length; i++) {

				if (numTelefono == contactos[i].getNumTelefonico()) {
					System.out.println("Su nombre es " + contactos[i].getNombre());
					System.out.println("Su apellido es " + contactos[i].getApellido());
					System.out.println("Su email es " + contactos[i].getEmail());
					System.out.println("Su numero de telefono es " + contactos[i].getNumTelefonico());
					encontrado = true;

				}

			}
			if (encontrado == false) {

				System.out.println("Contacto no encontrado");

			}

			break;
		}
	}
}