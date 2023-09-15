import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class Calculadora1 extends JPanel {
    /**
     * 
     */
    public Calculadora1() {
        // cria nova janela
        JPanel janelaTexto = new JPanel();
        // cria painel para texto
        JPanel janelaBotoes = new JPanel();
        // cria janela para botoes
        JPanel painelEquacao = new JPanel();
        // painel de texto da equação
        JPanel painelResultado = new JPanel();
        // painel de texto de resultado
        BorderLayout border = new BorderLayout();
        // cria Layout Border
        this.setLayout(border);
        BoxLayout box = new BoxLayout(janelaTexto, 1);
        janelaTexto.setLayout(box);
        // Seta "Border" como Layout
        this.add(janelaTexto, BorderLayout.NORTH);
        janelaTexto.add(painelEquacao);
        janelaTexto.add(painelResultado);
        this.add(janelaBotoes, BorderLayout.CENTER);
        // cria Textfield
        JTextField textEquacao = new JTextField(15);
        painelEquacao.add(textEquacao);
        textEquacao.setEditable(false);
        textEquacao.setBackground(Color.white);
        // adiciona o textField no painelT
        JTextField textResultado = new JTextField(15);
        textResultado.setEditable(false);
        painelResultado.add(textResultado);
        
        // adiciona o textField no PainelR
        GridLayout grid = new GridLayout(4, 4, 2, 2);
        janelaBotoes.setLayout(grid);
        String botoes[] = { "C", "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "/", "0", "=" };
        for (int i = 0; i < botoes.length; i++) {
            janelaBotoes.add(new JButton(botoes[i]));
        }
        this.setVisible(true); // Deixa o Painel visível

    }
}
