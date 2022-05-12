package dominio;

import java.util.List;

import javax.persistence.*;

@Entity (name= "itemfactura")
@Table
public class ItemFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_itemfactura;

    private Double montoTotal;

    @ManyToOne
    @JoinColumn(name= "id_factura" , referencedColumnName = "idFactura")
    private Factura factura;
 
    

	 @OneToOne
	 @JoinColumn(name= "id_tipo" , referencedColumnName = "id_tipoconsumo")
	 private TipoConsumo tipoConsumo;

    public Integer getId_itemfactura() {
        return id_itemfactura;
    }

    public void setId_itemfactura(Integer id_itemfactura) {
        this.id_itemfactura = id_itemfactura;
    }


    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

	public TipoConsumo getTipoConsumo() {
		return tipoConsumo;
	}

	public void setTipoConsumo(TipoConsumo tipoConsumo) {
		this.tipoConsumo = tipoConsumo;
	}



}