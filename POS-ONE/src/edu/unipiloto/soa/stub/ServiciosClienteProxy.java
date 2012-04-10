package edu.unipiloto.soa.stub;

public class ServiciosClienteProxy implements edu.unipiloto.soa.stub.ServiciosCliente {
  private String _endpoint = null;
  private edu.unipiloto.soa.stub.ServiciosCliente serviciosCliente = null;
  
  public ServiciosClienteProxy() {
    _initServiciosClienteProxy();
  }
  
  public ServiciosClienteProxy(String endpoint) {
    _endpoint = endpoint;
    _initServiciosClienteProxy();
  }
  
  private void _initServiciosClienteProxy() {
    try {
      serviciosCliente = (new edu.unipiloto.soa.stub.ServiciosClienteServiceLocator()).getServiciosClientePort();
      if (serviciosCliente != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)serviciosCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)serviciosCliente)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (serviciosCliente != null)
      ((javax.xml.rpc.Stub)serviciosCliente)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public edu.unipiloto.soa.stub.ServiciosCliente getServiciosCliente() {
    if (serviciosCliente == null)
      _initServiciosClienteProxy();
    return serviciosCliente;
  }
  
  public boolean comprar(double costo) throws java.rmi.RemoteException{
    if (serviciosCliente == null)
      _initServiciosClienteProxy();
    return serviciosCliente.comprar(costo);
  }
  
  public boolean crearCliente(java.lang.String nombre, java.lang.String direccion, java.lang.String telefono, java.lang.String cedula, java.lang.String puntos, java.lang.String ID_Cuenta, java.lang.String estado, java.lang.String saldo) throws java.rmi.RemoteException{
    if (serviciosCliente == null)
      _initServiciosClienteProxy();
    return serviciosCliente.crearCliente(nombre, direccion, telefono, cedula, puntos, ID_Cuenta, estado, saldo);
  }
  
  public boolean redimirPuntos(java.lang.String numeroPremio) throws java.rmi.RemoteException{
    if (serviciosCliente == null)
      _initServiciosClienteProxy();
    return serviciosCliente.redimirPuntos(numeroPremio);
  }
  
  
}