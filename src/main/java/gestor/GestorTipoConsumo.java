package gestor;

import dao.TipoEstadiaDAO;
import dao.TipoEstadiaDAO_Hibernate;
import dominio.TipoConsumo;

public class GestorTipoConsumo {
	
	TipoEstadiaDAO daoTipo = new TipoEstadiaDAO_Hibernate();
	

	public TipoConsumo getTipoEstadia() {
		
		return daoTipo.getTipoEstadua();
		
		
	}

}
