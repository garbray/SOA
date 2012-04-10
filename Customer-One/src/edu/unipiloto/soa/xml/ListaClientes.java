package edu.unipiloto.soa.xml;

import java.util.ArrayList;

public class ListaClientes {
	
	//implementar la lista de los clientes y grabado en el xml correcto pilass
	Cliente cliente;
	ArrayList<Cliente> listaClientes;
	
	public ListaClientes(){
		listaClientes = new ArrayList<Cliente>();
	}
	
	public void agregarCliente(String nombre,String cedula,String direccion,String telefono){
		cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setDireccion(direccion);
		cliente.setNombre(nombre);
		cliente.setTelefono(telefono);
		listaClientes.add(cliente);
	}
	
	public int tamListaCliente(){
		return listaClientes.size();
	}
}
