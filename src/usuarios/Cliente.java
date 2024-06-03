package usuarios;

import java.util.ArrayList;

public class Cliente extends Usuario {
    private ArrayList<String> historialCompras;

    public Cliente(String nombre, String contrasenia, double dineroInicial) {
        super(nombre, contrasenia, dineroInicial);
        this.historialCompras = new ArrayList<>();
    }

    public double consultarDinero() {
        return getDinero();
    }

    public void agregarFondos(double cantidad) {
        if (cantidad > 0) {
            setDinero(getDinero() + cantidad);
        } else {
            throw new IllegalArgumentException("Cantidad no válida. Por favor, ingrese un valor positivo.");
        }
    }

    public ArrayList<String> verHistorialCompras() {
        return historialCompras;
    }

    public void verMisPiezas() {
        // Implementación pendiente
    }
}
