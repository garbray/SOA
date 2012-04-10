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
	public boolean redimirPuntos(@WebParam(name="ID Premio") String numPremio) {
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
			xmlWrite.writeXML(client, acount, lAwards, lTransacciones);
			return true;
		}
		return false;
	}
	
	

	public boolean crearCliente(Cliente cliente, Cuenta cuenta) {
		XmlReader xmlRead = new XmlReader();
		client = xmlRead.getClient();
		acount = xmlRead.getAcount();
		lTransacciones = xmlRead.getTransactions();
		lAwards = xmlRead.getPremios();
		//crear la implementacion de lista de clientes para agregar un nuevo cliente
		
		return false;
	}
	
}
