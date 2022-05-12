package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTabbedPane;

import javax.swing.border.EmptyBorder;

import dominio.Consumo;
import dominio.Estadia;
import dominio.Factura;
import dominio.ItemFactura;
import dominio.ResponsablePago;
import gestor.GestorConsumo;
import gestor.GestorFactura;
import jasper.FacturaDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;

public class Gastos extends JFrame {

	private JPanel contentPane;
	private JTextField textEstadia;
	private JTextField textBar;
	private JTextField textSauna;
	private JTextField textLavado;
	private JTextField textTotal;

	Double precioBar, precioLavado, precioSauna, precioEstadia;

	GestorConsumo gestorConsumo = new GestorConsumo();
	GestorFactura gestorFactura = new GestorFactura();

	List<Consumo> idBar = new ArrayList<Consumo>();
	List<Consumo> idSauna = new ArrayList<Consumo>();
	List<Consumo> idLavado = new ArrayList<Consumo>();
	List<Consumo> idEstadia = new ArrayList<Consumo>();

	Boolean existenConsumos = false;

	JasperReport report;
	JasperPrint jprint;

	Gastos(Estadia est, ResponsablePago res, boolean cuitSeleccionado) {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 1280, 720);
		setResizable(false);
		setTitle("Seleccionar Gastos");

		JPanel panelCentral = new JPanel();
		panelCentral.setBackground(new Color(102, 204, 255));
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		JTabbedPane pestañas = new JTabbedPane();
		pestañas.setBounds(53, 47, 1127, 357);
		pestañas.setBackground(Color.WHITE);

		pestañas.setFont(new Font("Dialog", Font.PLAIN, 15));
		panelCentral.add(pestañas);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTotal.setBounds(1027, 430, 97, 23);
		panelCentral.add(lblTotal);

