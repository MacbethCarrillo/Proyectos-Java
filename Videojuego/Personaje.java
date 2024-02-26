package Herencia;

import java.util.Random;

public class Personaje {
    protected Random rnd;
    protected String nombre, tipo;
    protected int hp, mp;

    public Personaje(String nombre, String tipo, int hp, int mp) {
        rnd = new Random();
        this.nombre = nombre;
        this.tipo = tipo;
        this.hp = hp;
        this.mp = mp;
    }

    public int atacar() {
        int danio = rnd.nextInt(51) + 50;
        return danio;
    }

    public void curar() {
        this.hp = (int)(hp * 1.20);
    }


    public int especial() {

        int danio = 0, mult = 0;
        if ((mp - 5) >= 0) {
            mult = rnd.nextInt(2) + 2;
            danio = atacar() * mult;
            mp -= 5;
        }
        return danio;
    }
}
