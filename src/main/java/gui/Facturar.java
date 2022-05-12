package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Estadia;
import dominio.Pasajero;
import dominio.ResponsablePago;
import gestor.GestorEstadia;
import gestor.GestorFactura;
import gestor.GestorResponsablePago;

import javax.swing.JCheckBox;
import javax.swing.JComponent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Facturar extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private JTextField textNumero;
	private JTextField textCuit;
	private JTextField textHora;
	private JTextField textResponsable;

	List<ResponsablePago> responsableDePago = new ArrayList<ResponsablePago>();
	GestorResponsablePago gestorResponsable = new GestorResponsablePago();
	GestorFactura gestorFactura = new GestorFactura();
	
	GestorEstadia gEstadia = new GestorEstadia();
	String dni;
	List<Pasajero> listaDePasajeros = new ArrayList<Pasajero>();
	ResponsablePago responsable = new ResponsablePago();
	Estadia estadia = new Estadia();

	public Facturar(Estadia est, ResponsablePago res) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Facturar");
		setResizable(false);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		panelCentral.setBackground(new Color(102, 204, 255));

		// INICIALIZAR COMPONENTS

		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAtras.setBounds(114, 581, 150, 30);
		btnAtras.setBackground(new Color(255, 255, 255));
		panelCentral.add(btnAtras);

		JButton btnBuscar = new JButton("Buscar estadias");
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnBuscar.setBounds(1014, 72, 150, 30);
		btnBuscar.setBackground(new Color(255, 255, 255));
		panelCentral.add(btnBuscar);

		JButton btnGastos = new JButton("Seleccionar Gastos");
		btnGastos.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnGastos.setBackground(Color.WHITE);
		btnGastos.setBounds(964, 581, 200, 30);
		panelCentral.add(btnGastos);

		JButton btnVerificarCuit = new JButton("Verificar CUIT");
		btnVerificarCuit.setEnabled(false);
		btnVerificarCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnVerificarCuit.setBackground(Color.WHITE);
		btnVerificarCuit.setBounds(596, 155, 150, 30);
		panelCentral.add(btnVerificarCuit);

		JLabel lblTitulo = new JLabel("Seleccionar Responsable");
		lblTitulo.setToolTipText("");
		lblTitulo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblTitulo.setBounds(114, 11, 272, 30);
		panelCentral.add(lblTitulo);

		JLabel lblNumero = new JLabel("Numero de Habitacion");
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumero.setBounds(187, 72, 150, 30);
		panelCentral.add(lblNumero);

		JLabel lblHora = new JLabel("Hora de Salida");
		lblHora.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblHora.setBounds(596, 69, 138, 30);
		panelCentral.add(lblHora);

		JLabel lblResponsableDePago = new JLabel("Responsable de pago:");
		lblResponsableDePago.setToolTipText("");
		lblResponsableDePago.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblResponsableDePago.setBounds(114, 506, 167, 30);
		panelCentral.add(lblResponsableDePago);

		JCheckBox chckbxCuit = new JCheckBox("CUIT de tercero");
		chckbxCuit.setBackground(new Color(102, 204, 255));
		chckbxCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxCuit.setForeground(new Color(0, 0, 0));
		chckbxCuit.setBounds(187, 159, 150, 23);
		panelCentral.add(chckbxCuit);

		textNumero = new JTextField();
		textNumero.setBounds(350, 79, 150, 20);
		panelCentral.add(textNumero);
		textNumero.setColumns(10);
		textNumero.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

		textCuit = new JTextField();
		textCuit.setColumns(10);
		textCuit.setBounds(350, 160, 150, 20);
		panelCentral.add(textCuit);
		textCuit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

		textHora = new JTextField();
		textHora.setColumns(10);
		textHora.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		textHora.setBounds(765, 76, 150, 20);
		panelCentral.add(textHora);

		textResponsable = new JTextField();
		textResponsable.setColumns(10);
		textResponsable.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		textResponsable.setBounds(291, 514, 272, 20);
		panelCentral.add(textResponsable);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 219, 1050, 259);
		scrollPane.setBackground(new Color(255, 255, 255));
		panelCentral.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Edad", "DNI" }));

		scrollPane.setViewportView(table);

		chckbxCuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (chckbxCuit.isSelected()) {
					btnVerificarCuit.setEnabled(true);
					table.setEnabled(false);}

				else {
					btnVerificarCuit.setEnabled(false);
					table.setEnabled(true);	}

			}});
		

		if (!est.getOcupaciones().isEmpty()) {
			listaDePasajeros = gEstadia.recuperarPasajeros(est);
			textNumero.setText(est.getHabitacion().getNumero().toString());
		}

		ingresarATabla(listaDePasajeros, table);

		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (!chckbxCuit.isSelected()) {
					int seleccionar = table.rowAtPoint(e.getPoint());
					if (Integer.parseInt(table.getValueAt(seleccionar, 1).toString()) >= 18) {
					textResponsable.setText(table.getValueAt(seleccionar, 0).toString());
					dni = table.getValueAt(seleccionar, 2).toString();
					}
					else 
						JOptionPane.showMessageDialog(null, "La persona no es mayor a 18 años");
						
					
				
				}
			}
		});

		btnGastos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				List<List<Object>> listas = new ArrayList<>();
				listas = gestorFactura.validarEmpty(textNumero, textHora, lblHora, lblNumero);

				List<Object> listaTextVacios = new ArrayList<Object>();
				listaTextVacios = listas.get(0);
				List<Object> listaTextNoVacios = new ArrayList<Object>();
				listaTextNoVacios = listas.get(1);
				List<Object> listaLabelVacios = new ArrayList<Object>();
				listaLabelVacios = listas.get(2);
				List<Object> listaLabelNoVacios = new ArrayList<Object>();
				listaLabelNoVacios = listas.get(3);

				for (Object text : listaTextVacios)
					((JComponent) text).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
				for (Object text : listaTextNoVacios)
					((JComponent) text).setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
				for (Object label : listaLabelVacios)
					((Component) label).setForeground(Color.RED);
				for (Object label : listaLabelNoVacios)
					((Component) label).setForeground(Color.BLACK);

				if (!listaTextVacios.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Existen campos sin completar");
					
				}
				else {
					try {
						if (est.getOcupaciones().size()==0)
							JOptionPane.showMessageDialog(null, "Buscar la estadia");
						
						else {	
							if (!chckbxCuit.isSelected()) {
								responsable = gestorResponsable.crearResponsable(listaDePasajeros, dni);
								Gastos ventanaGastos = new Gastos(est, responsable,false);
								ventanaGastos.setVisible(true);
								dispose();
				}
				else {
					Gastos ventanaGastos = new Gastos(est, responsableDePago.get(0),true);
					ventanaGastos.setVisible(true);
					dispose();
				}}
					}catch (Exception e1) {
					JOptionPane.showMessageDialog(new JPanel(), e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					throw e1;
				}
					}
				
				
				

			}
		});
		
		
		

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				SeleccionarEstadias ventanaSE = new SeleccionarEstadias(textNumero.getText());
				ventanaSE.setVisible(true);
				dispose();

			}
		});

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				GestionarFactura vGF = new GestionarFactura();
				vGF.setVisible(true);
				dispose();

			}
		});

		btnVerificarCuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (gestorResponsable.validarCuit(textCuit.getText())) {
					responsableDePago = gestorResponsable.verificar(textCuit.getText());
					if (responsableDePago.size() == 0) {
						int seleccion = JOptionPane.showOptionDialog(new JPanel(),
								"No existe un responsable de pago con ese CUIT. Desea crear uno?", "Confirmacion",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																										// por defecto.
								new Object[] { "SI", "NO" }, // null para YES, NO y CANCEL
								"SI");

						if (seleccion == 0) {
							final NuevoResponsablePago ventanaNR = new NuevoResponsablePago();
							ventanaNR.setVisible(true);
							dispose();
						}
					} else {
						if (esPersona(textCuit.getText()))
							textResponsable.setText(responsableDePago.get(0).getPersona().getNombre() + " "
									+ responsableDePago.get(0).getPersona().getApellido());
						else
							textResponsable.setText(responsableDePago.get(0).getRazonSocial());
					}

				} else
					JOptionPane.showMessageDialog(new JPanel(), "El cuit no esta bien escrito", "Error",
							JOptionPane.ERROR_MESSAGE);
			}

		});

	}

	public void ingresarATabla(List<Pasajero> lista, JTable table) {

		ArrayList<Object[]> datos = new ArrayList<>();

		for (int j = 0; j < lista.size(); j++) {
			Object[] filas = new Object[3];

			filas[0] = lista.get(j).getPersona().getApellido();
			filas[1] = lista.get(j).getPersona().getEdad();
			filas[2] = lista.get(j).getPersona().getNumeroDocumento();
			datos.add(filas);
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < datos.size(); i++) {
			dtm.addRow(datos.get(i));
		}
	}

	public boolean esPersona(String cuit) {

		String codigo = cuit.substring(0, 2);
		Integer cod = Integer.parseInt(codigo);

		if (cod == 30 || cod == 33 || cod == 34)
			return false;
		else
			return true;
	}
	
	public JPanel crearPanel () {
		
		JPanel panelC = new JPanel();
		contentPane.add(panelC, BorderLayout.CENTER);
		panelC.setLayout(null);
		panelC.setBackground(new Color(102, 204, 255));

		// INICIALIZAR COMPONENTS

		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAtras.setBounds(114, 581, 150, 30);
		btnAtras.setBackground(new Color(255, 255, 255));
		panelC.add(btnAtras);
		
		return panelC;

		
	}
}