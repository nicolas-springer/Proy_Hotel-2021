package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.MantenimientoDAO;
import dao.MantenimientoDAO_Hibiernate;
import dao.ReservaDAO;
import dao.ReservaDAO_Hibernate;
import dominio.Habitacion;
import dominio.Reserva;
import dominio.Reserva;

public class GestorReserva {
	
	ReservaDAO dReserva = new ReservaDAO_Hibernate();
	
	public List<Reserva> recuperarHabitaciones(LocalDate inicio, LocalDate fin) {
		
			List<Reserva> listaHabitaciones =  new ArrayList<>(); 

	      listaHabitaciones = dReserva.recuperarHabitaciones(inicio,fin);
	
	      return listaHabitaciones;
	}

	public List<Integer> verificarReserva(Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
		
		List<Integer> idsReserva =  dReserva.verificarReserva(habitacion);
		
		List<Reserva> listaReservas =  new ArrayList<>(); 

		listaReservas = dReserva.recuperarHabitaciones(fechaInicio,fechaFin);
		
		for (Reserva r: listaReservas)
			System.out.println(r.getIdReserva());
		
		System.out.println();
		for (Integer id: idsReserva)
			System.out.println(id); 
				
		
		
		for (Reserva r: listaReservas)
			for (Integer id: idsReserva)
				if(r.getIdReserva() == id)
					dReserva.eliminarReserva(r);
					
				
					
		
		 
		 return idsReserva;
		
	}

}
