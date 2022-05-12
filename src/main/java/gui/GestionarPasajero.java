package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class GestionarPasajero extends JFrame {

	private JPanel contentPane;

	public GestionarPasajero() {

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
		ImageIcon iconoP= new ImageIcon("Images/usua.jpg");
		ImageIcon iconoPersona = new ImageIcon(iconoP.getImage().getScaledInstance(btnUsuario.getWidth(),btnUsuario.getHeight(),Image.SCALE_SMOOTH));
		btnUsuario.setIcon(iconoPersona);
		panelCentral.add(btnUsuario);	
				
		
		JButton btnDarDeAlta = new JButton("Dar de alta pasajero");
		btnDarDeAlta.setBackground(Color.WHITE);
		btnDarDeAlta.setBounds(503, 222, 250, 80);
		btnDarDeAlta.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnDarDeAlta);

		JButton btnModificar = new JButton("Modificar Pasajero");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(503, 326, 250, 80);
		btnModificar.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnModificar);

		JButton btnDarDeBaja = new JButton("Dar de baja pasajero");
		btnDarDeBaja.setBackground(Color.WHITE);
		btnDarDeBaja.setBounds(503, 436, 250, 80);
		btnDarDeBaja.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnDarDeBaja);
		
		JLabel lblHotelPremier = new JLabel("");
		lblHotelPremier.setBounds(28, 11,130, 120);
		ImageIcon iconoH= new ImageIcon("Images/hotel.png");
		ImageIcon iconoHotel = new ImageIcon(iconoH.getImage().getScaledInstance(btnUsuario.getWidth(),btnUsuario.getHeight(),Image.SCALE_SMOOTH));
		lblHotelPremier.setIcon(iconoHotel);
		
		panelCentral.add(lblHotelPremier);
		

		btnDarDeAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final DarDeAltaPasajero ventanaDarDeAlta = new DarDeAltaPasajero();
				ventanaDarDeAlta.setVisible(true);
				dispose();
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final ModificarPasajero ventanaModificarPasajero = new ModificarPasajero();
				ventanaModificarPasajero.setVisible(true);
				dispose();
			}
		});

		btnDarDeBaja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final EliminarPasajero ventanaEliminarPasajero = new EliminarPasajero();
				ventanaEliminarPasajero.setVisible(true);
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
