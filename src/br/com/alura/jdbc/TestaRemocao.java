package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaRemocao {

	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory criarconexao = new ConnectionFactory();
		Connection connection = criarconexao.recuperarConexao();

		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID > ?");
		stm.setInt(1, 2);
		stm.execute();
		
		Integer linhasdeletadas = stm.getUpdateCount(); // contaer os deletados
		
		System.out.println("Quantidade de linhas deletadas: " + linhasdeletadas );


	}

}
