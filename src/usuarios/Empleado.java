package usuarios;

import java.util.ArrayList;
import java.util.Collections;

import piezas.Pieza;
import venta.Subasta;

public class Empleado extends Usuario{
	public Boolean pagorealizado;
	protected ArrayList<Double> listaPujas;
	private Subasta subastaActual;
	private Pieza pieza;
	
	public Empleado(String nombre, String contrasenia, double dinero) {
		super(nombre, contrasenia, dinero);
		// TODO Auto-generated constructor stub
	}

	public static boolean ConfirmarPago(Usuario usuario, double cantidad, boolean esSubasta) {
		if (usuario.getDinero() >= cantidad) {
			usuario.setDinero(cantidad);
			if (esSubasta) {
				System.out.println("Pago confirmado desde subasta.");
			} else {
				System.out.println("Pago confirmado desde venta normal.");
			}
			return true;
		} else {
			System.out.println("Fondos insuficientes.");
			return false;
		}
	}
	public static void CambiarComprador() {
		// TODO Auto-generated method stub
		
	}
	
	public void registrarPuja(double monto) {
        listaPujas.add(monto);
        Collections.sort(listaPujas, Collections.reverseOrder());
        while (listaPujas.size() > 3) {
            listaPujas.remove(listaPujas.size() - 1);
        }
    }
	public ArrayList<Double> getListaPujas() {
        return new ArrayList<>(listaPujas); 
    }
	
	public void iniciarSubasta(Pieza pieza, double valorInicial, double valorMinimo) {
        this.subastaActual = new Subasta(valorInicial, valorMinimo, pieza);
        subastaActual.establecerPiezaEnSubasta(pieza); 
        subastaActual.abrirSubasta();
        this.listaPujas.clear();
	}


	public static void registrarpujas() {
		// TODO toca hacerlo xd
		
	}
}
