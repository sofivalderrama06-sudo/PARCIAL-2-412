package com.parcial;

/**
 * Guerrero: ataca con su arma (fuerza) y se defiende
 * con su armadura, que bloquea parte del daño.
 */
public class Guerrero extends Criatura {
    private String arma; // Arma que utiliza el guerrero
    private static final int REDUCCION_ARMADURA = 2; // Daño que bloquea la armadura

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    // El guerrero golpea con su arma con daño igual a su fuerza.
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " (Guerrero) golpea con " + arma + " causando " + daño + " de daño a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    // La armadura bloquea parte del daño; siempre recibe al menos 1.
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - REDUCCION_ARMADURA);
        System.out.println("  La armadura de " + getNombre() + " bloquea " + (daño - dañoReal) + ". Recibe " + dañoReal);
        recibirDaño(dañoReal);
    }
}