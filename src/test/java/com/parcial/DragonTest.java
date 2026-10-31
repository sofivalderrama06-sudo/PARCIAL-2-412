package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de Dragon: ataca con fuerza * 2 y sus escamas absorben 3 de daño. */
class DragonTest {

    @Test
    void ataqueEsElDobleDeLaFuerza() {
        Dragon dragon = new Dragon("Smaug", 100, 12, "fuego");
        Guerrero objetivo = new Guerrero("Aragorn", 100, 10, "espada");
        dragon.atacar(objetivo);
        // daño = 12 * 2 = 24; la armadura del guerrero bloquea 2 -> recibe 22
        assertEquals(78, objetivo.getSalud());
    }

    @Test
    void escamasReducenElDanoEnTres() {
        Dragon dragon = new Dragon("Drogon", 100, 10, "obsidiana");
        dragon.defender(10);
        assertEquals(93, dragon.getSalud()); // 10 - 3 = 7
    }

    @Test
    void siempreRecibeAlMenosUnDano() {
        Dragon dragon = new Dragon("Drogon", 100, 10, "obsidiana");
        dragon.defender(2); // 2 - 3 sería negativo -> mínimo 1
        assertEquals(99, dragon.getSalud());
    }
}