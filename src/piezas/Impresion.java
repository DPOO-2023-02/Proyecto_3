package piezas;

import java.util.List;

public class Impresion extends Pieza {
    
    private String resolucion;
    private String material;
    private String relacionImagen;
    private boolean tieneColor;
    
    public Impresion(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
			List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, double precio, 
    		String resolucion, String material, String relacionImagen, boolean tieneColor) {
    	
        super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, 
              propietarioActual, ubicacionActual, precio);
        
        this.resolucion = resolucion;
        this.material = material;
        this.relacionImagen = relacionImagen;
        this.tieneColor = tieneColor;
    }
    
    public String getResolucion() {
        return resolucion;
    }
    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }
    
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
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
}
