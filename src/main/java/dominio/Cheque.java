package dominio;

import java.util.Date;

public class Cheque extends MetodoDePago {


	private Integer numCheque;
	private Banco banco;
	private Integer plaza;
	private Double monto;
	private Date fechaDeCobro;

	public Cheque(Integer numCheque, Banco banco, Integer plaza, Double monto, Date fechaDeCobro) {
		this.numCheque = numCheque;
		this.banco = banco;
		this.plaza = plaza;
		this.monto = monto;
		this.fechaDeCobro = fechaDeCobro;
	}

	public Integer getNumCheque() {
		return numCheque;
	}

	public void setNumCheque(Integer numCheque) {
		this.numCheque = numCheque;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Integer getPlaza() {
		return plaza;
	}

	public void setPlaza(Integer plaza) {
		this.plaza = plaza;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFechaDeCobro() {
		return fechaDeCobro;
	}

	public void setFechaDeCobro(Date fechaDeCobro) {
		this.fechaDeCobro = fechaDeCobro;
	}
	
	
}
