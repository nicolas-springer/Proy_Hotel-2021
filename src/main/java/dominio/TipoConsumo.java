package dominio;

import javax.persistence.*;

@Entity (name = "tipoconsumo")
@Table
public class TipoConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipoconsumo;
    private String descripcionConsumo;
	public Integer getId_tipoconsumo() {
		return id_tipoconsumo;
	}
	public void setId_tipoconsumo(Integer id_tipoconsumo) {
		this.id_tipoconsumo = id_tipoconsumo;
	}
	public String getDescripcionConsumo() {
		return descripcionConsumo;
	}
	public void setDescripcionConsumo(String descripcionConsumo) {
		this.descripcionConsumo = descripcionConsumo;
	}
    
    

}