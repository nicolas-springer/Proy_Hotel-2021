package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.BusquedaPasajeroDTO;
import gestor.GestorPasajero;

import javax.swing.JLabel;
import javax.swing.JOptionPane;



@SuppressWarnings("serial")
public class ModificarPasajero extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textNroDocumento;
	
	GestorPasajero gestorPasajero = new GestorPasajero();
	BusquedaPasajeroDTO busquedaPasajeroDTO = new BusquedaPasajeroDTO();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ModificarPasajero() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Modificar pasajero");
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
		btnBuscar.setBounds(1014, 199, 150, 30);
		btnBuscar.setBackground(new Color(255, 255, 255));
		panelCentral.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 253, 1050, 300);
		scrollPane.setBackground(new Color(255, 255, 255));
		panelCentral.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Apellido", "Nombre", "Tipo de documento", "Numero de documento"}));

		scrollPane.setViewportView(table);

		textNombre = new JTextField();
		textNombre.setBounds(277, 77, 150, 20);
		panelCentral.add(textNombre);
		textNombre.setColumns(10);
		textNombre.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(277, 158, 150, 20);
		panelCentral.add(textApellido);
		textApellido.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		
		textNroDocumento = new JTextField();
		textNroDocumento.setColumns(10);
		textNroDocumento.setBounds(850, 158, 150, 20);
		textNroDocumento.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
		panelCentral.add(textNroDocumento);

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"DNI", "LE", "LC", "PASAPORTE"}));
		comboBoxTipo.setFont(new Font("Dialog", Font.PLAIN, 15));
		comboBoxTipo.setBackground(new Color(255, 255, 255));
		comboBoxTipo.setBounds(850, 73, 150, 24);
		panelCentral.add(comboBoxTipo);
		
		JButton btnModificar = new JButton("Modificar Pasajero");
		btnModificar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(964, 581, 200, 30);
		panelCentral.add(btnModificar);
		
		JLabel lblNewLabel = new JLabel("Busqueda de pasajero:");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(114, 11, 272, 30);
		panelCentral.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNombre.setBounds(146, 70, 100, 30);
		panelCentral.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblApellido.setBounds(146, 151, 100, 30);
		panelCentral.add(lblApellido);
		
		JLabel lblNumeroDeDocumento = new JLabel("Numero de documento");
		lblNumeroDeDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNumeroDeDocumento.setBounds(681, 151, 180, 30);
		panelCentral.add(lblNumeroDeDocumento);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento");
		lblTipoDeDocumento.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTipoDeDocumento.setBounds(681, 70, 180, 30);
		panelCentral.add(lblTipoDeDocumento);
		
		

		BusquedaPasajeroDTO busquedaPasajeroDTOseleccionado = new BusquedaPasajeroDTO();
		
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

		

		// BTN ACTIONS

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final GestionarPasajero ventanaGP = new GestionarPasajero();
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
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(new JPanel(), "Modalidad aún no implementada", " ",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
	}
}