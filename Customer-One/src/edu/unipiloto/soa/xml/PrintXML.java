package edu.unipiloto.soa.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;



public class PrintXML {
	
public static void main(String[] args) {
		
		try {
			String fileXML = "Empleados.xml";
			
			DocumentBuilderFactory factory = 
						DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document doc = builder.parse(fileXML);
			
			Node root = doc.getFirstChild();
			
			System.out.println(root.getTextContent());
			//printNode(root); TODO: implementar éste método
			
			
		} catch (Exception e) {
			
			System.out.println("Ocurrió un error al leer el  archivo. " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void printNode(Node node){
		for(int i= 0 ; i< 10;i++){
			
		}
			
		
	}


}
