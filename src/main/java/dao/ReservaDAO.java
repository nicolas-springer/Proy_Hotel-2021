package dao;

import java.time.LocalDate;
import java.util.List;

import dominio.Estadia;
import dominio.Habitacion;
import dominio.Reserva;

public interface ReservaDAO {
	public List<Reserva> recuperarHabitaciones (LocalDate inicio, LocalDate fin);

	public List<Integer>  verificarReserva(Habitacion habitacion);

	public void eliminarReserva(Reserva r);
}
