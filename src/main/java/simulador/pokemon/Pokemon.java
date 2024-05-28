package simulador.pokemon;

import java.io.Serializable;

public abstract class Pokemon implements Serializable {
    private String nombre; 
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo; 
    private String estado;
    
    public Pokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, String estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public void setPuntosDeAtaque(int puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void atacar(Pokemon oponente) {
       double multiplicador = this.tipo.calcularVentaja(oponente.getTipo());
        int daño = (int) (this.puntosDeAtaque * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + daño + " de daño.");
    } 
    public void recibirDaño (int daño ) {
    this.salud -= daño;
        if (this.salud < 0) this.salud = 0;
        System.out.println(this.nombre + " recibe " + daño + " de daño. Salud restante: " + this.salud);
    }
    public void entrenar() {
         this.puntosDeAtaque += 10;
        this.salud += 20;
        System.out.println(this.nombre + " ha entrenado. Puntos de ataque: " + this.puntosDeAtaque + ", Salud: " + this.salud);
    
    }
}
