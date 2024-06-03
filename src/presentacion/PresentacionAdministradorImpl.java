package presentacion;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import interfaces.PresentacionAdministrador;
import usuarios.Administrador;

public class PresentacionAdministradorImpl implements PresentacionAdministrador {
    @Override
    public void iniciarSesion(String tipoUsuario) {
        if (tipoUsuario.equals("administrador")) {
            mostrarMenuAdministrador();
        } else {
            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. Tipo de usuario: " + tipoUsuario);
        }
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

        addButton.addActionListener(e -> mostrarFormularioSeleccionTipoPieza());

        deleteButton.addActionListener(e -> mostrarEliminarPieza());

        consultButton.addActionListener(e -> mostrarConsultarInventario());

        historyButton.addActionListener(e -> mostrarVerHistorialClientes());

        searchButton.addActionListener(e -> mostrarBuscarPiezaPorTitulo());

        backButton.addActionListener(e -> {
            adminFrame.dispose();
            new SistemaLoginGUI(new PresentacionAdministradorImpl(), new PresentacionClienteImpl()).setVisible(true);
        });

        adminFrame.add(addButton);
        adminFrame.add(deleteButton);
        adminFrame.add(consultButton);
        adminFrame.add(historyButton);
        adminFrame.add(searchButton);
        adminFrame.add(backButton);

        adminFrame.setVisible(true);
    }

    private void mostrarFormularioSeleccionTipoPieza() {
        JFrame tipoPiezaFrame = new JFrame("Seleccionar Tipo de Pieza");
        tipoPiezaFrame.setSize(300, 200);
        tipoPiezaFrame.setLocationRelativeTo(null);
        tipoPiezaFrame.setLayout(new GridLayout(6, 1));

        JLabel tipoPiezaLabel = new JLabel("Seleccione el tipo de pieza a agregar:");
        JButton pinturaButton = new JButton("Pintura");
        JButton esculturaButton = new JButton("Escultura");
        JButton videoButton = new JButton("Video");
        JButton fotografiaButton = new JButton("Fotografía");
        JButton impresionButton = new JButton("Impresión");

        pinturaButton.addActionListener(e -> {
            mostrarFormularioAgregarPintura();
            tipoPiezaFrame.dispose();
        });

        esculturaButton.addActionListener(e -> {
            mostrarFormularioAgregarEscultura();
            tipoPiezaFrame.dispose();
        });

        videoButton.addActionListener(e -> {
            mostrarFormularioAgregarVideo();
            tipoPiezaFrame.dispose();
        });

        fotografiaButton.addActionListener(e -> {
            mostrarFormularioAgregarFotografia();
            tipoPiezaFrame.dispose();
        });

        impresionButton.addActionListener(e -> {
            mostrarFormularioAgregarImpresion();
            tipoPiezaFrame.dispose();
        });

        tipoPiezaFrame.add(tipoPiezaLabel);
        tipoPiezaFrame.add(pinturaButton);
        tipoPiezaFrame.add(esculturaButton);
        tipoPiezaFrame.add(videoButton);
        tipoPiezaFrame.add(fotografiaButton);
        tipoPiezaFrame.add(impresionButton);

        tipoPiezaFrame.setVisible(true);
    }

