package dao;

import java.time.LocalDate;
import java.util.List;

import dominio.Consumo;
import dominio.Estadia;

public interface ConsumoDAO {

	List<Consumo> recuperarConsumos (Integer idEstadia);

	void crearConsumo(Consumo consumo);

	void actualizarConsumos(List<Consumo> idBar, List<Consumo> idLavado, List<Consumo> idSauna,
			List<Consumo> idEstadia);
	
}
