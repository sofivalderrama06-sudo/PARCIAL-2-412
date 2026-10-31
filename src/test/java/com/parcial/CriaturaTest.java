package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de la lógica común de Criatura (estaViva, getters y salud mínima en 0). */
class CriaturaTest {

    @Test
    void criaturaNuevaEstaViva() {
        Criatura c = new Guerrero("Conan", 100, 10, "hacha");
        assertTrue(c.estaViva());
    }

    @Test
    void getteresDevuelvenLosValoresDelConstructor() {
        Criatura c = new Mago("Merlín", 90, 16, "Rayo");
        assertEquals("Merlín", c.getNombre());
        assertEquals(90, c.getSalud());
        assertEquals(16, c.getFuerza());
    }

    @Test
    void criaturaConSaludCeroNoEstaViva() {
        Criatura c = new Guerrero("Caído", 0, 10, "espada");
        assertFalse(c.estaViva());
    }

    @Test
    void laSaludNuncaQuedaNegativa() {
        Criatura c = new Mago("Débil", 5, 10, "Chispa");
        c.defender(100); // daño enorme
        assertEquals(0, c.getSalud());
        assertFalse(c.estaViva());
    }
}