package Examen;

public class Invocador implements Comando{

	@Override
	public int atacar(Personaje per, int ataque) {
		System.out.println("EL INVOCADOR "+per.nombre+ " ESTA ATACANDO");
		ataque = 10 * (per.nivel - per.str);
		return Math.abs(ataque);
	}

	@Override
	public double curar(Personaje per, double curacion) {
		System.out.println(per.nombre+" se curo: ");
		curacion = (per.hp * 0.25);
		return curacion;
	}

	@Override
	public int limite(Personaje per, int habilidad) {
		int random = (int) (Math.random() * 4 + 2);
		
		if (per.mp >= 10) {
			System.out.println(per.nombre+" Lanzando habilidad: Coste 10MP");
			habilidad = (10 * (per.str - per.nivel)) * random; //entre 2 y 4
			return Math.abs(habilidad);
		}else {
			System.out.println("No hay MP suficiente");
			return 0;
		}
		
	}

}
