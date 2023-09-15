import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 extends JPanel implements ActionListener {

    private JTextField eurTextField, usdTextField, gbpTextField, btcTextField, brlTextField;

    public Calculadora2() {
        // Layout do painel principal (FlowLayout)
        setLayout(new FlowLayout());

        // Painel interno com GridLayout
        JPanel gridPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // Adicionando espaçamento entre os componentes

        // Adicionando os rótulos e campos de texto no painel interno (GridLayout)
        adicionarComponente(gridPanel, "Euro (EUR):", eurTextField = new JTextField());
        adicionarComponente(gridPanel, "Dólar (USD):", usdTextField = new JTextField());
        adicionarComponente(gridPanel, "Libra (GBP):", gbpTextField = new JTextField());
        adicionarComponente(gridPanel, "Bitcoin (BTC):", btcTextField = new JTextField());
        adicionarComponente(gridPanel, "Real (BRL):", brlTextField = new JTextField());

        // Adiciona o painel interno (GridLayout) ao painel principal (FlowLayout)
        add(gridPanel);

        // Botão de limpar
        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(e -> {
            eurTextField.setText("");
            usdTextField.setText("");
            gbpTextField.setText("");
            btcTextField.setText("");
            brlTextField.setText("");
        });

        // Adiciona o botão de limpar ao painel principal (FlowLayout)
        add(limparButton);

        // Botão de conversão
        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(e -> converterMoedas());

        // Adiciona o botão de conversão ao painel principal (FlowLayout)
        add(converterButton);
    }

    private void adicionarComponente(JPanel panel, String label, JComponent componente) {
        JLabel rotulo = new JLabel(label);
        panel.add(rotulo);
        panel.add(componente);
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

  
}
