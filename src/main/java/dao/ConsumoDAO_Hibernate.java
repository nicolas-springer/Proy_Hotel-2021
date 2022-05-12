package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dominio.Consumo;
import util.ConnectionBD;


public class ConsumoDAO_Hibernate implements ConsumoDAO{

	private static EntityManager manager;
	
	public List<Consumo> recuperarConsumos(Integer idEstadia) {
	

		 manager = ConnectionBD.conectar();
		 
		 return manager
				.createQuery("SELECT c FROM consumo c WHERE id_estadia ='"+idEstadia+"'",Consumo.class).getResultList();
		 
	}

	public void crearConsumo(Consumo consumo){
		

		manager = ConnectionBD.conectar();
		
		try {
		manager.getTransaction().begin();
		manager.persist(consumo);
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
		
		 
		 
	}

	@Override
	public void actualizarConsumos(List<Consumo> idBar, List<Consumo> idLavado, List<Consumo> idSauna,
			List<Consumo> idEstadia) {
	
		manager = ConnectionBD.conectar();
		
		List<Consumo> listaConsumo = new ArrayList<Consumo>();
		
		for (Consumo c: idBar)
				if (c.getFacturado()) 
					listaConsumo.add(c);
		for (Consumo c: idSauna)
			if (c.getFacturado()) 
				listaConsumo.add(c);
		for (Consumo c: idLavado)
			if (c.getFacturado()) 
				listaConsumo.add(c);
		for (Consumo c: idEstadia)
			if (c.getFacturado()) 
				listaConsumo.add(c);
		
		
		String consulta = "UPDATE consumo SET facturado = true WHERE idconsumo =:sId";

		
		try {
		manager.getTransaction().begin();
		
			for (Consumo c: listaConsumo)
				if (c.getFacturado()) {
					Query query2 = manager.createNativeQuery(consulta);
					query2.setParameter("sId", c.getIdConsumo());
					query2.executeUpdate();
				}
			
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}
		
		/*
		for (Consumo c: idBar)
			if (c.getFacturado())
			manager.createNativeQuery("UPDATE consumo SET facturado = true WHERE idconsumo = '"+c.getIdConsumo()+"'").executeUpdate();
		
		for (Consumo c: idLavado)
			if (c.getFacturado())
			manager.createNativeQuery("UPDATE consumo SET facturado = true WHERE idconsumo = '"+c.getIdConsumo()+"'").executeUpdate();
		
		for (Consumo c: idSauna)
			if (c.getFacturado())
			manager.createNativeQuery("UPDATE consumo SET facturado = true WHERE idconsumo = '"+c.getIdConsumo()+"'").executeUpdate();
		
		for (Consumo c: idEstadia)
			if (c.getFacturado())
			manager.createNativeQuery("UPDATE consumo SET facturado = true WHERE idconsumo = '"+c.getIdConsumo()+"'").executeUpdate();
		*/
		
		
	}


	
}
