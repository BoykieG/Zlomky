import cz.uhk.zlomky.Zlomek;

public class Main {

    static void main() {
        IO.println("Projekt ZLOMKY"); // novinka Javy 25, jinak System.out.println()
        IO.println("=================================");

        var a = new Zlomek(); // konstruktor bez parametru = defaultní k.

        a.setCitatel(1);
        a.setJmenovatel(2);

        IO.println("Zlomek : " + a.getCitatel() + " / " + a.getJmenovatel());

        Zlomek b = new Zlomek(3, 4);
        IO.println(b);

        var soucet = a.plus(b);
        var oddil = a.minus(b);
        var soucin = a.krat(b);
        var podil = a.deleno(b);
        IO.println("Soucet je %s".formatted(soucet.zkratit()));
        // System.out.printf("Soucet je %s\n", soucet.zkratit());

        Zlomek[] pole = new Zlomek[] {
                new Zlomek(1, 3),
                new Zlomek(1, 2),
                new Zlomek(6, 5),
                new Zlomek(4, 3),
                new Zlomek(7, 8),
                new Zlomek(13, 10),
        };
        Zlomek prumer = prumer(pole);
        IO.println("Prumer je %s".formatted(prumer.zkratit()));

        int celeCislo = new Zlomek(25,12).intValue();
        IO.println("Zlomek na cele cislo: %d".formatted(celeCislo));
    }

    private static Zlomek prumer(Zlomek[] pole) {
        var soucet = new Zlomek(); // nulový zlomek
        for (var z : pole) {
            soucet = soucet.plus(z);
        }
        var pocet = new Zlomek(pole.length, 1);
        return soucet.deleno(pocet);
    }
}
