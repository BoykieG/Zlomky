package cz.uhk.merapp.data;

import cz.uhk.util.Seznam;
import cz.uhk.util.impl.SpojovySeznam;

import java.util.ArrayList;
import java.util.List;

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
        return  secist().doubleValue() / data.size();
    }

    public Number max() {
        Number max = data.vrat();
        for (Number cislo : data) {
            if (cislo.doubleValue() > max.doubleValue())
                max = cislo;
        }
        return max;
    }
    public Number min() {
        Number min = data.vrat();
        for (Number cislo : data) {
            if (cislo.doubleValue() < min.doubleValue())
                min = cislo;
        }
        return min;
    }

    public Number get(int index) {
        return data.get(index);
    }

    public int size() {
        return data.size();
    }
}
