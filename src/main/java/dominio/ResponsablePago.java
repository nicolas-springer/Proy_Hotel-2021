package dominio;

import javax.persistence.*;

@Entity (name = "responsablepago")
@Table
public class ResponsablePago {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResponsable;
	private String RazonSocial ;
	private String Cuit;
	private String email;
	private String telefono;
	
	
	
	 @OneToOne 
	 @JoinColumn(name= "personaId" , referencedColumnName = "id")
	 private Persona persona;
	 
	 @OneToOne
	 @JoinColumn(name= "direccionId" , referencedColumnName = "id_Direccion")
	 private Direccion direccion;
	
	
	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String  getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public String getCuit() {
		return Cuit;
	}
	public void setCuit(String cuit) {
		Cuit = cuit;
	}
	public Integer getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
}
