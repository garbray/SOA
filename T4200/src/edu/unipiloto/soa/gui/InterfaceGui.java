package edu.unipiloto.soa.gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.unipiloto.soa.clientedii.WSClient;

public class InterfaceGui extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblSaldo,lblResultado;
	private JTextField txtCedula,txtResultado;
	private JButton btnConsultar;
	private WSClient cliente;
	
	public InterfaceGui(){
		super("Consultar Saldo");
		setLayout(null);
		
		lblSaldo = new JLabel("N. Cedula");
		txtCedula = new JTextField();
		txtResultado = new JTextField();
		lblResultado = new JLabel("saldo:");
		btnConsultar = new JButton("Consultar");
		cliente = new WSClient();
		
		btnConsultar.addActionListener(this);
		
		txtResultado.setEnabled(false);
		
		lblSaldo.setBounds(40, 20, 100, 25);
		txtCedula.setBounds(140, 20, 100, 25);
		lblResultado.setBounds(40, 50, 100, 25);
		txtResultado.setBounds(140, 50, 100, 25);
		btnConsultar.setBounds(140, 80, 100, 25);
		
		add(lblSaldo);
		add(txtCedula);
		add(btnConsultar);
		add(lblResultado);
		add(txtResultado);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 160);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new InterfaceGui();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar){
			System.out.println("siii");
			txtResultado.setText(""+cliente.consultarSaldo(txtCedula.getText()));
		}
		
	}
}
