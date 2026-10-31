package com.parcial;

/**
 * Dragón: criatura con un ataque muy poderoso (fuerza * 2)
 * y escamas que reducen el daño que recibe.
 */
public class Dragon extends Criatura {
    private String escamas; // Tipo de escamas del dragón
    private static final int REDUCCION_ESCAMAS = 3; // Daño que absorben las escamas

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    //El dragón ataca con una llamarada: el daño es el doble de su fuerza. 
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2;
        System.out.println(getNombre() + " (Dragón) lanza una llamarada con " + daño + " de daño a " + objetivo.getNombre());
        objetivo.defender(daño);
    }

    // Las escamas absorben parte del daño; siempre recibe al menos 1. 
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - REDUCCION_ESCAMAS);
        System.out.println("  Las escamas de " + escamas + " de " + getNombre() + " absorben " + (daño - dañoReal) + ". Recibe " + dañoReal);
        recibirDaño(dañoReal);
    }
}