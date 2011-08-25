package br.usp.each.ach2077.laboratorio2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import br.usp.each.ach2077.laboratorio2.representacoes.Profissional;

public class ProfissionalDAO {
	
	private static final String SQL_PROFISSIONAL_NUMERO_CONTROLE = "Select * from \"Profissional\" where \"NumeroControle\" = ?";
	
	private static final String SQL_SALVA_PROFISSIONAL = "insert into \"Profissional\" (\"NumeroControle\", \"DataNasc\", \"Nome\", \"Endereco\", \"Numero_Contrato\")" +
														 " values(?,?,?,?,?)";

	private static final String SQL_EXCLUIR_TODOS = "delete from \"Profissional\"";	
	
	private final Connection connection;

	public ProfissionalDAO(final Connection connection) {
		this.connection = connection;
	}	
	
	public void salva(final Profissional profissional) {
		try{
			final PreparedStatement preparedStatement = connection.prepareStatement(SQL_SALVA_PROFISSIONAL);
			preparedStatement.setInt(1, profissional.getNumeroControle());
			preparedStatement.setDate(2, profissional.getDataNasc());
			preparedStatement.setString(3, profissional.getNome());
			preparedStatement.setString(4, profissional.getEndereco());
			preparedStatement.setInt(5, profissional.getNumeroContrato());			
			preparedStatement.execute();
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}			
	}	
	
	public Profissional obterProfissionalDeNumeroControle(final int numeroControle){
		Profissional profissional = null;
		try{
			final PreparedStatement preparedStatement = this.connection.prepareStatement(SQL_PROFISSIONAL_NUMERO_CONTROLE);
			preparedStatement.setInt(1, numeroControle);
			final ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				final String nome = resultSet.getString("Nome");
				final String endereco = resultSet.getString("Endereco");
				final Date dataNasc = resultSet.getDate("DataNasc");
				final int numeroContrato = resultSet.getInt("Numero_Contrato");
				profissional = new Profissional(numeroControle, nome, endereco, dataNasc, numeroContrato);
			}
			preparedStatement.close();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}		
		return profissional;
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
