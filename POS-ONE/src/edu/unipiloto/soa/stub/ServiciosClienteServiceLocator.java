/**
 * ServiciosClienteServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.unipiloto.soa.stub;

public class ServiciosClienteServiceLocator extends org.apache.axis.client.Service implements edu.unipiloto.soa.stub.ServiciosClienteService {

    public ServiciosClienteServiceLocator() {
    }


    public ServiciosClienteServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServiciosClienteServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServiciosClientePort
    private java.lang.String ServiciosClientePort_address = "http://127.0.0.1:8080/market/ServiciosCliente";

    public java.lang.String getServiciosClientePortAddress() {
        return ServiciosClientePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServiciosClientePortWSDDServiceName = "ServiciosClientePort";

    public java.lang.String getServiciosClientePortWSDDServiceName() {
        return ServiciosClientePortWSDDServiceName;
    }

    public void setServiciosClientePortWSDDServiceName(java.lang.String name) {
        ServiciosClientePortWSDDServiceName = name;
    }

    public edu.unipiloto.soa.stub.ServiciosCliente getServiciosClientePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServiciosClientePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServiciosClientePort(endpoint);
    }

    public edu.unipiloto.soa.stub.ServiciosCliente getServiciosClientePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.unipiloto.soa.stub.ServiciosClienteBindingStub _stub = new edu.unipiloto.soa.stub.ServiciosClienteBindingStub(portAddress, this);
            _stub.setPortName(getServiciosClientePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServiciosClientePortEndpointAddress(java.lang.String address) {
        ServiciosClientePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.unipiloto.soa.stub.ServiciosCliente.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.unipiloto.soa.stub.ServiciosClienteBindingStub _stub = new edu.unipiloto.soa.stub.ServiciosClienteBindingStub(new java.net.URL(ServiciosClientePort_address), this);
                _stub.setPortName(getServiciosClientePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServiciosClientePort".equals(inputPortName)) {
            return getServiciosClientePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://modelo.soa.unipiloto.edu/", "ServiciosClienteService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://modelo.soa.unipiloto.edu/", "ServiciosClientePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServiciosClientePort".equals(portName)) {
            setServiciosClientePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
