package venta;
import java.util.ArrayList;
import venta.Pago; 
import venta.Subasta;
import usuarios.Comprador;


public class Venta {
	private float precio;
	private boolean esperaVenta;
	private String piezaTitulo;
	private ArrayList<Comprador> posiblesCompradores;
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isEsperaVenta() {
		return esperaVenta;
	}
	public void setEsperaVenta(boolean esperaVenta) {
		this.esperaVenta = esperaVenta;
	}
	public String getPiezaTitulo() {
		return piezaTitulo;
	}
	public void setPiezaTitulo(String piezaTitulo) {
		this.piezaTitulo = piezaTitulo;
	}
	public ArrayList<Comprador> getPosiblesCompradores() {
		return posiblesCompradores;
	}
	public void setPosiblesCompradores(ArrayList<Comprador> posiblesCompradores) {
		this.posiblesCompradores = posiblesCompradores;
	}
	
	
}
