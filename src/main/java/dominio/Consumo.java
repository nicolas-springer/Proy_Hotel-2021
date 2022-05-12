package dominio;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

@Entity (name= "consumo")
@Table
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idConsumo;

    private Float precioUnitario;
    private LocalDate fechaFacturacion;

    private String descripcion;
    private Integer cantidad;
    private Boolean facturado;
    
  
    @ManyToOne
    @JoinColumn(name= "id_estadia" , referencedColumnName = "idEstadia")
    private Estadia estadia;

    @ManyToOne
    @JoinColumn(name="tipoconsumo_id",referencedColumnName="id_tipoconsumo")
    private TipoConsumo tipo;

    
    
	public Integer getIdConsumo() {
		return idConsumo;
	}

	public void setIdConsumo(Integer idConsumo) {
		this.idConsumo = idConsumo;
	}


	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getFacturado() {
		return facturado;
	}

	public void setFacturado(Boolean facturado) {
		this.facturado = facturado;
	}

	public TipoConsumo getTipo() {
		return tipo;
	}

	public void setTipo(TipoConsumo tipo) {
		this.tipo = tipo;
	}

	public Float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(LocalDate fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}



}