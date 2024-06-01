package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import usuarios.Cliente;

class TestCliente {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testConsultarDinero() {
        Cliente.consultarDinero();
        String expectedOutput = "Saldo disponible: 1000.0 unidades monetarias.";
        assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testAgregarFondosValidos() {
        String input = "500";
        Scanner scanner = new Scanner(input);
        Cliente.agregarFondos(scanner);
        scanner.close();
        String expectedOutput = "Fondos agregados exitosamente. Saldo actual: 1500.0";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testAgregarFondosInvalidos() {
        String input = "-100";
        Scanner scanner = new Scanner(input);
        Cliente.agregarFondos(scanner);
        scanner.close();
        String expectedOutput = "Cantidad no válida. Por favor, ingrese un valor positivo.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testVerHistorialCompras() {
        ArrayList<String> historial = Cliente.verHistorialCompras();
        assertNotNull(historial);  // Verificar que el historial no es null
    }
}