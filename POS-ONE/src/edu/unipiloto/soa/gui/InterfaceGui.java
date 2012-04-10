package edu.unipiloto.soa.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class InterfaceGui extends JFrame implements ActionListener {

	public InterfaceGui(){
		super("WS cliente");
		setLayout(null);
		
		setSize(200,200);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
	}

}
