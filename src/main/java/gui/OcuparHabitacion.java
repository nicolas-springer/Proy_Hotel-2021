package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import dominio.Habitacion;
import dominio.Ocupacion;
import dominio.Pasajero;
import dominio.Persona;
import dto.BusquedaPasajeroDTO;
import gestor.GestorEstadia;
import gestor.GestorPasajero;
import javax.swing.JCheckBox;

public class OcuparHabitacion extends JFrame {


	private JPanel contentPane;
	private JTable table;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNroDocumento;

	GestorPasajero gestorPasajero = new GestorPasajero();
	BusquedaPasajeroDTO busquedaPasajeroDTO = new BusquedaPasajeroDTO();
	BusquedaPasajeroDTO busquedaPasajeroDTOseleccionado = new BusquedaPasajeroDTO();
	GestorEstadia gEstadia = new GestorEstadia();
	 
	
	Estadia nuevaEstadia;
	public OcuparHabitacion(List<Habitacion> habitaciones , List<List<LocalDate>> fechas, int num, Estadia e, Boolean crearEstadia) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Ocupar Habitacion");
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

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnBuscar.setBounds(1014, 232, 150, 30);
		btnBuscar.setBackground(new Color(255, 255, 255));
		panelCentral.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 288, 1050, 265);
		scrollPane.setBackground(new Color(255, 255, 255));
		panelCentral.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Apellido", "Nombre", "Tipo de documento", "Numero de documento"}));

		scrollPane.setViewportView(table);

		textNombre = new JTextField();
		textNombre.setBounds(277, 110, 150, 20);
		panelCentral.add(textNombre);
		textNombre.setColumns(10);
		textNombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(277, 191, 150, 20);
		panelCentral.add(textApellido);
		textApellido.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		textNroDocumento = new JTextField();
		textNroDocumento.setColumns(10);
		textNroDocumento.setBounds(850, 191, 150, 20);
		textNroDocumento.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		panelCentral.add(textNroDocumento);

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LE", "LC", "PASAPORTE"}));
		comboBoxTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxTipo.setBackground(new Color(255, 255, 255));
		comboBoxTipo.setBounds(850, 106, 150, 24);
		panelCentral.add(comboBoxTipo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(1014, 581, 150, 30);
		panelCentral.add(btnAceptar);
		
		JLabel lblNewLabel = new JLabel("Busqueda de pasajero:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(114, 44, 272, 30);
		panelCentral.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombre.setBounds(146, 103, 100, 30);
		panelCentral.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblApellido.setBounds(146, 184, 100, 30);
		panelCentral.add(lblApellido);
		
		JLabel lblNumeroDeDocumento = new JLabel("Numero de documento");
		lblNumeroDeDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumeroDeDocumento.setBounds(681, 184, 180, 30);
		panelCentral.add(lblNumeroDeDocumento);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTipoDeDocumento.setBounds(681, 103, 180, 30);
		panelCentral.add(lblTipoDeDocumento);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAsignar.setBackground(Color.WHITE);
		btnAsignar.setBounds(833, 581, 150, 30);
		panelCentral.add(btnAsignar);
		
		JCheckBox chckbxResponsable = new JCheckBox("Responsable de habitacion");
		chckbxResponsable.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxResponsable.setBounds(596, 585, 225, 23);
		chckbxResponsable.setBackground(new Color(102, 204, 255));
		panelCentral.add(chckbxResponsable);
		
		JLabel lblHabitacion = new JLabel("");
		lblHabitacion.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHabitacion.setBounds(519, 26, 120, 20);
		panelCentral.add(lblHabitacion);
		
		
		lblHabitacion.setText("Habitacion " + habitaciones.get(num).getNumero().toString());
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int seleccionar = table.rowAtPoint(e.getPoint());
				busquedaPasajeroDTOseleccionado.setApellido(((String) table.getValueAt(seleccionar, 0)));
				busquedaPasajeroDTOseleccionado.setNombre(((String) table.getValueAt(seleccionar, 1)));
				busquedaPasajeroDTOseleccionado.setTipoDeDocumento(((String) table.getValueAt(seleccionar, 2)));
				busquedaPasajeroDTOseleccionado.setNumeroDeDocumento(((String) table.getValueAt(seleccionar, 3)));
			}
		});

		
		
		if (crearEstadia) nuevaEstadia = gEstadia.crearEstadia(habitaciones.get(num), fechas.get(num));
		else this.nuevaEstadia = e;
		
	
		
		for (Ocupacion o: nuevaEstadia.getOcupaciones())
			if (!o.getPasajeroResponsable()) 
				chckbxResponsable.setEnabled(true);
		
		for (Ocupacion o: nuevaEstadia.getOcupaciones())
			if (o.getPasajeroResponsable()) 
				chckbxResponsable.setEnabled(false);
			
		
		
		// BTN ACTIONS

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final GestionarHabitacion ventanaGP = new GestionarHabitacion();
				ventanaGP.setVisible(true);
				dispose();
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gestorPasajero.vaciarTabla(table);
	
				busquedaPasajeroDTO.setApellido(textApellido.getText());
				busquedaPasajeroDTO.setNombre(textNombre.getText().toString());
				busquedaPasajeroDTO.setNumeroDeDocumento(textNroDocumento.getText().toString());
				busquedaPasajeroDTO.setTipoDeDocumento(comboBoxTipo.getSelectedItem().toString());
				
				if (gestorPasajero.validarPasajero(busquedaPasajeroDTO)) {
			
					List<BusquedaPasajeroDTO> listaCoincidencias = gestorPasajero.recuperarPasajeros(busquedaPasajeroDTO);		
					gestorPasajero.ingresarATablaResultados(listaCoincidencias, table);
					}
				
			}
		});
		
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			
				List<Persona> listaPersonas = gestorPasajero.recuperarPersonas(busquedaPasajeroDTOseleccionado);
				
				
				Pasajero pasajero = gestorPasajero.obtenerPasajero(listaPersonas,busquedaPasajeroDTOseleccionado);
				
				if (!verificarPasajeros(nuevaEstadia,pasajero)) {
					
				Ocupacion ocupacion; 
				ocupacion = gEstadia.crearOcupacion(pasajero,chckbxResponsable.isSelected(), nuevaEstadia );
				
				nuevaEstadia.getOcupaciones().add(ocupacion);
				
				
				final CargarPasajeros ventanaCP = new CargarPasajeros(pasajero,chckbxResponsable.isSelected(), habitaciones, fechas, num, nuevaEstadia);
				ventanaCP.setVisible(true);
				}
				
				else JOptionPane.showMessageDialog(new JPanel(), "El pasajero ya se encuentra cargado. Intente nuevamente", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		});

	}
	
	
	public Boolean verificarPasajeros (Estadia e, Pasajero p) {
		
		for (Ocupacion o: e.getOcupaciones())
			if (o.getPasajero().getId() == p.getId())
				return true;
		
		return false;
	}
	
}
