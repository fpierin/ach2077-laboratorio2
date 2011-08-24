package br.usp.each.ach2077.laboratorio2.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.usp.each.ach2077.laboratorio2.representacoes.Contrato;
import br.usp.each.ach2077.laboratorio2.representacoes.Vigencia;

public class ContratoDAO {

	private final Connection connection;
	
	private static final String LISTA_PONTOS_GEOGRAFICOS = "select * from Contrato where = ?";
	
	public ContratoDAO(final Connection connection) {
		this.connection = connection;
	}	
	
	public List<Contrato> obterContratosDoProfissionalDeNumero(final int NumeroControle){
		try{
			List<Contrato> contratos = null;
			contratos = new ArrayList<Contrato>();
			final PreparedStatement preparedStatement = this.connection.prepareStatement(LISTA_PONTOS_GEOGRAFICOS);
			final ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				final Contrato contrato = new Contrato();

				final int numero = 0;
				final BigDecimal valorHora = new BigDecimal(0);
				final Date dataInicio = resultSet.getDate("DataInicio");
				final Date dataTermino = resultSet.getDate("DataTermino");
				final Vigencia vigencia = new Vigencia(dataInicio, dataTermino);
				
				contrato.setNumero(numero);
				contrato.setVigencia(vigencia);
				contrato.setValorHora(valorHora);
				
				contratos.add(contrato);
			}
			resultSet.close();
			preparedStatement.close();
			return contratos;
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	};
	
}
