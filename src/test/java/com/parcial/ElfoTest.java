package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de Elfo: ataca con fuerza + 2 y recibe el 75% del daño. */
class ElfoTest {

    @Test
    void ataqueEsFuerzaMasDos() {
        Elfo elfo = new Elfo("Legolas", 100, 10, "largo");
        Guerrero objetivo = new Guerrero("Conan", 100, 10, "hacha");
        elfo.atacar(objetivo);
        // daño = 10 + 2 = 12; la armadura bloquea 2 -> recibe 10
        assertEquals(90, objetivo.getSalud());
    }

    @Test
    void agilidadReduceElDanoAlSetentaYCincoPorCiento() {
        Elfo elfo = new Elfo("Legolas", 100, 10, "largo");
        elfo.defender(20);
        assertEquals(85, elfo.getSalud()); // 20 * 3 / 4 = 15
    }

    @Test
    void siempreRecibeAlMenosUnDano() {
        Elfo elfo = new Elfo("Legolas", 100, 10, "largo");
        elfo.defender(1); // 1 * 3 / 4 = 0 -> mínimo 1
        assertEquals(99, elfo.getSalud());
    }
}