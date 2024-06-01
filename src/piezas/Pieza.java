package piezas;

import java.util.ArrayList;
import java.util.List;

public abstract class Pieza {
	private String id;
	private String titulo;
	private String anio;
	private String autores;
	private String lugarCreacion;
	private boolean disponibilidadVenta;
	private List<String> propietariosAnteriores;
	private String propietarioActual;
	private String ubicacionActual;
	private boolean subastable;
	private double precio;

	public Pieza(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
			List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, double precio) {

		this.titulo = titulo;
		this.anio = anio;
		this.autores = autores;
		this.lugarCreacion = lugarCreacion;
		this.disponibilidadVenta = disponibilidadVenta;
		this.propietariosAnteriores = new ArrayList<>(propietariosAnteriores);
		this.propietarioActual = propietarioActual;
		this.ubicacionActual = ubicacionActual;
		this.precio = precio;
		this.subastable = false;

	}
	
	public void hacerDisponibleParaVenta() {
		if (!disponibilidadVenta) {
			disponibilidadVenta = true;
			System.out.println("La pieza ahora está disponible para la venta.");
		}
	}
	
	public void actualizarPrecio(double nuevoPrecio) {
	    if (subastable) {
	        precio = nuevoPrecio;
	        System.out.println("Precio actualizado a: " + nuevoPrecio);
	    } else {
	        System.out.println("Esta pieza no está disponible para subastas.");
	    }
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public String getAutores() {
		return autores;
	}
	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getLugarCreacion() {
		return lugarCreacion;
	}
	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}

	public boolean isDisponibilidadVenta() {
		return disponibilidadVenta;
	}
	public void setDisponibilidadVenta(boolean disponibilidadVenta) {
		this.disponibilidadVenta = disponibilidadVenta;
	}

	public List<String> getPropietariosAnteriores() {
		return propietariosAnteriores;
	}
	public void setPropietariosAnteriores(List<String> propietariosAnteriores) {
		this.propietariosAnteriores = propietariosAnteriores;
	}

	public String getPropietarioActual() {
		return propietarioActual;
	}
	public void setPropietarioActual(String propietarioActual) {
		this.propietarioActual = propietarioActual;
	}

	public String getUbicacionActual() {
		return ubicacionActual;
	}
	public void setUbicacionActual(String ubicacionActual) {
		this.ubicacionActual = ubicacionActual;
	}

	public boolean isSubastable() {
		return subastable;
	}
	public void setSubastable(boolean subastable) {
		this.subastable = subastable;
	}

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}