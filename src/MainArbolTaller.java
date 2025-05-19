// Clase MainArbolTaller (MainArbolTaller.java)
import java.util.Scanner;

public class MainArbolTaller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();
        int opcion;

        do {
            try {
                System.out.println("\n--- Menú Árbol Binario ---");
                System.out.println("1. Agregar Nodo");
                System.out.println("2. Recorridos (PreOrden, InOrden, PostOrden)");
                System.out.println("3. Buscar Nodo");
                System.out.println("4. Mostrar Altura");
                System.out.println("5. Contar Nodos Hojas");
                System.out.println("6. Borrar Nodo");
                System.out.println("7. Vaciar Árbol");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingrese el valor del nodo: ");
                        arbol.agregar(sc.nextInt());
                    }
                    case 2 -> {
                        System.out.print("PreOrden: "); arbol.preOrden();
                        System.out.print("\nInOrden: "); arbol.inOrden();
                        System.out.print("\nPostOrden: "); arbol.postOrden();
                    }
                    case 3 -> {
                        System.out.print("Ingrese el valor a buscar: ");
                        System.out.println(arbol.buscar(sc.nextInt()) ? "Nodo encontrado" : "Nodo no encontrado");
                    }
                    case 4 -> System.out.println("Altura del Árbol: " + arbol.altura());
                    case 5 -> System.out.println("Nodos Hojas: " + arbol.contarHojas());
                    case 6 -> {
                        System.out.print("Ingrese el valor a borrar: ");
                        arbol.borrar(sc.nextInt());
                    }
                    case 7 -> {
                        arbol.vaciar();
                        System.out.println("Árbol vaciado.");
                    }
                    case 8 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida. Intente nuevamente.");
                sc.nextLine(); // Limpiar el buffer
                opcion = 0; // Reiniciar opción para continuar el bucle
            }
        } while (opcion != 8);
        sc.close();
    }
}
