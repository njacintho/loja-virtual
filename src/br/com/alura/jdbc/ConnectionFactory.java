package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooleDataSource = new ComboPooledDataSource();
		comboPooleDataSource.setJdbcUrl("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC");
		comboPooleDataSource.setUser("host");
		comboPooleDataSource.setPassword("No020823");
		
		comboPooleDataSource.setMaxPoolSize(15);
		
		this.dataSource = comboPooleDataSource;

	}

	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
	}

}
