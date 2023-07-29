package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Animal;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.OutrosAnimais;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        //cria o cadastro
       Gato gatos[]=new Gato[10];
       Cachorro cachorros[]=new Cachorro[10];
       OutrosAnimais outros[]=new OutrosAnimais[10]; 
       int contGatos=0, contCachorros=0, contOutros=0;

       //criar aplicaçao
       JOptionPane.showMessageDialog(null, "Bem vindo ao consultorio\n do Dr Hans Chucrutes");
       boolean aberto = true;
       while (aberto) {
        int acao1=Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consulta\n 3-Sair"));
        if(acao1==1){//cadastro
            int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if(acao2==1){
                //criar um objeto
                gatos[contGatos] = new Gato();
                //setar os valores do cadastro
                gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                gatos[contGatos].setraca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                gatos[contGatos].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                gatos[contGatos].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                contGatos+=1;
                }else if(acao2==2){
                cachorros[contCachorros] = new Cachorro();
                cachorros[contCachorros].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                cachorros[contCachorros].setraca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                cachorros[contCachorros].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                cachorros[contCachorros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                contCachorros+=1;
                }else if(acao2==3){
                outros[contOutros] = new OutrosAnimais();
                outros[contOutros].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                outros[contOutros].setraca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                outros[contOutros].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                outros[contOutros].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                contOutros+=1;
                } else { 
                JOptionPane.showMessageDialog(null, "Opção Inválida");
                }
            } else if(acao1==2){

            }
        
        }
    }
}