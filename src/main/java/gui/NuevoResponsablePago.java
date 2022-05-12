package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.PasajeroDTO;
import gestor.GestorResponsablePago;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class NuevoResponsablePago extends JFrame {


	private JPanel contentPane;
	private JTextField textCUIT;

	GestorResponsablePago gestorResponsable = new GestorResponsablePago();
	
	public NuevoResponsablePago() {
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 150, 1280, 720);
	setResizable(false);
	setTitle("Nuevo Responsable de Pago");

	
	JPanel panelCentral = new JPanel();
	panelCentral.setBackground(new Color(102, 204, 255));
	contentPane.add(panelCentral, BorderLayout.CENTER);
	panelCentral.setLayout(null);
;

	JButton btnSiguiente = new JButton("Siguiente");
	btnSiguiente.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnSiguiente.setBackground(Color.WHITE);
	btnSiguiente.setBounds(658, 383, 150, 30);
	panelCentral.add(btnSiguiente);
	
	textCUIT = new JTextField();
	textCUIT.setFont(new Font("Dialog", Font.PLAIN, 15));
	textCUIT.setBounds(529, 258, 200, 30);
	panelCentral.add(textCUIT);
	textCUIT.setColumns(10);
	
	JLabel lblCuit = new JLabel("CUIT");
	lblCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblCuit.setBounds(432, 266, 46, 14);
	panelCentral.add(lblCuit);
	
	JButton btnVolver = new JButton("Volver");
	btnVolver.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnVolver.setBackground(Color.WHITE);
	btnVolver.setBounds(398, 383, 150, 30);
	panelCentral.add(btnVolver);
	
	

	btnSiguiente.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			

			if (textCUIT.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor, completar el CUIT");

			}

			else {

				try {
					if (gestorResponsable.validarCuit(textCUIT.getText().toString())) {
						try {
							if (esPersona(textCUIT.getText())) {
								ResponsablePagoPersona ventanaP = new ResponsablePagoPersona(textCUIT.getText().toString());
								ventanaP.setVisible(true);
								dispose();
							} else {
								ResponsablePagoEmpresa ventanaE = new ResponsablePagoEmpresa();
								ventanaE.setVisible(true);
								dispose();

							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(new JPanel(), e1.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
							// TODO Auto-generated catch block
							// e1.printStackTrace();
							throw e1;
						}
					}

				} catch (Exception e2) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JPanel(), e2.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		}
	});
}
	
	public boolean esPersona(String cuit) {

		String codigo = cuit.substring(0, 2);
		Integer cod = Integer.parseInt(codigo);

		if (cod == 30 || cod == 33 || cod == 34)
			return false;
		else
			return true;
	}
	
}
