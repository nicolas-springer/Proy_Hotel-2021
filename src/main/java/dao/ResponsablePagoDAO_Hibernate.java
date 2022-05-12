package dao;


import java.util.List;

import javax.persistence.EntityManager;

import dominio.Persona;
import dominio.ResponsablePago;
import util.ConnectionBD;

public class ResponsablePagoDAO_Hibernate implements ResponsablePagoDAO{
	
	private static EntityManager manager;
	
	DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();
	
	public List<ResponsablePago> recuperarResponsable(String cuit) {
	
			manager = ConnectionBD.conectar();
			
			List<ResponsablePago>responsables =  manager 
					.createQuery("SELECT r FROM responsablepago r WHERE cuit like '"+cuit +"'", ResponsablePago.class).getResultList();
			
		
				return responsables;}
	
	

	public void guardarResponsable(ResponsablePago responsable) {
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		daoDireccion.guardarDireccion(responsable.getPersona().getDireccion());
		daoPersona.guardarPersona(responsable.getPersona());
		manager.persist(responsable);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}
	

	public void guardarResponsablePago(ResponsablePago responsable) {
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		daoDireccion.guardarDireccion(responsable.getDireccion());
		manager.persist(responsable);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
	}




	


}


//