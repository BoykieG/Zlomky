package cz.uhk.zlomky;

public class Zlomek {
    private int citatel;
    private int jmenovatel;

    /**
     * Defaultní konstruktor
     */
    public Zlomek() {
        citatel = 0;
        jmenovatel = 1;
    }

    /**
     * Konstruktor s dvěma parametry
     *
     * @param citatel
     * @param jmenovatel musí být různý od 0
     */
    public Zlomek(int citatel, int jmenovatel) {
        this.citatel = citatel;
        this.jmenovatel = jmenovatel;
    }

    // selektory = getry = metody pro čtení dat
    public int getCitatel() {
        return citatel;
    }

    public int getJmenovatel() {
        return jmenovatel;
    }

    //  modifikátory = setry = metody pro změnu/zápis dat
    public void setCitatel(int citatel) {
        this.citatel = citatel;
    }

    public void setJmenovatel(int jmenovatel) {
        this.jmenovatel = jmenovatel;
    }

    @Override
    public String toString() {
        return String.format("%d/%d",citatel, jmenovatel);
    }

    /**
     * Metoda pro sčítání dvou zlomků
     *
     * @param druhy
     * @return nový zlomek, který je součtem obou zlomků
     */
    public Zlomek plus(Zlomek druhy) {
        int jm = jmenovatel * druhy.jmenovatel;
        int cit = citatel * druhy.jmenovatel + druhy.citatel * jmenovatel;
        return new Zlomek(cit, jm);
    }

    public Zlomek zkratit() {
        int delitel = nsd(citatel, jmenovatel); // výpočet největšího společného dělitele

        return new Zlomek(citatel / delitel, jmenovatel / delitel);
    }

    /**
     * Výpočet největšího společného dělitele čísel a a b
     *
     * @param a
     * @param b
     * @return
     */
    private int nsd(int a, int b) {
        if (a < b) {
            var temp = a;
            a = b;
            b = temp;
        }
        int zbytek;
        do {
            zbytek = a % b;
            a = b;
            b = zbytek;
        } while (zbytek != 0);
        return a;
    }
}

