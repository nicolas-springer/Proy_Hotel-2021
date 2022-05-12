package dto;

public class BusquedaPasajeroDTO {
	 
	private String Apellido; 
	private String Nombre;
	private String  TipoDeDocumento;
	private String NumeroDeDocumento;
	
	
	public BusquedaPasajeroDTO() {
		
	}
	
	
	public BusquedaPasajeroDTO(String apellido, String nombre, String tipoDeDocumento, String numeroDeDocumento) {
		super();
		Apellido = apellido;
		Nombre = nombre;
		TipoDeDocumento = tipoDeDocumento;
		NumeroDeDocumento = numeroDeDocumento;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getTipoDeDocumento() {
		return TipoDeDocumento;
	}
	public void setTipoDeDocumento(String tipoDeDocumento) {
		TipoDeDocumento = tipoDeDocumento;
	}
	public String getNumeroDeDocumento() {
		return NumeroDeDocumento;
	}
	public void setNumeroDeDocumento(String numeroDeDocumento) {
		NumeroDeDocumento = numeroDeDocumento;
	}
	
	
	public Object getColumna(int i) {
		
			if (i==0) return this.getApellido();
			else if (i==1) return this.getNombre();
			else if (i==2) return this.getTipoDeDocumento();
			else return this.getNumeroDeDocumento();
		
			
	}
	
	
}
