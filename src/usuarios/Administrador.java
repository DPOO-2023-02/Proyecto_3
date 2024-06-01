package usuarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
	public static void agregarPieza(Scanner scanner2) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Introduzca el título de la pieza: ");
		String titulo = scanner.nextLine();

		System.out.println("Introduzca el año de creación de la pieza: ");
		String anio = scanner.nextLine();

		System.out.println("Introduzca el/los autores de la pieza: ");
		String autores = scanner.nextLine();

		System.out.println("Introduzca el lugar de creación de la pieza: ");
		String lugarCreacion = scanner.nextLine();

		System.out.println("Introduzca la disponibilidad de la pieza (true/false): ");
		boolean disponibilidadVenta = Boolean.parseBoolean(scanner.nextLine());

		System.out.println("Introduzca el propietario actual de la pieza. (Se sugiere que sea galeria): ");
		String propietarioActual = scanner.nextLine();

		System.out.println("Introduzca la ubicación actual de la pieza: ");
		String ubicacionActual = scanner.nextLine();

		System.out.println("Introduzca el precio de la pieza: ");
		double precio = Double.parseDouble(scanner.nextLine());

		System.out.println("Seleccione el tipo de pieza a crear:");
		System.out.println("1. Pintura");
		System.out.println("2. Escultura");
		System.out.println("3. Video");
		System.out.println("4. Fotografía");
		System.out.println("5. Impresión");
		System.out.print("Ingrese su opción: ");
		int tipoPieza = scanner.nextInt();
		scanner.nextLine();

		switch (tipoPieza) {
		case 1:
			crearPintura(scanner, titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietarioActual, ubicacionActual, precio);
			break;
		case 2:
			crearEscultura(scanner, titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietarioActual, ubicacionActual, precio);
			break;
		case 3:
			crearVideo(scanner, titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietarioActual, ubicacionActual, precio);
			break;
		case 4:
			crearFotografia(scanner, titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietarioActual, ubicacionActual, precio);
			break;
		case 5:
			crearImpresion(scanner, titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietarioActual, ubicacionActual, precio);
			break;
		default:
			System.out.println("Tipo de pieza no válido.");
			break;
		}
	}

	public static void crearPintura(Scanner scanner, String titulo, String anio, String autores,
			String lugarCreacion, boolean disponibilidadVenta, String propietarioActual, String ubicacionActual, double precio) {
		System.out.println("Creando una nueva Pintura...");

		System.out.print("Ingrese el material: ");
		String material = scanner.nextLine();

		System.out.print("Ingrese el tamaño: ");
		String tamanio = scanner.nextLine();

		System.out.print("Ingrese el tipo de lienzo: ");
		String lienzo = scanner.nextLine();

		Pintura nuevaPintura = new Pintura(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
				new ArrayList<>(), propietarioActual, ubicacionActual, precio, material, tamanio, lienzo);

		Inventario.agregarPieza(nuevaPintura);
		System.out.println("Pintura agregada exitosamente al inventario.");
	}

	public static void crearEscultura(Scanner scanner, String titulo, String anio, String autores,
			String lugarCreacion, boolean disponibilidadVenta, String propietarioActual, String ubicacionActual, double precio) {
		System.out.println("Creando una nueva Escultura...");

		System.out.print("Ingrese los materiales utilizados: ");
		String materiales = scanner.nextLine();

		System.out.print("Ingrese detalles de instalación: ");
		String detallesInstalacion = scanner.nextLine();

		System.out.print("¿Requiere electricidad? (true/false): ");
		boolean requiereElectricidad = Boolean.parseBoolean(scanner.nextLine());

		System.out.print("Ingrese el peso de la escultura (por ejemplo, 500 kg): ");
		String peso = scanner.nextLine();

		System.out.print("Ingrese las dimensiones de la escultura (por ejemplo, 2m x 1m x 1m): ");
		String dimensiones = scanner.nextLine();

		Escultura nuevaEscultura = new Escultura(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
				new ArrayList<>(), propietarioActual, ubicacionActual,
				precio, materiales, detallesInstalacion, requiereElectricidad, peso, dimensiones);

		Inventario.agregarPieza(nuevaEscultura);
		System.out.println("Escultura agregada exitosamente al inventario.");
	}

	public static void crearVideo(Scanner scanner, String titulo, String anio, String autores,
			String lugarCreacion, boolean disponibilidadVenta, String propietarioActual, String ubicacionActual, double precio) {
		System.out.println("Creando un nuevo Video...");

		System.out.print("Ingrese la resolución del video (por ejemplo, 1920x1080): ");
		String resolucion = scanner.nextLine();

		System.out.print("Ingrese la relación de imagen (por ejemplo, 16:9): ");
		String relacionImagen = scanner.nextLine();

		System.out.print("¿Tiene audio? (true/false): ");
		boolean audio = Boolean.parseBoolean(scanner.nextLine());

		System.out.print("¿Es a color? (true/false): ");
		boolean tienecolor = Boolean.parseBoolean(scanner.nextLine());


		Video nuevoVideo = new Video(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
				new ArrayList<>(), propietarioActual, ubicacionActual,
				precio, resolucion, relacionImagen, audio, tienecolor);

		Inventario.agregarPieza(nuevoVideo);
		System.out.println("Video agregado exitosamente al inventario.");
	}

	public static void crearFotografia(Scanner scanner, String titulo, String anio, String autores,
			String lugarCreacion, boolean disponibilidadVenta, String propietarioActual, String ubicacionActual, double precio) {
		System.out.println("Creando una nueva Fotografía...");

		System.out.print("Ingrese la resolución de la fotografía (por ejemplo, 1920x1080): ");
		String resolucion = scanner.nextLine();

		System.out.print("Ingrese la relación de imagen (por ejemplo, 16:9): ");
		String relacionImagen = scanner.nextLine();

		System.out.print("¿La fotografía tiene color? (true/false): ");
		boolean tieneColor = Boolean.parseBoolean(scanner.nextLine());

		System.out.print("¿La fotografía es digital? (true/false): ");
		boolean esDigital = Boolean.parseBoolean(scanner.nextLine());

		Fotografia nuevaFotografia = new Fotografia(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
				new ArrayList<>(), propietarioActual, ubicacionActual, precio, resolucion, relacionImagen, tieneColor, esDigital);

		Inventario.agregarPieza(nuevaFotografia);
		System.out.println("Fotografía agregada exitosamente al inventario.");
	}

	public static void crearImpresion(Scanner scanner, String titulo, String anio, String autores,
			String lugarCreacion, boolean disponibilidadVenta, String propietarioActual, String ubicacionActual, double precio) {
		System.out.println("Creando una nueva Impresión...");

		System.out.print("Ingrese la resolución de la impresión (por ejemplo, 2400x1200): ");
		String resolucion = scanner.nextLine();

		System.out.print("Ingrese el material de la impresión (por ejemplo, papel fotográfico): ");
		String material = scanner.nextLine();

		System.out.print("Ingrese la relación de imagen (por ejemplo, 16:9): ");
		String relacionImagen = scanner.nextLine();

		System.out.print("¿Tiene color? (true/false): ");
		boolean tieneColor = Boolean.parseBoolean(scanner.nextLine());

		Impresion nuevaImpresion = new Impresion(titulo, anio, autores, lugarCreacion, disponibilidadVenta,
				new ArrayList<>(), propietarioActual, ubicacionActual,
				precio, resolucion, material, relacionImagen, tieneColor);

		Inventario.agregarPieza(nuevaImpresion);
		System.out.println("Impresión agregada exitosamente al inventario.");
	}

	public static void buscarPiezaPorTitulo(String titulo) {
		List<Pieza> piezas = Inventario.consultarInventario(); 
		for (Pieza pieza : piezas) {
			if (pieza.getTitulo().equals(titulo)) {
				System.out.println("Pieza encontrada:");
				System.out.println(pieza);
				return;
			}
		}
		System.out.println("No se encontró ninguna pieza con título '" + titulo + "'.");
	}

	public static void consultarInventario() {
		List<Pieza> piezas = Inventario.consultarInventario();
		if (piezas.isEmpty()) {
			System.out.println("El inventario está vacío.");
		} else {
			System.out.println("Inventario de piezas:");
			for (Pieza pieza : piezas) {
				System.out.println("===================" +
						"\nTítulo: " + pieza.getTitulo() +
						"\nAño: " + pieza.getAnio() +
						"\nAutores: " + pieza.getAutores() +
						"\nLugar de creación: " + pieza.getLugarCreacion() +
						"\nDisponibilidad de venta: " + (pieza.isDisponibilidadVenta() ? "Disponible" : "No disponible") +
						"\nPropietario actual: " + pieza.getPropietarioActual() +
						"\nUbicación actual: " + pieza.getUbicacionActual() +
						"\nPrecio: $" + pieza.getPrecio() +
						"\nSubastable: " + (pieza.isSubastable() ? "Sí" : "No"));
			}
		}
	}

	public static void eliminarPieza() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Ingrese el título de la pieza que desea eliminar:");
			String titulo = scanner.nextLine();
			Inventario.eliminarPieza(titulo);
			System.out.println("La pieza con título '" + titulo + "' ha sido eliminada.");
		} finally {
			scanner.close(); 
		}
	}
	public static void Verhistorial_clientes() {
	    UsuarioPiezas admin = new UsuarioPiezas();
	    admin.cargarUsuarios("usuarios.txt");
	    admin.cargarPiezas("piezas.txt");
	    admin.escribirArchivo("ruta_del_archivo_de_salida");
	    System.out.println("No hay nada ya que no hay ningun usuario con una nueva adquisición...");;
	}

	
}


