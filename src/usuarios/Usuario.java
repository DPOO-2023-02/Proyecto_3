package usuarios;

public abstract class Usuario {
	private String nombre;
	private String contrasenia;
	static double dinero;

	public Usuario(String nombre, String contrasenia, double dinero) {
		this.nombre=nombre;
		this.contrasenia=contrasenia;
		Usuario.dinero=dinero;
	}	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public static double getDinero() {
		return dinero;
	}

	public static void setDinero(double dinero) {
		Usuario.dinero = dinero;
	}

}
