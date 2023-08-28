import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutExemplo {
    public BorderLayoutExemplo() {
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        //mudando o Layout para BorderLayout do Frame
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        janelaP.add(new JButton("West"),BorderLayout.WEST);
        janelaP.add(new JButton("East"),BorderLayout.EAST);
        janelaP.add(new JButton("Center"),BorderLayout.CENTER);
        janelaP.add(new JButton("North"),BorderLayout.NORTH);
        janelaP.add(new JButton("South"),BorderLayout.SOUTH);
        //setar os elementos da janela
        janelaP.setDefaultCloseOperation(1);
        janelaP.setVisible(true);
        janelaP.pack();
    }
}
