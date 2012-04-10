package edu.unipiloto.soa.client;

import java.rmi.RemoteException;

import edu.unipiloto.soa.stub.ServiciosClienteProxy;



public class ClientWS {

	public static void main(String[] args) throws RemoteException {
		
		ServiciosClienteProxy servicioProxy = new ServiciosClienteProxy();
		
		boolean ok = servicioProxy.comprar(100.0);
		System.out.println(ok);
	}
}
