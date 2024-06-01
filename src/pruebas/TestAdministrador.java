package pruebas;

import static org.junit.Assert.*;
import org.junit.*;

import piezas.Inventario;
import usuarios.Administrador;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class TestAdministrador {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		Inventario.limpiarInventario();
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

	private void executeAgregarPiezaTest(String inputData, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        Scanner scanner = new Scanner(System.in);
        Administrador.agregarPieza(scanner);
        scanner.close();
        assertTrue(outContent.toString().contains(expectedOutput));
        outContent.reset();
    }

    @Test
    public void testAgregarPiezaPintura() {
        String data = "Aurora\n1894\nFrida Kahlo\nMéxico\ntrue\nMuseo Frida Kahlo\nCiudad de México\n950000\n1\nAceite\n120cm x 100cm\nCanvas";
        executeAgregarPiezaTest(data, "Pintura agregada exitosamente al inventario.");
    }

    @Test
    public void testAgregarPiezaEscultura() {
        String data = "El Guerreo Fantasma\n2023\nUnknown Artist\nJapón\ntrue\nColección Privada\nTokio\n1200000\n2\nAcero y cristales\nInstalación luminosa interactiva\nfalse\n450 kg\n3m x 2m x 2m";
        executeAgregarPiezaTest(data, "Escultura agregada exitosamente al inventario.");
    }

    @Test
    public void testAgregarPiezaVideo() {
        String data = "El Despertar de las Máquinas\n2077\nCyberArt 3000\nNeo-Tokio\ntrue\nExposición Futurista\nNeo-Tokio\n300000\n3\n8K\n21:9\ntrue\ntrue";
        executeAgregarPiezaTest(data, "Video agregado exitosamente al inventario.");
    }

    @Test
    public void testAgregarPiezaFotografia() {
        String data = "Los Colores del Tiempo\n2024\nAlice Wonderland\nNueva Zelanda\ntrue\nGalería Visiones\nAuckland\n180000\n4\n10K\nUltra Panorámico\ntrue\ndigital";
        executeAgregarPiezaTest(data, "Fotografía agregada exitosamente al inventario.");
    }

    @Test
    public void testAgregarPiezaImpresion() {
        String data = "Sueños Digitales\n2025\nEva Future\nCalifornia\ntrue\nGalería Moderna\nSan Francisco\n85000\n5\n4800x2400\nMetallic Gloss\nUltra Wide\ntrue";
        executeAgregarPiezaTest(data, "Impresión agregada exitosamente al inventario.");
    }

	@Test
	public void testEliminarPieza() {
		String inputData = "Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2mx3m\nLienzo";
		System.setIn(new ByteArrayInputStream(inputData.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));

		System.setIn(new ByteArrayInputStream("Mona Lisa\n".getBytes()));
        Administrador.eliminarPieza();

        String expectedOutput = "La pieza con título 'Mona Lisa' ha sido eliminada.";
        assertTrue(outContent.toString().contains(expectedOutput));
	}
	
	@Test
    public void testConsultarInventarioVacio() {
        Administrador.consultarInventario();
        String expectedOutput = "El inventario está vacío.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testConsultarInventarioConPiezas() {
    	String inputDataPieza = "Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2mx3m\nLienzo";
		System.setIn(new ByteArrayInputStream(inputDataPieza.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));
		
		String inputDataEscultutra = "El Pensador\n1902\nRodin\nFrancia\ntrue\nMuseo\nParis\n500000\n2\nBronce\nDetalle de instalación\ntrue\n200 kg\n2m x 1m x 1m";
		System.setIn(new ByteArrayInputStream(inputDataEscultutra.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));

        Administrador.consultarInventario();

        String expectedOutput = "Inventario de piezas:";
        assertTrue(outContent.toString().contains(expectedOutput));
        assertTrue(outContent.toString().contains("Mona Lisa"));
        assertTrue(outContent.toString().contains("El Pensador"));
    }
    
    @Test
    public void testBuscarPiezaPorTituloExistente() {
    	String inputDataEscultutra = "El Pensador\n1902\nRodin\nFrancia\ntrue\nMuseo\nParis\n500000\n2\nBronce\nDetalle de instalación\ntrue\n200 kg\n2m x 1m x 1m";
		System.setIn(new ByteArrayInputStream(inputDataEscultutra.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));
    	
    	String inputDataPieza = "Mona Lisa\n1887\nDa Vinci\nItalia\ntrue\nGaleria\nBogota\n70000\n1\nOleo\n2mx3m\nLienzo";
		System.setIn(new ByteArrayInputStream(inputDataPieza.getBytes()));
		Administrador.agregarPieza(new Scanner(System.in));

        Administrador.buscarPiezaPorTitulo("Mona Lisa");
        String expectedOutput = "Pieza encontrada:";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    public void testBuscarPiezaPorTituloNoExistente() {
    	System.setIn(new ByteArrayInputStream("Mona Lisa\n".getBytes()));
        Administrador.eliminarPieza();

        Administrador.buscarPiezaPorTitulo("Starry Night");
        String expectedOutput = "No se encontró ninguna pieza con título 'Starry Night'.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
}
