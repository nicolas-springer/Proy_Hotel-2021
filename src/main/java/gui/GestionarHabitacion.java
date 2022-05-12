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

public class GestionarHabitacion extends JFrame {

	private JPanel contentPane;


	public GestionarHabitacion() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Gestionar Habitacion");

		
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
				
		
		JButton btnReservar = new JButton("Reservar Habitacion");
		btnReservar.setBackground(Color.WHITE);
		btnReservar.setBounds(474, 216, 290, 80);
		btnReservar.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnReservar);

		JButton btnOcupar = new JButton("Ocupar Habitacion");
		btnOcupar.setBackground(Color.WHITE);
		btnOcupar.setBounds(474, 339, 290, 80);
		btnOcupar.setFont(new Font("Dialog", Font.PLAIN, 20));
		panelCentral.add(btnOcupar);
		
		JLabel lblHotelPremier = new JLabel("");
		lblHotelPremier.setBounds(28, 11,130, 120);
		ImageIcon iconoH= new ImageIcon("Images/hotel.png");
		ImageIcon iconoHotel = new ImageIcon(iconoH.getImage().getScaledInstance(btnUsuario.getWidth(),btnUsuario.getHeight(),Image.SCALE_SMOOTH));
		lblHotelPremier.setIcon(iconoHotel);
		
		panelCentral.add(lblHotelPremier);
	
		JButton btnCancelarReserva = new JButton("Cancelar Reserva");
		btnCancelarReserva.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnCancelarReserva.setBackground(Color.WHITE);
		btnCancelarReserva.setBounds(474, 460, 290, 80);
		panelCentral.add(btnCancelarReserva);

		btnReservar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnCancelarReserva.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnOcupar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final MostrarEstado ventanaMostrar = new MostrarEstado();
				ventanaMostrar.setVisible(true);
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
