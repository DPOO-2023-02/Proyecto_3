package venta;

import java.util.ArrayList;
import java.util.HashMap;

import piezas.Pieza;
import venta.Pago; 
import usuarios.Comprador;
import usuarios.Operador;
import usuarios.Usuario;
import usuarios.Comprador;

public class Subasta {
	public static double valorMinimo;
	public static double valorInicial;
	private double ofertas;
	private Pieza pieza;
	private double costoFinal;
	private ArrayList<Comprador> posiblesCompradores;
	private int numeroPostores;
	private double ofertaActual;
	
	public Subasta(double valorInicial, double valorMinimo, Pieza pieza) {
        Subasta.valorInicial = valorInicial;
        Subasta.valorMinimo = valorMinimo;
        this.pieza = pieza;
        this.ofertaActual = valorInicial;
        this.setCostoFinal(0.0);
        this.setNumeroPostores(0);
        this.posiblesCompradores =new ArrayList<>();
        Operador.listaPujas = ofertas;  
    }
	
	

    // Getters y setters para los atributos privados de la clase
	public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public int getNumeroPostores() {
        return numeroPostores;
    }

    public void setNumeroPostores(int numeroPostores) {
        this.numeroPostores = numeroPostores;
    }
    public void abrirSubasta() {
        setNumeroPostores(0); 
        posiblesCompradores.clear(); 
        ofertas.clear(); 
        ofertaActual = valorInicial; 
    }

    public void registrarParticipante(Comprador comprador) {
        if (!posiblesCompradores.contains(comprador)) {
            posiblesCompradores.add(comprador);
            numeroPostores++;
        }
    }
    public boolean realizarOferta(Comprador comprador, double oferta) {
        if (oferta <= ofertaActual || oferta < valorInicial) {
            return false;
        }

        ofertas.put(comprador, oferta);
        if (oferta > ofertaActual) {
            ofertaActual = oferta;
        }
        return true;
    }

    public Comprador terminarSubasta() {
        Comprador ganador = null;
        double mayorOferta = 0.0;

        for (HashMap.Entry<Comprador, Double> entrada : ofertas.entrySet()) {
            if (entrada.getValue() > mayorOferta) {
                mayorOferta = entrada.getValue();
                ganador = entrada.getKey();
            }
        }

        if (ganador != null && mayorOferta >= valorMinimo) {
            setCostoFinal(mayorOferta);
            pieza.setPropietarioActual(ganador); // Suponiendo que el método setPropietarioActual acepta un Comprador
            pieza.setDisponibilidadVenta(false); // Suponiendo que Pieza tiene un método setDisponibilidadVenta
        }

        return ganador;
    }



	public void establecerPiezaEnSubasta(Pieza pieza2) {
		// toca hacer esto manito
		
	}
}
