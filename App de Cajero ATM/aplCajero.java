package ayuda;
import java.util.*;;


public class aplCajero {

	public static void main(String[]args) {
		int op , nCuenta;
		ArrayList<Cuenta> al = crearCuenta();
		Operacion oper;
		Random rnd = new Random();
		
		do {
			nCuenta = rnd.nextInt(al.size());
			op = menu();
			switch (op) {
			case 1:
				oper = new Retiro();
				System.out.println("Saldo actual: "+ oper.realizarOperacion(al.get(nCuenta), 4000));
				break;
			case 2:
				oper = new Deposito();
				System.out.println(oper.realizarOperacion(al.get(nCuenta), 5000));
				break;
			case 3:
				oper = new ConsultaSaldo(); 
				System.out.println("Saldo actual: "+ oper.realizarOperacion(al.get(nCuenta), 0));
				break;
			case 4: 
				oper = new CambiarNIP();
				if(oper.realizarOperacion(al.get(nCuenta), 0 ) == 0) {
					System.out.println("No se puede cambiar el NIP");
				}else {
					System.out.println("Cambio de NIP realizado");
				}
			}
		}
		while(op>=1 && op<=4);
	}
	
	public static int menu() {
		Scanner Entrada = new Scanner(System.in);
		System.out.println();
		System.out.println("**********MENU************");
		System.out.println("1. Retiro en efectivo");
		System.out.println("2. Deposito en efectivo");
		System.out.println("3. Consultar saldo");
		System.out.println("4. Cambiar NIP");
		System.out.println("5. Salir");
		
		
		return Entrada.nextInt();
		
	}
	public static ArrayList<Cuenta> crearCuenta(){
		ArrayList<Cuenta> al = new ArrayList<>();
		al.add(new Cuenta("6566", "David", "Nomina" , "1234", "45656", 90000));
		al.add(new Cuenta("9873", "Alan", "Ahorro" , "9874", "98724", 60000));
		al.add(new Cuenta("3184", "Gilberto", "Nomina" , "4531", "475138", 9000));
		al.add(new Cuenta("4268", "Eliu", "Ahorro" , "9974", "68741", 15000));
		return al;
		
		
	}
}
