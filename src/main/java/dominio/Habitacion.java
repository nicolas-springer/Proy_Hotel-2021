package dominio;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity (name= "habitacion")
@Table

public class Habitacion {

    @Id
    private Integer IdHabitacion;
    
    private Integer numero;

    
    @ManyToOne
    @JoinColumn(name= "id_tipo" , referencedColumnName = "IdTipo")
    private TipoDeHabitacion tipoH;
   
    @ManyToMany
    @JoinTable (
    		name = "habitacionReserva",
    		joinColumns = @JoinColumn (name = "habitacionId",referencedColumnName="IdHabitacion"),
    		inverseJoinColumns = @JoinColumn (name = "reservaId",referencedColumnName="IdReserva")
    		)
		
    private List <Reserva> reserva;
    
    
    public Habitacion() {
  		
  	}

    public Habitacion(int j) {
		this.numero = j;
	}

	public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

	public Integer getIdHabitacion() {
		return IdHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion) {
		IdHabitacion = idHabitacion;
	}

	public TipoDeHabitacion getTipoH() {
		return tipoH;
	}

	public void setTipoH(TipoDeHabitacion tipoH) {
		this.tipoH = tipoH;
	}




}