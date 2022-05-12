package gestor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.validator.EmailValidator;

import dao.ResponsablePagoDAO;
import dao.ResponsablePagoDAO_Hibernate;
import dominio.Direccion;
import dominio.Pais;
import dominio.Pasajero;
import dominio.Persona;
import dominio.ResponsablePago;
import dto.EmpresaDTO;
import dto.PasajeroDTO;

public class GestorResponsablePago {

	GestorPersona gestorPersona = new GestorPersona();
	GestorDireccion gestorDireccion = new GestorDireccion();
	
	ResponsablePagoDAO daoResponsable = new ResponsablePagoDAO_Hibernate();
	
	public boolean validarCuit(String cuit){
	    
	    if (cuit.length() != 13) return false;
		
		boolean rv = false;
		int resultado = 0;
		String cuit_nro = cuit.replace("-", "");
		String codes = "6789456789";
		int verificador = Character.getNumericValue(cuit_nro.charAt(cuit_nro.length() - 1));
		int x = 0;
			
		while (x < 10)
		{
			int digitoValidador = Integer.parseInt(codes.substring(x, x+1));
			int digito = Integer.parseInt(cuit_nro.substring(x, x+1));
			int digitoValidacion = digitoValidador * digito;
			resultado += digitoValidacion;
			x++;
		}
		resultado = resultado % 11;
		rv = (resultado == verificador);
		return rv;    
	}
	
	
	public List<ResponsablePago> verificar(String cuit) {
		
	
		
		return daoResponsable.recuperarResponsable(cuit);
		
		
	}


	public ResponsablePago darDeAltaResponsable(PasajeroDTO pasajero, Pais nacionalidad) {
	
		Persona persona = gestorPersona.darDeAltaPersona(pasajero, nacionalidad);
		
		ResponsablePago responsable = new ResponsablePago();
		
		responsable.setPersona(persona);
		responsable.setCuit(persona.getCuit());
		
		daoResponsable.guardarResponsable(responsable);
		
		return responsable;
	}


	public List<List<Object>> validarEmpty(JTextField textRazonSocial, JTextField textTelefono, JTextField textEmail,
			JTextField textCalle, JTextField textNum, JTextField textCuit, JLabel lblCuit, JLabel lblRazonSocial,
			JLabel lblTelefono, JLabel lblEmail, JLabel lblCalle, JLabel lblNum) {
	
		List<Object> listaTextVacios = new ArrayList<Object>();
		List<Object> listaTextNoVacios = new ArrayList<Object>();
		List<Object> listaLabelVacios = new ArrayList<Object>();
		List<Object> listaLabelNoVacios = new ArrayList<Object>();

		List<List<Object>> listRetorno = new ArrayList<>();

		if (textRazonSocial.getText().isEmpty()) {
			listaTextVacios.add(textRazonSocial);
			listaLabelVacios.add(lblRazonSocial);
		} else {
			listaTextNoVacios.add(textRazonSocial);
			listaLabelNoVacios.add(lblRazonSocial);
		}

		

		if (textTelefono.getText().isEmpty()) {
			listaTextVacios.add(textTelefono);
			listaLabelVacios.add(lblTelefono);
		} else {
			listaTextNoVacios.add(textTelefono);
			listaLabelNoVacios.add(lblTelefono);
		}

		if (textEmail.getText().isEmpty()) {
			listaTextVacios.add(textEmail);
			listaLabelVacios.add(lblEmail);
		} else {
			listaTextNoVacios.add(textEmail);
			listaLabelNoVacios.add(lblEmail);
		}

		if (textCalle.getText().isEmpty()) {
			listaTextVacios.add(textCalle);
			listaLabelVacios.add(lblCalle);
		} else {
			listaTextNoVacios.add(textCalle);
			listaLabelNoVacios.add(lblCalle);
		}

		if (textNum.getText().isEmpty()) {
			listaTextVacios.add(textNum);
			listaLabelVacios.add(lblNum);
		} else {
			listaTextNoVacios.add(textNum);
			listaLabelNoVacios.add(lblNum);
		}

		if (textCuit.getText().isEmpty()) {
			listaTextVacios.add(textCuit);
			listaLabelVacios.add(lblCuit);
		} else {
			listaTextNoVacios.add(textCuit);
			listaLabelNoVacios.add(lblCuit);
		}

		listRetorno.add(listaTextVacios);
		listRetorno.add(listaTextNoVacios);
		listRetorno.add(listaLabelVacios);
		listRetorno.add(listaLabelNoVacios);

		return listRetorno;
		
	}


	public Boolean validarDatos(JTextField textTelefono, JTextField textEmail, JTextField textPiso)  throws Exception {
		
		Boolean dniValido = true, telefonoValido = true, emailValido = true, pisoValido = true;

		String mensaje = "Datos invalidos, revisar: ";


		if (textTelefono.getText().toString().length() != 10) {
			mensaje += "TELEFONO ";
			telefonoValido = false;
		}

		if (!EmailValidator.getInstance().isValid(textEmail.getText().toString())) {
			mensaje += "EMAIL ";
			emailValido = false;
		}

		if (Integer.parseInt(textPiso.getText().toString()) <= 0) {
			mensaje += "PISO ";
			pisoValido = false;
		}

		if (!dniValido || !telefonoValido || !emailValido || !pisoValido) {
			throw new Exception(mensaje);
		} else
			return true;
	}


	public ResponsablePago darDeAltaResponsable(EmpresaDTO empresa) {
		
		ResponsablePago responsable = new ResponsablePago();
		
		responsable = inicializarResponsable(empresa);
		
		daoResponsable.guardarResponsablePago(responsable);
		
		return responsable;
	}


	private ResponsablePago inicializarResponsable(EmpresaDTO empresa) {
		
		ResponsablePago responsable= new ResponsablePago();
		
		Direccion direccion = gestorDireccion.generarDireccion(empresa.getCalle(), empresa.getNumeroCalle(),
				empresa.getDepartamento(), empresa.getPiso(), empresa.getLocalidad());
		
		
		responsable.setCuit(empresa.getCuit());
		responsable.setEmail(empresa.getCorreoElectronico());
		responsable.setRazonSocial(empresa.getRazonSocial());
		responsable.setTelefono(empresa.getTelefono());
		responsable.setDireccion(direccion);
		
		return responsable;
		
	}


	public ResponsablePago crearResponsable(List<Pasajero> listaDePasajeros, String dni) {
		
		ResponsablePago responsable = new ResponsablePago();
		Pasajero p = new Pasajero();
		
		String cuit = "0" ; 
		
		for (Pasajero pasajero: listaDePasajeros)
			if (pasajero.getPersona().getNumeroDocumento().toString().equals(dni)) {
	
				cuit = pasajero.getPersona().getCuit();
				p = pasajero;
			}
				
		
		List<ResponsablePago> lista ; 
		
		lista = verificar(cuit);
		
		if (lista.size()==1)
			return lista.get(0);
		
		else responsable.setPersona(p.getPersona());
			
		
	
		return responsable;
		
	}
	



}
