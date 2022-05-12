package dao;

import java.util.List;

import dominio.ResponsablePago;

public interface ResponsablePagoDAO {
	
	public List<ResponsablePago> recuperarResponsable(String cuit);

	public void guardarResponsable(ResponsablePago responsable);
	public void guardarResponsablePago(ResponsablePago responsable);


}
