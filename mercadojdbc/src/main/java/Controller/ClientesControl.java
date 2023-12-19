package Controller;

import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.ClientesDAO;
import DAO.EstoqueDAO;
import Model.Clientes;
import Model.Estoque;

import java.util.List;

public class ClientesControl {
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // No método atualizarTabela(), ajuste o loop para usar EstoqueControl
public void atualizarTabela() {
    tableModel.setRowCount(0);
    List<Estoque> produtos = new EstoqueDAO().listarTodos();
    for (Estoque produto : produtos) {
        tableModel.addRow(new Object[]{produto.getId(), produto.getNomeDoProduto(), produto.getPreco(),
                produto.getQuantidade()});
    }
}

    // Método para cadastrar um novo cliente
    public void cadastrar(String nome, String cpf) {
        try {
            if (validarDadosCliente(nome, cpf)) {
                new ClientesDAO().cadastrar(nome, cpf);
                atualizarTabela();
            }
        } catch (Exception e) {
            exibirMensagemErro("Erro ao cadastrar: " + e.getMessage());
        }
    }

    // Método para atualizar os dados de um cliente existente
    public void atualizar(String nome, String cpf) {
        try {
            if (validarDadosCliente(nome, cpf)) {
                new ClientesDAO().atualizar(nome, cpf);
                atualizarTabela();
            }
        } catch (Exception e) {
            exibirMensagemErro("Erro ao atualizar: " + e.getMessage());
        }
    }

    // Método para apagar um cliente existente
public void apagar(String cpf) {
    try {
        validarCPF(cpf);
        new ClientesDAO().apagar(cpf);
        atualizarTabela();
    } catch (IllegalArgumentException e) {
        exibirMensagemErro("Erro ao apagar: " + e.getMessage());
    } catch (Exception e) {
        exibirMensagemErro("Erro ao apagar: " + e.getMessage());
    }
}

    // Método para validar os dados de um cliente
    private boolean validarDadosCliente(String nome, String cpf) {
        try {
            validarCampoEmBranco(nome, "Nome");
            validarCampoEmBranco(cpf, "CPF");
            validarNome(nome);
            validarCPF(cpf);
            return true;
        } catch (IllegalArgumentException e) {
            exibirMensagemErro(e.getMessage());
            return false;
        }
    }

    // Método para validar se um campo está em branco
    private void validarCampoEmBranco(String valor, String campo) {
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " não pode estar em branco. Preencha e tente novamente.");
        }
    }

    // Método para validar o formato do nome
    private void validarNome(String nome) {
        if (!nome.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("Nome inválido. Verifique e tente novamente.");
        }
    }

    // Método para validar o formato do CPF
private void validarCPF(String cpf) {
    if (!cpf.matches("\\d{11}")) {
        throw new IllegalArgumentException("CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
    }
}

    // Método para exibir mensagens de erro
    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
