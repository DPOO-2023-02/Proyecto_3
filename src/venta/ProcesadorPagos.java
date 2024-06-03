package venta;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ProcesadorPagos {
    // Interfaz PasarelaPago
    public interface PasarelaPago {
        String procesarPago(String numeroTarjeta, String titularTarjeta, double monto);
    }

    // Implementación de PayPal
    public static class PayPal implements PasarelaPago {
        @Override
        public String procesarPago(String numeroTarjeta, String titularTarjeta, double monto) {
            String resultado = "Pago procesado vía PayPal: " + titularTarjeta + " " + monto;
            try (PrintWriter out = new PrintWriter(new FileWriter("PayPal.log", true))) {
                out.println(resultado);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultado;
        }
    }

    // Implementación de Payu
    public static class Payu implements PasarelaPago {
        @Override
        public String procesarPago(String numeroTarjeta, String titularTarjeta, double monto) {
            String resultado = "Pago procesado vía Payu: " + titularTarjeta + " " + monto;
            try (PrintWriter out = new PrintWriter(new FileWriter("Payu.txt", true))) {
                out.println(resultado);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultado;
        }
    }

    // Implementación de Sire
    public static class Sire implements PasarelaPago {
        @Override
        public String procesarPago(String numeroTarjeta, String titularTarjeta, double monto) {
            String resultado = "Pago procesado vía Sire: " + titularTarjeta + " " + monto;
            try (PrintWriter out = new PrintWriter(new FileWriter("Sire.json", true))) {
                out.println(resultado);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resultado;
        }
    }

    // Manejador de Pasarelas de Pago
    private Map<String, PasarelaPago> pasarelas;

    public ProcesadorPagos() {
        pasarelas = new HashMap<>();
        cargarPasarelas();
    }

    private void cargarPasarelas() {
        pasarelas.put("PayPal", new PayPal());
        pasarelas.put("Payu", new Payu());
        pasarelas.put("Sire", new Sire());
    }

    public PasarelaPago obtenerPasarela(String nombre) {
        return pasarelas.get(nombre);
    }

    public Map<String, PasarelaPago> obtenerTodasPasarelas() {
        return pasarelas;
    }

    public void agregarPasarela(String nombre, PasarelaPago pasarela) {
        pasarelas.put(nombre, pasarela);
    }
}