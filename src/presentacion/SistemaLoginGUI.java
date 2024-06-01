package presentacion;

import javax.swing.*;

import usuarios.Administrador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaLoginGUI extends JFrame {
    private static Map<String, String[]> usuarios = new HashMap<>();
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public SistemaLoginGUI() {
        crearArchivoTxt(ARCHIVO_USUARIOS);
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
                    if (tipoUsuario.equals("administrador")) {
                        mostrarMenuAdministrador();
                    } else {
                        JOptionPane.showMessageDialog(loginFrame, "Inicio de sesión exitoso. Tipo de usuario: " + tipoUsuario);
                    }
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

    private void mostrarMenuAdministrador() {
        JFrame adminFrame = new JFrame("Menú Administrador");
        adminFrame.setSize(400, 400);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setLayout(new GridLayout(7, 1));

        JLabel titleLabel = new JLabel("=== MENÚ ADMINISTRADOR ===", SwingConstants.CENTER);
        adminFrame.add(titleLabel);

        JButton addButton = new JButton("Agregar Pieza a inventario");
        JButton deleteButton = new JButton("Eliminar Pieza de inventario");
        JButton consultButton = new JButton("Consultar Inventario");
        JButton historyButton = new JButton("Ver historial de clientes");
        JButton searchButton = new JButton("Buscar Pieza por título");
        JButton backButton = new JButton("Volver al menú principal");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador.agregarPieza(null);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador.eliminarPieza();
            }
        });

        consultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador.consultarInventario();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Administrador.Verhistorial_clientes();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = JOptionPane.showInputDialog(adminFrame, "Ingrese el título de la pieza a buscar:");
                if (titulo != null) {
                    Administrador.buscarPiezaPorTitulo(titulo);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                new SistemaLoginGUI().setVisible(true);
            }
        });

        adminFrame.add(addButton);
        adminFrame.add(deleteButton);
        adminFrame.add(consultButton);
        adminFrame.add(historyButton);
        adminFrame.add(searchButton);
        adminFrame.add(backButton);

        adminFrame.setVisible(true);
    }

    private static void cargarUsuarios() {
        try (Scanner fileScanner = new Scanner(new File(ARCHIVO_USUARIOS))) {
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length >= 4) { // corregido para incluir el campo de dinero
                    usuarios.put(partes[0], new String[]{partes[1], partes[2], partes[3]});
                } else {
                    System.err.println("Formato de usuario incorrecto en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private static void guardarUsuarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_USUARIOS))) {
            for (Map.Entry<String, String[]> entry : usuarios.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue()[0] + "," + entry.getValue()[1] + "," + entry.getValue()[2]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    private static void crearArchivoTxt(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaLoginGUI().setVisible(true);
            }
        });
    }
}