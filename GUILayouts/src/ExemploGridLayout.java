import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploGridLayout {
    public ExemploGridLayout() {
        JFrame janela1 = new JFrame("Exemplo GridLayout");
        //this.add(new JLabel("Calculadora Padrão"));
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        GridLayout grid = new GridLayout(4, 4, 5, 5);
        JTextField display = new JTextField("", 20);
        painel2.add(display);
        janela1.add (display,(BorderLayout.NORTH));
        painel1.setLayout(grid);
        //adicionar Jpanel ao Jframe
        janela1.getContentPane().add(painel1);
        String textButton[]={"C","7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "+", "0", "="};
        //add componentes ao painel
        for (int i = 0; i < textButton.length; i++) {
            painel1.add( new JButton(textButton[i]) );
        }
        //config janela1        
        janela1.pack();
        janela1.setBounds(500, 200, 250, 300);
        janela1.setDefaultCloseOperation(2);
        janela1.setVisible(true);
    }
}
