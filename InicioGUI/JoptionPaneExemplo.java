package InicioGUI;

import javax.swing.JOptionPane;

public class JoptionPaneExemplo extends JOptionPane {
    public JoptionPaneExemplo() {
        super();
        String info="Minha Janela Dialog";
        this.showMessageDialog(getComponentPopupMenu(), info, info, JOptionPane.INFORMATION_MESSAGE);
    }
}
