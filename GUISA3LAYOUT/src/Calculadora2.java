import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 extends JPanel implements ActionListener {

    private JTextField eurTextField, usdTextField, gbpTextField, btcTextField, brlTextField;

    public Calculadora2() {
        // Layout
        setLayout(new GridLayout(7, 2));

        // Rótulos
        JLabel eurLabel = new JLabel("Euro (EUR):");
        JLabel usdLabel = new JLabel("Dólar (USD):");
        JLabel gbpLabel = new JLabel("Libra (GBP):");
        JLabel btcLabel = new JLabel("Bitcoin (BTC):");
        JLabel brlLabel = new JLabel("Real (BRL):");

        // Campos de texto
        eurTextField = new JTextField();
        usdTextField = new JTextField();
        gbpTextField = new JTextField();
        btcTextField = new JTextField();
        brlTextField = new JTextField();

        // Botão de conversão
        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterMoedas();
            }
        });

        // Botão de limpar
        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eurTextField.setText("");
                usdTextField.setText("");
                gbpTextField.setText("");
                btcTextField.setText("");
                brlTextField.setText("");
            }
        });

        // Adiciona os componentes ao painel
        add(eurLabel);
        add(eurTextField);
        add(usdLabel);
        add(usdTextField);
        add(gbpLabel);
        add(gbpTextField);
        add(btcLabel);
        add(btcTextField);
        add(brlLabel);
        add(brlTextField);
        add(converterButton); // Adiciona o botão de conversão
        add(limparButton); // Adiciona o botão de limpar

        // Adiciona um ActionListener aos campos de texto
        eurTextField.addActionListener(this);
        usdTextField.addActionListener(this);
        gbpTextField.addActionListener(this);
        btcTextField.addActionListener(this);
        brlTextField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        converterMoedas();
    }

    private void converterMoedas() {
        try {
            if (!eurTextField.getText().isEmpty()) {
                double eurValue = Double.parseDouble(eurTextField.getText());
                usdTextField.setText(String.format("%.2f", eurValue * 1.18));
                gbpTextField.setText(String.format("%.2f", eurValue * 0.85));
                btcTextField.setText(String.format("%.6f", eurValue * 0.000023));
                brlTextField.setText(String.format("%.2f", eurValue * 6.26));
            } else if (!usdTextField.getText().isEmpty()) {
                double usdValue = Double.parseDouble(usdTextField.getText());
                eurTextField.setText(String.format("%.2f", usdValue / 1.18));
                gbpTextField.setText(String.format("%.2f", usdValue * 0.72));
                btcTextField.setText(String.format("%.6f", usdValue * 0.000020));
                brlTextField.setText(String.format("%.2f", usdValue * 5.29));
            } else if (!gbpTextField.getText().isEmpty()) {
                double gbpValue = Double.parseDouble(gbpTextField.getText());
                eurTextField.setText(String.format("%.2f", gbpValue / 0.85));
                usdTextField.setText(String.format("%.2f", gbpValue / 0.72));
                btcTextField.setText(String.format("%.6f", gbpValue * 0.000025));
                brlTextField.setText(String.format("%.2f", gbpValue * 7.38));
            } else if (!btcTextField.getText().isEmpty()) {
                double btcValue = Double.parseDouble(btcTextField.getText());
                eurTextField.setText(String.format("%.2f", btcValue * 43130.43));
                usdTextField.setText(String.format("%.2f", btcValue * 48400.00));
                gbpTextField.setText(String.format("%.2f", btcValue * 40000.00));
                brlTextField.setText(String.format("%.2f", btcValue * 158000.00));
            } else if (!brlTextField.getText().isEmpty()) {
                double brlValue = Double.parseDouble(brlTextField.getText());
                eurTextField.setText(String.format("%.2f", brlValue / 6.26));
                usdTextField.setText(String.format("%.2f", brlValue / 5.29));
                gbpTextField.setText(String.format("%.2f", brlValue / 7.38));
                btcTextField.setText(String.format("%.10f", brlValue * 0.0000063291));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Moedas");
        Calculadora2 calculadora = new Calculadora2();
        frame.add(calculadora);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
