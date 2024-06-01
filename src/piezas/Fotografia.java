package piezas;

import java.util.List;

public class Fotografia extends Pieza{
	
	private String resolucion;
	private String relacionImagen;
    private boolean tieneColor;
    private boolean esDigital;
	
    public Fotografia(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
			List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, double precio,
			String resolucion, String relacionImagen, boolean tieneColor, boolean esDigital) {
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual, precio);
		
		this.resolucion = resolucion;
        this.relacionImagen = relacionImagen;
        this.tieneColor = tieneColor;
        this.esDigital = esDigital;
        
	}

	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getRelacionImagen() {
		return relacionImagen;
	}
	public void setRelacionImagen(String relacionImagen) {
		this.relacionImagen = relacionImagen;
	}

	public boolean isTieneColor() {
		return tieneColor;
	}
	public void setTieneColor(boolean tieneColor) {
		this.tieneColor = tieneColor;
	}

	public boolean isEsDijital() {
		return esDigital;
	}
	public void setEsDijital(boolean esDijital) {
		this.esDigital = esDijital;
	}

}
