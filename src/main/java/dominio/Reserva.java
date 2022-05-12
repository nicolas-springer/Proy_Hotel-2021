package dominio;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity (name="reserva")
@Table

public class Reserva {

	@Id
	private Integer idReserva;
	private Integer numReserva;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String apellidoReservador;
	private String nombreReservador;
	
	 @ManyToMany (mappedBy = "reserva")
	 private List <Habitacion> habitacion;

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public Integer getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(Integer numReserva) {
		this.numReserva = numReserva;
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

	public String getApellidoReservador() {
		return apellidoReservador;
	}

	public void setApellidoReservador(String apellidoReservador) {
		this.apellidoReservador = apellidoReservador;
	}

	public String getNombreReservador() {
		return nombreReservador;
	}

	public void setNombreReservador(String nombreReservador) {
		this.nombreReservador = nombreReservador;
	}

	public List<Habitacion> getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(List<Habitacion> habitacion) {
		this.habitacion = habitacion;
	}

	 
	 
}
