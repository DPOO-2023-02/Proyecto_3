package menu;

import java.util.Scanner;
import usuarios.Administrador;

public class MainAdministrador {

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
            	System.out.println("=== MENÚ ADMINISTRADOR ===");
                System.out.println("1. Agregar Pieza a inventario");
                System.out.println("2. Eliminar Pieza de inventario");
                System.out.println("3. Consultar Inventario");
                System.out.println("4. Ver historial de clientes");
                System.out.println("5. Buscar Pieza por título");
                System.out.println("6. Volver al menú principal");
                System.out.println("Seleccione una opción:");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                case 1:
                    Administrador.agregarPieza(scanner);
                    break;
                case 2:
                    Administrador.eliminarPieza();
                    break;
                case 3:
                    Administrador.consultarInventario();
                    break;
                case 4:
                    Administrador.Verhistorial_clientes();
                    break;
                case 5:
                    System.out.println("Ingrese el título de la pieza a buscar:");
                    String titulo = scanner.nextLine();
                    Administrador.buscarPiezaPorTitulo(titulo);
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    return; 
                default:
                    System.out.println("Opción no válida.");
                }
            }
        } finally {
            scanner.close();
        }
    }
}
