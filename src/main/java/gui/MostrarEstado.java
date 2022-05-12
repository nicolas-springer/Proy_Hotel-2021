package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dominio.Estadia;
import dominio.Habitacion;
import dominio.Mantenimiento;
import dominio.Reserva;
import gestor.GestorHabitacion;

import javax.swing.SwingConstants;

import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MostrarEstado extends JFrame {

	private JPanel contentPane;
	private JTable tableIndividual;
	private JTable tableDobleE;
	private JTable tableDobleS;
	private JTable tableFamily;
	private JTable tableSuit;

	DefaultTableModel dtmIndividual;
	DefaultTableModel dtmDobleE;
	DefaultTableModel dtmDobleS;
	DefaultTableModel dtmFamily;
	DefaultTableModel dtmSuit;

	LocalDate startDate;
	LocalDate endDate;

	GestorHabitacion gHabitacion;
	JLabel aux;

	int columna;
	int fila;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MostrarEstado() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Estado Habitaciones");

		JPanel panelIndividual = new JPanel();
		JPanel panelDobleEstandar = new JPanel();
		JPanel panelDobleSuperior = new JPanel();
		JPanel panelSuperiorFamily = new JPanel();
		JPanel panelSuit = new JPanel();

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JLabel lblHasta = new JLabel("Hasta:");
		lblHasta.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblHasta.setBounds(362, 30, 61, 14);
		panelCentral.add(lblHasta);

		JLabel lblDesde_1 = new JLabel("Desde:");
		lblDesde_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDesde_1.setBounds(55, 30, 53, 14);
		panelCentral.add(lblDesde_1);

		JComboBox comboBoxAño = new JComboBox();
		comboBoxAño.setBounds(239, 27, 75, 24);
		panelCentral.add(comboBoxAño);

		JComboBox comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(114, 27, 45, 24);
		panelCentral.add(comboBoxDia);

		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(174, 27, 45, 24);
		panelCentral.add(comboBoxMes);

		JComboBox comboBoxDia_1 = new JComboBox();
		comboBoxDia_1.setBounds(421, 27, 45, 24);
		panelCentral.add(comboBoxDia_1);

		JComboBox comboBoxMes_1 = new JComboBox();
		comboBoxMes_1.setBounds(481, 27, 45, 24);
		panelCentral.add(comboBoxMes_1);

		JComboBox comboBoxAño_1 = new JComboBox();
		comboBoxAño_1.setBounds(546, 27, 75, 24);
		panelCentral.add(comboBoxAño_1);

		for (int a = 2020; a < 2022; a++) {
			comboBoxAño.addItem(a);
			comboBoxAño_1.addItem(a);
		}
		for (int d = 1; d < 32; d++) {
			comboBoxDia.addItem(d);
			comboBoxDia_1.addItem(d);
		}
		for (int m = 1; m < 13; m++) {
			comboBoxMes_1.addItem(m);
			comboBoxMes.addItem(m);
		}

		JTabbedPane sd = new JTabbedPane();
		sd.setBounds(53, 94, 1127, 394);

		sd.add("Individual Estandar", panelIndividual);
		sd.add("Doble Estandar", panelDobleEstandar);
		sd.add("Doble Superior", panelDobleSuperior);
		sd.add("Superior Family Plan", panelSuperiorFamily);
		sd.add("Suit Doble", panelSuit);
		sd.setFont(new Font("Dialog", Font.PLAIN, 15));

		panelCentral.add(sd);

		JLabel lbl1 = new JLabel("Numero de Habitacion ");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Dialog", Font.PLAIN, 15));

		JLabel lbl2 = new JLabel("Numero de Habitacion ");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Dialog", Font.PLAIN, 15));

		JLabel lbl5 = new JLabel("Numero de Habitacion ");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Dialog", Font.PLAIN, 15));

		JLabel lbl3 = new JLabel("Numero de Habitacion ");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Dialog", Font.PLAIN, 15));

		JLabel lbl4 = new JLabel("Numero de Habitacion ");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Dialog", Font.PLAIN, 15));

		// PANEL DE LA HABITACION INDIVIDUAL ESTANDAR
		panelIndividual.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneIndividual = new JScrollPane();
		scrollPaneIndividual.setBounds(10, 94, 1127, 518);
		scrollPaneIndividual.setBackground(new Color(255, 255, 255));
		panelIndividual.add(scrollPaneIndividual, BorderLayout.CENTER);

		tableIndividual = new JTable();
		tableIndividual.setBackground(new Color(255, 255, 255));
		tableIndividual.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dia" }));

		dtmIndividual = (DefaultTableModel) tableIndividual.getModel();
		for (int i = 1; i < 11; i++)
			dtmIndividual.addColumn(i);

		scrollPaneIndividual.setViewportView(tableIndividual);
		panelIndividual.add(lbl1, BorderLayout.NORTH);

		tableIndividual.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				columna = tableIndividual.getSelectedColumn();
				fila = tableIndividual.getSelectedRow();

				Boolean ocuparreserva = false;

				if ((tableIndividual.getValueAt(fila, columna) == null))
					tableIndividual.setValueAt("ocupar", fila, columna);

				else if (tableIndividual.getValueAt(fila, columna).equals("ocupar"))
					tableIndividual.setValueAt(null, fila, columna);

				else if (tableIndividual.getValueAt(fila, columna).equals("reservado"))
					ocuparreserva = true;

				else if (tableIndividual.getValueAt(fila, columna).equals("ocuparReserva"))
					tableIndividual.setValueAt("reservado", fila, columna);

				if (ocuparreserva) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(),
							"Seleccionaste una fecha en estado reservado. ¿Desea ocupar igualmente?.", "AVISO",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						tableIndividual.setValueAt("ocuparReserva", fila, columna);
					}
				}

				for (int i = 1; i < 11; i++)
					tableIndividual.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			}
		});

		// PANEL DE LA HABITACION DOBLE ESTANDAR
		panelDobleEstandar.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneDobleE = new JScrollPane();
		scrollPaneDobleE.setBounds(10, 94, 1127, 518);
		scrollPaneDobleE.setBackground(new Color(255, 255, 255));
		panelDobleEstandar.add(scrollPaneDobleE, BorderLayout.CENTER);

		tableDobleE = new JTable();
		tableDobleE.setBackground(new Color(255, 255, 255));
		tableDobleE.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dia" }));

		dtmDobleE = (DefaultTableModel) tableDobleE.getModel();
		for (int i = 11; i < 29; i++)
			dtmDobleE.addColumn(i);

		scrollPaneDobleE.setViewportView(tableDobleE);
		panelDobleEstandar.add(lbl2, BorderLayout.NORTH);

		tableDobleE.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				columna = tableDobleE.getSelectedColumn();
				fila = tableDobleE.getSelectedRow();
				Boolean ocuparreserva = false;

				if ((tableDobleE.getValueAt(fila, columna) == null))
					tableDobleE.setValueAt("ocupar", fila, columna);

				else if (tableDobleE.getValueAt(fila, columna).equals("ocupar"))
					tableDobleE.setValueAt(null, fila, columna);

				else if (tableDobleE.getValueAt(fila, columna).equals("reservado"))
					ocuparreserva = true;

				else if (tableDobleE.getValueAt(fila, columna).equals("ocuparReserva"))
					tableDobleE.setValueAt("reservado", fila, columna);

				if (ocuparreserva) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(),
							"Seleccionaste una fecha en estado reservado. ¿Desea ocupar igualmente?.", "AVISO",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						tableDobleE.setValueAt("ocuparReserva", fila, columna);
					}
				}

				for (int i = 1; i < 19; i++)
					tableDobleE.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			}
		});

		// PANEL DE LA HABITACION DOBLE SUPERIOR
		panelDobleSuperior.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneDobleS = new JScrollPane();
		scrollPaneDobleS.setBounds(10, 94, 1127, 518);
		scrollPaneDobleS.setBackground(new Color(255, 255, 255));
		panelDobleSuperior.add(scrollPaneDobleS, BorderLayout.CENTER);

		tableDobleS = new JTable();
		tableDobleS.setBackground(new Color(255, 255, 255));
		tableDobleS.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dia" }));

		dtmDobleS = (DefaultTableModel) tableDobleS.getModel();
		for (int i = 29; i < 37; i++)
			dtmDobleS.addColumn(i);

		scrollPaneDobleS.setViewportView(tableDobleS);
		panelDobleSuperior.add(lbl3, BorderLayout.NORTH);

		tableDobleS.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Boolean ocuparreserva = false;
				columna = tableDobleS.getSelectedColumn();
				fila = tableDobleS.getSelectedRow();

				if ((tableDobleS.getValueAt(fila, columna) == null))
					tableDobleS.setValueAt("ocupar", fila, columna);

				else if (tableDobleS.getValueAt(fila, columna).equals("ocupar"))
					tableDobleS.setValueAt(null, fila, columna);

				else if (tableDobleS.getValueAt(fila, columna).equals("reservado"))
					ocuparreserva = true;

				else if (tableDobleS.getValueAt(fila, columna).equals("ocuparReserva"))
					tableDobleS.setValueAt("reservado", fila, columna);

				if (ocuparreserva) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(),
							"Seleccionaste una fecha en estado reservado. ¿Desea ocupar igualmente?.", "AVISO",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						tableDobleS.setValueAt("ocuparReserva", fila, columna);
					}
				}

				for (int i = 1; i < 9; i++)
					tableDobleS.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			}
		});

		// PANEL DE LA HABITACION SUPERIOR FAMILY
		panelSuperiorFamily.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneSuperiorF = new JScrollPane();
		scrollPaneSuperiorF.setBounds(10, 94, 1127, 518);
		scrollPaneSuperiorF.setBackground(new Color(255, 255, 255));
		panelSuperiorFamily.add(scrollPaneSuperiorF, BorderLayout.CENTER);

		tableFamily = new JTable();
		tableFamily.setBackground(new Color(255, 255, 255));
		tableFamily.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dia" }));

		dtmFamily = (DefaultTableModel) tableFamily.getModel();
		for (int i = 37; i < 47; i++)
			dtmFamily.addColumn(i);

		scrollPaneSuperiorF.setViewportView(tableFamily);
		panelSuperiorFamily.add(lbl4, BorderLayout.NORTH);

		tableFamily.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Boolean ocuparreserva = false;
				columna = tableFamily.getSelectedColumn();
				fila = tableFamily.getSelectedRow();

				if ((tableFamily.getValueAt(fila, columna) == null))
					tableFamily.setValueAt("ocupar", fila, columna);

				else if (tableFamily.getValueAt(fila, columna).equals("ocupar"))
					tableFamily.setValueAt(null, fila, columna);

				else if (tableFamily.getValueAt(fila, columna).equals("reservado"))
					ocuparreserva = true;

				else if (tableFamily.getValueAt(fila, columna).equals("ocuparReserva"))
					tableFamily.setValueAt("reservado", fila, columna);

				if (ocuparreserva) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(),
							"Seleccionaste una fecha en estado reservado. ¿Desea ocupar igualmente?.", "AVISO",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						tableFamily.setValueAt("ocuparReserva", fila, columna);
					}
				}

				for (int i = 1; i < 11; i++)
					tableFamily.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			}
		});

		// PANEL DE LA HABITACION SUIT
		panelSuit.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPaneSuit = new JScrollPane();
		scrollPaneSuit.setBounds(10, 94, 1127, 518);
		scrollPaneSuit.setBackground(new Color(255, 255, 255));
		panelSuit.add(scrollPaneSuit, BorderLayout.CENTER);

		tableSuit = new JTable();
		tableSuit.setBackground(new Color(255, 255, 255));
		tableSuit.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Dia" }));

		dtmSuit = (DefaultTableModel) tableSuit.getModel();
		for (int i = 47; i < 49; i++)
			dtmSuit.addColumn(i);

		scrollPaneSuit.setViewportView(tableSuit);
		panelSuit.add(lbl5, BorderLayout.NORTH);

		tableSuit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Boolean ocuparreserva = false;
				columna = tableSuit.getSelectedColumn();
				fila = tableSuit.getSelectedRow();

				if ((tableSuit.getValueAt(fila, columna) == null))
					tableSuit.setValueAt("ocupar", fila, columna);

				else if (tableSuit.getValueAt(fila, columna).equals("ocupar"))
					tableSuit.setValueAt(null, fila, columna);

				else if (tableSuit.getValueAt(fila, columna).equals("reservado"))
					ocuparreserva = true;

				else if (tableSuit.getValueAt(fila, columna).equals("ocuparReserva"))
					tableSuit.setValueAt("reservado", fila, columna);

				if (ocuparreserva) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(),
							"Seleccionaste una fecha en estado reservado. ¿Desea ocupar igualmente?.", "AVISO",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para icono
																									// por defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						tableSuit.setValueAt("ocuparReserva", fila, columna);
					}
				}

				for (int i = 1; i < 3; i++)
					tableSuit.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnBuscar.setBounds(1091, 28, 89, 23);
		panelCentral.add(btnBuscar);

		JLabel lblOcupado = new JLabel("OCUPADO");
		lblOcupado.setForeground(Color.RED);
		lblOcupado.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblOcupado.setBounds(55, 513, 107, 24);
		panelCentral.add(lblOcupado);

		JLabel lblReservado = new JLabel("RESERVADO");
		lblReservado.setForeground(Color.YELLOW);
		lblReservado.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblReservado.setBounds(686, 513, 136, 24);
		panelCentral.add(lblReservado);

		JLabel lblMantenimiento = new JLabel("MANTENIMIENTO");
		lblMantenimiento.setForeground(Color.GRAY);
		lblMantenimiento.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblMantenimiento.setBounds(342, 513, 164, 24);
		panelCentral.add(lblMantenimiento);

		JLabel lblSeleccionReserva = new JLabel("SELECCION RESERVA");
		lblSeleccionReserva.setForeground(Color.GREEN);
		lblSeleccionReserva.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		lblSeleccionReserva.setBounds(971, 513, 209, 24);
		panelCentral.add(lblSeleccionReserva);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAceptar.setBounds(1091, 625, 89, 23);
		panelCentral.add(btnAceptar);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnAtras.setBounds(55, 627, 89, 23);
		panelCentral.add(btnAtras);

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

		comboBoxMes_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int mesSeleccionado = (int) comboBoxDia_1.getSelectedItem();
				comboBoxDia_1.removeAllItems();
				if ((Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()) == 4)
						|| (Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()) == 6)
						|| (Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()) == 9)
						|| (Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()) == 11))
					for (int d = 1; d < 31; d++)
						comboBoxDia_1.addItem(d);

				else if (Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()) == 2)
					for (int d = 1; d < 29; d++)
						comboBoxDia_1.addItem(d);

				else
					for (int d = 1; d < 32; d++)
						comboBoxDia_1.addItem(d);

				comboBoxDia_1.setSelectedItem(mesSeleccionado);
			}

		});
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				limpiarTabla();

				startDate = LocalDate.of(Integer.parseInt(comboBoxAño.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMes.getSelectedItem().toString()),
						Integer.parseInt(comboBoxDia.getSelectedItem().toString()));
				endDate = LocalDate.of(Integer.parseInt(comboBoxAño_1.getSelectedItem().toString()),
						Integer.parseInt(comboBoxMes_1.getSelectedItem().toString()),
						Integer.parseInt(comboBoxDia_1.getSelectedItem().toString()));

				if (verificarFecha(startDate, endDate)) {

					gHabitacion = new GestorHabitacion();

					ArrayList<Object[]> habitaciones = gHabitacion.listaHabitaciones(startDate, endDate);

					List<Estadia> listaHabitacionesE = new ArrayList<>();
					List<Mantenimiento> listaHabitacionesM = new ArrayList<>();
					List<Reserva> listaHabitacionesR = new ArrayList<>();

					listaHabitacionesE = gHabitacion.listaHabitacionesConEstadia(startDate, endDate);
					listaHabitacionesM = gHabitacion.listaHabitacionesConMantenimiento(startDate, endDate);
					listaHabitacionesR = gHabitacion.listaHabitacionesConReserva(startDate, endDate);

					for (int i = 0; i < habitaciones.size(); i++) {
						dtmIndividual.addRow(habitaciones.get(i));
						dtmDobleE.addRow(habitaciones.get(i));
						dtmDobleS.addRow(habitaciones.get(i));
						dtmFamily.addRow(habitaciones.get(i));
						dtmSuit.addRow(habitaciones.get(i));
					}

					completarOcupado(listaHabitacionesE);
					completarMantenimiento(listaHabitacionesM);
					completarReserva(listaHabitacionesR);

				}

				else
					JOptionPane.showMessageDialog(null,
							"El rango de fecha es incorrecto. Por favor vuelva a ingresarlo", "CUIDADO", 1);

			}
		});

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<List<Habitacion>> listaHabitaciones = new ArrayList<List<Habitacion>>();

				List<List<LocalDate>> listaFechas = new ArrayList<List<LocalDate>>();

				listaHabitaciones = recuperarHabitaciones();
				listaFechas = recuperarFechas();

				if (listaHabitaciones.size() == 0)
					JOptionPane.showMessageDialog(null,
							"No se ha seleccionado ninguna habitacion en el rango solicitado");
				else {

					for (List<LocalDate> lista : listaFechas)
						System.out.println(lista.toString());

					List<Habitacion> ha = listaHabitaciones.get(0);

					for (Habitacion h : ha)
						System.out.println(h.getNumero());

					System.out.println("skal");

					List<Habitacion> hab = listaHabitaciones.get(1);

					for (Habitacion h : hab)
						System.out.println(h.getNumero());

					Estadia est = null;

					final OcuparHabitacion ventanaO = new OcuparHabitacion(hab, listaFechas, 0, est, true);
					ventanaO.setVisible(true);
					dispose();

				}
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				final GestionarHabitacion ventanaGH = new GestionarHabitacion();
				ventanaGH.setVisible(true);
				dispose();

			}

		});
	}

	public void completarOcupado(List<Estadia> listaHabitacionesE) {

		int numHabitacion;
		JLabel ocupado = new JLabel("ocupado");

		for (Estadia estadia : listaHabitacionesE) {

			numHabitacion = estadia.getHabitacion().getNumero();

			if (numHabitacion <= 10)
				for (LocalDate date = estadia.getFechaInicio(); (date.isBefore(estadia.getFechaFin())
						|| date.isEqual(estadia.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmIndividual.setValueAt(ocupado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
								estadia.getHabitacion().getNumero());

			if (numHabitacion > 10 && numHabitacion <= 28)
				for (LocalDate date = estadia.getFechaInicio(); (date.isBefore(estadia.getFechaFin())
						|| date.isEqual(estadia.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmDobleE.setValueAt(ocupado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
								estadia.getHabitacion().getNumero() - 10);

			if (numHabitacion > 28 && numHabitacion <= 36)
				for (LocalDate date = estadia.getFechaInicio(); (date.isBefore(estadia.getFechaFin())
						|| date.isEqual(estadia.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmDobleS.setValueAt(ocupado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
								estadia.getHabitacion().getNumero() - 28);

			if (numHabitacion > 36 && numHabitacion <= 46)

				for (LocalDate date = estadia.getFechaInicio(); (date.isBefore(estadia.getFechaFin())
						|| date.isEqual(estadia.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmFamily.setValueAt(ocupado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
								estadia.getHabitacion().getNumero() - 36);

			if (numHabitacion > 46)
				for (LocalDate date = estadia.getFechaInicio(); (date.isBefore(estadia.getFechaFin())
						|| date.isEqual(estadia.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmSuit.setValueAt(ocupado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
								estadia.getHabitacion().getNumero() - 46);

		}
		/*
		 * for (int i = 1; i < 19; i++) {
		 * 
		 * if (i < 11) {
		 * tableIndividual.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
		 * tableFamily.getColumnModel().getColumn(i).setCellRenderer(new Pintar()); } if
		 * (i < 9) tableDobleS.getColumnModel().getColumn(i).setCellRenderer(new
		 * Pintar());
		 * 
		 * if (i < 3) tableSuit.getColumnModel().getColumn(i).setCellRenderer(new
		 * Pintar());
		 * 
		 * tableDobleE.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
		 * 
		 * }
		 */
	}

	public void completarMantenimiento(List<Mantenimiento> listaHabitacionesM) {

		int numHabitacion;
		JLabel lblMantenimiento = new JLabel("mantenimiento");

		for (Mantenimiento mantenimiento : listaHabitacionesM) {

			numHabitacion = mantenimiento.getHabitacion().getNumero();

			if (numHabitacion <= 10)
				for (LocalDate date = mantenimiento.getFechaInicio(); (date.isBefore(mantenimiento.getFechaFin())
						|| date.isEqual(mantenimiento.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmIndividual.setValueAt(lblMantenimiento.getText(),
								(date.getDayOfMonth() - startDate.getDayOfMonth()),
								mantenimiento.getHabitacion().getNumero());

			if (numHabitacion > 10 && numHabitacion <= 28)
				for (LocalDate date = mantenimiento.getFechaInicio(); (date.isBefore(mantenimiento.getFechaFin())
						|| date.isEqual(mantenimiento.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmDobleE.setValueAt(lblMantenimiento.getText(),
								(date.getDayOfMonth() - startDate.getDayOfMonth()),
								mantenimiento.getHabitacion().getNumero() - 10);

			if (numHabitacion > 28 && numHabitacion <= 36)
				for (LocalDate date = mantenimiento.getFechaInicio(); (date.isBefore(mantenimiento.getFechaFin())
						|| date.isEqual(mantenimiento.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmDobleS.setValueAt(lblMantenimiento.getText(),
								(date.getDayOfMonth() - startDate.getDayOfMonth()),
								mantenimiento.getHabitacion().getNumero() - 28);

			if (numHabitacion > 36 && numHabitacion <= 46)

				for (LocalDate date = mantenimiento.getFechaInicio(); (date.isBefore(mantenimiento.getFechaFin())
						|| date.isEqual(mantenimiento.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmFamily.setValueAt(lblMantenimiento.getText(),
								(date.getDayOfMonth() - startDate.getDayOfMonth()),
								mantenimiento.getHabitacion().getNumero() - 36);

			if (numHabitacion > 46)
				for (LocalDate date = mantenimiento.getFechaInicio(); (date.isBefore(mantenimiento.getFechaFin())
						|| date.isEqual(mantenimiento.getFechaFin())); date = date.plusDays(1))

					if ((date.isBefore(endDate) || date.isEqual(endDate))
							& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
						dtmSuit.setValueAt(lblMantenimiento.getText(),
								(date.getDayOfMonth() - startDate.getDayOfMonth()),
								mantenimiento.getHabitacion().getNumero() - 46);

		}

		for (int i = 1; i < 19; i++) {

			if (i < 11) {
				tableIndividual.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
				tableFamily.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
			}
			if (i < 9)
				tableDobleS.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			if (i < 3)
				tableSuit.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

			tableDobleE.getColumnModel().getColumn(i).setCellRenderer(new Pintar());

		}

	}

	public void completarReserva(List<Reserva> listaHabitacionesR) {

		int numHabitacion;
		JLabel reservado = new JLabel("reservado");

		for (Reserva reserva : listaHabitacionesR) {

			for (Habitacion habitacion : reserva.getHabitacion()) {
				numHabitacion = habitacion.getNumero();

				if (numHabitacion <= 10)
					for (LocalDate date = reserva.getFechaInicio(); (date.isBefore(reserva.getFechaFin())
							|| date.isEqual(reserva.getFechaFin())); date = date.plusDays(1))

						if ((date.isBefore(endDate) || date.isEqual(endDate))
								& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
							dtmIndividual.setValueAt(reservado.getText(),
									(date.getDayOfMonth() - startDate.getDayOfMonth()), numHabitacion);

				if (numHabitacion > 10 && numHabitacion <= 28)
					for (LocalDate date = reserva.getFechaInicio(); (date.isBefore(reserva.getFechaFin())
							|| date.isEqual(reserva.getFechaFin())); date = date.plusDays(1))

						if ((date.isBefore(endDate) || date.isEqual(endDate))
								& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
							dtmDobleE.setValueAt(reservado.getText(),
									(date.getDayOfMonth() - startDate.getDayOfMonth()), numHabitacion - 10);

				if (numHabitacion > 28 && numHabitacion <= 36)
					for (LocalDate date = reserva.getFechaInicio(); (date.isBefore(reserva.getFechaFin())
							|| date.isEqual(reserva.getFechaFin())); date = date.plusDays(1))

						if ((date.isBefore(endDate) || date.isEqual(endDate))
								& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
							dtmDobleS.setValueAt(reservado.getText(),
									(date.getDayOfMonth() - startDate.getDayOfMonth()), numHabitacion - 28);

				if (numHabitacion > 36 && numHabitacion <= 46)

					for (LocalDate date = reserva.getFechaInicio(); (date.isBefore(reserva.getFechaFin())
							|| date.isEqual(reserva.getFechaFin())); date = date.plusDays(1))

						if ((date.isBefore(endDate) || date.isEqual(endDate))
								& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
							dtmFamily.setValueAt(reservado.getText(),
									(date.getDayOfMonth() - startDate.getDayOfMonth()), numHabitacion - 36);

				if (numHabitacion > 46)
					for (LocalDate date = reserva.getFechaInicio(); (date.isBefore(reserva.getFechaFin())
							|| date.isEqual(reserva.getFechaFin())); date = date.plusDays(1))

						if ((date.isBefore(endDate) || date.isEqual(endDate))
								& ((date.getDayOfMonth() - startDate.getDayOfMonth()) >= 0))
							dtmSuit.setValueAt(reservado.getText(), (date.getDayOfMonth() - startDate.getDayOfMonth()),
									numHabitacion - 46);

			}
		}
		/*
		 * for (int i = 1; i < 19; i++) {
		 * 
		 * if (i < 11) {
		 * tableIndividual.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
		 * tableFamily.getColumnModel().getColumn(i).setCellRenderer(new Pintar()); } if
		 * (i < 9) tableDobleS.getColumnModel().getColumn(i).setCellRenderer(new
		 * Pintar());
		 * 
		 * if (i < 3) tableSuit.getColumnModel().getColumn(i).setCellRenderer(new
		 * Pintar());
		 * 
		 * tableDobleE.getColumnModel().getColumn(i).setCellRenderer(new Pintar());
		 * 
		 * }
		 */
	}

	public void limpiarTabla() {

		int cantidadFilas = dtmIndividual.getRowCount();

		for (int i = cantidadFilas - 1; i >= 0; i--) {
			dtmIndividual.removeRow(i);
			dtmDobleE.removeRow(i);
			dtmDobleS.removeRow(i);
			dtmFamily.removeRow(i);
			dtmSuit.removeRow(i);
		}
	}

	public Boolean verificarFecha(LocalDate startDate, LocalDate endDate) {

		if (startDate.isAfter(endDate))
			return false;

		else
			return true;

	}

	public List<List<Habitacion>> recuperarHabitaciones() {

		List<Integer> listaHabitacionesAOcupar = new ArrayList<Integer>();

		List<Integer> listaReservasADesocupar = new ArrayList<Integer>();
		listaHabitacionesAOcupar.add(0);
		listaReservasADesocupar.add(0);

		List<List<Habitacion>> retorno = new ArrayList<List<Habitacion>>();

		for (int j = 1; j < tableIndividual.getColumnCount(); j++)
			for (int i = 0; i < tableIndividual.getRowCount(); i++)
				if ((tableIndividual.getValueAt(i, j) != null))
					if (tableIndividual.getValueAt(i, j).equals("ocupar"))
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
					else if (tableIndividual.getValueAt(i, j).equals("ocuparReserva")) {
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
						listaReservasADesocupar = gHabitacion.agregarHabitacionAOcupar(listaReservasADesocupar, j);
					}

		for (int j = 1; j < tableDobleE.getColumnCount(); j++)
			for (int i = 0; i < tableDobleE.getRowCount(); i++)
				if ((tableDobleE.getValueAt(i, j) != null))
					if (tableDobleE.getValueAt(i, j).equals("ocupar"))
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar,
								j + 10);
					else if (tableDobleE.getValueAt(i, j).equals("ocuparReserva")) {
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
						listaReservasADesocupar = gHabitacion.agregarHabitacionAOcupar(listaReservasADesocupar, j);
					}

		for (int j = 1; j < tableDobleS.getColumnCount(); j++)
			for (int i = 0; i < tableDobleS.getRowCount(); i++)
				if ((tableDobleS.getValueAt(i, j) != null))
					if (tableDobleS.getValueAt(i, j).equals("ocupar"))
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar,
								j + 28);
					else if (tableDobleS.getValueAt(i, j).equals("ocuparReserva")) {
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
						listaReservasADesocupar = gHabitacion.agregarHabitacionAOcupar(listaReservasADesocupar, j);
					}

		for (int j = 1; j < tableFamily.getColumnCount(); j++)
			for (int i = 0; i < tableFamily.getRowCount(); i++)
				if ((tableFamily.getValueAt(i, j) != null))
					if (tableFamily.getValueAt(i, j).equals("ocupar"))
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar,
								j + 36);
					else if (tableFamily.getValueAt(i, j).equals("ocuparReserva")) {
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
						listaReservasADesocupar = gHabitacion.agregarHabitacionAOcupar(listaReservasADesocupar, j);
					}

		for (int j = 1; j < tableSuit.getColumnCount(); j++)
			for (int i = 0; i < tableSuit.getRowCount(); i++)
				if ((tableSuit.getValueAt(i, j) != null))
					if (tableSuit.getValueAt(i, j).equals("ocupar"))
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar,
								j + 46);
					else if (tableSuit.getValueAt(i, j).equals("ocuparReserva")) {
						listaHabitacionesAOcupar = gHabitacion.agregarHabitacionAOcupar(listaHabitacionesAOcupar, j);
						listaReservasADesocupar = gHabitacion.agregarHabitacionAOcupar(listaReservasADesocupar, j);
					}

		List<Habitacion> habitacionesOcupar = gHabitacion.recuperarH(listaHabitacionesAOcupar);
		List<Habitacion> habitacionesDesocupar = gHabitacion.recuperarH(listaReservasADesocupar);

		retorno.add(habitacionesDesocupar);
		retorno.add(habitacionesOcupar);

		return retorno;

	}

	public List<List<LocalDate>> recuperarFechas() {

		List<List<LocalDate>> listaDeFecha = new ArrayList<List<LocalDate>>();

		List<LocalDate> listaDeFechaAux = new ArrayList<LocalDate>();

		List<LocalDate> listaDeFechaReserva = new ArrayList<LocalDate>();

		Boolean flag = false;

		for (int j = 1; j < tableIndividual.getColumnCount(); j++) {
			flag = false;
			listaDeFechaAux = new ArrayList<LocalDate>();
			for (int i = 0; i < tableIndividual.getRowCount(); i++) {
				if ((tableIndividual.getValueAt(i, j) != null))
					if (tableIndividual.getValueAt(i, j).equals("ocupar")) {
						listaDeFechaAux.add((LocalDate) tableIndividual.getValueAt(i, 0));
						flag = true;
					} else if (tableIndividual.getValueAt(i, j).equals("ocuparReserva")) {
						listaDeFechaAux.add((LocalDate) tableIndividual.getValueAt(i, 0));
						flag = true;
					}
			}
			if (flag)
				listaDeFecha.add(listaDeFechaAux);
		}

		flag = false;

		for (int j = 1; j < tableDobleE.getColumnCount(); j++) {
			flag = false;
			listaDeFechaAux = new ArrayList<LocalDate>();
			for (int i = 0; i < tableDobleE.getRowCount(); i++) {
				if ((tableDobleE.getValueAt(i, j) != null))
					if (tableDobleE.getValueAt(i, j).equals("ocupar")) {
						listaDeFechaAux.add((LocalDate) tableDobleE.getValueAt(i, 0));
						flag = true;
					}

			}
			if (flag)
				listaDeFecha.add(listaDeFechaAux);
		}

		flag = false;

		for (int j = 1; j < tableDobleS.getColumnCount(); j++) {
			flag = false;
			listaDeFechaAux = new ArrayList<LocalDate>();
			for (int i = 0; i < tableDobleS.getRowCount(); i++) {
				if ((tableDobleS.getValueAt(i, j) != null))
					if (tableDobleS.getValueAt(i, j).equals("ocupar")) {
						listaDeFechaAux.add((LocalDate) tableDobleS.getValueAt(i, 0));
						flag = true;
					} else if (tableDobleS.getValueAt(i, j).equals("ocuparReserva")) {
						listaDeFechaAux.add((LocalDate) tableDobleS.getValueAt(i, 0));
						flag = true;
					}

			}
			if (flag)
				listaDeFecha.add(listaDeFechaAux);
		}

		flag = false;

		for (int j = 1; j < tableFamily.getColumnCount(); j++) {
			flag = false;
			listaDeFechaAux = new ArrayList<LocalDate>();
			for (int i = 0; i < tableFamily.getRowCount(); i++) {
				if ((tableFamily.getValueAt(i, j) != null))
					if (tableFamily.getValueAt(i, j).equals("ocupar")) {

						listaDeFechaAux.add((LocalDate) tableFamily.getValueAt(i, 0));
						flag = true;
					}

			}
			if (flag)
				listaDeFecha.add(listaDeFechaAux);
		}

		flag = false;

		for (int j = 1; j < tableSuit.getColumnCount(); j++) {
			flag = false;
			listaDeFechaAux = new ArrayList<LocalDate>();
			for (int i = 0; i < tableSuit.getRowCount(); i++) {
				if ((tableSuit.getValueAt(i, j) != null))
					if (tableSuit.getValueAt(i, j).equals("ocupar")) {

						listaDeFechaAux.add((LocalDate) tableSuit.getValueAt(i, 0));
						flag = true;
					}

			}
			if (flag)
				listaDeFecha.add(listaDeFechaAux);
		}

		return listaDeFecha;

	}
}