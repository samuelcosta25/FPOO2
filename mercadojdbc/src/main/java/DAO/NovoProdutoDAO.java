package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionFactory;

public class NovoProdutoDAO {
    // DAO para a Tela de Cadastro de Novo Produto
    // Pode ser expandido conforme necessário

    // Exemplo de método para cadastrar um novo produto
    public void cadastrarNovoProduto(String nome, String codigoBarras, double preco) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO estoque (nome, codigo_barras, preco, quantidade) VALUES (?, ?, ?, 0)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, codigoBarras);
            stmt.setDouble(3, preco);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar novo produto.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }
}
