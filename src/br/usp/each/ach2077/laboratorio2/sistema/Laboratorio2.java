package br.usp.each.ach2077.laboratorio2.sistema;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import br.usp.each.ach2077.laboratorio2.dao.ContratoDAO;
import br.usp.each.ach2077.laboratorio2.dao.ProfissionalDAO;
import br.usp.each.ach2077.laboratorio2.representacoes.Contrato;
import br.usp.each.ach2077.laboratorio2.representacoes.Profissional;
import br.usp.each.ach2077.laboratorio2.representacoes.Vigencia;
import br.usp.each.ach2077.laboratorio2.utils.ConnectionFactory;

public class Laboratorio2 {

	@SuppressWarnings("deprecation")
	public static void main(final String[] args) throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		
		final Connection connection = new ConnectionFactory().getConnection();
				
		final ProfissionalDAO profissionalDAO = new ProfissionalDAO(connection);
		final ContratoDAO contratoDAO = new ContratoDAO(connection);		
			
		final Vigencia vigencia = new Vigencia(new Date(2011, 1, 1), new Date(2012, 12, 1));
		
		profissionalDAO.apagarTodos();
		contratoDAO.apagarTodos();
		
		final Contrato contratoUm = new Contrato(551, vigencia, new BigDecimal(120.5));
		final Contrato contratoDois = new Contrato(442, vigencia, new BigDecimal(40.2));

		contratoDAO.salva(contratoUm);
		contratoDAO.salva(contratoDois);		
		
		final Profissional profissionalUm = new Profissional(1, "Felipe Pierin", "Rua Prof Rui Bloem", new Date(1980, 12, 1), 551);
		final Profissional profissionalTres = new Profissional(2, "Jose Rogerio", "Av. Tatuapé", new Date(1980, 1, 7), 551);
		final Profissional profissionalDois = new Profissional(3, "Adam Smith", "First Avenue", new Date(1980, 10, 22), 442);
		
		profissionalDAO.salva(profissionalUm);
		profissionalDAO.salva(profissionalDois);
		profissionalDAO.salva(profissionalTres);		
		
		final Profissional profissional = profissionalDAO.obterProfissionalDeNumeroControle(2);
		final Contrato contrato = contratoDAO.buscaContratoNumero(profissionalUm.getNumeroContrato());
		
		System.out.println(profissional + "\n" + contrato);
		
	}

}
