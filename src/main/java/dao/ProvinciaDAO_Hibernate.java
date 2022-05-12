package dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import util.ConnectionBD;
import dominio.Localidad;
import dominio.Provincia;


public class ProvinciaDAO_Hibernate implements ProvinciaDAO{

	private static EntityManager manager;
	
		
		public List<Provincia> getProvincias(Integer idPais) {
			
			manager = ConnectionBD.conectar();
			
			try{
		
				List<Provincia> provincias = manager.createQuery(
						 "SELECT p FROM provincia p where id_pais ='"+idPais+"' ", Provincia.class ).getResultList();
						 
			
				return provincias;
				
			}
			finally {
				
				
			}
			
			
		}
		
		
		public Integer getId(String nombre) {
			
			manager = ConnectionBD.conectar();
			
			List<Provincia> idProvincia = (List<Provincia>) manager
					.createQuery("SELECT p FROM provincia p WHERE nombre ='"+nombre+"'",Provincia.class).getResultList();


			return idProvincia.get(0).getIdProvincia();
			
		}
		
			
			
			
}
