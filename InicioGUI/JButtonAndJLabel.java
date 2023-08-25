package InicioGUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JButtonAndJLabel { // sem extends
    //atributos
    int contador=0;
    public JButtonAndJLabel() {
        //criar um JFrame
        JFrame janela = new JFrame("Janela Principal");
        JPanel painel = new JPanel(); //Container
        //adicionar o painel ao frame
        janela.getContentPane().add(painel);
        //criar componentes
        JButton botao = new JButton("Clique Aqui");
        JLabel text = new JLabel("Numero de cliques:");
        //add componentes ao painel
        painel.add(botao);
        painel.add(text);
        //config de janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();//organiza o tamanho da janela
        janela.setVisible(true);
        // action Listener
        botao.addActionListener(e ->{
            contador++;
            text.setText("N° de cliques: "+contador);
            JButton botao2 = new JButton(""+contador);
            painel.add(botao2);
            janela.pack();
        });
}
}
