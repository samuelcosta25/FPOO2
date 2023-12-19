package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTabbedPane;

    public JanelaPrincipal() {
        jTabbedPane = new JTabbedPane();

        // Criação das instâncias dos painéis para cada funcionalidade
        JanelaClientes janelaClientes = new JanelaClientes();
        JanelaIdentificacaoCliente janelaIdentificacaoCliente = new JanelaIdentificacaoCliente(janelaClientes);
        JanelaVendas janelaVendas = new JanelaVendas();
        JanelaConclusaoCompra janelaConclusaoCompra = new JanelaConclusaoCompra();
        JanelaNovoProduto janelaNovoProduto = new JanelaNovoProduto();
        JanelaRelatorioVendas janelaRelatorioVendas = new JanelaRelatorioVendas();
        
        // Adicionando a nova instância JanelaEstoque
        JanelaEstoque janelaEstoque = new JanelaEstoque();

        // Adição das abas ao JTabbedPane
        jTabbedPane.add("Identificação Cliente", janelaIdentificacaoCliente);
        jTabbedPane.add("Clientes", janelaClientes);
        jTabbedPane.add("Registro de Vendas", janelaVendas);
        jTabbedPane.add("Conclusão da Compra", janelaConclusaoCompra);
        jTabbedPane.add("Cadastro de Novo Produto", janelaNovoProduto);
        jTabbedPane.add("Relatório de Vendas", janelaRelatorioVendas);
        
        // Adicionando a nova aba JanelaEstoque
        jTabbedPane.add("Estoque", janelaEstoque);

        add(jTabbedPane);

        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }
}
