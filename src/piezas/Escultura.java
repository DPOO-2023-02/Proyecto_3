package piezas;

import java.util.List;

public class Escultura extends Pieza {
    
    private String material;
    private String detalleInstalacion;
    private String dimensiones; 
    private boolean requiereElectricidad;
    private String peso;

    public Escultura(String titulo, String anio, String autores, String lugarCreacion, boolean disponibilidadVenta,
			List<String> propietariosAnteriores, String propietarioActual, String ubicacionActual, double precio, 
            String material, String detalleInstalacion, boolean requiereElectricidad, String peso, String dimensiones) {
        
        super(titulo, anio, autores, lugarCreacion, disponibilidadVenta, propietariosAnteriores, propietarioActual,
                ubicacionActual, precio);
        
        this.material = material;
        this.detalleInstalacion = detalleInstalacion;
        this.requiereElectricidad = requiereElectricidad;
        this.peso = peso;
        this.dimensiones = dimensiones;
    }
        
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDetalleInstalacion() {
        return detalleInstalacion;
    }
    public void setDetalleInstalacion(String detalleInstalacion) {
        this.detalleInstalacion = detalleInstalacion;
    }

    public String getDimensiones() {
        return dimensiones;
    }
    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public boolean isRequiereElectricidad() {
        return requiereElectricidad;
    }
    public void setRequiereElectricidad(boolean requiereElectricidad) {
        this.requiereElectricidad = requiereElectricidad;
    }

    public String getPeso() {
        return peso;
    }
    public void setPeso(String peso) {
        this.peso = peso;
    }
}
