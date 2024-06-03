package presentacion;

import interfaces.PresentacionPago;
import venta.Pago;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresentacionPagoGUI implements PresentacionPago {

    private JFrame frame;
    private Pago pago;

    public PresentacionPagoGUI() {
        frame = new JFrame();
        pago = new Pago();

        // Configuración de la ventana principal
        frame.setTitle("Procesador de Pagos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");
        JMenuItem menuItemInsertarMetodo = new JMenuItem("Insertar método de pago");

        menuItemInsertarMetodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogoInsertarMetodo();
            }
        });

        menu.add(menuItemInsertarMetodo);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Configuración del panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton botonProcesarPago = new JButton("Procesar Pago");
        botonProcesarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPago();
            }
        });

        panel.add(botonProcesarPago, BorderLayout.CENTER);
        frame.add(panel);
    }

    public void mostrar() {
        frame.setVisible(true);
    }

    private void procesarPago() {
        // Obtener los datos del formulario
        JTextField campoNumeroTarjeta = new JTextField(20);
        JTextField campoTitularTarjeta = new JTextField(20);
        JTextField campoMonto = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Número de Tarjeta:"));
        panel.add(campoNumeroTarjeta);
        panel.add(new JLabel("Titular de la Tarjeta:"));
        panel.add(campoTitularTarjeta);
        panel.add(new JLabel("Monto:"));
        panel.add(campoMonto);

        int resultado = JOptionPane.showConfirmDialog(frame, panel, "Procesar Pago", JOptionPane.OK_CANCEL_OPTION);
        if (resultado == JOptionPane.OK_OPTION) {
            String numeroTarjeta = campoNumeroTarjeta.getText();
            String titularTarjeta = campoTitularTarjeta.getText();
            double monto = Double.parseDouble(campoMonto.getText());

            // Obtener la pasarela seleccionada
            JComboBox<String> comboBoxPasarelas = new JComboBox<>();
            for (String nombrePasarela : pago.obtenerTodasPasarelas().keySet()) {
                comboBoxPasarelas.addItem(nombrePasarela);
            }
            panel.add(new JLabel("Pasarela de Pago:"));
            panel.add(comboBoxPasarelas);

            String nombrePasarela = (String) comboBoxPasarelas.getSelectedItem();
            Pago.PasarelaPago pasarela = pago.obtenerPasarela(nombrePasarela);

            // Procesar el pago utilizando la pasarela seleccionada
            String resultadoPago = pasarela.procesarPago(numeroTarjeta, titularTarjeta, monto);
            JOptionPane.showMessageDialog(frame, resultadoPago);
        }
    }

    @Override
    public void mostrarDialogoInsertarMetodo() {
        // Implementación del método mostrarDialogoInsertarMetodo
    }

    @Override
    public void mostrarDialogoProcesarPago() {
        // Implementación del método mostrarDialogoProcesarPago
    }
}