import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Calculadora1 extends JPanel {
    public Calculadora1() {
        this.add(new JLabel("Calculadora Padrão"),(BorderLayout.NORTH));
        JPanel tela = new JPanel();
        JPanel botoes = new JPanel();
        GridLayout grid = new GridLayout(4, 4, 5, 5);
        JTextField display = new JTextField("", 20);
        botoes.setSize(100,100);
        botoes.add(display);
        this.add(display,(BorderLayout.NORTH));
        tela.setLayout(grid);
        //adicionar Jpanel ao Jframe
        this.add(tela);
        String textButton[]={"C","7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "+", "0", "="};
        //add componentes ao painel
        for (int i = 0; i < textButton.length; i++) {
            tela.add( new JButton(textButton[i]) );
        }
    }
}
