package presentacion;

import javax.swing.*;
<<<<<<< HEAD

import interfaces.UsuarioService;

=======
import piezas.Inventario;
import piezas.Pieza;
import usuarios.Administrador;
>>>>>>> 6815c19d2f781b4aaf58e3a050d9e8d2f8c2f49a
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
        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\USER\\Documents\\TODO\\universidad\\3er semestre\\DPO\\Proyecto_3NOMAS\\imagenes\\subasta.png"));
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

<<<<<<< HEAD
=======
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
                mostrarAgregarPieza();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarEliminarPieza();
            }
        });

        consultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConsultarInventario();
            }
        });

        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarVerHistorialClientes();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarBuscarPiezaPorTitulo();
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

    private void mostrarAgregarPieza() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Pieza");
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(9, 2));

        JLabel tituloLabel = new JLabel("Título:");
        JTextField tituloField = new JTextField();
        JLabel anioLabel = new JLabel("Año:");
        JTextField anioField = new JTextField();
        JLabel autoresLabel = new JLabel("Autores:");
        JTextField autoresField = new JTextField();
        JLabel lugarCreacionLabel = new JLabel("Lugar de Creación:");
        JTextField lugarCreacionField = new JTextField();
        JLabel disponibilidadLabel = new JLabel("Disponibilidad (true/false):");
        JTextField disponibilidadField = new JTextField();
        JLabel propietarioLabel = new JLabel("Propietario Actual:");
        JTextField propietarioField = new JTextField();
        JLabel ubicacionLabel = new JLabel("Ubicación Actual:");
        JTextField ubicacionField = new JTextField();
        JLabel precioLabel = new JLabel("Precio:");
        JTextField precioField = new JTextField();
        JLabel tipoLabel = new JLabel("Tipo de Pieza (1-5):");
        JTextField tipoField = new JTextField();
        JButton agregarButton = new JButton("Agregar");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String anio = anioField.getText();
                String autores = autoresField.getText();
                String lugarCreacion = lugarCreacionField.getText();
                boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
                String propietario = propietarioField.getText();
                String ubicacion = ubicacionField.getText();
                double precio = Double.parseDouble(precioField.getText());
                int tipo = Integer.parseInt(tipoField.getText());

                switch (tipo) {
                    case 1:
                    	Administrador.crearPintura(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, ubicacion, ubicacion, ubicacion);
                        break;
                    case 2:
                        Administrador.crearEscultura(new Scanner(""), titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio);
                        break;
                    case 3:
                        Administrador.crearVideo(new Scanner(""), titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio);
                        break;
                    case 4:
                        Administrador.crearFotografia(new Scanner(""), titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio);
                        break;
                    case 5:
                        Administrador.crearImpresion(new Scanner(""), titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio);
                        break;
                    default:
                        JOptionPane.showMessageDialog(agregarPiezaFrame, "Tipo de pieza no válido.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }
                JOptionPane.showMessageDialog(agregarPiezaFrame, "Pieza agregada exitosamente al inventario.");
                agregarPiezaFrame.dispose();
            }
        });

        agregarPiezaFrame.add(tituloLabel);
        agregarPiezaFrame.add(tituloField);
        agregarPiezaFrame.add(anioLabel);
        agregarPiezaFrame.add(anioField);
        agregarPiezaFrame.add(autoresLabel);
        agregarPiezaFrame.add(autoresField);
        agregarPiezaFrame.add(lugarCreacionLabel);
        agregarPiezaFrame.add(lugarCreacionField);
        agregarPiezaFrame.add(disponibilidadLabel);
        agregarPiezaFrame.add(disponibilidadField);
        agregarPiezaFrame.add(propietarioLabel);
        agregarPiezaFrame.add(propietarioField);
        agregarPiezaFrame.add(ubicacionLabel);
        agregarPiezaFrame.add(ubicacionField);
        agregarPiezaFrame.add(precioLabel);
        agregarPiezaFrame.add(precioField);
        agregarPiezaFrame.add(tipoLabel);
        agregarPiezaFrame.add(tipoField);
        agregarPiezaFrame.add(new JLabel());
        agregarPiezaFrame.add(agregarButton);

        agregarPiezaFrame.setVisible(true);
    }

    private void mostrarEliminarPieza() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la pieza que desea eliminar:");
        if (titulo != null && !titulo.isEmpty()) {
            Administrador.eliminarPieza(titulo);
            JOptionPane.showMessageDialog(null, "La pieza con título '" + titulo + "' ha sido eliminada.");
        } else {
            JOptionPane.showMessageDialog(null, "Título no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarConsultarInventario() {
        JFrame inventarioFrame = new JFrame("Consultar Inventario");
        inventarioFrame.setSize(500, 500);
        inventarioFrame.setLocationRelativeTo(null);

        JTextArea inventarioArea = new JTextArea(20, 40);
        inventarioArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inventarioArea);
        inventarioFrame.add(scrollPane);

        List<Pieza> piezas = Inventario.consultarInventario();
        if (piezas.isEmpty()) {
            inventarioArea.setText("El inventario está vacío.");
        } else {
            StringBuilder inventarioTexto = new StringBuilder("Inventario de piezas:\n");
            for (Pieza pieza : piezas) {
                inventarioTexto.append("===================\n")
                        .append("Título: ").append(pieza.getTitulo()).append("\n")
                        .append("Año: ").append(pieza.getAnio()).append("\n")
                        .append("Autores: ").append(pieza.getAutores()).append("\n")
                        .append("Lugar de creación: ").append(pieza.getLugarCreacion()).append("\n")
                        .append("Disponibilidad de venta: ").append(pieza.isDisponibilidadVenta() ? "Disponible" : "No disponible").append("\n")
                        .append("Propietario actual: ").append(pieza.getPropietarioActual()).append("\n")
                        .append("Ubicación actual: ").append(pieza.getUbicacionActual()).append("\n")
                        .append("Precio: $").append(pieza.getPrecio()).append("\n")
                        .append("Subastable: ").append(pieza.isSubastable() ? "Sí" : "No").append("\n");
            }
            inventarioArea.setText(inventarioTexto.toString());
        }

        inventarioFrame.setVisible(true);
    }

    private void mostrarVerHistorialClientes() {
        Administrador.Verhistorial_clientes();
        JOptionPane.showMessageDialog(null, "No hay nada ya que no hay ningun usuario con una nueva adquisición.");
    }

    private void mostrarBuscarPiezaPorTitulo() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la pieza que desea buscar:");
        if (titulo != null && !titulo.isEmpty()) {
            Administrador.buscarPiezaPorTitulo(titulo);
            // Aquí debes agregar el código para mostrar la pieza encontrada en un cuadro de diálogo.
            // Por ejemplo:
            Pieza pieza = Administrador.buscarPiezaPorTitulo(titulo);
            if (pieza != null) {
                JOptionPane.showMessageDialog(null, "Pieza encontrada:\n" +
                        "Título: " + pieza.getTitulo() + "\n" +
                        "Año: " + pieza.getAnio() + "\n" +
                        "Autores: " + pieza.getAutores() + "\n" +
                        "Lugar de creación: " + pieza.getLugarCreacion() + "\n" +
                        "Disponibilidad de venta: " + (pieza.isDisponibilidadVenta() ? "Disponible" : "No disponible") + "\n" +
                        "Propietario actual: " + pieza.getPropietarioActual() + "\n" +
                        "Ubicación actual: " + pieza.getUbicacionActual() + "\n" +
                        "Precio: $" + pieza.getPrecio() + "\n" +
                        "Subastable: " + (pieza.isSubastable() ? "Sí" : "No"));
            } else {
                JOptionPane.showMessageDialog(null, "Pieza no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Título no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void crearArchivoTxt(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

>>>>>>> 6815c19d2f781b4aaf58e3a050d9e8d2f8c2f49a
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
