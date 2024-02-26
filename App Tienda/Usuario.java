package Proyecto;
//**********************MACBETH ADOLFO CARRILLO IBARRA**************************
import java.util.*;

public class Usuario {				
	
	protected String nombre, tipo, contrasenia;
	protected int id;
	ArrayList<Usuario> usuarios = new ArrayList<>();
	ArrayList<Productos> productos = new ArrayList<>();
	
	Scanner Entrada = new Scanner(System.in);

	public Usuario() {
	}

	public Usuario(int id, String nombre, String tipo, String contrasenia) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public int getId() {
		return id;
	}

	public void vender(Productos p) {
		
		
        int ventas;
        boolean flag=true;
        while(flag) {
            System.out.println("Ingresar ID de producto que desea comprar: ");
            int idee = Entrada.nextInt();
            if(idee==0) {
                flag=false;
                break;
            }
            
            if(p !=null) {
                System.out.println("Introduzca la cantidad: ");
                int num = Entrada.nextInt();
                if(p.getCantidad()<=num){
                    System.out.println("El producto "+ p.getCantidad()+" No cuenta con existencias");
                }else {
                    for(Productos pro: productos) {
                        if(pro.cantidad>0)
                            flag=true;
                        {
                            pro.cantidad-=1;
                            System.out.println(p.getCantidad()+ " agregado");
                            ventas = p.getCantidad();
                        }
                    }
                }
            }else {
                break;
            }
        }
    }

    public void consultarExistencia() {
    	int total=0;
        System.out.println("Ingrese el ID: ");
        int con = Entrada.nextInt();
        for(Productos p: productos) {
            if(con == id) {
                total = p.getCantidad();
                break;
            }
        }
        System.out.println("la cantidad que tiene es de"+total);

    }

	

	protected int menu() {
		while (true) {
			System.out.println("*************************");
			System.out.println("MENU DE LA TIENDA OXXO");
			System.out.println("*************************");

		}

	}
			
	public void add(Usuario usuarios) {} // auxiliar

	public boolean validarLogin(ArrayList<Usuario> usuarios, String cargo) {
		String contraseniaLogin;
		System.out.println("Introduzca la contraseña: ");
		contraseniaLogin = Entrada.next();

		for (Usuario usuario : usuarios) {
			if (usuario.getContrasenia().equals(contraseniaLogin) && usuario.getTipo().equals(cargo)) {
				System.out.println("Entrando al Sistema...");
				return true;
			}

		}
		System.out.println("Contraseña incorrecta");
		return false;
	}
}
