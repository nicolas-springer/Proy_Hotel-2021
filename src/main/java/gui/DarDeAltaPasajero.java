package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dominio.Localidad;
import dominio.Pais;
import dominio.Provincia;
import dto.PasajeroDTO;
import gestor.GestorDireccion;
import gestor.GestorLocalidad;
import gestor.GestorPais;
import gestor.GestorPasajero;
import gestor.GestorProvincia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.Component;

@SuppressWarnings("serial")
public class DarDeAltaPasajero extends JFrame {

	private JPanel contentPane;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTextField textCalle;
	private JTextField textNombre;
	private JTextField textNumeroDocumento;
	private JTextField textOcupacion;
	private JTextField textEmail;
	private JTextField textCuit;
	private JTextField textPiso;
	private JTextField textDep;
	private JTextField textNum;

	GestorPasajero gestorPasajero = new GestorPasajero();
	GestorPais gestorPais = new GestorPais();
	GestorProvincia gestorProvincia = new GestorProvincia();
	GestorLocalidad gestorLocalidad = new GestorLocalidad();
	GestorDireccion gestorDireccion = new GestorDireccion();

	Boolean validarDatos = false, cuitActivo = false;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })

	public DarDeAltaPasajero() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(new Color(102, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Dar de alta pasajero");

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		// INICIALIZAR COMPONENTS

		textApellido = new JTextField();
		textApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		textApellido.setBounds(340, 50, 200, 20);
		panelCentral.add(textApellido);
		textApellido.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
		textTelefono.setColumns(10);
		textTelefono.setBounds(340, 260, 200, 20);
		panelCentral.add(textTelefono);

		textCalle = new JTextField();
		textCalle.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCalle.setColumns(10);
		textCalle.setBounds(970, 470, 200, 20);
		panelCentral.add(textCalle);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		textNombre.setColumns(10);
		textNombre.setBounds(970, 50, 200, 20);
		panelCentral.add(textNombre);

		textNumeroDocumento = new JTextField();
		textNumeroDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		textNumeroDocumento.setColumns(10);
		textNumeroDocumento.setBounds(970, 120, 200, 20);
		panelCentral.add(textNumeroDocumento);

		textOcupacion = new JTextField();
		textOcupacion.setFont(new Font("Dialog", Font.PLAIN, 15));
		textOcupacion.setColumns(10);
		textOcupacion.setBounds(970, 190, 200, 20);
		panelCentral.add(textOcupacion);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		textEmail.setColumns(10);
		textEmail.setBounds(970, 260, 200, 20);
		panelCentral.add(textEmail);

		textCuit = new JTextField();
		textCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
		textCuit.setEnabled(false);
		textCuit.setColumns(10);
		textCuit.setBounds(970, 330, 200, 20);
		panelCentral.add(textCuit);

		textPiso = new JTextField();
		textPiso.setFont(new Font("Dialog", Font.PLAIN, 15));
		textPiso.setColumns(10);
		textPiso.setBounds(1095, 542, 73, 20);
		panelCentral.add(textPiso);

		textDep = new JTextField();
		textDep.setFont(new Font("Dialog", Font.PLAIN, 15));
		textDep.setColumns(10);
		textDep.setBounds(928, 542, 73, 20);
		panelCentral.add(textDep);

		textNum = new JTextField();
		textNum.setFont(new Font("Dialog", Font.PLAIN, 15));
		textNum.setColumns(10);
		textNum.setBounds(756, 542, 73, 20);
		panelCentral.add(textNum);

		JLabel lblAux = new JLabel("");
		lblAux.setVisible(false);

		JLabel lblCuit = new JLabel("CUIT");
		lblCuit.setForeground(Color.GRAY);
		lblCuit.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCuit.setBounds(710, 330, 80, 30);
		panelCentral.add(lblCuit);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblApellido.setBounds(80, 50, 80, 30);
		panelCentral.add(lblApellido);

		JLabel lblTipoDeDocumento = new JLabel("Tipo de Documento");
		lblTipoDeDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTipoDeDocumento.setBounds(80, 120, 150, 30);
		panelCentral.add(lblTipoDeDocumento);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(80, 190, 150, 30);
		panelCentral.add(lblFechaDeNacimiento);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTelefono.setBounds(80, 260, 80, 30);
		panelCentral.add(lblTelefono);

		JLabel lblPosicionFrenteAl = new JLabel("Posicion frente al IVA");
		lblPosicionFrenteAl.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPosicionFrenteAl.setBounds(80, 330, 150, 30);
		panelCentral.add(lblPosicionFrenteAl);

		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPais.setBounds(80, 400, 80, 30);
		panelCentral.add(lblPais);

		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCiudad.setBounds(80, 470, 80, 30);
		panelCentral.add(lblCiudad);

		JLabel lblNumDocumento = new JLabel("Numero de Documento");
		lblNumDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumDocumento.setBounds(710, 120, 200, 30);
		panelCentral.add(lblNumDocumento);

		JLabel lblOcupacion = new JLabel("Ocupacion");
		lblOcupacion.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblOcupacion.setBounds(710, 190, 140, 30);
		panelCentral.add(lblOcupacion);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEmail.setBounds(710, 260, 80, 30);
		panelCentral.add(lblEmail);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombre.setBounds(710, 50, 80, 30);
		panelCentral.add(lblNombre);

		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblProvincia.setBounds(710, 400, 80, 30);
		panelCentral.add(lblProvincia);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblCalle.setBounds(710, 470, 80, 30);
		panelCentral.add(lblCalle);

		JLabel lblNum = new JLabel("Num");
		lblNum.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNum.setBounds(710, 540, 80, 20);
		panelCentral.add(lblNum);

		JLabel lblDep = new JLabel("Dep");
		lblDep.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDep.setBounds(883, 540, 61, 20);
		panelCentral.add(lblDep);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPiso.setBounds(1047, 540, 38, 20);
		panelCentral.add(lblPiso);

		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNacionalidad.setBounds(80, 540, 140, 30);
		panelCentral.add(lblNacionalidad);

		JComboBox comboBoxDocumento = new JComboBox();
		comboBoxDocumento.setForeground(Color.BLACK);
		comboBoxDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxDocumento.setModel(new DefaultComboBoxModel(new String[] { "DNI", "LE", "LC", "PASAPORTE", "OTRO" }));
		comboBoxDocumento.setBackground(new Color(255, 255, 255));
		comboBoxDocumento.setBounds(390, 120, 150, 24);
		panelCentral.add(comboBoxDocumento);

		JComboBox comboBoxAño = new JComboBox();
		comboBoxAño.setBounds(465, 188, 75, 24);
		panelCentral.add(comboBoxAño);

		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(340, 188, 45, 24);
		panelCentral.add(comboBoxDia);

		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(400, 188, 45, 24);
		panelCentral.add(comboBoxMes);
		

		JComboBox comboBoxNacionalidad = new JComboBox();
		comboBoxNacionalidad.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxNacionalidad.setBounds(340, 546, 200, 24);
		panelCentral.add(comboBoxNacionalidad);

		JComboBox comboBoxPais = new JComboBox();
		comboBoxPais.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxPais.setBounds(340, 405, 200, 24);
		panelCentral.add(comboBoxPais);

		JComboBox comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxCiudad.setBounds(340, 468, 200, 24);
		panelCentral.add(comboBoxCiudad);

		JComboBox comboBoxPosicion = new JComboBox();
		comboBoxPosicion.setBackground(Color.WHITE);
		comboBoxPosicion.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxPosicion.setModel(new DefaultComboBoxModel(new String[] { "Consumidor final", "IVA Sujeto Exento",
				"Responsable Monotributo", "IVA Responsable Inscripto" }));
		comboBoxPosicion.setBounds(340, 330, 200, 24);
		panelCentral.add(comboBoxPosicion);

		JComboBox comboBoxProvincia = new JComboBox();

		comboBoxProvincia.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxProvincia.setBounds(970, 400, 194, 24);
		panelCentral.add(comboBoxProvincia);

		for (int a = 1920; a < 2022; a++)
			comboBoxAño.addItem(a);
		for (int d = 1; d < 32; d++)
			comboBoxDia.addItem(d);
		for (int m = 1; m < 13; m++)
			comboBoxMes.addItem(m);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAceptar.setBounds(1070, 603, 100, 30);
		panelCentral.add(btnAceptar);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAtras.setBounds(80, 603, 100, 30);
		panelCentral.add(btnAtras);

		JLabel lblExampleEmail = new JLabel("example@xxx.xxx");
		lblExampleEmail.setEnabled(false);
		lblExampleEmail.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblExampleEmail.setBounds(1009, 286, 138, 20);
		panelCentral.add(lblExampleEmail);

		JLabel lblExampleCuit = new JLabel("xx-xxxxxxxx-x");
		lblExampleCuit.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblExampleCuit.setEnabled(false);
		lblExampleCuit.setBounds(1021, 350, 138, 20);
		panelCentral.add(lblExampleCuit);

		// INICIALIZAR LISTAS DE PAISES PROVINCIAS Y CIUDADES

		List<Pais> listaPaises =gestorPais.getPaises();
		List<Provincia> listaProvinciasArg = gestorProvincia.getProvincias(1);
		List<Localidad> listaLocalidadesArg = gestorLocalidad
				.getLocalidades(listaProvinciasArg.get(0).getNombre().toString());

		List<Provincia> listaProvinciasPy = gestorProvincia.getProvincias(2);
		List<Localidad> listaLocalidadesPy = gestorLocalidad
				.getLocalidades(listaProvinciasPy.get(0).getNombre().toString());

		for (Pais p : listaPaises) {
			comboBoxPais.addItem(p.getNombre().toString());
			comboBoxNacionalidad.addItem(p.getNombre().toString());
		}
		
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

		comboBoxMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int mesSeleccionado = (int) comboBoxDia.getSelectedItem();
				comboBoxDia.removeAllItems();
				if ((Integer.parseInt(comboBoxMes.getSelectedItem().toString()) == 4)
						|| (Integer.parseInt(comboBoxMes.getSelectedItem().toString()) == 6)
						|| (Integer.parseInt(comboBoxMes.getSelectedItem().toString()) == 9)
						|| (Integer.parseInt(comboBoxMes.getSelectedItem().toString()) == 11))
					for (int d = 1; d < 31; d++)
						comboBoxDia.addItem(d);

				else if (Integer.parseInt(comboBoxMes.getSelectedItem().toString()) == 2)
					for (int d = 1; d < 29; d++)
						comboBoxDia.addItem(d);

				else
					for (int d = 1; d < 32; d++)
						comboBoxDia.addItem(d);

				comboBoxDia.setSelectedItem(mesSeleccionado);
			}

		});

		comboBoxPosicion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBoxPosicion.getSelectedItem().toString() == "IVA Responsable Inscripto") {
					textCuit.setEnabled(true);
					lblCuit.setForeground(Color.BLACK);
					cuitActivo = true;
				} else {
					textCuit.setEnabled(false);
					lblCuit.setForeground(Color.GRAY);
					cuitActivo = false;
				}
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final GestionarPasajero ventanaGestionar = new GestionarPasajero();
				ventanaGestionar.setVisible(true);
				dispose();
			}
		});

		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				List<List<Object>> listas = new ArrayList<>();
				listas = gestorPasajero.validarEmpty(textApellido, textNombre, textNumeroDocumento, textOcupacion,
						textTelefono, textEmail, textCalle, textNum, textCuit, lblCuit, lblApellido,
						lblNombre, lblNumDocumento, lblOcupacion, lblTelefono, lblEmail, lblNacionalidad, lblCalle,
						lblNum, cuitActivo);

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
						LocalDate nacimiento;
						nacimiento = LocalDate.of(Integer.parseInt(comboBoxAño.getSelectedItem().toString()),
								Integer.parseInt(comboBoxMes.getSelectedItem().toString()),
								Integer.parseInt(comboBoxDia.getSelectedItem().toString()));

						Boolean validarDatos = false;
						if (comboBoxPosicion.getSelectedItem().toString() == "IVA Responsable Inscripto")
							validarDatos = gestorPasajero.validarDatos(textNumeroDocumento, textTelefono, textEmail,
									textPiso, textDep, textNum, nacimiento,
									gestorPasajero.validarCuit(textCuit.getText().toString()));
						else
							validarDatos = gestorPasajero.validarDatos(textNumeroDocumento, textTelefono, textEmail,
									textPiso, textDep, textNum, nacimiento, true);

						if (validarDatos) {
							System.out.println(validarDatos);
							PasajeroDTO pasajero = new PasajeroDTO();

							pasajero.setApellido(textApellido.getText().toString());
							pasajero.setNombre(textNombre.getText().toString());
							pasajero.setTipoDocumento(comboBoxDocumento.getSelectedItem().toString());
							pasajero.setNumeroDocumento(Integer.parseInt(textNumeroDocumento.getText().toString()));
							pasajero.setAnioNacimiento(Integer.parseInt(comboBoxAño.getSelectedItem().toString()));
							pasajero.setDiaNacimiento(Integer.parseInt(comboBoxDia.getSelectedItem().toString()));
							pasajero.setMesNacimiento(Integer.parseInt(comboBoxMes.getSelectedItem().toString()));
							pasajero.setOcupacion(textOcupacion.getText().toString());
							pasajero.setTelefono(textTelefono.getText().toString());
							pasajero.setCorreoElectronico(textEmail.getText().toString());
							pasajero.setPosFrenteIVA(comboBoxPosicion.getSelectedItem().toString());
							pasajero.setPais(comboBoxPais.getSelectedItem().toString());
							pasajero.setProvincia(comboBoxProvincia.getSelectedItem().toString());
							pasajero.setLocalidad(90);
							pasajero.setCalle(textCalle.getText().toString());
							pasajero.setNumeroCalle(Integer.parseInt(textNum.getText().toString()));
							if (comboBoxPosicion.getSelectedItem().toString() == "IVA Responsable Inscripto"
									&& !textCuit.getText().isEmpty()) {
								pasajero.setCuit(textCuit.getText().toString());
							}
							if (!textDep.getText().isEmpty())
								pasajero.setDepartamento(Integer.parseInt(textDep.getText().toString()));
							if (!textPiso.getText().isEmpty())
								pasajero.setPiso(Integer.parseInt(textPiso.getText().toString()));

							Pais nacionalidad = new Pais() ;
							
							for (Pais p: listaPaises)
								if (p.getNombre().toString().equals(comboBoxNacionalidad.getSelectedItem().toString()))
									nacionalidad = p;
									
							
							try {
								gestorPasajero.darDeAltaPasajero(pasajero, nacionalidad);
								JOptionPane.showMessageDialog(null, "Datos cargados correctamente");
								final GestionarPasajero ventanaGestionar = new GestionarPasajero();
								ventanaGestionar.setVisible(true);
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
