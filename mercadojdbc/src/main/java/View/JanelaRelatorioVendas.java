package View;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;

import Controller.RelatorioVendasControl;

public class JanelaRelatorioVendas extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public JanelaRelatorioVendas() {
        setLayout(new GridLayout(2, 1));

        // Painel para exibição do relatório (tabela)
        tableModel = new DefaultTableModel(new Object[][]{}, new String[]{"Produto", "Quantidade", "Preço"});
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        // Botão para gerar relatório
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        add(btnGerarRelatorio);

        // Criação do controle e associação com a view
        RelatorioVendasControl controle = new RelatorioVendasControl(this);

        // Adiciona ouvinte de ação para o botão de gerar relatório
        btnGerarRelatorio.addActionListener(e -> controle.gerarRelatorio());
    }

    // Métodos para atualizar a tabela com os dados do relatório
    public void atualizarTabela(Object[][] data, String[] columnNames) {
        tableModel.setDataVector(data, columnNames);
    }
}
