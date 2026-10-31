package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de Mago: ataca con su fuerza y su escudo mágico reduce el daño a la mitad. */
class MagoTest {

    @Test
    void ataqueEsIgualALaFuerza() {
        Mago mago = new Mago("Gandalf", 80, 14, "Bola de Fuego");
        Guerrero objetivo = new Guerrero("Conan", 100, 10, "hacha");
        mago.atacar(objetivo);
        // daño = 14; la armadura bloquea 2 -> recibe 12
        assertEquals(88, objetivo.getSalud());
    }

    @Test
    void escudoReduceElDanoALaMitad() {
        Mago mago = new Mago("Merlín", 100, 16, "Rayo");
        mago.defender(10);
        assertEquals(95, mago.getSalud()); // 10 / 2 = 5
    }

    @Test
    void siempreRecibeAlMenosUnDano() {
        Mago mago = new Mago("Merlín", 100, 16, "Rayo");
        mago.defender(1); // 1 / 2 = 0 -> mínimo 1
        assertEquals(99, mago.getSalud());
    }
}