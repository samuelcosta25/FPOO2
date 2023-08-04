package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean loop=true;
        while (loop) {
        String login = JOptionPane.showInputDialog("Informe um Login");
        String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
        String login = JOptionPane.showInputDialog("Informe um Login");
        try {
            if (senhaDigitada.equals(login)){
                throw new Exception("A senha não pode ser igual ao Login");
            }
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
