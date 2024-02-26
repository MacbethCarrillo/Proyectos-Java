package Herencia

public class AppRPG {
    public static void main(String[] args) {
        Espadachin espadachin = new Espadachin("Cloud", 700, 20);
        Mago mago = new Mago("Malzahar", 500, 30);
        Monje monje = new Monje("Leesin", 400, 40);
        Enemigo enemigo = new Enemigo("Troll", 1000, 50);

        int danio = 0;

        danio = espadachin.atacar();
        System.out.println("Espadachin ataca a enemigo");
        System.out.println("HP enemigo: " + enemigo.hp);
        enemigo.hp -= danio;
        System.out.println("HP enemigo: " + enemigo.hp);
        System.out.println();

        System.out.println("Enemigo ataca a monje");
        danio = enemigo.atacar();
        System.out.println("HP monje: " + monje.hp);
        monje.hp -= danio;
        System.out.println("HP monje: " + monje.hp);
        System.out.println();

        System.out.println("Especial mago negro a enemigo");
        danio = mago.especial();
        System.out.println("HP enemigo: " + enemigo.hp);
        enemigo.hp -= danio;
        System.out.println("HP enemigo: " + enemigo.hp);
        System.out.println();

        System.out.println("Enemigo ataca a monje");
        danio = enemigo.megaAtaque(monje);
        System.out.println("HP monje: " + monje.hp);
        monje.hp -= danio;
        System.out.println("HP monje: " + monje.hp);
        System.out.println();

        System.out.println("Monje ataca a enemigo");
        danio = monje.especial();
        System.out.println("HP enemigo: " + enemigo.hp);
        enemigo.hp -= danio;
        System.out.println("HP enemigo: " + enemigo.hp);
        System.out.println();

        System.out.println("Enemigo ataca a monje");
        danio = enemigo.megaAtaque(monje);
        System.out.println("HP monje: " + monje.hp);
        monje.hp -= danio;
        System.out.println("HP monje: " + monje.hp);
        System.out.println();
    }
}
