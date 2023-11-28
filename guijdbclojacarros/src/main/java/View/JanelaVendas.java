package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controller.VendasControl;
import Controller.VendasDAO;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import Model.Vendas;

public class JanelaVendas extends JPanel {
    private JButton cadastrar, apagar, editar;
    private JTextField vendaComprador, vendaModelo, vendaData, vendaValor;
    private List<Vendas> vendas;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor da classe
    public JanelaVendas() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Histórico de vendas"));

        // Painel de entrada para os dados da venda
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));

        inputPanel.add(new JLabel("Comprador"));
        vendaComprador = new JTextField(20);
        inputPanel.add(vendaComprador);

        inputPanel.add(new JLabel("Modelo"));
        vendaModelo = new JTextField(20);
        inputPanel.add(vendaModelo);

        inputPanel.add(new JLabel("Data"));
        vendaData = new JTextField(20);
        inputPanel.add(vendaData);

        inputPanel.add(new JLabel("Valor"));
        vendaValor = new JTextField(20);
        inputPanel.add(vendaValor);

        add(inputPanel);

        // Painel de botões para operações
        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes);

        // Tabela para exibir dados das vendas
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Comprador", "Modelo", "Data", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Cria a tabela no banco de dados e a atualiza
        new VendasDAO().criaTabela();
        atualizar();

        // Tratamento de eventos para clicar na tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    vendaComprador.setText((String) table.getValueAt(linhaSelecionada, 0));
                    vendaModelo.setText((String) table.getValueAt(linhaSelecionada, 1));
                    vendaData.setText((String) table.getValueAt(linhaSelecionada, 2));
                    vendaValor.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

        // Controlador para operações nas vendas
        VendasControl operacoes = new VendasControl(vendas, tableModel, table);

        // Tratamento de eventos para o botão cadastrar
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrar(vendaComprador.getText(), vendaModelo.getText(), vendaData.getText(),
                        vendaValor.getText());
                vendaComprador.setText("");
                vendaModelo.setText("");
                vendaData.setText("");
                vendaValor.setText("");
            }
        });

        // Tratamento de eventos para o botão editar
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizar(vendaComprador.getText(), vendaModelo.getText(), vendaData.getText(),
                        vendaValor.getText());
                vendaComprador.setText("");
                vendaModelo.setText("");
                vendaData.setText("");
                vendaValor.setText("");
            }
        });

        // Tratamento de eventos para o botão apagar
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagar(vendaComprador.getText());
                vendaComprador.setText("");
                vendaModelo.setText("");
                vendaData.setText("");
                vendaValor.setText("");
            }
        });
    }

    // Método para atualizar a tabela com dados do banco de dados
    private void atualizar() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada venda como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getComprador(), venda.getModelo(), venda.getData(), venda.getValor() });
        }
    }
}
