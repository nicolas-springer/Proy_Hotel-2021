package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import dominio.Localidad;
import dominio.Provincia;
import util.ConnectionBD;

public class LocalidadDAO_Hibernate implements LocalidadDAO {

	private static EntityManager manager;
	
	ProvinciaDAO provinciaDAO = new ProvinciaDAO_Hibernate();
	

	public List<Localidad> getLocalidades() {

		manager = ConnectionBD.conectar();
		
		try{
			
			CriteriaBuilder builder = manager.getCriteriaBuilder();
		    CriteriaQuery<Localidad> criteria = builder.createQuery(Localidad.class);
		    criteria.from(Localidad.class);
		    List<Localidad> localidades = manager.createQuery(criteria).getResultList();
		
			return localidades;
			
		}
		finally {
			
			
		}

	}
	
	public List<Localidad> getLocalidades(String nombreProvincia){
		
		Integer idProvincia = provinciaDAO.getId(nombreProvincia);
		
		System.out.println(idProvincia);
		manager = ConnectionBD.conectar();
	
		return manager.
				createQuery("SELECT l FROM localidad l Where id_provincia ='" + idProvincia + "'", Localidad.class).getResultList(); 

	}

}
