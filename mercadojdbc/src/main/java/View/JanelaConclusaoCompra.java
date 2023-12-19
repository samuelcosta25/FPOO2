package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ConclusaoCompraControl;
import DAO.ConclusaoCompraDAO;
import Model.ConclusaoCompraModel;

public class JanelaConclusaoCompra extends JPanel {
    private JTextArea areaListaProdutos;
    private JTextField campoTotalCompra;
    private JComboBox<String> comboMetodoPagamento;
    private JButton botaoFinalizarCompra;

    public JanelaConclusaoCompra() {
        super(new BorderLayout());

        JPanel painelListaProdutos = new JPanel(new BorderLayout());
        areaListaProdutos = new JTextArea();
        areaListaProdutos.setEditable(false);
        JScrollPane scrollListaProdutos = new JScrollPane(areaListaProdutos);
        painelListaProdutos.add(new JLabel("Lista de Produtos:"), BorderLayout.NORTH);
        painelListaProdutos.add(scrollListaProdutos, BorderLayout.CENTER);

        JPanel painelTotalCompra = new JPanel();
        painelTotalCompra.add(new JLabel("Total da Compra: R$"));
        campoTotalCompra = new JTextField(10);
        campoTotalCompra.setEditable(false);
        painelTotalCompra.add(campoTotalCompra);

        JPanel painelMetodoPagamento = new JPanel();
        painelMetodoPagamento.add(new JLabel("Método de Pagamento:"));
        String[] opcoesPagamento = {"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Outro"};
        comboMetodoPagamento = new JComboBox<>(opcoesPagamento);
        painelMetodoPagamento.add(comboMetodoPagamento);

        JPanel painelBotoes = new JPanel();
        botaoFinalizarCompra = new JButton("Finalizar Compra");
        painelBotoes.add(botaoFinalizarCompra);

        add(painelListaProdutos, BorderLayout.CENTER);
        add(painelTotalCompra, BorderLayout.NORTH);
        add(painelMetodoPagamento, BorderLayout.SOUTH);
        add(painelBotoes, BorderLayout.SOUTH);

        // Criação do controle e associação com a view
        ConclusaoCompraControl controle = new ConclusaoCompraControl(
                this, new ConclusaoCompraModel(), new ConclusaoCompraDAO());

        // Adiciona ouvinte de ação para o botão
        botaoFinalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalCompra = Double.parseDouble(campoTotalCompra.getText());
                String metodoPagamento = (String) comboMetodoPagamento.getSelectedItem();
                controle.finalizarCompra(totalCompra, metodoPagamento);
            }
        });
    }

    // Método para atualizar a lista de produtos e o total da compra na tela
    public void atualizarListaProdutos(double totalCompra, String listaProdutos) {
        areaListaProdutos.setText(listaProdutos);
        campoTotalCompra.setText(String.format("%.2f", totalCompra));
    }
}
