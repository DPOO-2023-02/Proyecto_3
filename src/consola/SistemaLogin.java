package consola;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import menu.MainAdministrador;
import menu.MainCliente;
import menu.MainEmpleado;

public class SistemaLogin {
    private static Map<String, String[]> usuarios = new HashMap<>();
    private static final String ARCHIVO_USUARIOS = "usuarios.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        crearArchivoTxt(ARCHIVO_USUARIOS);
        cargarUsuarios();

        try {
            while (true) {
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrar usuario");
                System.out.println("3. Salir");
                System.out.println("Seleccione una opción:");

                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
                        iniciarSesion(scanner);
                        break;
                    case 2:
                        registrarUsuario(scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del sistema...");
                        guardarUsuarios();
                        return;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } finally {
            scanner.close(); 
        }
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.println("Ingrese su nombre de usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");  
        String contraseña = scanner.nextLine();

        if (usuarios.containsKey(usuario) && usuarios.get(usuario)[0].equals(contraseña)) {
            String tipoUsuario = usuarios.get(usuario)[1];
            System.out.println("Inicio de sesión exitoso.");

            switch (tipoUsuario.toLowerCase()) {
                case "administrador":
                    System.out.println("¡Bienvenido, Administrador!");
                    MainAdministrador.main();
                    break;
                case "empleado":
                    System.out.println("¡Bienvenido, Empleado!");
                    MainEmpleado.main();
                    break;
                case "cliente":
                	System.out.println("¡Bienvenido, Cliente!");
                	MainCliente.main();
                	break;
                default:
                    System.out.println("¡Bienvenido!");
                
            }
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos.");
        }
    }



    private static void registrarUsuario(Scanner scanner) {
        System.out.println("Ingrese el nombre de usuario:");
        String nuevoUsuario = scanner.nextLine();
        System.out.println("Ingrese la contraseña:");
        String nuevaContraseña = scanner.nextLine();
        System.out.println("Ingrese el tipo de usuario (administrador/empleado/cliente):");
        String tipoUsuario = scanner.nextLine();
        System.out.println("Ingrese la cantidad de dinero:");
        double dinero = Double.parseDouble(scanner.nextLine());

        usuarios.put(nuevoUsuario, new String[]{nuevaContraseña, tipoUsuario, Double.toString(dinero)});
        guardarUsuarios();

        System.out.println("Usuario registrado con éxito.");
    }

    private static void cargarUsuarios() {
        try (Scanner fileScanner = new Scanner(new File(ARCHIVO_USUARIOS))) {
            while (fileScanner.hasNextLine()) {
                String linea = fileScanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length >= 3) { 
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
}