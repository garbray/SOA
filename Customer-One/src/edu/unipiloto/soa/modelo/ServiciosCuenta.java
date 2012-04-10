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


@WebService
@SOAPBinding(style=Style.RPC)
@WebContext(contextRoot="market")
@Stateless
public class ServiciosCuenta implements IServiciosCuenta{
	
	
	Cliente client;
	Cuenta acount;
	ListaTransacciones trans;
	ListaPremios awards;
	
	
	
	@WebMethod
	public double consultarSaldo( 
			@WebParam(name="cedula")String cedula) {
			XmlReader xmlRead = new XmlReader();
			client = xmlRead.getClient();
			acount = xmlRead.getAcount();
			if(cedula.equals(acount.getId()))
				return Double.parseDouble(acount.getSaldo());
			return 0;
	}
	
	@WebMethod
	public String obtenerCatalogo() {
		XmlReader xmlRead = new XmlReader();
		client = xmlRead.getClient();
		acount = xmlRead.getAcount();
		trans = xmlRead.getTransactions();
		awards = xmlRead.getPremios();
		
		String catalogo="";
		for(int i=0;i<awards.numPremios();i++){
			catalogo += awards.getPremioID(i).getNombre()+",";
		}
		return catalogo;
	}
	
	
	
}
