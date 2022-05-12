package dao;

import java.time.LocalDate;
import java.util.List;

import dominio.Estadia;
import dominio.Ocupacion;

public interface EstadiaDAO {
	public List<Estadia> recuperarHabitaciones (LocalDate inicio, LocalDate fin);

	public List<Estadia> recuperarEstadias(Integer num);

	public void guardarEstadia(Estadia nuevaEstadia);

	public void guardarOcupacion(List<Ocupacion> ocupaciones);
}
