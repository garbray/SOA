package edu.unipiloto.soa.xml;

public class Cuenta {
	
	private String id;
	private String estado;
	private String saldo;
	
	public double consultarSaldo( String cedula,String cuenta) {
		return 0;
	}

	
	public String getId() {
		return id;
	}
	public void setId(String numero) {
		this.id = numero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	
	

}
