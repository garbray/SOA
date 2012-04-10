package edu.unipiloto.soa.xml;

import java.util.ArrayList;

public class ListaTransacciones {
	
	Transaccion transaccion;
	ArrayList<Transaccion> listaTransacciones;
	
	public Transaccion getTransaccionID(int i){
		return listaTransacciones.get(i);
	}
	
	public ListaTransacciones(){
		listaTransacciones = new ArrayList<Transaccion>();
	}
	
	public void agregarTransaccion(String fecha,String numFactura,String tipo,String valor,String valorFactura){
		transaccion = new Transaccion();
		transaccion.setFecha(fecha);
		transaccion.setNumFactura(numFactura);
		transaccion.setTipo(tipo);
		transaccion.setValor(valor);
		transaccion.setValorFactura(valorFactura);
		listaTransacciones.add(transaccion);
	}
	
	public int numTransacciones(){
		return listaTransacciones.size();
	}
}
