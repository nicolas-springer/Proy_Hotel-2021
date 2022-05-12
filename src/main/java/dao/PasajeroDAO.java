package dao;

import java.util.List;

import dominio.Pasajero;

public interface PasajeroDAO {

	public void guardarPasajero(Pasajero pasajero);

	public Pasajero obtenerPasajero(Integer id);

	public List<Pasajero> obtenerPasajeros();


	
}
