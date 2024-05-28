package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;
import simulador.pokemon.Pokemon;

public class Entrenador {
    
    private String nombre;
    private List<Pokemon> pokemones;
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new ArrayList<>();
    }
    public String getNombre() {
        return nombre;
    }
    public List<Pokemon> getPokemones() {
        return pokemones;
    }
    public void agregarPokemon(Pokemon pokemon) {
        pokemones.add(pokemon);
    }
    public void entrenarPokemon(Pokemon pokemon) {
        pokemon.entrenar();
    }
    public void mostrarPokemones() {
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon.getNombre());
        }
    }
    public Pokemon seleccionarPokemon(String nombre) {
        for (Pokemon pokemon : pokemones) {
            if (pokemon.getNombre().equals(nombre)) {
                return pokemon;
            }
        }
        return null;
    }
}












