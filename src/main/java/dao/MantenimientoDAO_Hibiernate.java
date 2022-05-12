package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import dominio.Mantenimiento;
import util.ConnectionBD;

public class MantenimientoDAO_Hibiernate implements MantenimientoDAO{
	
	   
    private static EntityManager manager;

public List<Mantenimiento> recuperarHabitaciones (LocalDate inicio, LocalDate fin){

	//Timestamp ini = Timestamp.valueOf(inicio.toString());
	//Timestamp fi = Timestamp.valueOf(fin.toString());
	
    manager = ConnectionBD.conectar();

    List <Mantenimiento> mantenimientoOcupado = manager.createQuery("SELECT m FROM mantenimiento m WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' "
            + "OR fechafin  BETWEEN '"+inicio+"' AND  '"+fin+"'", Mantenimiento.class).getResultList();

   // List <Estadia> estadiasOcupadas =manager.createQuery("SELECT e FROM estadia e WHERE fechainicio BETWEEN '"+inicio+"' AND  '"+fin+"' ", Estadia.class).getResultList();
           


        return mantenimientoOcupado;
    }
    

}
