package edu.unipiloto.soa.modelo;

import javax.ejb.Remote;


@Remote
public interface IServiciosCliente {
	
	public boolean crearCliente(String nombre,String direccion, String telefono, String cedula, String puntos, 
								String idCuenta, String estado, String saldo);
	
	public boolean comprar(double costo);
	
	public boolean redimirPuntos(String premio);

}
