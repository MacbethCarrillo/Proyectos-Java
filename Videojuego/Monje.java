package Herencia;

public class Monje extends Personaje {
    public Monje(String nombre, int hp, int mp) {
        super(nombre, "Monje", hp, mp);
    }

    @Override
    public int especial() {
        int danio = 0;
        if ((mp - 8) >= 0) {
            danio = rnd.nextInt(101) + 200;
            mp -= 8;
        }
        return danio;
    }

    @Override
    public String toString() {
        return "Soy el " +this.getClass().getSimpleName() + " " + this.nombre + ". HP: " + this.hp + ". MP: " + this.mp;
    }
}
