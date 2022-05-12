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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import dominio.Estadia;
import dominio.Habitacion;
import dominio.Pasajero;
import gestor.GestorEstadia;
import gestor.GestorPasajero;


@SuppressWarnings("serial")
public class CargarPasajeros extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int fila;
	int columna;
	Boolean flag = false;

	GestorPasajero gestorPasajero = new GestorPasajero();
	GestorEstadia gestorEstadia = new GestorEstadia();

	public CargarPasajeros(Pasajero pasajero, Boolean responsable, List<Habitacion> habitaciones,
			List<List<LocalDate>> fechas, int num, Estadia nuevaEstadia) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 898, 497);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setTitle("Cargar Pasajeros");
		setResizable(false);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);
		panelCentral.setBackground(new Color(102, 204, 255));

		JButton btnSeguir = new JButton("Seguir cargando");
		btnSeguir.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnSeguir.setBackground(Color.WHITE);
		btnSeguir.setBounds(700, 405, 150, 32);
		panelCentral.add(btnSeguir);

		JButton btnOcuparOtraHabitacion = new JButton("Ocupar otra habitacion");
		btnOcuparOtraHabitacion.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnOcuparOtraHabitacion.setBackground(Color.WHITE);
		btnOcuparOtraHabitacion.setBounds(443, 405, 200, 32);
		panelCentral.add(btnOcuparOtraHabitacion);
		btnOcuparOtraHabitacion.setEnabled(false);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(231, 405, 150, 32);
		btnEliminar.setEnabled(false);
		panelCentral.add(btnEliminar);

		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnFinalizar.setBackground(Color.WHITE);
		btnFinalizar.setBounds(25, 405, 150, 32);
		panelCentral.add(btnFinalizar);

		btnFinalizar.setEnabled(false);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 35, 615, 333);
		scrollPane.setBackground(new Color(255, 255, 255));
		panelCentral.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Tipo de pasajero" }));

		scrollPane.setViewportView(table);

		gestorPasajero.ingresarATablaResultados(pasajero, table, responsable, nuevaEstadia);

		if (habitaciones.size() == 1 && verificarSiHayResponsable(table)) {
			btnFinalizar.setEnabled(true);
			btnOcuparOtraHabitacion.setEnabled(false);
		}

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				columna = table.getSelectedColumn();
				fila = table.getSelectedRow();
				btnEliminar.setEnabled(true);

			}
		});
		int numero = num;

		btnSeguir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				OcuparHabitacion oc = new OcuparHabitacion(habitaciones, fechas, numero, nuevaEstadia, false);
				oc.setVisible(true);

				dispose();
			}

		});

		if (verificarSiHayResponsable(table))
			btnOcuparOtraHabitacion.setEnabled(true);

		btnOcuparOtraHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (verificarSiHayResponsable(table)) {
					habitaciones.remove(0);
					fechas.remove(0);

				}

				gestorEstadia.guardarEstadia(nuevaEstadia);

				Estadia est = null;
				OcuparHabitacion oc = new OcuparHabitacion(habitaciones, fechas, numero, est, true);
				oc.setVisible(true);
				dispose();
			}

		});

		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getValueAt(fila, columna).equals("Responsable"))
					btnOcuparOtraHabitacion.setEnabled(false);

				gestorPasajero.eliminarDeTabla(fila, columna, table);

				nuevaEstadia.getOcupaciones().remove(fila);

			}

		});

		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gestorEstadia.guardarEstadia(nuevaEstadia);

				GestionarHabitacion ventanaGH = new GestionarHabitacion();

				ventanaGH.setVisible(true);

				dispose();

			}

		});

	}

	private boolean verificarSiHayResponsable(JTable table) {

		for (int j = 0; j < table.getColumnCount(); j++)
			for (int i = 0; i < table.getRowCount(); i++)
				if ((table.getValueAt(i, j) != null))
					if (table.getValueAt(i, j).equals("Responsable"))
						return true;

		return false;
	}

}
