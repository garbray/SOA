package edu.unipiloto.soa.xml;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class XmlWriter {
	
	
	public void writeXML(Cliente client, Cuenta acount,ListaPremios awards,ListaTransacciones transactions) {

        try {
        	DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Here instead of parsing an existing document we want to
            // create a new one.
            Document testDoc = builder.newDocument();

            // This creates a new tag named 'testElem' inside
            // the document and sets its data to 'TestContent'
            Element market = testDoc.createElement("Market");
            market.setAttribute("xmlns", "http://www.unipiloto.edu.co/soa/laboratorioXML/soa/lab-xsd");
            market.setAttribute("xmlns:cu", "http://www.unipiloto.edu.co/soa/laboratorioXML/soa/lab-xsd");
            Element cliente = testDoc.createElement("cliente");
            Element clientes = testDoc.createElement("clientes");
            Element nombre = testDoc.createElement("nombre");
            Element direccion = testDoc.createElement("direccion");
            Element telefono = testDoc.createElement("telefono");
            Element puntos = testDoc.createElement("puntos");
            Element cuenta = testDoc.createElement("cuenta");
            Element id = testDoc.createElement("identificacion");
            Element estado = testDoc.createElement("estado");
            Element saldo = testDoc.createElement("saldo");
            Element transacciones = testDoc.createElement("transacciones");
            
            
            Element catalogoPremios = testDoc.createElement("catalogoPremios");
            
            
            
            
            //pilas con la insercion de los datos
            nombre.setTextContent(client.getNombre());
            direccion.setTextContent(client.getDireccion());
            telefono.setTextContent(client.getTelefono());
            puntos.setTextContent(client.getPuntos());
            id.setTextContent(acount.getId());
            estado.setTextContent(acount.getEstado());
            saldo.setTextContent(acount.getSaldo());
            
            
            cliente.appendChild(nombre);
            cliente.appendChild(direccion);
            cliente.appendChild(telefono);
            cliente.appendChild(puntos);
            cliente.appendChild(cuenta);
            
            for(int i=0;i<transactions.numTransacciones();i++){
            	Element transaccion = testDoc.createElement("transaccion");
                Element fecha = testDoc.createElement("fecha");
                Element numeroFactura = testDoc.createElement("numeroFactura");
                Element valorFactura = testDoc.createElement("valorFactura");
                Element tipo = testDoc.createElement("tipo");
                Element valor = testDoc.createElement("valor");
                
            	
            	
            	fecha.setTextContent(transactions.getTransaccionID(i).getFecha());
            	numeroFactura.setTextContent(transactions.getTransaccionID(i).getNumFactura());
                valorFactura.setTextContent(transactions.getTransaccionID(i).getValorFactura());
                valor.setTextContent(transactions.getTransaccionID(i).getValor());
                tipo.setTextContent(transactions.getTransaccionID(i).getTipo());
                transaccion.appendChild(fecha);
                transaccion.appendChild(numeroFactura);
                transaccion.appendChild(valorFactura);
                transaccion.appendChild(valor);
                transaccion.appendChild(tipo);
                transacciones.appendChild(transaccion);
                System.out.println(i+" transa-----");
                
            }
            cliente.appendChild(transacciones);
            cuenta.appendChild(id);
            cuenta.appendChild(estado);
            cuenta.appendChild(saldo);
            clientes.appendChild(cliente);
            market.appendChild(clientes);
            
            
            
            for(int i=0;i<awards.numPremios();i++){
            	Element premio = testDoc.createElement("premio");
                Element codigo = testDoc.createElement("codigo");
                Element nombreP = testDoc.createElement("nombreP");
                Element puntosR = testDoc.createElement("puntosRequeridos");
                Element dineroR = testDoc.createElement("dineroRequerido");
            	
            	codigo.setTextContent(awards.getPremioID(i).getCodigo());
                nombreP.setTextContent(awards.getPremioID(i).getNombre());
                puntosR.setTextContent(awards.getPremioID(i).getPuntos());
                dineroR.setTextContent(awards.getPremioID(i).getDinero());
                premio.appendChild(codigo);
                premio.appendChild(nombreP);
                premio.appendChild(puntosR);
                premio.appendChild(dineroR);
                catalogoPremios.appendChild(premio);
                System.out.println(i+" premios-----");
            }
            
            
            market.appendChild(catalogoPremios);
            
            
            
            
            
            
            
            
            
            
            
            
            
            testDoc.appendChild(market);
            // The XML document we created above is still in memory
            // so we have to output it to a real file.
            // In order to do it we first have to create
            // an instance of DOMSource
            DOMSource source = new DOMSource(testDoc);

            // PrintStream will be responsible for writing
            // the text data to the file
            PrintStream ps = new PrintStream("C:\\java\\workspace\\Customer-One\\market.xml");
            StreamResult result = new StreamResult(ps);

            // Once again we are using a factory of some sort,
            // this time for getting a Transformer instance,
            // which we use to output the XML
            TransformerFactory transformerFactory = TransformerFactory
                .newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // The actual output to a file goes here
            transformer.transform(source, result);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }


}
