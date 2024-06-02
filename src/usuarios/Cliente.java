package usuarios;

import java.util.ArrayList;
import interfaces.PresentacionCliente;

public class Cliente extends Usuario {
    
    private ArrayList<String> historialCompras;
    private PresentacionCliente presentacion;

    public Cliente(String nombre, String contrasenia, double dineroInicial, PresentacionCliente presentacion) {
        super(nombre, contrasenia, dineroInicial);
        historialCompras = new ArrayList<>();
        this.presentacion = presentacion;
    }

    public void consultarDinero() {
        presentacion.consultarDinero(getDinero());
    }

    public void agregarFondos(double cantidad) {
        if (cantidad > 0) {
            setDinero(getDinero() + cantidad);
            presentacion.mostrarMensaje("Fondos agregados exitosamente. Saldo actual: " + getDinero());
        } else {
            presentacion.mostrarError("Cantidad no válida. Por favor, ingrese un valor positivo.");
        }
    }

    public void verHistorialCompras() {
        if (historialCompras.isEmpty()) {
            presentacion.mostrarMensaje("No hay compras en el historial.");
        } else {
            StringBuilder sb = new StringBuilder("Historial de Compras:\n");
            for (String compra : historialCompras) {
                sb.append(compra).append("\n");
            }
            presentacion.mostrarHistorialCompras(sb.toString());
        }
    }

    public void verMisPiezas() {
        // Implementa la lógica para devolver las piezas del cliente
        ArrayList<Pieza> piezas = new ArrayList<>(); // Placeholder
        if (piezas.isEmpty()) {
            presentacion.mostrarMensaje("No tienes piezas.");
        } else {
            StringBuilder sb = new StringBuilder("Mis Piezas:\n");
            for (Pieza pieza : piezas) {
                sb.append(pieza.toString()).append("\n");
            }
            presentacion.mostrarMisPiezas(sb.toString());
        }
    }
}
