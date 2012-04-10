package edu.unipiloto.soa.xml;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlReader {
	
	Cliente client;
	Cuenta acount;
	ListaPremios Lawards;
	ListaTransacciones lTransactions;
	
	
	public XmlReader(){
		
		client = new Cliente();
		acount = new Cuenta();
		lTransactions = new ListaTransacciones();
		Lawards = new ListaPremios();
		
		try {
			
			DocumentBuilderFactory factory =
	            DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        
	        Document doc = builder.parse(new File("C:\\java\\workspace\\Customer-One\\market.xml"));
	        Element rootElement = doc.getDocumentElement();
	        
	        /*
	         * queda pendiente para multiples clientes 
	         * 
	        NodeList node = rootElement.getElementsByTagName("cliente"); 
	        for(int i=0;i<node.getLength();i++){
	        	String cNombre = node.item(i).getChildNodes().item(1).getTextContent();
	        	String cDireccion = node.item(i).getChildNodes().item(3).getTextContent();
	        	String cTelefono = node.item(i).getChildNodes().item(5).getTextContent();
	        }*/
	        
	        NodeList node = rootElement.getElementsByTagName("nombre"); 
	        client.setNombre(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("direccion");
	        client.setDireccion(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("telefono");
	        client.setTelefono(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("puntos");
	        client.setPuntos(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("estado");
	        acount.setEstado(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("saldo");
	        acount.setSaldo(node.item(0).getTextContent());
	        node = rootElement.getElementsByTagName("identificacion");
	        acount.setId(node.item(0).getTextContent());
	        
	        node = rootElement.getElementsByTagName("transaccion");
	        
	        for(int i = 0;i<node.getLength();i++){
	        	String tFecha = node.item(i).getChildNodes().item(1).getTextContent();
	        	String tNumFac = node.item(i).getChildNodes().item(3).getTextContent();
	        	String tValorFac = node.item(i).getChildNodes().item(5).getTextContent();
	        	String tValor = node.item(i).getChildNodes().item(7).getTextContent(); 
	        	String tTipo = node.item(i).getChildNodes().item(9).getTextContent();
	        	
	        	lTransactions.agregarTransaccion(tFecha, tNumFac, tTipo, tValor, tValorFac);
	        }
	        
	        
	        
	        //lectura de premios pilas aqui va con la lista  
	        node = rootElement.getElementsByTagName("premio");
	        
	       
	        for(int i=0;i<node.getLength();i++){
	        	//datos necesarios para inicializar un nuevo premio
	        	
	        	String pCodigo = node.item(i).getChildNodes().item(1).getTextContent();
	        	String pNombre = node.item(i).getChildNodes().item(3).getTextContent();
	        	String pDinero = node.item(i).getChildNodes().item(7).getTextContent();
	        	String pPuntos = node.item(i).getChildNodes().item(5).getTextContent();
	        	Lawards.agregarPremio(pCodigo, pNombre, pDinero, pPuntos);
	        	
	        }
		} catch (Exception e) {
			System.out.println(e);
		}
		 
	}
	
	//hay que modificar con estemetodo la invocacion en el metodo anterior
	public NodeList readElem(String elem, Element rootElement){
		return rootElement.getElementsByTagName(elem);
	}
	
	
	public ListaTransacciones getTransactions(){
		return lTransactions;
	}
	
	public ListaPremios getPremios(){
		return Lawards;
	}
	 
	public Cuenta getAcount(){
		return acount;
	}
	
	public Cliente getClient(){
		return client;
	}
	
	public static void main(String[] args) {
		XmlReader x = new XmlReader();
		System.out.println(x.client.getNombre());
		System.out.println(x.Lawards.getPremioID(2).getPuntos());
		System.out.println(x.getTransactions().getTransaccionID(1).getNumFactura());
	}

}
