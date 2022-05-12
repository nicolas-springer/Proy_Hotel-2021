package dominio;

import java.util.Date;

public class TarjetaDeCredito extends MetodoDePago {

	private Banco banco;

	private Integer numTarjeta;

	private Date vencimiento;

	private String titular;

	private String marca;

	private Integer codSeguridad;

	private Double limite;

}
