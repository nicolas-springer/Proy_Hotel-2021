package dao;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import dominio.Estadia;
import dominio.Ocupacion;
import util.ConnectionBD;

public class EstadiaDAO_Hibernate implements EstadiaDAO {

    
    private static EntityManager manager;

public List<Estadia> recuperarHabitaciones (LocalDate inicio, LocalDate fin){

	//Timestamp ini = Timestamp.valueOf(inicio.toString());
	//Timestamp fi = Timestamp.valueOf(fin.toString());
	
    manager = ConnectionBD.conectar();

    List <Estadia> estadiasOcupadas =manager.createQuery("SELECT e FROM estadia e WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' "
            + "OR fechafin  BETWEEN '"+inicio+"' AND  '"+fin+"'", Estadia.class).getResultList();

   // List <Estadia> estadiasOcupadas =manager.createQuery("SELECT e FROM estadia e WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' ", Estadia.class).getResultList();
           


        return estadiasOcupadas;
    }

public List<Estadia> recuperarEstadias(Integer num) {
	
	 manager = ConnectionBD.conectar();
	
	 return  manager.createQuery("SELECT e FROM estadia e WHERE id_habitacion = '"+num+"'", Estadia.class).getResultList();
	
}

@Override
public void guardarEstadia(Estadia nuevaEstadia) {
	
	manager = ConnectionBD.conectar();
	try {
	manager.getTransaction().begin();
	manager.persist(nuevaEstadia);
	manager.getTransaction().commit();
	} catch (Exception e) {
		 
		e.printStackTrace();
		}finally {
		manager.close();
}
	
}


public void guardarOcupacion(List<Ocupacion> ocupaciones) {
	
	manager = ConnectionBD.conectar();
	try {
	manager.getTransaction().begin();
	for(Ocupacion o: ocupaciones)
		manager.persist(o);

	manager.getTransaction().commit();
	} catch (Exception e) {
		 
		e.printStackTrace();
		}finally {
		manager.close();
}
}
    
}