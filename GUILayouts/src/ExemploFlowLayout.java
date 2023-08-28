import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        //criar uma janela do tipo frame
        JFrame janela1 = new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        //criar alguns componentes
        janela1.add(new JLabel("N° de botões:"));
        JTextField campo = new JTextField("Insira um valor", 20);
        janela1.add(campo);
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        enviar.addActionListener(e ->{
            int a=1;
            int valor = Integer.parseInt(campo.getText());
            for (int i = 0; i < valor; i++) {
                janela1.add(new JButton(" "+i+a));
                janela1.pack();
            }
        });
        //setar os elementos da janela
        janela1.setDefaultCloseOperation(1);
        janela1.setVisible(true);
        janela1.pack();
    
    }
}
