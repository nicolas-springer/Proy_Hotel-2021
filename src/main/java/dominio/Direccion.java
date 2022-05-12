package dominio;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import dto.PasajeroDTO;

@Entity
@Table
public class Direccion {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_Direccion;
	@Column
	private String calle;
	@Column
	private Integer numero;
	@Column
	private Integer piso;
	@Column
	private Integer dto;
	
	//@ManyToOne(optional = false)
    //@JoinColumn(name= "id_localidad" , referencedColumnName = "idLocalidad")
    private Integer localidad;
	
	public Direccion () {
		
	}
	
	public Direccion(String calle, Integer numero, Integer piso, Integer dto) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.dto = dto;
	}

	public Integer getId_Direccion() {
		return id_Direccion;
	}
	public void setId_Direccion(Integer id_Direccion) {
		this.id_Direccion = id_Direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getDto() {
		return dto;
	}

	public void setDto(Integer dto) {
		this.dto = dto;
	}
	
	public Integer getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}

	public void inicializarDireccion (PasajeroDTO personaDTO) {
		this.setCalle(personaDTO.getCalle());
		this.setDto(personaDTO.getDepartamento());
		this.setNumero(personaDTO.getNumeroCalle());
		this.setPiso(personaDTO.getPiso());
	}

/*	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}*/

}
