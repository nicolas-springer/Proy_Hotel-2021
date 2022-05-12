package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dao.PaisDAO;
import dao.PaisDAO_Hibernate;
import dao.ProvinciaDAO;
import dao.ProvinciaDAO_Hibernate;
import dominio.Estadia;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;
import dominio.ResponsablePago;
import dto.EmpresaDTO;
import dto.PasajeroDTO;
import gestor.GestorDireccion;
import gestor.GestorLocalidad;
import gestor.GestorPais;
import gestor.GestorProvincia;
import gestor.GestorResponsablePago;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ResponsablePagoEmpresa extends JFrame {

	private JPanel contentPane;
	private JTextField textRazonSocial;
	private JTextField textCuit;
	private JTextField textEmail;
	private JTextField textTelefono;
	private JTextField textCalle;
	private JTextField textPiso;
	private JTextField textDep;
	private JTextField textNum;
	

	GestorPais gestorPais = new GestorPais();
	GestorProvincia gestorProvincia = new GestorProvincia();
	GestorLocalidad gestorLocalidad = new GestorLocalidad();
	GestorResponsablePago gestorResponsable = new GestorResponsablePago();
	GestorDireccion gestorDireccion = new GestorDireccion();
	
	
	public ResponsablePagoEmpresa() {

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(300, 150, 1280, 720);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(102, 204, 255));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new BorderLayout(0, 0));
	setTitle("Responsable de Pago EMPRESA");
	setResizable(false);

	JPanel panelCentral = new JPanel();
	contentPane.add(panelCentral, BorderLayout.CENTER);
	panelCentral.setLayout(null);
	panelCentral.setBackground(new Color(102, 204, 255));

	JButton btnConfirmar = new JButton("Confirmar");
	btnConfirmar.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnConfirmar.setBackground(Color.WHITE);
	btnConfirmar.setBounds(1049, 579, 150, 32);
	panelCentral.add(btnConfirmar);

	JButton btnVolver = new JButton("Volver");
	btnVolver.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnVolver.setBackground(Color.WHITE);
	btnVolver.setBounds(54, 579, 150, 32);
	panelCentral.add(btnVolver);
	
	JLabel lblRazonSocial = new JLabel("Razon social");
	lblRazonSocial.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblRazonSocial.setBounds(257, 174, 100, 20);
	panelCentral.add(lblRazonSocial);
	
	JLabel lblCuit = new JLabel("CUIT");
	lblCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblCuit.setBounds(654, 174, 100, 20);
	panelCentral.add(lblCuit);
	
	JLabel lblEmail = new JLabel("E-Mail");
	lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblEmail.setBounds(257, 236, 100, 20);
	panelCentral.add(lblEmail);
	
	JLabel lblTelefono = new JLabel("Telefono");
	lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblTelefono.setBounds(654, 236, 100, 20);
	panelCentral.add(lblTelefono);
	
	textRazonSocial = new JTextField();
	textRazonSocial.setFont(new Font("Dialog", Font.PLAIN, 15));
	textRazonSocial.setBounds(390, 174, 200, 20);
	panelCentral.add(textRazonSocial);
	textRazonSocial.setColumns(10);
	
	textCuit = new JTextField();
	textCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
	textCuit.setColumns(10);
	textCuit.setBounds(778, 174, 200, 20);
	panelCentral.add(textCuit);
	
	textEmail = new JTextField();
	textEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
	textEmail.setColumns(10);
	textEmail.setBounds(390, 236, 200, 20);
	panelCentral.add(textEmail);
	
	textTelefono = new JTextField();
	textTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
	textTelefono.setColumns(10);
	textTelefono.setBounds(778, 236, 200, 20);
	panelCentral.add(textTelefono);
	
	textCalle = new JTextField();
	textCalle.setFont(new Font("Dialog", Font.PLAIN, 15));
	textCalle.setColumns(10);
	textCalle.setBounds(778, 365, 200, 20);
	panelCentral.add(textCalle);

	textPiso = new JTextField();
	textPiso.setFont(new Font("Dialog", Font.PLAIN, 15));
	textPiso.setColumns(10);
	textPiso.setBounds(918, 411, 60, 20);
	panelCentral.add(textPiso);

	textDep = new JTextField();
	textDep.setFont(new Font("Dialog", Font.PLAIN, 15));
	textDep.setColumns(10);
	textDep.setBounds(811, 411, 60, 20);
	panelCentral.add(textDep);

	textNum = new JTextField();
	textNum.setFont(new Font("Dialog", Font.PLAIN, 15));
	textNum.setColumns(10);
	textNum.setBounds(696, 411, 60, 20);
	panelCentral.add(textNum);
	
	JLabel lblCalle = new JLabel("Calle");
	lblCalle.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblCalle.setBounds(654, 360, 80, 30);
	panelCentral.add(lblCalle);

	JLabel lblNum = new JLabel("Num");
	lblNum.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblNum.setBounds(654, 411, 80, 20);
	panelCentral.add(lblNum);

	JLabel lblDep = new JLabel("Dep");
	lblDep.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblDep.setBounds(774, 411, 61, 20);
	panelCentral.add(lblDep);

	JLabel lblPiso = new JLabel("Piso");
	lblPiso.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblPiso.setBounds(881, 411, 38, 20);
	panelCentral.add(lblPiso);


	
	JComboBox comboBoxPais = new JComboBox();
	comboBoxPais.setFont(new Font("Dialog", Font.PLAIN, 15));
	comboBoxPais.setBounds(390, 302, 200, 24);
	panelCentral.add(comboBoxPais);

	JComboBox comboBoxCiudad = new JComboBox();
	comboBoxCiudad.setFont(new Font("Dialog", Font.PLAIN, 15));
	comboBoxCiudad.setBounds(390, 363, 200, 24);
	panelCentral.add(comboBoxCiudad);

	JComboBox comboBoxProvincia = new JComboBox();
	comboBoxProvincia.setFont(new Font("Dialog", Font.PLAIN, 15));
	comboBoxProvincia.setBounds(778, 302, 200, 24);
	panelCentral.add(comboBoxProvincia);


	JLabel lblPais = new JLabel("Pais");
	lblPais.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblPais.setBounds(257, 304, 100, 20);
	panelCentral.add(lblPais);
	
	JLabel lblProvincia = new JLabel("Provincia");
	lblProvincia.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblProvincia.setBounds(654, 304, 100, 20);
	panelCentral.add(lblProvincia);
	
	JLabel lblCiudad = new JLabel("Ciudad");
	lblCiudad.setFont(new Font("Dialog", Font.PLAIN, 15));
	lblCiudad.setBounds(257, 365, 100, 20);
	panelCentral.add(lblCiudad);


	List<Pais> listaPaises = gestorPais.getPaises();
	List<Provincia> listaProvinciasArg = gestorProvincia.getProvincias(1);
	List<Localidad> listaLocalidadesArg = gestorLocalidad
			.getLocalidades(listaProvinciasArg.get(0).getNombre().toString());

	List<Provincia> listaProvinciasPy = gestorProvincia.getProvincias(2);
	List<Localidad> listaLocalidadesPy = gestorLocalidad
			.getLocalidades(listaProvinciasPy.get(0).getNombre().toString());

	for (Pais p : listaPaises) 
		comboBoxPais.addItem(p.getNombre().toString());
	
	
	
	for (Provincia p : listaProvinciasArg)
		comboBoxProvincia.addItem(p.getNombre().toString());

	for (Localidad l : listaLocalidadesArg)
		comboBoxCiudad.addItem(l.getNombre().toString());

	comboBoxPais.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {

			if (e.getStateChange() == ItemEvent.SELECTED) {
				comboBoxProvincia.removeAllItems();
				comboBoxCiudad.removeAllItems();

				if (comboBoxPais.getSelectedItem().toString().equals("Argentina")) {
					for (Provincia p : listaProvinciasArg)
						comboBoxProvincia.addItem(p.getNombre().toString());
					for (Localidad l : listaLocalidadesArg)
						comboBoxCiudad.addItem(l.getNombre().toString());
				} else {
					for (Provincia p : listaProvinciasPy)
						comboBoxProvincia.addItem(p.getNombre().toString());
					for (Localidad l : listaLocalidadesPy)
						comboBoxCiudad.addItem(l.getNombre().toString());
				}

			}

		}
	});

	comboBoxProvincia.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				comboBoxCiudad.removeAllItems();

				List<Localidad> localidadesSegunProvincia = gestorDireccion
						.obtenerLocalidades(comboBoxProvincia.getSelectedItem().toString());

				for (Localidad l : localidadesSegunProvincia)
					comboBoxCiudad.addItem(l.getNombre().toString());

			}

		}
	});

	
	
	btnConfirmar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {

			List<List<Object>> listas = new ArrayList<>();
			listas = gestorResponsable.validarEmpty(textRazonSocial,textTelefono, textEmail, textCalle, textNum, textCuit, lblCuit,
					lblRazonSocial, lblTelefono, lblEmail, lblCalle, lblNum);

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
					Boolean validarDatos = gestorResponsable.validarDatos(textTelefono, textEmail,textPiso);

					if (validarDatos) {
						EmpresaDTO empresa = new EmpresaDTO();

						empresa.setRazonSocial(textRazonSocial.getText().toString());
						empresa.setTelefono(textTelefono.getText().toString());
						empresa.setCorreoElectronico(textEmail.getText().toString());
						empresa.setPais(comboBoxPais.getSelectedItem().toString());
						empresa.setProvincia(comboBoxProvincia.getSelectedItem().toString());
						empresa.setLocalidad(90);
						empresa.setCalle(textCalle.getText().toString());
						empresa.setNumeroCalle(Integer.parseInt(textNum.getText().toString()));
						empresa.setCuit(textCuit.getText().toString());
						
						if (!textDep.getText().isEmpty())
							empresa.setDepartamento(Integer.parseInt(textDep.getText().toString()));
						if (!textPiso.getText().isEmpty())
							empresa.setPiso(Integer.parseInt(textPiso.getText().toString()));

						try {
							ResponsablePago responsable = new ResponsablePago();
							responsable = gestorResponsable.darDeAltaResponsable(empresa);
							JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
							final Principal ventanaP = new Principal();
							ventanaP.setVisible(true);
							dispose();
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
}
