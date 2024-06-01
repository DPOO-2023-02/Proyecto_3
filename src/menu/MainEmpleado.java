package menu;

import usuarios.Empleado;


import java.util.Scanner;
public class MainEmpleado {

	public static void main() {

	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("=== MENÚ CAJERO ===");
	        System.out.println("1. Confirmar pago");
	        System.out.println("2. Cambiar comprador");
	        System.out.println("3. Cambiar estado pieza");
	        System.out.println("4. Registrar Pujas");
	        System.out.println("3. Volver al menu principal");
	        System.out.println("Seleccione una opción:");

	        int opcion = scanner.nextInt();
	        scanner.nextLine();

	        switch (opcion) {
	            case 1:
	                System.out.println("Confirmar pago...");
	                Empleado.ConfirmarPago();
	                break;
	            case 2:
	                System.out.println("Cambiando comprador...");
	                Empleado.CambiarComprador();
	                break;
	            case 3:
	                System.out.println("Volviendo al menú principal...");
	                return;
	            case 4:
	                System.out.println("Cambiar estado pieza...");
	                Empleado.cambiar_estado_piezas();
	                break;
	            case 5:
	                System.out.println("Registrar Pujas...");
	                Empleado.registrarpujas();
	                break;
	            default:
	                System.out.println("Opción no válida.");
	        }
	    }
	}

}