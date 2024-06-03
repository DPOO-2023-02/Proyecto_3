package presentacion;

import interfaces.PresentacionCliente;
import interfaces.PresentacionPago;
import usuarios.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentacionClienteImpl implements PresentacionCliente {
    private Cliente cliente;
    private JFrame frame;

    public PresentacionClienteImpl() {
        this.cliente = new Cliente("nombre", "contrasenia", 1000); 
        initComponents();
    }

    private void initComponents() {
        frame = new JFrame("Menú Cliente");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(7, 1));

        JLabel titleLabel = new JLabel("=== MENÚ CLIENTE ===", SwingConstants.CENTER);
        frame.add(titleLabel);

        JButton btnVerMenuCompra = new JButton("Ver el menú de compra");
        JButton btnConsultarSaldo = new JButton("Consultar saldo");
        JButton btnAgregarFondos = new JButton("Agregar fondos");
        JButton btnMisPiezas = new JButton("Mis Piezas");
        JButton btnHistorialCompras = new JButton("Ver Historial de Compras");
        JButton btnTipoPago = new JButton("Tipo de Pago"); 
        JButton btnVolver = new JButton("Volver al menú principal");
        

        btnVerMenuCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // MainVenta.main(); 
            }
        });

        btnConsultarSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Saldo actual: " + cliente.consultarDinero(), "Consultar Saldo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnAgregarFondos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese la cantidad a agregar:");
                if (input != null && !input.isEmpty()) {
                    try {
                        double amount = Double.parseDouble(input);
                        cliente.agregarFondos(amount);
                        JOptionPane.showMessageDialog(null, "Fondos agregados exitosamente.", "Agregar Fondos", JOptionPane.INFORMATION_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnMisPiezas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cliente.verMisPiezas(); 
            }
        });

        btnHistorialCompras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Historial de Compras: " + cliente.verHistorialCompras(), "Ver Historial de Compras", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new SistemaLoginGUI(new PresentacionAdministradorImpl(), new PresentacionClienteImpl()).setVisible(true);
            }
        });

        btnTipoPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentacionPago presentacionPago = new PresentacionPagoImpl();
                presentacionPago.mostrar(); 
            }
        });

        frame.add(btnVerMenuCompra);
        frame.add(btnConsultarSaldo);
        frame.add(btnAgregarFondos);
        frame.add(btnMisPiezas);
        frame.add(btnHistorialCompras);
        frame.add(btnTipoPago);
        frame.add(btnVolver);
    }

    @Override
    public void iniciarSesionCliente() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }

    public static void main(String[] args) {
        new PresentacionClienteImpl().iniciarSesionCliente();
    }
}
