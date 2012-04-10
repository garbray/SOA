package edu.unipiloto.soa.xml;


import java.util.ArrayList;

public class ListaPremios {
	
	Premios premios;
	ArrayList<Premios> listaPremios;
	
	public ListaPremios(){
		listaPremios = new ArrayList<Premios>();
	}
	
	public void agregarPremio(String codigo,String nombre,String dinero,String puntos){
		premios = new Premios();
        premios.setCodigo(codigo);
        premios.setNombre(nombre);
        premios.setPuntos(puntos);
        premios.setDinero(dinero);
		
        listaPremios.add(premios);
	}
	
	public Premios getPremioID(int i){
		return listaPremios.get(i);
	}

	public int numPremios(){
		return listaPremios.size();
	}
}
