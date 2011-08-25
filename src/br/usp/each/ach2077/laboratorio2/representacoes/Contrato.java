package br.usp.each.ach2077.laboratorio2.representacoes;

import java.math.BigDecimal;

public class Contrato {
	
	private int Numero;
	
	private Vigencia vigencia;
	
	private BigDecimal ValorHora;

	public Contrato() {}
	
	public Contrato(final int numero, final Vigencia vigencia, final BigDecimal valorHora) {
		this.Numero = numero;
		this.vigencia = vigencia;
		this.ValorHora = valorHora;
	}

	public int getNumero() {
		return this.Numero;
	}

	public void setNumero(final int numero) {
		this.Numero = numero;
	}

	public Vigencia getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(final Vigencia vigencia) {
		this.vigencia = vigencia;
	}

	public BigDecimal getValorHora() {
		return this.ValorHora;
	}

	public void setValorHora(final BigDecimal valorHora) {
		this.ValorHora = valorHora;
	}

	@Override
	public String toString() {
		return "Contrato [Numero=" + Numero + ", vigencia=" + vigencia
				+ ", ValorHora=" + ValorHora + "]";
	}
	
}
