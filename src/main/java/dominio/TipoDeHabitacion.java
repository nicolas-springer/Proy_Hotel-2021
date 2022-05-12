package dominio;

import javax.persistence.*;


@Entity 
@Table 
public class TipoDeHabitacion {

@Id
@Column
	private Integer idTipo;
	private Integer cantCamasSimples;
	private Integer cantCamasDobles;
	private Double costoPorNoche;
	private Integer capacidad;
	private String nombre;
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public Integer getCantCamasSimples() {
		return cantCamasSimples;
	}
	public void setCantCamasSimples(Integer cantCamasSimples) {
		this.cantCamasSimples = cantCamasSimples;
	}
	public Integer getCantCamasDobles() {
		return cantCamasDobles;
	}
	public void setCantCamasDobles(Integer cantCamasDobles) {
		this.cantCamasDobles = cantCamasDobles;
	}
	public Double getCostoPorNoche() {
		return costoPorNoche;
	}
	public void setCostoPorNoche(Double costoPorNoche) {
		this.costoPorNoche = costoPorNoche;
	}
	public Integer getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
