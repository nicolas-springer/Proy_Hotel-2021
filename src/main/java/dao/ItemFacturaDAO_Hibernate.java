package dao;

import java.util.List;

import javax.persistence.EntityManager;

import dominio.ItemFactura;
import util.ConnectionBD;

public class ItemFacturaDAO_Hibernate implements ItemFacturaDAO {

	EntityManager manager;
	
	public void guardarItem(List<ItemFactura> items) {
		
		manager = ConnectionBD.conectar();
		
		try {
		manager.getTransaction().begin();
	
		for (ItemFactura item: items) 
			manager.persist(item);
		
		manager.getTransaction().commit();
		} catch (Exception e) {
			 
			e.printStackTrace();
			}finally {
			manager.close();
			}

	}

}
