package gestor;

import java.time.LocalDate;
import java.util.List;

import dao.ConsumoDAO;
import dao.ConsumoDAO_Hibernate;
import dominio.Consumo;
import dominio.Estadia;
import dominio.TipoConsumo;

public class GestorConsumo {

	ConsumoDAO daoConsumo = new ConsumoDAO_Hibernate();
	GestorEstadia gestorEstadia = new GestorEstadia();
	GestorTipoConsumo gestorTipo = new GestorTipoConsumo();
	
	
	public List<Consumo> recuperarConsumos (Estadia estadia){
		
		return daoConsumo.recuperarConsumos(estadia.getIdEstadia());
		
	}


	public String recuperarPrecioEstadia(Estadia est) {
	
		return gestorEstadia.recuperarPrecio(est);
		
	}


	public void cambiarFacturado(List<Consumo> idBar, boolean b, LocalDate fecha) {
		
		
			for(Consumo c: idBar)
				
				if (c.getFechaFacturacion().isEqual(fecha))
					if(b) {
						c.setFacturado(true);
					}
					else {
					c.setFacturado(false);
					}
		
				
	
		
	}


	public void crearConsumoParaEstadia(Estadia est, LocalDate date) {
	
		Consumo nuevoConsumo = new Consumo();
		
		nuevoConsumo.setCantidad(1);
		nuevoConsumo.setDescripcion("Estadia");
		nuevoConsumo.setEstadia(est);
		nuevoConsumo.setFacturado(false);
		nuevoConsumo.setFechaFacturacion(date);
		nuevoConsumo.setPrecioUnitario(Float.parseFloat(recuperarPrecioEstadia(est)));
		nuevoConsumo.setTipo(gestorTipo.getTipoEstadia());
		

		daoConsumo.crearConsumo(nuevoConsumo);
		
	}
}
