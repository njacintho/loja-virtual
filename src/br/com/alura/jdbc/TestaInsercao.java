package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Noemi
 *
 *iNSERINDO na tablea atraves do java
 */
public class TestaInsercao {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criarconexao = new ConnectionFactory();
		Connection connection = criarconexao.recuperarConexao();

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (nome, descricao) VALUES ('Mouse','Mouse sem fio')", Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rst = stm.getGeneratedKeys();
		while(rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println(" O id criado foi " + id);
		}

	}

}
