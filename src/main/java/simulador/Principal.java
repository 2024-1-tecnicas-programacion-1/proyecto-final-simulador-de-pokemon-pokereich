import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;
import simulador.pokemon.*;

public class Principal {
    private static List<Entrenador> entrenadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mostrarMenuPrincipal();
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Simulador de Batallas Pokémon");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                gestionarEntrenadores();
                break;
            case 2:
                gestionarPokemones();
                break;
            case 3:
                iniciarBatalla();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void gestionarEntrenadores() {
        System.out.println("Gestionar Entrenadores");
        System.out.println("1. Registrar nuevo entrenador");
        System.out.println("2. Ver lista de entrenadores");
        System.out.println("3. Seleccionar un entrenador");
        System.out.println("4. Volver al menú principal");
        System.out.print("Elige una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                registrarEntrenador();
                break;
            case 2:
                verListaEntrenadores();
                break;
            case 3:
                seleccionarEntrenador();
                break;
            case 4:
                return;
            default:
                System.out.println("Opción no válida");
        }
    }

    private static void gestionarPokemones() {
        List<Pokemon> pokemonesDisponibles = new ArrayList<>();
    
        pokemonesDisponibles.add(new Cubone());
        pokemonesDisponibles.add(new Doduo());
        pokemonesDisponibles.add(new Ekans());
        pokemonesDisponibles.add(new Electrode());
        pokemonesDisponibles.add(new Goldeen());
        pokemonesDisponibles.add(new Hitmonchan());
        pokemonesDisponibles.add(new Lickitung());
        pokemonesDisponibles.add(new Paras());
        pokemonesDisponibles.add(new Ponyta());
        pokemonesDisponibles.add(new Staryu());

        System.out.println("Lista de Pokémones Disponibles:");
        for (int i = 0; i < pokemonesDisponibles.size(); i++) {
            System.out.println((i+1) + ". " + pokemonesDisponibles.get(i).getNombre());
        }

        System.out.print("Selecciona un Pokémon para agregar al equipo (número): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > pokemonesDisponibles.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Pokemon pokemonSeleccionado = pokemonesDisponibles.get(seleccion - 1);
        
        // Agregar el Pokémon al equipo del entrenador seleccionado
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }

        System.out.println("Selecciona un entrenador para agregar el Pokémon:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i+1) + ". " + entrenadores.get(i).getNombre());
        }

        System.out.print("Selecciona un entrenador (número): ");
        int seleccionEntrenador = scanner.nextInt();
        scanner.nextLine();

        if (seleccionEntrenador < 1 || seleccionEntrenador > entrenadores.size()) {
            System.out.println("Selección inválida.");
            return;
        }

        Entrenador entrenadorSeleccionado = entrenadores.get(seleccionEntrenador - 1);
        entrenadorSeleccionado.agregarPokemon(pokemonSeleccionado);
        System.out.println("¡" + pokemonSeleccionado.getNombre() + " ha sido agregado al equipo de " + entrenadorSeleccionado.getNombre() + "!");
    }

    private static void iniciarBatalla() {
        // Implementar la lógica para iniciar la batalla
    }

    private static void registrarEntrenador() {
        System.out.print("Ingrese el nombre del nuevo entrenador: ");
        String nombre = scanner.nextLine();
        entrenadores.add(new Entrenador(nombre));
        System.out.println("Entrenador registrado con éxito.");
    }

    private static void verListaEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("Lista de Entrenadores:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i+1) + ". " + entrenadores.get(i).getNombre());
        }
    }

    private static void seleccionarEntrenador() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("Selecciona un entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i+1) + ". " + entrenadores.get(i).getNombre());
        }

        System.out.print("Selecciona un entrenador (número): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine();

        if (seleccion < 1 || seleccion > entrenadores.size()) {
            System.out.println("Selección inválida.");
            return;
        }
        Entrenador entrenadorSeleccionado = entrenadores.get(seleccion - 1);

        while (true) {
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    entrenadorSeleccionado.mostrarPokemones();
                    break;
                case 2:
                    gestionarPokemones(); // Llamar a la función de gestión de Pokémones para agregar más Pokémones
                    break;
                case 3:
                    // Implementar lógica para entrenar Pokémon
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

