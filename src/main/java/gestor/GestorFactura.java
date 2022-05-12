package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.validator.EmailValidator;

import dao.ConsumoDAO;
import dao.ConsumoDAO_Hibernate;
import dao.FacturaDAO;
import dao.FacturaDAO_Hibernate;
import dominio.Consumo;
import dominio.Estadia;
import dominio.Factura;
import dominio.ItemFactura;
import dominio.ResponsablePago;
import enumClasses.EstadoDeFactura;

public class GestorFactura {

	GestorItemFactura gestorItem = new GestorItemFactura();
	FacturaDAO daoFactura = new FacturaDAO_Hibernate();
	ConsumoDAO daoConsumo = new ConsumoDAO_Hibernate();
	
	public Factura crearFactura(ResponsablePago res, List<Consumo> idBar, List<Consumo> idLavado, List<Consumo> idSauna, List<Consumo> idEstadia, Estadia est, Boolean cuitSeleccionado) {
		List<ItemFactura> detalleFactura = new ArrayList<ItemFactura>(); 
		
		Factura nuevaFactura = new Factura();
		Double montoTotal = 0.0;
	
		Boolean esPersonaResponsable = true; 
		Boolean facturaA = false; 
		
		if (cuitSeleccionado) 
			esPersonaResponsable = esPersona(res.getCuit());
		
		if (esPersonaResponsable) {
			if (res.getPersona().getPosFrenteIVA().toString().equals("IVA Responsable Inscripto"))
				facturaA = true; 
		}else {
			facturaA = true;
		}
		
		
		
		detalleFactura = gestorItem.crearItems(idBar,idSauna,idEstadia,idLavado);
		
		nuevaFactura.setCuit(res.getCuit());
		nuevaFactura.setEstadia(est);
		nuevaFactura.setItems(detalleFactura);
		nuevaFactura.setResponsable(res);
		nuevaFactura.setFechaEmision(LocalDate.now());
		
		
		if (facturaA) {
			nuevaFactura.setTipoDeFactura('A');
			nuevaFactura.setIva(true);
		}
			
		else {
			nuevaFactura.setIva(false);
			nuevaFactura.setTipoDeFactura('B');
		}
		
		
		nuevaFactura.setNotaCredito(null);
		nuevaFactura.setEstado(EstadoDeFactura.PENDIENTE);
		
		
		for (ItemFactura item: detalleFactura) 
			montoTotal += item.getMontoTotal();

			nuevaFactura.setMontoTotal(montoTotal);
		
	
		for (ItemFactura item: detalleFactura) 
			item.setFactura(nuevaFactura);
		
		
		
		daoFactura.guardarFactura(res,nuevaFactura,idBar,idLavado,idSauna,idEstadia);
	
		return nuevaFactura;
		
	}
	
	public boolean esPersona(String cuit) {

		String codigo = cuit.substring(0, 2);
		Integer cod = Integer.parseInt(codigo);

		if (cod == 30 || cod == 33 || cod == 34)
			return false;
		else
			return true;
	}
		
		public List<List<Object>> validarEmpty(JTextField textNumero, JTextField textHora, JLabel lblHora,
				JLabel lblNumero) {
			
			List<Object> listaTextVacios = new ArrayList<Object>();
			List<Object> listaTextNoVacios = new ArrayList<Object>();
			List<Object> listaLabelVacios = new ArrayList<Object>();
			List<Object> listaLabelNoVacios = new ArrayList<Object>();

			List<List<Object>> listRetorno = new ArrayList<>();

			if (textNumero.getText().isEmpty()) {
				listaTextVacios.add(textNumero);
				listaLabelVacios.add(lblNumero);
			} else {
				listaTextNoVacios.add(textNumero);
				listaLabelNoVacios.add(lblNumero);
			}

			if (textHora.getText().isEmpty()) {
				listaTextVacios.add(textHora);
				listaLabelVacios.add(lblHora);
			} else {
				listaTextNoVacios.add(textHora);
				listaLabelNoVacios.add(lblHora);
			}

			
			listRetorno.add(listaTextVacios);
			listRetorno.add(listaTextNoVacios);
			listRetorno.add(listaLabelVacios);
			listRetorno.add(listaLabelNoVacios);

			return listRetorno;


	}
		
		
	
	}

	
