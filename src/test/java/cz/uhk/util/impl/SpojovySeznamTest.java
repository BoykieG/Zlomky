package cz.uhk.util.impl;

import cz.uhk.util.Seznam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpojovySeznamTest {
    Seznam<Integer> seznam;

    @BeforeEach
    void setupData() {
        seznam = new SpojovySeznam<>();
    }

    @Test
    void pridej() {
        initData();
        assertEquals(4, seznam.pocet());
    }

    @Test
    void smaz() {
        initData();
        seznam.smaz(1);
        assertEquals(3, seznam.pocet());
        assertEquals(30, seznam.vrat(1));
    }

    private void initData() {
        seznam.pridej(10);
        seznam.pridej(20);
        seznam.pridej(30);
        seznam.pridej(40);
    }

    @Test
    void vrat() {
        initData();

        assertEquals(10, seznam.vrat(0));
        assertEquals(20, seznam.vrat(1));
        assertEquals(40, seznam.vrat(seznam.pocet()-1));
        assertNull(seznam.vrat(100));
    }

    @Test
    @DisplayName("Pocet prvku")
    void pocet() {
        assertEquals(0,seznam.pocet(), "pocet - prazdny seznam");
        initData();
        assertEquals(4,seznam.pocet(), "pocet - 2 prvky");
    }

    @Test
    @DisplayName("Pridej na pozici")
    void pridejNaPozici() {
        initData(); // [10, 20, 30, 40]

        // vložení doprostřed
        seznam.pridej(1, 99);          // [10, 99, 20, 30, 40]
        assertEquals(5, seznam.pocet());
        assertEquals(99, seznam.vrat(1));
        assertEquals(20, seznam.vrat(2)); // původní prvek se posunul

        // vložení na začátek
        seznam.pridej(0, 5);           // [5, 10, 99, 20, 30, 40]
        assertEquals(6, seznam.pocet());
        assertEquals(5, seznam.vrat(0));
        assertEquals(10, seznam.vrat(1));

        // vložení na konec
        seznam.pridej(seznam.pocet(), 100); // neprojde přes vratPrvek – mimo rozsah, nic se nepřidá
        // pokud chcete testovat vložení na poslední platnou pozici:
        seznam.pridej(seznam.pocet() - 1, 77);
        assertEquals(77, seznam.vrat(seznam.pocet() - 2));
    }
}