package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.HabitacionDAO;
import dao.HabitacionDAO_Hibernate;
import dominio.Estadia;
import dominio.Habitacion;
import dominio.Mantenimiento;
import dominio.Reserva;

public class GestorHabitacion {

	GestorEstadia gEstadia = new GestorEstadia();
	GestorMantenimiento gMantenimiento = new GestorMantenimiento();
	GestorReserva gReserva = new GestorReserva();

	public List<Estadia> listaHabitacionesConEstadia(LocalDate inicio, LocalDate fin) {

		List<Estadia> listaHabitacionesE = new ArrayList<>();
		listaHabitacionesE = gEstadia.recuperarHabitaciones(inicio, fin);

		return listaHabitacionesE;
	}

	public List<Mantenimiento> listaHabitacionesConMantenimiento(LocalDate inicio, LocalDate fin) {

		List<Mantenimiento> listaHabitacionesM = new ArrayList<>();
		listaHabitacionesM = gMantenimiento.recuperarHabitaciones(inicio, fin);

		return listaHabitacionesM;
	}

	public List<Reserva> listaHabitacionesConReserva(LocalDate inicio, LocalDate fin) {

		List<Reserva> listaHabitacionesR = new ArrayList<>();
		listaHabitacionesR = gReserva.recuperarHabitaciones(inicio, fin);

		return listaHabitacionesR;
	}

	public ArrayList<Object[]> listaHabitaciones(LocalDate inicio, LocalDate fin) {

		ArrayList<Object[]> listaHabitaciones = new ArrayList<>();

		for (LocalDate date = inicio; (date.isBefore(fin) || date.isEqual(fin)); date = date.plusDays(1)) {
			Object[] filas = new Object[11];
			filas[0] = date;
			listaHabitaciones.add(filas);
		}

		return listaHabitaciones;
	}

	public List<Integer> agregarHabitacionAOcupar(List<Integer> listaHabitacionesAOcupar, int j) {
		
	
			if (j != listaHabitacionesAOcupar.get(listaHabitacionesAOcupar.size()-1)) {
				listaHabitacionesAOcupar.add(j);
			}
	
		return  listaHabitacionesAOcupar;
		
	}

	public List<Habitacion> recuperarH(List<Integer> listaHabitacionesAOcupar) {
		
		HabitacionDAO dHabitacion = new HabitacionDAO_Hibernate();
		
		List<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();  
		
		for (int i = 1; i<listaHabitacionesAOcupar.size(); i++) 
			listaHabitaciones.add(dHabitacion.recuperarHabitacion(listaHabitacionesAOcupar.get(i)));
		
			
		return listaHabitaciones;
	}

	public void asignarEstadia(Habitacion habitacion, Estadia nuevaEstadia) {
		
		
		
	}

	public String recuperarPrecio(Habitacion habitacion) {
		

		return habitacion.getTipoH().getCostoPorNoche().toString();
	}


}