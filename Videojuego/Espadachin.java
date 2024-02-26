package Herencia;

public class Espadachin extends Personaje {
    public Espadachin(String nombre, int hp, int mp) {
        super(nombre, "Espadachin", hp, mp);
    }

    @Override
    public String toString() {
        return "Soy el " +this.getClass().getSimpleName() + " " + this.nombre + ". HP: " + this.hp + ". MP: " + this.mp;
    }
}
