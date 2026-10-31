package com.parcial;

/**
 * Elfo: arquero ágil. Su flecha certera suma 2 al daño de su fuerza
 * y su agilidad le permite esquivar parte del daño (recibe el 75%).
 */
public class Elfo extends Criatura {
    private String arco; // Tipo de arco que utiliza el elfo
    private static final int BONO_FLECHA = 2; // Daño extra por puntería

    public Elfo(String nombre, int salud, int fuerza, String arco) {
        super(nombre, salud, fuerza);
        this.arco = arco;
    }

    /** El elfo dispara una flecha: daño = fuerza + bono de puntería. */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() + BONO_FLECHA;
        System.out.println(getNombre() + " (Elfo) dispara con su arco " + arco + " causando " + daño + " de daño a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    /** La agilidad reduce el daño al 75%; siempre recibe al menos 1. */
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño * 3 / 4);
        System.out.println("  " + getNombre() + " esquiva parte del golpe y recibe " + dañoReal);
        recibirDaño(dañoReal);
    }
}