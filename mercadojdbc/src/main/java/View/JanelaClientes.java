package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import Controller.ClientesControl;
import DAO.ClientesDAO;
import Model.Clientes;

public class JanelaClientes extends JPanel {
    private JButton cadastrar, apagar, editar;
    private JTextField clintNome, clintCPF;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public JanelaClientes() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Clientes"));

        // Painel para entrada de dados
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Nome"));
        clintNome = new JTextField(20);
        inputPanel.add(clintNome);

        inputPanel.add(new JLabel("CPF"));
        clintCPF = new JTextField(20);
        inputPanel.add(clintCPF);

        add(inputPanel);

        // Painel para botões
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);

        // Tabela
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Criação da tabela no banco de dados (se não existir)
        new ClientesDAO().criaTabela();
        // Atualiza a tabela com os dados do banco de dados
        atualizar();

        // Adiciona um ouvinte de clique na tabela
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    // Preenche os campos de texto com os dados da linha selecionada
                    clintNome.setText((String) table.getValueAt(linhaSelecionada, 0));
                    clintCPF.setText((String) table.getValueAt(linhaSelecionada, 1));
                }
            }
        });

        // Cria uma instância da classe de controle
        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        // Adiciona ouvintes de ação para os botões
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.cadastrar(clintNome.getText(), clintCPF.getText());
                clintNome.setText("");
                clintCPF.setText("");
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizar(clintNome.getText(), clintCPF.getText());
                clintNome.setText("");
                clintCPF.setText("");
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagar(clintCPF.getText());
                clintNome.setText("");
                clintCPF.setText("");
            }
        });
    }

    // Método para atualizar a tabela com os dados do banco de dados
    private void atualizar() {
        tableModel.setRowCount(0);
        clientes = new ClientesDAO().listarTodos();
        for (Clientes cliente : clientes) {
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getCPF() });
        }
    }

    public void runCadastroCliente() {
    }
}
