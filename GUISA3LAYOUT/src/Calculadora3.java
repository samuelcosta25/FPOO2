import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora3 extends JPanel implements ActionListener {

    private JTextField bitTextField, byteTextField, kilobyteTextField, megabyteTextField, gigabyteTextField;

    public Calculadora3() {
        // Layout
        setLayout(new GridLayout(6, 2));

        // Rótulos
        JLabel bitLabel = new JLabel("Bits:");
        JLabel byteLabel = new JLabel("Bytes:");
        JLabel kilobyteLabel = new JLabel("Kilobytes:");
        JLabel megabyteLabel = new JLabel("Megabytes:");
        JLabel gigabyteLabel = new JLabel("Gigabytes:");

        // Campos de texto
        bitTextField = new JTextField();
        byteTextField = new JTextField();
        kilobyteTextField = new JTextField();
        megabyteTextField = new JTextField();
        gigabyteTextField = new JTextField();

        // Botão de conversão
        JButton converterButton = new JButton("Converter");
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterUnidades();
            }
        });

        // Botão de limpar
        JButton limparButton = new JButton("Limpar");
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bitTextField.setText("");
                byteTextField.setText("");
                kilobyteTextField.setText("");
                megabyteTextField.setText("");
                gigabyteTextField.setText("");
            }
        });

        // Adiciona os componentes ao painel
        add(bitLabel);
        add(bitTextField);
        add(byteLabel);
        add(byteTextField);
        add(kilobyteLabel);
        add(kilobyteTextField);
        add(megabyteLabel);
        add(megabyteTextField);
        add(gigabyteLabel);
        add(gigabyteTextField);
        add(converterButton);
        add(limparButton);

        // Adiciona um ActionListener aos campos de texto
        bitTextField.addActionListener(this);
        byteTextField.addActionListener(this);
        kilobyteTextField.addActionListener(this);
        megabyteTextField.addActionListener(this);
        gigabyteTextField.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        converterUnidades();
    }

    private void converterUnidades() {
        try {
            if (!bitTextField.getText().isEmpty()) {
                long bits = Long.parseLong(bitTextField.getText());
                byteTextField.setText(String.valueOf(bits / 8));
                kilobyteTextField.setText(String.valueOf(bits / (8 * 1024)));
                megabyteTextField.setText(String.valueOf(bits / (8 * 1024 * 1024)));
                gigabyteTextField.setText(String.valueOf(bits / (8 * 1024 * 1024 * 1024)));
            } else if (!byteTextField.getText().isEmpty()) {
                long bytes = Long.parseLong(byteTextField.getText());
                bitTextField.setText(String.valueOf(bytes * 8));
                kilobyteTextField.setText(String.valueOf(bytes / 1024));
                megabyteTextField.setText(String.valueOf(bytes / (1024 * 1024)));
                gigabyteTextField.setText(String.valueOf(bytes / (1024 * 1024 * 1024)));
            } else if (!kilobyteTextField.getText().isEmpty()) {
                long kilobytes = Long.parseLong(kilobyteTextField.getText());
                bitTextField.setText(String.valueOf(kilobytes * 8 * 1024));
                byteTextField.setText(String.valueOf(kilobytes * 1024));
                megabyteTextField.setText(String.valueOf(kilobytes / 1024));
                gigabyteTextField.setText(String.valueOf(kilobytes / (1024 * 1024)));
            } else if (!megabyteTextField.getText().isEmpty()) {
                long megabytes = Long.parseLong(megabyteTextField.getText());
                bitTextField.setText(String.valueOf(megabytes * 8 * 1024 * 1024));
                byteTextField.setText(String.valueOf(megabytes * 1024 * 1024));
                kilobyteTextField.setText(String.valueOf(megabytes * 1024));
                gigabyteTextField.setText(String.valueOf(megabytes / 1024));
            } else if (!gigabyteTextField.getText().isEmpty()) {
                long gigabytes = Long.parseLong(gigabyteTextField.getText());
                bitTextField.setText(String.valueOf(gigabytes * 8 * 1024 * 1024 * 1024));
                byteTextField.setText(String.valueOf(gigabytes * 1024 * 1024 * 1024));
                kilobyteTextField.setText(String.valueOf(gigabytes * 1024 * 1024));
                megabyteTextField.setText(String.valueOf(gigabytes * 1024));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um valor numérico.");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Conversor de Unidades de Memória");
        Calculadora3 calculadora = new Calculadora3();
        frame.add(calculadora);
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
