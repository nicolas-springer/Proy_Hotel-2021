package dao;

import java.util.List;

import dominio.Localidad;

public interface LocalidadDAO {
	public List<Localidad> getLocalidades();
	public List<Localidad> getLocalidades(String nombreProvincia);
}
