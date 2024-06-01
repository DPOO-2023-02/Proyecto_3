package piezas;

import java.util.List;

public class Video extends Pieza {
	
	private String resolucion;
	private String relacionImagen;
	private boolean audio;
	private boolean tieneColor;
	
	public Video(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
			List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, double precio,
			String resolucion, String relacionImagen, boolean audio, boolean tieneColor) {
		
		super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
				ubicacionActual, precio);
		
		this.resolucion = resolucion;
        this.setRelacionImagen(relacionImagen);
        this.audio = audio;
        this.setTieneColor(tieneColor);
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
	
	public boolean isAudio() {
		return audio;
	}
	public void setAudio(boolean audio) {
		this.audio = audio;
	}

	public boolean isTieneColor() {
		return tieneColor;
	}
	public void setTieneColor(boolean tieneColor) {
		this.tieneColor = tieneColor;
	}	

}
