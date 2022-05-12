package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import dao.EstadiaDAO;
import dao.EstadiaDAO_Hibernate;
import dominio.Estadia;
import dominio.Habitacion;
import dominio.Ocupacion;
import dominio.Pasajero;
import dominio.Persona;

public class GestorEstadia {
    
    EstadiaDAO dEstadia = new EstadiaDAO_Hibernate();
    GestorReserva gestorReserva = new GestorReserva();
    



    public List<Estadia> recuperarHabitaciones (LocalDate inicio, LocalDate fin){

        List<Estadia> listaHabitaciones =  new ArrayList<>(); 

        listaHabitaciones = dEstadia.recuperarHabitaciones(inicio,fin);



        return listaHabitaciones;
    }


	public List<Estadia> recuperarEstadias(Integer num) {
		
		return dEstadia.recuperarEstadias(num);
		
	}


	public Estadia crearEstadia(Habitacion habitacion, List<LocalDate> fechas) {
		
		Estadia nuevaEstadia = new Estadia();
		
		nuevaEstadia.setFechaInicio(fechas.get(0));
		nuevaEstadia.setFechaFin(fechas.get(fechas.size()-1));
		nuevaEstadia.setHabitacion(habitacion);
		
		
		//gHabitacion.asignarEstadia(habitacion, nuevaEstadia);
		
		
		return nuevaEstadia;
	}


	public Ocupacion crearOcupacion(Pasajero pasajero, boolean selected, Estadia nuevaEstadia) {
		
		Ocupacion ocupacion = new Ocupacion ();

		ocupacion.setPasajero(pasajero);
		ocupacion.setPasajeroResponsable(selected);
		
		
		return ocupacion; 
		
	}


	public void guardarEstadia(Estadia nuevaEstadia) {
	
		List<Integer> listaIdsReserva = new ArrayList<Integer>();
		
		listaIdsReserva = gestorReserva.verificarReserva(nuevaEstadia.getHabitacion(), nuevaEstadia.getFechaInicio(), nuevaEstadia.getFechaFin());
		
		
		dEstadia.guardarOcupacion(nuevaEstadia.getOcupaciones());
		dEstadia.guardarEstadia(nuevaEstadia);
		
		

	}


	public List<Pasajero> recuperarPasajeros(Estadia est) {
		
		 List<Pasajero> retorno = new ArrayList<Pasajero>();
		 
		 for(Ocupacion o: est.getOcupaciones())
			 retorno.add(o.getPasajero());
		 
		 
		 
		 return retorno;
	}


	public String recuperarPrecio(Estadia est) {
		GestorHabitacion gHabitacion = new GestorHabitacion();
		
		return gHabitacion.recuperarPrecio(est.getHabitacion());
		
	}

    
}