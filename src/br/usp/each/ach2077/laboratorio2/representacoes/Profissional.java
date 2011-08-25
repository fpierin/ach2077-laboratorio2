package br.usp.each.ach2077.laboratorio2.representacoes;

import java.sql.Date;

public class Profissional {
	
	private int NumeroControle;
	private String Nome;
	private String Endereco;
	private Date DataNasc;
	private int numeroContrato;
	
	public Profissional(){};
	
	public Profissional(final int numeroControle, final String nome, final String endereco, final Date dataNasc, final int numeroContrato) {
		this.NumeroControle = numeroControle;
		this.Nome = nome;
		this.Endereco = endereco;
		this.DataNasc = dataNasc;
		this.numeroContrato = numeroContrato;
	}

	public int getNumeroControle() {
		return this.NumeroControle;
	}

	public void setNumeroControle(final int numeroControle) {
		this.NumeroControle = numeroControle;
	}

	public String getNome() {
		return this.Nome;
	}

	public void setNome(final String nome) {
		this.Nome = nome;
	}

	public String getEndereco() {
		return this.Endereco;
	}

	public void setEndereco(final String endereco) {
		this.Endereco = endereco;
	}

	public Date getDataNasc() {
		return this.DataNasc;
	}

	public void setDataNasc(final Date dataNasc) {
		this.DataNasc = dataNasc;
	}

	public void setNumeroContrato(int numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	public int getNumeroContrato() {
		return numeroContrato;
	}

	@Override
	public String toString() {
		return "Profissional [NumeroControle=" + NumeroControle + ", Nome="
				+ Nome + ", Endereco=" + Endereco + ", DataNasc=" + DataNasc
				+ ", numeroContrato=" + numeroContrato + "]";
	}
	
}

