package gestor;

import java.util.List;

import dao.ProvinciaDAO;
import dao.ProvinciaDAO_Hibernate;
import dominio.Provincia;

public class GestorProvincia {

	
	ProvinciaDAO daoProvincia = new ProvinciaDAO_Hibernate();

	public List<Provincia> getProvincias(int idPais) {
		
		return daoProvincia.getProvincias(idPais);
	}

	public List<Provincia> obtenerProvincias(String nombrePais) {
		// TODO Auto-generated method stub
		return null;
	}
}
