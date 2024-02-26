package Examen;

public class Personaje {

	 protected String nombre;
	 protected int hp , mp, str , nivel;
	 
	public Personaje(String nombre, int hp, int mp, int str, int nivel) {
		this.nombre = nombre;
		this.hp = hp;
		this.mp = mp;
		this.str = str;
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", hp=" + hp + ", mp=" + mp + ", str=" + str + ", nivel=" + nivel + "]";
	}
	 
	 
}
