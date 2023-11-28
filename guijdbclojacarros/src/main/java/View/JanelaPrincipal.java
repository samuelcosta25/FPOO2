package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class JanelaPrincipal extends JFrame {
    // criação do tabbedPane para incluir as tabs
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabelas do tabbedPanel
        
        JanelaCarros tab1 = new JanelaCarros(); // tab1 carros
        JanelaClientes tab2 = new JanelaClientes(); // tab2 clientes
        JanelaVendas tab3 = new JanelaVendas(); // tab3 vendas
        jTPane.add("Carros", tab1); // adicionar tab1 carros
        jTPane.add("Clientes", tab2); // adicionar tab2 clientes
        jTPane.add("Vendas", tab3); // adicionar tab3 vendas
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}