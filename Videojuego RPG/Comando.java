package Examen;

public interface Comando {

	public int atacar(Personaje per ,int ataque);
	
	public double curar(Personaje per ,double curacion);
	
	public int limite(Personaje per ,int habilidad);
	
}
