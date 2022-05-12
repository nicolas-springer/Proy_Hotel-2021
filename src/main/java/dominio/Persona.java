package dominio;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.jfree.util.Log;

import dto.PasajeroDTO;
import enumClasses.PosicionFrenteIVA;
import enumClasses.TipoDocumento;

@Entity (name = "persona")
@Table
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	@Column
	private String apellido;
	private String nombre;
	private String tipoDocumento;
	private Integer numeroDocumento;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="direccion_id",referencedColumnName="id_direccion")
	private Direccion direccion;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idNacionalidad",referencedColumnName="idPais")
	private Pais nacionalidad;
	
	private String cuit;
	private String posFrenteIVA;
	private String nacimiento;
	private String correoElectronico;
	private String ocupacion;
	private String telefono;

	public Persona() {

	}

	public Persona(String apellido, String nombre, String tipoDocumento, Integer numeroDocumento, Direccion direccion,
			String cuit, String nacimiento, Pais nacionalidad, String correoElectronico, String ocupacion,
			String telefono, String posFrenteIVA) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.direccion = direccion;
		this.cuit = cuit;
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.correoElectronico = correoElectronico;
		this.ocupacion = ocupacion;
		this.telefono = telefono;
		this.posFrenteIVA = posFrenteIVA;

	}

	public Pais getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Pais nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;

	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	

	public String getPosFrenteIVA() {
		return posFrenteIVA;
	}

	public void setPosFrenteIVA(String posFrenteIVA) {
		this.posFrenteIVA = posFrenteIVA;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public void inicializarPersona (PasajeroDTO pasajeroDTO, Direccion d, Pais nacionalidad) {
	
		this.setApellido(pasajeroDTO.getApellido());
		this.setNombre(pasajeroDTO.getNombre());
		this.setTipoDocumento(pasajeroDTO.getTipoDocumento());
		this.setNumeroDocumento(pasajeroDTO.getNumeroDocumento());
		this.setDireccion(d);
		this.setCuit(pasajeroDTO.getCuit());
		this.setPosFrenteIVA(pasajeroDTO.getPosFrenteIVA());
		String nacimiento = pasajeroDTO.getDiaNacimiento() +"/" + pasajeroDTO.getMesNacimiento() + "/" + pasajeroDTO.getAnioNacimiento() ;
		this.setNacimiento(nacimiento);
		this.setCorreoElectronico(pasajeroDTO.getCorreoElectronico());
		this.setOcupacion(pasajeroDTO.getOcupacion());
		this.setTelefono(pasajeroDTO.getTelefono());
		this.setNacionalidad(nacionalidad);

		
	}
	
	public Integer getEdad() {
	
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");
		LocalDate fechaNac = LocalDate.parse(nacimiento, fmt);

		LocalDate hoy = LocalDate.now();
	
		Period periodo = Period.between(fechaNac, hoy);
		
		return periodo.getYears();
		


	
	}
	
	
	

	
}
