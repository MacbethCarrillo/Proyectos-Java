package proyecto;
import java.util.*;


public class aplTienda {

	public static void main(String[] args) {
		Scanner Entrada = new Scanner(System.in);
		String diaSemana , nombreT;
		int edadT; double total=0;
		boolean salir = false;
		
		ArrayList<Producto> productos = new ArrayList<>();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		productos.add(new Producto("lac-01", "leche", 23.0, "litro", 2 , "lacteo"));
		productos.add(new Producto("car-01", "carne de cerdo", 99.0, "kilo", 1 , "carniceria"));
		productos.add(new Producto("lac-02", "crema", 19.90, "litro", 1 , "lacteo"));
		productos.add(new Producto("lac-03", "mantequilla", 14.50, "pieza", 2 , "lacteo"));
		productos.add(new Producto("car-02", "jamon fud", 160.00, "Kilo", 0.25 , "carniceria"));
		productos.add(new Producto("lac-04", "queso Lala", 140.00, "kilo", 0.50 , "lacteo"));
		productos.add(new Producto("fv-01", "platano", 21.00, "kilo", 1.50 , "frutas"));
		productos.add(new Producto("fv-02", "manzana", 39.00, "kilo", 0.75 , "frutas"));
		productos.add(new Producto("ag-01", "sopa knorr", 15.50, "pieza", 2 , "general"));
		productos.add(new Producto("ag-02", "pure del fuerte", 6.50, "pieza", 2 , "general"));
		
		
		Cliente c = new Cliente();
		adultoMayor cM = new adultoMayor();
		
		//while (!salir) {
			System.out.println("*************BIENVENIDO A SUPERMERCADOS MAC*************");	
			
				System.out.println(productos);
				System.out.println();
			
			System.out.println("Ingrese su nombre: ");
			nombreT = Entrada.next();
			
			System.out.println("Ingrese su edad: ");
			edadT = Entrada.nextInt();
		
			if(edadT>=60) {
				
				clientes.add(new adultoMayor(nombreT, edadT));
			}else {
				clientes.add(new Cliente(nombreT,edadT));
			}
			
			
				
			int op = (int)(Math. random()*7+1);
			switch (op) {
			case 1:
				diaSemana= "Lunes";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				
				c.RetirarProductosMarca(productos, total);
				c.promocionSemanal(productos, diaSemana);
 
				break;

			case 2:
				diaSemana = "Martes";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				
				
				if(edadT>=60) {
					cM.promocionSemanal(productos, diaSemana);
					cM.RetirarProductosMarca(productos, total);
				}
				else {
					c.promocionSemanal(productos, diaSemana);
					c.RetirarProductosMarca(productos, total);
				
				}

				break;

			case 3:
				diaSemana = "Miercoles";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				
				
				c.promocionSemanal(productos, diaSemana);
				c.RetirarProductosMarca(productos, total);
				
				break;
				
			case 4 : 
				diaSemana = "Jueves";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);

				
				c.promocionSemanal(productos, diaSemana);
				c.RetirarProductosMarca(productos, total);
				break;
				
			case 5:
				diaSemana = "Viernes";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				c.promocionSemanal(productos, diaSemana);
				c.RetirarProductosMarca(productos, total);
				break;
				
			case 6: 
				diaSemana = "Sabado";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				if(edadT>=60) {
					cM.promocionSemanal(productos, diaSemana);
					cM.RetirarProductosMarca(productos, total);
				}
				else {
					c.promocionSemanal(productos, diaSemana);
					c.RetirarProductosMarca(productos, total);
				}
				
				break;
			case 7:
				diaSemana = "Domingo";
				System.out.println("Bienvenido el dia de la semana es: "+diaSemana);
				System.out.println("Hola "+nombreT);
				c.promocionSemanal(productos, diaSemana);
				c.RetirarProductosMarca(productos, total);
				break;
			
			//}

		}

	}

}
