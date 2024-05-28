package simulador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;

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
        // Implementar la lógica para gestionar Pokémones
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
        for (Entrenador entrenador : entrenadores) {
            System.out.println(entrenador.getNombre());
        }
    }

    private static void seleccionarEntrenador() {
        System.out.print("Ingrese el nombre del entrenador: ");
        String nombre = scanner.nextLine();
        Entrenador entrenadorSeleccionado = null;

        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getNombre().equals(nombre)) {
                entrenadorSeleccionado = entrenador;
                break;
            }
        }

        if (entrenadorSeleccionado == null) {
            System.out.println("Entrenador no encontrado.");
            return;
        }

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
                    // Afregar pokemon  al equipo
                    break;
                case 3:
                    // Logica para entrenar
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
