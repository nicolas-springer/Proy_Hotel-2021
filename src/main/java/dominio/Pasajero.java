package dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name = "pasajero")
@Table
public class Pasajero {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(optional = false)
    @JoinColumn(name= "idpersona" , referencedColumnName = "id")
    private Persona persona;
	

	public Pasajero(Integer id) {
		this.id = id;
	}

	public Pasajero() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public void inicializarPasajero(Persona persona) {
		this.setPersona(persona);
	}

}
