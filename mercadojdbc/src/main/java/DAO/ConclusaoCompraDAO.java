package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.ConnectionFactory;

public class ConclusaoCompraDAO {
    // DAO para a Tela de Conclusão da Compra
    // Pode ser expandido conforme necessário

    // Exemplo de método para registrar a conclusão da compra
    public void registrarConclusaoCompra(double totalCompra, String metodoPagamento) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO conclusao_compra (total_compra, metodo_pagamento) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDouble(1, totalCompra);
            stmt.setString(2, metodoPagamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar conclusão da compra.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }
}
