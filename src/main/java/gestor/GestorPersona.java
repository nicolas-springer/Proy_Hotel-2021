package gestor;


import java.util.List;
import dao.PersonaDAO;
import dao.PersonaDAO_Hibernate;
import dominio.Direccion;
import dominio.Pais;
import dominio.Persona;
import dto.BusquedaPasajeroDTO;
import dto.PasajeroDTO;

public class GestorPersona {

	PersonaDAO daoPersona = new PersonaDAO_Hibernate();

	public Persona darDeAltaPersona(PasajeroDTO pasajeroDTO, Pais nacionalidad) {

		GestorDireccion gestorDireccion = new GestorDireccion();
		Direccion direccion = gestorDireccion.generarDireccion(pasajeroDTO.getCalle(), pasajeroDTO.getNumeroCalle(),
				pasajeroDTO.getDepartamento(), pasajeroDTO.getPiso(), pasajeroDTO.getLocalidad());

		Persona persona = new Persona();
		persona.inicializarPersona(pasajeroDTO, direccion, nacionalidad);

		return persona;
	}


	
	public List<Persona> recuperarPasajeros(BusquedaPasajeroDTO pasajeroBusqueda) {

		return daoPersona.recuperarPersonaBusqueda(pasajeroBusqueda.getNombre(), pasajeroBusqueda.getApellido(),
				pasajeroBusqueda.getNumeroDeDocumento(), pasajeroBusqueda.getTipoDeDocumento());

	}
	
	public Boolean buscarDNI (Integer dni) {
		
		return daoPersona.buscarDni(dni);
	}

}
