package br.usp.each.ach2077.laboratorio2.representacoes;

import java.util.Date;

public class Profissional {
	
	private int NumeroControle;
	private int Nome;
	private int Endereco;
	private Date DataNasc;
	
	public Profissional(){};
	
	public Profissional(final int numeroControle, final int nome, final int endereco, final Date dataNasc) {
		this.NumeroControle = numeroControle;
		this.Nome = nome;
		this.Endereco = endereco;
		this.DataNasc = dataNasc;
	}

	public int getNumeroControle() {
		return this.NumeroControle;
	}

	public void setNumeroControle(final int numeroControle) {
		this.NumeroControle = numeroControle;
	}

	public int getNome() {
		return this.Nome;
	}

	public void setNome(final int nome) {
		this.Nome = nome;
	}

	public int getEndereco() {
		return this.Endereco;
	}

	public void setEndereco(final int endereco) {
		this.Endereco = endereco;
	}

	public Date getDataNasc() {
		return this.DataNasc;
	}

	public void setDataNasc(final Date dataNasc) {
		this.DataNasc = dataNasc;
	}

	@Override
	public String toString() {
		return "Profissional [NumeroControle=" + NumeroControle + ", Nome="
				+ Nome + ", Endereco=" + Endereco + ", DataNasc=" + DataNasc
				+ "]";
	}
	
}

