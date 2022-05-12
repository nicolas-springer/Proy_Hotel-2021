package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.Estadia;
import dominio.ResponsablePago;

public class GestionarResponsablePago extends JFrame {

	private JPanel contentPane;

	public GestionarResponsablePago() {
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 150, 1280, 720);
	setResizable(false);
	setTitle("");

	
	JPanel panelCentral = new JPanel();
	panelCentral.setBackground(new Color(102, 204, 255));
	contentPane.add(panelCentral, BorderLayout.CENTER);
	panelCentral.setLayout(null);
	ImageIcon iconoP= new ImageIcon("Images/usua.jpg");
			
	
	JButton btnNuevo = new JButton("Nuevo Responsable de Pago");
	btnNuevo.setBackground(Color.WHITE);
	btnNuevo.setBounds(500, 220, 320, 80);
	btnNuevo.setFont(new Font("Dialog", Font.PLAIN, 20));
	panelCentral.add(btnNuevo);

	JButton btnResponsable = new JButton("Modificar Responsable de Pago");
	btnResponsable.setBackground(Color.WHITE);
	btnResponsable.setBounds(500, 386, 320, 80);
	btnResponsable.setFont(new Font("Dialog", Font.PLAIN, 20));
	panelCentral.add(btnResponsable);


	
	btnNuevo.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			NuevoResponsablePago ventanaNRP = new NuevoResponsablePago();
			ventanaNRP.setVisible(true);
			dispose();
			
		}
	});

	btnResponsable.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	});

	
	
	}
}
