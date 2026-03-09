package cz.uhk.merapp;

import cz.uhk.merapp.data.Mereni;
import cz.uhk.zlomky.Zlomek;

public class MereniApp {
    public static void main(String[] args) {
        var mereni = new Mereni();
        mereni.pridat(new Zlomek(12, 7));
        mereni.pridat(new Zlomek(8, 9));
        mereni.pridat(new Zlomek(1, 4));
        mereni.pridat(new Zlomek(7, 6));
        mereni.pridat(new Zlomek(14, 12));
        mereni.pridat(new Zlomek(31, 7));
        mereni.pridat(10);
        mereni.pridat(12.8);
        mereni.pridat(10E207);
        mereni.pridat(10235);
        mereni.pridat(-15.4f);

        IO.println("Soucet je %g".formatted(mereni.secist()));
        IO.println("Prumer je %g".formatted(mereni.prumer()));
        IO.println("Maximum je %g".formatted(mereni.max()));
        IO.println("Minimum je %g".formatted(mereni.min()));

        for (int i = 0; i < mereni.size(); i++) {
            Number m = mereni.get(i);
            if(m instanceof Float || m instanceof Double)
            IO.println("%g".formatted(m));
            else
                IO.println(m);
        }
    }
}
