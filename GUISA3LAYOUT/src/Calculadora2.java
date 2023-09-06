import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculadora2 extends JPanel {

    private JPanel panel;
    private JTextField quantidadeTextField;
    private JComboBox<String> entradaComboBox;
    private JComboBox<String> saidaComboBox;
    private JButton converterButton;
    private JLabel resultadoLabel;

    public Calculadora2() {
        
        super();
        this.add(new JLabel("Calculadora de Moedas"));
     
    private void converter() {
        double quantidade = Double.parseDouble(quantidadeTextField.getText());
        int unidadeEntrada = entradaComboBox.getSelectedIndex() + 1; // Adicionando 1 pois os índices começam em 0
        int unidadeSaida = saidaComboBox.getSelectedIndex() + 1;

        double resultado = converterParaBytes(quantidade, unidadeEntrada);
        double resultadoFinal = converterDeBytes(resultado, unidadeSaida);

        resultadoLabel.setText("Resultado: " + resultadoFinal + " " + getUnidadeNome(unidadeSaida));
    }

    private double converterParaBytes(double quantidade, int unidadeEntrada) {
        switch (unidadeEntrada) {
            case 1: return quantidade / 8;
            case 2: return quantidade;
            case 3: return quantidade * 1024;
            case 4: return quantidade * 1024 * 1024;
            case 5: return quantidade * 1024 * 1024 * 1024;
            case 6: return quantidade * 1024 * 1024 * 1024 * 1024;
            default: return 0;
        }
    }

    private double converterDeBytes(double quantidadeEmBytes, int unidadeSaida) {
        switch (unidadeSaida) {
            case 1: return quantidadeEmBytes * 8;
            case 2: return quantidadeEmBytes;
            case 3: return quantidadeEmBytes / 1024;
            case 4: return quantidadeEmBytes / (1024 * 1024);
            case 5: return quantidadeEmBytes / (1024 * 1024 * 1024);
            case 6: return quantidadeEmBytes / (1024 * 1024 * 1024 * 1024);
            default: return 0;
        }
    }

    private String getUnidadeNome(int unidade) {
        switch (unidade) {
            case 1: return "Bits";
            case 2: return "Bytes";
            case 3: return "Kilobytes";
            case 4: return "Megabytes";
            case 5: return "Gigabytes";
            case 6: return "Terabytes";
            default: return "Desconhecido";
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Unidades de Memória");
        frame.setContentPane(new ConversorMemoriaGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

    }

