package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * a Inserção com parametros proteje sue código de quebrar caso um usuario mal intencionado tente realizar o inject sql 
 * e por exemplo deletar seu banco de dados
 */
public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory criarconexao = new ConnectionFactory();
		Connection connection = criarconexao.recuperarConexao();
		connection.setAutoCommit(false);

		try {

			PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?)",
					Statement.RETURN_GENERATED_KEYS);

			adicionarVariavel("SmartTV", "45 polegadas", stm);
			adicionarVariavel("Radio", "Radio de baterias", stm);

			connection.commit();

			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ROLBACK EXECUTADO");
		}

	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

		if (nome.equals("Radio")) {
			throw new RuntimeException("Nao foi possiveL adicionar o produto");
		}

		stm.execute();

		try(ResultSet rst = stm.getGeneratedKeys()){
			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println(" O id criado foi " + id);
			}
		}
		
	}

//	extrair para variavel

//	stm.setString(1, nome);
//	stm.setString(2, descricao);
//	
//	stm.execute();
//	
//	ResultSet rst = stm.getGeneratedKeys();
//	while (rst.next()) {
//		Integer id = rst.getInt(1);
//		System.out.println(" O id criado foi " + id);
//	}
}
