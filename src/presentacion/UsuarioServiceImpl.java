package presentacion; 

import java.awt.GridLayout;

import javax.swing.*;

import interfaces.UsuarioService;
import usuarios.Administrador;

public class UsuarioServiceImpl implements UsuarioService {
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
            new SistemaLoginGUI(new UsuarioServiceImpl()).setVisible(true);
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
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(10, 2));

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
        JLabel materialLabel = new JLabel("Material:");
        JTextField materialField = new JTextField();
        JLabel tamanioLabel = new JLabel("Tamaño:");
        JTextField tamanioField = new JTextField();
        JLabel lienzoLabel = new JLabel("Lienzo:");
        JTextField lienzoField = new JTextField();
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

            Administrador.agregarPieza(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, 1,
                    material, tamanio, lienzo, null, null, false, null, null, null, null, false, false, false, false);
            agregarPiezaFrame.dispose();
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
        agregarPiezaFrame.add(materialLabel);
        agregarPiezaFrame.add(materialField);
        agregarPiezaFrame.add(tamanioLabel);
        agregarPiezaFrame.add(tamanioField);
        agregarPiezaFrame.add(lienzoLabel);
        agregarPiezaFrame.add(lienzoField);
        agregarPiezaFrame.add(new JLabel());
        agregarPiezaFrame.add(agregarButton);

        agregarPiezaFrame.setVisible(true);
    }

    private void mostrarFormularioAgregarEscultura() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Escultura");
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(11, 2));

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
        JLabel materialesLabel = new JLabel("Materiales:");
        JTextField materialesField = new JTextField();
        JLabel detallesInstalacionLabel = new JLabel("Detalles de Instalación:");
        JTextField detallesInstalacionField = new JTextField();
        JLabel requiereElectricidadLabel = new JLabel("¿Requiere Electricidad? (true/false):");
        JTextField requiereElectricidadField = new JTextField();
        JLabel pesoLabel = new JLabel("Peso:");
        JTextField pesoField = new JTextField();
        JLabel dimensionesLabel = new JLabel("Dimensiones:");
        JTextField dimensionesField = new JTextField();
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
            boolean requiereElectricidad = Boolean.parseBoolean(requiereElectricidadField.getText());
            String peso = pesoField.getText();
            String dimensiones = dimensionesField.getText();

            Administrador.agregarPieza(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, 2,
                    null, null, null, materiales, detallesInstalacion, requiereElectricidad, peso, dimensiones, null, null, false, false, false, false);
            agregarPiezaFrame.dispose();
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
        agregarPiezaFrame.add(materialesLabel);
        agregarPiezaFrame.add(materialesField);
        agregarPiezaFrame.add(detallesInstalacionLabel);
        agregarPiezaFrame.add(detallesInstalacionField);
        agregarPiezaFrame.add(requiereElectricidadLabel);
        agregarPiezaFrame.add(requiereElectricidadField);
        agregarPiezaFrame.add(pesoLabel);
        agregarPiezaFrame.add(pesoField);
        agregarPiezaFrame.add(dimensionesLabel);
        agregarPiezaFrame.add(dimensionesField);
        agregarPiezaFrame.add(new JLabel());
        agregarPiezaFrame.add(agregarButton);

        agregarPiezaFrame.setVisible(true);
    }

    private void mostrarFormularioAgregarVideo() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Video");
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(11, 2));

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
        JLabel resolucionLabel = new JLabel("Resolución:");
        JTextField resolucionField = new JTextField();
        JLabel relacionImagenLabel = new JLabel("Relación de Imagen:");
        JTextField relacionImagenField = new JTextField();
        JLabel audioLabel = new JLabel("¿Tiene Audio? (true/false):");
        JTextField audioField = new JTextField();
        JLabel tieneColorLabel = new JLabel("¿Tiene Color? (true/false):");
        JTextField tieneColorField = new JTextField();
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
            boolean audio = Boolean.parseBoolean(audioField.getText());
            boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());

            Administrador.agregarPieza(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, 3,
                    null, null, null, null, null, false, null, null, resolucion, relacionImagen, audio, tieneColor, false, false);
            agregarPiezaFrame.dispose();
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
        agregarPiezaFrame.add(resolucionLabel);
        agregarPiezaFrame.add(resolucionField);
        agregarPiezaFrame.add(relacionImagenLabel);
        agregarPiezaFrame.add(relacionImagenField);
        agregarPiezaFrame.add(audioLabel);
        agregarPiezaFrame.add(audioField);
        agregarPiezaFrame.add(tieneColorLabel);
        agregarPiezaFrame.add(tieneColorField);
        agregarPiezaFrame.add(new JLabel());
        agregarPiezaFrame.add(agregarButton);

        agregarPiezaFrame.setVisible(true);
    }

    private void mostrarFormularioAgregarFotografia() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Fotografía");
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(11, 2));

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
        JLabel resolucionLabel = new JLabel("Resolución:");
        JTextField resolucionField = new JTextField();
        JLabel relacionImagenLabel = new JLabel("Relación de Imagen:");
        JTextField relacionImagenField = new JTextField();
        JLabel tieneColorLabel = new JLabel("¿Tiene Color? (true/false):");
        JTextField tieneColorField = new JTextField();
        JLabel esDigitalLabel = new JLabel("¿Es Digital? (true/false):");
        JTextField esDigitalField = new JTextField();
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
            boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());
            boolean esDigital = Boolean.parseBoolean(esDigitalField.getText());

            Administrador.agregarPieza(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, 4,
                    null, null, null, null, null, false, null, null, resolucion, relacionImagen, false, false, tieneColor, esDigital);
            agregarPiezaFrame.dispose();
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
        agregarPiezaFrame.add(resolucionLabel);
        agregarPiezaFrame.add(resolucionField);
        agregarPiezaFrame.add(relacionImagenLabel);
        agregarPiezaFrame.add(relacionImagenField);
        agregarPiezaFrame.add(tieneColorLabel);
        agregarPiezaFrame.add(tieneColorField);
        agregarPiezaFrame.add(esDigitalLabel);
        agregarPiezaFrame.add(esDigitalField);
        agregarPiezaFrame.add(new JLabel());
        agregarPiezaFrame.add(agregarButton);

        agregarPiezaFrame.setVisible(true);
    }

    private void mostrarFormularioAgregarImpresion() {
        JFrame agregarPiezaFrame = new JFrame("Agregar Impresión");
        agregarPiezaFrame.setSize(400, 400);
        agregarPiezaFrame.setLocationRelativeTo(null);
        agregarPiezaFrame.setLayout(new GridLayout(10, 2));

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
        JLabel resolucionLabel = new JLabel("Resolución:");
        JTextField resolucionField = new JTextField();
        JLabel materialLabel = new JLabel("Material:");
        JTextField materialField = new JTextField();
        JLabel relacionImagenLabel = new JLabel("Relación de Imagen:");
        JTextField relacionImagenField = new JTextField();
        JLabel tieneColorLabel = new JLabel("¿Tiene Color? (true/false):");
        JTextField tieneColorField = new JTextField();
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
            boolean tieneColor = Boolean.parseBoolean(tieneColorField.getText());

            Administrador.agregarPieza(titulo, anio, autores, lugarCreacion, disponibilidad, propietario, ubicacion, precio, 5,
                    null, null, null, null, null, false, null, null, resolucion, relacionImagen, false, false, tieneColor, false);
            agregarPiezaFrame.dispose();
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
        agregarPiezaFrame.add(resolucionLabel);
        agregarPiezaFrame.add(resolucionField);
        agregarPiezaFrame.add(materialLabel);
        agregarPiezaFrame.add(materialField);
        agregarPiezaFrame.add(relacionImagenLabel);
        agregarPiezaFrame.add(relacionImagenField);
        agregarPiezaFrame.add(tieneColorLabel);
        agregarPiezaFrame.add(tieneColorField);
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
