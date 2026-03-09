package cz.uhk.util.impl;

import cz.uhk.util.Seznam;

import java.util.Iterator;

public class SpojovySeznam<E> implements Seznam<E> {
    private PrvekSeznamu<E> prvni, posledni;

    @Override
    public void pridej(int pozice, E hodnota) {
        var novy = new PrvekSeznamu<E>(hodnota);
        if (pozice == 0) {
            // vkládáme na začátek
            novy.dalsi = prvni;
            prvni = novy;
            if (posledni == null) posledni = novy;
        } else {
            // najdeme prvek před cílovou pozicí
            var pred = vratPrvek(pozice - 1);
            if (pred != null) {
                novy.dalsi = pred.dalsi;
                pred.dalsi = novy;
                if (novy.dalsi == null) posledni = novy; // vloženo na konec
            }
        }
    }

    @Override
    public void smaz(int pozice) {
        if (pozice == 0) {
            prvni = prvni.dalsi;
        } else {
            var pom = vratPrvek(pozice - 1);
            pom.dalsi = pom.dalsi.dalsi;
        }

    }

    @Override
    public E vrat(int pozice) {
        var prvek = vratPrvek(pozice);
        return (prvek != null) ? prvek.hodnota : null;
    }

    private PrvekSeznamu<E> vratPrvek(int pozice) {
        var pom = prvni;
        for (int i = 0; i < pozice && pom != null; i++, pom = pom.dalsi);
        return pom;
    }

    @Override
    public int pocet() {
        var pom = prvni;
        int pocet = 0;
        while (pom != null) {
            pom = pom.dalsi;
            pocet++;
        }
        return pocet;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            PrvekSeznamu<E> aktualni = prvni;
            @Override
            public boolean hasNext() {
                return aktualni.dalsi != null;
            }

            @Override
            public E next() {
                aktualni = aktualni.dalsi;
                return aktualni.hodnota;
            }
        };
    }
}

// typ prvku v seznamu s hodnotou zatim neznameho typu
class PrvekSeznamu<E> {
    E hodnota;
    PrvekSeznamu<E> dalsi;

    public PrvekSeznamu(E hodnota) {
        this.hodnota = hodnota;
    }
}