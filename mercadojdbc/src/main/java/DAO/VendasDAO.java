package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionFactory;

public class VendasDAO {
    // DAO para a Tela de Registro de Vendas
    // Pode ser expandido conforme necessário

    // Exemplo de método para registrar uma venda
    public void registrarVenda(String codigoProduto, int quantidade) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO vendas (codigo_produto, quantidade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, codigoProduto);
            stmt.setInt(2, quantidade);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar venda.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }
}
