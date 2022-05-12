package dao;

import java.util.List;

import dominio.Consumo;
import dominio.Factura;
import dominio.ResponsablePago;

public interface FacturaDAO {

	void guardarFactura(ResponsablePago res, Factura nuevaFactura, List<Consumo> idBar, List<Consumo> idLavado, List<Consumo> idSauna, List<Consumo> idEstadia);

	Factura obtenerFactura(Factura f);

}
