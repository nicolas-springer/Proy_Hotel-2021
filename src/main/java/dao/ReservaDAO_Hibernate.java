package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Consumo;
import dominio.Estadia;
import dominio.Habitacion;
import dominio.Reserva;
import util.ConnectionBD;

public class ReservaDAO_Hibernate implements ReservaDAO{

	private static EntityManager manager;

	public List<Reserva> recuperarHabitaciones (LocalDate inicio, LocalDate fin){

		//Timestamp ini = Timestamp.valueOf(inicio.toString());
		//Timestamp fi = Timestamp.valueOf(fin.toString());
		
	    manager = ConnectionBD.conectar();

	    List <Reserva> reservasOcupadas =manager.createQuery("SELECT r FROM reserva r WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' "
	            + "OR fechafin  BETWEEN '"+inicio+"' AND  '"+fin+"'", Reserva.class).getResultList();

	   // List <Estadia> estadiasOcupadas =manager.createQuery("SELECT e FROM estadia e WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' ", Estadia.class).getResultList();
	           


	        return reservasOcupadas;
	    }

	@Override
	public List<Integer> verificarReserva(Habitacion habitacion) {
		manager = ConnectionBD.conectar();
		
		List<Integer> listaIdsReserva = new ArrayList<Integer>();
		
		
		String consulta = "select reservaid from habitacionreserva where habitacionid =:sId";
		
		try {
			manager.getTransaction().begin();
		
			Query query2 = manager.createNativeQuery(consulta);
			query2.setParameter("sId", habitacion.getIdHabitacion());
			listaIdsReserva = query2.getResultList();
		
			manager.getTransaction().commit();
			} catch (Exception e) {
				 
				e.printStackTrace();
				}finally {
				manager.close();
				}
		
		//listaIdsReserva.add(1);
		
	return listaIdsReserva;
		
	}

	public void eliminarReserva(Reserva r) {
		
		manager = ConnectionBD.conectar();
	
			
		
		String consulta = "DELETE from habitacionreserva where reservaid =:sId";
		
		String consulta2 = "DELETE from reserva where idreserva =:sId";
		
		try {
			manager.getTransaction().begin();
		
			Query query2 = manager.createNativeQuery(consulta);
			Query query = manager.createNativeQuery(consulta2);
			query2.setParameter("sId", r.getIdReserva());
			query2.executeUpdate();
		
			query.setParameter("sId", r.getIdReserva());
			query.executeUpdate();
		
			
			manager.getTransaction().commit();
			} catch (Exception e) {
				 
				e.printStackTrace();
				}finally {
				manager.close();
				}
		
	}
}
