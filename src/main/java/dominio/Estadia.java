package dominio;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity (name = "estadia")
@Table


public class Estadia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEstadia;

	private LocalDate fechaInicio;
	private LocalDate  fechaFin;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numEstadia;

	 @ManyToOne
	 @JoinColumn(name= "id_habitacion" , referencedColumnName = "IdHabitacion")
	 private Habitacion habitacion;
	 
	 @OneToMany
	 private List<Ocupacion> ocupaciones= new ArrayList<>();
	 
	    
	public List<Ocupacion> getOcupaciones() {
		return ocupaciones;
	}

	public void setOcupaciones(List<Ocupacion> ocupaciones) {
		this.ocupaciones = ocupaciones;
	}

	public Integer getNumEstadia() {
		return numEstadia;
	}

	public void setNumEstadia(Integer numEstadia) {
		this.numEstadia = numEstadia;
	}

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

	public Integer getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(Integer idEstadia) {
		this.idEstadia = idEstadia;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	

}
