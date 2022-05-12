package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Pasajero;
import dominio.Persona;
import util.ConnectionBD;

public class PasajeroDAO_Hibernate implements PasajeroDAO{
	
	private static EntityManager manager;

	DireccionDAO daoDireccion = new DireccionDAO_Hibernate();
	PersonaDAO daoPersona = new PersonaDAO_Hibernate();
	
	public void guardarPasajero(Pasajero pasajero) {
	
		manager = ConnectionBD.conectar();
		try {
		manager.getTransaction().begin();
		daoDireccion.guardarDireccion(pasajero.getPersona().getDireccion());
		daoPersona.guardarPersona(pasajero.getPersona());
		manager.persist(pasajero);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}

	}


	public Pasajero obtenerPasajero(Integer id) {
		
		manager = ConnectionBD.conectar();
		
		return manager
				.createQuery("SELECT p FROM pasajero p WHERE idpersona = '"+id+"'",Pasajero.class).getSingleResult();
		
		
	}


	@Override
	public List<Pasajero> obtenerPasajeros() {
		
		manager = ConnectionBD.conectar();
		
		return manager
				.createQuery("SELECT p FROM pasajero p ",Pasajero.class).getResultList();
		
	}

}