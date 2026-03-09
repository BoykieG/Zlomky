package cz.uhk.util;

/**
 * Rozhrani seznamu prvku
 * @param <E> typ prvku
 */
public interface Seznam<E> extends Iterable<E> {
    // NOVÉ: přidání na zadanou pozici
    void pridej(int pozice, E prvek);

    void smaz(int pozice);

    E vrat(int pozice);

    int pocet();
}