package Herencia;

public class Enemigo extends Personaje {
    public Enemigo(String nombre, int hp, int mp) {
        super(nombre, "Enemigo", hp, mp);
    }

    @Override
    public int especial() {
        return 0;
    }

    public int especial(Personaje p) {
        return megaAtaque(p);
    }

    public int megaAtaque(Personaje p) {
        int danio = 0;
        if ((mp - 20) >= 0) {
            danio = (int)(p.hp * 0.50);
        }
        return danio;
    }

    @Override
    public String toString() {
        return "Soy el " +this.getClass().getSimpleName() + " " + this.nombre + ". HP: " + this.hp + ". MP: " + this.mp;
    }
}
