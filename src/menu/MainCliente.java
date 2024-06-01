package menu;

import java.util.Scanner;
import usuarios.Cliente;

public class MainCliente {

	public static void main() {
		
		Scanner scanner = new Scanner(System.in);
		int opcion;

		while (true) {
            System.out.println("=== MENÚ CLIENTE ===");
            System.out.println("1. Ver el menú de compra");
            System.out.println("2. Consultar saldo");
            System.out.println("3. Agregar fondos");
            System.out.println("4. Mis Piezas");
            System.out.println("5. Ver Historial de Compras");
            System.out.println("6. Volver al menú principal");
            System.out.println("Seleccione una opción:");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
	            case 1:
	                MainVenta.main();
	                break;
	            case 2:
	                Cliente.consultarDinero();
	                break;
	            case 3:
	                Cliente.agregarFondos(scanner);
	                break;
	            case 4:
	                Cliente.verMisPiezas();;
	                break;
	            case 5:
	                Cliente.verHistorialCompras();
	                break;
	            case 6:
	                System.out.println("Volviendo al menú principal...");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Opción no válida.");
	                break;
            }
        }
    }
}

