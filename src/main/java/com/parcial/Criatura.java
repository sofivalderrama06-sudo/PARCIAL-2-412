package com.parcial;

/**
 * Clase abstracta base de todas las criaturas del juego.
 * Define los atributos comunes y los métodos que cada subclase
 * debe implementar a su manera (polimorfismo).
 */
public abstract class Criatura {
    private String nombre; // Nombre de la criatura
    private int salud;     // Puntos de vida actuales
    private int fuerza;    // Fuerza base de ataque

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Ataca a otra criatura. Cada subclase define cómo.
    public abstract void atacar(Criatura objetivo);

    // Recibe un daño (daño = fuerza del atacante). Cada subclase define cómo se defiende.
    public abstract void defender(int daño);

    // Indica si la criatura sigue viva (salud > 0).
    public boolean estaViva() {
        return salud > 0;
    }

    // Resta salud sin permitir valores negativos. Usado por defender().
    protected void recibirDaño(int daño) {
        salud = Math.max(0, salud - daño);
    }

    public String getNombre() { return nombre; }
    public int getSalud()     { return salud; }
    public int getFuerza()    { return fuerza; }
}