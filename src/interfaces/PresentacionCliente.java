package interfaces;

public interface PresentacionCliente {
    void consultarDinero(double saldo);
    void mostrarMensaje(String mensaje);
    void mostrarError(String mensaje);
    void mostrarMisPiezas(String piezas);
    void mostrarHistorialCompras(String historial);
}
