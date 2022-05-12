package dominio;

import javax.persistence.*;

@Entity
@Table
public class Banco {
	
	@Id
	@Column
	private Integer id_Banco;
	@Column
	private String nombre;
	@Column
	private Integer telefono;

	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="direccion_id",referencedColumnName="id_Direccion")
	private Direccion direccion;


	
	public Banco() {
		
		
	}
	public Banco(String nombre, Integer telefono, Direccion direccion) {
		this.nombre = nombre;
		this.telefono = telefono;
		//this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	/*
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
*/
}
