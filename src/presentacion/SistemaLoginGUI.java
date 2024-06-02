package presentacion;

import javax.swing.*;

import interfaces.UsuarioService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SistemaLoginGUI extends JFrame {
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private Map<String, String[]> usuarios = new HashMap<>();
    private UsuarioService usuarioService;

    public SistemaLoginGUI(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
        cargarUsuarios();
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Login");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel para la imagen en el centro
        JLabel imageLabel = new JLabel(new ImageIcon("casino.jpg"));
        add(imageLabel, BorderLayout.CENTER);

        // Panel para los botones en la parte inferior
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton loginButton = new JButton("Iniciar sesión");
        JButton registerButton = new JButton("Registrar usuario");
        JButton exitButton = new JButton("Salir");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioLogin();
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioRegistro();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarUsuarios();
                System.exit(0);
            }
        });

        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);

        add(panel, BorderLayout.SOUTH);
    }

    private void mostrarFormularioLogin() {
        JFrame loginFrame = new JFrame("Iniciar Sesión");
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Usuario:");
        JLabel passLabel = new JLabel("Contraseña:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar Sesión");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = userField.getText();
                String contraseña = new String(passField.getPassword());

                if (usuarios.containsKey(usuario) && usuarios.get(usuario)[0].equals(contraseña)) {
                    String tipoUsuario = usuarios.get(usuario)[1];
                    usuarioService.iniciarSesion(tipoUsuario);
                    loginFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(loginFrame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginFrame.add(userLabel);
        loginFrame.add(userField);
        loginFrame.add(passLabel);
        loginFrame.add(passField);
        loginFrame.add(new JLabel());
        loginFrame.add(loginButton);

        loginFrame.setVisible(true);
    }

    private void mostrarFormularioRegistro() {
        JFrame registerFrame = new JFrame("Registrar Usuario");
        registerFrame.setSize(300, 300);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setLayout(new GridLayout(5, 2));

        JLabel userLabel = new JLabel("Nuevo Usuario:");
        JLabel passLabel = new JLabel("Nueva Contraseña:");
        JLabel typeLabel = new JLabel("Tipo de Usuario:");
        JLabel moneyLabel = new JLabel("Dinero:");
        JTextField userField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JTextField typeField = new JTextField();
        JTextField moneyField = new JTextField();
        JButton registerButton = new JButton("Registrar");

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoUsuario = userField.getText();
                String nuevaContraseña = new String(passField.getPassword());
                String tipoUsuario = typeField.getText();
                String dinero = moneyField.getText();

                usuarios.put(nuevoUsuario, new String[]{nuevaContraseña, tipoUsuario, dinero});
                guardarUsuarios();
                JOptionPane.showMessageDialog(registerFrame, "Usuario registrado con éxito.");
                registerFrame.dispose();
            }
        });

        registerFrame.add(userLabel);
        registerFrame.add(userField);
        registerFrame.add(passLabel);
        registerFrame.add(passField);
        registerFrame.add(typeLabel);
        registerFrame.add(typeField);
        registerFrame.add(moneyLabel);
        registerFrame.add(moneyField);
        registerFrame.add(new JLabel());
        registerFrame.add(registerButton);

        registerFrame.setVisible(true);
    }

    private void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_USUARIOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String usuario = partes[0];
                    String contraseña = partes[1];
                    String tipoUsuario = partes[2];
                    String dinero = partes[3];
                    usuarios.put(usuario, new String[]{contraseña, tipoUsuario, dinero});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void guardarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Map.Entry<String, String[]> entry : usuarios.entrySet()) {
                String usuario = entry.getKey();
                String[] datos = entry.getValue();
                String contraseña = datos[0];
                String tipoUsuario = datos[1];
                String dinero = datos[2];
                writer.write(usuario + "," + contraseña + "," + tipoUsuario + "," + dinero);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioServiceImpl();
        SwingUtilities.invokeLater(() -> new SistemaLoginGUI(usuarioService).setVisible(true));
    }
}
