package cz.uhk.merapp.data;

import cz.uhk.util.Seznam;
import cz.uhk.util.impl.SpojovySeznam;

public class Mereni {

    private Seznam<Number> data = new SpojovySeznam<>();

    public void pridat(Number cislo) {
        data.pridej(cislo);
    }

    public Number secist() {
        Number soucet = 0;
        for (int i = 0; i < data.pocet(); i++) {
            var cislo = data.vrat(i);
            soucet = soucet.doubleValue() + cislo.doubleValue();
        }
        return soucet;
    }

    public Number prumer() {
        return  secist().doubleValue() / data.pocet();
    }

    public Number max() {
        Number max = data.vrat(0);
        for (Number cislo : data) {
            if (cislo.doubleValue() > max.doubleValue())
                max = cislo;
        }
        return max;
    }
    public Number min() {
        Number min = data.vrat(0);
        for (Number cislo : data) {
            if (cislo.doubleValue() < min.doubleValue())
                min = cislo;
        }
        return min;
    }

    public Number get(int index) {
        return data.vrat(index);
    }

    public int size() {
        return data.pocet();
    }
}
