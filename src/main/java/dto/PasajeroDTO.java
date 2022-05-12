package dto;

public class PasajeroDTO {
	

	private String apellido;
	private String nombre;
	private String tipoDocumento;
	private Integer numeroDocumento;
	private Integer diaNacimiento;
	private Integer anioNacimiento;
	private Integer mesNacimiento;
	private String ocupacion;
	private String telefono;
	private String correoElectronico;
	private String posFrenteIVA;
	private String cuit;
	private String pais;
	private String provincia;
	private Integer localidad;
	private String calle;
	private Integer numeroCalle;
	private Integer departamento;
	private Integer piso;
	
	public PasajeroDTO() {
		
	}

	public PasajeroDTO(String apellido, String nombre, String tipoDocumento, Integer numeroDocumento,
			Integer diaNacimiento, Integer anioNacimiento, Integer mesNacimiento, String ocupacion, String telefono,
			String correoElectronico, String posFrenteIVA, String cuit, String pais, String provincia,
			Integer localidad, String calle, String nacionalidad, Integer numeroCalle, Integer departamento,
			Integer piso) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.diaNacimiento = diaNacimiento;
		this.anioNacimiento = anioNacimiento;
		this.mesNacimiento = mesNacimiento;
		this.ocupacion = ocupacion;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.posFrenteIVA = posFrenteIVA;
		this.cuit = cuit;
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
		this.calle = calle;
		this.numeroCalle = numeroCalle;
		this.departamento = departamento;
		this.piso = piso;
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

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getDiaNacimiento() {
		return diaNacimiento;
	}

	public void setDiaNacimiento(Integer diaNacimiento) {
		this.diaNacimiento = diaNacimiento;
	}

	public Integer getAnioNacimiento() {
		return anioNacimiento;
	}

	public void setAnioNacimiento(Integer anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	public Integer getMesNacimiento() {
		return mesNacimiento;
	}

	public void setMesNacimiento(Integer mesNacimiento) {
		this.mesNacimiento = mesNacimiento;
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

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getPosFrenteIVA() {
		return posFrenteIVA;
	}

	public void setPosFrenteIVA(String posFrenteIVA) {
		this.posFrenteIVA = posFrenteIVA;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Integer localidad) {
		this.localidad = localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	
	public Integer getNumeroCalle() {
		return numeroCalle;
	}

	public void setNumeroCalle(Integer numeroCalle) {
		this.numeroCalle = numeroCalle;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	

}
