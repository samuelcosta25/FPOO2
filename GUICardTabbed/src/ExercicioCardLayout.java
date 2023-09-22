import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;

public class ExercicioCardLayout extends JFrame{
    //construtor
    public ExercicioCardLayout() {
        super("Exercicio CardLayout");
        JPanel painel1 = new JPanel();//principal
        //elemento de seleção dos Cards JComboBox
        String itensCB[] = {"Card 1","Card 2", "Card 3"}; 
        JButton change = new JButton("Trocar de card");
        painel1.add(change);
        //criar os cards
        JPanel cards = new JPanel();//card principal - vai permitir a navegação
        CardLayout cl = new CardLayout();
        cards.setLayout(cl);
        //criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new JButton("Botão 1"));
        card1.add(new JButton("Botão 2"));
        card1.add(new JButton("Botão 3"));
        JPanel card2 = new JPanel();
        card2.add(new JTextField("Card2 com Jtext", 20));
        JPanel card3 = new JPanel();
        card3.add(new JButton("Botao 4"));
        card3.add(new JTextField("Card3 com JtextField", 20));
        //add cards a pilha
        cards.add(card1,itensCB[0]);
        cards.add(card2,itensCB[1]);
        cards.add(card3,itensCB[2]);
        painel1.add(cards);
        this.add(painel1);
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        //criar a ação para o botao
        change.addActionListener(e->{
            cl.next(cards);
        });

}
}
