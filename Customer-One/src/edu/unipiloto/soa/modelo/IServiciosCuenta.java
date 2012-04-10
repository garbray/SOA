package edu.unipiloto.soa.modelo;

import javax.ejb.Remote;


@Remote
public interface IServiciosCuenta {
	
	//servicios que procesan el evento de venta y consulta de saldo
	public String obtenerCatalogo();
	
	//cuando el cliente redime puntos, se crean transacciones cr�dito
	
	
	public double consultarSaldo(String cedula);

}
