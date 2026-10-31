package com.parcial;

/**
 * Clase principal: crea criaturas y simula batallas
 * trabajando únicamente con el tipo genérico Criatura (polimorfismo).
 */
public class Main {

    /**
     * Simula una batalla por turnos: las criaturas se atacan alternadamente
     * hasta que una queda sin salud. Funciona con cualquier subclase de Criatura.
     */
    public static void simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("\n=== BATALLA: " + criatura1.getNombre() + " vs " + criatura2.getNombre() + " ===");
        int turno = 1;
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n-- Turno " + turno + " --");

            criatura1.atacar(criatura2);
            mostrarSalud(criatura1, criatura2);
            if (!criatura2.estaViva()) break; // Si murió, no contraataca

            criatura2.atacar(criatura1);
            mostrarSalud(criatura1, criatura2);
            turno++;
        }
        Criatura ganadora = criatura1.estaViva() ? criatura1 : criatura2;
        System.out.println("\n>>> Ganador: " + ganadora.getNombre() + " con " + ganadora.getSalud() + " de salud");
    }

    /** Muestra la salud actual de ambas criaturas. */
    private static void mostrarSalud(Criatura c1, Criatura c2) {
        System.out.println("  [Salud] " + c1.getNombre() + ": " + c1.getSalud() + " | " + c2.getNombre() + ": " + c2.getSalud());
    }

    public static void main(String[] args) {
        simularBatalla(new Dragon("Smaug", 100, 12, "fuego"),
                       new Guerrero("Aragorn", 120, 15, "espada"));

        simularBatalla(new Mago("Gandalf", 80, 14, "Bola de Fuego"),
                       new Dragon("Drogon", 100, 10, "obsidiana"));

        simularBatalla(new Guerrero("Conan", 110, 13, "hacha"),
                       new Mago("Merlín", 90, 16, "Rayo"));
        simularBatalla(new Elfo("Legolas", 95, 14, "largo"),
                  new Dragon("Smaug", 100, 12, "fuego"));
    }
}