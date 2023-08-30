import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        int acao = Integer.parseInt(JOptionPane.showInputDialog("Digite qual exemplo deseja executar: \n 1-Flow Layout \n 2-Grid Layout \n 3-BorderLayout \n 4-BoxLayout "));
        switch (acao) {
            case 1:
                new ExemploFlowLayout();
                break;
            case 2:
                new ExemploGridLayout();
                break;
            case 3:
                new BorderLayoutExemplo();
                break;
            case 4:
                new BoxLayoutExemplo();
            break;
            default:
                break;
        }
    }
}
