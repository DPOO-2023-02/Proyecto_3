package usuarios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import piezas.Escultura;
import piezas.Fotografia;
import piezas.Impresion;
import piezas.Inventario;
import piezas.Pieza;
import piezas.Pintura;
import piezas.Video;
import historial.UsuarioPiezas;

public class Administrador extends Usuario {

    public Administrador(String nombre, String contrasenia, int dinero) {
        super(nombre, contrasenia, 0);
    }

    UsuarioPiezas admin = new UsuarioPiezas();

    public static void crearPintura(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
                                    String propietarioActual, String ubicacionActual, double precio, String material, String tamanio, String lienzo) {
        Pintura nuevaPintura = new Pintura(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
                new ArrayList<>(), propietarioActual, ubicacionActual, precio, material, tamanio, lienzo);
        Inventario.agregarPieza(nuevaPintura);
        JOptionPane.showMessageDialog(null, "Pintura agregada exitosamente al inventario.");
    }

    public static void crearEscultura(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
                                      String propietarioActual, String ubicacionActual, double precio, String materiales, String detallesInstalacion, Boolean requiereElectricidad, String peso, String dimensiones) {
        Escultura nuevaEscultura = new Escultura(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
                new ArrayList<>(), propietarioActual, ubicacionActual, precio, materiales, detallesInstalacion, requiereElectricidad, peso, dimensiones);
        Inventario.agregarPieza(nuevaEscultura);
        JOptionPane.showMessageDialog(null, "Escultura agregada exitosamente al inventario.");
    }

    public static void crearVideo(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
                                  String propietarioActual, String ubicacionActual, double precio, String resolucion, String relacionImagen, Boolean audio, Boolean tienecolor) {
        Video nuevoVideo = new Video(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
                new ArrayList<>(), propietarioActual, ubicacionActual, precio, resolucion, relacionImagen, audio, tienecolor);
        Inventario.agregarPieza(nuevoVideo);
        JOptionPane.showMessageDialog(null, "Video agregado exitosamente al inventario.");
    }

    public static void crearFotografia(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
                                       String propietarioActual, String ubicacionActual, double precio, String resolucion, String relacionImagen, Boolean tieneColor, Boolean esDigital) {
        Fotografia nuevaFotografia = new Fotografia(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
                new ArrayList<>(), propietarioActual, ubicacionActual, precio, resolucion, relacionImagen, tieneColor, esDigital);
        Inventario.agregarPieza(nuevaFotografia);
        JOptionPane.showMessageDialog(null, "Fotografía agregada exitosamente al inventario.");
    }

    public static void crearImpresion(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
                                      String propietarioActual, String ubicacionActual, double precio, String resolucion, String material, String relacionImagen, Boolean tieneColor) {
        Impresion nuevaImpresion = new Impresion(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
                new ArrayList<>(), propietarioActual, ubicacionActual, precio, resolucion, material, relacionImagen, tieneColor);
        Inventario.agregarPieza(nuevaImpresion);
        JOptionPane.showMessageDialog(null, "Impresión agregada exitosamente al inventario.");
    }

    public static void buscarPiezaPorTitulo(String titulo) {
        List<Pieza> piezas = Inventario.consultarInventario();
        for (Pieza pieza : piezas) {
            if (pieza.getTitulo().equals(titulo)) {
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
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontró ninguna pieza con título '" + titulo + "'.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void consultarInventario() {
        List<Pieza> piezas = Inventario.consultarInventario();
        if (piezas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El inventario está vacío.");
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
            JTextArea textArea = new JTextArea(inventarioTexto.toString());
            textArea.setEditable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane(textArea), "Inventario", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void eliminarPieza(String titulo) {
        Inventario.eliminarPieza(titulo);
        JOptionPane.showMessageDialog(null, "La pieza con título '" + titulo + "' ha sido eliminada.");
    }

    public static void Verhistorial_clientes() {
        UsuarioPiezas admin = new UsuarioPiezas();
        admin.cargarUsuarios("usuarios.txt");
        admin.cargarPiezas("piezas.txt");
        admin.escribirArchivo("ruta_del_archivo_de_salida");
        JOptionPane.showMessageDialog(null, "No hay nada ya que no hay ningun usuario con una nueva adquisición...");
    }
}
