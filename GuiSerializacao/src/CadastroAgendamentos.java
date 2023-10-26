import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CadastroAgendamentos {

    private JTextField inputData;
    private JTextField inputHora;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Agenda> Agendamentoss = new ArrayList<>();
    private int linhaSelecionada = -1;

    public CadastroAgendamentos() {
        tableModel = new DefaultTableModel(); 
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        inputData = new JTextField(10);
        inputHora = new JTextField(10);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}
