/**
 * ServiciosCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.unipiloto.soa.stub;

public interface ServiciosCliente extends java.rmi.Remote {
    public boolean comprar(double costo) throws java.rmi.RemoteException;
    public boolean crearCliente(java.lang.String nombre, java.lang.String direccion, java.lang.String telefono, java.lang.String cedula, java.lang.String puntos, java.lang.String ID_Cuenta, java.lang.String estado, java.lang.String saldo) throws java.rmi.RemoteException;
    public boolean redimirPuntos(java.lang.String numeroPremio) throws java.rmi.RemoteException;
}
