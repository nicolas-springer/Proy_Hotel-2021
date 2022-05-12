package gestor;

import java.util.List;

import dao.PaisDAO;
import dao.PaisDAO_Hibernate;
import dominio.Pais;

public class GestorPais {

	PaisDAO daoPais = new PaisDAO_Hibernate();

	public List<Pais> getPaises() {
	
		
		return daoPais.getPais();
	}
	
}
