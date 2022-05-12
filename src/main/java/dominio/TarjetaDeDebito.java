package dominio;

import java.util.Date;

public class TarjetaDeDebito extends MetodoDePago {

	private Banco banco;

	private Integer numTarjeta;

	private Date vencimiento;

	private String titular;

	private String marca;

	private Integer codSeguridad;

	private Double saldo;

}
