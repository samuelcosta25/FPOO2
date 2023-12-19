package Controller;

import javax.swing.JOptionPane;
import DAO.ClientesIdentificacaoDAO;
import Model.Clientes;
import View.JanelaIdentificacaoCliente;
import View.JanelaClientes;

public class ClientesIdentificacaoControl {
    private JanelaIdentificacaoCliente view;
    private JanelaClientes janelaClientes;

    public ClientesIdentificacaoControl(JanelaIdentificacaoCliente view, JanelaClientes janelaClientes) {
        this.view = view;
        this.janelaClientes = janelaClientes;
    }

    public void identificarCliente(String cpf) {
        try {
            // Validar se o CPF possui 11 dígitos numéricos
            if (validarCPF(cpf)) {
                // Consulta o banco de dados para verificar se o cliente é VIP
                Clientes cliente = new ClientesIdentificacaoDAO().consultarPorCPF(cpf);

                if (cliente != null) {
                    // Define na view se o cliente é VIP
                    view.setClienteVIP(true);
                    JOptionPane.showMessageDialog(null, "Cliente VIP identificado!");
                } else {
                    view.setClienteVIP(false);
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado. Cadastre um novo cliente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "CPF inválido. Deve conter exatamente 11 dígitos numéricos.");
            }
        } catch (Exception e) {
            exibirMensagemErro("Erro ao identificar cliente: " + e.getMessage());
        }
    }

    public void cadastrarNovoCliente() {
        janelaClientes.runCadastroCliente();
    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    // Método para validar se o CPF possui 11 dígitos numéricos
    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }
    // Adicione um método para obter o nome do cliente
public String obterNomeCliente(String cpf) {
    Clientes cliente = new ClientesIdentificacaoDAO().consultarPorCPF(cpf);
    return cliente != null ? cliente.getNome() : null;
}

}
