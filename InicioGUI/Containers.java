package InicioGUI;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Containers extends JFrame{
    public Containers() {
        super("Exemplo Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 400, 400);
        // Determinando layout da janela
       /* FlowLayout flow = new FlowLayout();
        this.setLayout(flow); */
        //Utilizando um novo Container
        JPanel Painel = new JPanel();
        this.getContentPane().add(Painel);
        for (int i = 0; i < 6; i++) {
        Painel.add(new JButton("Numero "+i));
    }
    this.setVisible(true);
}   
}