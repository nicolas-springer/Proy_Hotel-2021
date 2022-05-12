package dominio;

import javax.persistence.*;

@Entity
@Table

public class NotaDeCredito {

	@Id
	private Integer idNota;
	
	private Integer numeroDeNota;

	private Double importeNeto;

	private Double importeTotal;

	private Boolean iva;

}
