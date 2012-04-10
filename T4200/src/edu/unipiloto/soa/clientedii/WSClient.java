package edu.unipiloto.soa.clientedii;


import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceFactory;

public class WSClient {

	
public static double consultarSaldo(String cedula){
		
		try {
			
			String endpoint = 
			"http://localhost:8080/market/ServiciosCuenta";
			String nsXML = "http://www.w3.org/2001/XMLSchema";
			String nsTNS = "http://modelo.soa.unipiloto.edu/";
			
			QName nombreWS = new QName(endpoint,"ServiciosCuenta");
			QName nombreOperacion = new QName(nsTNS,"consultarSaldo");
			
			QName xmlStringType = new QName(nsXML, "string");
			QName xmlDoubleType = new QName(nsXML, "double");
			   
			ServiceFactory factory = ServiceFactory.newInstance();
			Service service = factory.createService(nombreWS);
			
			Call call = service.createCall();
			call.setOperationName(nombreOperacion);
			call.addParameter("cedula", xmlStringType, ParameterMode.IN);
			call.setReturnType(xmlDoubleType);
			
			call.setTargetEndpointAddress(endpoint);		
			return (Double) call.invoke(new Object[]{cedula});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("El saldo es:" + consultarSaldo("10244"));		
	}


}
