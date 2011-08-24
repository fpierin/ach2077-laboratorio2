package br.usp.each.ach2077.laboratorio2.sistema;

import java.sql.Connection;
import java.util.List;

import br.usp.each.ach2077.laboratorio2.dao.ContratoDAO;
import br.usp.each.ach2077.laboratorio2.representacoes.Contrato;
import br.usp.each.ach2077.laboratorio2.utils.ConnectionFactory;

public class Laboratorio2 {

	public static void main(final String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		
		final Connection connection = new ConnectionFactory().getConnection();
				
		ContratoDAO contratoDAO = new ContratoDAO(connection);
	
		
		final List<Contrato> contratos = contratoDAO.obterContratosDoProfissionalDeNumero(12);
		for (final Contrato contrato: contratos){
			System.out.println(contrato);
		}
	}

}
