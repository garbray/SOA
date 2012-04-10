package edu.unipiloto.soa.modelo;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.jboss.wsf.spi.annotation.WebContext;

import edu.unipiloto.soa.xml.Cliente;
import edu.unipiloto.soa.xml.Cuenta;
import edu.unipiloto.soa.xml.ListaPremios;
import edu.unipiloto.soa.xml.ListaTransacciones;
import edu.unipiloto.soa.xml.XmlReader;
import edu.unipiloto.soa.xml.XmlWriter;



@WebService
@SOAPBinding(style=Style.RPC)
@WebContext(contextRoot="market")
@Stateless
public class ServiciosCliente implements IServiciosCliente {
	
	Cliente client;
	Cuenta acount;
	ListaTransacciones lTransacciones;
	ListaPremios lAwards;
	
	

	@WebMethod
	public boolean redimirPuntos(
		@WebParam(name="numeroPremio") String numPremio) {
		XmlReader xmlRead = new XmlReader();
		client = xmlRead.getClient();
		acount = xmlRead.getAcount();
		lTransacciones = xmlRead.getTransactions();
		lAwards = xmlRead.getPremios();
		
		for(int i=0;i<lAwards.numPremios();i++){
			if(lAwards.getPremioID(i).getCodigo().equals(numPremio)){
				double saldo =Double.parseDouble(acount.getSaldo());
				double valor = Double.parseDouble(lAwards.getPremioID(i).getPuntos());
				if(saldo>valor){
					acount.setSaldo(Double.toString(saldo-valor));
					XmlWriter xmlWriter = new XmlWriter();
					xmlWriter.writeXML(client, acount, lAwards, lTransacciones);
					return true;
				}else{
					return false;
				}
			}
		}
		return false;
	}
	
	@WebMethod
	public boolean comprar(
	@WebParam(name="costo") double costo) {
		XmlReader xmlRead = new XmlReader();
		client = xmlRead.getClient();
		acount = xmlRead.getAcount();
		lTransacciones = xmlRead.getTransactions();
		lAwards = xmlRead.getPremios();
		
		if(Double.parseDouble(acount.getSaldo())>= costo){
			acount.setSaldo(Double.toString(Double.parseDouble(acount.getSaldo())-costo));
			XmlWriter xmlWrite = new XmlWriter();
			System.out.println("ok2");
			xmlWrite.writeXML(client, acount, lAwards, lTransacciones);
			return true;
		}
		return false;
	}
	
	
	@WebMethod
	public boolean crearCliente(
		@WebParam(name="Nombre")	String nombre,
		@WebParam(name="Direccion")	String direccion, 
		@WebParam(name="Telefono")	String telefono, 
		@WebParam(name="Cedula")	String cedula, 
		@WebParam(name="Puntos")	String puntos, 
		@WebParam(name="ID_Cuenta")	String idCuenta, 
		@WebParam(name="Estado")	String estado, 
		@WebParam(name="Saldo") String saldo) {
		XmlReader xmlRead = new XmlReader();
		client = xmlRead.getClient();
		acount = xmlRead.getAcount();
		lTransacciones = xmlRead.getTransactions();
		lAwards = xmlRead.getPremios();
		
		client.setNombre(nombre);
		client.setCedula(cedula);
		client.setDireccion(direccion);
		client.setTelefono(telefono);
		client.setPuntos(puntos);
		
		acount.setEstado(estado);
		acount.setId(idCuenta);
		acount.setSaldo(saldo);
		
		XmlWriter xmlWriter = new XmlWriter();
		System.out.println(client.getNombre());
		System.out.println(acount.getId());
		xmlWriter.writeXML(client, acount, lAwards, lTransacciones);
		//crear la implementacion de lista de clientes para agregar un nuevo cliente
		
		return true;
	}
	
}
