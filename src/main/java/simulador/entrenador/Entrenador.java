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
    
    public void entrenar() {
        if (pokemones.isEmpty()) {
        System.out.println("No hay Pokémon disponibles para entrenar en este momento.");
        return;
    }
        for (Pokemon pokemon : pokemones) {
        pokemon.entrenar();
         }
    }

    public void mostrarPokemones() {
        if (pokemones.isEmpty()) {
            System.out.println("El entrenador no tiene ningún Pokémon en su equipo.");
        } else {
            System.out.println("Equipo de Pokémones de " + nombre + ":");
            for (Pokemon pokemon : pokemones) {
                System.out.println(pokemon.getNombre());
            }
        }
    }

    public Pokemon seleccionarPokemon(String nombre) {
        for (Pokemon pokemon : pokemones) {
            if (pokemon.getNombre().equals(nombre)) {
                return pokemon;
            }
        }
        System.out.println("No se encontró ningún Pokémon con ese nombre en el equipo de " + nombre);
        return null;
    }

}












