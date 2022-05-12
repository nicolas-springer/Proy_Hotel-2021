package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dominio.Estadia;
import dominio.ResponsablePago;
import dto.BusquedaPasajeroDTO;
import gestor.GestorEstadia;

public class SeleccionarEstadias extends JFrame {

	private JPanel contentPane;
	private JTable table;
	String num; 
	Estadia estadia;
	List <Estadia> listaDeEstadias = new ArrayList<Estadia>();
	
	
	
	public SeleccionarEstadias(String numeroH) {
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Seleccionar Estadias");

		
		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);


	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	});
	scrollPane.setBounds(315, 44, 619, 478);
	scrollPane.setBackground(new Color(255, 255, 255));
	panelCentral.add(scrollPane);
	
	
	table = new JTable();
	table.setBackground(new Color(255, 255, 255));
	table.setModel(new DefaultTableModel(new Object[][] {},
			new String[] { "Numero de estadia","Fecha inicio", "Fecha fin"}));
	
	scrollPane.setViewportView(table);

	GestorEstadia gEstadia = new GestorEstadia();

	listaDeEstadias = gEstadia.recuperarEstadias(Integer.parseInt(numeroH));
	
	ingresarATablaResultados(listaDeEstadias,table);
	

	
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {

			int seleccionar = table.rowAtPoint(e.getPoint());
			num = (String) table.getValueAt(seleccionar, 0).toString();
			
			estadia = listaDeEstadias.get(0);
			for (Estadia es: listaDeEstadias)
				if(es.getIdEstadia()==Integer.parseInt(num))
					estadia = es ; 
		}
	});
	
	
	JButton btnConfirmar = new JButton("Confirmar");
	btnConfirmar.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnConfirmar.setBackground(Color.WHITE);
	btnConfirmar.setBounds(1003, 602, 200, 32);
	panelCentral.add(btnConfirmar);
	
	JButton btnAtras = new JButton("Atras");
	btnAtras.setFont(new Font("Dialog", Font.PLAIN, 15));
	btnAtras.setBackground(Color.WHITE);
	btnAtras.setBounds(49, 602, 200, 32);
	panelCentral.add(btnAtras);
	
	
	btnConfirmar.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ResponsablePago responsable = new ResponsablePago();
			Facturar ventanaFacturar = new Facturar(estadia,responsable);
			ventanaFacturar.setVisible(true);
			dispose();
			
		}
	});
	
	btnAtras.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			ResponsablePago responsable = new ResponsablePago();
			Estadia es= new Estadia();
			Facturar ventanaFacturar = new Facturar(es,responsable);
			ventanaFacturar.setVisible(true);
			dispose();
			
		}
	});

}
	
	public void ingresarATablaResultados(List<Estadia> listaCoincidencias, JTable table) {

		ArrayList<Object[]> datos = new ArrayList<>();

		for (int j = 0; j < listaCoincidencias.size(); j++) {
			Object[] filas = new Object[3];
			filas[0] = listaCoincidencias.get(j).getIdEstadia();
			filas[1] = listaCoincidencias.get(j).getFechaInicio();
			filas[2] = listaCoincidencias.get(j).getFechaFin();
			datos.add(filas);
		}
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		for (int i = 0; i < datos.size(); i++) {
			dtm.addRow(datos.get(i));
		}
	}
}
