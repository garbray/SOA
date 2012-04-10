package edu.unipiloto.soa.modelo;

import javax.ejb.Remote;

import edu.unipiloto.soa.xml.Cliente;
import edu.unipiloto.soa.xml.Cuenta;

@Remote
public interface IServiciosCliente {
	
	public boolean crearCliente(Cliente cliente,Cuenta cuenta);
	
	public boolean comprar(double costo);
	
	public boolean redimirPuntos(String premio);

}
