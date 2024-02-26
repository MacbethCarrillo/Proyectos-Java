package Examen;

import java.util.ArrayList;
import java.util.Random;

public class AppRPG {

	public static void main(String[]args) {
		int nPersonaje;
		ArrayList<Personaje> p = crearPersonaje();
		Random rnd = new Random();
		Comando c;
		for(int i = 0; i<4; i++) {
		nPersonaje = rnd.nextInt(p.size());
		System.out.println("***************************************************");
		System.out.println("Turno "+(i+1));
		c = new Mago();
		System.out.println("El ataque es " + c.atacar(p.get(nPersonaje), 0));
		System.out.println("" + c.curar(p.get(nPersonaje), 0));
		System.out.println("La habilidad es de " + c.limite(p.get(nPersonaje), 0));
		
		nPersonaje = rnd.nextInt(p.size());
		System.out.println("");
		c = new Invocador();
		System.out.println("El ataque es " + c.atacar(p.get(nPersonaje), 0));
		System.out.println("" + c.curar(p.get(nPersonaje), 0));
		System.out.println("La habilidad es de " + c.limite(p.get(nPersonaje), 0));
		
		nPersonaje = rnd.nextInt(p.size());
		System.out.println("");
		c = new Guerrero();
		System.out.println("El ataque es " + c.atacar(p.get(nPersonaje), 0));
		System.out.println("" + c.curar(p.get(nPersonaje), 0));
		System.out.println("La habilidad es de " + c.limite(p.get(nPersonaje), 0));
		
		System.out.println();
		}
	}
	
	
	public static ArrayList<Personaje> crearPersonaje(){
		ArrayList<Personaje> p = new ArrayList<>();
		//(String nombre, int hp, int mp, int str, int nivel)
		p.add(new Personaje("Malzahar", 100, 300, 25 , 40));
		p.add(new Personaje("Veigar", 90, 200, 10, 30));
		p.add(new Personaje("Yorick", 300, 50, 100, 60));
		p.add(new Personaje("Riven", 150, 100, 100, 80));
		p.add(new Personaje("Yi",80, 30, 500, 70));
		p.add(new Personaje("Darius",200, 4, 250, 30));
		p.add(new Personaje("Lilia",60, 100, 30, 55));
												//100 ataque
		return p;
		
	}
}
