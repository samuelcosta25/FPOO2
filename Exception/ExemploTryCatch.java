package Exception;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ExemploTryCatch {
    public static void main(String[] args) {
        boolean rodando = true;
        String calc[]={"soma","subtracao", "multiplicacao", "divisao", "sair"}
        while (rodando) {
        try {
            int num1=Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro"));
            int num2=Integer.parseInt(JOptionPane.showInputDialog("Digite outro Nº Inteiro"));
            int op=JOptionPane.showOptionDialog(null,"Escolha operacao:","calculadora", JOptionPane.CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, JOptionPane.CANCEL_OPTION, null, calc, calc[0]);
            int result=0;
            if (op==1){
                result = num1+num2;
                JOptionPane.showMessageDialog(null,"Resultado:\n"+result);
                rodando=false;
            } else if (op==2){
                result=num1-num2;
                JOptionPane.showMessageDialog(null,"Resultado:\n"+result);
                rodando=false;
            } else if (op==3){
                result=num1*num2;
                JOptionPane.showMessageDialog(null,"Resultado:\n"+result);
                rodando=false;
            } else if(op==4){
                result=num1/num2;
                JOptionPane.showMessageDialog(null,"Resultado:\n"+result);
                rodando=false;
            } else {
                rodando=false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERRO - Valor digitado nao e um numero inteiro!");
        }
    }
    }
}