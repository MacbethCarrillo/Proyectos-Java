package Herencia;

public class Mago extends Personaje {
    public Mago(String nombre, int hp, int mp) {
        super(nombre, "Mago", hp, mp);
    }

    @Override
    public int especial() {
        int danio = 0;
        if ((mp - 10) >= 0) {
            danio = rnd.nextInt(151) + 150;
            mp -= 10;
        }
        return danio;
    }

    @Override
    public String toString() {
        return "Soy el " +this.getClass().getSimpleName() + " " + this.nombre + ". HP: " + this.hp + ". MP: " + this.mp;
    }
}
