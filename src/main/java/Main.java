import cz.uhk.zlomky.Zlomek;

public class Main {

    static void main() {
        IO.println("Projekt ZLOMKY"); // novinka Javy 25, jinak System.out.println()
        IO.println("=================================");

        var a = new Zlomek(); // konstruktor bez parametru = defaultní k.

        a.setCitatel(3);
        a.setJmenovatel(4);

        IO.println("Zlomek : " + a.getCitatel() + " / " + a.getJmenovatel());

        Zlomek b = new Zlomek(4, 5);
        IO.println(b);
    }
}
