package piezas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private static List<Pieza> piezas = new ArrayList<>();
    private static final String ARCHIVO = "piezas.txt";

    public static void agregarPieza(Pieza pieza) {
        piezas.add(pieza);
        guardarPiezas(piezas); 
    }

    public static void eliminarPieza(String titulo) {
        piezas.removeIf(p -> p.getTitulo().equals(titulo));
        guardarPiezas(piezas);
    }

    public static void guardarPiezas(List<Pieza> piezas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Pieza pieza : piezas) {
                writer.write(pieza.getTitulo() + "," +
                        pieza.getAnio() + "," +
                        pieza.getAutores() + "," +
                        pieza.getLugarCreacion() + "," +
                        pieza.isDisponibilidadVenta() + "," +
                        pieza.getPropietarioActual() + "," +
                        pieza.getUbicacionActual() + "," +
                        pieza.getPrecio() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pieza> consultarInventario() {
        List<Pieza> nuevasPiezas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                nuevasPiezas.add(crearPiezaDesdeDatos(linea.split(",")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nuevasPiezas;
    }

    private static Pieza crearPiezaDesdeDatos(String[] datos) {
        String titulo = datos[0];
        String anio = datos[1];
        String autores = datos[2];
        String lugarCreacion = datos[3];
        boolean disponibilidadVenta = Boolean.parseBoolean(datos[4]);
        String propietarioActual = datos[5];
        String ubicacionActual = datos[6];
        double precio = Double.parseDouble(datos[7]);

        return new Pieza(titulo, anio, autores, lugarCreacion, disponibilidadVenta, new ArrayList<>(), propietarioActual, ubicacionActual, precio) {
        };
    }
    
    public static void limpiarInventario() {
        piezas.clear(); 
        guardarPiezas(new ArrayList<>());
    }

    public static List<Pieza> listaPiezasDisponiblesParaVenta() {
        return piezas.stream()
                .filter(Pieza::isDisponibilidadVenta)
                .collect(Collectors.toList());
    }

    public static List<Pieza> listaPiezasSubastables() {
        return piezas.stream()
                .filter(Pieza::isSubastable)
                .collect(Collectors.toList());
    }
}