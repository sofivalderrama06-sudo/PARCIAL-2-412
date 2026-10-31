package com.parcial;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;

/** Pruebas del polimorfismo y de la simulación de batallas. */
class MainTest {

    @Test
    void polimorfismoTodasLasCriaturasAtacanComoCriatura() {
        List<Criatura> atacantes = List.of(
                new Dragon("D", 100, 10, "fuego"),
                new Mago("M", 100, 10, "Rayo"),
                new Guerrero("G", 100, 10, "espada"));

        for (Criatura atacante : atacantes) {
            Criatura objetivo = new Guerrero("Blanco", 100, 5, "palo");
            atacante.atacar(objetivo); // mismo método, comportamiento distinto
            assertTrue(objetivo.getSalud() < 100,
                    atacante.getNombre() + " debería haber causado daño");
        }
    }

    @Test
    void laBatallaTerminaConExactamenteUnaCriaturaViva() {
        Criatura c1 = new Dragon("Smaug", 100, 12, "fuego");
        Criatura c2 = new Guerrero("Aragorn", 120, 15, "espada");

        Main.simularBatalla(c1, c2);

        assertTrue(c1.estaViva() ^ c2.estaViva(), "Solo una debe quedar viva");
    }

    @Test
    void laBatallaFuncionaConCualquierCombinacion() {
        Criatura mago = new Mago("Gandalf", 80, 14, "Bola de Fuego");
        Criatura dragon = new Dragon("Drogon", 100, 10, "obsidiana");

        Main.simularBatalla(mago, dragon);

        assertTrue(mago.estaViva() ^ dragon.estaViva());
    }

    @Test
    void laBatallaMuestraElGanador() {
        PrintStream original = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        try {
            Main.simularBatalla(new Guerrero("Conan", 110, 13, "hacha"),
                                new Mago("Merlín", 90, 16, "Rayo"));
        } finally {
            System.setOut(original); // siempre restaurar la salida
        }
        assertTrue(salida.toString().contains("Ganador"));
    }
}