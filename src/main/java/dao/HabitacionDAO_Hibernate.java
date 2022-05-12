package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Habitacion;
import util.ConnectionBD;

public class HabitacionDAO_Hibernate implements HabitacionDAO {

	private static EntityManager manager;

	public Habitacion recuperarHabitacion(Integer num) {

		manager = ConnectionBD.conectar();
		
		return manager.createQuery("SELECT h FROM habitacion h WHERE numero = '" + num + "' ", Habitacion.class).getSingleResult();
		
		
	}

}