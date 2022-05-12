package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Principal extends JFrame {

	private JPanel contentPane;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Hotel PREMIER");

		generarVentana();

	}

	public void generarVentana() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JButton btnGestionarFactura = new JButton("Gestionar Factura");
		btnGestionarFactura.setBackground(Color.WHITE);
		btnGestionarFactura.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarFactura.setBounds(362, 372, 250, 80);
		panelCentral.add(btnGestionarFactura);

		JButton btnGestionarPasajero = new JButton("Gestionar Pasajero");
		btnGestionarPasajero.setBackground(Color.WHITE);
		btnGestionarPasajero.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarPasajero.setBounds(362, 196, 250, 80);
		panelCentral.add(btnGestionarPasajero);

		JButton btnGestionarListado = new JButton("Gestionar Listado");
		btnGestionarListado.setBackground(Color.WHITE);
		btnGestionarListado.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarListado.setBounds(704, 196, 250, 80);
		panelCentral.add(btnGestionarListado);

		JButton btnGestionarHabitacion = new JButton("Gestionar Habitacion");
		btnGestionarHabitacion.setBackground(Color.WHITE);
		btnGestionarHabitacion.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnGestionarHabitacion.setBounds(704, 372, 250, 80);
		panelCentral.add(btnGestionarHabitacion);

		final GestionarPasajero gp = new GestionarPasajero();

		btnGestionarPasajero.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gp.setVisible(true);
				dispose();
			}
		});

		btnGestionarListado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});

		btnGestionarHabitacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final GestionarHabitacion ventanaGH = new GestionarHabitacion();
				 ventanaGH.setVisible(true);
				 dispose();
			}
		});

		btnGestionarFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final GestionarFactura ventanaGF = new GestionarFactura();
				ventanaGF.setVisible(true);
				dispose();
				
			}
		});

	}

}
