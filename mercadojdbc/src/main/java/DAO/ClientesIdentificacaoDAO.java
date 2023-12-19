package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.ConnectionFactory;
import Model.Clientes;

public class ClientesIdentificacaoDAO {
    public Clientes consultarPorCPF(String cpf) {
        Clientes cliente = null;
        String sql = "SELECT * FROM clientes_mercado WHERE CPF = ?";
        try (PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql)) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // Se encontrou o cliente pelo CPF, cria um objeto Clientes com os dados do banco
                cliente = new Clientes(rs.getString("Nome"), rs.getString("CPF"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao consultar cliente por CPF.", e);
        }
        return cliente;
    }
}
