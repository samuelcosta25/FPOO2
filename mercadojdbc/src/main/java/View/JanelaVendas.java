package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.VendasControl;
import DAO.VendasDAO;
import Model.VendasModel;

public class JanelaVendas extends JPanel {
    private JTextField campoCodigoProduto;
    private JTextField campoQuantidade;
    private JButton botaoAdicionar;
    private JButton botaoRemover;

    public JanelaVendas() {
        super(new BorderLayout());

        JPanel painelEntrada = new JPanel();
        painelEntrada.add(new JLabel("Código do Produto:"));
        campoCodigoProduto = new JTextField(15);
        painelEntrada.add(campoCodigoProduto);

        painelEntrada.add(new JLabel("Quantidade:"));
        campoQuantidade = new JTextField(5);
        painelEntrada.add(campoQuantidade);

        JPanel painelBotoes = new JPanel();
        botaoAdicionar = new JButton("Adicionar Produto");
        botaoRemover = new JButton("Remover Produto");
        painelBotoes.add(botaoAdicionar);
        painelBotoes.add(botaoRemover);

        add(painelEntrada, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        // Criação do controle e associação com a view
        VendasControl controle = new VendasControl(this, new VendasModel(), new VendasDAO());

        // Adiciona ouvintes de ação para os botões
        botaoAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(campoQuantidade.getText());
                controle.adicionarProduto(campoCodigoProduto.getText(), quantidade);
            }
        });

        botaoRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantidade = Integer.parseInt(campoQuantidade.getText());
                controle.removerProduto(campoCodigoProduto.getText(), quantidade);
            }
        });
    }
}
