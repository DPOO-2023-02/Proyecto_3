package historial;
import java.io.*;
import java.util.*;

public class UsuarioPiezas {

    public Map<String, List<String>> piezasPorComprador = new HashMap<>();
    public Set<String> usuariosValidos = new HashSet<>();


	public static void main(String[] args) {
		UsuarioPiezas admin = new UsuarioPiezas();
		admin.generarClientes("Usuarios.txt", "Piezas.txt", "Clientes.txt");
	}

	public void generarClientes(String rutaUsuarios, String rutaPiezas, String rutaSalida) {
		cargarUsuarios(rutaUsuarios);
		cargarPiezas(rutaPiezas);
		escribirArchivo(rutaSalida);
	}

	public void cargarUsuarios(String rutaUsuarios) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(rutaUsuarios));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 4) {
					String usuario = datos[0].toLowerCase();
					String rol = datos[2];
					if (rol.equals("comprador") || rol.equals("propietario")) {
						usuariosValidos.add(usuario);
					}

				}else {
					System.err.println("La línea no tiene el formato esperado: " + linea);
				}
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Error al cargar usuarios: " + e.getMessage());
		}
	}

	public void cargarPiezas(String rutaPiezas) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(rutaPiezas));
			String linea;
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				if (datos.length >= 8) {
					String propietario = datos[5].toLowerCase();
					if (usuariosValidos.contains(propietario)) {
						piezasPorComprador.computeIfAbsent(datos[5], k -> new ArrayList<>()).add(datos[0] + ", " + datos[7]);
					}
				}else {
					System.err.println("La línea no tiene el formato esperado: " + linea);
				}
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Error al cargar piezas: " + e.getMessage());
		}
	}

	public void escribirArchivo(String rutaSalida) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(rutaSalida));
			for (Map.Entry<String, List<String>> entry : piezasPorComprador.entrySet()) {
				String piezas = String.join("; ", entry.getValue());
				pw.println(entry.getKey() + ", [" + piezas + "]");
			}
			pw.close();
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo de salida: " + e.getMessage());
		}
	}

	public List<String> leerArchivo(String rutaArchivo) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                System.out.println(linea); 
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }


	public void verMisPiezas(String ola) {
		// TODO: Implementar funcionalidad
	}

}
