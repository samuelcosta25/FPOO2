import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class Exercicio3 extends JFrame {
    //construtor
        public Exercicio3() {
        super("Exercicio CardLayout");
        JPanel mainPanel = new JPanel(new BorderLayout());//principal
        this.add(mainPanel, BorderLayout.SOUTH);// adiciona painel ao JFrame
         //adicionando botoes:
        JButton home = new JButton("Home");
        JButton log = new JButton("Login");
        JButton cad = new JButton("Cadastro");
      
        JPanel menuPanel = new JPanel(new FlowLayout());//menu
        mainPanel.add(menuPanel, BorderLayout.SOUTH);
        menuPanel.add(home, FlowLayout.LEFT);
        menuPanel.add(log, FlowLayout.CENTER, 1);
        menuPanel.add(cad, FlowLayout.RIGHT, 2);

        //add um painel de cards ao centro - CardLayout
        CardLayout cl = new CardLayout();
        JPanel cardPanel = new JPanel(cl);
        mainPanel.add(cardPanel, BorderLayout.CENTER);
        // cria mais paineis do cardLayout
        JPanel card1 = new JPanel();
        card1.add(new JLabel("HOME"));
        cardPanel.add(card1, "Card 1");
        JPanel card2 = new JPanel();//card2
        card2.add(new JLabel("LOGIN"));
        cardPanel.add(card2,"Card 2");
        JPanel card3 = new JPanel();//card3
        card3.add(new JLabel("CADASTRO"));
        cardPanel.add(card3,"Card 3");
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //if () {} fazer condição para o botao ao ser pressionado
            
        
        //criar a ação para o botão
        home.addActionListener(e->{
            cl.first(cardPanel);
        });
        log.addActionListener(e->{
            cl.first(cardPanel);
        });
        cad.addActionListener(e->{
            cl.last(cardPanel);
        });
    }
}

