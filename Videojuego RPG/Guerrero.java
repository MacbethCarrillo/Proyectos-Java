package Examen;

public class Guerrero implements Comando{

	@Override
	public int atacar(Personaje per, int ataque) {
		System.out.println("EL GUERRERO "+per.nombre+ " ESTA ATACANDO");
		ataque = 10 * (per.nivel - per.str);
		return Math.abs(ataque);
	}

	@Override
	public double curar(Personaje per, double curacion) {
		System.out.println(per.nombre+" se curo:");
		curacion = (per.hp * 0.25);
		return curacion;
	}

	@Override
	public int limite(Personaje per, int habilidad) {
		if(per.mp>=300){
			System.out.println(per.nombre+" Lanzando Hablidad :Coste 300 MP del Mago");
			int random = (int) (Math.random() * 500 + 300);
			habilidad = random;
			return Math.abs(habilidad);
		}else {
			System.out.println("No hay suficiente MP");
			return 0;
		}

	}

}
