package gestor;

import java.util.List;

import dao.LocalidadDAO;
import dao.LocalidadDAO_Hibernate;
import dominio.Localidad;

public class GestorLocalidad {

	LocalidadDAO daoLocalidad = new LocalidadDAO_Hibernate();

	public List<Localidad> getLocalidades(String nombre) {
		
		return daoLocalidad.getLocalidades(nombre);
	}
	
}
