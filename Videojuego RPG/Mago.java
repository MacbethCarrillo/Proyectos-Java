package Examen;

public class Mago implements Comando {

	@Override
	public int atacar(Personaje per, int ataque) {
		System.out.println("EL MAGO " +per.nombre+" ESTA ATACANDO");
		ataque = 10 * (per.nivel - per.str);
		return Math.abs(ataque);
	}

	@Override
	public double curar(Personaje per, double curacion) {
		System.out.println(per.nombre+ " Se curo: ");
		curacion = (per.hp * 0.25);
		return curacion;
	}

	@Override
	public int limite(Personaje per, int habilidad) {

		if (per.mp >= 5) {
			habilidad = (int) (Math.random() * 400 + 250);// 250 - 400
			System.out.println(per.nombre+ " Lanzando Bola de Fuego: Costo 5MP");
			return Math.abs(habilidad);
		} else {
			System.out.println("No hay suficiente MP");
			return 0;
		}
	}

}
