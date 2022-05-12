package gestor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import dao.MantenimientoDAO;
import dao.MantenimientoDAO_Hibiernate;

import dominio.Mantenimiento;

public class GestorMantenimiento {
	
	MantenimientoDAO dMantenimiento = new MantenimientoDAO_Hibiernate();

	public List<Mantenimiento> recuperarHabitaciones(LocalDate inicio, LocalDate fin) {
		
		  List<Mantenimiento> listaHabitaciones =  new ArrayList<>(); 

	      listaHabitaciones = dMantenimiento.recuperarHabitaciones(inicio,fin);
	
	      return listaHabitaciones;
	}

}
