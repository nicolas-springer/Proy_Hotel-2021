package dominio;

import javax.persistence.*;


@Entity
@Table
 
public class Ocupacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idOcupacion; 
	
	
	private Boolean pasajeroResponsable;
	
	
	 @OneToOne
	 @JoinColumn(name= "pasajeroId" , referencedColumnName = "id")
	 private Pasajero pasajero;




	public Boolean getPasajeroResponsable() {
		return pasajeroResponsable;
	}

	public void setPasajeroResponsable(Boolean pasajeroResponsable) {
		this.pasajeroResponsable = pasajeroResponsable;
	}


	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}
	 

	 
	 
	 
}
