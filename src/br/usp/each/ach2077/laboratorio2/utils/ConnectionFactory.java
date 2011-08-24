package br.usp.each.ach2077.laboratorio2.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:postgresql://143.107.58.177:5432/dbgrupo50", "grupo50", "51r3g");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
