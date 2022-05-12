package dao;

import java.util.List;

import dominio.Provincia;

public interface ProvinciaDAO {
	public List<Provincia> getProvincias(Integer idPais);
	public Integer getId(String nombre);
	
}
