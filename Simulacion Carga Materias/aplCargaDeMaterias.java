/*
 * -PROGRAMACION ORIENTADA A OBJETOS-
 * 
 * ALUMNO: MACBETH ADOLFO CARRILLO IBARRA
 * 
 * NO.CONTROL: 19170557
 * 
 * SEMESTRE: 5
 * 
 * PROFESOR: ALDO URIARTE PORTILLO
 * 
 */
package practica;
import java.util.*;

public class aplCargaDeMaterias {
	

	public static void main(String[] args) {
		Scanner Entrada = new Scanner(System.in);

		carga Horario= new carga(10);	//horario es mi objeto
		Horario.materia[0]=new  Materia(1	, " Calculo Diferencial	 ", 4 ,"Grupo EB03", 30, 17, 0);
		Horario.materia[1]=	new Materia(2	, " Base de datos ", 5 ,"Grupo EB03", 45, 32, 0);
		Horario.materia[2]=new Materia(3	, " Ingles ", 1 ,"Grupo EB03", 32, 15, 0);
		Horario.materia[3]=new Materia(4	, " Contabilidad " , 2 ,"Grupo EB03", 30, 22, 0);
		Horario.materia[4]=new Materia(5	, " Administracion de empresas	" , 3 ,"Grupo EB03", 25, 21, 0);
		Horario.materia[5]=new Materia(6	, " Calculo integral " , 6 ,"Grupo EB03", 50, 40, 0);
		Horario.materia[6]=new Materia(7	, " Metodos numericos " , 3 ,"Grupo EB03", 26, 17, 0);
		
			
		int opcion,alumnosMax,alumnosActual,creditos;
		int idMateria=7; int id =0;
		String descripcion,carreraGrupo;
		boolean salir = false;
		Materia c = null;
		
		while (!salir) {
			System.out.println("1.-Agregar una materia");
			System.out.println("2.-Imprimir materias cargadas");
			System.out.println("3.-Añadir la calificacion de la materia");
			System.out.println("4.-Salir");
			opcion = Entrada.nextInt();

			switch (opcion) {
			case 1: 
				idMateria +=1;
				System.out.println("Inserte el nombre de la materia: ");
				descripcion = Entrada.next();
				
				System.out.println("Inserte los creditos: ");
				creditos = Entrada.nextInt();
				
				System.out.println("Inserte el grupo: ");
				carreraGrupo = Entrada.next();
				
				System.out.println("Alumnos maximos: ");
				alumnosMax = Entrada.nextInt();
				
				System.out.println("Alumnos actuales: ");
				alumnosActual = Entrada.nextInt();
				
				if(Horario.grupoLleno(c)) {
					System.out.println("El grupo ya esta lleno");
					idMateria -=1;
				}else {
					
					c = new Materia(idMateria, descripcion, creditos, carreraGrupo, alumnosMax,alumnosActual, 0);
					Horario.aniadirMateria(c);
					
				}
				
				break;
			case 2:
				
				Horario.imprimirMateria();
				
				
				break;

			case 3:
				
				int aux=0;
				System.out.println("Inserte el id de la materia a cargar: ");
				id = Entrada.nextInt();
				
				for(int i=0; i<Horario.materia.length ; i++) {
					if(id == Horario.materia[i].getIdMateria()) {
					
						aux = i;
						c = Horario.materia[i];
							break;
					}
					
				}
				Horario.materia[aux] = Horario.escribirCalificacion(c);
				
				break;
				
			case 4:
				System.out.println("Hasta la proxima");
				salir =true;
				break;
				
				}
			}
		}	//cierra main
	}//cierra clase


