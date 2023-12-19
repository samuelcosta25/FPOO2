package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Clientes;

public class ClientesDAO {
    private Connection connection;
    private List<Clientes> clientes;

    public ClientesDAO() {
        // Obtém a conexão com o banco de dados ao criar uma instância da classe
        this.connection = ConnectionFactory.getConnection();
    }

    // Cria a tabela no banco de dados se ela não existir
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_mercado (Nome VARCHAR(255), CPF VARCHAR(11) PRIMARY KEY)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela.", e);
        } finally {
            // Fecha a conexão após a execução da operação
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Lista todos os clientes presentes na tabela
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        clientes = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_mercado");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // Cria um objeto Cliente para cada linha retornada da tabela
                Clientes cliente = new Clientes(rs.getString("Nome"), rs.getString("CPF"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar clientes.", ex);
        } finally {
            // Fecha a conexão após a execução da operação
            ConnectionFactory.closeConnection(connection, stmt);
        }
        return clientes;
    }

    // Cadastra um novo cliente na tabela
    public void cadastrar(String nome, String cpf) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO clientes_mercado (Nome, CPF) VALUES (?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            // Fecha a conexão após a execução da operação
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualiza os dados de um cliente na tabela
    public void atualizar(String nome, String cpf) {
        PreparedStatement stmt = null;
        String sql = "UPDATE clientes_mercado SET Nome = ? WHERE CPF = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            // Fecha a conexão após a execução da operação
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apaga um cliente da tabela com base no CPF
    public void apagar(String cpf) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM clientes_mercado WHERE CPF = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            // Fecha a conexão após a execução da operação
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public Clientes consultarPorCPF(String cpf) {
        return null;
    }
}
