package br.usp.each.ach2077.laboratorio2.representacoes;

import java.sql.Date;

public class Vigencia {
	
	private Date DataInicio;
	private Date DataTermino;

	public Vigencia() {}

	public Vigencia(final Date dataInicio, final Date dataTermino) {
		this.DataInicio = dataInicio;
		this.DataTermino = dataTermino;
	}

	public Date getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		DataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return DataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		DataTermino = dataTermino;
	}

	@Override
	public String toString() {
		return "Vigencia [DataInicio=" + DataInicio + ", DataTermino="
				+ DataTermino + "]";
	}

}
