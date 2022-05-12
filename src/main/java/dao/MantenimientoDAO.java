package dao;

import java.time.LocalDate;
import java.util.List;

import dominio.Mantenimiento;

public interface MantenimientoDAO {

	public List<Mantenimiento> recuperarHabitaciones (LocalDate inicio, LocalDate fin);
	
}
