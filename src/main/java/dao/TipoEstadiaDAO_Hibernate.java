package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import dominio.TipoConsumo;
import util.ConnectionBD;

public class TipoEstadiaDAO_Hibernate implements TipoEstadiaDAO{

	private static EntityManager manager;
	
	public TipoConsumo getTipoEstadua() {
	
		 manager = ConnectionBD.conectar();
		 
		 Integer numero = 4; 
		 
		 List<TipoConsumo> lista = new ArrayList<TipoConsumo>();
		 
		lista = manager
					.createQuery("SELECT t FROM tipoconsumo t WHERE id_tipoconsumo ='"+numero+"'", TipoConsumo.class).getResultList();
		
		return lista.get(0);
	}
	

}
