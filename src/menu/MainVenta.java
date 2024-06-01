package menu;

import java.util.Scanner;
import piezas.Pieza;
import usuarios.Cliente;
import venta.Subasta;
import usuarios.Cajero;

public class MainVenta {

    private Cliente cliente;

    public MainVenta(Cliente cliente) {
        this.cliente = cliente;
    }

    public static void main() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            System.out.println("=== MENÚ DE COMPRA ===");
            System.out.println("1. Ver piezas disponibles para compra");
            System.out.println("2. Participar en subasta");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción:");

            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {
                case 1:
                    comprarPieza(scanner);
                    break;
                case 2:
                    participarSubasta(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del menú de compras...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private void comprarPieza(Scanner scanner) {
        System.out.println("Mostrando piezas disponibles para la venta...");
        Pieza piezaSeleccionada = seleccionarPieza(scanner);
        if (piezaSeleccionada != null && piezaSeleccionada.isDisponibilidadVenta()) {
            boolean exito = Cliente.ConfirmarPago(cliente, piezaSeleccionada.getPrecio(), false);
            if (exito) {
                System.out.println("Compra realizada con éxito. Pieza comprada: " + piezaSeleccionada.getTitulo());
            } else {
                System.out.println("No se pudo completar la compra. Verifique su saldo.");
            }
        } else {
            System.out.println("La pieza seleccionada no está disponible para la venta directa.");
        }
    }

    private void participarSubasta(Scanner scanner) {
        System.out.println("Participando en subasta...");
        // Implementar lógica para participar en una subasta
        // Subasta subasta = seleccionarSubasta(scanner); // Método ficticio para obtener una subasta
        // subasta.registrarParticipante(comprador);
    }

    private Pieza seleccionarPieza(Scanner scanner) {
        // Implementar lógica para seleccionar una pieza
        return null; // Retornar la pieza seleccionada
    }
}

