package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criarconexao = new ConnectionFactory();
		Connection connection = criarconexao.recuperarConexao();

		System.out.println("Fechando conexao");
		connection.close();
	}

}
