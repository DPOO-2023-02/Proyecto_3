package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import historial.UsuarioPiezas;

import java.io.*;
import java.util.Arrays;

class TestHistorialUsuarios {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testCargarUsuariosValidos() {
        UsuarioPiezas usuarioPiezas = new UsuarioPiezas();
        String data = "Juan,1234,comprador,20000.0\nPedro,5678,propiedad,15000.0";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            usuarioPiezas.cargarUsuarios("Usuarios.txt");
            assertTrue(usuarioPiezas.usuariosValidos.contains("juan"));
            assertFalse(usuarioPiezas.usuariosValidos.contains("pedro"));
        } finally {
            System.setIn(stdin);
        }
    }
    
    @Test
    public void cargarPiezas(String rutaPiezas) {
        File file = new File(rutaPiezas);
        if (!file.exists()) {
            System.err.println("Error: el archivo no existe: " + rutaPiezas);
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 8) {
                    String propietario = datos[5].trim().toLowerCase();
                    if (usuariosValidos.contains(propietario)) {
                        String piezaInfo = datos[0].trim() + ", " + datos[7].trim();
                        piezasPorComprador.computeIfAbsent(propietario, k -> new ArrayList<>()).add(piezaInfo);
                    }
                } else {
                    System.err.println("La línea no tiene el formato esperado: " + linea);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar piezas: " + e.getMessage());
        }
    }


    @Test
    void testEscribirArchivo() throws IOException {
        UsuarioPiezas usuarioPiezas = new UsuarioPiezas();
        usuarioPiezas.piezasPorComprador.put("juan", Arrays.asList("La Joven de la Perla, 10000.0"));
        String filename = "testOutput.txt";
        usuarioPiezas.escribirArchivo(filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        assertTrue(line.contains("juan"));
        assertTrue(line.contains("La Joven de la Perla, 10000.0"));
        reader.close();
        new File(filename).delete();
    }
}