		textTotal = new JTextField("0");
		textTotal.setFont(new Font("Dialog", Font.PLAIN, 15));
		textTotal.setColumns(10);
		textTotal.setBounds(1093, 431, 87, 20);
		panelCentral.add(textTotal);

		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnFacturar.setBounds(1024, 544, 141, 41);
		panelCentral.add(btnFacturar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Dialog", Font.PLAIN, 15));
		btnVolver.setBounds(53, 544, 141, 41);
		panelCentral.add(btnVolver);

		List<Consumo> listaConsumos = new ArrayList<Consumo>();

		listaConsumos = gestorConsumo.recuperarConsumos(est);
		Boolean flag = false;

		for (Consumo c : listaConsumos)
			if (c.getTipo().getId_tipoconsumo() == 4)
				flag = true;

		if (!flag) {
			for (LocalDate date = est.getFechaInicio(); (date.isBefore(est.getFechaFin())
					|| date.isEqual(est.getFechaFin())); date = date.plusDays(1))
				gestorConsumo.crearConsumoParaEstadia(est, date);

			listaConsumos = gestorConsumo.recuperarConsumos(est);
		}

		for (Consumo c : listaConsumos)
			if (!c.getFacturado())
				existenConsumos = true;

		for (LocalDate date = est.getFechaInicio(); (date.isBefore(est.getFechaFin())
				|| date.isEqual(est.getFechaFin())); date = date.plusDays(1))
			pestañas.add(date.toString(), crearPanel(listaConsumos, date, est));

		btnVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				GestionarFactura vGF = new GestionarFactura();
				vGF.setVisible(true);
				dispose();

			}
		});

		List<Consumo> listaConsumosSeleccionado = new ArrayList<Consumo>();

		btnFacturar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!existenConsumos) {
					int seleccion = JOptionPane.showOptionDialog(new JPanel(), "No existen mas consumos para facturar.",
							"AVISO", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, // null para
																											// icono
																											// por
																											// defecto.
							new Object[] { "ACEPTAR", "CANCELAR" }, // null para YES, NO y CANCEL
							"ACEPTAR");

					if (seleccion == 0) {
						final Facturar ventanaNR = new Facturar(est, res);
						ventanaNR.setVisible(true);
						dispose();
					}

				} else {

					Factura factura = gestorFactura.crearFactura(res, idBar, idLavado, idSauna, idEstadia, est,
							cuitSeleccionado);

					imprimirFactura(factura, res, cuitSeleccionado);

					final Facturar ventanaNR = new Facturar(est, res);
					ventanaNR.setVisible(true);
					dispose();

				}

			}

		});

	}

	private void imprimirFactura(Factura factura, ResponsablePago res, boolean cuitSeleccionado) {

		Map<String, Object> parametros = new HashMap<String, Object>();

		Boolean esPersonaResponsable = true;
		Boolean facturaA = false;

		if (cuitSeleccionado)
			esPersonaResponsable = esPersona(res.getCuit());

		if (esPersonaResponsable) {
			if (res.getPersona().getPosFrenteIVA().toString().equals("IVA Responsable Inscripto"))
				facturaA = true;
		} else {
			facturaA = true;
		}

		parametros.put("nroFactura", factura.getIdFactura().toString());

		if (esPersonaResponsable) {

			parametros.put("nomCompletoCliente", factura.getResponsable().getPersona().getApellido()
					+ factura.getResponsable().getPersona().getNombre());
			parametros.put("dni", factura.getResponsable().getPersona().getNumeroDocumento().toString());
			parametros.put("direccion", factura.getResponsable().getPersona().getDireccion().getCalle()
					+ factura.getResponsable().getPersona().getDireccion().getNumero().toString());
			parametros.put("telefono", factura.getResponsable().getPersona().getTelefono().toString());
			parametros.put("email", factura.getResponsable().getPersona().getCorreoElectronico());

			if (!cuitSeleccionado)
				parametros.put("cuit", "-");
			else
				parametros.put("cuit", factura.getResponsable().getPersona().getCuit().toString());
		}

		else {
			parametros.put("nomCompletoCliente", factura.getResponsable().getRazonSocial().toString());
			parametros.put("dni", "-");
			parametros.put("direccion", factura.getResponsable().getDireccion().getCalle()
					+ factura.getResponsable().getDireccion().getNumero().toString());
			parametros.put("cuit", factura.getResponsable().getCuit().toString());
			parametros.put("telefono", factura.getResponsable().getTelefono().toString());
			parametros.put("email", factura.getResponsable().getEmail());

		}

		if (facturaA) {
			parametros.put("tipoFactura", "A");
			parametros.put("totParcial", factura.getMontoTotal().toString());
			Double total = factura.getMontoTotal() * 1.21;
			parametros.put("totalFactura", total.toString());
			parametros.put("iva", "21%");
		}

		else {
			parametros.put("tipoFactura", "B");
			parametros.put("totParcial", factura.getMontoTotal().toString());
			parametros.put("totalFactura", factura.getMontoTotal().toString());
			parametros.put("iva", "-");
		}

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

		for (ItemFactura item : factura.getItems()) {

			ArrayList<String> aux = new ArrayList<String>();
			aux.add(item.getTipoConsumo().getDescripcionConsumo());
			aux.add("-");
			aux.add(item.getMontoTotal().toString());
			list.add(aux);

		}

		Object[][] matriz = new Object[4][3];

		int i = 0;
		int j = 0;

		for (ArrayList<String> listaExterna : list) {
			j = 0;
			for (String interna : listaExterna) {
				matriz[i][j] = interna;
				j++;
			}
			i++;
		}

		try {
			JasperReport report;
			report = (JasperReport) JRLoader.loadObjectFromFile(
					"C:\\Users\\Intel\\Desktop\\Nico\\ISI\\3ro\\Diseño de sistemas\\HotelPremier\\TP-DS\\src\\main\\java\\jasper\\FacturaA.jasper");
			jprint = JasperFillManager.fillReport(report, parametros, FacturaDataSource.getDataSource(matriz));
			JasperViewer view = new JasperViewer(jprint, false);
			view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			view.setVisible(true);
			
			// 1. Create exporter instance
			JRPdfExporter exporter = new JRPdfExporter();

			// 2. Set exporter input document
			exporter.setExporterInput(new SimpleExporterInput(jprint));

			// 3. Set file path for exporter output
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("C:\\Users\\Intel\\Desktop\\factura " + "'" + factura.getIdFactura() + "'.pdf"));

			// 4. Create configuration instance
			SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();

			// 5. Associate configuration with exporter
			exporter.setConfiguration(configuration);

			// 6. Fill export and write to file path
			exporter.exportReport();
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	public JPanel crearPanel(List<Consumo> listaConsumos, LocalDate fecha, Estadia est) {

		JPanel nuevo = new JPanel();

		nuevo.setLayout(null);

		JCheckBox chckbxEstadia = new JCheckBox("Valor Estadia");
		chckbxEstadia.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxEstadia.setBounds(64, 46, 138, 23);
		nuevo.add(chckbxEstadia);

		JCheckBox chckbxBar = new JCheckBox("Bar");
		chckbxBar.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxBar.setBounds(64, 88, 138, 23);
		nuevo.add(chckbxBar);

		JCheckBox chckbxSauna = new JCheckBox("Sauna");
		chckbxSauna.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxSauna.setBounds(64, 127, 138, 23);
		nuevo.add(chckbxSauna);

		JCheckBox chckbxLavado = new JCheckBox("Lavado/Planchado");
		chckbxLavado.setFont(new Font("Dialog", Font.PLAIN, 15));
		chckbxLavado.setBounds(64, 170, 169, 23);
		nuevo.add(chckbxLavado);

	
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblPrecio.setBounds(410, 11, 97, 23);
		nuevo.add(lblPrecio);

		
		textEstadia = new JTextField("0");
		textEstadia.setFont(new Font("Dialog", Font.PLAIN, 15));
		textEstadia.setBounds(410, 49, 87, 20);
		nuevo.add(textEstadia);
		textEstadia.setColumns(10);

		textBar = new JTextField("0");
		textBar.setFont(new Font("Dialog", Font.PLAIN, 15));
		textBar.setColumns(10);
		textBar.setBounds(410, 88, 87, 20);
		nuevo.add(textBar);

		textSauna = new JTextField("0");
		textSauna.setFont(new Font("Dialog", Font.PLAIN, 15));
		textSauna.setColumns(10);
		textSauna.setBounds(410, 130, 87, 20);
		nuevo.add(textSauna);

		textLavado = new JTextField("0");
		textLavado.setFont(new Font("Dialog", Font.PLAIN, 15));
		textLavado.setColumns(10);
		textLavado.setBounds(410, 173, 87, 20);
		nuevo.add(textLavado);

		JLabel lblTotalAFacturar = new JLabel("Total a facturar:");
		lblTotalAFacturar.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblTotalAFacturar.setBounds(54, 451, 156, 23);

		precioBar = Double.parseDouble(textBar.getText());
		precioSauna = Double.parseDouble(textSauna.getText());
		precioLavado = Double.parseDouble(textLavado.getText());
		precioEstadia = Double.parseDouble(textEstadia.getText());

		for (Consumo c : listaConsumos)
			if (c.getFechaFacturacion().isEqual(fecha)) {
				if (!c.getFacturado()) {
					if (c.getTipo().getId_tipoconsumo() == 1) {
						precioLavado += (c.getPrecioUnitario() * c.getCantidad());
						textLavado.setText(String.valueOf(precioLavado));
						idLavado.add(c);
					}

					if (c.getTipo().getId_tipoconsumo() == 2) {
						precioSauna += (c.getPrecioUnitario() * c.getCantidad());
						textSauna.setText(String.valueOf(precioSauna));
						idSauna.add(c);
					}

					if (c.getTipo().getId_tipoconsumo() == 3) {
						precioBar += (c.getPrecioUnitario() * c.getCantidad());
						textBar.setText(String.valueOf(precioBar));
						idBar.add(c);
					}

					if (c.getTipo().getId_tipoconsumo() == 4) {
						precioEstadia += (c.getPrecioUnitario() * c.getCantidad());
						textEstadia.setText(String.valueOf(precioEstadia));
						idEstadia.add(c);
					}

				}
			}

		chckbxBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Double aux = Double.parseDouble(textTotal.getText());
				if (chckbxBar.isSelected()) {
					for (Consumo c : idBar)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux += (c.getPrecioUnitario() * c.getCantidad());

					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idBar, true, fecha);
				}

				else {
					for (Consumo c : idBar)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux -= (c.getPrecioUnitario() * c.getCantidad());
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idBar, false, fecha);
				}
			}
		});

		chckbxSauna.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Double aux = Double.parseDouble(textTotal.getText());
				if (chckbxSauna.isSelected()) {
					for (Consumo c : idSauna)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux += (c.getPrecioUnitario() * c.getCantidad());
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idSauna, true, fecha);
				}

				else {
					for (Consumo c : idSauna)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux -= (c.getPrecioUnitario() * c.getCantidad());
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idSauna, false, fecha);
				}
			}
		});

		chckbxLavado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Double aux = Double.parseDouble(textTotal.getText());
				if (chckbxLavado.isSelected()) {
					for (Consumo c : idLavado)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux += (c.getPrecioUnitario() * c.getCantidad());
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idLavado, true, fecha);
				}

				else {
					for (Consumo c : idLavado)
						if (c.getFechaFacturacion().isEqual(fecha))
							aux -= (c.getPrecioUnitario() * c.getCantidad());
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idLavado, false, fecha);
				}
			}
		});

		chckbxEstadia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Double aux = Double.parseDouble(textTotal.getText());
				if (chckbxEstadia.isSelected()) {
					aux += Double.parseDouble(gestorConsumo.recuperarPrecioEstadia(est));
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idEstadia, true, fecha);
				}

				else {
					aux -= Double.parseDouble(gestorConsumo.recuperarPrecioEstadia(est));
					textTotal.setText(aux.toString());
					gestorConsumo.cambiarFacturado(idEstadia, false, fecha);
				}
			}
		});

		return nuevo;

	}
}
