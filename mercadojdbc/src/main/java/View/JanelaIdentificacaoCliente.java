package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ClientesIdentificacaoControl;

public class JanelaIdentificacaoCliente extends JPanel {
    private JTextField campoCPF;
    private JButton botaoIdentificar;
    private JButton botaoCadastrarNovoCliente;
    private boolean clienteVIP;

    public JanelaIdentificacaoCliente(JanelaClientes janelaClientes) {
        super(new BorderLayout());

        JPanel painelEntrada = new JPanel();
        painelEntrada.add(new JLabel("CPF:"));
        campoCPF = new JTextField(15);
        painelEntrada.add(campoCPF);

        JPanel painelBotoes = new JPanel();
        botaoIdentificar = new JButton("Identificar Cliente");
        botaoCadastrarNovoCliente = new JButton("Cadastrar Novo Cliente");
        botaoCadastrarNovoCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {new JanelaClientes().setVisible(true);
            }});
        painelBotoes.add(botaoIdentificar);
        painelBotoes.add(botaoCadastrarNovoCliente);

        add(painelEntrada, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Criação do controle e associação com a view
        ClientesIdentificacaoControl controle = new ClientesIdentificacaoControl(this, janelaClientes);

        

        // Adiciona ouvintes de ação para os botões
        botaoIdentificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.identificarCliente(campoCPF.getText());
            }
        });
        

        botaoCadastrarNovoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controle.cadastrarNovoCliente();
            }
        });
    }

    public void setClienteVIP(boolean isVIP) {
        this.clienteVIP = isVIP;
    }

    public boolean isClienteVIP() {
        return clienteVIP;
    }
}
