package com.parcial;

/**
 * Mago: ataca con hechizos (fuerza) y se defiende
 * con un escudo mágico que reduce el daño a la mitad.
 */
public class Mago extends Criatura {
    private String hechizos; // Hechizo principal del mago

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    // El mago lanza un hechizo con daño igual a su fuerza. 
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " (Mago) lanza el hechizo " + hechizos + " con " + daño + " de daño a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    // El escudo mágico reduce el daño a la mitad; siempre recibe al menos 1. 
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño / 2);
        System.out.println("  El escudo mágico de " + getNombre() + " reduce el daño a " + dañoReal);
        recibirDaño(dañoReal);
    }
}