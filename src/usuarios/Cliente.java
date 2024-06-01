package usuarios;

import java.util.ArrayList;
import java.util.Scanner;


public class Cliente extends Usuario {
	
    private static ArrayList<String> historialCompras;

    public Cliente(String nombre, String contrasenia, double dineroInicial) {
        super(nombre, contrasenia, dineroInicial);
    }

    public static void consultarDinero() {
        System.out.println("Saldo disponible: " + getDinero() + " unidades monetarias.");
    }

    public static void agregarFondos(Scanner scanner) {
        System.out.println("Ingrese la cantidad de fondos a agregar:");
        double cantidad = scanner.nextDouble();
        if (cantidad > 0) {
            setDinero(getDinero() + cantidad);
            System.out.println("Fondos agregados exitosamente. Saldo actual: " + getDinero());
        } else {
            System.out.println("Cantidad no válida. Por favor, ingrese un valor positivo.");
        }
    }

	public static ArrayList<String> verHistorialCompras() {
        return historialCompras;
    }

	public static void verMisPiezas() {
		// TODO Auto-generated method stub
		
	}
}
