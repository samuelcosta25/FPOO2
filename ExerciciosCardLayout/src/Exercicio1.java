import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class Exercicio1 extends JFrame {
    //construtor
        public Exercicio1() {
        super("Exercicio CardLayout");
        JPanel mainPanel = new JPanel(new BorderLayout());//principal
        this.add(mainPanel);// adiciona painel ao JFrame
         //adicionando botoes:
        JButton nxt = new JButton("Next");
        mainPanel.add(nxt, BorderLayout.NORTH);
        //add um painel de cards ao centro - CardLayout
        CardLayout cl = new CardLayout();
        JPanel cardPanel = new JPanel(cl);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        // cria mais paineis do cardLayout
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        cardPanel.add(card1, "Card 1");
        JPanel card2 = new JPanel();//card2
        card2.add(new JLabel("Card 2"));
        cardPanel.add(card2,"Card 2");
        JPanel card3 = new JPanel();//card3
        card3.add(new JLabel("Card 3"));
        cardPanel.add(card3,"Card 3");
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //criar a ação para o botão
        nxt.addActionListener(e->{
            cl.next(cardPanel);
        });
    }
}

