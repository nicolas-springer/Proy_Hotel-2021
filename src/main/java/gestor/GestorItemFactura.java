package gestor;

import java.util.ArrayList;
import java.util.List;

import dominio.Consumo;
import dominio.ItemFactura;

public class GestorItemFactura {

	public List<ItemFactura> crearItems(List<Consumo> idBar, List<Consumo> idSauna, List<Consumo> idEstadia,
			List<Consumo> idLavado) {
		
		List<ItemFactura> detalleFactura = new ArrayList<ItemFactura>(); 
		
		ItemFactura itemBar = new ItemFactura();
		ItemFactura itemSauna = new ItemFactura();
		ItemFactura itemEstadia = new ItemFactura();
		ItemFactura itemLavado= new ItemFactura();
		Double total = 0.0; 
		
		
		if (idBar.size()!=0) {
			
			total = 0.0; 
			itemBar.setTipoConsumo(idBar.get(0).getTipo());
		
			for (Consumo c: idBar)
				if(c.getFacturado())
				total += (double) (c.getPrecioUnitario()*c.getCantidad()); 
		
			itemBar.setMontoTotal(total);
			detalleFactura.add(itemBar);
		}
		
		if (idSauna.size()!=0) {	
			total = 0.0; 
			itemSauna.setTipoConsumo(idSauna.get(0).getTipo());
		
			for (Consumo c: idSauna)
				if(c.getFacturado())
				total += (double) (c.getPrecioUnitario()*c.getCantidad()); 
		
			itemSauna.setMontoTotal(total);
			detalleFactura.add(itemSauna);
		}
		
		if (idLavado.size()!=0) {	
			total = 0.0; 
			itemLavado.setTipoConsumo(idLavado.get(0).getTipo());
		
			for (Consumo c: idLavado)
				if(c.getFacturado())
				total += (double) (c.getPrecioUnitario()*c.getCantidad()); 
		
			itemLavado.setMontoTotal(total);
			detalleFactura.add(itemLavado);
		}
		
		if (idEstadia.size()!=0) {	
			total = 0.0; 
			itemEstadia.setTipoConsumo(idEstadia.get(0).getTipo());
		
			for (Consumo c: idEstadia)
				if(c.getFacturado())
				total += (double) (c.getPrecioUnitario()*c.getCantidad()); 
		
			itemEstadia.setMontoTotal(total);
			detalleFactura.add(itemEstadia);
		}
		
	
		
		return detalleFactura;
	}

}
