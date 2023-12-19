package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.NovoProdutoControl;
import DAO.NovoProdutoDAO;
import Model.NovoProdutoModel;

public class JanelaNovoProduto extends JPanel {
    private JTextField campoNome;
    private JTextField campoCodigoBarras;
    private JTextField campoPreco;
    private JButton botaoCadastrarNovoProduto;

    public JanelaNovoProduto() {
        super(new GridLayout(4, 2));

        add(new JLabel("Nome do Produto:"));
        campoNome = new JTextField(20);
        add(campoNome);

        add(new JLabel("Código de Barras:"));
        campoCodigoBarras = new JTextField(20);
        add(campoCodigoBarras);

        add(new JLabel("Preço:"));
        campoPreco = new JTextField(10);
        add(campoPreco);

        botaoCadastrarNovoProduto = new JButton("Cadastrar Novo Produto");
        add(botaoCadastrarNovoProduto);

        // Criação do controle e associação com a view
        NovoProdutoControl controle = new NovoProdutoControl(
                this, new NovoProdutoModel(), new NovoProdutoDAO());

        // Adiciona ouvinte de ação para o botão de cadastrar novo produto
        botaoCadastrarNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String codigoBarras = campoCodigoBarras.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                controle.cadastrarNovoProduto(nome, codigoBarras, preco);
                // Chame métodos adicionais conforme necessário
            }
        });
    }
}
