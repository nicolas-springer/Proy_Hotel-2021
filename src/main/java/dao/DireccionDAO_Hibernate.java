package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Direccion;
import util.ConnectionBD;

public class DireccionDAO_Hibernate implements DireccionDAO {

	private static EntityManager manager;

	public void guardarDireccion(Direccion direccion) {

		manager = ConnectionBD.conectar();
		
		try {
			manager.getTransaction().begin();
			manager.persist(direccion);

			// manager.flush();
			// manager.refresh(persona);
			manager.getTransaction().commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			manager.close();
		}

	}
}
