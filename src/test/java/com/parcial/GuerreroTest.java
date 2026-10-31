package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/** Pruebas de Guerrero: ataca con su fuerza y su armadura bloquea 2 de daño. */
class GuerreroTest {

    @Test
    void ataqueEsIgualALaFuerza() {
        Guerrero guerrero = new Guerrero("Aragorn", 120, 15, "espada");
        Dragon objetivo = new Dragon("Smaug", 100, 12, "fuego");
        guerrero.atacar(objetivo);
        // daño = 15; las escamas absorben 3 -> recibe 12
        assertEquals(88, objetivo.getSalud());
    }

    @Test
    void armaduraBloqueaDosDeDano() {
        Guerrero guerrero = new Guerrero("Conan", 100, 13, "hacha");
        guerrero.defender(10);
        assertEquals(92, guerrero.getSalud()); // 10 - 2 = 8
    }

    @Test
    void siempreRecibeAlMenosUnDano() {
        Guerrero guerrero = new Guerrero("Conan", 100, 13, "hacha");
        guerrero.defender(1); // 1 - 2 sería negativo -> mínimo 1
        assertEquals(99, guerrero.getSalud());
    }
}