    private void mostrarFormularioAgregarPintura() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Pintura");
        agregarPiezaFrame.setSize(400, 500);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("== PINTURA ==", SwingConstants.CENTER);
        agregarPiezaFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(11, 2, 5, 5));
        
        formPanel.add(new JLabel("Título:"));
        JTextField tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Año:"));
        JTextField anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Autores:"));
        JTextField autoresField = new JTextField();
        formPanel.add(autoresField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        JTextField lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Disponibilidad (true/false):"));
        JTextField disponibilidadField = new JTextField();
        formPanel.add(disponibilidadField);

        formPanel.add(new JLabel("Propietario Actual:"));
        JTextField propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Ubicación Actual:"));
        JTextField ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        formPanel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Material:"));
        JTextField materialField = new JTextField();
        formPanel.add(materialField);

        formPanel.add(new JLabel("Tamaño:"));
        JTextField tamanioField = new JTextField();
        formPanel.add(tamanioField);

        formPanel.add(new JLabel("Lienzo:"));
        JTextField lienzoField = new JTextField();
        formPanel.add(lienzoField);

        agregarPiezaFrame.add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String anio = anioField.getText();
            String autores = autoresField.getText();
            String lugarCreacion = lugarCreacionField.getText();
            boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
            String propietario = propietarioField.getText();
            String ubicacion = ubicacionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String material = materialField.getText();
            String tamanio = tamanioField.getText();
            String lienzo = lienzoField.getText();

            Administrador.crearPintura(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, material, tamanio, lienzo);
            agregarPiezaFrame.dispose();
        });

        agregarPiezaFrame.add(agregarButton, BorderLayout.SOUTH);

        agregarPiezaFrame.setVisible(true);
    }


    private void mostrarFormularioAgregarEscultura() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Escultura");
        agregarPiezaFrame.setSize(400, 500);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("== ESCULTURA ==", SwingConstants.CENTER);
        agregarPiezaFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(12, 2, 5, 5));
        
        formPanel.add(new JLabel("Título:"));
        JTextField tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Año:"));
        JTextField anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Autores:"));
        JTextField autoresField = new JTextField();
        formPanel.add(autoresField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        JTextField lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Disponibilidad (true/false):"));
        JTextField disponibilidadField = new JTextField();
        formPanel.add(disponibilidadField);

        formPanel.add(new JLabel("Propietario Actual:"));
        JTextField propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Ubicación Actual:"));
        JTextField ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        formPanel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Materiales:"));
        JTextField materialesField = new JTextField();
        formPanel.add(materialesField);

        formPanel.add(new JLabel("Detalles de Instalación:"));
        JTextField detallesInstalacionField = new JTextField();
        formPanel.add(detallesInstalacionField);

        formPanel.add(new JLabel("¿Requiere Electricidad? (true/false):"));
        JTextField requiereElectricidadField = new JTextField();
        formPanel.add(requiereElectricidadField);

        formPanel.add(new JLabel("Peso:"));
        JTextField pesoField = new JTextField();
        formPanel.add(pesoField);

        formPanel.add(new JLabel("Dimensiones:"));
        JTextField dimensionesField = new JTextField();
        formPanel.add(dimensionesField);

        agregarPiezaFrame.add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String anio = anioField.getText();
            String autores = autoresField.getText();
            String lugarCreacion = lugarCreacionField.getText();
            boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
            String propietario = propietarioField.getText();
            String ubicacion = ubicacionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String materiales = materialesField.getText();
            String detallesInstalacion = detallesInstalacionField.getText();
            Boolean requiereElectricidad = Boolean.parseBoolean(requiereElectricidadField.getText());
            String peso = pesoField.getText();
            String dimensiones = dimensionesField.getText();

            Administrador.crearEscultura(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, materiales, detallesInstalacion, requiereElectricidad, peso, dimensiones);
            agregarPiezaFrame.dispose();
        });

        agregarPiezaFrame.add(agregarButton, BorderLayout.SOUTH);

        agregarPiezaFrame.setVisible(true);
    }


    private void mostrarFormularioAgregarVideo() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Video");
        agregarPiezaFrame.setSize(400, 500);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("== VIDEO ==", SwingConstants.CENTER);
        agregarPiezaFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(12, 2, 5, 5));
        
        formPanel.add(new JLabel("Título:"));
        JTextField tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Año:"));
        JTextField anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Autores:"));
        JTextField autoresField = new JTextField();
        formPanel.add(autoresField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        JTextField lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Disponibilidad (true/false):"));
        JTextField disponibilidadField = new JTextField();
        formPanel.add(disponibilidadField);

        formPanel.add(new JLabel("Propietario Actual:"));
        JTextField propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Ubicación Actual:"));
        JTextField ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        formPanel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Resolución:"));
        JTextField resolucionField = new JTextField();
        formPanel.add(resolucionField);

        formPanel.add(new JLabel("Relación de Imagen:"));
        JTextField relacionImagenField = new JTextField();
        formPanel.add(relacionImagenField);

        formPanel.add(new JLabel("¿Tiene Audio? (true/false):"));
        JTextField audioField = new JTextField();
        formPanel.add(audioField);

        formPanel.add(new JLabel("¿Tiene Color? (true/false):"));
        JTextField tieneColorField = new JTextField();
        formPanel.add(tieneColorField);

        agregarPiezaFrame.add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String anio = anioField.getText();
            String autores = autoresField.getText();
            String lugarCreacion = lugarCreacionField.getText();
            boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
            String propietario = propietarioField.getText();
            String ubicacion = ubicacionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String resolucion = resolucionField.getText();
            String relacionImagen = relacionImagenField.getText();
            Boolean audio = Boolean.parseBoolean(audioField.getText());
            Boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());

            Administrador.crearVideo(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, resolucion, relacionImagen, audio, tieneColor);
            agregarPiezaFrame.dispose();
        });

        agregarPiezaFrame.add(agregarButton, BorderLayout.SOUTH);

        agregarPiezaFrame.setVisible(true);
    }


    private void mostrarFormularioAgregarFotografia() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Fotografía");
        agregarPiezaFrame.setSize(400, 500);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("== FOTOGRAFÍA ==", SwingConstants.CENTER);
        agregarPiezaFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(12, 2, 5, 5));
        
        formPanel.add(new JLabel("Título:"));
        JTextField tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Año:"));
        JTextField anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Autores:"));
        JTextField autoresField = new JTextField();
        formPanel.add(autoresField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        JTextField lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Disponibilidad (true/false):"));
        JTextField disponibilidadField = new JTextField();
        formPanel.add(disponibilidadField);

        formPanel.add(new JLabel("Propietario Actual:"));
        JTextField propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Ubicación Actual:"));
        JTextField ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        formPanel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Resolución:"));
        JTextField resolucionField = new JTextField();
        formPanel.add(resolucionField);

        formPanel.add(new JLabel("Relación de Imagen:"));
        JTextField relacionImagenField = new JTextField();
        formPanel.add(relacionImagenField);

        formPanel.add(new JLabel("¿Tiene Color? (true/false):"));
        JTextField tieneColorField = new JTextField();
        formPanel.add(tieneColorField);

        formPanel.add(new JLabel("¿Es Digital? (true/false):"));
        JTextField esDigitalField = new JTextField();
        formPanel.add(esDigitalField);

        agregarPiezaFrame.add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String anio = anioField.getText();
            String autores = autoresField.getText();
            String lugarCreacion = lugarCreacionField.getText();
            boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
            String propietario = propietarioField.getText();
            String ubicacion = ubicacionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String resolucion = resolucionField.getText();
            String relacionImagen = relacionImagenField.getText();
            Boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());
            Boolean esDigital = Boolean.parseBoolean(esDigitalField.getText());

            Administrador.crearFotografia(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, resolucion, relacionImagen, tieneColor, esDigital);
            agregarPiezaFrame.dispose();
        });

        agregarPiezaFrame.add(agregarButton, BorderLayout.SOUTH);

        agregarPiezaFrame.setVisible(true);
    }


    private void mostrarFormularioAgregarImpresion() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Impresión");
        agregarPiezaFrame.setSize(400, 500);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("== IMPRESIÓN ==", SwingConstants.CENTER);
        agregarPiezaFrame.add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(12, 2, 5, 5));
        
        formPanel.add(new JLabel("Título:"));
        JTextField tituloField = new JTextField();
        formPanel.add(tituloField);

        formPanel.add(new JLabel("Año:"));
        JTextField anioField = new JTextField();
        formPanel.add(anioField);

        formPanel.add(new JLabel("Autores:"));
        JTextField autoresField = new JTextField();
        formPanel.add(autoresField);

        formPanel.add(new JLabel("Lugar de Creación:"));
        JTextField lugarCreacionField = new JTextField();
        formPanel.add(lugarCreacionField);

        formPanel.add(new JLabel("Disponibilidad (true/false):"));
        JTextField disponibilidadField = new JTextField();
        formPanel.add(disponibilidadField);

        formPanel.add(new JLabel("Propietario Actual:"));
        JTextField propietarioField = new JTextField();
        formPanel.add(propietarioField);

        formPanel.add(new JLabel("Ubicación Actual:"));
        JTextField ubicacionField = new JTextField();
        formPanel.add(ubicacionField);

        formPanel.add(new JLabel("Precio:"));
        JTextField precioField = new JTextField();
        formPanel.add(precioField);

        formPanel.add(new JLabel("Resolución:"));
        JTextField resolucionField = new JTextField();
        formPanel.add(resolucionField);

        formPanel.add(new JLabel("Material:"));
        JTextField materialField = new JTextField();
        formPanel.add(materialField);

        formPanel.add(new JLabel("Relación de Imagen:"));
        JTextField relacionImagenField = new JTextField();
        formPanel.add(relacionImagenField);

        formPanel.add(new JLabel("¿Tiene Color? (true/false):"));
        JTextField tieneColorField = new JTextField();
        formPanel.add(tieneColorField);

        agregarPiezaFrame.add(formPanel, BorderLayout.CENTER);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> {
            String titulo = tituloField.getText();
            String anio = anioField.getText();
            String autores = autoresField.getText();
            String lugarCreacion = lugarCreacionField.getText();
            boolean disponibilidad = Boolean.parseBoolean(disponibilidadField.getText());
            String propietario = propietarioField.getText();
            String ubicacion = ubicacionField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String resolucion = resolucionField.getText();
            String material = materialField.getText();
            String relacionImagen = relacionImagenField.getText();
            Boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());

            Administrador.crearImpresion(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, resolucion, material, relacionImagen, tieneColor);
            agregarPiezaFrame.dispose();
        });

        agregarPiezaFrame.add(agregarButton, BorderLayout.SOUTH);

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
        Administrador.consultarInventario();
    }

    private void mostrarVerHistorialClientes() {
        Administrador.Verhistorial_clientes();
        JOptionPane.showMessageDialog(null, "No hay nada ya que no hay ningun usuario con una nueva adquisición.");
    }

    private void mostrarBuscarPiezaPorTitulo() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la pieza que desea buscar:");
        if (titulo != null && !titulo.isEmpty()) {
            Administrador.buscarPiezaPorTitulo(titulo);
        } else {
            JOptionPane.showMessageDialog(null, "Título no válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
