package cz.uhk.zlomky;

public class Zlomek {
    private int citatel;
    private int jmenovatel;

    /**
     * Defaultní konstruktor
     */
    public Zlomek() {}
    /**
     * Konstruktor s dvěma parametry
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
        return String.format(
                "%3d\n-----\n%3d",
                citatel, jmenovatel
        );
    }
}

