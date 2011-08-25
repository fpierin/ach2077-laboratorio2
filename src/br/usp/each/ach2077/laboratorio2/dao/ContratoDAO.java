package br.usp.each.ach2077.laboratorio2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usp.each.ach2077.laboratorio2.representacoes.Contrato;
import br.usp.each.ach2077.laboratorio2.representacoes.Vigencia;

public class ContratoDAO {

	private final Connection connection;
	
	private static final String SQL_OBTER_CONTRATO_POR_NUMERO = "select * from \"Contrato\" where \"Numero\" = ?";

	private static final String SQL_SALVAR_CONTRATO = "insert into \"Contrato\" (\"Numero\", \"DataInicio\", \"DataTermino\", \"ValorHora\")" +
													  " values (?, ?, ?, ?)";

	private static final String SQL_EXCLUIR_TODOS = "delete from \"Contrato\"";	
	
	public ContratoDAO(final Connection connection) {
		this.connection = connection;
	}

	public void salva(final Contrato contrato) {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SQL_SALVAR_CONTRATO);
			preparedStatement.setInt(1, contrato.getNumero());		
			preparedStatement.setDate(2, contrato.getVigencia().getDataInicio());
			preparedStatement.setDate(3, contrato.getVigencia().getDataTermino());
			preparedStatement.setBigDecimal(4, contrato.getValorHora());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public Contrato buscaContratoNumero(final int numero) throws SQLException {
		Contrato contrato = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			preparedStatement = this.connection.prepareStatement(SQL_OBTER_CONTRATO_POR_NUMERO);
			preparedStatement.setInt(1, numero);			
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				contrato = new Contrato();
				final Vigencia vigencia = new Vigencia(resultSet.getDate("DataInicio"), resultSet.getDate("DataTermino"));
				contrato.setNumero(resultSet.getInt("Numero"));
				contrato.setValorHora(resultSet.getBigDecimal("ValorHora"));
				contrato.setVigencia(vigencia);				
				return contrato;
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (preparedStatement != null ){
				preparedStatement.close();
			}
			if (resultSet != null ){
				resultSet.close();
			}			
		}
		return contrato;		
	}

	public void apagarTodos() {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SQL_EXCLUIR_TODOS);
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}			
	}	
	
	
}
