package dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import enumClasses.EstadoDeFactura;

@Entity (name= "factura")
@Table
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;
    private LocalDate fechaEmision;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numFactura;
    private String cuit;
    private char tipoDeFactura;
    private EstadoDeFactura estado;
    private Boolean iva;
    private Double montoTotal;
    
    @ManyToOne
    @JoinColumn(name= "id_nota" , referencedColumnName = "idNota")
    private NotaDeCredito notaCredito;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name= "responsableId" , referencedColumnName = "idResponsable")
    private ResponsablePago responsable;

    @ManyToOne
    @JoinColumn(name= "estadiaId" , referencedColumnName = "idEstadia")
    private Estadia estadia;
    
    
     @OneToMany(mappedBy="factura")
     private List<ItemFactura> items;


	public Integer getIdFactura() {
		return idFactura;
	}


	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}


	public LocalDate getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public Integer getNumFactura() {
		return numFactura;
	}


	public void setNumFactura(Integer numFactura) {
		this.numFactura = numFactura;
	}


	public String getCuit() {
		return cuit;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public char getTipoDeFactura() {
		return tipoDeFactura;
	}


	public void setTipoDeFactura(char tipoDeFactura) {
		this.tipoDeFactura = tipoDeFactura;
	}


	public EstadoDeFactura getEstado() {
		return estado;
	}


	public void setEstado(EstadoDeFactura estado) {
		this.estado = estado;
	}


	public Boolean getIva() {
		return iva;
	}


	public void setIva(Boolean iva) {
		this.iva = iva;
	}


	public NotaDeCredito getNotaCredito() {
		return notaCredito;
	}


	public void setNotaCredito(NotaDeCredito notaCredito) {
		this.notaCredito = notaCredito;
	}


	public ResponsablePago getResponsable() {
		return responsable;
	}


	public void setResponsable(ResponsablePago responsable) {
		this.responsable = responsable;
	}


	public Estadia getEstadia() {
		return estadia;
	}


	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}


	public List<ItemFactura> getItems() {
		return items;
	}


	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}


	public Double getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

     
  
    
    
    
 
}