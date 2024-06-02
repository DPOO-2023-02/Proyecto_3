package presentacion;

import javax.swing.*;
import interfaces.PresentacionCliente;

public class PresentacionClienteImpl implements PresentacionCliente {
    @Override
    public void consultarDinero(double saldo) {
        JOptionPane.showMessageDialog(null, "Saldo disponible: " + saldo + " unidades monetarias.");
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarMisPiezas(String piezas) {
        JTextArea textArea = new JTextArea(piezas);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Mis Piezas", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void mostrarHistorialCompras(String historial) {
        JTextArea textArea = new JTextArea(historial);
        textArea.setEditable(false);
        JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
    }
}
