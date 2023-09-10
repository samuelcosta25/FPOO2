import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculadora1 extends JPanel implements ActionListener {

    private JTextField visorOperacao, visorResultado;
    private JButton[] botoes = new JButton[16];
    private String[] labels = {
        "7", "8", "9", "/",
        "4", "5", "6", "*",
        "1", "2", "3", "-",
        "0", "C", "=", "+"
    };

    private double num1, num2, resultado;
    private char operacao;
    private String operacaoAtual = "";

    public Calculadora1() {
        setLayout(new BorderLayout());

        visorOperacao = new JTextField("", 20);
        visorOperacao.setEditable(false);
        visorResultado = new JTextField("", 20);
        visorResultado.setColumns(20);

        add(visorOperacao, BorderLayout.NORTH);
        add(visorResultado, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < 16; i++) {
            botoes[i] = new JButton(labels[i]);
            botoes[i].addActionListener(this);
            painelBotoes.add(botoes[i]);
        }

        add(painelBotoes, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.matches("[0-9]")) {
            operacaoAtual += command;
            visorResultado.setText(operacaoAtual);
        } else if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/")) {
            if (!operacaoAtual.isEmpty()) {
                if (resultado != 0) {
                    num1 = resultado;
                } else {
                    num1 = Double.parseDouble(operacaoAtual);
                }
                operacao = command.charAt(0);
                operacaoAtual = "";
                visorOperacao.setText(num1 + " " + operacao);
                visorResultado.setText("");
            }
        } else if (command.equals("=")) {
            if (!operacaoAtual.isEmpty()) {
                num2 = Double.parseDouble(operacaoAtual);
                switch (operacao) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        resultado = num1 / num2;
                        break;
                }
                visorOperacao.setText(num1 + " " + operacao + " " + num2 + " =");
                visorResultado.setText("" + resultado);
                operacaoAtual = "";
            }
        } else if (command.equals("C")) {
            operacaoAtual = "";
            visorOperacao.setText("");
            visorResultado.setText("");
            num1 = num2 = resultado = 0;
            operacao = ' ';
        }

        if (!command.equals("=") && !command.equals("C") && !command.matches("[0-9]")) {
            if (resultado != 0) {
                num1 = resultado;
                operacaoAtual = "";
                visorOperacao.setText(num1 + " " + operacao);
                visorResultado.setText("");
                resultado = 0;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora1");
        Calculadora1 calculadora = new Calculadora1();
        frame.add(calculadora);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
