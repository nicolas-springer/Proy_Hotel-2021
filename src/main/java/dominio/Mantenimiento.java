package dominio;

import java.time.LocalDate;


import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity (name = "mantenimiento")
@Table
public class Mantenimiento {

	@Id
	private Integer idMantenimiento;
	private LocalDate fechaInicio;
	private LocalDate  fechaFin;
	private String motivo;
	
	 @ManyToOne
	 @JoinColumn(name= "id_habitacion" , referencedColumnName = "IdHabitacion")
	 private Habitacion habitacion;
	    
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Integer getIdMantenimiento() {
		return idMantenimiento;
	}
	public void setIdMantenimiento(Integer idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}
	public Habitacion getHabitacion() {
		return habitacion;
	}
	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	

	
	
	
	
}

