package dao;

import java.util.List;

import dominio.Persona;

public interface PersonaDAO {
	
	public void guardarPersona(Persona persona);
	public List<Persona> recuperarPersonaBusqueda (String nombre, String apellido, String nroDoc, String tipoDoc);
	public Boolean buscarDni(Integer dni);
	
}
