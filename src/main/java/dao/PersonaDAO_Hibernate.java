package dao;

import java.util.List;

import javax.persistence.EntityManager;


import dominio.Persona;
import util.ConnectionBD;


public class PersonaDAO_Hibernate implements PersonaDAO{
	
	private static EntityManager manager;

	
	public void guardarPersona(Persona persona) {
	
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		manager.persist(persona);
		//manager.flush();
		//manager.refresh(persona);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
	}

}
	
	public List<Persona> recuperarPersonaBusqueda (String nombre, String apellido, String nroDoc, String tipoDoc){
		
		manager = ConnectionBD.conectar();
		
		
		return (List<Persona>) manager
				.createQuery("SELECT p FROM persona p WHERE nombre like '"+nombre+"%' AND apellido like '"+apellido+"%' AND cast(numerodocumento as text) like '"+nroDoc+"%' AND tipodocumento = '"+tipoDoc+"'",Persona.class).getResultList();
		
	
					
	}
	
	public Boolean buscarDni(Integer dni) {
		
		manager = ConnectionBD.conectar();
		
		List<Persona> p =  manager
			.createQuery("SELECT p FROM persona p WHERE numerodocumento = '"+dni+"' ",Persona.class).getResultList();
	
		if(p.size() == 0) return false;
		else return true;
		
	}

}
