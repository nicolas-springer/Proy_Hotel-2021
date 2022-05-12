package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.Consumo;
import dominio.Factura;
import dominio.ItemFactura;
import dominio.ResponsablePago;
import util.ConnectionBD;

public class FacturaDAO_Hibernate implements FacturaDAO{
	
	private static EntityManager manager;
	
	ItemFacturaDAO daoItem = new ItemFacturaDAO_Hibernate();
	ConsumoDAO daoConsumo = new ConsumoDAO_Hibernate();
	ResponsablePagoDAO daoResponsable = new ResponsablePagoDAO_Hibernate();
	


		@Override
	public Factura obtenerFactura(Factura f) {
		
		
		return null;
	}
	@Override
	public void guardarFactura(ResponsablePago res, Factura nuevaFactura, List<Consumo> idBar, List<Consumo> idLavado, List<Consumo> idSauna,
			List<Consumo> idEstadia) {

			manager = ConnectionBD.conectar();
			
			try {
			
			daoResponsable.guardarResponsable(res);
			manager.getTransaction().begin();
			manager.persist(nuevaFactura);
			manager.getTransaction().commit();
			
			manager.getTransaction().begin();
			daoConsumo.actualizarConsumos(idBar,idLavado,idSauna,idEstadia);
			daoItem.guardarItem(nuevaFactura.getItems());
			manager.getTransaction().commit();
			} catch (Exception e) {
				 
				e.printStackTrace();
				}finally {
				manager.close();
				}
		
	}

}
