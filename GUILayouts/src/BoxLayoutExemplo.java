import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoxLayoutExemplo extends JFrame {
public BoxLayoutExemplo() {
    super("Exemplo de Box Layout");
    BorderLayout border = new BorderLayout();
    this.setLayout(border);
    //criar dois paineis
    JPanel painel1 = new JPanel();
    JPanel painel2 = new JPanel();
    //adicionar os paineis ao frame
    this.add(painel1, BorderLayout.WEST);
    this.add(painel2, BorderLayout.SOUTH);
    //layout do Paineis
    painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
    painel2.setLayout(new BoxLayout(painel1, BoxLayout.X_AXIS));
    //adicionar os elementos aos paineis
    for (int i = 0; i < 5; i++) {
        painel1.add(new JButton(""+i+(1)));
        painel2.add(new JButton(""+i+(1)));
    }
    //set dos frames 
    this.setDefaultCloseOperation(1);
    this.setVisible(true);
    this.pack();
    
}
}
