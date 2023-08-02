package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean loop=true;
        while (loop) {
        String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
        try {
            if (senhaDigitada.length()!=6) {
                throw new Exception("Senha inválida");
            }
            loop=false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        } //catch
    }//while
    }//main
}//class
