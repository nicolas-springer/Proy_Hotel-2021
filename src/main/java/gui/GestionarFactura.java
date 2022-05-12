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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import dominio.Estadia;
import dominio.ResponsablePago;

public class GestionarFactura extends JFrame {

	private JPanel contentPane;

	
	public GestionarFactura() {

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


		JButton btnUsuario = new JButton("");
		btnUsuario.setBounds(1092, 11, 120, 110);
		btnUsuario.setBackground(new Color(102, 204, 255));
		ImageIcon iconoP= new ImageIcon("Images/usua.jpg");
		ImageIcon iconoPersona = new ImageIcon(iconoP.getImage().getScaledInstance(btnUsuario.getWidth(),btnUsuario.getHeight(),Image.SCALE_SMOOTH));
		btnUsuario.setIcon(iconoPersona);
		panelCentral.add(btnUsuario);	
				
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setBackground(Color.WHITE);
		btnFacturar.setBounds(500, 220, 320, 80);
		btnFacturar.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnFacturar);

		JButton btnResponsable = new JButton("Gestionar Responsable de Pago");
		btnResponsable.setBackground(Color.WHITE);
		btnResponsable.setBounds(500, 386, 320, 80);
		btnResponsable.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnResponsable);

		
		JLabel lblHotelPremier = new JLabel("");
		lblHotelPremier.setBounds(28, 11,130, 120);
		ImageIcon iconoH= new ImageIcon("Images/hotel.png");
		ImageIcon iconoHotel = new ImageIcon(iconoH.getImage().getScaledInstance(btnUsuario.getWidth(),btnUsuario.getHeight(),Image.SCALE_SMOOTH));
		lblHotelPremier.setIcon(iconoHotel);
		
		panelCentral.add(lblHotelPremier);
		
		
		btnFacturar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Estadia est = new Estadia();
				ResponsablePago responsable = new ResponsablePago();
				final Facturar ventanaFacturar = new Facturar(est,responsable);
			
				ventanaFacturar.setVisible(true);
				dispose();
			}
		});

		btnResponsable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GestionarResponsablePago ventanaGRP = new GestionarResponsablePago();
				ventanaGRP.setVisible(true);
				dispose();
				
			}
		});

		
		
		btnUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final Principal ventanaP = new Principal();
				ventanaP.setVisible(true);
				dispose();
			}
		});
	}
	}


