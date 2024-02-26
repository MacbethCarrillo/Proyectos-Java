package Proyecto;

public class Cajero extends Usuario{ 

	Productos p;
	
	public Cajero() {}
	
	public Cajero( int id,String nombre, String tipo, String contrasenia) {
		super(id ,nombre,tipo,contrasenia );
		
	}
	protected int menu() {
		boolean salir = true;
		while (salir) {
			int op;
			System.out.println("MENU DE CAJERO");
			System.out.println("_______________________________");
			System.out.println("1.-Vender");
			System.out.println("2.-Salir");
			System.out.println("_______________________________");
			op = Entrada.nextInt();

			switch (op) {
			case 1:
				vender(p);
				
				break;
			case 2:
				System.out.println("Saliendo...");
				System.out.println();
				salir = false;
				break;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "El cajero debe vender";
	}
	
}
